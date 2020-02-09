package com.cs3365.rpgdapi.weapons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/weapons")
public class WeaponsController {

    private WeaponsService weaponsService;

    @Autowired
    public WeaponsController(WeaponsService weaponsService) {
        this.weaponsService = weaponsService;
    }

    @PostMapping
    public ResponseEntity<String> post(@RequestBody Weapon requestBody) {
        try {
            requestBody.validate();
        } catch(WeaponsException e) {
            return ResponseEntity.badRequest()
                                 .body(e.getMessage());
        }

        UUID weaponId;
        String baseUrl = "";

        try {
            weaponId = weaponsService.createWeapon(requestBody);
        } catch(WeaponsException e) {
            return ResponseEntity.badRequest()
                                 .body(String.format(
                                         "There was an issue creating the weapon in the database: %s",
                                         e.getMessage()));
        }

        URI location = URI.create(String.format("%s/%s", baseUrl, weaponId.toString()));

        return ResponseEntity.created(location)
                             .body("");
    }
}

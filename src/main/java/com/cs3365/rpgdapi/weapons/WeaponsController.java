package com.cs3365.rpgdapi.weapons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

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
            weaponsService.createWeapon(requestBody);
        } catch(WeaponsException e) {
            return ResponseEntity.badRequest()
                                 .body(e.getMessage());
        }

        URI location = URI.create("https://localhost:8080/weapons/1234567");

        return ResponseEntity.created(location)
                             .body("");
    }
}

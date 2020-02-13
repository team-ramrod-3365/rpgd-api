package com.cs3365.rpgdapi.weapons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    
    @GetMapping("/{weaponID}")
    public ResponseEntity get(@PathVariable("weaponID") UUID identifier)
    {
        try {
            return new ResponseEntity<>(weaponsService.findWeapon(identifier), HttpStatus.OK);
        }
        catch(WeaponsException e) {
            return ResponseEntity.badRequest()
                                 .body(String.format(
                                         "Could not retrieve the weapon from the database: %s",
                                         e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> put(@RequestBody Weapon requestBody,
                                      @PathVariable UUID identity) throws WeaponsException {
        try {
            requestBody.validate();
        } catch(WeaponsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        WeaponEntity weapon = weaponsService.findWeapon(identity);
        if (weapon == null) {
            return ResponseEntity.notFound().build();
        }

        weapon.setName(requestBody.getName());
        weapon.setType(requestBody.getType());
        weapon.setDescription(requestBody.getDescription());
        weapon.setAttackPower(requestBody.getAttackPower());
        weapon.setAttackType(requestBody.getAttackType());
        weapon.setSpecialAbility(requestBody.getSpecialAbility());
        weapon.setWeight(requestBody.getWeight());

        try {
            weaponsService.updateWeapon(weapon);
        } catch(WeaponsException e) {
            return ResponseEntity.badRequest()
                    .body(String.format(
                            "There was an issue updating the weapon in the database: %s",
                            e.getMessage()));
        }

        return ResponseEntity.ok().body("");
    }


}

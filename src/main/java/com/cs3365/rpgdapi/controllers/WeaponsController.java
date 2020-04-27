package com.cs3365.rpgdapi.controllers;

import com.cs3365.rpgdapi.models.Weapon;
import com.cs3365.rpgdapi.models.WeaponEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

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
        } catch (WeaponsException e) {
            return ResponseEntity.badRequest()
                    .body(e.getMessage());
        }

        UUID weaponId;
        String baseUrl = "";

        try {
            weaponId = weaponsService.createWeapon(requestBody);
        } catch (WeaponsException e) {
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
    public ResponseEntity get(@PathVariable("weaponID") UUID identifier) {
        try {
            return new ResponseEntity<>(weaponsService.findWeapon(identifier), HttpStatus.OK);
        } catch (WeaponsException e) {
            return ResponseEntity.badRequest()
                    .body(String.format(
                            "Could not retrieve the weapon from the database: %s",
                            e.getMessage()));
        }
    }

    @PutMapping("/{weaponID}")
    public ResponseEntity put(@RequestBody Weapon requestBody,
                              @PathVariable("weaponID") UUID identifier) {

        try {
            requestBody.validate();
        } catch(WeaponsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        WeaponEntity updatedWeapon;

        try {
            updatedWeapon = weaponsService.updateWeapon(requestBody, identifier);
        } catch (WeaponsException e) {
            return ResponseEntity.badRequest()
                    .body(String.format(
                            "There was an issue updating the weapon in the database: %s",
                            e.getMessage()));
        }

        return new ResponseEntity<>(updatedWeapon, HttpStatus.OK);

    }

    @DeleteMapping("/{weaponID}")
    public ResponseEntity delete(@PathVariable("weaponID") UUID identifier)
    {
        try {
            weaponsService.removeWeapon(identifier);
        }
        catch (WeaponsException e) {
            return ResponseEntity.badRequest()
                                 .body(String.format(
                                         "Could not delete the weapon from the database: %s",
                                         e.getMessage()));
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

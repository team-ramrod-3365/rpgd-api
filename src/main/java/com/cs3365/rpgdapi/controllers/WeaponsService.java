package com.cs3365.rpgdapi.controllers;

import com.cs3365.rpgdapi.models.Weapon;
import com.cs3365.rpgdapi.models.WeaponEntity;

import java.util.List;
import java.util.UUID;

public interface WeaponsService {
    UUID createWeapon(Weapon requestBody) throws WeaponsException;
    WeaponEntity findWeapon(UUID identity) throws WeaponsException;
    WeaponEntity updateWeapon(Weapon weapon, UUID identifier) throws WeaponsException;
    void removeWeapon(UUID identity) throws WeaponsException;
    List<WeaponEntity> findWeapons() throws WeaponsException;
}

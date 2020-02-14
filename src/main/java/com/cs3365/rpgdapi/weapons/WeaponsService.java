package com.cs3365.rpgdapi.weapons;

import java.util.UUID;

public interface WeaponsService {
    UUID createWeapon(Weapon requestBody) throws WeaponsException;
    WeaponEntity findWeapon(UUID identity) throws WeaponsException;
    WeaponEntity updateWeapon(Weapon weapon, UUID identifier) throws WeaponsException;
    void removeWeapon(UUID identity) throws WeaponsException;
}

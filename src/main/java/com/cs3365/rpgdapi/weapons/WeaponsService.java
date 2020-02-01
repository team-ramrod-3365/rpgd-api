package com.cs3365.rpgdapi.weapons;

import java.util.UUID;

public interface WeaponsService {
    UUID createWeapon(Weapon requestBody) throws WeaponsException;
}

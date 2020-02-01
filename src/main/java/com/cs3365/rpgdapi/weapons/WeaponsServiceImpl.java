package com.cs3365.rpgdapi.weapons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeaponsServiceImpl implements WeaponsService {

    private WeaponsRepository weaponsRepository;

    @Autowired
    public WeaponsServiceImpl(WeaponsRepository weaponsRepository) {
        this.weaponsRepository = weaponsRepository;
    }

    @Override
    public void createWeapon(Weapon requestBody) throws WeaponsException {
        WeaponEntity weapon = new WeaponEntity();

        weaponsRepository.save(weapon);
    }
}

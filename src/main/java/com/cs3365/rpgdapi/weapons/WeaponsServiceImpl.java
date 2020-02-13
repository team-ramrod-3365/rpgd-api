package com.cs3365.rpgdapi.weapons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class WeaponsServiceImpl implements WeaponsService {

    private WeaponsRepository weaponsRepository;

    @Autowired
    public WeaponsServiceImpl(WeaponsRepository weaponsRepository) {
        this.weaponsRepository = weaponsRepository;
    }

    @Override
    public UUID createWeapon(Weapon requestBody) throws WeaponsException {
        WeaponEntity weapon = new WeaponEntity(requestBody);
        WeaponEntity createdWeapon;

        try {
            createdWeapon = weaponsRepository.save(weapon);
        } catch(Exception e) {
            throw new WeaponsException(e.getMessage(), e.getCause());
        }

        return createdWeapon.getId();
    }
    
    @Override
    public WeaponEntity findWeapon(UUID identity) throws WeaponsException
    {
        try {
            return weaponsRepository.findById(identity).get();
        } catch(Exception e) {
            throw new WeaponsException(e.getMessage(), e.getCause());
        }
    }
}

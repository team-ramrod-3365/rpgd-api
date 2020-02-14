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

    @Override
    public WeaponEntity updateWeapon(Weapon weapon, UUID identifier) throws WeaponsException {

        WeaponEntity weaponEntity;

        try {
            weaponEntity = weaponsRepository.findById(identifier).get();
        } catch(Exception e) {
            throw new WeaponsException(e.getMessage(), e.getCause());
        }

        if (weaponEntity == null){
            return null;
        }

        weaponEntity.setName(weapon.getName());
        weaponEntity.setType(weapon.getType());
        weaponEntity.setDescription(weapon.getDescription());
        weaponEntity.setAttackPower(weapon.getAttackPower());
        weaponEntity.setAttackType(weapon.getAttackType());
        weaponEntity.setSpecialAbility(weapon.getSpecialAbility());
        weaponEntity.setWeight(weapon.getWeight());

        WeaponEntity updatedWeapon;

        try {
            updatedWeapon = weaponsRepository.save(weaponEntity);
        } catch(Exception e) {
            throw new WeaponsException(e.getMessage(), e.getCause());
        }

        return updatedWeapon;
    }

}


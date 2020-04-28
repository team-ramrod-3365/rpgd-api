package com.cs3365.rpgdapi.controllers;

import com.cs3365.rpgdapi.models.Weapon;
import com.cs3365.rpgdapi.models.WeaponEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
        WeaponEntity weapon = new WeaponEntity.WeaponEntityBuilder(requestBody.getName(), requestBody.getType())
                .description(requestBody.getDescription())
                .attackPower(requestBody.getAttackPower())
                .attackType(requestBody.getAttackType())
                .specialAbility(requestBody.getSpecialAbility())
                .weight(requestBody.getWeight())
                .build();

        WeaponEntity createdWeapon;

        try {
            createdWeapon = weaponsRepository.save(weapon);
        } catch(Exception e) {
            throw new WeaponsException(e.getMessage(), e.getCause());
        }

        return createdWeapon.getId();
    }
    
    @Override
    public WeaponEntity findWeapon(UUID identity) throws WeaponsException {
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

        weaponEntity = new WeaponEntity.WeaponEntityBuilder(weapon.getName(), weapon.getType())
                                       .description(weapon.getDescription())
                                       .attackPower(weapon.getAttackPower())
                                       .attackType(weapon.getAttackType())
                                       .specialAbility(weapon.getSpecialAbility())
                                       .weight(weapon.getWeight())
                                       .build();

        WeaponEntity updatedWeapon;

        try {
            updatedWeapon = weaponsRepository.save(weaponEntity);
        } catch(Exception e) {
            throw new WeaponsException(e.getMessage(), e.getCause());
        }

        return updatedWeapon;
    }

    @Override
    public void removeWeapon(UUID identity) throws WeaponsException {
        try {
            weaponsRepository.deleteById(identity);
        } catch(Exception e) {
            throw new WeaponsException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public List<WeaponEntity> findWeapons() throws WeaponsException {
        List<WeaponEntity> weapons = new ArrayList<>();

        try {
            weaponsRepository.findAll().forEach(weapons::add);
        } catch(Exception e) {
            throw new WeaponsException(e.getMessage(), e.getCause());
        }

        return weapons;
    }
}


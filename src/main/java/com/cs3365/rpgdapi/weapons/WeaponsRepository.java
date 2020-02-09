package com.cs3365.rpgdapi.weapons;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface WeaponsRepository extends CrudRepository<WeaponEntity, UUID> {

    @Override
    <S extends WeaponEntity> S save(S entity);
}

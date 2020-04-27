package com.cs3365.rpgdapi.controllers;

import com.cs3365.rpgdapi.models.Weapon;
import com.cs3365.rpgdapi.models.WeaponEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.UUID;

@SpringBootTest
public class WeaponsServiceImplTests {

    @Autowired
    private WeaponsService weaponsService;

    @MockBean
    private WeaponsRepository mockWeaponsRepository;

    @Test
    public void shouldSucceed() throws Exception {
        // Given
        Weapon weapon = new Weapon.WeaponBuilder("Test Weapon", "sword").build();
        WeaponEntity weaponEntity = new WeaponEntity(weapon);
        Mockito.when(mockWeaponsRepository.save(Mockito.any())).thenReturn(weaponEntity);

        // When
        UUID newWeaponId = weaponsService.createWeapon(weapon);

        // Then
        Assertions.assertEquals(newWeaponId, weaponEntity.getId());
    }
}

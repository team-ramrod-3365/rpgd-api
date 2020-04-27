package com.cs3365.rpgdapi.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "weapons")
public class WeaponEntity {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private String type;
    private String description;
    private Double attackPower;
    private String attackType;
    private String specialAbility;
    private Double weight;

    public WeaponEntity() {}

    public WeaponEntity(Weapon weapon) {
        this.name = weapon.getName();
        this.type = weapon.getType();
        this.description = weapon.getDescription();
        this.attackPower = weapon.getAttackPower();
        this.attackType = weapon.getAttackType();
        this.specialAbility = weapon.getSpecialAbility();
        this.weight = weapon.getWeight();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(Double attackPower) {
        this.attackPower = attackPower;
    }

    public String getAttackType() {
        return attackType;
    }

    public void setAttackType(String attackType) {
        this.attackType = attackType;
    }

    public String getSpecialAbility() {
        return specialAbility;
    }

    public void setSpecialAbility(String specialAbility) {
        this.specialAbility = specialAbility;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
}

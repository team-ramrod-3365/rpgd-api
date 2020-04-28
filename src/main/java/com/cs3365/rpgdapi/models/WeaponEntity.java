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

    private WeaponEntity(WeaponEntityBuilder builder) {
        this.name = builder.name;
        this.type = builder.type;
        this.description = builder.description;
        this.attackPower = builder.attackPower;
        this.attackType = builder.attackType;
        this.specialAbility = builder.specialAbility;
        this.weight = builder.weight;
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

    public static class WeaponEntityBuilder {

        private String name;
        private String type;
        private String description;
        private Double attackPower;
        private String attackType;
        private String specialAbility;
        private Double weight;

        public WeaponEntityBuilder(String name, String type) {
            this.name = name;
            this.type = type;
        }

        public WeaponEntityBuilder description(String description) {
            this.description = description;
            return this;
        }

        public WeaponEntityBuilder attackPower(Double attackPower) {
            this.attackPower = attackPower;
            return this;
        }

        public WeaponEntityBuilder attackType(String attackType) {
            this.attackType = attackType;
            return this;
        }

        public WeaponEntityBuilder specialAbility(String specialAbility) {
            this.specialAbility = specialAbility;
            return this;
        }

        public WeaponEntityBuilder weight(Double weight) {
            this.weight = weight;
            return this;
        }

        public WeaponEntity build() {
            return new WeaponEntity(this);
        }
    }
}

package com.cs3365.rpgdapi.models;

import com.cs3365.rpgdapi.controllers.WeaponsException;

public class Weapon {

    private final String name;
    private final String type;
    private final String description;
    private final Double attackPower;
    private final String attackType;
    private final String specialAbility;
    private final Double weight;

    public Weapon(String name, String type, String description, Double attackPower,
                  String attackType, String specialAbility, Double weight) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.attackPower = attackPower;
        this.attackType = attackType;
        this.specialAbility = specialAbility;
        this.weight = weight;
    }

    private Weapon(WeaponBuilder builder) {
        this.name = builder.name;
        this.type = builder.type;
        this.description = builder.description;
        this.attackPower = builder.attackPower;
        this.attackType = builder.attackType;
        this.specialAbility = builder.specialAbility;
        this.weight = builder.weight;
    }

    public void validate() throws WeaponsException {
        validateName();
        validateType();
        validateAttackPower();
        validateWeight();
    }

    private void validateName() throws WeaponsException {
        if(this.name == null) {
            throw new WeaponsException("The name attribute is a required field when creating a weapon.");
        }
    }

    private void validateType() throws WeaponsException {
        if(this.type == null) {
            throw new WeaponsException("The type attribute is a required field when creating a weapon.");
        }
    }

    private void validateAttackPower() throws WeaponsException {
        if(this.attackPower != null && this.attackPower < 0.0) {
            throw new WeaponsException("The attackPower attribute must be greater than or equal to 0.0.");
        }
    }

    private void validateWeight() throws WeaponsException {
        if(this.weight != null && this.weight < 0.0) {
            throw new WeaponsException("The weight attribute must be greater than or equal to 0.0.");
        }
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public Double getAttackPower() {
        return attackPower;
    }

    public String getAttackType() {
        return attackType;
    }

    public String getSpecialAbility() {
        return specialAbility;
    }

    public Double getWeight() {
        return weight;
    }

    public static class WeaponBuilder {

        private String name;
        private String type;
        private String description;
        private Double attackPower;
        private String attackType;
        private String specialAbility;
        private Double weight;

        public WeaponBuilder(String name, String type) {
            this.name = name;
            this.type = type;
        }

        public WeaponBuilder description(String description) {
            this.description = description;
            return this;
        }

        public WeaponBuilder attackPower(Double attackPower) {
            this.attackPower = attackPower;
            return this;
        }

        public WeaponBuilder attackType(String attackType) {
            this.attackType = attackType;
            return this;
        }

        public WeaponBuilder specialAbility(String specialAbility) {
            this.specialAbility = specialAbility;
            return this;
        }

        public WeaponBuilder weight(Double weight) {
            this.weight = weight;
            return this;
        }

        public Weapon build() {
            return new Weapon(this);
        }
    }
}

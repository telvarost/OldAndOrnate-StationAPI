package com.github.telvarost.oldandornate.enums;

public enum StarFlowerGenerationEnum {
    NO_BIOMES("No Biomes"),
    SPECIFIC_BIOMES("Specific Biomes"),
    ALL_BIOMES("All Biomes");

    final String stringValue;

    StarFlowerGenerationEnum() {
        this.stringValue = "Specific Biomes";
    }

    StarFlowerGenerationEnum(String stringValue) {
        this.stringValue = stringValue;
    }

    @Override
    public String toString() {
        return stringValue;
    }
}
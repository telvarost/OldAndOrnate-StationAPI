package com.github.telvarost.oldandornate.enums;

public enum AdobeBrickRecipeEnum {
    NO_RECIPE("No Recipe"),
    OLD_RECIPE("Old: Craft 4 Adobe In A Square"),
    NEW_RECIPE("New: Smelt 1 Adobe");

    final String stringValue;

    AdobeBrickRecipeEnum() {
        this.stringValue = "New: Smelt 1 Adobe";
    }

    AdobeBrickRecipeEnum(String stringValue) {
        this.stringValue = stringValue;
    }

    @Override
    public String toString() {
        return stringValue;
    }
}
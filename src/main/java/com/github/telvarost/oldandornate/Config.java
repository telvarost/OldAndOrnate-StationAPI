package com.github.telvarost.oldandornate;

import net.glasslauncher.mods.gcapi3.api.*;

public class Config {

    @ConfigRoot(value = "config", visibleName = "OldAndOrnate")
    public static ConfigFields config = new ConfigFields();

    public static class ConfigFields {
        @ConfigCategory(
                name = "Adobe Config",
                description = "Restart required for changes to take effect"
        )
        public AdobeConfig ADOBE_CONFIG = new AdobeConfig();

        @ConfigCategory(
                name = "Star Flower Config",
                description = "Restart required for changes to take effect"
        )
        public StarFlowerConfig STAR_FLOWER_CONFIG = new StarFlowerConfig();
    }

    public static class AdobeConfig {
        @ConfigEntry(
                name = "Adobe Crafting Recipe",
                multiplayerSynced = true
        )
        public AdobeRecipeEnum adobeCraftingRecipe = AdobeRecipeEnum.NEW_RECIPE;

        @ConfigEntry(
                name = "Adobe Brick Recipe",
                multiplayerSynced = true
        )
        public AdobeBrickRecipeEnum adobeBrickRecipe = AdobeBrickRecipeEnum.NEW_RECIPE;

        @ConfigEntry(
                name = "Enable Adobe Bricks Recipe",
                description = "Craft 4 adobe brick in a square",
                multiplayerSynced = true
        )
        public Boolean enableAdobeBricksRecipe = true;

        @ConfigEntry(
                name = "Enable Adobe Terrain Generation",
                description = "Generates adobe lakebeds in savannas",
                multiplayerSynced = true
        )
        public Boolean enableAdobeTerrainGeneration = true;

        @ConfigEntry(
                name = "Use Tweaked Adobe Mining Speeds",
                description = "Adobe mines slower, adobe bricks mine faster",
                multiplayerSynced = true
        )
        public Boolean useTweakedAdobeMiningSpeeds = true;
    }

    public static class StarFlowerConfig {
        @ConfigEntry(
                name = "Enable Star Flower Crafting Recipe",
                description = "Craft 1 glowstone dust with 1 dandelion",
                multiplayerSynced = true
        )
        public Boolean enableStarFlowerCraftingRecipe = true;

        @ConfigEntry(
                name = "Enable Star Flower Dye Recipe",
                description = "Craft 1 star flower into 2 lime dye",
                multiplayerSynced = true
        )
        public Boolean enableStarFlowerDyeRecipe = true;

        @ConfigEntry(
                name = "Star Flower Terrain Generation",
                description = "Which biomes allow star flowers to generate",
                multiplayerSynced = true
        )
        public StarFlowerGenerationEnum starFlowerTerrainGeneration = StarFlowerGenerationEnum.SPECIFIC_BIOMES;
    }
}

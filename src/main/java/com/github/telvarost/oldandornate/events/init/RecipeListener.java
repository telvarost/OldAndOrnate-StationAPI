package com.github.telvarost.oldandornate.events.init;

import com.github.telvarost.oldandornate.AdobeBrickRecipeEnum;
import com.github.telvarost.oldandornate.AdobeRecipeEnum;
import com.github.telvarost.oldandornate.Config;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.modificationstation.stationapi.api.event.recipe.RecipeRegisterEvent;
import net.modificationstation.stationapi.api.recipe.CraftingRegistry;
import net.modificationstation.stationapi.api.recipe.SmeltingRegistry;
import net.modificationstation.stationapi.api.util.Identifier;

import static com.github.telvarost.oldandornate.events.init.BlockListener.*;
import static com.github.telvarost.oldandornate.events.init.ItemListener.ADOBE_BRICK;

public class RecipeListener {

    @EventListener
    public void registerRecipes(RecipeRegisterEvent event) {
        Identifier type = event.recipeId;

        if (type == RecipeRegisterEvent.Vanilla.CRAFTING_SHAPED.type()) {
            if (Config.config.ADOBE_CONFIG.enableAdobeBricksRecipe) {
                CraftingRegistry.addShapedRecipe(new ItemStack(ADOBE_BRICKS.asItem(), 1), "XX", "XX", 'X', ADOBE_BRICK);
            }

            if (AdobeBrickRecipeEnum.OLD_RECIPE == Config.config.ADOBE_CONFIG.adobeBrickRecipe) {
                CraftingRegistry.addShapedRecipe(new ItemStack(ADOBE_BRICK.asItem(), 4), "XX", "XX", 'X', ADOBE);
            }
        }

        if (type == RecipeRegisterEvent.Vanilla.SMELTING.type()) {
            if (AdobeBrickRecipeEnum.NEW_RECIPE == Config.config.ADOBE_CONFIG.adobeBrickRecipe) {
                SmeltingRegistry.addSmeltingRecipe(new ItemStack(ADOBE.asItem(), 1), new ItemStack(ADOBE_BRICK, 1));
            }
        }

        if (type == RecipeRegisterEvent.Vanilla.CRAFTING_SHAPELESS.type()) {
            if (AdobeRecipeEnum.OLD_RECIPE == Config.config.ADOBE_CONFIG.adobeCraftingRecipe) {
                CraftingRegistry.addShapelessRecipe(new ItemStack(ADOBE.asItem(), 1), Block.DIRT);
            } else if (AdobeRecipeEnum.NEW_RECIPE == Config.config.ADOBE_CONFIG.adobeCraftingRecipe) {
                CraftingRegistry.addShapelessRecipe(new ItemStack(ADOBE.asItem(), 2), Block.DIRT, Block.SAND);
            } else if (AdobeRecipeEnum.REALISM_RECIPE == Config.config.ADOBE_CONFIG.adobeCraftingRecipe) {
                CraftingRegistry.addShapelessRecipe(new ItemStack(ADOBE.asItem(), 4), Block.DIRT, Block.SAND, Item.WHEAT, Item.WATER_BUCKET);

            }

            if (Config.config.STAR_FLOWER_CONFIG.enableStarFlowerCraftingRecipe) {
                CraftingRegistry.addShapelessRecipe(new ItemStack(STAR_FLOWER.asItem(), 1), Item.GLOWSTONE_DUST, Block.DANDELION);
            }

            if (Config.config.STAR_FLOWER_CONFIG.enableStarFlowerDyeRecipe) {
                CraftingRegistry.addShapelessRecipe(new ItemStack(Item.DYE, 2, 10), STAR_FLOWER.asItem());
            }
        }
    }
}
package com.github.telvarost.oldandornate.events.init;

import com.github.telvarost.oldandornate.ModHelper;
import com.github.telvarost.oldandornate.item.AdobeBrick;
import com.github.telvarost.oldandornate.item.LapisLazuliSword;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.modificationstation.stationapi.api.event.registry.ItemRegistryEvent;

public class ItemListener {
    public static Item[] items;

    public static Item ADOBE_BRICK;
    public static Item LAPIS_LAZULI_SWORD;

    @EventListener
    public void registerItems(ItemRegistryEvent event) {
        ADOBE_BRICK = new AdobeBrick(ModHelper.NAMESPACE.id("adobe_brick")).setTranslationKey(ModHelper.NAMESPACE, "adobe_brick");
        LAPIS_LAZULI_SWORD = new LapisLazuliSword(ModHelper.NAMESPACE.id("lapis_lazuli_sword"), ToolMaterial.WOOD).setTranslationKey(ModHelper.NAMESPACE, "lapis_lazuli_sword");

        items = new Item[]
        { ADOBE_BRICK
        , LAPIS_LAZULI_SWORD
        };
    }
}
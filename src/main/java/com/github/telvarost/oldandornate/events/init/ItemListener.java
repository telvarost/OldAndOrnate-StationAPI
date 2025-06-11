package com.github.telvarost.oldandornate.events.init;

import com.github.telvarost.oldandornate.ModHelper;
import com.github.telvarost.oldandornate.item.AdobeBrick;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.item.Item;
import net.modificationstation.stationapi.api.event.registry.ItemRegistryEvent;

public class ItemListener {
    public static Item[] items;
    public static Item ADOBE_BRICK;

    @EventListener
    public void registerItems(ItemRegistryEvent event) {
        ADOBE_BRICK = new AdobeBrick(ModHelper.NAMESPACE.id("adobe_brick")).setTranslationKey(ModHelper.NAMESPACE, "adobe_brick");

        items = new Item[]
        { ADOBE_BRICK
        };
    }
}
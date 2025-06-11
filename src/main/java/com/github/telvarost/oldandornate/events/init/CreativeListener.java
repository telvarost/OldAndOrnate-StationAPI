package com.github.telvarost.oldandornate.events.init;

import com.github.telvarost.oldandornate.ModHelper;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import paulevs.bhcreative.api.CreativeTab;
import paulevs.bhcreative.api.SimpleTab;
import paulevs.bhcreative.registry.TabRegistryEvent;

public class CreativeListener {
    public static CreativeTab tabOldAndOrnate;

    @EventListener
    public void onTabInit(TabRegistryEvent event){
        tabOldAndOrnate = new SimpleTab(ModHelper.NAMESPACE.id("adobe"), BlockListener.ADOBE.asItem());
        event.register(tabOldAndOrnate);

        for (Block block : BlockListener.blocks){
            tabOldAndOrnate.addItem(new ItemStack(block.asItem(), 1));
        }

        for (Item item : ItemListener.items){
            tabOldAndOrnate.addItem(new ItemStack(item, 1));
        }
    }
}
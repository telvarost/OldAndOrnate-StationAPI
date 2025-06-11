package com.github.telvarost.oldandornate.events.init;

import com.github.telvarost.oldandornate.Config;
import com.github.telvarost.oldandornate.ModHelper;
import com.github.telvarost.oldandornate.block.Adobe;
import com.github.telvarost.oldandornate.block.StarFlower;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.event.registry.BlockRegistryEvent;
import net.modificationstation.stationapi.api.util.Identifier;

import static net.minecraft.block.Block.*;

public class BlockListener {
    public static Block[] blocks;

    public static Block ADOBE;
    public static Block ADOBE_BRICKS;
    public static Block STAR_FLOWER;

    @EventListener
    public void registerBlocks(BlockRegistryEvent event) {
        float adobeHardnessAdjustment = 0.0F;

        if (Config.config.ADOBE_CONFIG.useTweakedAdobeMiningSpeeds) {
            adobeHardnessAdjustment = 0.25F;
        }

        ADOBE = new Adobe(Identifier.of(ModHelper.NAMESPACE, "adobe"), Material.SOLID_ORGANIC).setHardness(0.5F + adobeHardnessAdjustment).setSoundGroup(GRAVEL_SOUND_GROUP).setTranslationKey(ModHelper.NAMESPACE, "adobe");
        ADOBE_BRICKS = new Adobe(Identifier.of(ModHelper.NAMESPACE, "adobe_bricks"), Material.STONE).setHardness(1.5F - adobeHardnessAdjustment).setResistance(5.0F).setSoundGroup(STONE_SOUND_GROUP).setTranslationKey(ModHelper.NAMESPACE, "adobe_bricks");
        STAR_FLOWER = new StarFlower(Identifier.of(ModHelper.NAMESPACE, "star_flower"), 0).setLuminance(0.7F).setSoundGroup(DIRT_SOUND_GROUP).setTranslationKey(ModHelper.NAMESPACE, "star_flower");

        blocks = new Block[]
        { ADOBE
        , ADOBE_BRICKS
        , STAR_FLOWER
        };
    }
}

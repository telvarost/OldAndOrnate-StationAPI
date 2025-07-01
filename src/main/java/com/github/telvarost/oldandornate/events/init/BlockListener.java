package com.github.telvarost.oldandornate.events.init;

import com.github.telvarost.oldandornate.Config;
import com.github.telvarost.oldandornate.OldAndOrnate;
import com.github.telvarost.oldandornate.block.*;
import com.github.telvarost.oldandornate.blockentity.PlatformBlockEntity;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.event.block.entity.BlockEntityRegisterEvent;
import net.modificationstation.stationapi.api.event.registry.BlockRegistryEvent;
import net.modificationstation.stationapi.api.util.Identifier;

import static net.minecraft.block.Block.*;

public class BlockListener {
    public static Block[] blocks;

    public static Block ADOBE;
    public static Block ADOBE_BRICKS;
    public static Block DUNGEON_PLATFORM;
    public static Block FALTERING_PLATFORM;
    public static Block GHOST_PLATFORM;
    public static Block STAR_FLOWER;

    @EventListener
    public static void registerBlockEntities(BlockEntityRegisterEvent event) {
        event.register(PlatformBlockEntity.class, "oldandornate:platform");
    }

    @EventListener
    public void registerBlocks(BlockRegistryEvent event) {
        float adobeHardnessAdjustment = 0.0F;

        if (Config.config.ADOBE_CONFIG.useTweakedAdobeMiningSpeeds) {
            adobeHardnessAdjustment = 0.25F;
        }

        ADOBE              = new Adobe            (Identifier.of(OldAndOrnate.OLD_AND_ORNATE, "adobe")             , Material.SOLID_ORGANIC).setHardness(0.5F + adobeHardnessAdjustment).setSoundGroup(GRAVEL_SOUND_GROUP).setTranslationKey(OldAndOrnate.OLD_AND_ORNATE, "adobe");
        ADOBE_BRICKS       = new AdobeBricks      (Identifier.of(OldAndOrnate.OLD_AND_ORNATE, "adobe_bricks")      , Material.STONE).setHardness(1.5F - adobeHardnessAdjustment).setResistance(5.0F).setSoundGroup(STONE_SOUND_GROUP).setTranslationKey(OldAndOrnate.OLD_AND_ORNATE, "adobe_bricks");
        DUNGEON_PLATFORM   = new DungeonPlatform  (Identifier.of(OldAndOrnate.OLD_AND_ORNATE, "dungeon_platform")  , Material.STONE).setHardness(10.0F).setResistance(2000.0F).setSoundGroup(STONE_SOUND_GROUP).setTranslationKey(OldAndOrnate.OLD_AND_ORNATE, "dungeon_platform");
        FALTERING_PLATFORM = new FalteringPlatform(Identifier.of(OldAndOrnate.OLD_AND_ORNATE, "faltering_platform"), Material.STONE).setHardness(1.0F).setResistance(200.0F).setSoundGroup(STONE_SOUND_GROUP).setTranslationKey(OldAndOrnate.OLD_AND_ORNATE, "faltering_platform");
        GHOST_PLATFORM     = new GhostPlatform    (Identifier.of(OldAndOrnate.OLD_AND_ORNATE, "ghost_platform")    , Material.STONE).setHardness(0.1F).setResistance(20.0F).setSoundGroup(STONE_SOUND_GROUP).setTranslationKey(OldAndOrnate.OLD_AND_ORNATE, "ghost_platform");
        STAR_FLOWER        = new StarFlower       (Identifier.of(OldAndOrnate.OLD_AND_ORNATE, "star_flower"), OldAndOrnate.STAR_FLOWER_TEXTURE).setLuminance(0.7F).setSoundGroup(DIRT_SOUND_GROUP).setTranslationKey(OldAndOrnate.OLD_AND_ORNATE, "star_flower");

        blocks = new Block[]
        { ADOBE
        , ADOBE_BRICKS
        , DUNGEON_PLATFORM
        , FALTERING_PLATFORM
        , GHOST_PLATFORM
        , STAR_FLOWER
        };
    }
}

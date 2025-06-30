package com.github.telvarost.oldandornate.events.client;

import com.github.telvarost.oldandornate.OldAndOrnate;
import com.github.telvarost.oldandornate.events.init.ItemListener;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.client.event.texture.TextureRegisterEvent;
import net.modificationstation.stationapi.api.client.texture.atlas.Atlases;
import net.modificationstation.stationapi.api.util.Identifier;

public class TextureListener {

    @EventListener
    public void registerTextures(TextureRegisterEvent event) {
        OldAndOrnate.ADOBE_TEXTURE = Atlases.getTerrain().addTexture(Identifier.of(OldAndOrnate.OLD_AND_ORNATE, "block/adobe")).index;
        OldAndOrnate.ADOBE_BRICKS_TEXTURE = Atlases.getTerrain().addTexture(Identifier.of(OldAndOrnate.OLD_AND_ORNATE, "block/adobe_bricks")).index;
        OldAndOrnate.DUNGEON_PLATFORM_TEXTURE_TOP = Atlases.getTerrain().addTexture(Identifier.of(OldAndOrnate.OLD_AND_ORNATE, "block/dungeon_platform_top")).index;
        OldAndOrnate.DUNGEON_PLATFORM_TEXTURE_SIDE = Atlases.getTerrain().addTexture(Identifier.of(OldAndOrnate.OLD_AND_ORNATE, "block/dungeon_platform_side")).index;
        OldAndOrnate.DUNGEON_PLATFORM_TEXTURE_BOTTOM = Atlases.getTerrain().addTexture(Identifier.of(OldAndOrnate.OLD_AND_ORNATE, "block/dungeon_platform_bottom")).index;
        OldAndOrnate.FALTERING_PLATFORM_TEXTURE_TOP = Atlases.getTerrain().addTexture(Identifier.of(OldAndOrnate.OLD_AND_ORNATE, "block/faltering_platform_top")).index;
        OldAndOrnate.FALTERING_PLATFORM_TEXTURE_SIDE = Atlases.getTerrain().addTexture(Identifier.of(OldAndOrnate.OLD_AND_ORNATE, "block/faltering_platform_side")).index;
        OldAndOrnate.FALTERING_PLATFORM_TEXTURE_BOTTOM = Atlases.getTerrain().addTexture(Identifier.of(OldAndOrnate.OLD_AND_ORNATE, "block/faltering_platform_bottom")).index;
        OldAndOrnate.GHOST_PLATFORM_TEXTURE_TOP = Atlases.getTerrain().addTexture(Identifier.of(OldAndOrnate.OLD_AND_ORNATE, "block/ghost_platform_top")).index;
        OldAndOrnate.GHOST_PLATFORM_TEXTURE_SIDE = Atlases.getTerrain().addTexture(Identifier.of(OldAndOrnate.OLD_AND_ORNATE, "block/ghost_platform_side")).index;

        ItemListener.ADOBE_BRICK.setTexture(OldAndOrnate.OLD_AND_ORNATE.id("item/adobe_brick"));
        ItemListener.LAPIS_LAZULI_SWORD.setTexture(OldAndOrnate.OLD_AND_ORNATE.id("item/lapis_lazuli_sword"));
    }
}

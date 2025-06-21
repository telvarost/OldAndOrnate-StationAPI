package com.github.telvarost.oldandornate.events.client;

import com.github.telvarost.oldandornate.ModHelper;
import com.github.telvarost.oldandornate.OldAndOrnate;
import com.github.telvarost.oldandornate.events.init.ItemListener;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.client.event.texture.TextureRegisterEvent;
import net.modificationstation.stationapi.api.client.texture.atlas.Atlases;
import net.modificationstation.stationapi.api.util.Identifier;

public class TextureListener {

    @EventListener
    public void registerTextures(TextureRegisterEvent event) {
        OldAndOrnate.ADOBE_TEXTURE = Atlases.getTerrain().addTexture(Identifier.of(ModHelper.NAMESPACE, "block/adobe")).index;
        OldAndOrnate.ADOBE_BRICKS_TEXTURE = Atlases.getTerrain().addTexture(Identifier.of(ModHelper.NAMESPACE, "block/adobe_bricks")).index;
        OldAndOrnate.DUNGEON_PLATFORM_TEXTURE = Atlases.getTerrain().addTexture(Identifier.of(ModHelper.NAMESPACE, "block/dungeon_platform")).index;
        OldAndOrnate.FALTERING_PLATFORM_TEXTURE = Atlases.getTerrain().addTexture(Identifier.of(ModHelper.NAMESPACE, "block/faltering_platform")).index;
        OldAndOrnate.GHOST_PLATFORM_TEXTURE = Atlases.getTerrain().addTexture(Identifier.of(ModHelper.NAMESPACE, "block/ghost_platform")).index;

        ItemListener.ADOBE_BRICK.setTexture(ModHelper.NAMESPACE.id("item/adobe_brick"));
        ItemListener.LAPIS_LAZULI_SWORD.setTexture(ModHelper.NAMESPACE.id("item/lapis_lazuli_sword"));
    }
}

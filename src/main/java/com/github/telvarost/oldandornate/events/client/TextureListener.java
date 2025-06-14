package com.github.telvarost.oldandornate.events.client;

import com.github.telvarost.oldandornate.ModHelper;
import com.github.telvarost.oldandornate.events.init.ItemListener;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.client.event.texture.TextureRegisterEvent;

public class TextureListener {

    @EventListener
    public void registerTextures(TextureRegisterEvent event) {
        ItemListener.ADOBE_BRICK.setTexture(ModHelper.NAMESPACE.id("item/adobe_brick"));
        ItemListener.LAPIS_LAZULI_SWORD.setTexture(ModHelper.NAMESPACE.id("item/lapis_lazuli_sword"));
    }
}

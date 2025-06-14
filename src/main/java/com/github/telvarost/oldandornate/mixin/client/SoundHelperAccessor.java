package com.github.telvarost.oldandornate.mixin.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.sound.SoundManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import paulscode.sound.SoundSystem;

@Environment(EnvType.CLIENT)
@Mixin(SoundManager.class)
public interface SoundHelperAccessor {

    @Accessor("soundSystem")
    SoundSystem getSoundSystem();
}

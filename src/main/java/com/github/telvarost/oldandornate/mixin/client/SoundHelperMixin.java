package com.github.telvarost.oldandornate.mixin.client;

import com.github.telvarost.oldandornate.ModHelper;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.sound.Sound;
import net.minecraft.client.sound.SoundEntry;
import net.minecraft.client.sound.SoundManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Environment(EnvType.CLIENT)
@Mixin(SoundManager.class)
public abstract class SoundHelperMixin {

    @WrapOperation(
            method = "playStreaming",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/sound/SoundEntry;get(Ljava/lang/String;)Lnet/minecraft/client/sound/Sound;"
            )
    )
    public Sound quickAdditions_tickRegionSpecific(SoundEntry instance, String string, Operation<Sound> original) {
        Sound streamingSong = original.call(instance, string);

        if (null != streamingSong)
        {
            ModHelper.ModHelperFields.currentStreamingSong = streamingSong.id;
        }

        return streamingSong;
    }
}

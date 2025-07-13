package com.github.telvarost.oldandornate.mixin.client;

import com.github.telvarost.zastavkaapi.ZastavkaHelper;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.render.WorldRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(WorldRenderer.class)
public class WorldRendererMixin {

    @Shadow private Minecraft client;

    @Inject(
            method = "playStreaming",
            at = @At("HEAD"),
            cancellable = true
    )
    public void oldAndOrnate_playStreaming(String stream, int x, int y, int z, CallbackInfo ci) {
        if (  stream != null
           && stream.startsWith("oldandornate:zeldrys")
        ) {
            if (  !((SoundHelperAccessor) this.client.soundManager).getSoundSystem().playing("streaming")
               || (  ZastavkaHelper.currentStreamingSong != null
                  && ZastavkaHelper.currentStreamingSong.startsWith("oldandornate:zeldrys")
                  )
            ) {
                this.client.soundManager.playStreaming(stream, (float)x, (float)y, (float)z, 1.0F, 1.0F);
                ci.cancel();
            } else {
                ci.cancel();
            }
        }
    }
}

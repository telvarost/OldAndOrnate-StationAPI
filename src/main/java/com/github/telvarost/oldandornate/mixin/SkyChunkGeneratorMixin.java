package com.github.telvarost.oldandornate.mixin;

import com.github.telvarost.oldandornate.Config;
import com.github.telvarost.oldandornate.gen.SkyDungeonFeature;
import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkSource;
import net.minecraft.world.gen.chunk.SkyChunkGenerator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(SkyChunkGenerator.class)
public class SkyChunkGeneratorMixin {

    @Shadow private Random random;

    @Shadow private World world;

    @Inject(
            method = "decorate",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/World;method_1781()Lnet/minecraft/world/biome/source/BiomeSource;",
                    ordinal = 1
            ),
            cancellable = true
    )
    public void oldAndOrnate_decorateSkyDungeons(ChunkSource source, int x, int z, CallbackInfo ci) {
        if (0 < Config.config.STAR_FLOWER_CONFIG.starFlowerTerrainGeneration.ordinal()) {
            int xBlockLocation = x * 16;
            int zBlockLocation = z * 16;

            if (this.random.nextInt(255) == 0) {
                int xLocation = xBlockLocation + this.random.nextInt(16) + 8;
                int yLocation = this.random.nextInt(1, world.getHeight() - 16);
                int zLocation = zBlockLocation + this.random.nextInt(16) + 8;
                new SkyDungeonFeature().generate(this.world, this.random, xLocation, yLocation, zLocation);
            }
        }
    }
}

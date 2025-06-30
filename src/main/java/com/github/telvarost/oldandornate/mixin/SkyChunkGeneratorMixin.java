package com.github.telvarost.oldandornate.mixin;

import com.github.telvarost.oldandornate.Config;
import com.github.telvarost.oldandornate.gen.SkyDungeonFeature;
import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkSource;
import net.minecraft.world.gen.chunk.SkyChunkGenerator;
import net.minecraft.world.gen.feature.PlantPatchFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

import static com.github.telvarost.oldandornate.events.init.BlockListener.STAR_FLOWER;

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
    public void oldAndOrnate_decorateSky(ChunkSource source, int x, int z, CallbackInfo ci) {
        int xBlockLocation = x * 16;
        int zBlockLocation = z * 16;

        if (Config.config.DUNGEON_PLATFORM_CONFIG.enableSkylandsDungeonGeneration) {
            if (this.random.nextInt(255) == 0) {
                int xLocation = xBlockLocation + this.random.nextInt(16) + 8;
                int yLocation = this.random.nextInt(1, world.getHeight() - 16);
                int zLocation = zBlockLocation + this.random.nextInt(16) + 8;
                new SkyDungeonFeature().generate(this.world, this.random, xLocation, yLocation, zLocation);
            }
        }

        if (Config.config.STAR_FLOWER_CONFIG.enableSkylandsStarFlowerGeneration) {
            if (this.random.nextInt(2) == 0) {
                int xLocation2 = xBlockLocation + this.random.nextInt(16) + 8;
                int yLocation2 = this.random.nextInt(128);
                int zLocation2 = zBlockLocation + this.random.nextInt(16) + 8;
                new PlantPatchFeature(STAR_FLOWER.id).generate(this.world, this.random, xLocation2, yLocation2, zLocation2);
            }
        }
    }
}

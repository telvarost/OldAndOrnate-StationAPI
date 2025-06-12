package com.github.telvarost.oldandornate.mixin;

import com.github.telvarost.oldandornate.Config;
import com.github.telvarost.oldandornate.StarFlowerGenerationEnum;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkSource;
import net.minecraft.world.gen.chunk.OverworldChunkGenerator;
import net.minecraft.world.gen.feature.LakeFeature;
import net.minecraft.world.gen.feature.PlantPatchFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

import static com.github.telvarost.oldandornate.events.init.BlockListener.ADOBE;
import static com.github.telvarost.oldandornate.events.init.BlockListener.STAR_FLOWER;

@Mixin(OverworldChunkGenerator.class)
public class OverworldChunkGeneratorMixin {

    @Shadow private Random random;

    @Shadow private World world;

    @Unique
    private Biome biomeToDecorate;

    @Inject(
            method = "decorate",
            at = @At("HEAD"),
            cancellable = true
    )
    public void oldAndOrnate_decorateAdobe(ChunkSource source, int x, int z, CallbackInfo ci) {
        int var4 = x * 16;
        int var5 = z * 16;
        biomeToDecorate = this.world.method_1781().getBiome(var4 + 16, var5 + 16);

        if (Config.config.ADOBE_CONFIG.enableAdobeTerrainGeneration) {
            if (Biome.SAVANNA == biomeToDecorate) {
                int var13;
                int var14;
                int var15;

                if (this.random.nextInt(5) == 0) {
                    var13 = var4 + this.random.nextInt(16) + 8;
                    var14 = this.random.nextInt(128);
                    var15 = var5 + this.random.nextInt(16) + 8;
                    (new LakeFeature(ADOBE.id)).generate(this.world, this.random, var13, var14, var15);
                }
            }
        }
    }

    @WrapOperation(
            method = "decorate",
            at = @At(
                    value = "INVOKE",
                    target = "Ljava/util/Random;nextInt(I)I",
                    ordinal = 0
            )
    )
    public int oldAndOrnate_decorateDrySavanna(Random instance, int bound, Operation<Integer> original) {
        if (Config.config.ADOBE_CONFIG.enableAdobeTerrainGeneration) {
            if (Biome.SAVANNA == biomeToDecorate) {
                return original.call(instance, 10);
            }
        }

        return original.call(instance, bound);
    }

    @Inject(
            method = "decorate",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/World;method_1781()Lnet/minecraft/world/biome/source/BiomeSource;",
                    ordinal = 1
            ),
            cancellable = true
    )
    public void oldAndOrnate_decorateStarFlowers(ChunkSource source, int x, int z, CallbackInfo ci) {
        if (0 < Config.config.STAR_FLOWER_CONFIG.starFlowerTerrainGeneration.ordinal()) {
            int var4 = x * 16;
            int var5 = z * 16;

            if (  (StarFlowerGenerationEnum.SPECIFIC_BIOMES == Config.config.STAR_FLOWER_CONFIG.starFlowerTerrainGeneration)
               && (  Biome.SHRUBLAND       == biomeToDecorate
                  || Biome.SEASONAL_FOREST == biomeToDecorate
                  || Biome.SWAMPLAND       == biomeToDecorate
                  || Biome.TUNDRA          == biomeToDecorate
                  )
            ) {
                for (int k = 0; k < 2; ++k) {
                    int var79 = var4 + this.random.nextInt(16) + 8;
                    int var88 = this.random.nextInt(128);
                    int var99 = var5 + this.random.nextInt(16) + 8;
                    new PlantPatchFeature(STAR_FLOWER.id).generate(this.world, this.random, var79, var88, var99);
                }
            } else if (StarFlowerGenerationEnum.ALL_BIOMES == Config.config.STAR_FLOWER_CONFIG.starFlowerTerrainGeneration) {
                for (int k = 0; k < 2; ++k) {
                    int var79 = var4 + this.random.nextInt(16) + 8;
                    int var88 = this.random.nextInt(128);
                    int var99 = var5 + this.random.nextInt(16) + 8;
                    new PlantPatchFeature(STAR_FLOWER.id).generate(this.world, this.random, var79, var88, var99);
                }
            }
        }
    }
}

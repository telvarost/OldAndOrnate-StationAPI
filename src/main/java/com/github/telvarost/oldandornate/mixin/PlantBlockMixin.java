package com.github.telvarost.oldandornate.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.PlantBlock;
import net.minecraft.block.material.Material;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static com.github.telvarost.oldandornate.events.init.BlockListener.ADOBE;

@Mixin(PlantBlock.class)
public class PlantBlockMixin extends Block {
    public PlantBlockMixin(int id, int textureId) {
        super(id, Material.PLANT);
    }

    @Inject(
            method = "canPlantOnTop",
            at = @At("RETURN"),
            cancellable = true
    )
    protected void oldAndOrnate_canPlantOnTop(int id, CallbackInfoReturnable<Boolean> cir) {
        if (id == ADOBE.id) {
            cir.setReturnValue(true);
        }
    }
}

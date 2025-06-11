package com.github.telvarost.oldandornate.mixin;

import net.minecraft.block.DeadBushBlock;
import net.minecraft.block.PlantBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static com.github.telvarost.oldandornate.events.init.BlockListener.ADOBE;

@Mixin(DeadBushBlock.class)
public class DeadBushBlockMixin extends PlantBlock {
    public DeadBushBlockMixin(int i, int j) {
        super(i, j);
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

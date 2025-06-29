//package com.github.telvarost.oldandornate.mixin;
//
//import net.minecraft.world.WorldProperties;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
//
//@Mixin(WorldProperties.class)
//public class WorldMixin {
//
//    @Inject(
//            method = "setRainTime",
//            at = @At("RETURN"),
//            cancellable = true
//    )
//    protected void oldAndOrnate_canPlantOnTop(int par1, CallbackInfo ci) {
//        System.out.println("R: " + par1);
//    }
//}

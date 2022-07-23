package net.boomexe.terrariatrinkets.mixin;

import dev.emi.trinkets.SurvivalTrinketSlot;
import dev.emi.trinkets.TrinketsMain;
import dev.emi.trinkets.api.*;
import net.boomexe.terrariatrinkets.item.TerrariaTrinketsItems;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public abstract class PlayerMixin extends LivingEntity implements TrinketComponent{
    protected PlayerMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

//    @Inject(method = "getBlockBreakingSpeed", at=@At("END"), cancellable = true)
//    private void modifyBlockBreakingSpeed(BlockState block, CallbackInfoReturnable<Float> cir) {
//        if () {
//            cir.setReturnValue(cir.getReturnValueF() + 10);
//        }
//    }
}

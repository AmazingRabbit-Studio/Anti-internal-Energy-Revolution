package io.github.armramzing.aier.mixin;

import io.github.armramzing.aier.item.Items;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {
    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "tick()V", at = @At("HEAD"))
    private void tick(CallbackInfo ci) {
        if (getMainHandStack().getItem() == Items.FRIENDSHIP_SWORD) {
            addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED,
                    720, 1));
        }
    }
}

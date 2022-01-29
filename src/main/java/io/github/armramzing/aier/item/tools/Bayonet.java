package io.github.armramzing.aier.item.tools;

import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class Bayonet extends SwordItem {

    public boolean isCrazy;

    public Bayonet(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED,200,4));
        user.getItemCooldownManager().set(this, 800);
        isCrazy = true;
        return super.use(world, user, hand);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if(isCrazy){
            entity.heal(-1000000);
            user.removeStatusEffect(StatusEffects.SPEED);
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS,200,4));
            user.getItemCooldownManager().set(this, 200);
            isCrazy = false;
        }
        return super.useOnEntity(stack, user, entity, hand);
    }
}

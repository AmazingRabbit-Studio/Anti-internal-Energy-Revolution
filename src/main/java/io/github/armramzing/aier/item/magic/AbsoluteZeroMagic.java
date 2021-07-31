package io.github.armramzing.aier.item.magic;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class AbsoluteZeroMagic extends Item {
    public AbsoluteZeroMagic(Item.Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        user.playSound(SoundEvents.ENTITY_ELDER_GUARDIAN_CURSE, SoundCategory.PLAYERS,1.0F,1.0F);
        entity.playSound(SoundEvents.ENTITY_ELDER_GUARDIAN_CURSE,1.0F,1.0F);
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS,140,127));
        return super.useOnEntity(stack, user, entity, hand);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.getItemCooldownManager().set(this, 400);
        return super.use(world, user, hand);
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(new TranslatableText("item.absolute_zero_magic.fabric_item.tooltip"));
        tooltip.add(new TranslatableText("item.absolute_zero_magic.fabric_item.tooltip1"));
    }
}

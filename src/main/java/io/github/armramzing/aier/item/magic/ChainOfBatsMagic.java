package io.github.armramzing.aier.item.magic;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
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

public class ChainOfBatsMagic extends Item{
    public ChainOfBatsMagic(Item.Settings settings) {
        super(settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!stack.hasEnchantments()) {
            stack.addEnchantment(Enchantments.UNBREAKING, 127);
            stack.addHideFlag(ItemStack.TooltipSection.ENCHANTMENTS);
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        user.playSound(SoundEvents.ENTITY_BAT_DEATH, SoundCategory.PLAYERS,1.0F,1.0F);
        entity.playSound(SoundEvents.ENTITY_BAT_DEATH,1.0F,1.0F);
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER,60,3));
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION,60,1));
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,60,1));
        return super.useOnEntity(stack, user, entity, hand);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.playSound(SoundEvents.ENTITY_BAT_DEATH, SoundCategory.PLAYERS,1.0F,1.0F);
        user.getItemCooldownManager().set(this, 200);
        return super.use(world, user, hand);
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(new TranslatableText("item.chain_of_bats_magic.fabric_item.tooltip"));
        tooltip.add(new TranslatableText("item.chain_of_bats_magic.fabric_item.tooltip1"));
        tooltip.add(new TranslatableText("item.chain_of_bats_magic.fabric_item.tooltip2"));
    }
}

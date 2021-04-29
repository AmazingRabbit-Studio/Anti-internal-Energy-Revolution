package io.github.armramzing.aier.item.tools;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

import java.util.List;

public class FriendshipSword extends SwordItem {

    public FriendshipSword(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!stack.hasEnchantments()) {
            stack.addEnchantment(Enchantments.FIRE_ASPECT, 127);
            stack.addEnchantment(Enchantments.MENDING, 127);
            stack.addEnchantment(Enchantments.UNBREAKING, 127);
            stack.addEnchantment(Enchantments.SHARPNESS, 127);
            stack.addEnchantment(Enchantments.SWEEPING, 127);
            entity.canFly();
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    /*@Override
    public void playerEffects(PlayerEntity player, ItemStack stack){
        if(stack.getItem() == Items.FRIENDSHIP_SWORD){
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED,16,1));
        }
    }*/

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        user.playSound(SoundEvents.ITEM_TRIDENT_RETURN, SoundCategory.PLAYERS,1.0F,1.0F);
        entity.playSound(SoundEvents.ITEM_TRIDENT_RETURN,1.0F,1.0F);
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER,60,3));
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION,60,1));
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,60,1));
        return super.useOnEntity(stack, user, entity, hand);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.playSound(SoundEvents.ITEM_TRIDENT_RETURN, SoundCategory.PLAYERS,1.0F,1.0F);
        user.getItemCooldownManager().set(this, 200);
        return super.use(world, user, hand);
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(new TranslatableText("item.friendship_sword.fabric_item.tooltip"));
        tooltip.add(new TranslatableText("item.friendship_sword.fabric_item.tooltip1"));
        tooltip.add(new TranslatableText("item.friendship_sword.fabric_item.tooltip2"));
        tooltip.add(new TranslatableText("item.friendship_sword.fabric_item.tooltip3"));
        tooltip.add(new TranslatableText("item.friendship_sword.fabric_item.tooltip4"));
        tooltip.add(new TranslatableText("item.friendship_sword.fabric_item.tooltip5"));
    }
}

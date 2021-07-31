package io.github.armramzing.aier.item.tools;

import io.github.armramzing.aier.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class BlackIcyIronToolMaterial implements ToolMaterial {
    @Override
    public int getDurability() {
        return 512;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 7;
    }

    @Override
    public float getAttackDamage() {
        return 0;
    }

    @Override
    public int getMiningLevel() {
        return 2;
    }

    @Override
    public int getEnchantability() {
        return 8;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.BLACK_ICY_IRON_INGOT);
    }

    public static final BlackIcyIronToolMaterial INSTANCE = new BlackIcyIronToolMaterial();
}

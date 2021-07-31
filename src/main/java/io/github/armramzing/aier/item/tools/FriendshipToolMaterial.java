package io.github.armramzing.aier.item.tools;

import io.github.armramzing.aier.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class FriendshipToolMaterial implements ToolMaterial {
    @Override
    public int getDurability() {
        return 8192;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 10;
    }

    @Override
    public float getAttackDamage() {
        return 0;
    }

    @Override
    public int getMiningLevel() {
        return 4;
    }

    @Override
    public int getEnchantability() {
        return 10;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.MAGIC_OF_FRIENDSHIP);
    }

    public static final FriendshipToolMaterial INSTANCE = new FriendshipToolMaterial();
}

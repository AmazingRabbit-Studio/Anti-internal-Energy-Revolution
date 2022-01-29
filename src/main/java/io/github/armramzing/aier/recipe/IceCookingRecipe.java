package io.github.armramzing.aier.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import io.github.armramzing.aier.Aier;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class IceCookingRecipe implements Recipe<Inventory> {
    public static final Codec<IceCookingRecipe> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Registry.ITEM.fieldOf("input1").forGetter(IceCookingRecipe::getInput1),
            Registry.ITEM.fieldOf("input2").forGetter(IceCookingRecipe::getInput2),
            ItemStack.CODEC.fieldOf("result").forGetter(IceCookingRecipe::getOutput)
    ).apply(instance, IceCookingRecipe::new));
    private final Identifier id = new Identifier("aier", "recipe");
    private final Item input1;
    private final Item input2;
    private final ItemStack output;

    public IceCookingRecipe(Item input1, Item input2, ItemStack output) {
        this.input1 = input1;
        this.input2 = input2;
        this.output = output;
    }

    @Override
    public boolean matches(Inventory inventory, World world) {
        if (inventory.size() < 2) {
            return false;
        }
        return this.input1.equals(inventory.getStack(0).getItem()) && this.input2.equals(inventory.getStack(1).getItem());
    }

    @Override
    public ItemStack craft(Inventory inv) {
        return this.output.copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return width == 1 && height == 1;
    }

    @Override
    public ItemStack getOutput() {
        return this.output;
    }

    @Override
    public Identifier getId() {
        return this.id;
    }

    @Override
    public RecipeSerializer<? extends IceCookingRecipe> getSerializer() {
        return IceCookingRecipeSerializer.INSTANCE;
    }

    @Override
    public RecipeType<? extends IceCookingRecipe> getType() {
        return Aier.RECIPE_TYPE;
    }

    public Item getInput1() {
        return this.input1;
    }

    public Item getInput2() {
        return this.input2;
    }
}
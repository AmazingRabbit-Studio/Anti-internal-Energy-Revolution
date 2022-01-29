package io.github.armramzing.aier.recipe;

import com.google.gson.JsonObject;
import com.mojang.serialization.JsonOps;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public enum IceCookingRecipeSerializer implements RecipeSerializer<IceCookingRecipe> {
    INSTANCE;
    @Override
    public IceCookingRecipe read(Identifier id, JsonObject json) {
        return IceCookingRecipe.CODEC.decode(JsonOps.INSTANCE, json).getOrThrow(false, System.err::println).getFirst();
    }

    @Override
    public IceCookingRecipe read(Identifier id, PacketByteBuf buf) {
        Item input1 = Registry.ITEM.get(buf.readIdentifier());
        Item input2 = Registry.ITEM.get(buf.readIdentifier());
        ItemStack output = buf.readItemStack();
        return new IceCookingRecipe(input1, input2, output);
    }

    @Override
    public void write(PacketByteBuf buf, IceCookingRecipe recipe) {
        buf.writeIdentifier(Registry.ITEM.getId(recipe.getInput1()));
        buf.writeIdentifier(Registry.ITEM.getId(recipe.getInput2()));
        buf.writeItemStack(recipe.getOutput());
    }
}

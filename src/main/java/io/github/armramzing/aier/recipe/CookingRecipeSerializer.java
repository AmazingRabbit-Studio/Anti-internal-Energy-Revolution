package io.github.armramzing.aier.recipe;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.registry.Registry;

public class CookingRecipeSerializer<T extends AbstractCookingRecipe>
        implements RecipeSerializer<T> {
    private final int cookingTime;
    private final RecipeFactory<T> factory;

    public CookingRecipeSerializer(RecipeFactory<T> factory, int cookingTime) {
        this.cookingTime = cookingTime;
        this.factory = factory;
    }

    @Override
    public T read(Identifier id, JsonObject json) {
        String result = JsonHelper.getString(json, "result");
        ItemStack output = new ItemStack(
                Registry.ITEM.getOrEmpty(new Identifier(result))
                        .orElseThrow(() -> new IllegalStateException("Item: " + result + " does not exist"))
        );
        return factory.create(id,
                JsonHelper.getString(json, "group", ""),
                Ingredient.fromJson(
                        JsonHelper.hasArray(json, "ingredient")
                                ? JsonHelper.getArray(json, "ingredient")
                                : JsonHelper.getObject(json, "ingredient")
                ),
                output,
                JsonHelper.getFloat(json, "experience", 0f),
                JsonHelper.getInt(json, "cookingtime", cookingTime));
    }

    @Override
    public T read(Identifier id, PacketByteBuf buf) {
        return factory.create(id,
                buf.readString(32767),
                Ingredient.fromPacket(buf),
                buf.readItemStack(),
                buf.readFloat(),
                buf.readVarInt());
    }

    @Override
    public void write(PacketByteBuf buf, T recipe) {
        buf.writeString(recipe.getGroup());
        recipe.getPreviewInputs().get(0).write(buf);
        buf.writeItemStack(recipe.getOutput());
        buf.writeFloat(recipe.getExperience());
        buf.writeVarInt(recipe.getCookTime());
    }

    public interface RecipeFactory<T extends AbstractCookingRecipe> {
        T create(Identifier id, String group, Ingredient input, ItemStack output, float experience, int cookTime);
    }
}

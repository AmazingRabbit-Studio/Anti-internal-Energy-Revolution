package io.github.armramzing.aier.item;

import io.github.armramzing.aier.screen.HelpBookScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class HelpBook extends Item {

    public HelpBook(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(new TranslatableText("item.aier.help_book.tooltip1"));
        tooltip.add(new TranslatableText("item.aier.help_book.tooltip2"));
        tooltip.add(new TranslatableText("item.aier.help_book.tooltip3"));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        MinecraftClient.getInstance().openScreen(new HelpBookScreen());
        return TypedActionResult.success(user.getStackInHand(hand));
    }

}

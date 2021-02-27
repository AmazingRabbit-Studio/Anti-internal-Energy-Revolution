package io.github.armramzing.aier.item;

import io.github.armramzing.aier.Aier;
import io.github.armramzing.aier.block.Blocks;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public final class Items {
    /**help_book**/
    public static final Item HELP_BOOK = register("help_book", new HelpBook(defaultGroup().maxCount(1)));
    /**blocks**/
    public static final Item ICE_FURNACE = register("ice_furnace", new BlockItem(Blocks.ICE_FURNACE, defaultGroup()));
    public static final Item HAND_CRANKED_GRINDER = register("hand_cranked_grinder", new BlockItem(Blocks.HAND_CRANKED_GRINDER,defaultGroup()));
    public static final Item COMPRESSOR = register("compressor", new BlockItem(Blocks.COMPRESSOR, defaultGroup()));
    public static final Item SHAPING_MACHINE = register("shaping_machine", new BlockItem(Blocks.SHAPING_MACHINE, defaultGroup()));
    public static final Item FUSION_MACHINE = register("fusion_machine", new BlockItem(Blocks.FUSION_MACHINE, defaultGroup()));
    public static final Item ICY_IRON_BLOCK = register("icy_iron_block", new BlockItem(Blocks.ICY_IRON_BLOCK,defaultGroup()));
    public static final Item BLACK_ICE = register("black_ice", new BlockItem(Blocks.BLACK_ICE,defaultGroup()));
    public static final Item BLACK_ICY_IRON_BLOCK = register("black_icy_iron_block", new BlockItem(Blocks.BLACK_ICY_IRON_BLOCK,defaultGroup()));
    /**items**/
    public static final Item ICE_CORE = register("ice_core", new Item(defaultGroup()));
    public static final Item ICY_IRON_INGOT = register("icy_iron_ingot", new Item(defaultGroup()));
    public static final Item BLACK_ICY_IRON_INGOT = register("black_icy_iron_ingot", new Item(defaultGroup()));
    public static final Item GOLD_IRON_ALLOY_INGOT = register("gold_iron_alloy_ingot", new Item(defaultGroup()));
    public static final Item NETHER_IRON_ALLOY_INGOT = register("nether_iron_alloy_ingot", new Item(defaultGroup()));
    public static final Item ENDER_IRON_ALLOY_INGOT = register("ender_iron_alloy_ingot", new Item(defaultGroup()));
    public static final Item ICY_IRON_STICK= register("icy_iron_stick", new Item(defaultGroup()));
    public static final Item BLACK_ICY_IRON_STICK= register("black_icy_iron_stick", new Item(defaultGroup()));
    public static final Item ICY_IRON_GEAR = register("icy_iron_gear", new Item(defaultGroup()));
    public static final Item BLACK_ICY_IRON_GEAR = register("black_icy_iron_gear", new Item(defaultGroup()));
    public static final Item CRUSHED_ICE = register("crushed_ice", new Item(defaultGroup()));
    public static final Item INGOT_MOLD = register("ingot_mold", new Item(defaultGroup()));
    public static final Item STICK_MOLD = register("stick_mold", new Item(defaultGroup()));
    public static final Item GEAR_MOLD = register("gear_mold", new Item(defaultGroup()));
    /**tools**/
    public static final Item HEAVY_HAMMER = register("heavy_hammer", new HeavyHammer(BlackIcyIronToolMaterial.INSTANCE,5,-3.5F,new Item.Settings().group(ItemGroups.AIER)));

    private static Item register(String id, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(Aier.MODID, id), item);
    }

    private static Item.Settings defaultGroup() {
        return new Item.Settings().group(ItemGroups.AIER);
    }
}
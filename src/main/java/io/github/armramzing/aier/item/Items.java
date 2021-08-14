package io.github.armramzing.aier.item;

import io.github.armramzing.aier.Aier;
import io.github.armramzing.aier.block.Blocks;
import io.github.armramzing.aier.item.magic.AbsoluteZeroMagic;
import io.github.armramzing.aier.item.magic.AngelSoulMagic;
import io.github.armramzing.aier.item.magic.ChainOfBatsMagic;
import io.github.armramzing.aier.item.tools.*;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public final class Items {
    //help book
    public static final Item HELP_BOOK = register("help_book", new Item(defaultGroup().group(null).maxCount(1)));
    //blocks
    public static final Item ICE_FURNACE = register("ice_furnace", new BlockItem(Blocks.ICE_FURNACE, defaultGroup()));
    public static final Item HAND_CRANKED_GRINDER = register("hand_cranked_grinder", new BlockItem(Blocks.HAND_CRANKED_GRINDER,defaultGroup()));
    public static final Item COMPRESSOR = register("compressor", new BlockItem(Blocks.COMPRESSOR, defaultGroup()));
    public static final Item SHAPING_MACHINE = register("shaping_machine", new BlockItem(Blocks.SHAPING_MACHINE, defaultGroup()));
    public static final Item FUSION_MACHINE = register("fusion_machine", new BlockItem(Blocks.FUSION_MACHINE, defaultGroup()));
    public static final Item ENERGY_PERFUSION_MACHINE = register("energy_perfusion_machine", new BlockItem(Blocks.ENERGY_PERFUSION_MACHINE, defaultGroup()));
    public static final Item ICY_IRON_BLOCK = register("icy_iron_block", new BlockItem(Blocks.ICY_IRON_BLOCK,defaultGroup()));
    public static final Item BLACK_ICE = register("black_ice", new BlockItem(Blocks.BLACK_ICE,defaultGroup()));
    public static final Item BLACK_ICY_IRON_BLOCK = register("black_icy_iron_block", new BlockItem(Blocks.BLACK_ICY_IRON_BLOCK,defaultGroup()));
    public static final Item COMPRESSED_COBBLESTONE = register("compressed_cobblestone", new BlockItem(Blocks.COMPRESSED_COBBLESTONE, defaultGroup()));
    public static final Item HCV_ICE = register("hcv_ice", new BlockItem(Blocks.HCV_ICE,defaultGroup()));
    //items
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
    public static final Item INGOT_MOLD = register("ingot_mold", new Item(defaultGroup()));
    public static final Item STICK_MOLD = register("stick_mold", new Item(defaultGroup()));
    public static final Item GEAR_MOLD = register("gear_mold", new Item(defaultGroup()));
    public static final Item CRUSHED_ICE = register("crushed_ice", new Item(defaultGroup()));
    public static final Item MAGIC_OF_FRIENDSHIP = register("magic_of_friendship", new Item(defaultGroup()));
    //tools
    public static final Item HEAVY_HAMMER = register("heavy_hammer", new HeavyHammer(BlackIcyIronToolMaterial.INSTANCE,5,-3.5F,new Item.Settings().group(ItemGroups.AIER)));
    public static final Item BAYONET = register("bayonet", new Bayonet(BlackIcyIronToolMaterial.INSTANCE,5,3F,new Item.Settings().group(ItemGroups.AIER)));
    public static final Item BLUE_FIRE_SWORD = register("blue_fire_sword", new BlueFireSword(BlueFireToolMaterial.INSTANCE,10,7F,new Item.Settings().group(ItemGroups.AIER)));
    public static final Item FRIENDSHIP_SWORD = register("friendship_sword", new FriendshipSword(FriendshipToolMaterial.INSTANCE,100,10F,new Item.Settings().group(ItemGroups.AIER)));
    //magic
    public static final Item CHAIN_OF_BATS_MAGIC = register("chain_of_bats_magic", new ChainOfBatsMagic(defaultGroup()));
    public static final Item ANGEL_SOUL_MAGIC = register("angel_soul_magic", new AngelSoulMagic(defaultGroup()));
    public static final Item ABSOLUTE_ZERO_MAGIC = register("absolute_zero_magic", new AbsoluteZeroMagic(defaultGroup()));
    //skills
    public static final Item BEATING_SKILL = register("beating_skill", new Item(defaultGroup()));
    public static final Item CASTING_SKILL = register("casting_skill", new Item(defaultGroup()));
    public static final Item QUENCHING_SKILL = register("quenching_skill", new Item(defaultGroup()));

    private static Item register(String id, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(Aier.MODID, id), item);
    }

    private static Item.Settings defaultGroup() {
        return new Item.Settings().group(ItemGroups.AIER);
    }
}
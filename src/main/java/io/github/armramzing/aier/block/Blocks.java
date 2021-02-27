package io.github.armramzing.aier.block;

import io.github.armramzing.aier.Aier;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

import java.util.function.Supplier;

public final class Blocks extends Block {
    public Blocks(AbstractBlock.Settings settings) {
        super(settings);
    }

    /**blocks**/
    public static final Block ICY_IRON_BLOCK = register("icy_iron_block", new IcyIronBlock(FabricBlockSettings.of(Material.METAL).strength(2).requiresTool().breakByTool(FabricToolTags.PICKAXES,1)));
    public static final Block BLACK_ICY_IRON_BLOCK = register("black_icy_iron_block", new BlackIcyIronBlock(FabricBlockSettings.of(Material.METAL).strength(3).requiresTool().breakByTool(FabricToolTags.PICKAXES,2)));
    public static final Block BLACK_ICE= register("black_ice", new BlackIce(FabricBlockSettings.of(Material.ICE).strength(0)));
    public static final Block ICE_FURNACE = register("ice_furnace", new IceFurnace(FabricBlockSettings.of(Material.METAL).strength(2).requiresTool().breakByTool(FabricToolTags.PICKAXES,1)));
    public static final Block HAND_CRANKED_GRINDER = register("hand_cranked_grinder", new HandCrankedGrinder(FabricBlockSettings.of(Material.METAL).strength(2).requiresTool().breakByTool(FabricToolTags.PICKAXES,1)));
    public static final Block COMPRESSOR = register("compressor", new Compressor(FabricBlockSettings.of(Material.METAL).strength(2).requiresTool().breakByTool(FabricToolTags.PICKAXES,1)));
    public static final Block SHAPING_MACHINE = register("shaping_machine", new ShapingMachine(FabricBlockSettings.of(Material.METAL).strength(2).requiresTool().breakByTool(FabricToolTags.PICKAXES,1)));
    public static final Block FUSION_MACHINE = register("fusion_machine", new FusionMachine(FabricBlockSettings.of(Material.METAL).strength(2).requiresTool().breakByTool(FabricToolTags.PICKAXES,1)));
    /**blockentities**/
    public static final BlockEntityType<IceFurnaceEntity> ICE_FURNACE_ENTITY =
            register("ice_furnace_entity", IceFurnaceEntity::new, ICE_FURNACE);
    public static final BlockEntityType<HandCrankedGrinderEntity> HAND_CRANKED_GRINDER_ENTITY =
            register("hand_cranked_grinder_entity", HandCrankedGrinderEntity::new, HAND_CRANKED_GRINDER);
    public static final BlockEntityType<CompressorEntity> COMPRESSOR_ENTITY =
            register("compressor_entity", CompressorEntity::new, COMPRESSOR);
    public static final BlockEntityType<ShapingMachineEntity> SHAPING_MACHINE_ENTITY =
            register("shaping_machine_entity", ShapingMachineEntity::new, SHAPING_MACHINE);
    public static final BlockEntityType<FusionMachineEntity> FUSION_MACHINE_ENTITY =
            register("fusion_machine_entity", FusionMachineEntity::new, FUSION_MACHINE);
    /**blockstates**/
    public static final BooleanProperty LIT = Properties.LIT;

    private static <T extends BlockEntity>
    BlockEntityType<T> register(String id,
                                Supplier<T> supplier,
                                Block block) {
        return Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(Aier.MODID, id),
                BlockEntityType.Builder.create(supplier, block)
                        .build(null));
    }

    private static Block register(String id, Block block) {
        return Registry.register(Registry.BLOCK, new Identifier(Aier.MODID, id), block);
    }
}

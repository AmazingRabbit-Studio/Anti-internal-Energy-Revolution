package io.github.armramzing.aier.block;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class Compressor extends BlockWithEntity {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public Compressor(Settings settings) {
        super(settings);
        setDefaultState(stateManager.getDefaultState().with(FACING, Direction.NORTH));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder
                .add
                        (FACING);
    }

    public static final VoxelShape A = VoxelShapes.cuboid(0, 15/16f, 0,16/16f, 16/16f, 1/16f);
    public static final VoxelShape B = VoxelShapes.cuboid(0, 0, 0,16/16f, 1/16f, 1/16f);
    public static final VoxelShape C = VoxelShapes.cuboid(15/16f, 1/16f, 15/16f,16/16f, 15/16f, 16/16f);
    public static final VoxelShape D = VoxelShapes.cuboid(15/16f, 1/16f, 0,16/16f, 15/16f, 1/16f);
    public static final VoxelShape E = VoxelShapes.cuboid(0, 1/16f, 0,1/16f, 15/16f, 1/16f);
    public static final VoxelShape F = VoxelShapes.cuboid(0, 1/16f, 15/16f,1/16f, 15/16f, 16/16f);
    public static final VoxelShape G = VoxelShapes.cuboid(0, 0, 15/16f,16/16f, 1/16f, 16/16f);
    public static final VoxelShape H = VoxelShapes.cuboid(0, 15/16f, 15/16f,16/16f, 16/16f, 16/16f);
    public static final VoxelShape I = VoxelShapes.cuboid(0, 0, 15/16f,16/16f, 1/16f, 16/16f);
    public static final VoxelShape J = VoxelShapes.cuboid(1/16f, 14/16f, 1/16f,15/16f, 16/16f, 15/16f);
    public static final VoxelShape K = VoxelShapes.cuboid(15/16f, 15/16f, 1/16f,16/16f, 16/16f, 15/16f);
    public static final VoxelShape L = VoxelShapes.cuboid(15/16f, 0, 1/16f,16/16f, 1/16f, 15/16f);
    public static final VoxelShape M = VoxelShapes.cuboid(1/16f, 0, 1/16f,15/16f, 1/16f, 15/16f);
    public static final VoxelShape N = VoxelShapes.cuboid(3/16f, 1/16f, 12/16f,13/16f, 3/16f, 13/16f);
    public static final VoxelShape O = VoxelShapes.cuboid(4/16f, 1/16f, 3/16f,12/16f, 3/16f, 4/16f);
    public static final VoxelShape P = VoxelShapes.cuboid(3/16f, 1/16f, 3/16f,4/16f, 3/16f, 12/16f);
    public static final VoxelShape Q = VoxelShapes.cuboid(12/16f, 1/16f, 3/16f,13/16f, 3/16f, 12/16f);
    public static final VoxelShape R = VoxelShapes.cuboid(0, 15/16f, 1/16f,1/16f, 16/16f, 15/16f);
    public static final VoxelShape S = VoxelShapes.cuboid(0, 0, 1/16f,1/16f, 1/16f, 15/16f);
    public static final VoxelShape T = VoxelShapes.cuboid(7/16f, 10/16f, 7/16f,9/16f, 14/16f, 9/16f);
    public static final VoxelShape U = VoxelShapes.cuboid(4/16f, 7/16f, 4/16f,12/16f, 10/16f, 12/16f);
    public static final VoxelShape V = VoxelShapes.cuboid(0, 0, 0,16/16f, 0, 16/16f);

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return VoxelShapes.union(A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        return new CompressorEntity();
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof CompressorEntity) {
                ItemScatterer.spawn(world, pos, (CompressorEntity) blockEntity);
                // update comparators
                world.updateComparators(pos, this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            NamedScreenHandlerFactory factory = state.createScreenHandlerFactory(world, pos);
            if (factory != null) {
                player.openHandledScreen(factory);
            }
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite());
    }

    @Override
    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    @Override
    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return ScreenHandler.calculateComparatorOutput(world.getBlockEntity(pos));
    }
}

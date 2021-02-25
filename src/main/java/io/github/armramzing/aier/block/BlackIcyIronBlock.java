package io.github.armramzing.aier.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import static io.github.armramzing.aier.item.Items.HEAVY_HAMMER;

public class BlackIcyIronBlock extends Block {

    public static final BooleanProperty HARDENED = BooleanProperty.of("hardened");

    public BlackIcyIronBlock(AbstractBlock.Settings settings) {
        super(settings);
        setDefaultState(getStateManager().getDefaultState().with(HARDENED, false));
    }

    @Override
    public void appendProperties(StateManager.Builder<Block, BlockState> builder){
        super.appendProperties(builder);
        builder
                .add
                        (HARDENED);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(player.getMainHandStack().getItem() == HEAVY_HAMMER) {
            if(state.get(HARDENED)){
            }else{
                world.playSound((double) pos.getX(), (double) pos.getY(), (double) pos.getZ(), SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, 1.0F, 1.0F, false);
            }
            world.setBlockState(pos, state.with(HARDENED, true));
            return ActionResult.SUCCESS;
        }
        return ActionResult.FAIL;
    }
    public float getStrength(BlockState blockState, BlockView blockView, BlockPos pos) {
        boolean hardened = blockState.get(HARDENED);
        if(hardened) {
            return 10.0f;
        } else {
            return 2.0f;
        }
    }
}

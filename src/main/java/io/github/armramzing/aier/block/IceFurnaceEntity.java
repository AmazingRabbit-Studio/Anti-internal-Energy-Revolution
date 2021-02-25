package io.github.armramzing.aier.block;

import io.github.armramzing.aier.inv.ImplementedInventory;
import io.github.armramzing.aier.screen.IceFurnaceScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

/**
 * @author squid233
 * @since 2021/01/17
 */
public class IceFurnaceEntity extends BlockEntity
        implements NamedScreenHandlerFactory,
        ImplementedInventory,
        SidedInventory {
    private static final int[] TOP_SLOT = {0};
    private static final int[] SIDE_SLOT = {1};
    private static final int[] BOTTOM_SLOT = {2};
    private DefaultedList<ItemStack> inventory = DefaultedList.ofSize(3, ItemStack.EMPTY);

    public IceFurnaceEntity() {
        super(Blocks.ICE_FURNACE_ENTITY);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new IceFurnaceScreenHandler(syncId, inv, this);
    }

    @Override
    public Text getDisplayName() {
        return new TranslatableText(getCachedState().getBlock().getTranslationKey());
    }

    @Override
    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);
        inventory = DefaultedList.ofSize(3, ItemStack.EMPTY);
        Inventories.fromTag(tag, inventory);
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        super.toTag(tag);
        Inventories.toTag(tag, inventory);
        return tag;
    }

    @Override
    public int[] getAvailableSlots(Direction side) {
        return side == Direction.UP ? TOP_SLOT : side == Direction.DOWN ? BOTTOM_SLOT : SIDE_SLOT;
    }

    @Override
    public boolean canInsert(int slot, ItemStack stack, @Nullable Direction dir) {
        return true;
    }

    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction dir) {
        return true;
    }
}

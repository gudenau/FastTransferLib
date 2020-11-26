package dev.technici4n.fasttransferlib.api.item;

import dev.technici4n.fasttransferlib.impl.item.ItemImpl;
import net.minecraft.item.ItemStack;

/**
 * A view of an item inventory.
 */
public interface ItemView {
    /**
     * Return the number of slots in the inventory.
     */
    int getSlotCount();

    /**
     * Return the stack in some slot. Note that the stack may have an arbitrary count. It is possible that the returned stack may change
     *
     * <p><b>THIS IS AN ITEM VIEW. DO NOT EVER MODIFY THE RETURNED SLOT.
     * @param slot The slot id, must be between 0 and {@link ItemView#getSlotCount()}.
     * @throws IndexOutOfBoundsException if the slot is not in the range [0, {@link ItemView#getSlotCount()}).
     */
    ItemStack getStack(int slot);

    /**
     * Return the version of this inventory. This number must be non-decreasing, and if this number is the same for two calls, it is expected
     * that the underlying inventory hasn't changed. There is however no guarantee that the inventory has changed if this number has increased.
     */
    default int getVersion() {
        return ItemImpl.version++;
    }
}
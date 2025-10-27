// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.world.World;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Container;

public class ContainerCrystalWorkbench extends Container
{
    public InventoryCrafting craftMatrix;
    public IInventory craftResult;
    private World worldObj;
    private int posX;
    private int posY;
    private int posZ;
    
    public ContainerCrystalWorkbench(final InventoryPlayer par1InventoryPlayer, final World par2World, final int par3, final int par4, final int par5) {
        this.craftMatrix = new InventoryCrafting((Container)this, 3, 3);
        this.craftResult = (IInventory)new InventoryCraftResult();
        this.worldObj = par2World;
        this.posX = par3;
        this.posY = par4;
        this.posZ = par5;
        this.func_75146_a((Slot)new SlotCrafting(par1InventoryPlayer.field_70458_d, (IInventory)this.craftMatrix, this.craftResult, 0, 124, 35));
        for (int l = 0; l < 3; ++l) {
            for (int i1 = 0; i1 < 3; ++i1) {
                this.func_75146_a(new Slot((IInventory)this.craftMatrix, i1 + l * 3, 30 + i1 * 18, 17 + l * 18));
            }
        }
        for (int l = 0; l < 3; ++l) {
            for (int i1 = 0; i1 < 9; ++i1) {
                this.func_75146_a(new Slot((IInventory)par1InventoryPlayer, i1 + l * 9 + 9, 8 + i1 * 18, 84 + l * 18));
            }
        }
        for (int l = 0; l < 9; ++l) {
            this.func_75146_a(new Slot((IInventory)par1InventoryPlayer, l, 8 + l * 18, 142));
        }
        this.func_75130_a((IInventory)this.craftMatrix);
    }
    
    public void func_75130_a(final IInventory par1IInventory) {
        this.craftResult.func_70299_a(0, CraftingManager.func_77594_a().func_82787_a(this.craftMatrix, this.worldObj));
    }
    
    public void func_75134_a(final EntityPlayer par1EntityPlayer) {
        super.func_75134_a(par1EntityPlayer);
        if (!this.worldObj.field_72995_K) {
            for (int i = 0; i < 9; ++i) {
                final ItemStack itemstack = this.craftMatrix.func_70304_b(i);
                if (itemstack != null) {
                    par1EntityPlayer.func_71019_a(itemstack, false);
                }
            }
        }
    }
    
    public boolean func_75145_c(final EntityPlayer par1EntityPlayer) {
        return this.worldObj.func_147439_a(this.posX, this.posY, this.posZ) == OreSpawnMain.CrystalWorkbenchBlock && par1EntityPlayer.func_70092_e(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5) <= 64.0;
    }
    
    public ItemStack func_82846_b(final EntityPlayer par1EntityPlayer, final int par2) {
        ItemStack itemstack = null;
        final Slot slot = this.field_75151_b.get(par2);
        if (slot != null && slot.func_75216_d()) {
            final ItemStack itemstack2 = slot.func_75211_c();
            itemstack = itemstack2.func_77946_l();
            if (par2 == 0) {
                if (!this.func_75135_a(itemstack2, 10, 46, true)) {
                    return null;
                }
                slot.func_75220_a(itemstack2, itemstack);
            }
            else if (par2 >= 10 && par2 < 37) {
                if (!this.func_75135_a(itemstack2, 37, 46, false)) {
                    return null;
                }
            }
            else if (par2 >= 37 && par2 < 46) {
                if (!this.func_75135_a(itemstack2, 10, 37, false)) {
                    return null;
                }
            }
            else if (!this.func_75135_a(itemstack2, 10, 46, false)) {
                return null;
            }
            if (itemstack2.field_77994_a == 0) {
                slot.func_75215_d((ItemStack)null);
            }
            else {
                slot.func_75218_e();
            }
            if (itemstack2.field_77994_a == itemstack.field_77994_a) {
                return null;
            }
            slot.func_82870_a(par1EntityPlayer, itemstack2);
        }
        return itemstack;
    }
    
    public boolean func_94530_a(final ItemStack par1ItemStack, final Slot par2Slot) {
        return par2Slot.field_75224_c != this.craftResult && super.func_94530_a(par1ItemStack, par2Slot);
    }
}

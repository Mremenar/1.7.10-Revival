// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

public class ContainerCrystalFurnace extends Container
{
    private TileEntityCrystalFurnace furnace;
    private int lastCookTime;
    private int lastBurnTime;
    private int lastItemBurnTime;
    
    public ContainerCrystalFurnace(final InventoryPlayer par1InventoryPlayer, final TileEntityCrystalFurnace par2TileEntityCrystalFurnace) {
        this.furnace = par2TileEntityCrystalFurnace;
        this.func_75146_a(new Slot((IInventory)par2TileEntityCrystalFurnace, 0, 56, 17));
        this.func_75146_a(new Slot((IInventory)par2TileEntityCrystalFurnace, 1, 56, 53));
        this.func_75146_a((Slot)new SlotFurnace(par1InventoryPlayer.field_70458_d, (IInventory)par2TileEntityCrystalFurnace, 2, 116, 35));
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.func_75146_a(new Slot((IInventory)par1InventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
        for (int i = 0; i < 9; ++i) {
            this.func_75146_a(new Slot((IInventory)par1InventoryPlayer, i, 8 + i * 18, 142));
        }
    }
    
    public void func_75132_a(final ICrafting par1ICrafting) {
        super.func_75132_a(par1ICrafting);
        par1ICrafting.func_71112_a((Container)this, 0, this.furnace.furnaceCookTime);
        par1ICrafting.func_71112_a((Container)this, 1, this.furnace.furnaceBurnTime);
        par1ICrafting.func_71112_a((Container)this, 2, this.furnace.currentItemBurnTime);
    }
    
    public void func_75142_b() {
        super.func_75142_b();
        for (int i = 0; i < this.field_75149_d.size(); ++i) {
            final ICrafting icrafting = this.field_75149_d.get(i);
            if (this.lastCookTime != this.furnace.furnaceCookTime) {
                icrafting.func_71112_a((Container)this, 0, this.furnace.furnaceCookTime);
            }
            if (this.lastBurnTime != this.furnace.furnaceBurnTime) {
                icrafting.func_71112_a((Container)this, 1, this.furnace.furnaceBurnTime);
            }
            if (this.lastItemBurnTime != this.furnace.currentItemBurnTime) {
                icrafting.func_71112_a((Container)this, 2, this.furnace.currentItemBurnTime);
            }
        }
        this.lastCookTime = this.furnace.furnaceCookTime;
        this.lastBurnTime = this.furnace.furnaceBurnTime;
        this.lastItemBurnTime = this.furnace.currentItemBurnTime;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_75137_b(final int par1, final int par2) {
        if (par1 == 0) {
            this.furnace.furnaceCookTime = par2;
        }
        if (par1 == 1) {
            this.furnace.furnaceBurnTime = par2;
        }
        if (par1 == 2) {
            this.furnace.currentItemBurnTime = par2;
        }
    }
    
    public boolean func_75145_c(final EntityPlayer par1EntityPlayer) {
        return this.furnace.func_70300_a(par1EntityPlayer);
    }
    
    public ItemStack func_82846_b(final EntityPlayer par1EntityPlayer, final int par2) {
        ItemStack itemstack = null;
        final Slot slot = this.field_75151_b.get(par2);
        if (slot != null && slot.func_75216_d()) {
            final ItemStack itemstack2 = slot.func_75211_c();
            itemstack = itemstack2.func_77946_l();
            if (par2 == 2) {
                if (!this.func_75135_a(itemstack2, 3, 39, true)) {
                    return null;
                }
                slot.func_75220_a(itemstack2, itemstack);
            }
            else if (par2 != 1 && par2 != 0) {
                if (FurnaceRecipes.func_77602_a().func_151395_a(itemstack2) != null) {
                    if (!this.func_75135_a(itemstack2, 0, 1, false)) {
                        return null;
                    }
                }
                else if (TileEntityCrystalFurnace.isItemFuel(itemstack2)) {
                    if (!this.func_75135_a(itemstack2, 1, 2, false)) {
                        return null;
                    }
                }
                else if (par2 >= 3 && par2 < 30) {
                    if (!this.func_75135_a(itemstack2, 30, 39, false)) {
                        return null;
                    }
                }
                else if (par2 >= 30 && par2 < 39 && !this.func_75135_a(itemstack2, 3, 30, false)) {
                    return null;
                }
            }
            else if (!this.func_75135_a(itemstack2, 3, 39, false)) {
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
}

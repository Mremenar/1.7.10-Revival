// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.init.Items;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.crafting.FurnaceRecipes;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.tileentity.TileEntity;

public class TileEntityCrystalFurnace extends TileEntity implements ISidedInventory
{
    private static final int[] slots_top;
    private static final int[] slots_bottom;
    private static final int[] slots_sides;
    private ItemStack[] furnaceItemStacks;
    public int furnaceBurnTime;
    public int currentItemBurnTime;
    public int furnaceCookTime;
    private String field_94130_e;
    
    public TileEntityCrystalFurnace() {
        this.furnaceItemStacks = new ItemStack[3];
    }
    
    public int func_70302_i_() {
        return this.furnaceItemStacks.length;
    }
    
    public ItemStack func_70301_a(final int par1) {
        return this.furnaceItemStacks[par1];
    }
    
    public ItemStack func_70298_a(final int par1, final int par2) {
        if (this.furnaceItemStacks[par1] == null) {
            return null;
        }
        if (this.furnaceItemStacks[par1].field_77994_a <= par2) {
            final ItemStack itemstack = this.furnaceItemStacks[par1];
            this.furnaceItemStacks[par1] = null;
            return itemstack;
        }
        final ItemStack itemstack = this.furnaceItemStacks[par1].func_77979_a(par2);
        if (this.furnaceItemStacks[par1].field_77994_a == 0) {
            this.furnaceItemStacks[par1] = null;
        }
        return itemstack;
    }
    
    public ItemStack func_70304_b(final int par1) {
        if (this.furnaceItemStacks[par1] != null) {
            final ItemStack itemstack = this.furnaceItemStacks[par1];
            this.furnaceItemStacks[par1] = null;
            return itemstack;
        }
        return null;
    }
    
    public void func_70299_a(final int par1, final ItemStack par2ItemStack) {
        this.furnaceItemStacks[par1] = par2ItemStack;
        if (par2ItemStack != null && par2ItemStack.field_77994_a > this.func_70297_j_()) {
            par2ItemStack.field_77994_a = this.func_70297_j_();
        }
    }
    
    public String func_145825_b() {
        return this.func_145818_k_() ? this.field_94130_e : "container.furnace";
    }
    
    public boolean func_145818_k_() {
        return this.field_94130_e != null && this.field_94130_e.length() > 0;
    }
    
    public void func_145951_a(final String par1Str) {
        this.field_94130_e = par1Str;
    }
    
    public void func_145839_a(final NBTTagCompound par1NBTTagCompound) {
        super.func_145839_a(par1NBTTagCompound);
        final NBTTagList nbttaglist = par1NBTTagCompound.func_150295_c("Items", 10);
        this.furnaceItemStacks = new ItemStack[this.func_70302_i_()];
        for (int i = 0; i < nbttaglist.func_74745_c(); ++i) {
            final NBTTagCompound nbttagcompound1 = nbttaglist.func_150305_b(i);
            final byte b0 = nbttagcompound1.func_74771_c("Slot");
            if (b0 >= 0 && b0 < this.furnaceItemStacks.length) {
                this.furnaceItemStacks[b0] = ItemStack.func_77949_a(nbttagcompound1);
            }
        }
        this.furnaceBurnTime = par1NBTTagCompound.func_74765_d("BurnTime");
        this.furnaceCookTime = par1NBTTagCompound.func_74765_d("CookTime");
        this.currentItemBurnTime = getItemBurnTime(this.furnaceItemStacks[1]);
        if (par1NBTTagCompound.func_74764_b("CustomName")) {
            this.field_94130_e = par1NBTTagCompound.func_74779_i("CustomName");
        }
    }
    
    public void func_145841_b(final NBTTagCompound par1NBTTagCompound) {
        super.func_145841_b(par1NBTTagCompound);
        par1NBTTagCompound.func_74777_a("BurnTime", (short)this.furnaceBurnTime);
        par1NBTTagCompound.func_74777_a("CookTime", (short)this.furnaceCookTime);
        final NBTTagList nbttaglist = new NBTTagList();
        for (int i = 0; i < this.furnaceItemStacks.length; ++i) {
            if (this.furnaceItemStacks[i] != null) {
                final NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.func_74774_a("Slot", (byte)i);
                this.furnaceItemStacks[i].func_77955_b(nbttagcompound1);
                nbttaglist.func_74742_a((NBTBase)nbttagcompound1);
            }
        }
        par1NBTTagCompound.func_74782_a("Items", (NBTBase)nbttaglist);
        if (this.func_145818_k_()) {
            par1NBTTagCompound.func_74778_a("CustomName", this.field_94130_e);
        }
    }
    
    public int func_70297_j_() {
        return 64;
    }
    
    @SideOnly(Side.CLIENT)
    public int getCookProgressScaled(final int par1) {
        return this.furnaceCookTime * par1 / 150;
    }
    
    @SideOnly(Side.CLIENT)
    public int getBurnTimeRemainingScaled(final int par1) {
        if (this.currentItemBurnTime == 0) {
            this.currentItemBurnTime = 150;
        }
        return this.furnaceBurnTime * par1 / this.currentItemBurnTime;
    }
    
    public boolean isBurning() {
        return this.furnaceBurnTime > 0;
    }
    
    public void func_145845_h() {
        final boolean flag = this.furnaceBurnTime > 0;
        boolean flag2 = false;
        if (this.furnaceBurnTime > 0) {
            --this.furnaceBurnTime;
        }
        if (!this.field_145850_b.field_72995_K) {
            if (this.furnaceBurnTime == 0 && this.canSmelt()) {
                final int itemBurnTime = getItemBurnTime(this.furnaceItemStacks[1]);
                this.furnaceBurnTime = itemBurnTime;
                this.currentItemBurnTime = itemBurnTime;
                if (this.furnaceBurnTime > 0) {
                    flag2 = true;
                    if (this.furnaceItemStacks[1] != null) {
                        final ItemStack itemStack = this.furnaceItemStacks[1];
                        --itemStack.field_77994_a;
                        if (this.furnaceItemStacks[1].field_77994_a == 0) {
                            this.furnaceItemStacks[1] = this.furnaceItemStacks[1].func_77973_b().getContainerItem(this.furnaceItemStacks[1]);
                        }
                    }
                }
            }
            if (this.isBurning() && this.canSmelt()) {
                ++this.furnaceCookTime;
                if (this.furnaceCookTime == 150) {
                    this.furnaceCookTime = 0;
                    this.smeltItem();
                    flag2 = true;
                }
            }
            else {
                this.furnaceCookTime = 0;
            }
            if (flag != this.furnaceBurnTime > 0) {
                flag2 = true;
                final CrystalFurnace crystalFurnaceBlock = OreSpawnMain.CrystalFurnaceBlock;
                CrystalFurnace.updateFurnaceBlockState(this.furnaceBurnTime > 0, this.field_145850_b, this.field_145851_c, this.field_145848_d, this.field_145849_e);
            }
        }
        if (flag2) {
            this.func_70296_d();
        }
    }
    
    private boolean canSmelt() {
        if (this.furnaceItemStacks[0] == null) {
            return false;
        }
        final ItemStack itemstack = FurnaceRecipes.func_77602_a().func_151395_a(this.furnaceItemStacks[0]);
        if (itemstack == null) {
            return false;
        }
        if (this.furnaceItemStacks[2] == null) {
            return true;
        }
        if (!this.furnaceItemStacks[2].func_77969_a(itemstack)) {
            return false;
        }
        final int result = this.furnaceItemStacks[2].field_77994_a + itemstack.field_77994_a;
        return result <= this.func_70297_j_() && result <= itemstack.func_77976_d();
    }
    
    public void smeltItem() {
        if (this.canSmelt()) {
            final ItemStack itemstack = FurnaceRecipes.func_77602_a().func_151395_a(this.furnaceItemStacks[0]);
            if (this.furnaceItemStacks[2] == null) {
                this.furnaceItemStacks[2] = itemstack.func_77946_l();
            }
            else if (this.furnaceItemStacks[2].func_77969_a(itemstack)) {
                final ItemStack itemStack = this.furnaceItemStacks[2];
                itemStack.field_77994_a += itemstack.field_77994_a;
            }
            final ItemStack itemStack2 = this.furnaceItemStacks[0];
            --itemStack2.field_77994_a;
            if (this.furnaceItemStacks[0].field_77994_a <= 0) {
                this.furnaceItemStacks[0] = null;
            }
        }
    }
    
    public static int getItemBurnTime(final ItemStack par0ItemStack) {
        if (par0ItemStack == null) {
            return 0;
        }
        final Item item = par0ItemStack.func_77973_b();
        if (item instanceof ItemBlock && Block.func_149634_a(item) != Blocks.field_150350_a) {
            final Block block = Block.func_149634_a(item);
            if (block == Blocks.field_150376_bx) {
                return 150;
            }
            if (block.func_149688_o() == Material.field_151575_d) {
                return 300;
            }
            if (block == Blocks.field_150402_ci) {
                return 16000;
            }
        }
        if (item instanceof ItemTool && ((ItemTool)item).func_77861_e().equals("WOOD")) {
            return 200;
        }
        if (item instanceof ItemSword && ((ItemSword)item).func_150932_j().equals("WOOD")) {
            return 200;
        }
        if (item instanceof ItemHoe && ((ItemHoe)item).func_77842_f().equals("WOOD")) {
            return 200;
        }
        if (item == Items.field_151055_y) {
            return 100;
        }
        if (item == Items.field_151044_h) {
            return 1600;
        }
        if (item == Items.field_151129_at) {
            return 20000;
        }
        if (item == Item.func_150898_a(Blocks.field_150345_g)) {
            return 100;
        }
        if (item == Items.field_151072_bj) {
            return 2400;
        }
        if (item == Item.func_150898_a(OreSpawnMain.CrystalCoal)) {
            return 20000;
        }
        if (item == Item.func_150898_a(OreSpawnMain.MyCrystalTreeLog)) {
            return 800;
        }
        if (item == Item.func_150898_a(OreSpawnMain.CrystalPlanksBlock)) {
            return 400;
        }
        return GameRegistry.getFuelValue(par0ItemStack);
    }
    
    public static boolean isItemFuel(final ItemStack par0ItemStack) {
        return getItemBurnTime(par0ItemStack) > 0;
    }
    
    public boolean func_70300_a(final EntityPlayer par1EntityPlayer) {
        return this.field_145850_b.func_147438_o(this.field_145851_c, this.field_145848_d, this.field_145849_e) == this && par1EntityPlayer.func_70092_e(this.field_145851_c + 0.5, this.field_145848_d + 0.5, this.field_145849_e + 0.5) <= 64.0;
    }
    
    public void openChest() {
    }
    
    public void closeChest() {
    }
    
    public boolean func_94041_b(final int par1, final ItemStack par2ItemStack) {
        return par1 != 2 && (par1 != 1 || isItemFuel(par2ItemStack));
    }
    
    public int[] func_94128_d(final int par1) {
        return (par1 == 0) ? TileEntityCrystalFurnace.slots_bottom : ((par1 == 1) ? TileEntityCrystalFurnace.slots_top : TileEntityCrystalFurnace.slots_sides);
    }
    
    public boolean func_102007_a(final int par1, final ItemStack par2ItemStack, final int par3) {
        return this.func_94041_b(par1, par2ItemStack);
    }
    
    public boolean func_102008_b(final int par1, final ItemStack par2ItemStack, final int par3) {
        return par3 != 0 || par1 != 1 || par2ItemStack.func_77973_b() == Items.field_151133_ar;
    }
    
    public void func_70295_k_() {
    }
    
    public void func_70305_f() {
    }
    
    static {
        slots_top = new int[] { 0 };
        slots_bottom = new int[] { 2, 1 };
        slots_sides = new int[] { 1 };
    }
}

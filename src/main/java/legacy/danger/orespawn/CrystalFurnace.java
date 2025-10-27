// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.MathHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.world.World;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.IIcon;
import java.util.Random;
import net.minecraft.block.BlockContainer;

public class CrystalFurnace extends BlockContainer
{
    private final Random furnaceRand;
    private final boolean isActive;
    private static boolean keepFurnaceInventory;
    @SideOnly(Side.CLIENT)
    private IIcon furnaceIconTop;
    @SideOnly(Side.CLIENT)
    private IIcon furnaceIconFront;
    
    protected CrystalFurnace(final int par1, final boolean par2, final float f1, final float f2) {
        super(Material.field_151576_e);
        this.furnaceRand = new Random();
        if (!(this.isActive = par2)) {
            this.func_149647_a(CreativeTabs.field_78031_c);
        }
        else {
            this.func_149715_a(0.6f);
        }
        this.func_149711_c(f1);
        this.func_149752_b(f2);
    }
    
    public boolean func_149662_c() {
        return false;
    }
    
    public boolean func_149686_d() {
        return false;
    }
    
    public Item func_149650_a(final int par1, final Random par2Random, final int par3) {
        return Item.func_150898_a((Block)OreSpawnMain.CrystalFurnaceBlock);
    }
    
    @SideOnly(Side.CLIENT)
    public Item idPicked(final World par1World, final int par2, final int par3, final int par4) {
        return Item.func_150898_a((Block)OreSpawnMain.CrystalFurnaceBlock);
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon func_149691_a(final int par1, final int par2) {
        return (par1 == 1) ? this.furnaceIconTop : ((par1 == 0) ? this.furnaceIconTop : ((par1 != par2) ? this.field_149761_L : this.furnaceIconFront));
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149651_a(final IIconRegister par1IIconRegister) {
        this.field_149761_L = par1IIconRegister.func_94245_a("OreSpawn:" + this.func_149739_a().substring(5) + "_side");
        this.furnaceIconFront = par1IIconRegister.func_94245_a("OreSpawn:" + this.func_149739_a().substring(5) + (this.isActive ? "_front_off" : "_front_off"));
        this.furnaceIconTop = par1IIconRegister.func_94245_a("OreSpawn:" + this.func_149739_a().substring(5) + "_top");
    }
    
    public static void updateFurnaceBlockState(final boolean par0, final World par1World, final int par2, final int par3, final int par4) {
        final int l = par1World.func_72805_g(par2, par3, par4);
        final TileEntity tileentity = par1World.func_147438_o(par2, par3, par4);
        CrystalFurnace.keepFurnaceInventory = true;
        if (par0) {
            par1World.func_147449_b(par2, par3, par4, OreSpawnMain.CrystalFurnaceOnBlock);
        }
        else {
            par1World.func_147449_b(par2, par3, par4, (Block)OreSpawnMain.CrystalFurnaceBlock);
        }
        CrystalFurnace.keepFurnaceInventory = false;
        par1World.func_72921_c(par2, par3, par4, l, 2);
        if (tileentity != null) {
            tileentity.func_145829_t();
            par1World.func_147455_a(par2, par3, par4, tileentity);
        }
    }
    
    public void func_149726_b(final World par1World, final int par2, final int par3, final int par4) {
        super.func_149726_b(par1World, par2, par3, par4);
        this.setDefaultDirection(par1World, par2, par3, par4);
    }
    
    private void setDefaultDirection(final World par1World, final int par2, final int par3, final int par4) {
        if (!par1World.field_72995_K) {
            final Block l = par1World.func_147439_a(par2, par3, par4 - 1);
            final Block i1 = par1World.func_147439_a(par2, par3, par4 + 1);
            final Block j1 = par1World.func_147439_a(par2 - 1, par3, par4);
            final Block k1 = par1World.func_147439_a(par2 + 1, par3, par4);
            byte b0 = 3;
            if (l.func_149730_j() && !i1.func_149730_j()) {
                b0 = 3;
            }
            if (i1.func_149730_j() && !l.func_149730_j()) {
                b0 = 2;
            }
            if (j1.func_149730_j() && !k1.func_149730_j()) {
                b0 = 5;
            }
            if (k1.func_149730_j() && !j1.func_149730_j()) {
                b0 = 4;
            }
            par1World.func_72921_c(par2, par3, par4, (int)b0, 2);
        }
    }
    
    public boolean func_149727_a(final World par1World, final int par2, final int par3, final int par4, final EntityPlayer par5EntityPlayer, final int par6, final float par7, final float par8, final float par9) {
        if (par1World.field_72995_K) {
            return true;
        }
        final TileEntityCrystalFurnace tileentitycrystalfurnace = (TileEntityCrystalFurnace)par1World.func_147438_o(par2, par3, par4);
        if (tileentitycrystalfurnace != null) {
            par5EntityPlayer.openGui((Object)OreSpawnMain.instance, 0, par1World, par2, par3, par4);
        }
        return true;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149734_b(final World par1World, final int par2, final int par3, final int par4, final Random par5Random) {
        if (this.isActive) {
            final int l = par1World.func_72805_g(par2, par3, par4);
            final float f = par2 + 0.5f;
            final float f2 = par3 + 0.0f + par5Random.nextFloat() * 6.0f / 16.0f;
            final float f3 = par4 + 0.5f;
            final float f4 = par5Random.nextFloat() * 0.6f - 0.3f;
            final float f5 = par5Random.nextFloat() * 0.6f - 0.3f;
            if (l == 4) {
                par1World.func_72869_a("smoke", (double)(f - f4), (double)f2, (double)(f3 + f5), 0.0, 0.0, 0.0);
                par1World.func_72869_a("flame", (double)(f - f4), (double)f2, (double)(f3 + f5), 0.0, 0.0, 0.0);
            }
            else if (l == 5) {
                par1World.func_72869_a("smoke", (double)(f + f4), (double)f2, (double)(f3 + f5), 0.0, 0.0, 0.0);
                par1World.func_72869_a("flame", (double)(f + f4), (double)f2, (double)(f3 + f5), 0.0, 0.0, 0.0);
            }
            else if (l == 2) {
                par1World.func_72869_a("smoke", (double)(f + f5), (double)f2, (double)(f3 - f4), 0.0, 0.0, 0.0);
                par1World.func_72869_a("flame", (double)(f + f5), (double)f2, (double)(f3 - f4), 0.0, 0.0, 0.0);
            }
            else if (l == 3) {
                par1World.func_72869_a("smoke", (double)(f + f5), (double)f2, (double)(f3 + f4), 0.0, 0.0, 0.0);
                par1World.func_72869_a("flame", (double)(f + f5), (double)f2, (double)(f3 + f4), 0.0, 0.0, 0.0);
            }
        }
    }
    
    public void func_149689_a(final World par1World, final int par2, final int par3, final int par4, final EntityLivingBase par5EntityLivingBase, final ItemStack par6ItemStack) {
        final int l = MathHelper.func_76128_c(par5EntityLivingBase.field_70177_z * 4.0f / 360.0f + 0.5) & 0x3;
        if (l == 0) {
            par1World.func_72921_c(par2, par3, par4, 2, 2);
        }
        if (l == 1) {
            par1World.func_72921_c(par2, par3, par4, 5, 2);
        }
        if (l == 2) {
            par1World.func_72921_c(par2, par3, par4, 3, 2);
        }
        if (l == 3) {
            par1World.func_72921_c(par2, par3, par4, 4, 2);
        }
        if (par6ItemStack.func_82837_s()) {
            ((TileEntityCrystalFurnace)par1World.func_147438_o(par2, par3, par4)).func_145951_a(par6ItemStack.func_82833_r());
        }
    }
    
    public void func_149749_a(final World par1World, final int par2, final int par3, final int par4, final Block par5, final int par6) {
        if (!CrystalFurnace.keepFurnaceInventory) {
            final TileEntityCrystalFurnace tileentitycrystalfurnace = (TileEntityCrystalFurnace)par1World.func_147438_o(par2, par3, par4);
            if (tileentitycrystalfurnace != null) {
                for (int j1 = 0; j1 < tileentitycrystalfurnace.func_70302_i_(); ++j1) {
                    final ItemStack itemstack = tileentitycrystalfurnace.func_70301_a(j1);
                    if (itemstack != null) {
                        final float f = this.furnaceRand.nextFloat() * 0.8f + 0.1f;
                        final float f2 = this.furnaceRand.nextFloat() * 0.8f + 0.1f;
                        final float f3 = this.furnaceRand.nextFloat() * 0.8f + 0.1f;
                        while (itemstack.field_77994_a > 0) {
                            int k1 = this.furnaceRand.nextInt(21) + 10;
                            if (k1 > itemstack.field_77994_a) {
                                k1 = itemstack.field_77994_a;
                            }
                            final ItemStack itemStack = itemstack;
                            itemStack.field_77994_a -= k1;
                            final EntityItem entityitem = new EntityItem(par1World, (double)(par2 + f), (double)(par3 + f2), (double)(par4 + f3), new ItemStack(itemstack.func_77973_b(), k1, itemstack.func_77960_j()));
                            if (itemstack.func_77942_o()) {
                                entityitem.func_92059_d().func_77982_d((NBTTagCompound)itemstack.func_77978_p().func_74737_b());
                            }
                            final float f4 = 0.05f;
                            entityitem.field_70159_w = (float)this.furnaceRand.nextGaussian() * f4;
                            entityitem.field_70181_x = (float)this.furnaceRand.nextGaussian() * f4 + 0.2f;
                            entityitem.field_70179_y = (float)this.furnaceRand.nextGaussian() * f4;
                            par1World.func_72838_d((Entity)entityitem);
                        }
                    }
                }
                par1World.func_147453_f(par2, par3, par4, par5);
            }
        }
        super.func_149749_a(par1World, par2, par3, par4, par5, par6);
    }
    
    public boolean func_149740_M() {
        return true;
    }
    
    public int func_149736_g(final World par1World, final int par2, final int par3, final int par4, final int par5) {
        return Container.func_94526_b((IInventory)par1World.func_147438_o(par2, par3, par4));
    }
    
    public TileEntity func_149915_a(final World var1, final int var2) {
        return new TileEntityCrystalFurnace();
    }
}

// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.init.Blocks;
import net.minecraft.world.IBlockAccess;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Block;
import java.util.List;
import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.BlockLeaves;

public class BlockCrystalLeaves extends BlockLeaves
{
    protected BlockCrystalLeaves(final int par1) {
        this.func_149675_a(true);
        this.func_149647_a(CreativeTabs.field_78031_c);
    }
    
    public void func_149666_a(final Item par1, final CreativeTabs par2CreativeTabs, final List par3List) {
        par3List.add(new ItemStack(Item.func_150898_a((Block)this), 1, 0));
    }
    
    public void func_149690_a(final World par1World, final int par2, final int par3, final int par4, final int par5, final float par6, final int par7) {
        if (!par1World.field_72995_K) {
            if (par1World.field_73012_v.nextInt(100) == 1) {
                this.func_149642_a(par1World, par2, par3, par4, new ItemStack(OreSpawnMain.MyCrystalApple));
            }
            if (par1World.field_73012_v.nextInt(50) == 1) {
                if (this == OreSpawnMain.MyCrystalLeaves) {
                    this.func_149642_a(par1World, par2, par3, par4, new ItemStack(OreSpawnMain.MyCrystalPlant));
                }
                if (this == OreSpawnMain.MyCrystalLeaves2) {
                    this.func_149642_a(par1World, par2, par3, par4, new ItemStack(OreSpawnMain.MyCrystalPlant2));
                }
                if (this == OreSpawnMain.MyCrystalLeaves3) {
                    this.func_149642_a(par1World, par2, par3, par4, new ItemStack(OreSpawnMain.MyCrystalPlant3));
                }
            }
        }
    }
    
    public int func_149745_a(final Random par1Random) {
        return 1;
    }
    
    public void func_149674_a(final World par1World, final int par2, final int par3, final int par4, final Random par5Random) {
        int var7 = 2;
        int totaldist = 0;
        int chance = 20;
        if (par1World.field_73011_w.field_76574_g == OreSpawnMain.DimensionID4) {
            chance = 100;
            var7 = 1;
        }
        if (!par1World.field_72995_K && par1World.func_72904_c(par2 - var7, par3 - var7, par4 - var7, par2 + var7, par3 + var7, par4 + var7)) {
            for (int var8 = -var7; var8 <= var7; ++var8) {
                for (int var9 = -var7; var9 <= 0; ++var9) {
                    for (int var10 = -var7; var10 <= var7; ++var10) {
                        totaldist = Math.abs(var8) + Math.abs(var9) + Math.abs(var10);
                        if (totaldist <= 3) {
                            Block bid = par1World.func_147439_a(par2 + var8, par3 + var9, par4 + var10);
                            if (bid != null && bid.canSustainLeaves((IBlockAccess)par1World, par2 + var8, par3 + var9, par4 + var10)) {
                                bid = par1World.func_147439_a(par2, par3 - 1, par4);
                                if (bid == Blocks.field_150350_a && par1World.field_73012_v.nextInt(chance) == 3) {
                                    this.func_149690_a(par1World, par2, par3 - 1, par4, 0, 0.0f, 0);
                                }
                                return;
                            }
                        }
                    }
                }
            }
            this.removeLeaves(par1World, par2, par3, par4);
        }
    }
    
    private void removeLeaves(final World par1World, final int par2, final int par3, final int par4) {
        this.func_149697_b(par1World, par2, par3, par4, 0, 0);
        par1World.func_147465_d(par2, par3, par4, Blocks.field_150350_a, 0, 2);
    }
    
    public boolean func_149662_c() {
        return OreSpawnMain.FastGraphicsLeaves != 0;
    }
    
    public boolean func_149686_d() {
        return OreSpawnMain.FastGraphicsLeaves != 0;
    }
    
    public int func_149645_b() {
        if (OreSpawnMain.FastGraphicsLeaves != 0) {
            return super.func_149645_b();
        }
        return 1;
    }
    
    @SideOnly(Side.CLIENT)
    public boolean func_149646_a(final IBlockAccess par1IBlockAccess, final int par2, final int par3, final int par4, final int par5) {
        final Block i1 = par1IBlockAccess.func_147439_a(par2, par3, par4);
        return OreSpawnMain.FastGraphicsLeaves == 0 || i1 != this;
    }
    
    @SideOnly(Side.CLIENT)
    public int func_149635_D() {
        return 14540253;
    }
    
    @SideOnly(Side.CLIENT)
    public int func_149741_i(final int par1) {
        return 14540253;
    }
    
    @SideOnly(Side.CLIENT)
    public int func_149720_d(final IBlockAccess par1IBlockAccess, final int par2, final int par3, final int par4) {
        return 14540253;
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon func_149691_a(final int par1, final int par2) {
        return this.field_149761_L;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149651_a(final IIconRegister iconRegister) {
        this.field_149761_L = iconRegister.func_94245_a("OreSpawn:" + this.func_149739_a().substring(5));
    }
    
    public String[] func_150125_e() {
        return null;
    }
}

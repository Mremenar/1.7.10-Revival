// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.client.renderer.texture.IIconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.init.Blocks;
import net.minecraft.world.IBlockAccess;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Block;
import java.util.List;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.block.BlockLeaves;

public class BlockScaryLeaves extends BlockLeaves
{
    private IIcon scary_solid;
    private IIcon generic_solid;
    
    protected BlockScaryLeaves(final int par1) {
        this.scary_solid = null;
        this.generic_solid = null;
    }
    
    public void func_149666_a(final Item par1, final CreativeTabs par2CreativeTabs, final List par3List) {
        par3List.add(new ItemStack(Item.func_150898_a((Block)this), 1, 0));
    }
    
    public void func_149690_a(final World par1World, final int par2, final int par3, final int par4, final int par5, final float par6, final int par7) {
        if (!par1World.field_72995_K && par1World.field_73012_v.nextInt(25) == 1) {
            if (this == OreSpawnMain.MyCherryLeaves) {
                this.func_149642_a(par1World, par2, par3, par4, new ItemStack(OreSpawnMain.MyCherry));
            }
            if (this == OreSpawnMain.MyPeachLeaves) {
                this.func_149642_a(par1World, par2, par3, par4, new ItemStack(OreSpawnMain.MyPeach));
            }
        }
    }
    
    public int func_149745_a(final Random par1Random) {
        if (this == OreSpawnMain.MyCherryLeaves) {
            return par1Random.nextInt(4);
        }
        if (this == OreSpawnMain.MyPeachLeaves) {
            return par1Random.nextInt(1);
        }
        return 0;
    }
    
    public void func_149674_a(final World par1World, final int par2, final int par3, final int par4, final Random par5Random) {
        final int var7 = 2;
        int totaldist = 0;
        if (!par1World.field_72995_K && par1World.func_72904_c(par2 - var7, par3 - var7, par4 - var7, par2 + var7, par3 + var7, par4 + var7)) {
            for (int var8 = -var7; var8 <= var7; ++var8) {
                for (int var9 = -var7; var9 <= 0; ++var9) {
                    for (int var10 = -var7; var10 <= var7; ++var10) {
                        totaldist = Math.abs(var8) + Math.abs(var9) + Math.abs(var10);
                        if (totaldist <= 3) {
                            Block bid = par1World.func_147439_a(par2 + var8, par3 + var9, par4 + var10);
                            if (bid != null && bid.canSustainLeaves((IBlockAccess)par1World, par2 + var8, par3 + var9, par4 + var10)) {
                                long t = par1World.func_72820_D();
                                t %= 24000L;
                                if (this == OreSpawnMain.MyScaryLeaves && t < 12000L) {
                                    OreSpawnMain.setBlockFast(par1World, par2, par3, par4, OreSpawnMain.MyAppleLeaves, 0, 3);
                                }
                                bid = par1World.func_147439_a(par2, par3 - 1, par4);
                                if (bid == Blocks.field_150350_a && par1World.field_73012_v.nextInt(20) == 3) {
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
    
    public void func_149734_b(final World par1World, final int par2, final int par3, final int par4, final Random par5Random) {
    }
    
    private void removeLeaves(final World par1World, final int par2, final int par3, final int par4) {
        this.func_149697_b(par1World, par2, par3, par4, 0, 0);
        par1World.func_147465_d(par2, par3, par4, Blocks.field_150350_a, 0, 2);
    }
    
    public boolean func_149662_c() {
        return OreSpawnMain.FastGraphicsLeaves != 0;
    }
    
    @SideOnly(Side.CLIENT)
    public boolean func_149646_a(final IBlockAccess par1IBlockAccess, final int par2, final int par3, final int par4, final int par5) {
        final Block i1 = par1IBlockAccess.func_147439_a(par2, par3, par4);
        return OreSpawnMain.FastGraphicsLeaves == 0 || i1 != this;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149651_a(final IIconRegister iconRegister) {
        this.field_149761_L = iconRegister.func_94245_a("OreSpawn:" + this.func_149739_a().substring(5));
        this.generic_solid = iconRegister.func_94245_a("OreSpawn:generic_solid");
        this.scary_solid = iconRegister.func_94245_a("OreSpawn:scary_solid");
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon func_149691_a(final int par1, final int par2) {
        if (OreSpawnMain.FastGraphicsLeaves == 0) {
            return this.field_149761_L;
        }
        if (this == OreSpawnMain.MyCherryLeaves) {
            return this.generic_solid;
        }
        if (this == OreSpawnMain.MyPeachLeaves) {
            return this.generic_solid;
        }
        return this.scary_solid;
    }
    
    public String[] func_150125_e() {
        return null;
    }
}

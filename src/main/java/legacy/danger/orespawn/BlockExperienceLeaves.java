// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.client.renderer.texture.IIconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityExpBottle;
import net.minecraft.init.Items;
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

public class BlockExperienceLeaves extends BlockLeaves
{
    private IIcon generic_solid;
    
    protected BlockExperienceLeaves(final int par1) {
        this.generic_solid = null;
    }
    
    public void func_149666_a(final Item par1, final CreativeTabs par2CreativeTabs, final List par3List) {
        par3List.add(new ItemStack(Item.func_150898_a((Block)this), 1, 0));
    }
    
    public void func_149690_a(final World par1World, final int par2, final int par3, final int par4, final int par5, final float par6, final int par7) {
        if (!par1World.field_72995_K) {}
    }
    
    public int func_149745_a(final Random par1Random) {
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
                                if (t < 14000L || t > 22000L) {
                                    return;
                                }
                                if (par1World.field_73012_v.nextInt(65) == 1) {
                                    bid = par1World.func_147439_a(par2, par3 + 1, par4);
                                    if (bid == Blocks.field_150350_a) {
                                        this.func_149642_a(par1World, par2, par3 + 2, par4, new ItemStack(Items.field_151062_by));
                                    }
                                }
                                if (par1World.field_73012_v.nextInt(75) == 1) {
                                    bid = par1World.func_147439_a(par2, par3 - 1, par4);
                                    if (bid == Blocks.field_150350_a) {
                                        final EntityExpBottle var11 = new EntityExpBottle(par1World, (double)par2, (double)(par3 - 1), (double)par4);
                                        var11.func_70012_b((double)par2, (double)(par3 - 1), (double)par4, 0.0f, 0.0f);
                                        var11.func_70186_c((double)((par1World.field_73012_v.nextFloat() - par1World.field_73012_v.nextFloat()) / 2.0f), -0.10000000149011612, (double)((par1World.field_73012_v.nextFloat() - par1World.field_73012_v.nextFloat()) / 2.0f), 0.4f, 5.0f);
                                        par1World.func_72838_d((Entity)var11);
                                    }
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
        long t = par1World.func_72820_D();
        t %= 24000L;
        if (t < 13000L || t > 23000L) {
            return;
        }
        int rate = 0;
        if (t < 14000L) {
            rate = (14000 - (int)t) / 2;
        }
        if (t > 22000L) {
            rate = (int)(t - 22000L) / 2;
        }
        if (par1World.field_73012_v.nextInt(200 + rate) == 1) {
            final Block bid = par1World.func_147439_a(par2, par3 + 1, par4);
            if (bid == Blocks.field_150350_a) {
                for (int i = 0; i < 10; ++i) {
                    par1World.func_72869_a("fireworksSpark", (double)par2, par3 + 1.25, (double)par4, par1World.field_73012_v.nextGaussian(), Math.abs(par1World.field_73012_v.nextGaussian()), par1World.field_73012_v.nextGaussian());
                }
            }
        }
        if (par1World.field_73012_v.nextInt(40 + rate) == 1) {
            final Block bid = par1World.func_147439_a(par2, par3 - 1, par4);
            if (bid == Blocks.field_150350_a) {
                for (int i = 0; i < 4; ++i) {
                    par1World.func_72869_a("fireworksSpark", (double)par2, par3 - 1.25, (double)par4, (double)(par1World.field_73012_v.nextFloat() - par1World.field_73012_v.nextFloat()), (double)(-Math.abs(par1World.field_73012_v.nextFloat())), (double)(par1World.field_73012_v.nextFloat() - par1World.field_73012_v.nextFloat()));
                }
            }
        }
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
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon func_149691_a(final int par1, final int par2) {
        if (OreSpawnMain.FastGraphicsLeaves != 0) {
            return this.generic_solid;
        }
        return this.field_149761_L;
    }
    
    public String[] func_150125_e() {
        return null;
    }
}

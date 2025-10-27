// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.IBlockAccess;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.IIcon;
import net.minecraft.block.BlockGrass;

public class AntBlock extends BlockGrass
{
    @SideOnly(Side.CLIENT)
    private IIcon[] field_94364_a;
    
    protected AntBlock(final int par1) {
        this.func_149675_a(true);
        this.func_149647_a(CreativeTabs.field_78030_b);
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon func_149691_a(final int par1, final int par2) {
        if (this.field_94364_a == null) {
            return null;
        }
        return (par1 == 1) ? this.field_94364_a[0] : ((par1 == 0) ? this.field_94364_a[1] : this.field_94364_a[2]);
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon func_149673_e(final IBlockAccess par1IBlockAccess, final int par2, final int par3, final int par4, final int par5) {
        if (this.field_94364_a == null) {
            return null;
        }
        if (par5 == 1) {
            return this.field_94364_a[0];
        }
        if (par5 == 0) {
            return this.field_94364_a[1];
        }
        return this.field_94364_a[2];
    }
    
    public void func_149674_a(final World par1World, final int par2, final int par3, final int par4, final Random par5Random) {
        int howmany = 0;
        if (!par1World.field_72995_K) {
            if (par1World.func_72896_J()) {
                return;
            }
            final Block bid = par1World.func_147439_a(par2, par3 + 1, par4);
            if (bid == Blocks.field_150350_a) {
                howmany = OreSpawnMain.OreSpawnRand.nextInt(6) + 2;
                for (int i = 0; i < howmany; ++i) {
                    if (this == OreSpawnMain.MyAntBlock) {
                        if (OreSpawnMain.BlackAntEnable != 0) {
                            spawnCreature(par1World, "Ant", par2 + 0.5, par3 + 1.01, par4 + 0.5);
                        }
                    }
                    else if (this == OreSpawnMain.MyRedAntBlock) {
                        if (OreSpawnMain.RedAntEnable != 0) {
                            spawnCreature(par1World, "Red Ant", par2 + 0.5, par3 + 1.01, par4 + 0.5);
                        }
                    }
                    else if (this == OreSpawnMain.MyUnstableAntBlock) {
                        if (OreSpawnMain.UnstableAntEnable != 0) {
                            spawnCreature(par1World, "Unstable Ant", par2 + 0.5, par3 + 1.01, par4 + 0.5);
                        }
                    }
                    else if (this == OreSpawnMain.TermiteBlock) {
                        if (OreSpawnMain.TermiteEnable != 0) {
                            spawnCreature(par1World, "Termite", par2 + 0.5, par3 + 1.01, par4 + 0.5);
                        }
                    }
                    else if (OreSpawnMain.RainbowAntEnable != 0) {
                        spawnCreature(par1World, "Rainbow Ant", par2 + 0.5, par3 + 1.01, par4 + 0.5);
                    }
                }
            }
        }
    }
    
    public Item func_149650_a(final int par1, final Random par2Random, final int par3) {
        return Item.func_150898_a((Block)this);
    }
    
    public static Entity spawnCreature(final World par0World, final String par1, final double par2, final double par4, final double par6) {
        Entity var8 = null;
        var8 = EntityList.func_75620_a(par1, par0World);
        if (var8 != null) {
            var8.func_70012_b(par2, par4, par6, par0World.field_73012_v.nextFloat() * 360.0f, 0.0f);
            par0World.func_72838_d(var8);
            ((EntityLiving)var8).func_70642_aH();
        }
        return var8;
    }
    
    @SideOnly(Side.CLIENT)
    public int func_149635_D() {
        final double var1 = 0.5;
        final double var2 = 1.0;
        return ColorizerGrass.func_77480_a(var1, var2);
    }
    
    @SideOnly(Side.CLIENT)
    public int func_149741_i(final int par1) {
        return this.func_149635_D();
    }
    
    @SideOnly(Side.CLIENT)
    public int func_149720_d(final IBlockAccess p_149720_1_, final int p_149720_2_, final int p_149720_3_, final int p_149720_4_) {
        int l = 0;
        int i1 = 0;
        int j1 = 0;
        for (int k1 = -1; k1 <= 1; ++k1) {
            for (int l2 = -1; l2 <= 1; ++l2) {
                final int i2 = p_149720_1_.func_72807_a(p_149720_2_ + l2, p_149720_4_ + k1).func_150558_b(p_149720_2_ + l2, p_149720_3_, p_149720_4_ + k1);
                l += (i2 & 0xFF0000) >> 16;
                i1 += (i2 & 0xFF00) >> 8;
                j1 += (i2 & 0xFF);
            }
        }
        return (l / 9 & 0xFF) << 16 | (i1 / 9 & 0xFF) << 8 | (j1 / 9 & 0xFF);
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149651_a(final IIconRegister par1IIconRegister) {
        (this.field_94364_a = new IIcon[3])[0] = par1IIconRegister.func_94245_a("OreSpawn:antnest_top");
        this.field_94364_a[1] = par1IIconRegister.func_94245_a("OreSpawn:antnest_bottom");
        this.field_94364_a[2] = par1IIconRegister.func_94245_a("OreSpawn:antnest_side");
    }
}

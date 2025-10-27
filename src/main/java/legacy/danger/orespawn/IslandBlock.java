// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.BlockReed;

public class IslandBlock extends BlockReed
{
    protected IslandBlock(final int par1) {
        final float var3 = 0.375f;
        this.func_149676_a(0.5f - var3, 0.0f, 0.5f - var3, 0.5f + var3, 1.0f, 0.5f + var3);
        this.func_149675_a(true);
        this.func_149647_a(CreativeTabs.field_78031_c);
    }
    
    public boolean func_149742_c(final World par1World, final int par2, final int par3, final int par4) {
        return par1World.func_147439_a(par2, par3 - 1, par4).func_149688_o().func_76220_a();
    }
    
    public void func_149734_b(final World par1World, final int par2, final int par3, final int par4, final Random par5Random) {
        if (par1World.field_73012_v.nextInt(20) != 1) {
            return;
        }
        for (int j1 = 0; j1 < 20; ++j1) {
            par1World.func_72869_a("happyVillager", (double)(par2 + par1World.field_73012_v.nextFloat()), par3 + (double)par1World.field_73012_v.nextFloat(), (double)(par4 + par1World.field_73012_v.nextFloat()), 0.0, 0.0, 0.0);
        }
    }
    
    public void func_149674_a(final World par1World, final int par2, final int par3, final int par4, final Random par5Random) {
        int isok = 1;
        if (par1World.field_72995_K) {
            return;
        }
        final int n = 1 + par1World.field_73012_v.nextInt(3);
        int m = 64;
        if (OreSpawnMain.IslandSizeFactor == 2) {
            m = 55;
        }
        if (OreSpawnMain.IslandSizeFactor == 1) {
            m = 45;
        }
        for (int i = 0; i < n; ++i) {
            final int height = 12 + par1World.field_73012_v.nextInt(m);
            isok = 1;
            for (int k = -10; k <= 10; ++k) {
                for (int j = -10; j <= 10; ++j) {
                    final Block bid = par1World.func_147439_a(par2 + j, par3 + height, par4 + k);
                    if (bid != Blocks.field_150350_a) {
                        isok = 0;
                        break;
                    }
                }
            }
            if (isok != 0) {
                if (par1World.field_73012_v.nextInt(25) == 1) {
                    spawnCreature(par1World, "Island", par2, par3 + height, par4);
                }
                else {
                    spawnCreature(par1World, "IslandToo", par2, par3 + height, par4);
                }
            }
        }
        par1World.func_147465_d(par2, par3, par4, Blocks.field_150350_a, 0, 2);
        par1World.func_147465_d(par2, par3 + 1, par4, Blocks.field_150350_a, 0, 2);
    }
    
    public Item func_149650_a(final int par1, final Random par2Random, final int par3) {
        return Item.func_150898_a(OreSpawnMain.MyIslandBlock);
    }
    
    public int func_149745_a(final Random par1Random) {
        return 1;
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
    public void func_149651_a(final IIconRegister iconRegister) {
        this.field_149761_L = iconRegister.func_94245_a("OreSpawn:" + this.func_149739_a().substring(5));
    }
}

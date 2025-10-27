// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.Entity;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import java.util.Random;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.IIcon;
import net.minecraft.block.BlockCrops;

public class BlockMosquitoPlant extends BlockCrops
{
    @SideOnly(Side.CLIENT)
    private IIcon[] field_94364_a;
    
    public BlockMosquitoPlant(final int par1) {
        this.func_149675_a(true);
    }
    
    public void func_149674_a(final World par1World, final int par2, final int par3, final int par4, final Random par5Random) {
        super.func_149674_a(par1World, par2, par3, par4, par5Random);
        if (par1World.field_72995_K) {
            return;
        }
        if (OreSpawnMain.MosquitoEnable == 0) {
            return;
        }
        int rate = par1World.func_72805_g(par2, par3, par4);
        rate &= 0x7;
        rate = 7 - rate;
        if (rate > 1 && OreSpawnMain.OreSpawnRand.nextInt(rate) != 0) {
            return;
        }
        final Block bid = par1World.func_147439_a(par2, par3 + 1, par4);
        if (bid == Blocks.field_150350_a) {
            for (int howmany = 2 + OreSpawnMain.OreSpawnRand.nextInt(5), i = 0; i < howmany; ++i) {
                spawnCreature(par1World, "Mosquito", par2 + 0.5, par3 + 1.01, par4 + 0.5);
            }
        }
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
    
    public IIcon func_149691_a(final int par1, int par2) {
        if (par2 < 7) {
            if (par2 >= 6) {
                par2 = 4;
            }
            return this.field_94364_a[par2 >> 1];
        }
        return this.field_94364_a[3];
    }
    
    public int func_149745_a(final Random par1Random) {
        return 1 + par1Random.nextInt(5);
    }
    
    protected Item func_149866_i() {
        return OreSpawnMain.MyMosquitoSeed;
    }
    
    protected Item func_149865_P() {
        return null;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149651_a(final IIconRegister par1IIconRegister) {
        this.field_94364_a = new IIcon[4];
        for (int i = 0; i < this.field_94364_a.length; ++i) {
            this.field_94364_a[i] = par1IIconRegister.func_94245_a("OreSpawn:mosquito_" + i);
        }
    }
}

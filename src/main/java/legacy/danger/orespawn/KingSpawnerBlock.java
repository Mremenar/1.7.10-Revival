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
import net.minecraft.init.Blocks;
import net.minecraft.block.Block;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.BlockReed;

public class KingSpawnerBlock extends BlockReed
{
    protected KingSpawnerBlock(final int par1) {
        final float var3 = 0.375f;
        this.func_149676_a(0.5f - var3, 0.0f, 0.5f - var3, 0.5f + var3, 1.0f, 0.5f + var3);
        this.func_149675_a(true);
        this.func_149647_a(CreativeTabs.field_78031_c);
    }
    
    public boolean func_149742_c(final World par1World, final int par2, final int par3, final int par4) {
        return par1World.func_147439_a(par2, par3 - 1, par4).func_149688_o().func_76220_a();
    }
    
    public void func_149734_b(final World par1World, final int par2, final int par3, final int par4, final Random par5Random) {
        if (!par1World.field_72995_K) {
            this.func_149674_a(par1World, par2, par3, par4, par5Random);
            return;
        }
        if (par1World.field_73012_v.nextInt(20) != 1) {
            return;
        }
        for (int j1 = 0; j1 < 20; ++j1) {
            par1World.func_72869_a("fireworksSpark", (double)(par2 + par1World.field_73012_v.nextFloat()), par3 + (double)par1World.field_73012_v.nextFloat(), (double)(par4 + par1World.field_73012_v.nextFloat()), 0.0, 0.0, 0.0);
        }
    }
    
    public void func_149726_b(final World world, final int x, final int y, final int z) {
        if (world.field_72995_K) {
            return;
        }
        world.func_147464_a(x, y, z, (Block)this, 100);
    }
    
    public void func_149664_b(final World par1World, final int par2, final int par3, final int par4, final int par5) {
        this.func_149674_a(par1World, par2, par3, par4, null);
    }
    
    public void func_149674_a(final World par1World, final int par2, final int par3, final int par4, final Random par5Random) {
        if (par1World.field_72995_K) {
            return;
        }
        if (OreSpawnMain.TheKingEnable != 0) {
            spawnTheKing(par1World, par2, par3 + 8, par4);
        }
        par1World.func_147465_d(par2, par3, par4, Blocks.field_150350_a, 0, 2);
        par1World.func_147465_d(par2, par3 + 1, par4, Blocks.field_150350_a, 0, 2);
    }
    
    public Item func_149650_a(final int par1, final Random par2Random, final int par3) {
        return Item.func_150898_a(OreSpawnMain.MyKingSpawnerBlock);
    }
    
    public int func_149745_a(final Random par1Random) {
        return 1;
    }
    
    public static Entity spawnTheKing(final World par0World, final double par2, final double par4, final double par6) {
        Entity var8 = null;
        var8 = EntityList.func_75620_a("The King", par0World);
        if (var8 != null) {
            var8.func_70012_b(par2, par4, par6, par0World.field_73012_v.nextFloat() * 360.0f, 0.0f);
            par0World.func_72838_d(var8);
            ((EntityLiving)var8).func_70642_aH();
            ((TheKing)var8).setGuardMode(1);
        }
        return var8;
    }
    
    public boolean func_149718_j(final World par1World, final int par2, final int par3, final int par4) {
        this.func_149674_a(par1World, par2, par3, par4, null);
        return true;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149651_a(final IIconRegister iconRegister) {
        this.field_149761_L = iconRegister.func_94245_a("OreSpawn:" + this.func_149739_a().substring(5));
    }
}

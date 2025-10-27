// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.EntityLivingBase;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.BlockTorch;

public class BlockExtremeTorch extends BlockTorch
{
    public BlockExtremeTorch(final int par1) {
        this.func_149647_a(CreativeTabs.field_78028_d);
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149734_b(final World par1World, final int par2, final int par3, final int par4, final Random par5Random) {
        final int var6 = par1World.func_72805_g(par2, par3, par4);
        final double var7 = par2 + 0.5f;
        final double var8 = par3 + 0.7f;
        final double var9 = par4 + 0.5f;
        final double var10 = 0.213;
        final double var11 = 0.271;
        if (var6 == 1) {
            par1World.func_72869_a("smoke", var7 - var11, var8 + var10, var9, 0.0, 0.0, 0.0);
            par1World.func_72869_a("flame", var7 - var11, var8 + var10, var9, 0.0, 0.0, 0.0);
            par1World.func_72869_a("reddust", var7 - var11, var8 + var10, var9, 0.0, 0.0, 0.0);
        }
        else if (var6 == 2) {
            par1World.func_72869_a("smoke", var7 + var11, var8 + var10, var9, 0.0, 0.0, 0.0);
            par1World.func_72869_a("flame", var7 + var11, var8 + var10, var9, 0.0, 0.0, 0.0);
            par1World.func_72869_a("reddust", var7 + var11, var8 + var10, var9, 0.0, 0.0, 0.0);
        }
        else if (var6 == 3) {
            par1World.func_72869_a("smoke", var7, var8 + var10, var9 - var11, 0.0, 0.0, 0.0);
            par1World.func_72869_a("flame", var7, var8 + var10, var9 - var11, 0.0, 0.0, 0.0);
            par1World.func_72869_a("reddust", var7, var8 + var10, var9 - var11, 0.0, 0.0, 0.0);
        }
        else if (var6 == 4) {
            par1World.func_72869_a("smoke", var7, var8 + var10, var9 + var11, 0.0, 0.0, 0.0);
            par1World.func_72869_a("flame", var7, var8 + var10, var9 + var11, 0.0, 0.0, 0.0);
            par1World.func_72869_a("reddust", var7, var8 + var10, var9 + var11, 0.0, 0.0, 0.0);
        }
        else {
            par1World.func_72869_a("smoke", var7, var8, var9, 0.0, 0.0, 0.0);
            par1World.func_72869_a("flame", var7, var8, var9, 0.0, 0.0, 0.0);
            par1World.func_72869_a("reddust", var7, var8, var9, 0.0, 0.0, 0.0);
        }
        this.func_149689_a(par1World, par2, par3, par4, null, null);
    }
    
    public boolean func_149742_c(final World par1World, final int par2, final int par3, final int par4) {
        return super.func_149742_c(par1World, par2, par3, par4);
    }
    
    public void func_149689_a(final World world, final int par2, final int par3, final int par4, final EntityLivingBase par5EntityLiving, final ItemStack par6ItemStack) {
        int x = par2;
        int y = par3;
        int z = par4;
        int found = 0;
        if (world.func_147439_a(x, y - 1, z) == OreSpawnMain.MyEyeOfEnderBlock) {
            for (int tries = 0; tries < 100 && found == 0; ++tries) {
                if (world.field_73012_v.nextInt(2) == 0) {
                    x = par2 + 4 + world.field_73012_v.nextInt(3) - world.field_73012_v.nextInt(3);
                }
                else {
                    x = par2 - 4 + world.field_73012_v.nextInt(3) - world.field_73012_v.nextInt(3);
                }
                if (world.field_73012_v.nextInt(2) == 0) {
                    z = par4 + 4 + world.field_73012_v.nextInt(3) - world.field_73012_v.nextInt(3);
                }
                else {
                    z = par4 - 4 + world.field_73012_v.nextInt(3) - world.field_73012_v.nextInt(3);
                }
                for (y = par3 - 2; y <= par3 + 2; ++y) {
                    if (world.func_147439_a(x, y - 1, z).func_149688_o().func_76220_a() && world.func_147439_a(x, y, z) == Blocks.field_150350_a && world.func_147439_a(x, y + 1, z) == Blocks.field_150350_a) {
                        found = 1;
                        break;
                    }
                }
            }
            if (found != 0) {
                if (!world.field_72995_K) {
                    Entity ent = null;
                    ent = spawnCreature(world, "Cephadrome", x + 0.5, y + 0.01, z + 0.5);
                }
                else {
                    for (int var3 = 0; var3 < 16; ++var3) {
                        world.func_72869_a("smoke", (double)(par2 + world.field_73012_v.nextFloat() - world.field_73012_v.nextFloat()), (double)(par3 + world.field_73012_v.nextFloat()), (double)(par4 + world.field_73012_v.nextFloat() - world.field_73012_v.nextFloat()), 0.0, 0.0, 0.0);
                        world.func_72869_a("explode", (double)(par2 + world.field_73012_v.nextFloat() - world.field_73012_v.nextFloat()), (double)(par3 + world.field_73012_v.nextFloat()), (double)(par4 + world.field_73012_v.nextFloat() - world.field_73012_v.nextFloat()), 0.0, 0.0, 0.0);
                        world.func_72869_a("reddust", (double)(par2 + world.field_73012_v.nextFloat() - world.field_73012_v.nextFloat()), (double)(par3 + world.field_73012_v.nextFloat()), (double)(par4 + world.field_73012_v.nextFloat() - world.field_73012_v.nextFloat()), 0.0, 0.0, 0.0);
                    }
                }
                if (par5EntityLiving != null) {
                    par5EntityLiving.field_70170_p.func_72956_a((Entity)par5EntityLiving, "random.explode", 1.0f, world.field_73012_v.nextFloat() * 0.2f + 0.9f);
                }
                else {
                    world.func_72980_b((double)par2, (double)par3, (double)par4, "random.explode", 1.0f, world.field_73012_v.nextFloat() * 0.2f + 0.9f, false);
                }
                world.func_147449_b(par2, par3, par4, Blocks.field_150350_a);
            }
        }
        super.func_149689_a(world, par2, par3, par4, par5EntityLiving, par6ItemStack);
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

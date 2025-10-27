// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.block.BlockReed;

public class BlockExperiencePlant extends BlockReed
{
    protected BlockExperiencePlant(final int par1) {
        final float var3 = 0.375f;
        this.func_149676_a(0.5f - var3, 0.0f, 0.5f - var3, 0.5f + var3, 1.0f, 0.5f + var3);
        this.func_149675_a(true);
    }
    
    public boolean func_149742_c(final World par1World, final int par2, final int par3, final int par4) {
        final Block bid = par1World.func_147439_a(par2, par3 - 1, par4);
        return bid != Blocks.field_150350_a && (bid == Blocks.field_150349_c || bid == Blocks.field_150346_d || bid == Blocks.field_150458_ak);
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
        if (par1World.field_72995_K) {
            return;
        }
        if (par1World.field_73012_v.nextInt(10) != 1) {
            return;
        }
        par1World.func_147465_d(par2, par3, par4, Blocks.field_150350_a, 0, 2);
        OreSpawnMain.OreSpawnTrees.ExperienceTree(par1World, par2, par3 - 1, par4);
    }
    
    public Item func_149650_a(final int p_149650_1_, final Random p_149650_2_, final int p_149650_3_) {
        return Item.func_150898_a(OreSpawnMain.MyExperiencePlant);
    }
    
    public int func_149745_a(final Random par1Random) {
        return 1;
    }
    
    public int idPicked(final World par1World, final int par2, final int par3, final int par4) {
        return 0;
    }
    
    protected Item getSeedItem() {
        return OreSpawnMain.MyExperienceTreeSeed;
    }
    
    protected int getCropItem() {
        return 0;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149651_a(final IIconRegister iconRegister) {
        this.field_149761_L = iconRegister.func_94245_a("OreSpawn:" + this.func_149739_a().substring(5));
    }
}

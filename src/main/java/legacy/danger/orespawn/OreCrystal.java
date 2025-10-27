// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;

public class OreCrystal extends Block
{
    public OreCrystal(final int par1, final float lv, final float f1, final float f2) {
        super(Material.field_151576_e);
        this.func_149711_c(f1);
        this.func_149752_b(f2);
        this.func_149647_a(CreativeTabs.field_78030_b);
        this.func_149715_a(lv);
        this.func_149675_a(true);
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149734_b(final World par1World, final int par2, final int par3, final int par4, final Random par5Random) {
        if (par1World.field_73012_v.nextInt(5) == 0) {
            this.sparkle(par1World, par2, par3, par4);
        }
    }
    
    private void sparkle(final World par1World, final int par2, final int par3, final int par4) {
        int which = 0;
        final float dx = 0.5f;
        final float dz = 0.5f;
        final float dy = 0.5f;
        for (int j1 = 0; j1 < 5; ++j1) {
            which = par1World.field_73012_v.nextInt(3);
            if (which == 0) {
                par1World.func_72869_a("flame", (double)(par2 + dx), par3 + (double)dy, (double)(par4 + dz), (double)((par1World.field_73012_v.nextFloat() - par1World.field_73012_v.nextFloat()) / 4.0f), (double)((par1World.field_73012_v.nextFloat() - par1World.field_73012_v.nextFloat()) / 4.0f), (double)((par1World.field_73012_v.nextFloat() - par1World.field_73012_v.nextFloat()) / 4.0f));
            }
            if (which == 1) {
                par1World.func_72869_a("smoke", (double)(par2 + dx), par3 + (double)dy, (double)(par4 + dz), (double)((par1World.field_73012_v.nextFloat() - par1World.field_73012_v.nextFloat()) / 4.0f), (double)((par1World.field_73012_v.nextFloat() - par1World.field_73012_v.nextFloat()) / 4.0f), (double)((par1World.field_73012_v.nextFloat() - par1World.field_73012_v.nextFloat()) / 4.0f));
            }
            if (which == 2) {
                par1World.func_72869_a("reddust", (double)(par2 + dx), par3 + (double)dy, (double)(par4 + dz), (double)((par1World.field_73012_v.nextFloat() - par1World.field_73012_v.nextFloat()) / 4.0f), (double)((par1World.field_73012_v.nextFloat() - par1World.field_73012_v.nextFloat()) / 4.0f), (double)((par1World.field_73012_v.nextFloat() - par1World.field_73012_v.nextFloat()) / 4.0f));
            }
        }
    }
    
    public int func_149645_b() {
        return 1;
    }
    
    public boolean func_149662_c() {
        return false;
    }
    
    public boolean func_149686_d() {
        return false;
    }
    
    public void func_149664_b(final World par1World, final int par2, final int par3, final int par4, final int par5) {
        if (!par1World.field_72995_K && par1World.field_73012_v.nextInt(3) == 1) {
            par1World.func_72885_a((Entity)null, (double)(par2 + 0.5f), (double)(par3 + 0.5f), (double)(par4 + 0.5f), 1.5f, true, par1World.func_82736_K().func_82766_b("mobGriefing"));
        }
        super.func_149664_b(par1World, par2, par3, par4, par5);
    }
    
    public void func_149690_a(final World par1World, final int par2, final int par3, final int par4, final int par5, final float par6, final int par7) {
        super.func_149690_a(par1World, par2, par3, par4, par5, par6, par7);
        final int j1 = 5 + par1World.field_73012_v.nextInt(5) + par1World.field_73012_v.nextInt(10);
        if (par3 < 40) {
            this.func_149657_c(par1World, par2, par3, par4, j1);
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149651_a(final IIconRegister iconRegister) {
        this.field_149761_L = iconRegister.func_94245_a("OreSpawn:" + this.func_149739_a().substring(5));
    }
}

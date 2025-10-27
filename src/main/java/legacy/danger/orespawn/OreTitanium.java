// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.client.renderer.texture.IIconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;

public class OreTitanium extends Block
{
    private boolean glowing;
    private int glowcount;
    
    public OreTitanium(final int par1) {
        super(Material.field_151576_e);
        this.glowing = false;
        this.glowcount = 0;
        this.func_149711_c(15.0f);
        this.func_149752_b(5.0f);
        this.func_149647_a(CreativeTabs.field_78030_b);
        this.func_149675_a(true);
        this.glowing = false;
    }
    
    public int tickRate() {
        return 30;
    }
    
    public void func_149699_a(final World par1World, final int par2, final int par3, final int par4, final EntityPlayer par5EntityPlayer) {
        this.glow(par1World, par2, par3, par4);
        super.func_149699_a(par1World, par2, par3, par4, par5EntityPlayer);
    }
    
    public void func_149724_b(final World par1World, final int par2, final int par3, final int par4, final Entity par5Entity) {
        this.glow(par1World, par2, par3, par4);
        super.func_149724_b(par1World, par2, par3, par4, par5Entity);
    }
    
    public boolean func_149727_a(final World par1World, final int par2, final int par3, final int par4, final EntityPlayer par5EntityPlayer, final int par6, final float par7, final float par8, final float par9) {
        this.glow(par1World, par2, par3, par4);
        return super.func_149727_a(par1World, par2, par3, par4, par5EntityPlayer, par6, par7, par8, par9);
    }
    
    private void glow(final World par1World, final int par2, final int par3, final int par4) {
        this.glowing = true;
        this.glowcount = 5;
        this.sparkle(par1World, par2, par3, par4);
    }
    
    public void func_149674_a(final World par1World, final int par2, final int par3, final int par4, final Random par5Random) {
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149734_b(final World par1World, final int par2, final int par3, final int par4, final Random par5Random) {
        if (this.glowing) {
            this.sparkle(par1World, par2, par3, par4);
            if (this.glowcount > 0) {
                --this.glowcount;
            }
            else {
                this.glowing = false;
            }
        }
    }
    
    private void sparkle(final World par1World, final int par2, final int par3, final int par4) {
        final Random var5 = par1World.field_73012_v;
        final double var6 = 0.0625;
        for (int var7 = 0; var7 < 6; ++var7) {
            double var8 = par2 + var5.nextFloat();
            double var9 = par3 + var5.nextFloat();
            double var10 = par4 + var5.nextFloat();
            if (var7 == 0 && !par1World.func_147439_a(par2, par3 + 1, par4).func_149662_c()) {
                var9 = par3 + 1 + var6;
            }
            if (var7 == 1 && !par1World.func_147439_a(par2, par3 - 1, par4).func_149662_c()) {
                var9 = par3 + 0 - var6;
            }
            if (var7 == 2 && !par1World.func_147439_a(par2, par3, par4 + 1).func_149662_c()) {
                var10 = par4 + 1 + var6;
            }
            if (var7 == 3 && !par1World.func_147439_a(par2, par3, par4 - 1).func_149662_c()) {
                var10 = par4 + 0 - var6;
            }
            if (var7 == 4 && !par1World.func_147439_a(par2 + 1, par3, par4).func_149662_c()) {
                var8 = par2 + 1 + var6;
            }
            if (var7 == 5 && !par1World.func_147439_a(par2 - 1, par3, par4).func_149662_c()) {
                var8 = par2 + 0 - var6;
            }
            if (var8 < par2 || var8 > par2 + 1 || var9 < 0.0 || var9 > par3 + 1 || var10 < par4 || var10 > par4 + 1) {
                par1World.func_72869_a("reddust", var8, var9, var10, 0.0, 0.0, 0.0);
            }
        }
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

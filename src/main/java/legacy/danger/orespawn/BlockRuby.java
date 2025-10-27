// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.Potion;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;

public class BlockRuby extends Block
{
    public BlockRuby(final int par1) {
        super(Material.field_151576_e);
        this.func_149711_c(4.0f);
        this.func_149752_b(4.0f);
        this.func_149647_a(CreativeTabs.field_78030_b);
        this.func_149715_a(0.4f);
    }
    
    public boolean func_149662_c() {
        return false;
    }
    
    public boolean func_149686_d() {
        return true;
    }
    
    public void func_149670_a(final World par1World, final int par2, final int par3, final int par4, final Entity par5Entity) {
        if (this == OreSpawnMain.MyBlockMobzillaScaleBlock && par5Entity instanceof EntityLivingBase) {
            ((EntityLivingBase)par5Entity).func_70690_d(new PotionEffect(Potion.field_76420_g.field_76415_H, 200, 0));
        }
    }
    
    public void func_149724_b(final World par1World, final int par2, final int par3, final int par4, final Entity par5Entity) {
        if (this == OreSpawnMain.MyBlockMobzillaScaleBlock && par5Entity instanceof EntityLivingBase) {
            ((EntityLivingBase)par5Entity).func_70690_d(new PotionEffect(Potion.field_76420_g.field_76415_H, 200, 0));
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149651_a(final IIconRegister iconRegister) {
        this.field_149761_L = iconRegister.func_94245_a("OreSpawn:" + this.func_149739_a().substring(5));
    }
}

// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;

public class OreSalt extends Block
{
    public OreSalt(final int par1) {
        super(Material.field_151576_e);
        this.func_149711_c(5.0f);
        this.func_149752_b(2.0f);
        this.func_149647_a(CreativeTabs.field_78030_b);
    }
    
    public void func_149670_a(final World par1World, final int par2, final int par3, final int par4, final Entity par5Entity) {
        if (par5Entity instanceof EntityAnt) {
            par5Entity.func_70097_a(DamageSource.field_76367_g, 5.0f);
        }
    }
    
    public void func_149724_b(final World par1World, final int par2, final int par3, final int par4, final Entity par5Entity) {
        if (par5Entity instanceof EntityAnt) {
            par5Entity.func_70097_a(DamageSource.field_76367_g, 5.0f);
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149651_a(final IIconRegister iconRegister) {
        this.field_149761_L = iconRegister.func_94245_a("OreSpawn:" + this.func_149739_a().substring(5));
    }
}

// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.client.renderer.texture.IIconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.IIcon;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;

public class CrystalWood extends Block
{
    public CrystalWood(final int par1, final float f1, final float f2) {
        super(Material.field_151575_d);
        this.func_149647_a(CreativeTabs.field_78030_b);
        this.func_149675_a(false);
        this.func_149711_c(f1);
        this.func_149752_b(f2);
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon func_149691_a(final int par1, final int par2) {
        return this.field_149761_L;
    }
    
    public boolean func_149662_c() {
        return false;
    }
    
    public boolean func_149686_d() {
        return false;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149651_a(final IIconRegister iconRegister) {
        this.field_149761_L = iconRegister.func_94245_a("OreSpawn:" + this.func_149739_a().substring(5));
    }
}

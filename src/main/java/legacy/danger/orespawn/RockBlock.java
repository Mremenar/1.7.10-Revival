// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;

public class RockBlock extends Block
{
    public RockBlock(final int par1) {
        super(Material.field_151576_e);
        this.func_149711_c(2.0f);
        this.func_149752_b(1.0f);
        this.func_149647_a(CreativeTabs.field_78030_b);
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149651_a(final IIconRegister iconRegister) {
        this.field_149761_L = iconRegister.func_94245_a("OreSpawn:" + this.func_149739_a().substring(5));
    }
}

// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.world.World;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;

public class OreGenericEgg extends Block
{
    public OreGenericEgg(final int oldid) {
        super(Material.field_151578_c);
        this.func_149711_c(0.5f);
        this.func_149752_b(1.0f);
        this.func_149672_a(Block.field_149767_g);
        this.func_149647_a(CreativeTabs.field_78030_b);
    }
    
    public void func_149690_a(final World par1World, final int par2, final int par3, final int par4, final int par5, final float par6, final int par7) {
        super.func_149690_a(par1World, par2, par3, par4, par5, par6, par7);
        final int j1 = 5 + par1World.field_73012_v.nextInt(3) + par1World.field_73012_v.nextInt(3);
        if (par1World.field_73012_v.nextInt(2) == 1) {
            this.func_149657_c(par1World, par2, par3, par4, j1);
        }
    }
    
    public boolean func_149662_c() {
        return true;
    }
    
    public boolean func_149686_d() {
        return true;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149651_a(final IIconRegister iconRegister) {
        this.field_149761_L = iconRegister.func_94245_a("OreSpawn:" + this.func_149739_a().substring(5));
    }
}

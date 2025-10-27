// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;

public class OreAmethyst extends Block
{
    public OreAmethyst(final int i) {
        super(Material.field_151576_e);
        this.func_149711_c(10.0f);
        this.func_149752_b(4.0f);
        this.func_149647_a(CreativeTabs.field_78030_b);
    }
    
    public void func_149690_a(final World par1World, final int par2, final int par3, final int par4, final int par5, final float par6, final int par7) {
        super.func_149690_a(par1World, par2, par3, par4, par5, par6, par7);
        final int j1 = 5 + par1World.field_73012_v.nextInt(5) + par1World.field_73012_v.nextInt(5);
        this.func_149657_c(par1World, par2, par3, par4, j1);
    }
    
    public Item func_149650_a(final int par1, final Random par2Random, final int par3) {
        return OreSpawnMain.MyAmethyst;
    }
    
    public int func_149679_a(final int par1, final Random par2Random) {
        return 1 + par2Random.nextInt(2);
    }
    
    public int func_149745_a(final Random par1Random) {
        return 1;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149651_a(final IIconRegister iconRegister) {
        this.field_149761_L = iconRegister.func_94245_a("OreSpawn:" + this.func_149739_a().substring(5));
    }
}

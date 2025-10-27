// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.IIcon;
import net.minecraft.block.BlockWorkbench;

public class CrystalWorkbench extends BlockWorkbench
{
    @SideOnly(Side.CLIENT)
    private IIcon workbenchIconTop;
    @SideOnly(Side.CLIENT)
    private IIcon workbenchIconFront;
    
    protected CrystalWorkbench(final int par1, final float f1, final float f2) {
        this.func_149647_a(CreativeTabs.field_78031_c);
        this.func_149711_c(f1);
        this.func_149752_b(f2);
    }
    
    public boolean func_149727_a(final World par1World, final int par2, final int par3, final int par4, final EntityPlayer par5EntityPlayer, final int par6, final float par7, final float par8, final float par9) {
        if (par1World.field_72995_K) {
            return true;
        }
        par5EntityPlayer.openGui((Object)OreSpawnMain.instance, 1, par1World, par2, par3, par4);
        return true;
    }
    
    public boolean func_149662_c() {
        return false;
    }
    
    public boolean func_149686_d() {
        return false;
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon func_149691_a(final int par1, final int par2) {
        return (par1 == 1) ? this.workbenchIconTop : ((par1 == 0) ? this.field_149761_L : ((par1 != 2 && par1 != 4) ? this.field_149761_L : this.workbenchIconFront));
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149651_a(final IIconRegister par1IIconRegister) {
        this.field_149761_L = par1IIconRegister.func_94245_a("OreSpawn:" + this.func_149739_a().substring(5) + "_side");
        this.workbenchIconTop = par1IIconRegister.func_94245_a("OreSpawn:" + this.func_149739_a().substring(5) + "_top");
        this.workbenchIconFront = par1IIconRegister.func_94245_a("OreSpawn:" + this.func_149739_a().substring(5) + "_bottom");
    }
}

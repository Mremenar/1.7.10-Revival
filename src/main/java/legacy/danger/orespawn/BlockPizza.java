// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.item.Item;
import java.util.Random;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.material.Material;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.IIcon;
import net.minecraft.block.Block;

public class BlockPizza extends Block
{
    @SideOnly(Side.CLIENT)
    private IIcon pizzaTopIcon;
    @SideOnly(Side.CLIENT)
    private IIcon pizzaBottomIcon;
    @SideOnly(Side.CLIENT)
    private IIcon field_94382_c;
    
    protected BlockPizza(final int par1) {
        super(Material.field_151568_F);
        this.func_149675_a(true);
    }
    
    public void func_149719_a(final IBlockAccess par1IBlockAccess, final int par2, final int par3, final int par4) {
        final int l = par1IBlockAccess.func_72805_g(par2, par3, par4);
        final float f = 0.0625f;
        final float f2 = (1 + l * 2) / 16.0f;
        final float f3 = 0.25f;
        this.func_149676_a(f2, 0.0f, f, 1.0f - f, f3, 1.0f - f);
    }
    
    public void func_149683_g() {
        final float f = 0.0625f;
        final float f2 = 0.25f;
        this.func_149676_a(f, 0.0f, f, 1.0f - f, f2, 1.0f - f);
    }
    
    public AxisAlignedBB func_149668_a(final World par1World, final int par2, final int par3, final int par4) {
        final int l = par1World.func_72805_g(par2, par3, par4);
        final float f = 0.0625f;
        final float f2 = (1 + l * 2) / 16.0f;
        final float f3 = 0.25f;
        return AxisAlignedBB.func_72330_a((double)(par2 + f2), (double)par3, (double)(par4 + f), (double)(par2 + 1 - f), (double)(par3 + f3 - f), (double)(par4 + 1 - f));
    }
    
    public boolean func_149686_d() {
        return false;
    }
    
    @SideOnly(Side.CLIENT)
    public AxisAlignedBB func_149633_g(final World par1World, final int par2, final int par3, final int par4) {
        final int l = par1World.func_72805_g(par2, par3, par4);
        final float f = 0.0625f;
        final float f2 = (1 + l * 2) / 16.0f;
        final float f3 = 0.25f;
        return AxisAlignedBB.func_72330_a((double)(par2 + f2), (double)par3, (double)(par4 + f), (double)(par2 + 1 - f), (double)(par3 + f3), (double)(par4 + 1 - f));
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon func_149691_a(final int par1, final int par2) {
        return (par1 == 1) ? this.pizzaTopIcon : ((par1 == 0) ? this.pizzaBottomIcon : ((par2 > 0 && par1 == 4) ? this.field_94382_c : this.field_149761_L));
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149651_a(final IIconRegister par1IIconRegister) {
        this.field_149761_L = par1IIconRegister.func_94245_a("OreSpawn:" + this.func_149739_a().substring(5) + "_side");
        this.field_94382_c = par1IIconRegister.func_94245_a("OreSpawn:" + this.func_149739_a().substring(5) + "_inner");
        this.pizzaTopIcon = par1IIconRegister.func_94245_a("OreSpawn:" + this.func_149739_a().substring(5) + "_top");
        this.pizzaBottomIcon = par1IIconRegister.func_94245_a("OreSpawn:" + this.func_149739_a().substring(5) + "_bottom");
    }
    
    public boolean func_149662_c() {
        return false;
    }
    
    public boolean func_149727_a(final World par1World, final int par2, final int par3, final int par4, final EntityPlayer par5EntityPlayer, final int par6, final float par7, final float par8, final float par9) {
        this.eatPizzaSlice(par1World, par2, par3, par4, par5EntityPlayer);
        return true;
    }
    
    public void func_149699_a(final World par1World, final int par2, final int par3, final int par4, final EntityPlayer par5EntityPlayer) {
        this.eatPizzaSlice(par1World, par2, par3, par4, par5EntityPlayer);
    }
    
    private void eatPizzaSlice(final World par1World, final int par2, final int par3, final int par4, final EntityPlayer par5EntityPlayer) {
        if (par5EntityPlayer.func_71043_e(false)) {
            par5EntityPlayer.func_71024_bL().func_75122_a(4, 0.2f);
            final int l = par1World.func_72805_g(par2, par3, par4) + 1;
            if (l >= 6) {
                par1World.func_147468_f(par2, par3, par4);
            }
            else {
                par1World.func_72921_c(par2, par3, par4, l, 2);
            }
        }
    }
    
    public boolean func_149742_c(final World par1World, final int par2, final int par3, final int par4) {
        return super.func_149742_c(par1World, par2, par3, par4) && this.func_149718_j(par1World, par2, par3, par4);
    }
    
    public void onNeighborBlockChange(final World par1World, final int par2, final int par3, final int par4, final int par5) {
        if (!this.func_149718_j(par1World, par2, par3, par4)) {
            par1World.func_147468_f(par2, par3, par4);
        }
    }
    
    public boolean func_149718_j(final World par1World, final int par2, final int par3, final int par4) {
        return par1World.func_147439_a(par2, par3 - 1, par4).func_149721_r();
    }
    
    public int func_149745_a(final Random par1Random) {
        return 0;
    }
    
    public Item func_149650_a(final int par1, final Random par2Random, final int par3) {
        return OreSpawnMain.MyPizzaItem;
    }
}

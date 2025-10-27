// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.client.renderer.texture.IIconRegister;
import java.util.Random;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.IIcon;
import net.minecraft.block.BlockRotatedPillar;

public class BlockCrystalTreeLog extends BlockRotatedPillar
{
    @SideOnly(Side.CLIENT)
    private IIcon field_111052_c;
    @SideOnly(Side.CLIENT)
    private IIcon tree_top;
    
    protected BlockCrystalTreeLog(final int par1, final int par2) {
        super(Material.field_151575_d);
        this.func_149647_a(CreativeTabs.field_78030_b);
    }
    
    protected ItemStack func_149644_j(final int par1) {
        return new ItemStack(Item.func_150898_a((Block)this), 1, 0);
    }
    
    public boolean canSustainLeaves(final IBlockAccess world, final int x, final int y, final int z) {
        return true;
    }
    
    public boolean isWood(final IBlockAccess world, final int x, final int y, final int z) {
        return true;
    }
    
    public boolean func_149662_c() {
        return false;
    }
    
    public boolean func_149686_d() {
        return false;
    }
    
    public Item func_149650_a(final int p_149650_1_, final Random p_149650_2_, final int p_149650_3_) {
        return Item.func_150898_a(OreSpawnMain.MyCrystalTreeLog);
    }
    
    @SideOnly(Side.CLIENT)
    protected IIcon func_150163_b(final int par1) {
        return this.field_111052_c;
    }
    
    @SideOnly(Side.CLIENT)
    protected IIcon func_150161_d(final int par1) {
        return this.tree_top;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149651_a(final IIconRegister iconRegister) {
        this.field_111052_c = iconRegister.func_94245_a("OreSpawn:" + this.func_149739_a().substring(5));
        this.tree_top = iconRegister.func_94245_a("OreSpawn:" + this.func_149739_a().substring(5) + "_top");
    }
}

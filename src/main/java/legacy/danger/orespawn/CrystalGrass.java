// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraftforge.common.IPlantable;
import net.minecraft.item.Item;
import java.util.Random;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraft.world.World;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.IIcon;
import net.minecraft.block.Block;

public class CrystalGrass extends Block
{
    @SideOnly(Side.CLIENT)
    private IIcon[] field_94364_a;
    
    protected CrystalGrass(final int par1, final float f1, final float f2) {
        super(Material.field_151577_b);
        this.func_149711_c(f1);
        this.func_149752_b(f2);
        this.func_149675_a(false);
        this.func_149647_a(CreativeTabs.field_78030_b);
    }
    
    public boolean isBlockSolidOnSide(final World world, final int x, final int y, final int z, final ForgeDirection side) {
        return true;
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon func_149691_a(final int par1, final int par2) {
        if (this.field_94364_a == null) {
            return null;
        }
        return (par1 == 1) ? this.field_94364_a[0] : ((par1 == 0) ? this.field_94364_a[1] : this.field_94364_a[2]);
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getBlockTexture(final IBlockAccess par1IBlockAccess, final int par2, final int par3, final int par4, final int par5) {
        if (this.field_94364_a == null) {
            return null;
        }
        if (par5 == 1) {
            return this.field_94364_a[0];
        }
        if (par5 == 0) {
            return this.field_94364_a[1];
        }
        return this.field_94364_a[2];
    }
    
    public Item func_149650_a(final int par1, final Random par2Random, final int par3) {
        return Item.func_150898_a((Block)this);
    }
    
    public boolean canSustainPlant(final IBlockAccess world, final int x, final int y, final int z, final ForgeDirection direction, final IPlantable plant) {
        return true;
    }
    
    public boolean func_149662_c() {
        return OreSpawnMain.current_dimension == OreSpawnMain.DimensionID5;
    }
    
    public boolean func_149686_d() {
        return OreSpawnMain.current_dimension == OreSpawnMain.DimensionID5;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149651_a(final IIconRegister par1IIconRegister) {
        (this.field_94364_a = new IIcon[3])[0] = par1IIconRegister.func_94245_a("OreSpawn:crystalgrass_top");
        this.field_94364_a[1] = par1IIconRegister.func_94245_a("OreSpawn:crystalgrass_bottom");
        this.field_94364_a[2] = par1IIconRegister.func_94245_a("OreSpawn:crystalgrass_side");
    }
}

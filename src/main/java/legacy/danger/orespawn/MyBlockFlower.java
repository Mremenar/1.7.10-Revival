// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraftforge.common.EnumPlantType;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;
import java.util.Random;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.IPlantable;
import net.minecraft.block.Block;

public class MyBlockFlower extends Block implements IPlantable
{
    protected MyBlockFlower(final int par1, final Material par2Material) {
        super(par2Material);
        this.func_149675_a(true);
        final float f = 0.2f;
        this.func_149676_a(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, f * 3.0f, 0.5f + f);
        this.func_149647_a(CreativeTabs.field_78031_c);
    }
    
    protected MyBlockFlower(final int par1) {
        this(par1, Material.field_151585_k);
    }
    
    public boolean func_149742_c(final World par1World, final int par2, final int par3, final int par4) {
        return super.func_149742_c(par1World, par2, par3, par4) && this.func_149718_j(par1World, par2, par3, par4);
    }
    
    protected boolean canPlaceBlockOn(final Block par1) {
        return par1 == Blocks.field_150349_c || par1 == Blocks.field_150346_d || par1 == Blocks.field_150458_ak || par1 == OreSpawnMain.CrystalGrass;
    }
    
    public void func_149695_a(final World par1World, final int par2, final int par3, final int par4, final Block par5) {
        super.func_149695_a(par1World, par2, par3, par4, par5);
        this.checkFlowerChange(par1World, par2, par3, par4);
    }
    
    public void func_149674_a(final World par1World, final int par2, final int par3, final int par4, final Random par5Random) {
        this.checkFlowerChange(par1World, par2, par3, par4);
    }
    
    protected final void checkFlowerChange(final World par1World, final int par2, final int par3, final int par4) {
        if (!this.func_149718_j(par1World, par2, par3, par4)) {
            this.func_149697_b(par1World, par2, par3, par4, par1World.func_72805_g(par2, par3, par4), 0);
            par1World.func_147465_d(par2, par3, par4, Blocks.field_150350_a, 0, 2);
            return;
        }
        long t = par1World.func_72820_D();
        t %= 24000L;
        if (t > 12000L) {
            if (this == OreSpawnMain.MyFlowerPinkBlock) {
                par1World.func_147449_b(par2, par3, par4, OreSpawnMain.MyFlowerBlackBlock);
            }
            if (this == OreSpawnMain.MyFlowerBlueBlock) {
                par1World.func_147449_b(par2, par3, par4, OreSpawnMain.MyFlowerScaryBlock);
            }
        }
        else {
            if (this == OreSpawnMain.MyFlowerBlackBlock) {
                par1World.func_147449_b(par2, par3, par4, OreSpawnMain.MyFlowerPinkBlock);
            }
            if (this == OreSpawnMain.MyFlowerScaryBlock) {
                par1World.func_147449_b(par2, par3, par4, OreSpawnMain.MyFlowerBlueBlock);
            }
        }
    }
    
    public boolean func_149718_j(final World p_149718_1_, final int p_149718_2_, final int p_149718_3_, final int p_149718_4_) {
        return p_149718_1_.func_147439_a(p_149718_2_, p_149718_3_ - 1, p_149718_4_).canSustainPlant((IBlockAccess)p_149718_1_, p_149718_2_, p_149718_3_ - 1, p_149718_4_, ForgeDirection.UP, (IPlantable)this);
    }
    
    public AxisAlignedBB func_149668_a(final World par1World, final int par2, final int par3, final int par4) {
        return null;
    }
    
    public boolean func_149662_c() {
        return false;
    }
    
    public boolean func_149686_d() {
        return false;
    }
    
    public int func_149645_b() {
        return 1;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149651_a(final IIconRegister iconRegister) {
        this.field_149761_L = iconRegister.func_94245_a("OreSpawn:" + this.func_149739_a().substring(5));
    }
    
    public EnumPlantType getPlantType(final IBlockAccess world, final int x, final int y, final int z) {
        return EnumPlantType.Plains;
    }
    
    public Block getPlant(final IBlockAccess world, final int x, final int y, final int z) {
        return this;
    }
    
    public int getPlantMetadata(final IBlockAccess world, final int x, final int y, final int z) {
        return world.func_72805_g(x, y, z);
    }
}

// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraft.block.Block;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.BlockTorch;

public class BlockCrystalTorch extends BlockTorch
{
    public BlockCrystalTorch(final int par1) {
        this.func_149647_a(CreativeTabs.field_78031_c);
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149734_b(final World par1World, final int par2, final int par3, final int par4, final Random par5Random) {
        if (par1World.field_73012_v.nextInt(4) != 1) {
            return;
        }
        final int var6 = par1World.func_72805_g(par2, par3, par4);
        final double var7 = par2 + 0.5f;
        final double var8 = par3 + 0.7f;
        final double var9 = par4 + 0.5f;
        final double var10 = 0.213;
        final double var11 = 0.271;
        if (var6 == 1) {
            par1World.func_72869_a("fireworksSpark", var7 - var11, var8 + var10, var9, (double)((par1World.field_73012_v.nextFloat() - par1World.field_73012_v.nextFloat()) / 8.0f), (double)(par1World.field_73012_v.nextFloat() / 8.0f), (double)((par1World.field_73012_v.nextFloat() - par1World.field_73012_v.nextFloat()) / 8.0f));
            par1World.func_72869_a("flame", var7 - var11, var8 + var10, var9, (double)((par1World.field_73012_v.nextFloat() - par1World.field_73012_v.nextFloat()) / 60.0f), (double)(par1World.field_73012_v.nextFloat() / 10.0f), (double)((par1World.field_73012_v.nextFloat() - par1World.field_73012_v.nextFloat()) / 60.0f));
        }
        else if (var6 == 2) {
            par1World.func_72869_a("fireworksSpark", var7 + var11, var8 + var10, var9, (double)((par1World.field_73012_v.nextFloat() - par1World.field_73012_v.nextFloat()) / 8.0f), (double)(par1World.field_73012_v.nextFloat() / 8.0f), (double)((par1World.field_73012_v.nextFloat() - par1World.field_73012_v.nextFloat()) / 8.0f));
            par1World.func_72869_a("flame", var7 + var11, var8 + var10, var9, (double)((par1World.field_73012_v.nextFloat() - par1World.field_73012_v.nextFloat()) / 60.0f), (double)(par1World.field_73012_v.nextFloat() / 10.0f), (double)((par1World.field_73012_v.nextFloat() - par1World.field_73012_v.nextFloat()) / 60.0f));
        }
        else if (var6 == 3) {
            par1World.func_72869_a("fireworksSpark", var7, var8 + var10, var9 - var11, (double)((par1World.field_73012_v.nextFloat() - par1World.field_73012_v.nextFloat()) / 8.0f), (double)(par1World.field_73012_v.nextFloat() / 8.0f), (double)((par1World.field_73012_v.nextFloat() - par1World.field_73012_v.nextFloat()) / 8.0f));
            par1World.func_72869_a("flame", var7, var8 + var10, var9 - var11, (double)((par1World.field_73012_v.nextFloat() - par1World.field_73012_v.nextFloat()) / 60.0f), (double)(par1World.field_73012_v.nextFloat() / 10.0f), (double)((par1World.field_73012_v.nextFloat() - par1World.field_73012_v.nextFloat()) / 60.0f));
        }
        else if (var6 == 4) {
            par1World.func_72869_a("fireworksSpark", var7, var8 + var10, var9 + var11, (double)((par1World.field_73012_v.nextFloat() - par1World.field_73012_v.nextFloat()) / 8.0f), (double)(par1World.field_73012_v.nextFloat() / 8.0f), (double)((par1World.field_73012_v.nextFloat() - par1World.field_73012_v.nextFloat()) / 8.0f));
            par1World.func_72869_a("flame", var7, var8 + var10, var9 + var11, (double)((par1World.field_73012_v.nextFloat() - par1World.field_73012_v.nextFloat()) / 60.0f), (double)(par1World.field_73012_v.nextFloat() / 10.0f), (double)((par1World.field_73012_v.nextFloat() - par1World.field_73012_v.nextFloat()) / 60.0f));
        }
        else {
            par1World.func_72869_a("fireworksSpark", var7, var8, var9, (double)((par1World.field_73012_v.nextFloat() - par1World.field_73012_v.nextFloat()) / 8.0f), (double)(par1World.field_73012_v.nextFloat() / 8.0f), (double)((par1World.field_73012_v.nextFloat() - par1World.field_73012_v.nextFloat()) / 8.0f));
            par1World.func_72869_a("flame", var7, var8, var9, (double)((par1World.field_73012_v.nextFloat() - par1World.field_73012_v.nextFloat()) / 60.0f), (double)(par1World.field_73012_v.nextFloat() / 10.0f), (double)((par1World.field_73012_v.nextFloat() - par1World.field_73012_v.nextFloat()) / 60.0f));
        }
    }
    
    private boolean isCrystalBlock(final World par1World, final int par2, final int par3, final int par4) {
        final Block l = par1World.func_147439_a(par2, par3, par4);
        return l == OreSpawnMain.CrystalStone || l == OreSpawnMain.CrystalGrass || l == OreSpawnMain.MyCrystalTreeLog || l == OreSpawnMain.CrystalPlanksBlock;
    }
    
    private boolean isItSolidOnSide(final World par1World, final int par2, final int par3, final int par4, final ForgeDirection dir, final boolean tf) {
        return this.isCrystalBlock(par1World, par2, par3, par4) || par1World.isSideSolid(par2, par3, par4, dir, tf);
    }
    
    private boolean canPlaceTorchOn(final World par1World, final int par2, final int par3, final int par4) {
        final Block l = par1World.func_147439_a(par2, par3, par4);
        return this.isCrystalBlock(par1World, par2, par3, par4) || World.func_147466_a((IBlockAccess)par1World, par2, par3, par4) || (l != null && l.canPlaceTorchOnTop(par1World, par2, par3, par4));
    }
    
    public boolean func_149742_c(final World par1World, final int par2, final int par3, final int par4) {
        return this.isItSolidOnSide(par1World, par2 - 1, par3, par4, ForgeDirection.EAST, true) || this.isItSolidOnSide(par1World, par2 + 1, par3, par4, ForgeDirection.WEST, true) || this.isItSolidOnSide(par1World, par2, par3, par4 - 1, ForgeDirection.SOUTH, true) || this.isItSolidOnSide(par1World, par2, par3, par4 + 1, ForgeDirection.NORTH, true) || this.canPlaceTorchOn(par1World, par2, par3 - 1, par4);
    }
    
    public int func_149660_a(final World par1World, final int par2, final int par3, final int par4, final int par5, final float par6, final float par7, final float par8, final int par9) {
        int j1 = par9;
        if (par5 == 1 && this.canPlaceTorchOn(par1World, par2, par3 - 1, par4)) {
            j1 = 5;
        }
        if (par5 == 2 && (par1World.isSideSolid(par2, par3, par4 + 1, ForgeDirection.NORTH, true) || this.isCrystalBlock(par1World, par2, par3, par4 + 1))) {
            j1 = 4;
        }
        if (par5 == 3 && (par1World.isSideSolid(par2, par3, par4 - 1, ForgeDirection.SOUTH, true) || this.isCrystalBlock(par1World, par2, par3, par4 - 1))) {
            j1 = 3;
        }
        if (par5 == 4 && (par1World.isSideSolid(par2 + 1, par3, par4, ForgeDirection.WEST, true) || this.isCrystalBlock(par1World, par2 + 1, par3, par4))) {
            j1 = 2;
        }
        if (par5 == 5 && (par1World.isSideSolid(par2 - 1, par3, par4, ForgeDirection.EAST, true) || this.isCrystalBlock(par1World, par2 - 1, par3, par4))) {
            j1 = 1;
        }
        return j1;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149651_a(final IIconRegister iconRegister) {
        this.field_149761_L = iconRegister.func_94245_a("OreSpawn:" + this.func_149739_a().substring(5));
    }
}

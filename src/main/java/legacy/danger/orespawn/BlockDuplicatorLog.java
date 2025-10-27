// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.world.IBlockAccess;
import net.minecraft.item.ItemStack;
import java.util.List;
import net.minecraft.item.Item;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;

public class BlockDuplicatorLog extends Block
{
    protected BlockDuplicatorLog(final int par1) {
        super(Material.field_151575_d);
        this.func_149647_a(CreativeTabs.field_78030_b);
        this.func_149675_a(true);
    }
    
    public int tickRate() {
        return 1;
    }
    
    public void func_149674_a(final World par1World, final int par2, final int par3, final int par4, final Random par5Random) {
        if (par1World.field_72995_K) {
            return;
        }
        if (OreSpawnMain.enableduplicatortree != 0) {
            OreSpawnMain.OreSpawnTrees.DuplicatorTree(par1World, par2, par3, par4);
        }
    }
    
    public void func_149666_a(final Item par1, final CreativeTabs par2CreativeTabs, final List par3List) {
        par3List.add(new ItemStack(Item.func_150898_a((Block)this), 1, 0));
    }
    
    protected ItemStack func_149644_j(final int par1) {
        return new ItemStack((Block)this, 1, 0);
    }
    
    public boolean canSustainLeaves(final IBlockAccess world, final int x, final int y, final int z) {
        return true;
    }
    
    public boolean isWood(final IBlockAccess world, final int x, final int y, final int z) {
        return true;
    }
    
    public int func_149745_a(final Random par1Random) {
        return 1;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149651_a(final IIconRegister iconRegister) {
        this.field_149761_L = iconRegister.func_94245_a("OreSpawn:" + this.func_149739_a().substring(5));
    }
}

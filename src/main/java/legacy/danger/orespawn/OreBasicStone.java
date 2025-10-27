// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.Entity;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraft.world.World;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;

public class OreBasicStone extends Block
{
    public OreBasicStone(final int par1, final float f1, final float f2) {
        super(Material.field_151576_e);
        this.func_149711_c(f1);
        this.func_149752_b(f2);
        this.func_149647_a(CreativeTabs.field_78030_b);
        this.func_149675_a(false);
    }
    
    public void func_149664_b(final World par1World, final int par2, final int par3, final int par4, final int par5) {
        if (!par1World.field_72995_K && this == OreSpawnMain.CrystalRat) {
            for (int num = 1 + par1World.field_73012_v.nextInt(10), i = 0; i < num; ++i) {
                spawnCreature(par1World, 0, "Rat", par2 + 0.5 + (par1World.field_73012_v.nextFloat() - par1World.field_73012_v.nextFloat()) * 0.2, par3 + 0.01, par4 + 0.5 + (par1World.field_73012_v.nextFloat() - par1World.field_73012_v.nextFloat()) * 0.2);
            }
        }
        if (!par1World.field_72995_K && this == OreSpawnMain.CrystalFairy) {
            for (int num = 1 + par1World.field_73012_v.nextInt(6), i = 0; i < num; ++i) {
                spawnCreature(par1World, 0, "Fairy", par2 + 0.5 + (par1World.field_73012_v.nextFloat() - par1World.field_73012_v.nextFloat()) * 0.2, par3 + 0.01, par4 + 0.5 + (par1World.field_73012_v.nextFloat() - par1World.field_73012_v.nextFloat()) * 0.2);
            }
        }
        if (!par1World.field_72995_K && this == OreSpawnMain.RedAntTroll) {
            for (int num = 15 + par1World.field_73012_v.nextInt(6), i = 0; i < num; ++i) {
                spawnCreature(par1World, 0, "Red Ant", par2 + 0.5 + (par1World.field_73012_v.nextFloat() - par1World.field_73012_v.nextFloat()) * 0.2, par3 + 0.01, par4 + 0.5 + (par1World.field_73012_v.nextFloat() - par1World.field_73012_v.nextFloat()) * 0.2);
            }
        }
        if (!par1World.field_72995_K && this == OreSpawnMain.TermiteTroll) {
            for (int num = 15 + par1World.field_73012_v.nextInt(6), i = 0; i < num; ++i) {
                spawnCreature(par1World, 0, "Termite", par2 + 0.5 + (par1World.field_73012_v.nextFloat() - par1World.field_73012_v.nextFloat()) * 0.2, par3 + 0.01, par4 + 0.5 + (par1World.field_73012_v.nextFloat() - par1World.field_73012_v.nextFloat()) * 0.2);
            }
        }
        super.func_149664_b(par1World, par2, par3, par4, par5);
    }
    
    public boolean isBlockSolidOnSide(final World world, final int x, final int y, final int z, final ForgeDirection side) {
        return true;
    }
    
    public boolean func_149662_c() {
        return OreSpawnMain.current_dimension == OreSpawnMain.DimensionID5;
    }
    
    public boolean func_149686_d() {
        return OreSpawnMain.current_dimension == OreSpawnMain.DimensionID5;
    }
    
    public static Entity spawnCreature(final World par0World, final int par1, final String name, final double par2, final double par4, final double par6) {
        Entity var8 = null;
        if (name == null) {
            var8 = EntityList.func_75616_a(par1, par0World);
        }
        else {
            var8 = EntityList.func_75620_a(name, par0World);
        }
        if (var8 != null) {
            var8.func_70012_b(par2, par4, par6, par0World.field_73012_v.nextFloat() * 360.0f, 0.0f);
            par0World.func_72838_d(var8);
            ((EntityLiving)var8).func_70642_aH();
        }
        return var8;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149651_a(final IIconRegister iconRegister) {
        this.field_149761_L = iconRegister.func_94245_a("OreSpawn:" + this.func_149739_a().substring(5));
    }
}

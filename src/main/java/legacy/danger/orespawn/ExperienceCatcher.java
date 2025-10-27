// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ExperienceCatcher extends Item
{
    public ExperienceCatcher(final int i) {
        this.field_77777_bU = 16;
        this.func_77637_a(CreativeTabs.field_78040_i);
    }
    
    public boolean func_77648_a(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final World world, final int x, final int y, final int z, final int par7, final float par8, final float par9, final float par10) {
        par2EntityPlayer.func_71038_i();
        System.out.printf("x, y,z, 7,8,9,10 == %d, %d, %d - %d, %f, %f, %f\n", x, y, z, par7, par8, par9, par10);
        if (!par2EntityPlayer.field_70170_p.field_72995_K) {
            final AxisAlignedBB bb = AxisAlignedBB.func_72330_a(x - 0.5 + par8, (double)y, z - 0.5 + par10, x + 0.5 + par8, y + 2.0, z + 0.5 + par10);
            final List var5 = world.func_72872_a((Class)EntityXPOrb.class, bb);
            for (final Entity var7 : var5) {
                if (var7 instanceof EntityXPOrb) {
                    final EntityXPOrb ex = (EntityXPOrb)var7;
                    if (ex.func_70526_d() < 3) {
                        continue;
                    }
                    if (world.field_73012_v.nextInt(5) == 1) {
                        continue;
                    }
                    var7.func_70106_y();
                    EntityItem var8 = null;
                    ItemStack is = new ItemStack(Items.field_151062_by, 1, 0);
                    var8 = new EntityItem(par2EntityPlayer.field_70170_p, (double)(par8 + x), y + 1.0, (double)(par10 + z), is);
                    if (var8 != null) {
                        par2EntityPlayer.field_70170_p.func_72838_d((Entity)var8);
                    }
                    is = new ItemStack(Items.field_151007_F, 1, 0);
                    var8 = new EntityItem(par2EntityPlayer.field_70170_p, (double)(par8 + x), y + 1.0, (double)(par10 + z), is);
                    if (var8 != null) {
                        par2EntityPlayer.field_70170_p.func_72838_d((Entity)var8);
                    }
                    is = new ItemStack(Items.field_151055_y, 1, 0);
                    var8 = new EntityItem(par2EntityPlayer.field_70170_p, (double)(par8 + x), y + 1.0, (double)(par10 + z), is);
                    if (var8 != null) {
                        par2EntityPlayer.field_70170_p.func_72838_d((Entity)var8);
                    }
                    if (!par2EntityPlayer.field_71075_bZ.field_75098_d) {
                        --par1ItemStack.field_77994_a;
                    }
                    return true;
                }
            }
            EntityItem var9 = null;
            final ItemStack is2 = new ItemStack(OreSpawnMain.MyExperienceCatcher, 1, 0);
            var9 = new EntityItem(par2EntityPlayer.field_70170_p, (double)(par8 + x), y + 1.0, (double)(par10 + z), is2);
            if (var9 != null) {
                par2EntityPlayer.field_70170_p.func_72838_d((Entity)var9);
            }
            --par1ItemStack.field_77994_a;
        }
        return true;
    }
    
    public ItemStack func_77659_a(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        par3EntityPlayer.func_71038_i();
        return par1ItemStack;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94581_a(final IIconRegister iconRegister) {
        this.field_77791_bV = iconRegister.func_94245_a("OreSpawn:" + this.func_77658_a().substring(5));
    }
}

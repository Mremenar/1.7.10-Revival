// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemRayGun extends Item
{
    public ItemRayGun(final int i) {
        this.field_77777_bU = 1;
        this.func_77656_e(50);
        this.func_77637_a(CreativeTabs.field_78037_j);
    }
    
    public ItemStack func_77659_a(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        if (par1ItemStack.func_77958_k() - par1ItemStack.func_77960_j() <= 1) {
            return par1ItemStack;
        }
        par2World.func_72956_a((Entity)par3EntityPlayer, "fireworks.launch", 3.5f, 0.5f);
        if (!par2World.field_72995_K) {
            final double xzoff = 1.0;
            final double yoff = 1.55;
            final LaserBall lb = new LaserBall(par2World, (EntityLivingBase)par3EntityPlayer);
            lb.setSpecial();
            lb.func_70012_b(par3EntityPlayer.field_70165_t - xzoff * Math.sin(Math.toRadians(par3EntityPlayer.field_70759_as + 45.0f)), par3EntityPlayer.field_70163_u + yoff, par3EntityPlayer.field_70161_v + xzoff * Math.cos(Math.toRadians(par3EntityPlayer.field_70759_as + 45.0f)), par3EntityPlayer.field_70759_as, par3EntityPlayer.field_70125_A);
            final LaserBall laserBall = lb;
            laserBall.field_70159_w *= 3.0;
            final LaserBall laserBall2 = lb;
            laserBall2.field_70181_x *= 3.0;
            final LaserBall laserBall3 = lb;
            laserBall3.field_70179_y *= 3.0;
            par2World.func_72838_d((Entity)lb);
        }
        par3EntityPlayer.func_71038_i();
        par3EntityPlayer.func_70024_g(Math.cos(Math.toRadians(par3EntityPlayer.field_70759_as - 90.0f)) * 1.5, 0.3, Math.sin(Math.toRadians(par3EntityPlayer.field_70759_as - 90.0f)) * 1.5);
        par1ItemStack.func_77972_a(1, (EntityLivingBase)par3EntityPlayer);
        return par1ItemStack;
    }
    
    public String getMaterialName() {
        return "Unknown";
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94581_a(final IIconRegister iconRegister) {
        this.field_77791_bV = iconRegister.func_94245_a("OreSpawn:" + this.func_77658_a().substring(5));
    }
}

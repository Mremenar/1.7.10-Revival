// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemSquidZooka extends Item
{
    public ItemSquidZooka(final int i) {
        this.field_77777_bU = 1;
        this.func_77656_e(100);
        this.func_77637_a(CreativeTabs.field_78037_j);
    }
    
    public ItemStack func_77659_a(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        if (par1ItemStack.func_77958_k() - par1ItemStack.func_77960_j() <= 1) {
            return par1ItemStack;
        }
        par2World.func_72956_a((Entity)par3EntityPlayer, "random.explode", 0.5f, 0.5f);
        if (!par2World.field_72995_K) {
            final double xzoff = 2.5;
            final double yoff = 1.65;
            final Entity e = spawnCreature(par2World, "Attack Squid", par3EntityPlayer.field_70165_t - xzoff * Math.sin(Math.toRadians(par3EntityPlayer.field_70759_as + 15.0f)), par3EntityPlayer.field_70163_u + yoff, par3EntityPlayer.field_70161_v + xzoff * Math.cos(Math.toRadians(par3EntityPlayer.field_70759_as + 15.0f)));
            if (e instanceof AttackSquid) {
                final AttackSquid a = (AttackSquid)e;
                a.setWasShot();
            }
            final float f = 3.6f;
            e.field_70159_w = -MathHelper.func_76126_a(par3EntityPlayer.field_70177_z / 180.0f * 3.1415927f) * MathHelper.func_76134_b(par3EntityPlayer.field_70125_A / 180.0f * 3.1415927f) * f;
            e.field_70179_y = MathHelper.func_76134_b(par3EntityPlayer.field_70177_z / 180.0f * 3.1415927f) * MathHelper.func_76134_b(par3EntityPlayer.field_70125_A / 180.0f * 3.1415927f) * f;
            e.field_70181_x = -MathHelper.func_76126_a(par3EntityPlayer.field_70125_A / 180.0f * 3.1415927f) * f;
            final Entity entity = e;
            entity.field_70159_w += (par2World.field_73012_v.nextFloat() - par2World.field_73012_v.nextFloat()) * 0.05;
            final Entity entity2 = e;
            entity2.field_70181_x += (par2World.field_73012_v.nextFloat() - par2World.field_73012_v.nextFloat()) * 0.05;
            final Entity entity3 = e;
            entity3.field_70179_y += (par2World.field_73012_v.nextFloat() - par2World.field_73012_v.nextFloat()) * 0.05;
        }
        par3EntityPlayer.func_71038_i();
        par3EntityPlayer.func_70024_g(Math.cos(Math.toRadians(par3EntityPlayer.field_70759_as - 90.0f)) * 0.45, 0.1, Math.sin(Math.toRadians(par3EntityPlayer.field_70759_as - 90.0f)) * 0.45);
        par1ItemStack.func_77972_a(1, (EntityLivingBase)par3EntityPlayer);
        return par1ItemStack;
    }
    
    public static Entity spawnCreature(final World par0World, final String par1, final double par2, final double par4, final double par6) {
        Entity var8 = null;
        var8 = EntityList.func_75620_a(par1, par0World);
        if (var8 != null) {
            var8.func_70012_b(par2, par4, par6, par0World.field_73012_v.nextFloat() * 360.0f, 0.0f);
            par0World.func_72838_d(var8);
        }
        return var8;
    }
    
    public String getMaterialName() {
        return "Unknown";
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94581_a(final IIconRegister iconRegister) {
        this.field_77791_bV = iconRegister.func_94245_a("OreSpawn:" + this.func_77658_a().substring(5));
    }
}

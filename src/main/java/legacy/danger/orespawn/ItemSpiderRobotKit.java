// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemSpiderRobotKit extends Item
{
    public ItemSpiderRobotKit(final int i) {
        this.field_77777_bU = 1;
        this.func_77637_a(CreativeTabs.field_78040_i);
        if (i == OreSpawnMain.BaseItemID + 471) {
            this.func_77656_e(OreSpawnMain.SpiderRobot_stats.health);
        }
        else {
            this.func_77656_e(OreSpawnMain.AntRobot_stats.health);
        }
    }
    
    public boolean func_77648_a(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final World par3World, final int par4, final int par5, final int par6, final int par7, final float par8, final float par9, final float par10) {
        if (par3World.field_72995_K) {
            return true;
        }
        String name = null;
        name = "Robot Spider";
        if (par1ItemStack.func_77973_b() == OreSpawnMain.AntRobotKit) {
            name = "Robot Red Ant";
        }
        final Entity ent = spawnCreature(par3World, 0, name, par4 + 0.5, par5 + 1.01, par6 + 0.5);
        if (ent != null) {
            final EntityLiving e = (EntityLiving)ent;
            e.func_70606_j((float)(this.func_77612_l() - this.getDamage(par1ItemStack)));
            if (ent instanceof EntityLiving && par1ItemStack.func_82837_s()) {
                ((EntityLiving)ent).func_94058_c(par1ItemStack.func_82833_r());
            }
            par3World.func_72956_a((Entity)par2EntityPlayer, "random.explode", 1.0f, par3World.field_73012_v.nextFloat() * 0.2f + 0.9f);
            if (ent instanceof AntRobot) {
                final AntRobot a = (AntRobot)ent;
                a.setOwned();
            }
        }
        if (!par2EntityPlayer.field_71075_bZ.field_75098_d) {
            --par1ItemStack.field_77994_a;
        }
        return true;
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
    public void func_94581_a(final IIconRegister iconRegister) {
        this.field_77791_bV = iconRegister.func_94245_a("OreSpawn:" + this.func_77658_a().substring(5));
    }
}

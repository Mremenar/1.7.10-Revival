// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;

public class Bertha extends ItemSword
{
    public Bertha(final int par1, final Item.ToolMaterial par2EnumToolMaterial) {
        super(par2EnumToolMaterial);
        this.field_77777_bU = 1;
        this.func_77656_e(9000);
        this.func_77637_a(CreativeTabs.field_78037_j);
    }
    
    public void func_77622_d(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        if (this == OreSpawnMain.MyRoyal) {
            par1ItemStack.func_77966_a(Enchantment.field_77347_r, 5);
        }
        else if (this != OreSpawnMain.MyHammy) {
            par1ItemStack.func_77966_a(Enchantment.field_77337_m, 5);
            par1ItemStack.func_77966_a(Enchantment.field_77336_l, 1);
            par1ItemStack.func_77966_a(Enchantment.field_77334_n, 1);
        }
    }
    
    public void onUsingTick(final ItemStack stack, final EntityPlayer player, final int count) {
        int lvl = EnchantmentHelper.func_77506_a(Enchantment.field_77337_m.field_77352_x, stack);
        if (lvl == 0) {
            lvl = EnchantmentHelper.func_77506_a(Enchantment.field_77347_r.field_77352_x, stack);
        }
        if (lvl <= 0) {
            if (this == OreSpawnMain.MyRoyal) {
                stack.func_77966_a(Enchantment.field_77347_r, 5);
            }
            else if (this != OreSpawnMain.MyHammy) {
                stack.func_77966_a(Enchantment.field_77337_m, 5);
                stack.func_77966_a(Enchantment.field_77336_l, 1);
                stack.func_77966_a(Enchantment.field_77334_n, 1);
            }
        }
    }
    
    public void func_77663_a(final ItemStack stack, final World par2World, final Entity par3Entity, final int par4, final boolean par5) {
        this.onUsingTick(stack, null, 0);
    }
    
    public boolean onLeftClickEntity(final ItemStack stack, final EntityPlayer player, final Entity entity) {
        if (entity != null && OreSpawnMain.big_bertha_pvp == 0) {
            if (entity instanceof EntityPlayer || entity instanceof Girlfriend || entity instanceof Boyfriend) {
                return true;
            }
            if (entity instanceof EntityTameable) {
                final EntityTameable t = (EntityTameable)entity;
                if (t.func_70909_n()) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean onEntitySwing(final EntityLivingBase entityLiving, final ItemStack stack) {
        if (entityLiving != null && entityLiving instanceof EntityPlayer && !entityLiving.field_70170_p.field_72995_K) {
            final EntityPlayer p = (EntityPlayer)entityLiving;
            final double xzoff = 2.0;
            final double yoff = 1.55;
            final BerthaHit lb = new BerthaHit(p.field_70170_p, (EntityLivingBase)p);
            lb.func_70012_b(p.field_70165_t - xzoff * Math.sin(Math.toRadians(p.field_70759_as)), p.field_70163_u + yoff, p.field_70161_v + xzoff * Math.cos(Math.toRadians(p.field_70759_as)), p.field_70759_as, p.field_70125_A);
            final BerthaHit berthaHit = lb;
            berthaHit.field_70159_w *= 2.0;
            final BerthaHit berthaHit2 = lb;
            berthaHit2.field_70181_x *= 2.0;
            final BerthaHit berthaHit3 = lb;
            berthaHit3.field_70179_y *= 2.0;
            if (this == OreSpawnMain.MyRoyal) {
                lb.setHitType(2);
            }
            if (this == OreSpawnMain.MyHammy) {
                lb.setHitType(3);
            }
            p.field_70170_p.func_72838_d((Entity)lb);
            stack.func_77972_a(1, (EntityLivingBase)p);
        }
        return false;
    }
    
    public String getMaterialName() {
        return "Uranium/Titanium";
    }
    
    public boolean hitEntity(final ItemStack par1ItemStack, final EntityLiving par2EntityLiving, final EntityLiving par3EntityLiving) {
        par1ItemStack.func_77972_a(1, (EntityLivingBase)par3EntityLiving);
        return true;
    }
    
    public int func_77626_a(final ItemStack par1ItemStack) {
        return 9000;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94581_a(final IIconRegister iconRegister) {
        this.field_77791_bV = iconRegister.func_94245_a("OreSpawn:" + this.func_77658_a().substring(5));
    }
}

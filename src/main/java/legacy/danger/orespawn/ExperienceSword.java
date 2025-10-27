// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.World;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;

public class ExperienceSword extends ItemSword
{
    private int weaponDamage;
    private final Item.ToolMaterial toolMaterial;
    private World worldObj;
    private World worldObjr;
    
    public ExperienceSword(final int par1, final Item.ToolMaterial par2EnumToolMaterial) {
        super(par2EnumToolMaterial);
        this.worldObj = null;
        this.worldObjr = null;
        this.toolMaterial = par2EnumToolMaterial;
        this.weaponDamage = 15;
        this.field_77777_bU = 1;
        this.func_77656_e(1400);
        this.func_77637_a(CreativeTabs.field_78037_j);
    }
    
    public void func_77622_d(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        par1ItemStack.func_77966_a(Enchantment.field_77338_j, 2);
        par1ItemStack.func_77966_a(Enchantment.field_77347_r, 3);
    }
    
    public void onUsingTick(final ItemStack stack, final EntityPlayer player, final int count) {
        final int lvl = EnchantmentHelper.func_77506_a(Enchantment.field_77338_j.field_77352_x, stack);
        if (lvl <= 0) {
            stack.func_77966_a(Enchantment.field_77338_j, 2);
            stack.func_77966_a(Enchantment.field_77347_r, 3);
        }
    }
    
    public void func_77663_a(final ItemStack stack, final World par2World, final Entity par3Entity, final int par4, final boolean par5) {
        EntityLivingBase e = null;
        ItemOreSpawnArmor ia = null;
        EntityPlayer p = null;
        this.onUsingTick(stack, null, 0);
        if (this.worldObj == null && !par2World.field_72995_K) {
            this.worldObj = par2World;
        }
        if (this.worldObjr == null && par2World.field_72995_K) {
            this.worldObjr = par2World;
        }
        if (par2World.field_73012_v.nextInt(60) == 1 && par3Entity != null && par3Entity instanceof EntityLivingBase) {
            e = (EntityLivingBase)par3Entity;
            if (e instanceof EntityPlayer) {
                p = (EntityPlayer)e;
            }
            for (int i = 1; i < 5; ++i) {
                final ItemStack is = p.func_71124_b(i);
                if (is != null) {
                    final Item it = is.func_77973_b();
                    if (it != null && it instanceof ItemOreSpawnArmor) {
                        ia = (ItemOreSpawnArmor)it;
                        if (ia.get_armor_material() == 4) {
                            switch (ia.get_armor_type()) {
                                case 0: {
                                    if (!par2World.field_72995_K && p != null && par2World.field_73012_v.nextInt(10) == 1) {
                                        p.func_71023_q(1);
                                    }
                                    par2World.func_72869_a("portal", e.field_70165_t, e.field_70163_u + 1.5, e.field_70161_v, par2World.field_73012_v.nextGaussian(), par2World.field_73012_v.nextGaussian(), par2World.field_73012_v.nextGaussian());
                                    break;
                                }
                                case 1: {
                                    if (!par2World.field_72995_K && p != null && par2World.field_73012_v.nextInt(20) == 1) {
                                        p.func_71023_q(1);
                                    }
                                    par2World.func_72869_a("portal", e.field_70165_t, e.field_70163_u + 1.25, e.field_70161_v, par2World.field_73012_v.nextGaussian(), par2World.field_73012_v.nextGaussian(), par2World.field_73012_v.nextGaussian());
                                    break;
                                }
                                case 2: {
                                    if (!par2World.field_72995_K && p != null && par2World.field_73012_v.nextInt(30) == 1) {
                                        p.func_71023_q(1);
                                    }
                                    par2World.func_72869_a("portal", e.field_70165_t, e.field_70163_u + 0.75, e.field_70161_v, par2World.field_73012_v.nextGaussian(), par2World.field_73012_v.nextGaussian(), par2World.field_73012_v.nextGaussian());
                                    break;
                                }
                                case 3: {
                                    if (!par2World.field_72995_K && p != null && par2World.field_73012_v.nextInt(40) == 1) {
                                        p.func_71023_q(1);
                                    }
                                    par2World.func_72869_a("portal", e.field_70165_t, e.field_70163_u + 0.25, e.field_70161_v, par2World.field_73012_v.nextGaussian(), par2World.field_73012_v.nextGaussian(), par2World.field_73012_v.nextGaussian());
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    public int getDamageVsEntity(final Entity par1Entity) {
        return this.weaponDamage;
    }
    
    public String getMaterialName() {
        return "Emerald";
    }
    
    public boolean func_77644_a(final ItemStack par1ItemStack, final EntityLivingBase par2EntityLiving, final EntityLivingBase par3EntityLiving) {
        float i = 0.0f;
        EntityPlayer p = null;
        final EntityLiving l = null;
        if (par3EntityLiving instanceof EntityPlayer) {
            p = (EntityPlayer)par3EntityLiving;
        }
        if (par2EntityLiving != null && par2EntityLiving instanceof EntityLiving) {
            i = 10.0f;
        }
        if (i > 0.0f && p != null) {
            p.func_71023_q((int)i);
        }
        if (p != null) {
            i = (float)(p.field_71068_ca / 2);
            if (i > 0.0f && par2EntityLiving != null) {
                par2EntityLiving.func_70097_a(DamageSource.func_76365_a(p), i);
            }
        }
        if (this.worldObjr != null && par2EntityLiving != null) {
            for (int j = 0; j <= i / 2.0f; ++j) {
                this.worldObjr.func_72869_a("portal", par2EntityLiving.field_70165_t, par2EntityLiving.field_70163_u + 1.0, par2EntityLiving.field_70161_v, this.worldObjr.field_73012_v.nextGaussian(), this.worldObjr.field_73012_v.nextGaussian(), this.worldObjr.field_73012_v.nextGaussian());
            }
        }
        par1ItemStack.func_77972_a(1, par3EntityLiving);
        return true;
    }
    
    public int func_77626_a(final ItemStack par1ItemStack) {
        return 3000;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94581_a(final IIconRegister iconRegister) {
        this.field_77791_bV = iconRegister.func_94245_a("OreSpawn:" + this.func_77658_a().substring(5));
    }
}

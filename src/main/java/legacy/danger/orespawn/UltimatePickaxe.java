// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Items;
import net.minecraft.init.Blocks;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;

public class UltimatePickaxe extends ItemPickaxe
{
    private int weaponDamage;
    
    public UltimatePickaxe(final int par1, final Item.ToolMaterial par2) {
        super(par2);
        this.weaponDamage = 15;
        this.field_77777_bU = 1;
        this.func_77656_e(3000);
        this.func_77637_a(CreativeTabs.field_78040_i);
    }
    
    public void func_77622_d(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        par1ItemStack.func_77966_a(Enchantment.field_77349_p, 5);
        par1ItemStack.func_77966_a(Enchantment.field_77346_s, 5);
    }
    
    public void onUsingTick(final ItemStack stack, final EntityPlayer player, final int count) {
        final int lvl = EnchantmentHelper.func_77506_a(Enchantment.field_77349_p.field_77352_x, stack);
        if (lvl <= 0) {
            stack.func_77966_a(Enchantment.field_77349_p, 5);
            stack.func_77966_a(Enchantment.field_77346_s, 5);
        }
    }
    
    public void func_77663_a(final ItemStack stack, final World par2World, final Entity par3Entity, final int par4, final boolean par5) {
        this.onUsingTick(stack, null, 0);
    }
    
    public boolean canHarvestBlock(final Block par1Block) {
        return true;
    }
    
    public int getDamageVsEntity(final Entity par1Entity) {
        if (par1Entity instanceof Girlfriend) {
            return 1;
        }
        if (par1Entity instanceof Boyfriend) {
            return 1;
        }
        if (par1Entity instanceof EntityPlayer) {
            return 1;
        }
        return this.weaponDamage;
    }
    
    public boolean onLeftClickEntity(final ItemStack stack, final EntityPlayer player, final Entity entity) {
        if (entity != null && OreSpawnMain.ultimate_sword_pvp == 0) {
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
    
    private ItemStack dropItemAnItem(final World world, final int x, final int y, final int z, final Item index, final int par1) {
        EntityItem var3 = null;
        final ItemStack is = new ItemStack(index, par1, 0);
        var3 = new EntityItem(world, (double)x, (double)y, (double)z, is);
        if (var3 != null) {
            world.func_72838_d((Entity)var3);
        }
        return is;
    }
    
    public boolean func_150894_a(final ItemStack par1ItemStack, final World par2World, final Block par3, final int par4, final int par5, final int par6, final EntityLivingBase par7EntityLivingBase) {
        if (par3.func_149712_f(par2World, par4, par5, par6) != 0.0) {
            par1ItemStack.func_77972_a(1, par7EntityLivingBase);
        }
        if (!par2World.field_72995_K) {
            if (par3 == Blocks.field_150366_p && par2World.field_73012_v.nextInt(2) != 0) {
                this.dropItemAnItem(par2World, par4, par5, par6, Items.field_151042_j, 1 + par2World.field_73012_v.nextInt(2));
            }
            if (par3 == Blocks.field_150352_o && par2World.field_73012_v.nextInt(2) != 0) {
                this.dropItemAnItem(par2World, par4, par5, par6, Items.field_151043_k, 1 + par2World.field_73012_v.nextInt(2));
            }
            if (par3 == Blocks.field_150348_b && par2World.field_73012_v.nextInt(100) == 2) {
                final int i = par2World.field_73012_v.nextInt(10);
                if (i == 0) {
                    this.dropItemAnItem(par2World, par4, par5, par6, Items.field_151045_i, 1);
                }
                if (i == 1) {
                    this.dropItemAnItem(par2World, par4, par5, par6, Items.field_151166_bC, 1);
                }
                if (i == 2) {
                    this.dropItemAnItem(par2World, par4, par5, par6, OreSpawnMain.MyAmethyst, 1);
                }
                if (i == 3) {
                    this.dropItemAnItem(par2World, par4, par5, par6, OreSpawnMain.MyRuby, 1);
                }
                if (i == 4) {
                    this.dropItemAnItem(par2World, par4, par5, par6, OreSpawnMain.UraniumNugget, 1);
                }
                if (i == 5) {
                    this.dropItemAnItem(par2World, par4, par5, par6, OreSpawnMain.TitaniumNugget, 1);
                }
            }
        }
        return true;
    }
    
    public String getMaterialName() {
        return "Uranium/Titanium";
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94581_a(final IIconRegister iconRegister) {
        this.field_77791_bV = iconRegister.func_94245_a("OreSpawn:" + this.func_77658_a().substring(5));
    }
}

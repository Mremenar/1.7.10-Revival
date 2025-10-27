// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import java.util.Iterator;
import java.util.List;
import net.minecraft.util.DamageSource;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;

public class UltimateSword extends ItemSword
{
    private int swingtimer;
    private boolean leaf;
    
    public UltimateSword(final int par1, final Item.ToolMaterial par2EnumToolMaterial) {
        super(par2EnumToolMaterial);
        this.swingtimer = 0;
        this.leaf = false;
        this.field_77777_bU = 1;
        this.func_77656_e(3000);
        this.func_77637_a(CreativeTabs.field_78037_j);
    }
    
    public void func_77622_d(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        if (this == OreSpawnMain.MyChainsaw) {
            return;
        }
        if (this != OreSpawnMain.MyBattleAxe) {
            par1ItemStack.func_77966_a(Enchantment.field_77338_j, OreSpawnMain.UltimateSwordMagic);
            par1ItemStack.func_77966_a(Enchantment.field_77339_k, OreSpawnMain.UltimateSwordMagic);
            par1ItemStack.func_77966_a(Enchantment.field_77336_l, OreSpawnMain.UltimateSwordMagic);
            par1ItemStack.func_77966_a(Enchantment.field_77337_m, 1 + OreSpawnMain.UltimateSwordMagic / 2);
            par1ItemStack.func_77966_a(Enchantment.field_77335_o, 1 + OreSpawnMain.UltimateSwordMagic / 2);
            par1ItemStack.func_77966_a(Enchantment.field_77347_r, 1 + OreSpawnMain.UltimateSwordMagic / 2);
            par1ItemStack.func_77966_a(Enchantment.field_77334_n, 1 + OreSpawnMain.UltimateSwordMagic / 3);
        }
        else {
            par1ItemStack.func_77966_a(Enchantment.field_77335_o, 1 + OreSpawnMain.UltimateSwordMagic / 2);
            par1ItemStack.func_77966_a(Enchantment.field_77347_r, 1 + OreSpawnMain.UltimateSwordMagic / 2);
        }
    }
    
    public boolean onEntitySwing(final EntityLivingBase entityLiving, final ItemStack stack) {
        if (this == OreSpawnMain.MyChainsaw && entityLiving != null && this.swingtimer == 0) {
            entityLiving.func_85030_a("orespawn:chainsawshort", 1.0f, entityLiving.field_70170_p.field_73012_v.nextFloat() * 0.2f + 0.9f);
            this.swingtimer = 50;
        }
        return false;
    }
    
    public void onUsingTick(final ItemStack stack, final EntityPlayer player, final int count) {
        if (this == OreSpawnMain.MyChainsaw) {
            return;
        }
        final int lvl = EnchantmentHelper.func_77506_a(Enchantment.field_77335_o.field_77352_x, stack);
        if (lvl <= 0) {
            if (this != OreSpawnMain.MyBattleAxe) {
                stack.func_77966_a(Enchantment.field_77338_j, OreSpawnMain.UltimateSwordMagic);
                stack.func_77966_a(Enchantment.field_77339_k, OreSpawnMain.UltimateSwordMagic);
                stack.func_77966_a(Enchantment.field_77336_l, OreSpawnMain.UltimateSwordMagic);
                stack.func_77966_a(Enchantment.field_77337_m, 1 + OreSpawnMain.UltimateSwordMagic / 2);
                stack.func_77966_a(Enchantment.field_77335_o, 1 + OreSpawnMain.UltimateSwordMagic / 2);
                stack.func_77966_a(Enchantment.field_77347_r, 1 + OreSpawnMain.UltimateSwordMagic / 2);
                stack.func_77966_a(Enchantment.field_77334_n, 1 + OreSpawnMain.UltimateSwordMagic / 3);
            }
            else {
                stack.func_77966_a(Enchantment.field_77335_o, 1 + OreSpawnMain.UltimateSwordMagic / 2);
                stack.func_77966_a(Enchantment.field_77347_r, 1 + OreSpawnMain.UltimateSwordMagic / 2);
            }
        }
    }
    
    public void func_77663_a(final ItemStack stack, final World par2World, final Entity par3Entity, final int par4, final boolean par5) {
        if (this == OreSpawnMain.MyChainsaw) {
            if (this.swingtimer > 0) {
                --this.swingtimer;
            }
            if (par2World.field_72995_K && this.swingtimer > 0) {
                final float f = 1.0f;
                final float dx = (float)(f * Math.cos(Math.toRadians(par3Entity.field_70177_z + 90.0f + 45.0f)));
                final float dz = (float)(f * Math.sin(Math.toRadians(par3Entity.field_70177_z + 90.0f + 45.0f)));
                if (par2World.field_73012_v.nextInt(8) == 0) {
                    par2World.func_72869_a("flame", par3Entity.field_70165_t + dx, par3Entity.field_70163_u, par3Entity.field_70161_v + dz, (double)((par2World.field_73012_v.nextFloat() - par2World.field_73012_v.nextFloat()) / 20.0f), (double)(par2World.field_73012_v.nextFloat() / 10.0f), (double)((par2World.field_73012_v.nextFloat() - par2World.field_73012_v.nextFloat()) / 20.0f));
                }
                if (par2World.field_73012_v.nextInt(2) == 0) {
                    par2World.func_72869_a("smoke", par3Entity.field_70165_t + dx, par3Entity.field_70163_u, par3Entity.field_70161_v + dz, (double)((par2World.field_73012_v.nextFloat() - par2World.field_73012_v.nextFloat()) / 20.0f), (double)(par2World.field_73012_v.nextFloat() / 10.0f), (double)((par2World.field_73012_v.nextFloat() - par2World.field_73012_v.nextFloat()) / 20.0f));
                }
                if (par2World.field_73012_v.nextInt(10) == 0) {
                    par2World.func_72869_a("fireworksSpark", par3Entity.field_70165_t + dx, par3Entity.field_70163_u, par3Entity.field_70161_v + dz, (double)((par2World.field_73012_v.nextFloat() - par2World.field_73012_v.nextFloat()) / 20.0f), (double)(par2World.field_73012_v.nextFloat() / 5.0f), (double)((par2World.field_73012_v.nextFloat() - par2World.field_73012_v.nextFloat()) / 20.0f));
                }
            }
            return;
        }
        final int lvl = EnchantmentHelper.func_77506_a(Enchantment.field_77335_o.field_77352_x, stack);
        if (lvl <= 0) {
            if (this != OreSpawnMain.MyBattleAxe) {
                stack.func_77966_a(Enchantment.field_77338_j, OreSpawnMain.UltimateSwordMagic);
                stack.func_77966_a(Enchantment.field_77339_k, OreSpawnMain.UltimateSwordMagic);
                stack.func_77966_a(Enchantment.field_77336_l, OreSpawnMain.UltimateSwordMagic);
                stack.func_77966_a(Enchantment.field_77337_m, 1 + OreSpawnMain.UltimateSwordMagic / 2);
                stack.func_77966_a(Enchantment.field_77335_o, 1 + OreSpawnMain.UltimateSwordMagic / 2);
                stack.func_77966_a(Enchantment.field_77347_r, 1 + OreSpawnMain.UltimateSwordMagic / 2);
                stack.func_77966_a(Enchantment.field_77334_n, 1 + OreSpawnMain.UltimateSwordMagic / 3);
            }
            else {
                stack.func_77966_a(Enchantment.field_77335_o, 1 + OreSpawnMain.UltimateSwordMagic / 2);
                stack.func_77966_a(Enchantment.field_77347_r, 1 + OreSpawnMain.UltimateSwordMagic / 2);
            }
        }
    }
    
    public String getMaterialName() {
        return "Uranium/Titanium";
    }
    
    public boolean hitEntity(final ItemStack par1ItemStack, final EntityLiving par2EntityLiving, final EntityLiving par3EntityLiving) {
        par1ItemStack.func_77972_a(1, (EntityLivingBase)par3EntityLiving);
        return true;
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
        if (this == OreSpawnMain.MyChainsaw && player != null) {
            this.findSomethingToHit(player);
        }
        return false;
    }
    
    public int func_77626_a(final ItemStack par1ItemStack) {
        return 9000;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94581_a(final IIconRegister iconRegister) {
        this.field_77791_bV = iconRegister.func_94245_a("OreSpawn:" + this.func_77658_a().substring(5));
    }
    
    private void findSomethingToHit(final EntityPlayer player) {
        final List var5 = player.field_70170_p.func_72872_a((Class)EntityLivingBase.class, player.field_70121_D.func_72314_b(5.0, 5.0, 5.0));
        final Iterator var6 = var5.iterator();
        Entity var7 = null;
        EntityLivingBase var8 = null;
        while (var6.hasNext()) {
            var7 = var6.next();
            var8 = (EntityLivingBase)var7;
            if (this.isSuitableTarget(var8, false, player)) {
                var8.func_70097_a(DamageSource.func_76365_a(player), (float)OreSpawnMain.chainsaw_stats.damage);
            }
        }
    }
    
    private boolean isSuitableTarget(final EntityLivingBase par1EntityLiving, final boolean par2, final EntityPlayer player) {
        if (par1EntityLiving == null) {
            return false;
        }
        if (par1EntityLiving == player) {
            return false;
        }
        if (!par1EntityLiving.func_70089_S()) {
            return false;
        }
        if (OreSpawnMain.ultimate_sword_pvp == 0) {
            if (par1EntityLiving instanceof EntityPlayer || par1EntityLiving instanceof Girlfriend || par1EntityLiving instanceof Boyfriend) {
                return false;
            }
            if (par1EntityLiving instanceof EntityTameable) {
                final EntityTameable t = (EntityTameable)par1EntityLiving;
                if (t.func_70909_n()) {
                    return false;
                }
            }
        }
        return this.MyCanSee(par1EntityLiving, player);
    }
    
    public boolean MyCanSee(final EntityLivingBase e, final EntityPlayer player) {
        int nblks = 10;
        final double cx = player.field_70165_t;
        final double cz = player.field_70161_v;
        float startx = (float)cx;
        float starty = (float)(player.field_70163_u + 1.399999976158142);
        float startz = (float)cz;
        float dx = (float)((e.field_70165_t - startx) / 10.0);
        float dy = (float)((e.field_70163_u + e.field_70131_O / 2.0f - starty) / 10.0);
        float dz = (float)((e.field_70161_v - startz) / 10.0);
        if (Math.abs(dx) > 1.0) {
            dy /= Math.abs(dx);
            dz /= Math.abs(dx);
            nblks *= (int)Math.abs(dx);
            if (dx > 1.0f) {
                dx = 1.0f;
            }
            if (dx < -1.0f) {
                dx = -1.0f;
            }
        }
        if (Math.abs(dy) > 1.0) {
            dx /= Math.abs(dy);
            dz /= Math.abs(dy);
            nblks *= (int)Math.abs(dy);
            if (dy > 1.0f) {
                dy = 1.0f;
            }
            if (dy < -1.0f) {
                dy = -1.0f;
            }
        }
        if (Math.abs(dz) > 1.0) {
            dy /= Math.abs(dz);
            dx /= Math.abs(dz);
            nblks *= (int)Math.abs(dz);
            if (dz > 1.0f) {
                dz = 1.0f;
            }
            if (dz < -1.0f) {
                dz = -1.0f;
            }
        }
        for (int i = 0; i < nblks; ++i) {
            startx += dx;
            starty += dy;
            startz += dz;
            final Block bid = player.field_70170_p.func_147439_a((int)startx, (int)starty, (int)startz);
            if (bid != Blocks.field_150350_a) {
                return false;
            }
        }
        return true;
    }
    
    public boolean canHarvestBlock(final Block par1Block) {
        return this.canCrush(par1Block);
    }
    
    private boolean canCrush(final Block blockID) {
        if (this == OreSpawnMain.MyChainsaw) {
            return blockID == Blocks.field_150321_G || blockID == Blocks.field_150364_r || blockID == Blocks.field_150362_t || blockID == Blocks.field_150344_f || blockID == Blocks.field_150345_g || blockID == Blocks.field_150329_H || blockID == Blocks.field_150434_aF || blockID == OreSpawnMain.CrystalPlanksBlock || blockID == OreSpawnMain.MyAppleLeaves || blockID == OreSpawnMain.MySkyTreeLog || blockID == OreSpawnMain.MyDT || blockID == OreSpawnMain.MyExperienceLeaves || blockID == OreSpawnMain.MyScaryLeaves || blockID == OreSpawnMain.MyCherryLeaves || blockID == OreSpawnMain.MyPeachLeaves || blockID == OreSpawnMain.MyCrystalLeaves || blockID == OreSpawnMain.MyCrystalLeaves2 || blockID == OreSpawnMain.MyCrystalLeaves3 || blockID == OreSpawnMain.MyCrystalTreeLog;
        }
        return blockID == Blocks.field_150321_G;
    }
    
    private boolean isLeaves(final Block blockID) {
        return blockID == Blocks.field_150321_G || blockID == Blocks.field_150362_t || blockID == Blocks.field_150345_g || blockID == Blocks.field_150329_H || blockID == OreSpawnMain.MyAppleLeaves || blockID == OreSpawnMain.MyExperienceLeaves || blockID == OreSpawnMain.MyScaryLeaves || blockID == OreSpawnMain.MyCherryLeaves || blockID == OreSpawnMain.MyPeachLeaves || blockID == OreSpawnMain.MyCrystalLeaves || blockID == OreSpawnMain.MyCrystalLeaves2 || blockID == OreSpawnMain.MyCrystalLeaves3;
    }
    
    public boolean func_150894_a(final ItemStack par1ItemStack, final World par2World, final Block par3, final int par4, final int par5, final int par6, final EntityLivingBase par7EntityLivingBase) {
        if (this == OreSpawnMain.MyChainsaw && !par2World.field_72995_K) {
            for (int i = -5; i <= 5; ++i) {
                for (int j = -5; j <= 10; ++j) {
                    for (int k = -5; k <= 5; ++k) {
                        final Block bid = par2World.func_147439_a(par4 + i, par5 + j, par6 + k);
                        if (this.leaf) {
                            if (this.isLeaves(bid)) {
                                this.dropItemRand(par2World, Item.func_150898_a(bid), 1, par4 + i, par5 + j, par6 + k);
                                par2World.func_147449_b(par4 + i, par5 + j, par6 + k, Blocks.field_150350_a);
                            }
                        }
                        else if (this.canCrush(bid)) {
                            this.dropItemRand(par2World, Item.func_150898_a(bid), 1, par4 + i, par5 + j, par6 + k);
                            par2World.func_147449_b(par4 + i, par5 + j, par6 + k, Blocks.field_150350_a);
                        }
                    }
                }
            }
        }
        return super.func_150894_a(par1ItemStack, par2World, par3, par4, par5, par6, par7EntityLivingBase);
    }
    
    private ItemStack dropItemRand(final World world, final Item index, final int par1, final int x, final int y, final int z) {
        EntityItem var3 = null;
        final ItemStack is = new ItemStack(index, par1, 0);
        var3 = new EntityItem(world, (double)(x + OreSpawnMain.OreSpawnRand.nextInt(5) - OreSpawnMain.OreSpawnRand.nextInt(5)), y + 1.0 + world.field_73012_v.nextInt(5), (double)(z + OreSpawnMain.OreSpawnRand.nextInt(5) - OreSpawnMain.OreSpawnRand.nextInt(5)), is);
        if (var3 != null) {
            world.func_72838_d((Entity)var3);
        }
        return is;
    }
    
    public float getStrVsBlock(final ItemStack par1ItemStack, final Block par2Block) {
        if (par2Block != null && this == OreSpawnMain.MyChainsaw) {
            this.leaf = this.isLeaves(par2Block);
            if (par2Block.func_149688_o() == Material.field_151575_d || par2Block.func_149688_o() == Material.field_151585_k || par2Block.func_149688_o() == Material.field_151582_l) {
                return (float)OreSpawnMain.chainsaw_stats.efficiency;
            }
            if (this.canCrush(par2Block)) {
                return (float)OreSpawnMain.chainsaw_stats.efficiency;
            }
        }
        return 2.0f;
    }
}

// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.tileentity.TileEntityMobSpawner;
import java.util.Iterator;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityList;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.entity.monster.EntityMob;

public class CaterKiller extends EntityMob
{
    private GenericTargetSorter TargetSorter;
    private float moveSpeed;
    int foundmob;
    int ticker;
    private int closest;
    private int tx;
    private int ty;
    private int tz;
    
    public CaterKiller(final World par1World) {
        super(par1World);
        this.TargetSorter = null;
        this.moveSpeed = 0.35f;
        this.foundmob = 0;
        this.ticker = 0;
        this.closest = 99999;
        this.tx = 0;
        this.ty = 0;
        this.tz = 0;
        if (OreSpawnMain.PlayNicely == 0) {
            this.func_70105_a(2.9f, 4.6f);
        }
        else {
            this.func_70105_a(1.45f, 2.3f);
        }
        this.func_70661_as().func_75491_a(true);
        this.field_70728_aV = 200;
        this.field_70174_ab = 100;
        this.TargetSorter = new GenericTargetSorter((Entity)this);
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIMoveThroughVillage((EntityCreature)this, 1.0, false));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new MyEntityAIWanderALot((EntityCreature)this, 16, 1.0));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)this.mygetMaxHealth());
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)this.moveSpeed);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)OreSpawnMain.CaterKiller_stats.attack);
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_75682_a(20, (Object)0);
        this.field_70180_af.func_75682_a(21, (Object)OreSpawnMain.PlayNicely);
    }
    
    public int getPlayNicely() {
        return this.field_70180_af.func_75679_c(21);
    }
    
    protected boolean func_70692_ba() {
        return !this.func_104002_bU();
    }
    
    public boolean func_70097_a(final DamageSource par1DamageSource, final float par2) {
        Entity e = null;
        final Boolean ret = super.func_70097_a(par1DamageSource, par2);
        e = par1DamageSource.func_76346_g();
        if (e != null && e instanceof EntityLiving) {
            this.func_70624_b((EntityLivingBase)e);
        }
        return ret;
    }
    
    public void func_70071_h_() {
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)this.moveSpeed);
        super.func_70071_h_();
    }
    
    public int mygetMaxHealth() {
        return OreSpawnMain.CaterKiller_stats.health;
    }
    
    public int func_70658_aO() {
        return OreSpawnMain.CaterKiller_stats.defense;
    }
    
    protected boolean func_70650_aV() {
        return true;
    }
    
    public void func_70636_d() {
        super.func_70636_d();
    }
    
    protected String func_70639_aQ() {
        if (this.field_70146_Z.nextInt(3) == 0) {
            return "orespawn:caterkiller_living";
        }
        return null;
    }
    
    protected String func_70621_aR() {
        return "orespawn:caterkiller_hit";
    }
    
    protected String func_70673_aS() {
        return "orespawn:caterkiller_death";
    }
    
    protected float func_70599_aP() {
        return 1.5f;
    }
    
    protected float func_70647_i() {
        return 1.0f;
    }
    
    protected Item func_146068_u() {
        return Items.field_151082_bd;
    }
    
    private ItemStack dropItemRand(final Item index, final int par1) {
        EntityItem var3 = null;
        final ItemStack is = new ItemStack(index, par1, 0);
        var3 = new EntityItem(this.field_70170_p, this.field_70165_t + OreSpawnMain.OreSpawnRand.nextInt(5) - OreSpawnMain.OreSpawnRand.nextInt(5), this.field_70163_u + 1.0, this.field_70161_v + OreSpawnMain.OreSpawnRand.nextInt(5) - OreSpawnMain.OreSpawnRand.nextInt(5), is);
        if (var3 != null) {
            this.field_70170_p.func_72838_d((Entity)var3);
        }
        return is;
    }
    
    protected void func_70628_a(final boolean par1, final int par2) {
        ItemStack is = null;
        this.dropItemRand(OreSpawnMain.CaterKillerJaw, 1);
        this.dropItemRand(Items.field_151160_bD, 1);
        for (int var4 = 0; var4 < 10; ++var4) {
            this.dropItemRand(Items.field_151116_aA, 1);
        }
        for (int var4 = 0; var4 < 6; ++var4) {
            this.dropItemRand(Items.field_151082_bd, 1);
        }
        for (int i = 1 + this.field_70170_p.field_73012_v.nextInt(5), var4 = 0; var4 < i; ++var4) {
            final int var5 = this.field_70170_p.field_73012_v.nextInt(20);
            switch (var5) {
                case 0: {
                    is = this.dropItemRand(OreSpawnMain.MyUltimateSword, 1);
                    break;
                }
                case 1: {
                    is = this.dropItemRand(OreSpawnMain.MyRuby, 1);
                    break;
                }
                case 2: {
                    is = this.dropItemRand(Item.func_150898_a(Blocks.field_150484_ah), 1);
                    break;
                }
                case 3: {
                    is = this.dropItemRand(OreSpawnMain.MyRubySword, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77338_j, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77336_l, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77337_m, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77335_o, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77334_n, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77338_j, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                        break;
                    }
                    break;
                }
                case 4: {
                    is = this.dropItemRand(OreSpawnMain.MyRubyShovel, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77349_p, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                        break;
                    }
                    break;
                }
                case 5: {
                    is = this.dropItemRand(OreSpawnMain.MyRubyPickaxe, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77349_p, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77346_s, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                        break;
                    }
                    break;
                }
                case 6: {
                    is = this.dropItemRand(OreSpawnMain.MyRubyAxe, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77349_p, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                        break;
                    }
                    break;
                }
                case 7: {
                    is = this.dropItemRand(OreSpawnMain.MyRubyHoe, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77349_p, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                        break;
                    }
                    break;
                }
                case 8: {
                    is = this.dropItemRand((Item)OreSpawnMain.RubyHelmet, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77332_c, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77327_f, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77329_d, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77328_g, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77340_h, 1 + this.field_70170_p.field_73012_v.nextInt(2));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77341_i, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                        break;
                    }
                    break;
                }
                case 9: {
                    is = this.dropItemRand((Item)OreSpawnMain.RubyBody, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77332_c, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77327_f, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77329_d, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77328_g, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                        break;
                    }
                    break;
                }
                case 10: {
                    is = this.dropItemRand((Item)OreSpawnMain.RubyLegs, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77332_c, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77327_f, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77329_d, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77328_g, 1 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                        break;
                    }
                    break;
                }
                case 11: {
                    is = this.dropItemRand((Item)OreSpawnMain.RubyBoots, 1);
                    if (this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                        is.func_77966_a(Enchantment.field_77330_e, 5 + this.field_70170_p.field_73012_v.nextInt(5));
                    }
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        is.func_77966_a(Enchantment.field_77347_r, 2 + this.field_70170_p.field_73012_v.nextInt(4));
                        break;
                    }
                    break;
                }
                case 12: {
                    is = this.dropItemRand(OreSpawnMain.MyUltimateBow, 1);
                    break;
                }
            }
        }
        for (int var4 = 0; var4 < 25; ++var4) {
            spawnCreature(this.field_70170_p, "Butterfly", this.field_70165_t, this.field_70163_u + 1.0, this.field_70161_v);
        }
    }
    
    public static Entity spawnCreature(final World par0World, final String par1, final double par2, final double par4, final double par6) {
        Entity var8 = null;
        if (par0World == null) {
            return null;
        }
        var8 = EntityList.func_75620_a(par1, par0World);
        if (var8 != null) {
            var8.func_70012_b(par2, par4, par6, par0World.field_73012_v.nextFloat() * 360.0f, 0.0f);
            par0World.func_72838_d(var8);
            ((EntityLiving)var8).func_70642_aH();
        }
        return var8;
    }
    
    public void initCreature() {
    }
    
    public boolean func_70085_c(final EntityPlayer par1EntityPlayer) {
        return false;
    }
    
    public boolean func_70652_k(final Entity par1Entity) {
        if (super.func_70652_k(par1Entity)) {
            if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
                final double ks = 1.2;
                double inair = 0.1;
                final float f3 = (float)Math.atan2(par1Entity.field_70161_v - this.field_70161_v, par1Entity.field_70165_t - this.field_70165_t);
                if (par1Entity.field_70128_L || par1Entity instanceof EntityPlayer) {
                    inair *= 2.0;
                }
                par1Entity.func_70024_g(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
            }
            return true;
        }
        return false;
    }
    
    private boolean scan_it(final int x, final int y, final int z, final int dx, final int dy, final int dz) {
        int found = 0;
        for (int i = -dy; i <= dy; ++i) {
            for (int j = -dz; j <= dz; ++j) {
                Block bid = this.field_70170_p.func_147439_a(x + dx, y + i, z + j);
                if (bid == Blocks.field_150362_t || bid == Blocks.field_150395_bd || bid == Blocks.field_150364_r || bid == OreSpawnMain.MyDT || bid == Blocks.field_150363_s || bid == Blocks.field_150361_u || bid == OreSpawnMain.MyAppleLeaves || bid == OreSpawnMain.MyExperienceLeaves || bid == OreSpawnMain.MyScaryLeaves || bid == OreSpawnMain.MyPeachLeaves || bid == OreSpawnMain.MyCherryLeaves) {
                    final int d = dx * dx + j * j + i * i;
                    if (d < this.closest) {
                        this.closest = d;
                        this.tx = x + dx;
                        this.ty = y + i;
                        this.tz = z + j;
                        ++found;
                    }
                }
                bid = this.field_70170_p.func_147439_a(x - dx, y + i, z + j);
                if (bid == Blocks.field_150362_t || bid == Blocks.field_150395_bd || bid == Blocks.field_150364_r || bid == OreSpawnMain.MyDT || bid == Blocks.field_150363_s || bid == Blocks.field_150361_u || bid == OreSpawnMain.MyAppleLeaves || bid == OreSpawnMain.MyExperienceLeaves || bid == OreSpawnMain.MyScaryLeaves || bid == OreSpawnMain.MyPeachLeaves || bid == OreSpawnMain.MyCherryLeaves) {
                    final int d = dx * dx + j * j + i * i;
                    if (d < this.closest) {
                        this.closest = d;
                        this.tx = x - dx;
                        this.ty = y + i;
                        this.tz = z + j;
                        ++found;
                    }
                }
            }
        }
        for (int i = -dx; i <= dx; ++i) {
            for (int j = -dz; j <= dz; ++j) {
                Block bid = this.field_70170_p.func_147439_a(x + i, y + dy, z + j);
                if (bid == Blocks.field_150362_t || bid == Blocks.field_150395_bd || bid == Blocks.field_150364_r || bid == OreSpawnMain.MyDT || bid == Blocks.field_150363_s || bid == Blocks.field_150361_u || bid == OreSpawnMain.MyAppleLeaves || bid == OreSpawnMain.MyExperienceLeaves || bid == OreSpawnMain.MyScaryLeaves || bid == OreSpawnMain.MyPeachLeaves || bid == OreSpawnMain.MyCherryLeaves) {
                    final int d = dy * dy + j * j + i * i;
                    if (d < this.closest) {
                        this.closest = d;
                        this.tx = x + i;
                        this.ty = y + dy;
                        this.tz = z + j;
                        ++found;
                    }
                }
                bid = this.field_70170_p.func_147439_a(x + i, y - dy, z + j);
                if (bid == Blocks.field_150362_t || bid == Blocks.field_150395_bd || bid == Blocks.field_150364_r || bid == OreSpawnMain.MyDT || bid == Blocks.field_150363_s || bid == Blocks.field_150361_u || bid == OreSpawnMain.MyAppleLeaves || bid == OreSpawnMain.MyExperienceLeaves || bid == OreSpawnMain.MyScaryLeaves || bid == OreSpawnMain.MyPeachLeaves || bid == OreSpawnMain.MyCherryLeaves) {
                    final int d = dy * dy + j * j + i * i;
                    if (d < this.closest) {
                        this.closest = d;
                        this.tx = x + i;
                        this.ty = y - dy;
                        this.tz = z + j;
                        ++found;
                    }
                }
            }
        }
        for (int i = -dx; i <= dx; ++i) {
            for (int j = -dy; j <= dy; ++j) {
                Block bid = this.field_70170_p.func_147439_a(x + i, y + j, z + dz);
                if (bid == Blocks.field_150362_t || bid == Blocks.field_150395_bd || bid == Blocks.field_150364_r || bid == OreSpawnMain.MyDT || bid == Blocks.field_150363_s || bid == Blocks.field_150361_u || bid == OreSpawnMain.MyAppleLeaves || bid == OreSpawnMain.MyExperienceLeaves || bid == OreSpawnMain.MyScaryLeaves || bid == OreSpawnMain.MyPeachLeaves || bid == OreSpawnMain.MyCherryLeaves) {
                    final int d = dz * dz + j * j + i * i;
                    if (d < this.closest) {
                        this.closest = d;
                        this.tx = x + i;
                        this.ty = y + j;
                        this.tz = z + dz;
                        ++found;
                    }
                }
                bid = this.field_70170_p.func_147439_a(x + i, y + j, z - dz);
                if (bid == Blocks.field_150362_t || bid == Blocks.field_150395_bd || bid == Blocks.field_150364_r || bid == OreSpawnMain.MyDT || bid == Blocks.field_150363_s || bid == Blocks.field_150361_u || bid == OreSpawnMain.MyAppleLeaves || bid == OreSpawnMain.MyExperienceLeaves || bid == OreSpawnMain.MyScaryLeaves || bid == OreSpawnMain.MyPeachLeaves || bid == OreSpawnMain.MyCherryLeaves) {
                    final int d = dz * dz + j * j + i * i;
                    if (d < this.closest) {
                        this.closest = d;
                        this.tx = x + i;
                        this.ty = y + j;
                        this.tz = z - dz;
                        ++found;
                    }
                }
            }
        }
        return found != 0;
    }
    
    protected void func_70619_bc() {
        if (this.field_70128_L) {
            return;
        }
        super.func_70619_bc();
        this.field_70180_af.func_75692_b(21, (Object)OreSpawnMain.PlayNicely);
        if (this.func_110143_aJ() + 1.0f < this.func_110138_aP()) {
            ++this.ticker;
            if (this.ticker > 2400) {
                spawnCreature(this.field_70170_p, "Brutalfly", this.field_70165_t, this.field_70163_u + 4.0, this.field_70161_v);
                this.func_85030_a("random.explode", 1.0f, this.field_70170_p.field_73012_v.nextFloat() * 0.2f + 0.9f);
                for (int i = 0; i < 10; ++i) {
                    spawnCreature(this.field_70170_p, "Butterfly", this.field_70165_t, this.field_70163_u + 1.0 + this.field_70170_p.field_73012_v.nextInt(4), this.field_70161_v);
                }
                this.func_70106_y();
                return;
            }
        }
        if (this.field_70134_J) {
            for (int i = -2; i <= 2; ++i) {
                for (int j = -1; j < 5; ++j) {
                    for (int k = -2; k <= 2; ++k) {
                        if (this.field_70170_p.func_147439_a((int)this.field_70165_t + i, (int)this.field_70163_u + j, (int)this.field_70161_v + k) == Blocks.field_150321_G) {
                            this.field_70170_p.func_147449_b((int)this.field_70165_t + i, (int)this.field_70163_u + j, (int)this.field_70161_v + k, Blocks.field_150350_a);
                            this.field_70170_p.func_72921_c((int)this.field_70165_t + i, (int)this.field_70163_u + j, (int)this.field_70161_v + k, 0, 3);
                        }
                    }
                }
            }
            this.field_70134_J = false;
        }
        if (this.field_70170_p.field_73012_v.nextInt(4) == 0) {
            EntityLivingBase e = this.func_70638_az();
            if (e != null && !e.func_70089_S()) {
                this.func_70624_b((EntityLivingBase)null);
                e = null;
            }
            if (this.field_70170_p.field_73012_v.nextInt(200) == 0) {
                this.func_70624_b((EntityLivingBase)null);
            }
            if (e == null) {
                e = this.findSomethingToAttack();
            }
            if (e != null) {
                this.foundmob = 1;
                this.func_70625_a((Entity)e, 10.0f, 10.0f);
                if (this.func_70068_e((Entity)e) < (5.0f + e.field_70130_N / 2.0f) * (5.0f + e.field_70130_N / 2.0f)) {
                    this.setAttacking(1);
                    if (this.field_70170_p.field_73012_v.nextInt(3) == 0 || this.field_70170_p.field_73012_v.nextInt(4) == 1) {
                        this.func_70652_k((Entity)e);
                    }
                }
                else {
                    this.setAttacking(0);
                    this.func_70661_as().func_75497_a((Entity)e, 1.25);
                    if (this.field_70170_p.field_73012_v.nextInt(4) == 0) {
                        double dx = e.field_70165_t;
                        double dz = e.field_70161_v;
                        dx += (this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat()) * 2.0;
                        dz += (this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat()) * 2.0;
                        for (int i = 2; i > -2; --i) {
                            if (this.field_70170_p.func_147439_a((int)dx, (int)e.field_70163_u + i + 1, (int)dz) == Blocks.field_150350_a && this.field_70170_p.func_147439_a((int)dx, (int)e.field_70163_u + i, (int)dz) != Blocks.field_150350_a) {
                                this.field_70170_p.func_147449_b((int)dx, (int)e.field_70163_u + i + 1, (int)dz, Blocks.field_150321_G);
                                break;
                            }
                        }
                    }
                }
            }
            else {
                this.setAttacking(0);
                this.foundmob = 0;
            }
        }
        if (((this.field_70170_p.field_73012_v.nextInt(8) == 0 && this.func_110143_aJ() < this.mygetMaxHealth()) || this.field_70170_p.field_73012_v.nextInt(30) == 0) && OreSpawnMain.PlayNicely == 0) {
            this.closest = 99999;
            final int tx = 0;
            this.tz = tx;
            this.ty = tx;
            this.tx = tx;
            for (int i = 1; i < 13; ++i) {
                int j = i;
                if (j > 9) {
                    j = 9;
                }
                if (this.scan_it((int)this.field_70165_t, (int)this.field_70163_u + 1, (int)this.field_70161_v, i, j, i)) {
                    break;
                }
                if (i >= 9) {
                    ++i;
                }
            }
            if (this.closest < 99999) {
                if (this.foundmob == 0) {
                    this.func_70661_as().func_75492_a((double)this.tx, (double)this.ty, (double)this.tz, 1.0);
                }
                if (this.closest < 81) {
                    if (this.field_70170_p.func_82736_K().func_82766_b("mobGriefing")) {
                        this.field_70170_p.func_147465_d(this.tx, this.ty, this.tz, Blocks.field_150350_a, 0, 2);
                    }
                    this.func_70691_i(2.0f);
                    if (this.field_70170_p.field_73012_v.nextInt(20) == 1) {
                        this.func_85030_a("random.burp", 1.0f, this.field_70170_p.field_73012_v.nextFloat() * 0.2f + 0.9f);
                    }
                }
            }
        }
    }
    
    private boolean isSuitableTarget(final EntityLivingBase par1EntityLiving, final boolean par2) {
        if (par1EntityLiving == null) {
            return false;
        }
        if (par1EntityLiving == this) {
            return false;
        }
        if (!par1EntityLiving.func_70089_S()) {
            return false;
        }
        if (!this.MyCanSee(par1EntityLiving)) {
            return false;
        }
        if (par1EntityLiving instanceof EntityPlayer) {
            final EntityPlayer p = (EntityPlayer)par1EntityLiving;
            return !p.field_71075_bZ.field_75098_d;
        }
        if (par1EntityLiving instanceof CaterKiller) {
            return false;
        }
        if (par1EntityLiving instanceof EntityMob) {
            return true;
        }
        final MyUtils oreSpawnUtils = OreSpawnMain.OreSpawnUtils;
        return MyUtils.isAttackableNonMob(par1EntityLiving);
    }
    
    private EntityLivingBase findSomethingToAttack() {
        if (OreSpawnMain.PlayNicely != 0) {
            return null;
        }
        final List var5 = this.field_70170_p.func_72872_a((Class)EntityLivingBase.class, this.field_70121_D.func_72314_b(20.0, 8.0, 20.0));
        Collections.sort((List<Object>)var5, this.TargetSorter);
        final Iterator var6 = var5.iterator();
        Entity var7 = null;
        EntityLivingBase var8 = null;
        while (var6.hasNext()) {
            var7 = var6.next();
            var8 = (EntityLivingBase)var7;
            if (this.isSuitableTarget(var8, false)) {
                return var8;
            }
        }
        return null;
    }
    
    public final int getAttacking() {
        return this.field_70180_af.func_75683_a(20);
    }
    
    public final void setAttacking(final int par1) {
        this.field_70180_af.func_75692_b(20, (Object)(byte)par1);
    }
    
    public boolean func_70601_bi() {
        for (int k = -3; k < 3; ++k) {
            for (int j = -3; j < 3; ++j) {
                for (int i = 0; i < 5; ++i) {
                    final Block bid = this.field_70170_p.func_147439_a((int)this.field_70165_t + j, (int)this.field_70163_u + i, (int)this.field_70161_v + k);
                    if (bid == Blocks.field_150474_ac) {
                        TileEntityMobSpawner tileentitymobspawner = null;
                        tileentitymobspawner = (TileEntityMobSpawner)this.field_70170_p.func_147438_o((int)this.field_70165_t + j, (int)this.field_70163_u + i, (int)this.field_70161_v + k);
                        final String s = tileentitymobspawner.func_145881_a().func_98276_e();
                        if (s != null && s.equals("CaterKiller")) {
                            return true;
                        }
                    }
                }
            }
        }
        if (this.field_70163_u < 50.0) {
            return false;
        }
        if (this.field_70170_p.field_73012_v.nextInt(10) != 0) {
            return false;
        }
        if (!this.field_70170_p.func_72935_r()) {
            return false;
        }
        for (int k = -1; k < 2; ++k) {
            for (int j = -1; j < 2; ++j) {
                for (int i = 1; i < 5; ++i) {
                    final Block bid = this.field_70170_p.func_147439_a((int)this.field_70165_t + j, (int)this.field_70163_u + i, (int)this.field_70161_v + k);
                    if (bid != Blocks.field_150350_a && bid != Blocks.field_150362_t && bid != Blocks.field_150361_u && bid != Blocks.field_150364_r && bid != Blocks.field_150363_s) {
                        return false;
                    }
                }
            }
        }
        CaterKiller target = null;
        target = (CaterKiller)this.field_70170_p.func_72857_a((Class)CaterKiller.class, this.field_70121_D.func_72314_b(48.0, 16.0, 48.0), (Entity)this);
        return target == null;
    }
    
    public boolean MyCanSee(final EntityLivingBase e) {
        final double xzoff = 2.5;
        int nblks = 10;
        final double cx = this.field_70165_t - xzoff * Math.sin(Math.toRadians(this.field_70177_z));
        final double cz = this.field_70161_v + xzoff * Math.cos(Math.toRadians(this.field_70177_z));
        float startx = (float)cx;
        float starty = (float)(this.field_70163_u + 3.0);
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
            final Block bid = this.field_70170_p.func_147439_a((int)startx, (int)starty, (int)startz);
            if (bid != Blocks.field_150350_a) {
                if (bid != Blocks.field_150321_G) {
                    if (bid != Blocks.field_150329_H) {
                        if (bid != Blocks.field_150362_t) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}

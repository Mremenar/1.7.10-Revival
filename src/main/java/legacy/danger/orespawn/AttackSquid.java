// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.nbt.NBTTagCompound;
import java.util.Iterator;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.util.MathHelper;
import net.minecraft.block.Block;
import net.minecraft.util.DamageSource;
import net.minecraft.init.Blocks;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;

public class AttackSquid extends EntityMob
{
    private GenericTargetSorter TargetSorter;
    private EntityLivingBase buddy;
    private float moveSpeed;
    private int wasshot;
    private int closest;
    private int tx;
    private int ty;
    private int tz;
    
    public AttackSquid(final World par1World) {
        super(par1World);
        this.TargetSorter = null;
        this.buddy = null;
        this.moveSpeed = 0.25f;
        this.wasshot = 0;
        this.closest = 99999;
        this.tx = 0;
        this.ty = 0;
        this.tz = 0;
        this.func_70105_a(1.0f, 1.25f);
        this.func_70661_as().func_75491_a(false);
        this.field_70728_aV = 15;
        this.field_70174_ab = 3;
        this.field_70178_ae = false;
        this.TargetSorter = new GenericTargetSorter((Entity)this);
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new MyEntityAIWanderALot((EntityCreature)this, 16, 1.0));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)this.mygetMaxHealth());
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)this.moveSpeed);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)OreSpawnMain.AttackSquid_stats.attack);
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_75682_a(20, (Object)0);
    }
    
    protected boolean func_70692_ba() {
        return !this.func_104002_bU();
    }
    
    public void setWasShot() {
        this.wasshot = 250;
    }
    
    public void func_70071_h_() {
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)this.moveSpeed);
        super.func_70071_h_();
    }
    
    public int mygetMaxHealth() {
        return OreSpawnMain.AttackSquid_stats.health;
    }
    
    public int func_70658_aO() {
        return OreSpawnMain.AttackSquid_stats.defense;
    }
    
    protected boolean func_70650_aV() {
        return true;
    }
    
    public void func_70636_d() {
        super.func_70636_d();
    }
    
    public int getAttackStrength(final Entity par1Entity) {
        final int var2 = 2;
        return var2;
    }
    
    protected String func_70639_aQ() {
        return null;
    }
    
    protected String func_70621_aR() {
        return "orespawn:squid_hurt";
    }
    
    protected String func_70673_aS() {
        return "orespawn:squid_death";
    }
    
    public static Entity spawnCreature(final World par0World, final String par1, final double par2, final double par4, final double par6) {
        Entity var8 = null;
        var8 = EntityList.func_75620_a(par1, par0World);
        if (var8 != null) {
            var8.func_70012_b(par2, par4, par6, par0World.field_73012_v.nextFloat() * 360.0f, 0.0f);
            par0World.func_72838_d(var8);
            ((EntityLiving)var8).func_70642_aH();
        }
        return var8;
    }
    
    protected float func_70599_aP() {
        return 1.0f;
    }
    
    protected float func_70647_i() {
        return 1.0f;
    }
    
    protected Item func_146068_u() {
        return Items.field_151115_aP;
    }
    
    private ItemStack dropItemRand(final Item index, final int par1) {
        EntityItem var3 = null;
        final ItemStack is = new ItemStack(index, par1, 0);
        var3 = new EntityItem(this.field_70170_p, this.field_70165_t + OreSpawnMain.OreSpawnRand.nextInt(2) - OreSpawnMain.OreSpawnRand.nextInt(2), this.field_70163_u + 1.0, this.field_70161_v + OreSpawnMain.OreSpawnRand.nextInt(2) - OreSpawnMain.OreSpawnRand.nextInt(2), is);
        if (var3 != null) {
            this.field_70170_p.func_72838_d((Entity)var3);
        }
        return is;
    }
    
    protected void func_70628_a(final boolean par1, final int par2) {
        ItemStack is = null;
        int var4 = this.field_70170_p.field_73012_v.nextInt(50);
        switch (var4) {
            case 0: {
                is = this.dropItemRand(Items.field_151074_bl, 1);
                break;
            }
            case 1: {
                is = this.dropItemRand(Items.field_151043_k, 1);
                break;
            }
            case 2: {
                is = this.dropItemRand(Items.field_151150_bK, 1);
                break;
            }
            case 3: {
                is = this.dropItemRand(Items.field_151010_B, 1);
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
                is = this.dropItemRand(Items.field_151011_C, 1);
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
                is = this.dropItemRand(Items.field_151005_D, 1);
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
                is = this.dropItemRand(Items.field_151006_E, 1);
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
                is = this.dropItemRand(Items.field_151013_M, 1);
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
                is = this.dropItemRand((Item)Items.field_151169_ag, 1);
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
                is = this.dropItemRand((Item)Items.field_151171_ah, 1);
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
                is = this.dropItemRand((Item)Items.field_151149_ai, 1);
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
                is = this.dropItemRand((Item)Items.field_151151_aj, 1);
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
                this.dropItemRand(Items.field_151153_ao, 1);
                break;
            }
            case 13: {
                this.dropItemRand(Item.func_150898_a(Blocks.field_150340_R), 1);
                break;
            }
            case 14: {
                EntityItem var5 = null;
                is = new ItemStack(Items.field_151153_ao, 1, 1);
                var5 = new EntityItem(this.field_70170_p, this.field_70165_t + OreSpawnMain.OreSpawnRand.nextInt(3) - OreSpawnMain.OreSpawnRand.nextInt(3), this.field_70163_u + 1.0, this.field_70161_v + OreSpawnMain.OreSpawnRand.nextInt(3) - OreSpawnMain.OreSpawnRand.nextInt(3), is);
                if (var5 != null) {
                    this.field_70170_p.func_72838_d((Entity)var5);
                }
                break;
            }
            case 15:
            case 16:
            case 17: {
                this.dropItemRand(Items.field_151100_aR, 1);
                break;
            }
        }
        int i;
        for (i = 1 + this.field_70170_p.field_73012_v.nextInt(3), var4 = 0; var4 < i; ++var4) {
            this.dropItemRand(Items.field_151115_aP, 1);
        }
    }
    
    public void initCreature() {
    }
    
    public boolean func_70085_c(final EntityPlayer par1EntityPlayer) {
        return false;
    }
    
    public boolean func_70652_k(final Entity par1Entity) {
        return super.func_70652_k(par1Entity);
    }
    
    protected void func_70069_a(final float par1) {
        if (this.wasshot != 0) {
            return;
        }
        super.func_70069_a(par1);
    }
    
    public boolean func_70097_a(final DamageSource par1DamageSource, final float par2) {
        boolean ret = false;
        if (this.field_70128_L) {
            return false;
        }
        final Entity e = par1DamageSource.func_76346_g();
        if (e != null && e instanceof AttackSquid) {
            return false;
        }
        if (e != null && e instanceof WaterBall) {
            return false;
        }
        if (e != null && e instanceof WaterDragon) {
            return false;
        }
        if (e != null && e instanceof EntityLiving) {
            if (e instanceof AttackSquid) {
                return false;
            }
            if (e instanceof WaterDragon) {
                return false;
            }
            this.func_70624_b((EntityLivingBase)e);
            this.func_70784_b(e);
            this.func_70661_as().func_75497_a((Entity)e, 1.2);
            ret = true;
        }
        ret = super.func_70097_a(par1DamageSource, par2);
        if ((this.func_110143_aJ() <= 0.0f || this.field_70128_L) && this.field_70170_p.field_73011_w.field_76574_g != OreSpawnMain.DimensionID5 && !this.field_70170_p.field_72995_K && e != null && e instanceof EntityPlayer && this.field_70170_p.field_73012_v.nextInt(15) == 1 && OreSpawnMain.KrakenEnable != 0 && this.wasshot == 0) {
            for (int j = 1 + this.field_70170_p.field_73012_v.nextInt(3), i = 0; i < j; ++i) {
                final EntityCreature newent = (EntityCreature)spawnCreature(this.field_70170_p, "The Kraken", this.field_70165_t + this.field_70170_p.field_73012_v.nextInt(4) - this.field_70170_p.field_73012_v.nextInt(4), 170.0, this.field_70161_v + this.field_70170_p.field_73012_v.nextInt(4) - this.field_70170_p.field_73012_v.nextInt(4));
            }
        }
        return ret;
    }
    
    private boolean scan_it(final int x, final int y, final int z, final int dx, final int dy, final int dz) {
        int found = 0;
        for (int i = -dy; i <= dy; ++i) {
            for (int j = -dz; j <= dz; ++j) {
                Block bid = this.field_70170_p.func_147439_a(x + dx, y + i, z + j);
                if (bid == Blocks.field_150355_j || bid == Blocks.field_150358_i) {
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
                if (bid == Blocks.field_150355_j || bid == Blocks.field_150358_i) {
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
                if (bid == Blocks.field_150355_j || bid == Blocks.field_150358_i) {
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
                if (bid == Blocks.field_150355_j || bid == Blocks.field_150358_i) {
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
                if (bid == Blocks.field_150355_j || bid == Blocks.field_150358_i) {
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
                if (bid == Blocks.field_150355_j || bid == Blocks.field_150358_i) {
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
        if (this.wasshot > 0) {
            --this.wasshot;
            if (this.wasshot == 0) {
                this.func_70106_y();
                return;
            }
        }
        if (!this.func_70090_H() && this.field_70170_p.field_73012_v.nextInt(10) == 0) {
            this.closest = 99999;
            final int tx = 0;
            this.tz = tx;
            this.ty = tx;
            this.tx = tx;
            for (int i = 1; i < 12; ++i) {
                int j = i;
                if (j > 5) {
                    j = 5;
                }
                if (this.scan_it((int)this.field_70165_t, (int)this.field_70163_u - 1, (int)this.field_70161_v, i, j, i)) {
                    break;
                }
                if (i >= 5) {
                    ++i;
                }
            }
            if (this.closest < 99999) {
                this.func_70661_as().func_75492_a((double)this.tx, (double)(this.ty - 1), (double)this.tz, 1.33);
            }
            else {
                if (this.field_70170_p.field_73012_v.nextInt(25) == 1) {
                    this.func_70691_i(-1.0f);
                }
                if (this.func_110143_aJ() <= 0.0f) {
                    this.func_70106_y();
                    return;
                }
            }
        }
        if (this.field_70170_p.field_73012_v.nextInt(10) == 1) {
            final EntityLivingBase e = this.findSomethingToAttack();
            if (e != null) {
                if (this.func_70068_e((Entity)e) < 9.0) {
                    this.setAttacking(1);
                    if (this.field_70170_p.field_73012_v.nextInt(4) == 0 || this.field_70170_p.field_73012_v.nextInt(5) == 1) {
                        this.func_70652_k((Entity)e);
                    }
                }
                else {
                    this.func_70661_as().func_75497_a((Entity)e, 1.2);
                    this.watercanon(e);
                }
            }
            else {
                if (this.buddy != null) {
                    this.func_70661_as().func_75497_a((Entity)this.buddy, 1.0);
                }
                this.setAttacking(0);
            }
        }
    }
    
    private void watercanon(final EntityLivingBase e) {
        final double yoff = 1.0;
        final double xzoff = 1.2;
        if (this.field_70170_p.field_73012_v.nextInt(5) == 1) {
            if (this.field_70146_Z.nextInt(3) == 1) {
                final InkSack var2 = new InkSack(this.field_70170_p, e.field_70165_t - this.field_70165_t, e.field_70163_u + 0.75 - (this.field_70163_u + yoff), e.field_70161_v - this.field_70161_v);
                var2.func_70012_b(this.field_70165_t - xzoff * Math.sin(Math.toRadians(this.field_70759_as)), this.field_70163_u + yoff, this.field_70161_v + xzoff * Math.cos(Math.toRadians(this.field_70177_z)), this.field_70759_as, this.field_70125_A);
                final double var3 = e.field_70165_t - this.field_70165_t;
                final double var4 = e.field_70163_u + 0.25 - var2.field_70163_u;
                final double var5 = e.field_70161_v - this.field_70161_v;
                final float var6 = MathHelper.func_76133_a(var3 * var3 + var5 * var5) * 0.2f;
                var2.func_70186_c(var3, var4 + var6, var5, 1.4f, 5.0f);
                this.field_70170_p.func_72956_a((Entity)this, "random.bow", 0.75f, 1.0f / (this.func_70681_au().nextFloat() * 0.4f + 0.8f));
                this.field_70170_p.func_72838_d((Entity)var2);
            }
            else {
                final WaterBall var7 = new WaterBall(this.field_70170_p, e.field_70165_t - this.field_70165_t, e.field_70163_u + 0.75 - (this.field_70163_u + yoff), e.field_70161_v - this.field_70161_v);
                var7.func_70012_b(this.field_70165_t - xzoff * Math.sin(Math.toRadians(this.field_70759_as)), this.field_70163_u + yoff, this.field_70161_v + xzoff * Math.cos(Math.toRadians(this.field_70177_z)), this.field_70759_as, this.field_70125_A);
                final double var3 = e.field_70165_t - this.field_70165_t;
                final double var4 = e.field_70163_u + 0.25 - var7.field_70163_u;
                final double var5 = e.field_70161_v - this.field_70161_v;
                final float var6 = MathHelper.func_76133_a(var3 * var3 + var5 * var5) * 0.2f;
                var7.func_70186_c(var3, var4 + var6, var5, 1.4f, 5.0f);
                this.field_70170_p.func_72956_a((Entity)this, "random.bow", 0.75f, 1.0f / (this.func_70681_au().nextFloat() * 0.4f + 0.8f));
                this.field_70170_p.func_72838_d((Entity)var7);
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
        if (!this.func_70635_at().func_75522_a((Entity)par1EntityLiving)) {
            return false;
        }
        if (par1EntityLiving instanceof EntityPlayer) {
            final EntityPlayer p = (EntityPlayer)par1EntityLiving;
            return !p.field_71075_bZ.field_75098_d;
        }
        if (par1EntityLiving instanceof Girlfriend) {
            return true;
        }
        if (par1EntityLiving instanceof Boyfriend) {
            return true;
        }
        if (par1EntityLiving instanceof EntityZombie) {
            return true;
        }
        if (par1EntityLiving instanceof EntityVillager) {
            return true;
        }
        if (par1EntityLiving instanceof EntitySpider) {
            return true;
        }
        if (par1EntityLiving instanceof EntityCaveSpider) {
            return true;
        }
        if (par1EntityLiving instanceof Ghost) {
            return false;
        }
        if (par1EntityLiving instanceof GhostSkelly) {
            return false;
        }
        if (par1EntityLiving instanceof Lizard) {
            return true;
        }
        if (par1EntityLiving instanceof AttackSquid) {
            if (this.field_70170_p.field_73012_v.nextInt(5) == 1) {
                this.buddy = par1EntityLiving;
            }
            return false;
        }
        return this.wasshot != 0;
    }
    
    private EntityLivingBase findSomethingToAttack() {
        if (OreSpawnMain.PlayNicely != 0) {
            return null;
        }
        final List var5 = this.field_70170_p.func_72872_a((Class)EntityLivingBase.class, this.field_70121_D.func_72314_b(10.0, 4.0, 10.0));
        Collections.sort((List<Object>)var5, this.TargetSorter);
        final Iterator var6 = var5.iterator();
        Entity var7 = null;
        EntityLivingBase var8 = null;
        final EntityLivingBase e = this.func_70638_az();
        if (e != null && e.func_70089_S()) {
            return e;
        }
        this.func_70624_b((EntityLivingBase)null);
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
    
    public void func_70014_b(final NBTTagCompound par1NBTTagCompound) {
        super.func_70014_b(par1NBTTagCompound);
        par1NBTTagCompound.func_74768_a("WasShot", this.wasshot);
    }
    
    public void func_70037_a(final NBTTagCompound par1NBTTagCompound) {
        super.func_70037_a(par1NBTTagCompound);
        this.wasshot = par1NBTTagCompound.func_74762_e("WasShot");
    }
    
    public boolean func_70601_bi() {
        super.func_70601_bi();
        return this.field_70163_u >= 50.0 && this.field_70170_p.func_72935_r();
    }
}

// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.tileentity.TileEntityMobSpawner;
import java.util.Iterator;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
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
import net.minecraft.entity.monster.EntityMob;

public class Crab extends EntityMob
{
    private GenericTargetSorter TargetSorter;
    private int hurt_timer;
    private float moveSpeed;
    private int closest;
    private int tx;
    private int ty;
    private int tz;
    
    public Crab(final World par1World) {
        super(par1World);
        this.TargetSorter = null;
        this.hurt_timer = 0;
        this.moveSpeed = 0.55f;
        this.closest = 99999;
        this.tx = 0;
        this.ty = 0;
        this.tz = 0;
        this.moveSpeed = 0.55f;
        this.func_70105_a(1.25f, 2.5f);
        this.func_70661_as().func_75491_a(false);
        this.field_70728_aV = 150;
        this.field_70174_ab = 30;
        this.field_70178_ae = false;
        this.TargetSorter = new GenericTargetSorter((Entity)this);
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new MyEntityAIWanderALot((EntityCreature)this, 16, 1.0));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 10.0f));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityLiving.class, 8.0f));
        this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)this.mygetMaxHealth());
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)(this.moveSpeed * this.getCrabScale()));
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)(OreSpawnMain.Crab_stats.attack * this.getCrabScale()));
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_75682_a(20, (Object)0);
        this.field_70180_af.func_75682_a(21, (Object)0);
        float t = 0.25f;
        if (this.field_70170_p != null) {
            if (this.field_70170_p.field_73012_v.nextInt(4) == 1) {
                t = 0.5f;
            }
            if (this.field_70170_p.field_73012_v.nextInt(8) == 2) {
                t = 1.0f;
            }
        }
        else {
            if (OreSpawnMain.OreSpawnRand.nextInt(4) == 1) {
                t = 0.5f;
            }
            if (OreSpawnMain.OreSpawnRand.nextInt(8) == 2) {
                t = 1.0f;
            }
        }
        this.setCrabScale(t);
        this.field_70728_aV = (int)(400.0f * t);
        this.field_70174_ab = (int)(10.0f * t);
        this.func_70105_a(3.75f * this.getCrabScale(), 3.5f * this.getCrabScale());
    }
    
    public float getCrabScale() {
        final int i = this.field_70180_af.func_75679_c(21);
        final float f = (float)i;
        return f / 100.0f;
    }
    
    public void setCrabScale(final float par1) {
        final float f = par1 * 100.0f;
        final int i = (int)f;
        this.field_70180_af.func_75692_b(21, (Object)i);
    }
    
    public void func_70037_a(final NBTTagCompound par1NBTTagCompound) {
        super.func_70037_a(par1NBTTagCompound);
        this.setCrabScale(par1NBTTagCompound.func_74760_g("Fscale"));
        this.func_70105_a(3.75f * this.getCrabScale(), 3.5f * this.getCrabScale());
        this.field_70728_aV = (int)(400.0f * this.getCrabScale());
        this.field_70174_ab = (int)(10.0f * this.getCrabScale());
    }
    
    public void func_70014_b(final NBTTagCompound par1NBTTagCompound) {
        super.func_70014_b(par1NBTTagCompound);
        par1NBTTagCompound.func_74776_a("Fscale", this.getCrabScale());
    }
    
    protected boolean func_70692_ba() {
        return !this.func_104002_bU();
    }
    
    public void func_70071_h_() {
        if (this.func_70090_H()) {
            this.moveSpeed = 0.95f;
        }
        else {
            this.moveSpeed = 0.55f;
        }
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)(this.moveSpeed * this.getCrabScale()));
        super.func_70071_h_();
        this.func_70105_a(2.5f * this.getCrabScale(), 3.5f * this.getCrabScale());
    }
    
    public int mygetMaxHealth() {
        return (int)(OreSpawnMain.PitchBlack_stats.health * this.getCrabScale());
    }
    
    public int func_70658_aO() {
        return OreSpawnMain.Crab_stats.defense + (int)(2.0f * this.getCrabScale());
    }
    
    protected boolean func_70650_aV() {
        return true;
    }
    
    public void func_70636_d() {
        super.func_70636_d();
    }
    
    public int getCrabHealth() {
        return (int)this.func_110143_aJ();
    }
    
    protected String func_70639_aQ() {
        return null;
    }
    
    protected String func_70621_aR() {
        return "orespawn:leaves_hit";
    }
    
    protected String func_70673_aS() {
        return null;
    }
    
    protected float func_70599_aP() {
        return 0.75f;
    }
    
    protected float func_70647_i() {
        return 2.0f - 0.3f * (1.0f / this.getCrabScale());
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
        final ItemStack is = null;
        int var5 = 4 + this.field_70170_p.field_73012_v.nextInt(8);
        var5 *= (int)this.getCrabScale();
        if (var5 < 1) {
            var5 = 1;
        }
        for (int var6 = 0; var6 < var5; ++var6) {
            this.dropItemRand(OreSpawnMain.MyRawCrabMeat, 1);
        }
    }
    
    public void initCreature() {
    }
    
    public boolean func_70085_c(final EntityPlayer par1EntityPlayer) {
        return false;
    }
    
    public boolean func_70652_k(final Entity par1Entity) {
        final boolean var4 = par1Entity.func_70097_a(DamageSource.func_76358_a((EntityLivingBase)this), OreSpawnMain.Crab_stats.attack * this.getCrabScale());
        if (var4 && par1Entity != null && par1Entity instanceof EntityLivingBase) {
            final double ks = 1.15 * this.getCrabScale();
            double inair = 0.48 * this.getCrabScale();
            final float f3 = (float)Math.atan2(par1Entity.field_70161_v - this.field_70161_v, par1Entity.field_70165_t - this.field_70165_t);
            if (par1Entity.field_70128_L || par1Entity instanceof EntityPlayer) {
                inair *= 2.0;
            }
            par1Entity.func_70024_g(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
        }
        return var4;
    }
    
    public boolean func_70097_a(final DamageSource par1DamageSource, final float par2) {
        boolean ret = false;
        if (par1DamageSource.func_76355_l().equals("cactus")) {
            return false;
        }
        final Entity e = par1DamageSource.func_76346_g();
        if (this.hurt_timer <= 0) {
            ret = super.func_70097_a(par1DamageSource, par2);
            this.hurt_timer = 8;
        }
        if (e != null && e instanceof EntityLiving) {
            if (e instanceof Crab) {
                return false;
            }
            this.func_70624_b((EntityLivingBase)e);
            this.func_70784_b(e);
            this.func_70661_as().func_75497_a((Entity)e, 1.2);
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
        if (this.hurt_timer > 0) {
            --this.hurt_timer;
        }
        if (!this.func_70090_H() && this.field_70170_p.field_73012_v.nextInt(25) == 0) {
            this.closest = 99999;
            final int tx = 0;
            this.tz = tx;
            this.ty = tx;
            this.tx = tx;
            for (int i = 1; i < 12; ++i) {
                int j = i;
                if (j > 10) {
                    j = 10;
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
                if (this.field_70170_p.field_73012_v.nextInt(100) == 1) {
                    this.func_70691_i(-1.0f * this.getCrabScale());
                }
                if (this.func_110143_aJ() <= 0.0f) {
                    this.func_70106_y();
                    return;
                }
            }
        }
        if (this.field_70170_p.field_73012_v.nextInt(5) == 1) {
            EntityLivingBase e = null;
            if (this.field_70170_p.field_73012_v.nextInt(100) == 1) {
                this.func_70624_b((EntityLivingBase)null);
            }
            e = this.func_70638_az();
            if (e != null && !e.func_70089_S()) {
                this.func_70624_b((EntityLivingBase)null);
                e = null;
            }
            if (e == null) {
                e = this.findSomethingToAttack();
            }
            if (e != null) {
                this.func_70625_a((Entity)e, 10.0f, 10.0f);
                if (this.func_70068_e((Entity)e) < (6.0f + e.field_70130_N / 2.0f) * (6.0f + e.field_70130_N / 2.0f) * this.getCrabScale()) {
                    this.setAttacking(1);
                    if (this.field_70170_p.field_73012_v.nextInt(4) == 0 || this.field_70170_p.field_73012_v.nextInt(5) == 1) {
                        this.func_70652_k((Entity)e);
                        if (!this.field_70170_p.field_72995_K) {
                            if (this.field_70170_p.field_73012_v.nextInt(3) == 1) {
                                this.field_70170_p.func_72956_a((Entity)e, "orespawn:scorpion_attack", 0.75f, 1.5f);
                            }
                            else {
                                this.field_70170_p.func_72956_a((Entity)e, "orespawn:scorpion_living", 0.75f, 1.5f);
                            }
                        }
                    }
                }
                else {
                    this.func_70661_as().func_75497_a((Entity)e, 1.0);
                }
            }
            else {
                this.setAttacking(0);
            }
        }
        if (this.field_70170_p.field_73012_v.nextInt(120) == 1 && this.func_70090_H() && this.func_110143_aJ() < this.mygetMaxHealth()) {
            this.func_85030_a("splash", 1.5f, this.field_70170_p.field_73012_v.nextFloat() * 0.2f + 0.9f);
            this.func_70691_i(4.0f * this.getCrabScale());
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
        if (par1EntityLiving instanceof Crab) {
            return false;
        }
        if (par1EntityLiving instanceof EntityMob) {
            return true;
        }
        if (par1EntityLiving instanceof Lizard) {
            return true;
        }
        if (par1EntityLiving instanceof RubberDucky) {
            return true;
        }
        if (par1EntityLiving instanceof EntityVillager) {
            return true;
        }
        if (par1EntityLiving instanceof Girlfriend) {
            return true;
        }
        if (par1EntityLiving instanceof Boyfriend) {
            return true;
        }
        final MyUtils oreSpawnUtils = OreSpawnMain.OreSpawnUtils;
        return MyUtils.isAttackableNonMob(par1EntityLiving);
    }
    
    private EntityLivingBase findSomethingToAttack() {
        if (OreSpawnMain.PlayNicely != 0) {
            return null;
        }
        final List var5 = this.field_70170_p.func_72872_a((Class)EntityLivingBase.class, this.field_70121_D.func_72314_b(16.0, 6.0, 16.0));
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
    
    private int findBuddies() {
        final List var5 = this.field_70170_p.func_72872_a((Class)Crab.class, this.field_70121_D.func_72314_b(24.0, 8.0, 24.0));
        return var5.size();
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
                        if (s != null && s.equals("Crab")) {
                            this.setCrabScale(0.35f);
                            return true;
                        }
                    }
                }
            }
        }
        if (this.field_70163_u < 50.0) {
            return false;
        }
        if (!this.field_70170_p.func_72935_r()) {
            return false;
        }
        if (this.field_70170_p.field_73011_w.field_76574_g == OreSpawnMain.DimensionID5) {
            if (this.field_70170_p.field_73012_v.nextInt(40) != 1) {
                return false;
            }
            if (this.findBuddies() > 3) {
                return false;
            }
        }
        return true;
    }
    
    public boolean func_70648_aU() {
        return true;
    }
}

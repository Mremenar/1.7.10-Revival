// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import java.util.Iterator;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.entity.monster.EntityMob;

public class Triffid extends EntityMob
{
    private GenericTargetSorter TargetSorter;
    private RenderInfo renderdata;
    private int hurt_timer;
    private float moveSpeed;
    
    public Triffid(final World par1World) {
        super(par1World);
        this.TargetSorter = null;
        this.renderdata = new RenderInfo();
        this.hurt_timer = 0;
        this.moveSpeed = 0.13f;
        this.func_70105_a(2.0f, 4.0f);
        this.func_70661_as().func_75491_a(true);
        this.field_70728_aV = 50;
        this.field_70174_ab = 75;
        this.field_70178_ae = false;
        this.TargetSorter = new GenericTargetSorter((Entity)this);
        this.renderdata = new RenderInfo();
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 10.0f));
        this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_75682_a(20, (Object)0);
        this.field_70180_af.func_75682_a(21, (Object)0);
        if (this.renderdata == null) {
            this.renderdata = new RenderInfo();
        }
        this.renderdata.rf1 = 0.0f;
        this.renderdata.rf2 = 0.0f;
        this.renderdata.rf3 = 0.0f;
        this.renderdata.rf4 = 0.0f;
        this.renderdata.ri1 = 0;
        this.renderdata.ri2 = 0;
        this.renderdata.ri3 = 0;
        this.renderdata.ri4 = 0;
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)this.mygetMaxHealth());
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)this.moveSpeed);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)OreSpawnMain.Triffid_stats.attack);
    }
    
    protected boolean func_70692_ba() {
        return !this.func_104002_bU();
    }
    
    public void func_70071_h_() {
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)this.moveSpeed);
        super.func_70071_h_();
        if (this.field_70170_p.field_73012_v.nextInt(100) == 1) {
            int ix = (int)this.field_70165_t;
            int iz = (int)this.field_70161_v;
            for (int k = -5; k <= 5; ++k) {
                final Block bid = this.field_70170_p.func_147439_a((int)this.field_70165_t, (int)this.field_70163_u - 1, (int)this.field_70161_v + k);
                if (bid != Blocks.field_150350_a) {
                    if (k < 0) {
                        --iz;
                    }
                    if (k > 0) {
                        ++iz;
                    }
                }
            }
            for (int k = -5; k <= 5; ++k) {
                final Block bid = this.field_70170_p.func_147439_a((int)this.field_70165_t + k, (int)this.field_70163_u - 1, (int)this.field_70161_v);
                if (bid != Blocks.field_150350_a) {
                    if (k < 0) {
                        --ix;
                    }
                    if (k > 0) {
                        ++ix;
                    }
                }
            }
            this.func_70661_as().func_75492_a((double)ix, this.field_70163_u, (double)iz, 1.0);
        }
        if (this.hurt_timer <= 0) {
            final EntityLivingBase e = this.findSomethingToAttack();
            if (e != null) {
                this.field_70177_z = (float)Math.toDegrees(Math.atan2(e.field_70161_v - this.field_70161_v, e.field_70165_t - this.field_70165_t)) - 90.0f;
                while (this.field_70177_z < 0.0f) {
                    this.field_70177_z += 360.0f;
                }
            }
        }
    }
    
    public int mygetMaxHealth() {
        return OreSpawnMain.Triffid_stats.health;
    }
    
    public RenderInfo getRenderInfo() {
        return this.renderdata;
    }
    
    public void setRenderInfo(final RenderInfo r) {
        this.renderdata.rf1 = r.rf1;
        this.renderdata.rf2 = r.rf2;
        this.renderdata.rf3 = r.rf3;
        this.renderdata.rf4 = r.rf4;
        this.renderdata.ri1 = r.ri1;
        this.renderdata.ri2 = r.ri2;
        this.renderdata.ri3 = r.ri3;
        this.renderdata.ri4 = r.ri4;
    }
    
    public int func_70658_aO() {
        return OreSpawnMain.Triffid_stats.defense;
    }
    
    protected boolean func_70650_aV() {
        return true;
    }
    
    public void func_70636_d() {
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K && this.hurt_timer > 0) {
            final double n = 0.0;
            this.field_70179_y = n;
            this.field_70159_w = n;
        }
    }
    
    public int getTriffidHealth() {
        return (int)this.func_110143_aJ();
    }
    
    protected String func_70639_aQ() {
        return "orespawn:triffid_living";
    }
    
    protected String func_70621_aR() {
        return "orespawn:triffid_hit";
    }
    
    protected String func_70673_aS() {
        return "orespawn:triffid_dead";
    }
    
    protected float func_70599_aP() {
        return 0.75f;
    }
    
    protected float func_70647_i() {
        return 1.0f;
    }
    
    protected Item func_146068_u() {
        final int i = this.field_70170_p.field_73012_v.nextInt(3);
        if (i == 0) {
            return Items.field_151074_bl;
        }
        return null;
    }
    
    private ItemStack dropItemRand(final Item index, final int par1) {
        EntityItem var3 = null;
        final ItemStack is = new ItemStack(index, par1, 0);
        var3 = new EntityItem(this.field_70170_p, this.field_70165_t + OreSpawnMain.OreSpawnRand.nextInt(3) - OreSpawnMain.OreSpawnRand.nextInt(3), this.field_70163_u + 1.0, this.field_70161_v + OreSpawnMain.OreSpawnRand.nextInt(3) - OreSpawnMain.OreSpawnRand.nextInt(3), is);
        if (var3 != null) {
            this.field_70170_p.func_72838_d((Entity)var3);
        }
        return is;
    }
    
    protected void func_70628_a(final boolean par1, final int par2) {
        for (int i = 4 + this.field_70170_p.field_73012_v.nextInt(6), var4 = 0; var4 < i; ++var4) {
            this.dropItemRand(OreSpawnMain.GreenGoo, 1);
        }
        this.dropItemRand(Items.field_151160_bD, 1);
    }
    
    public boolean func_70104_M() {
        return false;
    }
    
    public boolean func_70652_k(final Entity par1Entity) {
        final boolean ret = super.func_70652_k(par1Entity);
        return ret;
    }
    
    public boolean func_70097_a(final DamageSource par1DamageSource, final float par2) {
        boolean ret = false;
        if (this.hurt_timer > 0 || this.getOpenClosed() == 0) {
            this.hurt_timer = 300;
            this.setAttacking(0);
            return false;
        }
        ret = super.func_70097_a(par1DamageSource, par2);
        this.hurt_timer = 300;
        this.setOpenClosed(0);
        this.setAttacking(0);
        return ret;
    }
    
    protected void func_70619_bc() {
        if (this.field_70128_L) {
            return;
        }
        super.func_70619_bc();
        if (this.hurt_timer > 0) {
            --this.hurt_timer;
            this.func_70015_d(0);
            this.setOpenClosed(0);
        }
        if (this.field_70170_p.field_73012_v.nextInt(250) == 1 && this.func_110143_aJ() < this.mygetMaxHealth()) {
            this.func_70691_i(1.0f);
        }
        if (this.field_70170_p.field_73012_v.nextInt(80) == 2 && this.hurt_timer <= 0) {
            if (this.field_70170_p.field_73012_v.nextInt(8) == 1) {
                this.setOpenClosed(1);
            }
            else {
                this.setOpenClosed(0);
            }
        }
        if (this.field_70170_p.field_73012_v.nextInt(10) == 1 && this.hurt_timer <= 0) {
            final EntityLivingBase e = this.findSomethingToAttack();
            if (e != null) {
                this.setOpenClosed(1);
                if (this.func_70068_e((Entity)e) < 25.0) {
                    this.field_70177_z = (float)Math.toDegrees(Math.atan2(e.field_70161_v - this.field_70161_v, e.field_70165_t - this.field_70165_t)) - 90.0f;
                    while (this.field_70177_z < 0.0f) {
                        this.field_70177_z += 360.0f;
                    }
                    this.setAttacking(1);
                    this.func_70652_k((Entity)e);
                }
                else {
                    this.setAttacking(0);
                }
            }
            else {
                this.setAttacking(0);
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
        final MyUtils oreSpawnUtils = OreSpawnMain.OreSpawnUtils;
        if (MyUtils.isIgnoreable(par1EntityLiving)) {
            return false;
        }
        if (!this.func_70635_at().func_75522_a((Entity)par1EntityLiving)) {
            return false;
        }
        if (par1EntityLiving instanceof EntityCreeper) {
            return false;
        }
        if (par1EntityLiving instanceof EnderReaper) {
            return false;
        }
        if (par1EntityLiving instanceof Triffid) {
            return false;
        }
        if (par1EntityLiving instanceof TerribleTerror) {
            return false;
        }
        if (par1EntityLiving instanceof LurkingTerror) {
            return false;
        }
        if (par1EntityLiving instanceof PitchBlack) {
            return false;
        }
        if (par1EntityLiving instanceof Dragon) {
            return false;
        }
        if (par1EntityLiving instanceof EntityPlayer) {
            final EntityPlayer p = (EntityPlayer)par1EntityLiving;
            if (p.field_71075_bZ.field_75098_d) {
                return false;
            }
        }
        return true;
    }
    
    private EntityLivingBase findSomethingToAttack() {
        if (OreSpawnMain.PlayNicely != 0) {
            return null;
        }
        final List var5 = this.field_70170_p.func_72872_a((Class)EntityLivingBase.class, this.field_70121_D.func_72314_b(10.0, 8.0, 10.0));
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
    
    public final int getOpenClosed() {
        return this.field_70180_af.func_75683_a(21);
    }
    
    public final void setOpenClosed(final int par1) {
        this.field_70180_af.func_75692_b(21, (Object)(byte)par1);
    }
    
    public boolean func_70601_bi() {
        return true;
    }
}

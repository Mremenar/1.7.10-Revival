// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.init.Blocks;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import java.util.Iterator;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.world.World;
import net.minecraft.entity.monster.EntityMob;

public class Kyuubi extends EntityMob
{
    private GenericTargetSorter TargetSorter;
    private float moveSpeed;
    
    public Kyuubi(final World par1World) {
        super(par1World);
        this.TargetSorter = null;
        this.moveSpeed = 0.25f;
        this.func_70105_a(0.5f, 1.25f);
        this.func_70661_as().func_75491_a(true);
        this.field_70728_aV = 30;
        this.field_70174_ab = 1000;
        this.field_70178_ae = true;
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.350000023841858));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIMoveThroughVillage((EntityCreature)this, 1.0, false));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIWander((EntityCreature)this, 1.0));
        this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 10.0f));
        this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
        this.TargetSorter = new GenericTargetSorter((Entity)this);
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)this.mygetMaxHealth());
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)this.moveSpeed);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)OreSpawnMain.Kyuubi_stats.attack);
    }
    
    protected boolean func_70692_ba() {
        return !this.func_104002_bU();
    }
    
    public void func_70071_h_() {
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)this.moveSpeed);
        super.func_70071_h_();
    }
    
    public int mygetMaxHealth() {
        return OreSpawnMain.Kyuubi_stats.health;
    }
    
    public int func_70658_aO() {
        return OreSpawnMain.Kyuubi_stats.defense;
    }
    
    protected boolean func_70650_aV() {
        return true;
    }
    
    public void func_70636_d() {
        super.func_70636_d();
        if (this.field_70170_p.field_73012_v.nextInt(10) == 1) {
            this.field_70170_p.func_72869_a("reddust", this.field_70165_t, this.field_70163_u + 2.0, this.field_70161_v, 0.0, 0.0, 0.0);
            this.field_70170_p.func_72869_a("lava", this.field_70165_t, this.field_70163_u + 2.0, this.field_70161_v, 0.0, 0.0, 0.0);
            this.func_70015_d(5);
            if (this.func_70090_H()) {
                this.func_70652_k((Entity)this);
                this.field_70170_p.func_72869_a("smoke", this.field_70165_t, this.field_70163_u + 1.75, this.field_70161_v, 0.0, 0.0, 0.0);
                this.field_70170_p.func_72869_a("largesmoke", this.field_70165_t, this.field_70163_u + 1.75, this.field_70161_v, 0.0, 0.0, 0.0);
                this.field_70170_p.func_72869_a("smoke", this.field_70165_t, this.field_70163_u + 2.0, this.field_70161_v, 0.0, 0.0, 0.0);
                this.field_70170_p.func_72869_a("largesmoke", this.field_70165_t, this.field_70163_u + 2.0, this.field_70161_v, 0.0, 0.0, 0.0);
            }
        }
    }
    
    public int getAttackStrength(final Entity par1Entity) {
        return 3;
    }
    
    protected String func_70639_aQ() {
        return "orespawn:kyuubi_living";
    }
    
    protected String func_70621_aR() {
        return "orespawn:alo_hurt";
    }
    
    protected String func_70673_aS() {
        return "orespawn:alo_death";
    }
    
    protected float func_70599_aP() {
        return 0.75f;
    }
    
    protected float func_70647_i() {
        return 1.0f;
    }
    
    protected Item func_146068_u() {
        final int i = this.field_70170_p.field_73012_v.nextInt(6);
        if (i == 0) {
            return Items.field_151074_bl;
        }
        if (i == 1) {
            return OreSpawnMain.UraniumNugget;
        }
        if (i == 2) {
            return OreSpawnMain.TitaniumNugget;
        }
        return null;
    }
    
    public void initCreature() {
    }
    
    public boolean func_70085_c(final EntityPlayer par1EntityPlayer) {
        return false;
    }
    
    protected void func_70619_bc() {
        if (this.field_70128_L) {
            return;
        }
        if (this.field_70170_p.field_73012_v.nextInt(200) == 1) {
            this.func_70604_c((EntityLivingBase)null);
        }
        super.func_70619_bc();
        if (this.field_70170_p.field_73012_v.nextInt(10) == 1) {
            final EntityLivingBase e = this.findSomethingToAttack();
            if (e != null) {
                this.func_70625_a((Entity)e, 10.0f, 10.0f);
                this.func_70661_as().func_75497_a((Entity)e, 1.25);
                if (this.func_70068_e((Entity)e) < 64.0 && (this.field_70146_Z.nextInt(6) == 0 || this.field_70146_Z.nextInt(8) == 1)) {
                    final EntitySmallFireball var2 = new EntitySmallFireball(this.field_70170_p, (EntityLivingBase)this, e.field_70165_t - this.field_70165_t, e.field_70163_u + 0.75 - (this.field_70163_u + 1.25), e.field_70161_v - this.field_70161_v);
                    var2.func_70012_b(this.field_70165_t, this.field_70163_u + 1.25, this.field_70161_v, this.field_70177_z, this.field_70125_A);
                    this.field_70170_p.func_72956_a((Entity)this, "random.bow", 0.75f, 1.0f / (this.func_70681_au().nextFloat() * 0.4f + 0.8f));
                    this.field_70170_p.func_72838_d((Entity)var2);
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
        final MyUtils oreSpawnUtils = OreSpawnMain.OreSpawnUtils;
        if (MyUtils.isIgnoreable(par1EntityLiving)) {
            return false;
        }
        if (!this.func_70635_at().func_75522_a((Entity)par1EntityLiving)) {
            return false;
        }
        if (par1EntityLiving instanceof EntityMob) {
            return false;
        }
        if (par1EntityLiving instanceof EntityPigZombie) {
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
        final List var5 = this.field_70170_p.func_72872_a((Class)EntityLivingBase.class, this.field_70121_D.func_72314_b(12.0, 4.0, 12.0));
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
    
    public boolean func_70601_bi() {
        return true;
    }
    
    private void dropItemRand(final Item index, final int par1) {
        final EntityItem var3 = new EntityItem(this.field_70170_p, this.field_70165_t + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), this.field_70163_u + 1.0, this.field_70161_v + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4), new ItemStack(index, par1, 0));
        this.field_70170_p.func_72838_d((Entity)var3);
    }
    
    protected void func_70628_a(final boolean par1, final int par2) {
        for (int var4 = 0; var4 < 10; ++var4) {
            this.dropItemRand(Items.field_151044_h, 1);
        }
        for (int var4 = 0; var4 < 3; ++var4) {
            this.dropItemRand(Item.func_150898_a(Blocks.field_150451_bX), 1);
        }
        for (int var4 = 0; var4 < 4; ++var4) {
            this.dropItemRand(Item.func_150898_a(Blocks.field_150371_ca), 1);
        }
    }
}

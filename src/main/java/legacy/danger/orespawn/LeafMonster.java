// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.tileentity.TileEntityMobSpawner;
import java.util.Iterator;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.world.World;
import net.minecraft.entity.monster.EntityMob;

public class LeafMonster extends EntityMob
{
    private GenericTargetSorter TargetSorter;
    private float moveSpeed;
    
    public LeafMonster(final World par1World) {
        super(par1World);
        this.TargetSorter = null;
        this.moveSpeed = 0.25f;
        this.func_70105_a(1.0f, 2.5f);
        this.func_70661_as().func_75491_a(true);
        this.field_70728_aV = 5;
        this.field_70174_ab = 0;
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.350000023841858));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
        this.TargetSorter = new GenericTargetSorter((Entity)this);
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)this.mygetMaxHealth());
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)this.moveSpeed);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)OreSpawnMain.LeafMonster_stats.attack);
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_75682_a(20, (Object)0);
    }
    
    public final int getAttacking() {
        return this.field_70180_af.func_75683_a(20);
    }
    
    public final void setAttacking(final int par1) {
        this.field_70180_af.func_75692_b(20, (Object)(byte)par1);
    }
    
    public int mygetMaxHealth() {
        return OreSpawnMain.LeafMonster_stats.health;
    }
    
    public int func_70658_aO() {
        return OreSpawnMain.LeafMonster_stats.defense;
    }
    
    protected boolean func_70650_aV() {
        return true;
    }
    
    protected void func_70069_a(final float par1) {
        float i = (float)MathHelper.func_76123_f(par1 - 3.0f);
        if (i > 0.0f) {
            if (i > 2.0f) {
                this.func_85030_a("damage.fallbig", 1.0f, 1.0f);
                i = 2.0f;
            }
            else {
                this.func_85030_a("damage.fallsmall", 1.0f, 1.0f);
            }
            this.func_70097_a(DamageSource.field_76379_h, i);
        }
    }
    
    public void func_70071_h_() {
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)this.moveSpeed);
        super.func_70071_h_();
        if (this.getAttacking() == 0) {
            int px = (int)this.field_70165_t;
            final int py = (int)this.field_70163_u;
            final int pz = (int)this.field_70161_v;
            this.field_70165_t = px;
            this.field_70163_u = py;
            this.field_70161_v = pz;
            if (this.field_70165_t > 0.0) {
                this.field_70165_t += 0.5;
            }
            if (this.field_70161_v > 0.0) {
                this.field_70161_v += 0.5;
            }
            if (this.field_70165_t < 0.0) {
                this.field_70165_t -= 0.5;
            }
            if (this.field_70161_v < 0.0) {
                this.field_70161_v -= 0.5;
            }
            this.field_70125_A = 0.0f;
            px = (int)this.field_70759_as;
            px /= 90;
            final float n = (float)(px * 90);
            this.field_70759_as = n;
            this.field_70177_z = n;
        }
    }
    
    protected String func_70639_aQ() {
        return null;
    }
    
    protected String func_70621_aR() {
        return "orespawn:leaves_hit";
    }
    
    protected String func_70673_aS() {
        return "orespawn:leaves_death";
    }
    
    protected float func_70599_aP() {
        return 0.65f;
    }
    
    protected float func_70647_i() {
        return 1.0f;
    }
    
    protected Item func_146068_u() {
        final int i = this.field_70170_p.field_73012_v.nextInt(3);
        if (i == 0) {
            return Item.func_150898_a(Blocks.field_150364_r);
        }
        if (i == 1) {
            return Item.func_150898_a((Block)Blocks.field_150362_t);
        }
        return Items.field_151078_bh;
    }
    
    protected void func_70619_bc() {
        super.func_70619_bc();
        if (this.field_70128_L) {
            return;
        }
        if (this.field_70170_p.field_73012_v.nextInt(100) == 1) {
            this.func_70604_c((EntityLivingBase)null);
        }
        if (this.field_70170_p.field_73012_v.nextInt(4) == 1) {
            final EntityLivingBase e = this.findSomethingToAttack();
            if (e != null) {
                this.func_70625_a((Entity)e, 10.0f, 10.0f);
                this.setAttacking(1);
                this.func_70661_as().func_75497_a((Entity)e, 1.25);
                if (this.func_70068_e((Entity)e) < 5.0 && (this.field_70146_Z.nextInt(8) == 0 || this.field_70146_Z.nextInt(10) == 1)) {
                    this.func_70652_k((Entity)e);
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
        if (!this.func_70635_at().func_75522_a((Entity)par1EntityLiving)) {
            return false;
        }
        if (par1EntityLiving instanceof EntityAnt) {
            return true;
        }
        if (par1EntityLiving instanceof EntityButterfly) {
            return true;
        }
        if (par1EntityLiving instanceof EntityLunaMoth) {
            return true;
        }
        if (par1EntityLiving instanceof EntityPlayer) {
            final EntityPlayer p = (EntityPlayer)par1EntityLiving;
            if (!p.field_71075_bZ.field_75098_d) {
                return true;
            }
        }
        return false;
    }
    
    private EntityLivingBase findSomethingToAttack() {
        if (OreSpawnMain.PlayNicely != 0) {
            return null;
        }
        final List var5 = this.field_70170_p.func_72872_a((Class)EntityLivingBase.class, this.field_70121_D.func_72314_b(4.0, 6.0, 4.0));
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
        for (int k = -3; k < 3; ++k) {
            for (int j = -3; j < 3; ++j) {
                for (int i = 0; i < 5; ++i) {
                    final Block bid = this.field_70170_p.func_147439_a((int)this.field_70165_t + j, (int)this.field_70163_u + i, (int)this.field_70161_v + k);
                    if (bid == Blocks.field_150474_ac) {
                        TileEntityMobSpawner tileentitymobspawner = null;
                        tileentitymobspawner = (TileEntityMobSpawner)this.field_70170_p.func_147438_o((int)this.field_70165_t + j, (int)this.field_70163_u + i, (int)this.field_70161_v + k);
                        final String s = tileentitymobspawner.func_145881_a().func_98276_e();
                        if (s != null && s.equals("Leaf Monster")) {
                            return true;
                        }
                    }
                }
            }
        }
        if (!this.func_70814_o()) {
            return false;
        }
        if (this.field_70170_p.func_72935_r()) {
            return false;
        }
        if (this.field_70170_p.field_73011_w.field_76574_g == OreSpawnMain.DimensionID4) {
            if (this.field_70163_u > 20.0) {
                return false;
            }
        }
        else if (this.field_70163_u < 50.0) {
            return false;
        }
        return this.findBuddies() <= 4;
    }
    
    private int findBuddies() {
        final List var5 = this.field_70170_p.func_72872_a((Class)LeafMonster.class, this.field_70121_D.func_72314_b(20.0, 10.0, 20.0));
        return var5.size();
    }
    
    protected boolean func_70692_ba() {
        return !this.func_104002_bU();
    }
}

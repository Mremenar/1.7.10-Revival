// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.nbt.NBTTagCompound;
import java.util.Iterator;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.world.World;
import net.minecraft.entity.monster.EntityMob;

public class Rat extends EntityMob
{
    private GenericTargetSorter TargetSorter;
    private float moveSpeed;
    private String myowner;
    
    public Rat(final World par1World) {
        super(par1World);
        this.TargetSorter = null;
        this.moveSpeed = 0.25f;
        this.myowner = null;
        this.func_70105_a(0.25f, 0.5f);
        this.func_70661_as().func_75491_a(true);
        this.field_70728_aV = 5;
        this.field_70174_ab = 10;
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.350000023841858));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIMoveThroughVillage((EntityCreature)this, 1.0, false));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new MyEntityAIWanderALot((EntityCreature)this, 10, 1.0));
        this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
        this.TargetSorter = new GenericTargetSorter((Entity)this);
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)this.mygetMaxHealth());
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)this.moveSpeed);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)OreSpawnMain.Rat_stats.attack);
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_75682_a(20, (Object)0);
    }
    
    protected boolean func_70692_ba() {
        return !this.func_104002_bU() && this.myowner == null;
    }
    
    public final int getAttacking() {
        return this.field_70180_af.func_75683_a(20);
    }
    
    public final void setAttacking(final int par1) {
        this.field_70180_af.func_75692_b(20, (Object)(byte)par1);
    }
    
    public int mygetMaxHealth() {
        return OreSpawnMain.Rat_stats.health;
    }
    
    public int func_70658_aO() {
        return OreSpawnMain.Rat_stats.defense;
    }
    
    protected boolean func_70650_aV() {
        return true;
    }
    
    public void func_70636_d() {
        super.func_70636_d();
    }
    
    public void func_70071_h_() {
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)this.moveSpeed);
        super.func_70071_h_();
    }
    
    protected void func_70664_aZ() {
        super.func_70664_aZ();
        this.field_70181_x += 0.25;
        this.field_70163_u += 0.25;
    }
    
    protected String func_70639_aQ() {
        return "orespawn:ratlive";
    }
    
    protected String func_70621_aR() {
        return "orespawn:rathit";
    }
    
    protected String func_70673_aS() {
        return "orespawn:ratdead";
    }
    
    protected float func_70599_aP() {
        return 0.45f;
    }
    
    protected float func_70647_i() {
        return 1.0f;
    }
    
    protected Item func_146068_u() {
        return Items.field_151078_bh;
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
        super.func_70619_bc();
        if (this.field_70170_p.field_73012_v.nextInt(200) == 1) {
            this.func_70604_c((EntityLivingBase)null);
        }
        if (this.field_70170_p.field_73012_v.nextInt(5) == 1) {
            final EntityLivingBase e = this.findSomethingToAttack();
            if (e != null) {
                this.setAttacking(1);
                this.func_70661_as().func_75497_a((Entity)e, 1.25);
                if (this.func_70068_e((Entity)e) < 4.0 && (this.field_70146_Z.nextInt(8) == 0 || this.field_70146_Z.nextInt(7) == 1)) {
                    this.func_70652_k((Entity)e);
                }
            }
            else {
                this.setAttacking(0);
                if (this.myowner != null) {
                    final EntityPlayer p = this.field_70170_p.func_72924_a(this.myowner);
                    if (p != null) {
                        if (this.func_70068_e((Entity)p) > 64.0) {
                            this.func_70661_as().func_75497_a((Entity)p, 1.75);
                        }
                        if (this.func_70068_e((Entity)p) > 256.0) {
                            this.func_70107_b(p.field_70165_t + this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat(), p.field_70163_u, p.field_70161_v + this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat());
                        }
                    }
                }
            }
        }
        if (this.field_70170_p.field_73012_v.nextInt(250) == 1) {
            this.func_70691_i(1.0f);
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
        if (par1EntityLiving instanceof Irukandji) {
            return false;
        }
        if (par1EntityLiving instanceof Skate) {
            return false;
        }
        if (par1EntityLiving instanceof Whale) {
            return false;
        }
        if (par1EntityLiving instanceof Flounder) {
            return false;
        }
        if (par1EntityLiving instanceof Rat) {
            return false;
        }
        if (par1EntityLiving instanceof Ghost) {
            return false;
        }
        if (par1EntityLiving instanceof GhostSkelly) {
            return false;
        }
        if (par1EntityLiving instanceof DungeonBeast) {
            return false;
        }
        if (par1EntityLiving instanceof EntityPlayer) {
            final EntityPlayer p = (EntityPlayer)par1EntityLiving;
            if (p.field_71075_bZ.field_75098_d) {
                return false;
            }
            if (this.myowner != null) {
                if (this.myowner.equals(p.func_110124_au().toString())) {
                    return false;
                }
                if (OreSpawnMain.RatPlayerFriendly != 0) {
                    return false;
                }
            }
        }
        if (this.myowner != null && par1EntityLiving instanceof EntityTameable) {
            final EntityTameable e = (EntityTameable)par1EntityLiving;
            if (OreSpawnMain.RatPetFriendly != 0 && e.func_70909_n()) {
                return false;
            }
            if (e.func_152113_b() != null && this.myowner.equals(e.func_152113_b())) {
                return false;
            }
        }
        return true;
    }
    
    private EntityLivingBase findSomethingToAttack() {
        if (OreSpawnMain.PlayNicely != 0) {
            return null;
        }
        final List var5 = this.field_70170_p.func_72872_a((Class)EntityLivingBase.class, this.field_70121_D.func_72314_b(9.0, 2.0, 9.0));
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
    
    public void setOwner(final EntityLivingBase e) {
        EntityPlayer p = null;
        if (e != null && e instanceof EntityPlayer) {
            p = (EntityPlayer)e;
            final String s = p.func_110124_au().toString();
            if (s != null) {
                this.myowner = s;
            }
        }
    }
    
    public void func_70014_b(final NBTTagCompound par1NBTTagCompound) {
        super.func_70014_b(par1NBTTagCompound);
        if (this.myowner == null) {
            this.myowner = "null";
        }
        par1NBTTagCompound.func_74778_a("MyOwner", this.myowner);
    }
    
    public void func_70037_a(final NBTTagCompound par1NBTTagCompound) {
        super.func_70037_a(par1NBTTagCompound);
        this.myowner = par1NBTTagCompound.func_74779_i("MyOwner");
        if (this.myowner != null && this.myowner.equals("null")) {
            this.myowner = null;
        }
    }
    
    public boolean func_70097_a(final DamageSource par1DamageSource, final float par2) {
        boolean ret = false;
        if (par1DamageSource.func_76355_l().equals("inWall")) {
            return ret;
        }
        ret = super.func_70097_a(par1DamageSource, par2);
        return ret;
    }
    
    public boolean func_70601_bi() {
        int sc = 0;
        for (int k = -2; k < 2; ++k) {
            for (int j = -2; j < 2; ++j) {
                for (int i = 0; i < 5; ++i) {
                    final Block bid = this.field_70170_p.func_147439_a((int)this.field_70165_t + j, (int)this.field_70163_u + i, (int)this.field_70161_v + k);
                    if (bid == Blocks.field_150474_ac) {
                        TileEntityMobSpawner tileentitymobspawner = null;
                        tileentitymobspawner = (TileEntityMobSpawner)this.field_70170_p.func_147438_o((int)this.field_70165_t + j, (int)this.field_70163_u + i, (int)this.field_70161_v + k);
                        final String s = tileentitymobspawner.func_145881_a().func_98276_e();
                        if (s != null && s.equals("Rat")) {
                            return true;
                        }
                    }
                }
            }
        }
        if (!this.func_70814_o()) {
            return false;
        }
        if (this.field_70170_p.field_73011_w.field_76574_g == OreSpawnMain.DimensionID5) {
            if (this.field_70163_u > 50.0) {
                return false;
            }
            for (int k = -1; k <= 1; ++k) {
                for (int j = -1; j <= 1; ++j) {
                    final Block bid = this.field_70170_p.func_147439_a((int)this.field_70165_t + j, (int)this.field_70163_u + 1, (int)this.field_70161_v + k);
                    if (bid == Blocks.field_150350_a) {
                        ++sc;
                    }
                }
            }
            if (sc < 4) {
                return false;
            }
        }
        return this.findBuddies() <= 8;
    }
    
    private int findBuddies() {
        final List var5 = this.field_70170_p.func_72872_a((Class)Rat.class, this.field_70121_D.func_72314_b(20.0, 10.0, 20.0));
        return var5.size();
    }
}

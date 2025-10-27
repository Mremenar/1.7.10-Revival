// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.entity.EntityList;
import java.util.Iterator;
import java.util.Comparator;
import java.util.Collections;
import net.minecraft.world.EnumDifficulty;
import java.util.List;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.util.Vec3;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.init.Items;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.entity.passive.EntityAnimal;

public class Frog extends EntityAnimal
{
    private GenericTargetSorter TargetSorter;
    public double moveSpeed;
    private int singing;
    private int jumpcount;
    
    public Frog(final World par1World) {
        super(par1World);
        this.TargetSorter = null;
        this.moveSpeed = 0.10000000149011612;
        this.singing = 0;
        this.jumpcount = 0;
        this.func_70105_a(0.75f, 0.75f);
        this.field_70728_aV = 5;
        this.TargetSorter = new GenericTargetSorter((Entity)this);
        this.func_70661_as().func_75491_a(false);
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.4));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new MyEntityAIWander((EntityCreature)this, 1.0f));
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)this.mygetMaxHealth());
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(this.moveSpeed);
        this.func_110140_aT().func_111150_b(SharedMonsterAttributes.field_111264_e);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(0.0);
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_75682_a(20, (Object)0);
    }
    
    public boolean func_70648_aU() {
        return true;
    }
    
    protected boolean func_70692_ba() {
        return !this.func_104002_bU();
    }
    
    public int getSinging() {
        return this.field_70180_af.func_75683_a(20);
    }
    
    public void setSinging(final int par1) {
        this.field_70180_af.func_75692_b(20, (Object)(byte)par1);
    }
    
    private void jumpAround() {
        this.field_70181_x += 0.75f + Math.abs(this.field_70170_p.field_73012_v.nextFloat() * 0.55f);
        this.field_70163_u += 0.3499999940395355;
        final float f = 0.7f + Math.abs(this.field_70170_p.field_73012_v.nextFloat() * 0.75f);
        final float d = (float)Math.toRadians(this.field_70177_z);
        this.field_70159_w -= f * Math.sin(d);
        this.field_70179_y += f * Math.cos(d);
        this.field_70160_al = true;
    }
    
    public void func_70071_h_() {
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(this.moveSpeed);
        super.func_70071_h_();
        if (!this.field_70170_p.field_72995_K) {
            if (this.singing != 0) {
                --this.singing;
                if (this.singing <= 0) {
                    this.setSinging(0);
                }
            }
            if (this.jumpcount > 0) {
                --this.jumpcount;
            }
            if (this.jumpcount == 0 && this.field_70170_p.field_73012_v.nextInt(70) == 1) {
                this.jumpAround();
                this.jumpcount = 50;
            }
        }
    }
    
    public boolean func_70085_c(final EntityPlayer par1EntityPlayer) {
        if (par1EntityPlayer != null && par1EntityPlayer.func_70093_af() && par1EntityPlayer.field_71071_by.func_70448_g() == null) {
            final World world = par1EntityPlayer.field_70170_p;
            this.func_70106_y();
            par1EntityPlayer.field_70170_p.func_72956_a((Entity)par1EntityPlayer, "random.explode", 1.0f, world.field_73012_v.nextFloat() * 0.2f + 0.9f);
            if (!world.field_72995_K) {
                if (world.field_73012_v.nextInt(2) == 0) {
                    Boyfriend ent = null;
                    ent = (Boyfriend)spawnCreature(world, "Boyfriend", this.field_70165_t, this.field_70163_u + 0.01, this.field_70161_v);
                    if (ent != null) {
                        ent.setPrince(1 + world.field_73012_v.nextInt(2));
                    }
                }
                else {
                    Girlfriend ent2 = null;
                    ent2 = (Girlfriend)spawnCreature(world, "Girlfriend", this.field_70165_t, this.field_70163_u + 0.01, this.field_70161_v);
                    if (ent2 != null) {
                        ent2.setPrincess(1 + world.field_73012_v.nextInt(2));
                    }
                }
            }
            else {
                for (int var3 = 0; var3 < 16; ++var3) {
                    world.func_72869_a("smoke", (double)((float)this.field_70165_t + world.field_73012_v.nextFloat() - world.field_73012_v.nextFloat()), (double)((float)this.field_70163_u + world.field_73012_v.nextFloat()), (double)((float)this.field_70161_v + world.field_73012_v.nextFloat() - world.field_73012_v.nextFloat()), 0.0, 0.0, 0.0);
                    world.func_72869_a("explode", (double)((float)this.field_70165_t + world.field_73012_v.nextFloat() - world.field_73012_v.nextFloat()), (double)((float)this.field_70163_u + world.field_73012_v.nextFloat()), (double)((float)this.field_70161_v + world.field_73012_v.nextFloat() - world.field_73012_v.nextFloat()), 0.0, 0.0, 0.0);
                    world.func_72869_a("reddust", (double)((float)this.field_70165_t + world.field_73012_v.nextFloat() - world.field_73012_v.nextFloat()), (double)((float)this.field_70163_u + world.field_73012_v.nextFloat()), (double)((float)this.field_70161_v + world.field_73012_v.nextFloat() - world.field_73012_v.nextFloat()), 0.0, 0.0, 0.0);
                }
            }
        }
        return false;
    }
    
    public boolean func_70650_aV() {
        return true;
    }
    
    public int mygetMaxHealth() {
        return 8;
    }
    
    protected String func_70639_aQ() {
        if (!this.field_70170_p.field_72995_K) {
            if (this.field_70170_p.field_73012_v.nextInt(2) == 0) {
                return null;
            }
            this.setSinging(this.singing = 35);
        }
        return "orespawn:frog";
    }
    
    protected String func_70621_aR() {
        return "orespawn:scorpion_hit";
    }
    
    protected String func_70673_aS() {
        return "orespawn:big_splat";
    }
    
    protected float func_70599_aP() {
        return 0.7f;
    }
    
    protected void func_70069_a(final float par1) {
    }
    
    protected void func_70064_a(final double par1, final boolean par3) {
    }
    
    protected void playStepSound(final int par1, final int par2, final int par3, final int par4) {
    }
    
    private void dropItemRand(final Item index, final int par1) {
        final EntityItem var3 = new EntityItem(this.field_70170_p, this.field_70165_t + OreSpawnMain.OreSpawnRand.nextInt(2) - OreSpawnMain.OreSpawnRand.nextInt(2), this.field_70163_u + 1.0, this.field_70161_v + OreSpawnMain.OreSpawnRand.nextInt(2) - OreSpawnMain.OreSpawnRand.nextInt(2), new ItemStack(index, par1, 0));
        this.field_70170_p.func_72838_d((Entity)var3);
    }
    
    protected void func_70628_a(final boolean par1, final int par2) {
        for (int i = 0; i < 4; ++i) {
            this.dropItemRand(Items.field_151123_aH, 1);
        }
    }
    
    public boolean func_70652_k(final Entity par1Entity) {
        final boolean var4 = par1Entity.func_70097_a(DamageSource.func_76358_a((EntityLivingBase)this), 3.0f);
        if (par1Entity.field_70128_L) {
            this.func_70691_i(1.0f);
        }
        return var4;
    }
    
    public boolean func_70097_a(final DamageSource par1DamageSource, final float par2) {
        boolean ret = false;
        ret = super.func_70097_a(par1DamageSource, par2);
        if (!this.field_70170_p.field_72995_K && this.jumpcount <= 0) {
            this.jumpAround();
            this.jumpcount = 25;
        }
        return ret;
    }
    
    public boolean canSeeTarget(final double pX, final double pY, final double pZ) {
        return this.field_70170_p.func_72901_a(Vec3.func_72443_a(this.field_70165_t, this.field_70163_u + 0.25, this.field_70161_v), Vec3.func_72443_a(pX, pY, pZ), false) == null;
    }
    
    protected boolean func_70041_e_() {
        return true;
    }
    
    public EntityAgeable func_90011_a(final EntityAgeable var1) {
        return null;
    }
    
    private int findBuddies() {
        final List var5 = this.field_70170_p.func_72872_a((Class)Frog.class, this.field_70121_D.func_72314_b(20.0, 8.0, 20.0));
        return var5.size();
    }
    
    public boolean func_70601_bi() {
        return this.field_70163_u >= 50.0 && this.field_70170_p.func_72935_r() && (this.field_70170_p.field_73011_w.field_76574_g != OreSpawnMain.DimensionID5 || this.field_70170_p.field_73012_v.nextInt(20) == 1) && this.findBuddies() <= 5;
    }
    
    protected void func_70619_bc() {
        final int xdir = 1;
        final int zdir = 1;
        final int keep_trying = 50;
        if (this.field_70128_L) {
            return;
        }
        super.func_70619_bc();
        if (this.field_70146_Z.nextInt(12) == 0 && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
            EntityLivingBase e = null;
            e = this.findSomethingToAttack();
            if (e != null) {
                this.func_70661_as().func_75497_a((Entity)e, 1.25);
                if (this.func_70068_e((Entity)e) < 6.0) {
                    this.func_70652_k((Entity)e);
                }
            }
        }
    }
    
    private boolean isSuitableTarget(final EntityLivingBase par1EntityLiving, final boolean par2) {
        return this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL && par1EntityLiving != null && par1EntityLiving != this && par1EntityLiving.func_70089_S() && this.func_70635_at().func_75522_a((Entity)par1EntityLiving) && (par1EntityLiving instanceof EntityAnt || par1EntityLiving instanceof EntityButterfly || par1EntityLiving instanceof Cricket || par1EntityLiving instanceof EntityMosquito || par1EntityLiving instanceof Firefly || par1EntityLiving instanceof WormSmall);
    }
    
    private EntityLivingBase findSomethingToAttack() {
        if (OreSpawnMain.PlayNicely != 0) {
            return null;
        }
        final List var5 = this.field_70170_p.func_72872_a((Class)EntityLivingBase.class, this.field_70121_D.func_72314_b(8.0, 3.0, 8.0));
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
}

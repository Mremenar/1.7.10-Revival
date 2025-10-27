// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.init.Items;
import net.minecraft.block.Block;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.util.MathHelper;
import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Vec3;
import net.minecraft.item.Item;
import net.minecraft.init.Blocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import java.util.UUID;
import net.minecraft.entity.monster.EntityMob;

public class EnderReaper extends EntityMob
{
    private static final UUID attackingSpeedBoostModifierUUID;
    private static final AttributeModifier attackingSpeedBoostModifier;
    private int teleportDelay;
    private int stareTimer;
    private Entity lastEntityToAttack;
    
    public EnderReaper(final World par1World) {
        super(par1World);
        this.func_70105_a(0.7f, 2.9f);
        this.field_70138_W = 1.0f;
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)OreSpawnMain.EnderReaper_stats.health);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.37);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)OreSpawnMain.EnderReaper_stats.attack);
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_75682_a(18, (Object)new Byte((byte)0));
    }
    
    public void func_70014_b(final NBTTagCompound par1NBTTagCompound) {
        super.func_70014_b(par1NBTTagCompound);
    }
    
    public void func_70037_a(final NBTTagCompound par1NBTTagCompound) {
        super.func_70037_a(par1NBTTagCompound);
    }
    
    protected Entity func_70782_k() {
        if (OreSpawnMain.PlayNicely != 0) {
            return null;
        }
        final EntityPlayer entityplayer = this.field_70170_p.func_72856_b((Entity)this, 81.0);
        if (entityplayer != null) {
            if (this.shouldAttackPlayer(entityplayer)) {
                if (this.stareTimer == 0) {
                    this.field_70170_p.func_72956_a((Entity)entityplayer, "mob.endermen.stare", 1.0f, 1.0f);
                }
                if (this.stareTimer++ == 5) {
                    this.stareTimer = 0;
                }
                this.setScreaming(true);
                return (Entity)entityplayer;
            }
            this.stareTimer = 0;
            this.setScreaming(false);
        }
        return null;
    }
    
    private boolean shouldAttackPlayer(final EntityPlayer par1EntityPlayer) {
        final ItemStack itemstack = par1EntityPlayer.field_71071_by.field_70460_b[3];
        if (itemstack != null && itemstack.func_77973_b() == Item.func_150898_a(Blocks.field_150423_aK)) {
            return false;
        }
        final Vec3 vec3 = par1EntityPlayer.func_70676_i(1.0f).func_72432_b();
        Vec3 vec4 = Vec3.func_72443_a(this.field_70165_t - par1EntityPlayer.field_70165_t, this.field_70121_D.field_72338_b + this.field_70131_O / 2.0f - (par1EntityPlayer.field_70163_u + par1EntityPlayer.func_70047_e()), this.field_70161_v - par1EntityPlayer.field_70161_v);
        final double d0 = vec4.func_72433_c();
        vec4 = vec4.func_72432_b();
        final double d2 = vec3.func_72430_b(vec4);
        return d2 > 1.0 - 0.025 / d0 && par1EntityPlayer.func_70685_l((Entity)this);
    }
    
    public void func_70636_d() {
        if (this.func_70026_G()) {
            this.func_70097_a(DamageSource.field_76369_e, 1.0f);
        }
        if (this.lastEntityToAttack != this.field_70789_a) {
            final IAttributeInstance attributeinstance = this.func_110148_a(SharedMonsterAttributes.field_111263_d);
            attributeinstance.func_111124_b(EnderReaper.attackingSpeedBoostModifier);
            if (this.field_70789_a != null) {
                attributeinstance.func_111121_a(EnderReaper.attackingSpeedBoostModifier);
            }
        }
        this.lastEntityToAttack = this.field_70789_a;
        for (int i = 0; i < 2; ++i) {
            this.field_70170_p.func_72869_a("portal", this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * this.field_70131_O - 0.25, this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * this.field_70130_N, (this.field_70146_Z.nextDouble() - 0.5) * 2.0, -this.field_70146_Z.nextDouble(), (this.field_70146_Z.nextDouble() - 0.5) * 2.0);
        }
        if (this.field_70170_p.func_72935_r() && !this.field_70170_p.field_72995_K) {
            final float f = this.func_70013_c(1.0f);
            if (f > 0.5f && this.field_70170_p.func_72937_j(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u), MathHelper.func_76128_c(this.field_70161_v)) && this.field_70146_Z.nextFloat() * 30.0f < (f - 0.4f) * 2.0f) {
                this.field_70789_a = null;
                this.setScreaming(false);
                this.teleportRandomly();
            }
        }
        if (this.func_70026_G() || this.func_70027_ad()) {
            this.setScreaming(false);
            this.teleportRandomly();
        }
        this.field_70703_bu = false;
        if (this.field_70789_a != null) {
            this.func_70625_a(this.field_70789_a, 100.0f, 100.0f);
        }
        if (!this.field_70170_p.field_72995_K && this.func_70089_S()) {
            if (this.field_70789_a != null) {
                if (this.field_70789_a instanceof EntityPlayer && this.shouldAttackPlayer((EntityPlayer)this.field_70789_a)) {
                    if (this.field_70789_a.func_70068_e((Entity)this) < 16.0) {
                        this.teleportRandomly();
                    }
                    this.teleportDelay = 0;
                }
                else if (this.field_70789_a.func_70068_e((Entity)this) > 256.0 && this.teleportDelay++ >= 30 && this.teleportToEntity(this.field_70789_a)) {
                    this.teleportDelay = 0;
                }
            }
            else {
                this.setScreaming(false);
                this.teleportDelay = 0;
            }
        }
        super.func_70636_d();
    }
    
    protected boolean teleportRandomly() {
        final double d0 = this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * 64.0;
        final double d2 = this.field_70163_u + (this.field_70146_Z.nextInt(64) - 32);
        final double d3 = this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * 64.0;
        return this.teleportTo(d0, d2, d3);
    }
    
    protected boolean teleportToEntity(final Entity par1Entity) {
        Vec3 vec3 = Vec3.func_72443_a(this.field_70165_t - par1Entity.field_70165_t, this.field_70121_D.field_72338_b + this.field_70131_O / 2.0f - par1Entity.field_70163_u + par1Entity.func_70047_e(), this.field_70161_v - par1Entity.field_70161_v);
        vec3 = vec3.func_72432_b();
        final double d0 = 16.0;
        final double d2 = this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * 8.0 - vec3.field_72450_a * d0;
        final double d3 = this.field_70163_u + (this.field_70146_Z.nextInt(16) - 8) - vec3.field_72448_b * d0;
        final double d4 = this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * 8.0 - vec3.field_72449_c * d0;
        return this.teleportTo(d2, d3, d4);
    }
    
    protected boolean teleportTo(final double par1, final double par3, final double par5) {
        final double d3 = this.field_70165_t;
        final double d4 = this.field_70163_u;
        final double d5 = this.field_70161_v;
        this.field_70165_t = par1;
        this.field_70163_u = par3;
        this.field_70161_v = par5;
        boolean flag = false;
        final int i = MathHelper.func_76128_c(this.field_70165_t);
        int j = MathHelper.func_76128_c(this.field_70163_u);
        final int k = MathHelper.func_76128_c(this.field_70161_v);
        if (this.field_70170_p.func_72899_e(i, j, k)) {
            boolean flag2 = false;
            while (!flag2 && j > 0) {
                final Block l = this.field_70170_p.func_147439_a(i, j - 1, k);
                if (l != Blocks.field_150350_a && l.func_149688_o().func_76230_c()) {
                    flag2 = true;
                }
                else {
                    --this.field_70163_u;
                    --j;
                }
            }
            if (flag2) {
                this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
                if (this.field_70170_p.func_72945_a((Entity)this, this.field_70121_D).isEmpty() && !this.field_70170_p.func_72953_d(this.field_70121_D)) {
                    flag = true;
                }
            }
        }
        if (!flag) {
            this.func_70107_b(d3, d4, d5);
            return false;
        }
        final short short1 = 128;
        for (int lx = 0; lx < short1; ++lx) {
            final double d6 = lx / (short1 - 1.0);
            final float f = (this.field_70146_Z.nextFloat() - 0.5f) * 0.2f;
            final float f2 = (this.field_70146_Z.nextFloat() - 0.5f) * 0.2f;
            final float f3 = (this.field_70146_Z.nextFloat() - 0.5f) * 0.2f;
            final double d7 = d3 + (this.field_70165_t - d3) * d6 + (this.field_70146_Z.nextDouble() - 0.5) * this.field_70130_N * 2.0;
            final double d8 = d4 + (this.field_70163_u - d4) * d6 + this.field_70146_Z.nextDouble() * this.field_70131_O;
            final double d9 = d5 + (this.field_70161_v - d5) * d6 + (this.field_70146_Z.nextDouble() - 0.5) * this.field_70130_N * 2.0;
            this.field_70170_p.func_72869_a("portal", d7, d8, d9, (double)f, (double)f2, (double)f3);
        }
        this.field_70170_p.func_72908_a(d3, d4, d5, "mob.endermen.portal", 1.0f, 1.0f);
        this.func_85030_a("mob.endermen.portal", 1.0f, 1.0f);
        return true;
    }
    
    protected String func_70639_aQ() {
        return this.isScreaming() ? "mob.endermen.scream" : "mob.endermen.idle";
    }
    
    protected String func_70621_aR() {
        return "mob.endermen.hit";
    }
    
    protected String func_70673_aS() {
        return "mob.endermen.death";
    }
    
    protected Item func_146068_u() {
        return Items.field_151061_bv;
    }
    
    public int func_70658_aO() {
        return OreSpawnMain.EnderReaper_stats.defense;
    }
    
    protected void func_70628_a(final boolean par1, final int par2) {
        final Item j = this.func_146068_u();
        if (j != null) {
            for (int k = this.field_70146_Z.nextInt(2 + par2), l = 0; l < k; ++l) {
                this.func_145779_a(j, 1);
            }
        }
    }
    
    public boolean func_70097_a(final DamageSource par1DamageSource, final float par2) {
        if (this.func_85032_ar()) {
            return false;
        }
        this.setScreaming(true);
        if (par1DamageSource instanceof EntityDamageSourceIndirect) {
            for (int i = 0; i < 16; ++i) {
                if (this.teleportRandomly()) {
                    return true;
                }
            }
            return super.func_70097_a(par1DamageSource, par2);
        }
        return super.func_70097_a(par1DamageSource, par2);
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
                        if (s != null && s.equals("Ender Reaper")) {
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
        if (this.field_70163_u < 30.0) {
            return false;
        }
        EnderReaper target = null;
        target = (EnderReaper)this.field_70170_p.func_72857_a((Class)EnderReaper.class, this.field_70121_D.func_72314_b(16.0, 8.0, 16.0), (Entity)this);
        return target == null;
    }
    
    public boolean isScreaming() {
        return this.field_70180_af.func_75683_a(18) > 0;
    }
    
    public void setScreaming(final boolean par1) {
        this.field_70180_af.func_75692_b(18, (Object)(byte)(par1 ? 1 : 0));
    }
    
    static {
        attackingSpeedBoostModifierUUID = UUID.fromString("020E0DFB-87AE-4653-9556-831010E291A0");
        attackingSpeedBoostModifier = new AttributeModifier(EnderReaper.attackingSpeedBoostModifierUUID, "Attacking speed boost", 6.199999809265137, 0).func_111168_a(false);
    }
}

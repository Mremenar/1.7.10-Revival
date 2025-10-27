// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.tileentity.TileEntityMobSpawner;
import java.util.Iterator;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.entity.monster.EntityMob;

public class Robot2 extends EntityMob
{
    private GenericTargetSorter TargetSorter;
    private RenderInfo renderdata;
    private int just_for_fun;
    private float moveSpeed;
    
    public Robot2(final World par1World) {
        super(par1World);
        this.TargetSorter = null;
        this.renderdata = new RenderInfo();
        this.just_for_fun = 0;
        this.moveSpeed = 0.3f;
        this.func_70105_a(3.0f, 6.2f);
        this.func_70661_as().func_75491_a(true);
        this.field_70728_aV = 100;
        this.field_70174_ab = 200;
        this.field_70178_ae = true;
        this.TargetSorter = new GenericTargetSorter((Entity)this);
        this.renderdata = new RenderInfo();
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new MyEntityAIWanderALot((EntityCreature)this, 14, 1.0));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIMoveThroughVillage((EntityCreature)this, 0.8999999761581421, false));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 10.0f));
        this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)this.mygetMaxHealth());
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)this.moveSpeed);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a((double)OreSpawnMain.Robot2_stats.attack);
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_75682_a(20, (Object)0);
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
    
    protected boolean func_70692_ba() {
        return !this.func_104002_bU();
    }
    
    public void func_70071_h_() {
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)this.moveSpeed);
        super.func_70071_h_();
    }
    
    public int mygetMaxHealth() {
        return OreSpawnMain.Robot2_stats.health;
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
        return OreSpawnMain.Robot2_stats.defense;
    }
    
    protected boolean func_70650_aV() {
        return true;
    }
    
    public void func_70636_d() {
        super.func_70636_d();
    }
    
    protected void func_70664_aZ() {
        this.field_70181_x += 0.25;
        super.func_70664_aZ();
    }
    
    protected String func_70639_aQ() {
        if (this.field_70146_Z.nextInt(4) == 0) {
            return "orespawn:robot_living";
        }
        return null;
    }
    
    protected String func_70621_aR() {
        return "orespawn:robot_hurt";
    }
    
    protected String func_70673_aS() {
        return "orespawn:robot_death";
    }
    
    protected float func_70599_aP() {
        return 1.0f;
    }
    
    protected float func_70647_i() {
        return 1.0f;
    }
    
    protected Item func_146068_u() {
        return Item.func_150898_a(Blocks.field_150339_S);
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
        for (int var5 = 2 + this.field_70170_p.field_73012_v.nextInt(8), var6 = 0; var6 < var5; ++var6) {
            this.dropItemRand(Item.func_150898_a(Blocks.field_150339_S), 1);
        }
        for (int var5 = 5 + this.field_70170_p.field_73012_v.nextInt(6), var6 = 0; var6 < var5; ++var6) {
            this.dropItemRand(Items.field_151042_j, 1);
        }
        for (int i = 5 + this.field_70170_p.field_73012_v.nextInt(10), var6 = 0; var6 < i; ++var6) {
            final int var7 = this.field_70170_p.field_73012_v.nextInt(15);
            switch (var7) {
                case 0: {
                    is = this.dropItemRand(Items.field_151137_ax, 1);
                    break;
                }
                case 1: {
                    is = this.dropItemRand(Items.field_151107_aW, 1);
                    break;
                }
                case 2: {
                    is = this.dropItemRand(Items.field_151132_bS, 1);
                    break;
                }
                case 3: {
                    is = this.dropItemRand(Item.func_150898_a(Blocks.field_150451_bX), 1);
                    break;
                }
                case 4: {
                    is = this.dropItemRand(Item.func_150898_a(Blocks.field_150367_z), 1);
                    break;
                }
                case 5: {
                    is = this.dropItemRand(Item.func_150898_a((Block)Blocks.field_150320_F), 1);
                    break;
                }
                case 6: {
                    is = this.dropItemRand(Item.func_150898_a((Block)Blocks.field_150331_J), 1);
                    break;
                }
                case 7: {
                    is = this.dropItemRand(Item.func_150898_a(Blocks.field_150442_at), 1);
                    break;
                }
                case 8: {
                    is = this.dropItemRand(Item.func_150898_a(Blocks.field_150451_bX), 1);
                    break;
                }
                case 9: {
                    is = this.dropItemRand(Item.func_150898_a(Blocks.field_150445_bS), 1);
                    break;
                }
            }
        }
    }
    
    public boolean func_70085_c(final EntityPlayer par1EntityPlayer) {
        return false;
    }
    
    public boolean func_70652_k(final Entity par1Entity) {
        return super.func_70652_k(par1Entity);
    }
    
    protected void destroyBlock(final EntityLivingBase e) {
        final double x = e.field_70165_t + this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat();
        final double y = e.field_70163_u - 1.0;
        final double z = e.field_70161_v + this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat();
        final Block bid = this.field_70170_p.func_147439_a((int)x, (int)y, (int)z);
        if (bid == Blocks.field_150343_Z) {
            return;
        }
        if (bid == Blocks.field_150357_h) {
            return;
        }
        if (bid == Blocks.field_150371_ca) {
            return;
        }
        if (bid == Blocks.field_150474_ac) {
            return;
        }
        if (bid == Blocks.field_150451_bX) {
            return;
        }
        if (bid == Blocks.field_150339_S) {
            return;
        }
        if (bid == Blocks.field_150486_ae) {
            return;
        }
        if (bid != Blocks.field_150350_a && this.field_70170_p.func_82736_K().func_82766_b("mobGriefing")) {
            this.field_70170_p.func_147449_b((int)x, (int)y, (int)z, Blocks.field_150350_a);
        }
    }
    
    protected void destroyNearbyBlocks() {
        for (int i = 0; i < 50; ++i) {
            final double x = this.field_70165_t + this.field_70170_p.field_73012_v.nextFloat() * 6.5 - this.field_70170_p.field_73012_v.nextFloat() * 6.5;
            final double y = this.field_70163_u + 0.1 + this.field_70170_p.field_73012_v.nextFloat() * 8.5;
            final double z = this.field_70161_v + this.field_70170_p.field_73012_v.nextFloat() * 6.5 - this.field_70170_p.field_73012_v.nextFloat() * 6.5;
            final Block bid = this.field_70170_p.func_147439_a((int)x, (int)y, (int)z);
            if (bid != Blocks.field_150343_Z) {
                if (bid != Blocks.field_150357_h) {
                    if (bid != Blocks.field_150371_ca) {
                        if (bid != Blocks.field_150474_ac) {
                            if (bid != Blocks.field_150451_bX) {
                                if (bid != Blocks.field_150339_S) {
                                    if (bid != Blocks.field_150486_ae) {
                                        if (bid != Blocks.field_150350_a && this.field_70170_p.func_82736_K().func_82766_b("mobGriefing")) {
                                            this.field_70170_p.func_147449_b((int)x, (int)y, (int)z, Blocks.field_150350_a);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    protected void func_70619_bc() {
        if (this.field_70128_L) {
            return;
        }
        super.func_70619_bc();
        if (this.field_70170_p.field_73012_v.nextInt(6) == 1 && OreSpawnMain.PlayNicely == 0) {
            EntityLivingBase e = null;
            if (this.field_70170_p.field_73012_v.nextInt(50) == 1) {
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
                final double rr = Math.atan2(e.field_70161_v - this.field_70161_v, e.field_70165_t - this.field_70165_t);
                final double rhdir = Math.toRadians((this.field_70177_z + 90.0f) % 360.0f);
                final double pi = 3.1415926545;
                double rdd = Math.abs(rr - rhdir) % (pi * 2.0);
                if (rdd > pi) {
                    rdd -= pi * 2.0;
                }
                rdd = Math.abs(rdd);
                this.func_70625_a((Entity)e, 10.0f, 10.0f);
                if (rdd < 1.25) {
                    if (this.func_70068_e((Entity)e) < (5.0f + e.field_70130_N / 2.0f) * (5.0f + e.field_70130_N / 2.0f)) {
                        this.setAttacking(1);
                        if (this.field_70170_p.field_73012_v.nextInt(5) == 0 || this.field_70170_p.field_73012_v.nextInt(6) == 1) {
                            this.func_70652_k((Entity)e);
                            for (int i = 0; i < 6; ++i) {
                                this.destroyBlock(e);
                            }
                        }
                        this.destroyNearbyBlocks();
                    }
                }
                else {
                    this.setAttacking(0);
                }
                this.func_70661_as().func_75497_a((Entity)e, 1.0);
            }
            else {
                this.setAttacking(0);
            }
        }
        if (this.getAttacking() == 0 && OreSpawnMain.PlayNicely == 0) {
            if (this.field_70170_p.field_73012_v.nextInt(450) == 1) {
                this.just_for_fun = 50;
            }
            if (this.just_for_fun > 0) {
                --this.just_for_fun;
            }
            if (this.just_for_fun > 0) {
                this.setAttacking(1);
                if (this.field_70170_p.field_73012_v.nextInt(3) == 1) {
                    this.destroyNearbyBlocks();
                }
            }
            else {
                this.setAttacking(0);
            }
        }
    }
    
    public boolean func_70097_a(final DamageSource par1DamageSource, final float par2) {
        boolean ret = false;
        if (!par1DamageSource.func_76355_l().equals("cactus")) {
            ret = super.func_70097_a(par1DamageSource, par2);
            final Entity e = par1DamageSource.func_76346_g();
            if (e != null && e instanceof EntityLiving) {
                this.func_70624_b((EntityLivingBase)e);
                this.func_70784_b(e);
                this.func_70661_as().func_75497_a((Entity)e, 1.2);
            }
            return ret;
        }
        return false;
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
        final List var5 = this.field_70170_p.func_72872_a((Class)EntityLivingBase.class, this.field_70121_D.func_72314_b(14.0, 3.0, 14.0));
        Collections.sort((List<Object>)var5, this.TargetSorter);
        for (final Entity var7 : var5) {
            final EntityLivingBase var8 = (EntityLivingBase)var7;
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
                        if (s != null && s.equals("Robo-Pounder")) {
                            return true;
                        }
                    }
                }
            }
        }
        if (this.field_70163_u < 50.0) {
            return false;
        }
        if (this.field_70170_p.func_72935_r()) {
            return false;
        }
        for (int k = -1; k < 1; ++k) {
            for (int j = -1; j <= 1; ++j) {
                for (int i = 1; i < 6; ++i) {
                    final Block bid = this.field_70170_p.func_147439_a((int)this.field_70165_t + j, (int)this.field_70163_u + i, (int)this.field_70161_v + k);
                    if (bid != Blocks.field_150350_a && bid != Blocks.field_150329_H) {
                        return false;
                    }
                }
            }
        }
        return this.func_70814_o();
    }
}

// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.entity.EntityAgeable;
import java.util.Iterator;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.init.Items;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.entity.EntityLivingBase;

public class Lizard extends EntityCannonFodder
{
    private GenericTargetSorter TargetSorter;
    public boolean should_despawn;
    private EntityLivingBase buddy;
    private int follow_time;
    private float moveSpeed;
    private int closest;
    private int tx;
    private int ty;
    private int tz;
    
    public Lizard(final World par1World) {
        super(par1World);
        this.TargetSorter = null;
        this.should_despawn = true;
        this.buddy = null;
        this.follow_time = 0;
        this.moveSpeed = 0.3f;
        this.closest = 99999;
        this.tx = 0;
        this.ty = 0;
        this.tz = 0;
        this.moveSpeed = 0.3f;
        this.func_70105_a(1.5f, 1.25f);
        this.func_70661_as().func_75491_a(false);
        this.field_70728_aV = 15;
        this.field_70174_ab = 3;
        this.field_70178_ae = false;
        this.TargetSorter = new GenericTargetSorter((Entity)this);
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new MyEntityAIFollowOwner(this, 2.0f, 10.0f, 2.0f));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIMate((EntityAnimal)this, 1.0));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.25, Items.field_151100_aR, false));
        this.field_70714_bg.func_75776_a(4, (EntityAIBase)new MyEntityAIWanderALot((EntityCreature)this, 16, 1.0));
        this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 8.0f));
        this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
    }
    
    @Override
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)this.mygetMaxHealth());
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)this.moveSpeed);
        this.func_110140_aT().func_111150_b(SharedMonsterAttributes.field_111264_e);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(6.0);
    }
    
    @Override
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_75682_a(23, (Object)0);
    }
    
    @Override
    public void func_70071_h_() {
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)this.moveSpeed);
        super.func_70071_h_();
    }
    
    public int mygetMaxHealth() {
        return 30;
    }
    
    @Override
    public int func_70658_aO() {
        return 5;
    }
    
    protected boolean func_70650_aV() {
        return true;
    }
    
    public void func_70636_d() {
        super.func_70636_d();
    }
    
    public boolean func_70097_a(final DamageSource par1DamageSource, final float par2) {
        boolean ret = false;
        final Entity e = par1DamageSource.func_76346_g();
        if (!par1DamageSource.func_76355_l().equals("cactus")) {
            ret = super.func_70097_a(par1DamageSource, par2);
            if (e != null && e instanceof EntityLivingBase) {
                this.func_70624_b((EntityLivingBase)e);
            }
        }
        this.follow_time = 0;
        return ret;
    }
    
    protected String func_70639_aQ() {
        return null;
    }
    
    protected String func_70621_aR() {
        return "orespawn:alo_hurt";
    }
    
    protected String func_70673_aS() {
        return "orespawn:alo_death";
    }
    
    protected float func_70599_aP() {
        return 1.0f;
    }
    
    protected float func_70647_i() {
        return 1.0f;
    }
    
    protected Item func_146068_u() {
        return null;
    }
    
    @Override
    public boolean func_70085_c(final EntityPlayer par1EntityPlayer) {
        ItemStack var2 = par1EntityPlayer.field_71071_by.func_70448_g();
        if (var2 != null && var2.field_77994_a <= 0) {
            par1EntityPlayer.field_71071_by.func_70299_a(par1EntityPlayer.field_71071_by.field_70461_c, (ItemStack)null);
            var2 = null;
        }
        if (super.func_70085_c(par1EntityPlayer)) {
            return true;
        }
        if (var2 != null && var2.func_77973_b() == Items.field_151100_aR && par1EntityPlayer.func_70068_e((Entity)this) < 16.0) {
            if (!this.field_70170_p.field_72995_K) {
                this.buddy = (EntityLivingBase)par1EntityPlayer;
                this.follow_time = 3000 + this.field_70170_p.field_73012_v.nextInt(2000);
            }
            this.func_70908_e(true);
            if (!par1EntityPlayer.field_71075_bZ.field_75098_d) {
                final ItemStack itemStack = var2;
                --itemStack.field_77994_a;
                if (var2.field_77994_a <= 0) {
                    par1EntityPlayer.field_71071_by.func_70299_a(par1EntityPlayer.field_71071_by.field_70461_c, (ItemStack)null);
                }
            }
            return true;
        }
        if (!this.field_70170_p.field_72995_K) {
            this.buddy = null;
            this.follow_time = 0;
        }
        this.func_70908_e(false);
        return true;
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
    
    @Override
    protected void func_70619_bc() {
        if (this.field_70128_L) {
            return;
        }
        super.func_70619_bc();
        if (this.follow_time > 0) {
            --this.follow_time;
            this.should_despawn = false;
        }
        else {
            this.should_despawn = true;
        }
        if (!this.func_70090_H() && this.field_70170_p.field_73012_v.nextInt(100) == 0) {
            this.closest = 99999;
            final int tx = 0;
            this.tz = tx;
            this.ty = tx;
            this.tx = tx;
            for (int i = 1; i < 14; ++i) {
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
        }
        if (this.func_110143_aJ() < this.mygetMaxHealth() && this.field_70170_p.field_73012_v.nextInt(300) == 1) {
            this.func_70691_i(1.0f);
        }
        if (this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL && this.field_70170_p.field_73012_v.nextInt(10) == 1) {
            final EntityLivingBase e = this.findSomethingToAttack();
            if (e != null) {
                this.follow_time = 0;
                if (this.func_70068_e((Entity)e) < 12.0) {
                    this.setAttacking(1);
                    if (this.field_70170_p.field_73012_v.nextInt(4) == 0 || this.field_70170_p.field_73012_v.nextInt(5) == 1) {
                        this.func_70652_k((Entity)e);
                    }
                }
                else {
                    this.func_70661_as().func_75497_a((Entity)e, 1.2);
                }
            }
            else {
                if (this.buddy != null && !this.buddy.field_70128_L && this.field_70170_p.field_73012_v.nextInt(15) == 1) {
                    this.func_70661_as().func_75497_a((Entity)this.buddy, 1.0);
                }
                this.setAttacking(0);
            }
        }
        if (this.buddy != null && !this.buddy.field_70128_L && this.follow_time > 0 && this.field_70170_p.field_73012_v.nextInt(20) == 1) {
            this.func_70661_as().func_75497_a((Entity)this.buddy, 1.0);
        }
    }
    
    public boolean func_70652_k(final Entity par1Entity) {
        final float i = 6.0f;
        final boolean flag = par1Entity.func_70097_a(DamageSource.func_76358_a((EntityLivingBase)this), i);
        return flag;
    }
    
    private boolean isSuitableTarget(final EntityLivingBase par1EntityLiving, final boolean par2) {
        if (this.field_70170_p.field_73013_u == EnumDifficulty.PEACEFUL) {
            return false;
        }
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
        if (par1EntityLiving instanceof AttackSquid) {
            return true;
        }
        if (par1EntityLiving instanceof EntitySpider) {
            return true;
        }
        if (par1EntityLiving instanceof EntityCaveSpider) {
            return true;
        }
        if (par1EntityLiving instanceof EntityChicken) {
            return true;
        }
        if (par1EntityLiving instanceof Lizard && this.field_70170_p.field_73012_v.nextInt(10) == 1 && this.follow_time <= 0) {
            this.buddy = par1EntityLiving;
        }
        return false;
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
        if (this.field_70170_p.field_73012_v.nextInt(100) == 0) {
            this.func_70624_b((EntityLivingBase)null);
        }
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
        return this.field_70180_af.func_75683_a(23);
    }
    
    public final void setAttacking(final int par1) {
        this.field_70180_af.func_75692_b(23, (Object)(byte)par1);
    }
    
    public boolean func_70601_bi() {
        return this.field_70163_u >= 50.0;
    }
    
    protected boolean func_70692_ba() {
        if (this.func_70631_g_()) {
            this.func_110163_bv();
            return false;
        }
        return !this.func_104002_bU() && !this.func_70909_n() && this.should_despawn;
    }
    
    @Override
    public EntityAgeable func_90011_a(final EntityAgeable entityageable) {
        return (EntityAgeable)this.spawnBabyAnimal(entityageable);
    }
    
    public Lizard spawnBabyAnimal(final EntityAgeable par1EntityAgeable) {
        return new Lizard(this.field_70170_p);
    }
    
    public boolean isWheat(final ItemStack par1ItemStack) {
        return par1ItemStack != null && par1ItemStack.func_77973_b() == Items.field_151034_e;
    }
    
    public boolean func_70877_b(final ItemStack par1ItemStack) {
        return par1ItemStack.func_77973_b() == OreSpawnMain.MyCrystalApple;
    }
}

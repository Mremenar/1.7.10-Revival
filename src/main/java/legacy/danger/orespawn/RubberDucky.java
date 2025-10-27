// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.nbt.NBTTagCompound;
import java.util.Iterator;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.EntityList;
import net.minecraft.init.Blocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.init.Items;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityTameable;

public class RubberDucky extends EntityTameable
{
    private GenericTargetSorter TargetSorter;
    public boolean should_despawn;
    private EntityLivingBase buddy;
    private float moveSpeed;
    private int killcount;
    private int died;
    private RenderInfo renderdata;
    private int closest;
    private int tx;
    private int ty;
    private int tz;
    
    public RubberDucky(final World par1World) {
        super(par1World);
        this.TargetSorter = null;
        this.should_despawn = true;
        this.buddy = null;
        this.moveSpeed = 0.22f;
        this.killcount = 0;
        this.died = 0;
        this.renderdata = new RenderInfo();
        this.closest = 99999;
        this.tx = 0;
        this.ty = 0;
        this.tz = 0;
        this.moveSpeed = 0.22f;
        this.func_70105_a(0.33f, 0.5f);
        this.func_70661_as().func_75491_a(false);
        this.field_70728_aV = 15;
        this.field_70174_ab = 3;
        this.field_70178_ae = false;
        this.renderdata = new RenderInfo();
        this.TargetSorter = new GenericTargetSorter((Entity)this);
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIMate((EntityAnimal)this, 1.0));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new MyEntityAIFollowOwner(this, 2.0f, 10.0f, 2.0f));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIMate((EntityAnimal)this, 1.0));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.25, Items.field_151115_aP, false));
        this.field_70714_bg.func_75776_a(4, (EntityAIBase)new MyEntityAIWanderALot((EntityCreature)this, 16, 1.0));
        this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityLiving.class, 6.0f));
        this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, false));
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)this.mygetMaxHealth());
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)this.moveSpeed);
        this.func_110140_aT().func_111150_b(SharedMonsterAttributes.field_111264_e);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(6.0);
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_75682_a(23, (Object)0);
        this.field_70180_af.func_75682_a(22, (Object)0);
        this.func_70904_g(false);
        if (this.func_70874_b() < 0) {
            this.func_70873_a(-this.func_70874_b());
        }
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
    
    public void func_70071_h_() {
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)this.moveSpeed);
        super.func_70071_h_();
        if (this.func_70090_H()) {
            this.field_70181_x += 0.10000000149011612;
            if (this.field_70181_x < -0.05000000074505806) {
                this.field_70181_x = -0.05000000074505806;
            }
        }
    }
    
    public boolean func_70097_a(final DamageSource par1DamageSource, final float par2) {
        boolean ret = false;
        Entity w = null;
        w = par1DamageSource.func_76346_g();
        ret = super.func_70097_a(par1DamageSource, par2);
        this.func_70904_g(false);
        if (!this.field_70170_p.field_72995_K && w != null && w instanceof EntityPlayer && (this.field_70128_L || this.func_110143_aJ() <= 0.0f) && this.died == 0) {
            this.died = 1;
            this.setKillCount(++this.killcount);
            if (this.killcount < 10) {
                for (int m = 0; m < 20; ++m) {
                    int i = this.field_70170_p.field_73012_v.nextInt(3);
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        i = -i;
                    }
                    int k = this.field_70170_p.field_73012_v.nextInt(3);
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                        k = -k;
                    }
                    for (int j = 3; j > -3; --j) {
                        if (this.field_70170_p.func_147439_a((int)this.field_70165_t + i, (int)this.field_70163_u + j + 1, (int)this.field_70161_v + k) == Blocks.field_150350_a && this.field_70170_p.func_147439_a((int)this.field_70165_t + i, (int)this.field_70163_u + j, (int)this.field_70161_v + k) != Blocks.field_150350_a) {
                            final Entity e = spawnCreature(this.field_70170_p, "Rubber Ducky", (int)this.field_70165_t + i + 1, (int)this.field_70163_u + j + 1, (int)this.field_70161_v + k);
                            if (e != null) {
                                final RubberDucky d = (RubberDucky)e;
                                d.setKillCount(this.killcount);
                            }
                            return ret;
                        }
                    }
                }
            }
        }
        return ret;
    }
    
    public int mygetMaxHealth() {
        return 5;
    }
    
    public int func_70658_aO() {
        return 1;
    }
    
    protected void func_70069_a(final float par1) {
    }
    
    protected void func_70064_a(final double par1, final boolean par3) {
    }
    
    protected boolean func_70650_aV() {
        return true;
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
    
    protected String func_70639_aQ() {
        if (this.field_70170_p.field_73012_v.nextInt(10) == 1) {
            return "orespawn:duck_hurt";
        }
        return null;
    }
    
    protected String func_70621_aR() {
        return "orespawn:duck_hurt";
    }
    
    protected String func_70673_aS() {
        return "orespawn:duck_hurt";
    }
    
    protected float func_70599_aP() {
        return 0.8f;
    }
    
    protected float func_70647_i() {
        return 1.2f;
    }
    
    protected Item func_146068_u() {
        if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
            return Items.field_151008_G;
        }
        if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
            return OreSpawnMain.RubberDuckyEgg;
        }
        return null;
    }
    
    public boolean func_70085_c(final EntityPlayer par1EntityPlayer) {
        ItemStack var2 = par1EntityPlayer.field_71071_by.func_70448_g();
        if (var2 != null && var2.field_77994_a <= 0) {
            par1EntityPlayer.field_71071_by.func_70299_a(par1EntityPlayer.field_71071_by.field_70461_c, (ItemStack)null);
            var2 = null;
        }
        if (super.func_70085_c(par1EntityPlayer)) {
            return true;
        }
        if (var2 != null && var2.func_77973_b() == Items.field_151115_aP && par1EntityPlayer.func_70068_e((Entity)this) < 16.0) {
            if (!this.func_70909_n()) {
                if (!this.field_70170_p.field_72995_K) {
                    if (this.field_70146_Z.nextInt(2) == 0) {
                        this.func_70903_f(true);
                        this.func_152115_b(par1EntityPlayer.func_110124_au().toString());
                        this.func_70908_e(true);
                        this.field_70170_p.func_72960_a((Entity)this, (byte)7);
                        this.func_70691_i(this.mygetMaxHealth() - this.func_110143_aJ());
                    }
                    else {
                        this.func_70908_e(false);
                        this.field_70170_p.func_72960_a((Entity)this, (byte)6);
                    }
                }
            }
            else if (this.func_152114_e((EntityLivingBase)par1EntityPlayer)) {
                if (this.field_70170_p.field_72995_K) {
                    this.func_70908_e(true);
                    this.field_70170_p.func_72960_a((Entity)this, (byte)7);
                }
                if (this.mygetMaxHealth() > this.func_110143_aJ()) {
                    this.func_70691_i(this.mygetMaxHealth() - this.func_110143_aJ());
                }
            }
            if (!par1EntityPlayer.field_71075_bZ.field_75098_d) {
                final ItemStack itemStack = var2;
                --itemStack.field_77994_a;
                if (var2.field_77994_a <= 0) {
                    par1EntityPlayer.field_71071_by.func_70299_a(par1EntityPlayer.field_71071_by.field_70461_c, (ItemStack)null);
                }
            }
            return true;
        }
        if (this.func_70909_n() && var2 != null && var2.func_77973_b() == Item.func_150898_a((Block)Blocks.field_150330_I) && par1EntityPlayer.func_70068_e((Entity)this) < 16.0 && this.func_152114_e((EntityLivingBase)par1EntityPlayer)) {
            if (!this.field_70170_p.field_72995_K) {
                this.func_70903_f(false);
                this.func_152115_b("");
                this.func_70908_e(false);
                this.field_70170_p.func_72960_a((Entity)this, (byte)6);
            }
            if (!par1EntityPlayer.field_71075_bZ.field_75098_d) {
                final ItemStack itemStack2 = var2;
                --itemStack2.field_77994_a;
                if (var2.field_77994_a <= 0) {
                    par1EntityPlayer.field_71071_by.func_70299_a(par1EntityPlayer.field_71071_by.field_70461_c, (ItemStack)null);
                }
            }
            return true;
        }
        if (this.func_70909_n() && this.func_152114_e((EntityLivingBase)par1EntityPlayer) && par1EntityPlayer.func_70068_e((Entity)this) < 16.0) {
            if (!this.func_70906_o() && this.getKillCount() < 5) {
                this.func_70904_g(true);
            }
            else {
                this.func_70904_g(false);
            }
            return true;
        }
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
    
    protected void func_70619_bc() {
        if (this.field_70128_L) {
            return;
        }
        super.func_70619_bc();
        if (!this.func_70090_H() && this.field_70170_p.field_73012_v.nextInt(50) == 0) {
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
        if (this.killcount > 0 && this.field_70170_p.field_73012_v.nextInt(200) == 1) {
            this.setKillCount(--this.killcount);
        }
        if (this.func_110143_aJ() < this.mygetMaxHealth() && this.field_70170_p.field_73012_v.nextInt(300) == 1) {
            this.func_70691_i(1.0f);
        }
        if (this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL && this.field_70170_p.field_73012_v.nextInt(5) == 1) {
            final EntityLivingBase e = this.findSomethingToAttack();
            if (e != null) {
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
        if (this.buddy != null && !this.buddy.field_70128_L && this.field_70170_p.field_73012_v.nextInt(20) == 1) {
            this.func_70661_as().func_75497_a((Entity)this.buddy, 1.0);
        }
    }
    
    public boolean func_70652_k(final Entity par1Entity) {
        float i = 1.0f;
        if (this.getKillCount() >= 5) {
            i = 2.0f;
        }
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
        if (par1EntityLiving instanceof EntitySquid) {
            return true;
        }
        if (par1EntityLiving instanceof RubberDucky && this.field_70170_p.field_73012_v.nextInt(10) == 1) {
            this.buddy = par1EntityLiving;
        }
        if (this.getKillCount() >= 5 && par1EntityLiving instanceof EntityPlayer) {
            final EntityPlayer p = (EntityPlayer)par1EntityLiving;
            return !p.field_71075_bZ.field_75098_d;
        }
        return false;
    }
    
    private EntityLivingBase findSomethingToAttack() {
        if (OreSpawnMain.PlayNicely != 0) {
            return null;
        }
        final List var5 = this.field_70170_p.func_72872_a((Class)EntityLivingBase.class, this.field_70121_D.func_72314_b(8.0, 4.0, 8.0));
        Collections.sort((List<Object>)var5, this.TargetSorter);
        final Iterator var6 = var5.iterator();
        Entity var7 = null;
        EntityLivingBase var8 = null;
        final EntityLivingBase e = this.func_70638_az();
        if (e != null && e.func_70089_S()) {
            return e;
        }
        this.func_70624_b((EntityLivingBase)null);
        this.buddy = null;
        while (var6.hasNext()) {
            var7 = var6.next();
            var8 = (EntityLivingBase)var7;
            if (this.isSuitableTarget(var8, false)) {
                return var8;
            }
        }
        return null;
    }
    
    public void func_70014_b(final NBTTagCompound par1NBTTagCompound) {
        super.func_70014_b(par1NBTTagCompound);
        par1NBTTagCompound.func_74768_a("Killcount", this.killcount);
    }
    
    public void func_70037_a(final NBTTagCompound par1NBTTagCompound) {
        super.func_70037_a(par1NBTTagCompound);
        this.setKillCount(this.killcount = par1NBTTagCompound.func_74762_e("Killcount"));
    }
    
    public final int getAttacking() {
        return this.field_70180_af.func_75683_a(23);
    }
    
    public final void setAttacking(final int par1) {
        this.field_70180_af.func_75692_b(23, (Object)(byte)par1);
    }
    
    public final int getKillCount() {
        return this.field_70180_af.func_75683_a(22);
    }
    
    public final void setKillCount(final int par1) {
        this.field_70180_af.func_75692_b(22, (Object)(byte)par1);
        this.killcount = par1;
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
                        if (s != null && s.equals("Rubber Ducky")) {
                            return true;
                        }
                    }
                }
            }
        }
        return this.field_70163_u >= 50.0 && this.field_70170_p.func_72935_r();
    }
    
    protected boolean func_70692_ba() {
        if (this.func_70631_g_()) {
            this.func_110163_bv();
            return false;
        }
        return !this.func_104002_bU() && !this.func_70909_n() && this.should_despawn;
    }
    
    public EntityAgeable func_90011_a(final EntityAgeable entityageable) {
        return (EntityAgeable)this.spawnBabyAnimal(entityageable);
    }
    
    public RubberDucky spawnBabyAnimal(final EntityAgeable par1EntityAgeable) {
        return new RubberDucky(this.field_70170_p);
    }
    
    public boolean isWheat(final ItemStack par1ItemStack) {
        return par1ItemStack != null && par1ItemStack.func_77973_b() == Items.field_151115_aP;
    }
    
    public boolean func_70877_b(final ItemStack par1ItemStack) {
        return par1ItemStack.func_77973_b() == OreSpawnMain.MyCrystalApple;
    }
}

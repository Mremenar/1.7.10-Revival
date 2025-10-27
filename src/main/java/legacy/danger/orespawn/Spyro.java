// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.entity.EntityList;
import java.util.Iterator;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.util.Vec3;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.ChatComponentText;
import net.minecraft.item.Item;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIMoveIndoors;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.init.Items;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.world.World;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.entity.passive.EntityTameable;

public class Spyro extends EntityTameable
{
    private ChunkCoordinates currentFlightTarget;
    private GenericTargetSorter TargetSorter;
    public int activity;
    private int owner_flying;
    private boolean target_in_sight;
    private float moveSpeed;
    private int closest;
    private int tx;
    private int ty;
    private int tz;
    
    public Spyro(final World par1World) {
        super(par1World);
        this.TargetSorter = null;
        this.activity = 1;
        this.owner_flying = 0;
        this.target_in_sight = false;
        this.moveSpeed = 0.3f;
        this.closest = 99999;
        this.tx = 0;
        this.ty = 0;
        this.tz = 0;
        this.func_70105_a(0.5f, 0.5f);
        this.moveSpeed = 0.3f;
        this.field_70174_ab = 1000;
        this.field_70178_ae = true;
        this.func_70661_as().func_75491_a(true);
        this.func_70904_g(false);
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, (Class)EntityMob.class, 8.0f, 0.30000001192092896, 0.4000000059604645));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new MyEntityAIFollowOwner(this, 1.15f, 12.0f, 2.0f));
        this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.25, Items.field_151082_bd, false));
        this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.5));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 6.0f));
        this.field_70714_bg.func_75776_a(7, (EntityAIBase)new MyEntityAIWander((EntityCreature)this, 0.75f));
        this.field_70714_bg.func_75776_a(8, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.field_70714_bg.func_75776_a(9, (EntityAIBase)new EntityAIMoveIndoors((EntityCreature)this));
        this.TargetSorter = new GenericTargetSorter((Entity)this);
        this.field_70728_aV = 35;
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)this.mygetMaxHealth());
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)this.moveSpeed);
        this.func_110140_aT().func_111150_b(SharedMonsterAttributes.field_111264_e);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(5.0);
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.activity = 1;
        this.field_70180_af.func_75682_a(21, (Object)this.activity);
        this.field_70180_af.func_75682_a(20, (Object)1);
        this.func_70904_g(false);
        this.func_70903_f(false);
    }
    
    public void func_70014_b(final NBTTagCompound par1NBTTagCompound) {
        super.func_70014_b(par1NBTTagCompound);
        par1NBTTagCompound.func_74768_a("SpyroActivity", this.field_70180_af.func_75679_c(21));
        par1NBTTagCompound.func_74768_a("SpyroFire", this.field_70180_af.func_75679_c(20));
    }
    
    public void func_70037_a(final NBTTagCompound par1NBTTagCompound) {
        super.func_70037_a(par1NBTTagCompound);
        this.activity = par1NBTTagCompound.func_74762_e("SpyroActivity");
        this.field_70180_af.func_75692_b(21, (Object)this.activity);
        this.field_70180_af.func_75692_b(20, (Object)par1NBTTagCompound.func_74762_e("SpyroFire"));
    }
    
    private boolean scan_it(final int x, final int y, final int z, final int dx, final int dy, final int dz) {
        int found = 0;
        for (int i = -dy; i <= dy; ++i) {
            for (int j = -dz; j <= dz; ++j) {
                Block bid = this.field_70170_p.func_147439_a(x + dx, y + i, z + j);
                if (bid == Blocks.field_150353_l || bid == Blocks.field_150356_k) {
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
                if (bid == Blocks.field_150353_l || bid == Blocks.field_150356_k) {
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
                if (bid == Blocks.field_150353_l || bid == Blocks.field_150356_k) {
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
                if (bid == Blocks.field_150353_l || bid == Blocks.field_150356_k) {
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
                if (bid == Blocks.field_150353_l || bid == Blocks.field_150356_k) {
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
                if (bid == Blocks.field_150353_l || bid == Blocks.field_150356_k) {
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
    
    public int getActivity() {
        final int i = this.field_70180_af.func_75679_c(21);
        return i;
    }
    
    public void setActivity(final int par1) {
        this.activity = par1;
        this.field_70180_af.func_75692_b(21, (Object)this.activity);
    }
    
    public int getSpyroFire() {
        return this.field_70180_af.func_75679_c(20);
    }
    
    public void setSpyroFire(final int par1) {
        this.field_70180_af.func_75692_b(20, (Object)par1);
    }
    
    public boolean func_70650_aV() {
        return true;
    }
    
    public boolean func_70648_aU() {
        return true;
    }
    
    public int mygetMaxHealth() {
        return 200;
    }
    
    public int getSpyroHealth() {
        return (int)this.func_110143_aJ();
    }
    
    public boolean func_70085_c(final EntityPlayer par1EntityPlayer) {
        ItemStack var2 = par1EntityPlayer.field_71071_by.func_70448_g();
        if (var2 != null && var2.field_77994_a <= 0) {
            par1EntityPlayer.field_71071_by.func_70299_a(par1EntityPlayer.field_71071_by.field_70461_c, (ItemStack)null);
            var2 = null;
        }
        if (var2 != null && var2.func_77973_b() == Items.field_151082_bd && par1EntityPlayer.func_70068_e((Entity)this) < 16.0) {
            if (!this.func_70909_n()) {
                if (!this.field_70170_p.field_72995_K) {
                    if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
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
                this.func_70606_j((float)this.mygetMaxHealth());
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
        if (this.func_70909_n() && var2 != null && var2.func_77973_b() == Item.func_150898_a(Blocks.field_150432_aD) && par1EntityPlayer.func_70068_e((Entity)this) < 16.0 && this.func_152114_e((EntityLivingBase)par1EntityPlayer)) {
            if (!this.field_70170_p.field_72995_K) {
                this.func_70908_e(true);
                this.field_70170_p.func_72960_a((Entity)this, (byte)6);
                this.setSpyroFire(0);
                par1EntityPlayer.func_146105_b((IChatComponent)new ChatComponentText("Baby Dragon fireballs extinguished."));
            }
            if (!par1EntityPlayer.field_71075_bZ.field_75098_d) {
                final ItemStack itemStack3 = var2;
                --itemStack3.field_77994_a;
                if (var2.field_77994_a <= 0) {
                    par1EntityPlayer.field_71071_by.func_70299_a(par1EntityPlayer.field_71071_by.field_70461_c, (ItemStack)null);
                }
            }
            return true;
        }
        if (this.func_70909_n() && var2 != null && var2.func_77973_b() == Items.field_151045_i && par1EntityPlayer.func_70068_e((Entity)this) < 16.0 && this.func_152114_e((EntityLivingBase)par1EntityPlayer) && !this.field_70170_p.field_72995_K) {
            Entity ent = null;
            Dragon d = null;
            ent = spawnCreature(this.field_70170_p, "Dragon", this.field_70165_t, this.field_70163_u, this.field_70161_v);
            if (ent != null) {
                d = (Dragon)ent;
                if (this.func_70909_n()) {
                    d.func_70903_f(true);
                    d.func_152115_b(par1EntityPlayer.func_110124_au().toString());
                }
                this.func_70106_y();
            }
            if (!par1EntityPlayer.field_71075_bZ.field_75098_d) {
                final ItemStack itemStack4 = var2;
                --itemStack4.field_77994_a;
                if (var2.field_77994_a <= 0) {
                    par1EntityPlayer.field_71071_by.func_70299_a(par1EntityPlayer.field_71071_by.field_70461_c, (ItemStack)null);
                }
            }
            return true;
        }
        if (this.func_70909_n() && var2 != null && var2.func_77973_b() == Items.field_151033_d && par1EntityPlayer.func_70068_e((Entity)this) < 16.0 && this.func_152114_e((EntityLivingBase)par1EntityPlayer)) {
            if (!this.field_70170_p.field_72995_K) {
                this.func_70908_e(true);
                this.field_70170_p.func_72960_a((Entity)this, (byte)6);
                this.setSpyroFire(1);
                par1EntityPlayer.func_146105_b((IChatComponent)new ChatComponentText("Baby Dragon fireballs lit!"));
            }
            if (!par1EntityPlayer.field_71075_bZ.field_75098_d) {
                final ItemStack itemStack5 = var2;
                --itemStack5.field_77994_a;
                if (var2.field_77994_a <= 0) {
                    par1EntityPlayer.field_71071_by.func_70299_a(par1EntityPlayer.field_71071_by.field_70461_c, (ItemStack)null);
                }
            }
            return true;
        }
        if (this.func_70909_n() && var2 != null && var2.func_77973_b() == Items.field_151057_cb && par1EntityPlayer.func_70068_e((Entity)this) < 16.0 && this.func_152114_e((EntityLivingBase)par1EntityPlayer)) {
            this.func_94058_c(var2.func_82833_r());
            if (!par1EntityPlayer.field_71075_bZ.field_75098_d) {
                final ItemStack itemStack6 = var2;
                --itemStack6.field_77994_a;
                if (var2.field_77994_a <= 0) {
                    par1EntityPlayer.field_71071_by.func_70299_a(par1EntityPlayer.field_71071_by.field_70461_c, (ItemStack)null);
                }
            }
            return true;
        }
        if (this.func_70909_n() && par1EntityPlayer.func_70068_e((Entity)this) < 16.0 && this.func_152114_e((EntityLivingBase)par1EntityPlayer)) {
            if (!this.func_70906_o()) {
                this.func_70904_g(true);
            }
            else {
                this.func_70904_g(false);
            }
            return true;
        }
        return super.func_70085_c(par1EntityPlayer);
    }
    
    public boolean isWheat(final ItemStack par1ItemStack) {
        return par1ItemStack != null && par1ItemStack.func_77973_b() == Items.field_151082_bd;
    }
    
    protected boolean func_70692_ba() {
        return !this.func_104002_bU() && !this.func_70909_n();
    }
    
    public int func_70658_aO() {
        return 5;
    }
    
    protected String func_70639_aQ() {
        if (this.func_70906_o()) {
            return null;
        }
        if (this.getActivity() != 2) {
            return null;
        }
        return "orespawn:roar";
    }
    
    protected String func_70621_aR() {
        return "orespawn:duck_hurt";
    }
    
    protected String func_70673_aS() {
        return "orespawn:cryo_death";
    }
    
    protected float func_70599_aP() {
        return 0.4f;
    }
    
    protected Item func_146068_u() {
        return Items.field_151082_bd;
    }
    
    protected void func_70628_a(final boolean par1, final int par2) {
        int var3 = 0;
        if (this.func_70909_n()) {
            var3 = this.field_70170_p.field_73012_v.nextInt(4);
            ++var3;
            for (int var4 = 0; var4 < var3; ++var4) {
                this.func_145779_a(Items.field_151082_bd, 1);
            }
        }
    }
    
    protected float func_70647_i() {
        return this.func_70631_g_() ? ((this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat()) * 0.1f + 1.5f) : ((this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat()) * 0.1f + 1.0f);
    }
    
    protected boolean func_70041_e_() {
        return true;
    }
    
    protected void func_70069_a(final float par1) {
    }
    
    protected void func_70064_a(final double par1, final boolean par3) {
    }
    
    public boolean func_145773_az() {
        return false;
    }
    
    public boolean func_70601_bi() {
        return this.field_70170_p.func_72935_r() && this.field_70163_u >= 50.0;
    }
    
    public EntityAgeable func_90011_a(final EntityAgeable var1) {
        return null;
    }
    
    public float getAttackStrength(final Entity par1Entity) {
        return 4.0f;
    }
    
    public boolean func_70652_k(final Entity par1Entity) {
        final float var2 = this.getAttackStrength(par1Entity);
        final boolean var3 = par1Entity.func_70097_a(DamageSource.func_76358_a((EntityLivingBase)this), var2);
        return var3;
    }
    
    public boolean func_70097_a(final DamageSource par1DamageSource, final float par2) {
        boolean ret = false;
        if (!par1DamageSource.func_76355_l().equals("cactus")) {
            ret = super.func_70097_a(par1DamageSource, par2);
        }
        return ret;
    }
    
    public boolean canSeeTarget(final double pX, final double pY, final double pZ) {
        return this.field_70170_p.func_72901_a(Vec3.func_72443_a(this.field_70165_t, this.field_70163_u + 0.75, this.field_70161_v), Vec3.func_72443_a(pX, pY, pZ), false) == null;
    }
    
    public void func_70071_h_() {
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)this.moveSpeed);
        super.func_70071_h_();
        if (this.func_70090_H()) {
            this.field_70181_x += 0.07;
        }
        if (this.field_70170_p.field_72995_K) {
            return;
        }
        if (this.currentFlightTarget == null) {
            this.currentFlightTarget = new ChunkCoordinates((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v);
        }
        if (this.field_70170_p.field_73012_v.nextInt(100000) == 1 && !this.func_104002_bU()) {
            Entity ent = null;
            Dragon d = null;
            ent = spawnCreature(this.field_70170_p, "Dragon", this.field_70165_t, this.field_70163_u, this.field_70161_v);
            if (ent != null) {
                d = (Dragon)ent;
                if (this.func_70909_n()) {
                    d.func_70903_f(true);
                    d.func_152115_b(this.func_152113_b());
                }
                this.func_70106_y();
                return;
            }
        }
        if (this.activity == 2) {
            if (this.field_70163_u < this.currentFlightTarget.field_71572_b + 2.0) {
                this.field_70181_x *= 0.7;
            }
            else if (this.field_70163_u > this.currentFlightTarget.field_71572_b - 2.0) {
                this.field_70181_x *= 0.5;
            }
            else {
                this.field_70181_x *= 0.61;
            }
        }
        if (this.activity == 1 && this.func_70909_n() && this.func_70902_q() != null) {
            final EntityLivingBase e = this.func_70902_q();
            if (this.func_70068_e((Entity)e) > 256.0) {
                this.setActivity(2);
            }
        }
        this.do_movement();
    }
    
    public void func_70636_d() {
        super.func_70636_d();
    }
    
    protected void func_70629_bd() {
        int fly = 0;
        if (this.activity == 1) {
            super.func_70629_bd();
        }
        if (this.field_70128_L) {
            return;
        }
        if (this.field_70170_p.field_73012_v.nextInt(200) == 1) {
            this.func_70604_c((EntityLivingBase)null);
        }
        if (this.field_70170_p.field_72995_K) {
            return;
        }
        if (!this.func_70906_o()) {
            if (this.activity == 0) {
                this.activity = 1;
            }
            if (this.field_70170_p.field_73012_v.nextInt(20) == 0) {
                this.closest = 99999;
                final int tx = 0;
                this.tz = tx;
                this.ty = tx;
                this.tx = tx;
                for (int i = 1; i < 11; ++i) {
                    int j = i;
                    if (j > 4) {
                        j = 4;
                    }
                    if (this.scan_it((int)this.field_70165_t, (int)this.field_70163_u - 1, (int)this.field_70161_v, i, j, i)) {
                        break;
                    }
                    if (i >= 6) {
                        ++i;
                    }
                }
                if (this.closest < 99999) {
                    this.setActivity(1);
                    this.func_70661_as().func_75492_a((double)this.tx, (double)(this.ty - 1), (double)this.tz, 1.0);
                    if (this.func_70058_J()) {
                        this.func_70691_i(1.0f);
                        this.func_85030_a("splash", 1.0f, this.field_70170_p.field_73012_v.nextFloat() * 0.2f + 0.9f);
                    }
                }
            }
            if (this.field_70170_p.field_73012_v.nextInt(100) == 1 && !this.target_in_sight) {
                this.activity = 1;
                if (this.field_70170_p.field_73012_v.nextInt(8) == 1) {
                    this.activity = 2;
                }
                this.setActivity(this.activity);
            }
            this.owner_flying = 0;
            if (this.func_70909_n() && this.func_70902_q() != null) {
                final EntityPlayer e = (EntityPlayer)this.func_70902_q();
                if (e.field_71075_bZ.field_75100_b) {
                    fly = 1;
                }
                if (fly == 1) {
                    this.owner_flying = 1;
                    this.setActivity(2);
                }
            }
        }
    }
    
    protected void func_70619_bc() {
        if (this.field_70128_L) {
            return;
        }
        super.func_70619_bc();
        if (this.field_70170_p.field_73012_v.nextInt(100) == 1 && this.func_110143_aJ() < this.mygetMaxHealth()) {
            this.func_70691_i(1.0f);
        }
    }
    
    private void do_movement() {
        int xdir = 1;
        int zdir = 1;
        int keep_trying = 50;
        int do_new = 0;
        double ox = 0.0;
        double oy = 0.0;
        double oz = 0.0;
        int has_owner = 0;
        EntityLivingBase e = null;
        if (this.currentFlightTarget == null) {
            do_new = 1;
            this.currentFlightTarget = new ChunkCoordinates((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v);
        }
        if (this.func_70906_o()) {
            return;
        }
        if (this.activity == 1) {
            return;
        }
        if (this.getActivity() == 2 && this.field_70170_p.field_73012_v.nextInt(300) == 0) {
            do_new = 1;
        }
        if (this.func_70909_n() && this.func_70902_q() != null) {
            e = this.func_70902_q();
            has_owner = 1;
            ox = e.field_70165_t;
            oy = e.field_70163_u;
            oz = e.field_70161_v;
            if (this.func_70068_e((Entity)e) > 100.0) {
                do_new = 1;
            }
            if (this.owner_flying != 0 && this.func_70068_e((Entity)e) > 36.0) {
                do_new = 1;
            }
        }
        if (this.field_70170_p.field_73012_v.nextInt(6) == 1 && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
            e = this.findSomethingToAttack();
            if (e != null) {
                if (this.func_70909_n() && this.func_110143_aJ() / this.mygetMaxHealth() < 0.25f) {
                    this.setActivity(2);
                    this.target_in_sight = false;
                    do_new = 0;
                    this.currentFlightTarget.func_71571_b((int)(this.field_70165_t + (this.field_70165_t - e.field_70165_t)), (int)(this.field_70163_u + 1.0), (int)(this.field_70161_v + (this.field_70161_v - e.field_70161_v)));
                }
                else {
                    this.setActivity(2);
                    this.target_in_sight = true;
                    this.currentFlightTarget.func_71571_b((int)e.field_70165_t, (int)(e.field_70163_u + 1.0), (int)e.field_70161_v);
                    this.func_70661_as().func_75497_a((Entity)e, 1.25);
                    do_new = 0;
                    if (this.func_70068_e((Entity)e) < (3.0f + e.field_70130_N / 2.0f) * (3.0f + e.field_70130_N / 2.0f)) {
                        this.func_70652_k((Entity)e);
                    }
                    else if (this.func_70068_e((Entity)e) < 64.0 && !this.func_70090_H() && ((this.getSpyroFire() == 1 && this.field_70170_p.field_73012_v.nextInt(10) == 0) || this.field_70170_p.field_73012_v.nextInt(15) == 1)) {
                        final EntitySmallFireball var2 = new EntitySmallFireball(this.field_70170_p, (EntityLivingBase)this, e.field_70165_t - this.field_70165_t, e.field_70163_u + 0.25 - (this.field_70163_u + 1.25), e.field_70161_v - this.field_70161_v);
                        var2.func_70012_b(this.field_70165_t, this.field_70163_u + 1.25, this.field_70161_v, this.field_70177_z, this.field_70125_A);
                        this.field_70170_p.func_72956_a((Entity)this, "random.bow", 0.75f, 1.0f / (this.func_70681_au().nextFloat() * 0.4f + 0.8f));
                        this.field_70170_p.func_72838_d((Entity)var2);
                    }
                }
            }
            else {
                this.target_in_sight = false;
            }
        }
        if (this.currentFlightTarget.func_71569_e((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v) < 2.1f && this.getActivity() != 3) {
            do_new = 1;
        }
        if (do_new != 0 && !this.target_in_sight) {
            for (Block bid = Blocks.field_150348_b; bid != Blocks.field_150350_a && keep_trying != 0; --keep_trying) {
                int gox = (int)this.field_70165_t;
                int goy = (int)this.field_70163_u;
                int goz = (int)this.field_70161_v;
                if (has_owner == 1) {
                    gox = (int)ox;
                    goy = (int)oy;
                    goz = (int)oz;
                    if (this.owner_flying == 0) {
                        zdir = this.field_70170_p.field_73012_v.nextInt(4) + 6;
                        xdir = this.field_70170_p.field_73012_v.nextInt(4) + 6;
                    }
                    else {
                        zdir = this.field_70170_p.field_73012_v.nextInt(6);
                        xdir = this.field_70170_p.field_73012_v.nextInt(6);
                    }
                }
                else {
                    zdir = this.field_70170_p.field_73012_v.nextInt(5) + 6;
                    xdir = this.field_70170_p.field_73012_v.nextInt(5) + 6;
                }
                if (this.field_70170_p.field_73012_v.nextInt(2) == 0) {
                    zdir = -zdir;
                }
                if (this.field_70170_p.field_73012_v.nextInt(2) == 0) {
                    xdir = -xdir;
                }
                this.currentFlightTarget.func_71571_b(gox + xdir, goy + this.field_70170_p.field_73012_v.nextInt(9 + this.owner_flying * 2) - 4, goz + zdir);
                bid = this.field_70170_p.func_147439_a(this.currentFlightTarget.field_71574_a, this.currentFlightTarget.field_71572_b, this.currentFlightTarget.field_71573_c);
                if (bid == Blocks.field_150350_a && !this.canSeeTarget(this.currentFlightTarget.field_71574_a, this.currentFlightTarget.field_71572_b, this.currentFlightTarget.field_71573_c)) {
                    bid = Blocks.field_150348_b;
                }
            }
        }
        double speed_factor = 0.5;
        final double var3 = this.currentFlightTarget.field_71574_a + 0.5 - this.field_70165_t;
        final double var4 = this.currentFlightTarget.field_71572_b + 0.1 - this.field_70163_u;
        final double var5 = this.currentFlightTarget.field_71573_c + 0.5 - this.field_70161_v;
        if (this.owner_flying != 0) {
            speed_factor = 1.75;
            if (this.func_70909_n() && this.func_70902_q() != null) {
                e = this.func_70902_q();
                if (this.func_70068_e((Entity)e) > 49.0) {
                    speed_factor = 3.5;
                }
            }
        }
        this.field_70159_w += (Math.signum(var3) * 0.5 - this.field_70159_w) * 0.15 * speed_factor;
        this.field_70181_x += (Math.signum(var4) * 0.7 - this.field_70181_x) * 0.21 * speed_factor;
        this.field_70179_y += (Math.signum(var5) * 0.5 - this.field_70179_y) * 0.15 * speed_factor;
        final float var6 = (float)(Math.atan2(this.field_70179_y, this.field_70159_w) * 180.0 / 3.141592653589793) - 90.0f;
        final float var7 = MathHelper.func_76142_g(var6 - this.field_70177_z);
        this.field_70701_bs = (float)(0.75 * speed_factor);
        this.field_70177_z += var7 / 3.0f;
    }
    
    private boolean isSuitableTarget(final EntityLivingBase par1EntityLiving, final boolean par2) {
        return this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL && par1EntityLiving != null && par1EntityLiving != this && par1EntityLiving.func_70089_S() && this.func_70635_at().func_75522_a((Entity)par1EntityLiving) && !(par1EntityLiving instanceof Spyro) && (par1EntityLiving instanceof Mothra || par1EntityLiving instanceof EntityMob);
    }
    
    private EntityLivingBase findSomethingToAttack() {
        if (OreSpawnMain.PlayNicely != 0) {
            return null;
        }
        final List var5 = this.field_70170_p.func_72872_a((Class)EntityLivingBase.class, this.field_70121_D.func_72314_b(12.0, 6.0, 12.0));
        Collections.sort((List<Object>)var5, this.TargetSorter);
        final Iterator var6 = var5.iterator();
        Entity var7 = null;
        EntityLivingBase var8 = null;
        while (var6.hasNext()) {
            var7 = var6.next();
            var8 = (EntityLivingBase)var7;
            if (this.isSuitableTarget(var8, false) && this.canSeeTarget(var8.field_70165_t, var8.field_70163_u, var8.field_70161_v)) {
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

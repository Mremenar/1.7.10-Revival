// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.potion.Potion;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.ChatComponentText;
import net.minecraft.item.ItemFood;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.ai.EntityAIMoveIndoors;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.init.Items;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.passive.EntityTameable;

public class Boyfriend extends EntityTameable implements IRangedAttackMob
{
    public int which_guy;
    public int which_wet_guy;
    public int wet_count;
    private int auto_heal;
    private int force_sync;
    private int fight_sound_ticker;
    private int taunt_sound_ticker;
    private int had_target;
    private int voice;
    private float moveSpeed;
    private int voice_enable;
    public int passenger;
    private int is_prince;
    private static final ResourceLocation DryTexture0;
    private static final ResourceLocation DryTexture1;
    private static final ResourceLocation DryTexture2;
    private static final ResourceLocation DryTexture3;
    private static final ResourceLocation DryTexture4;
    private static final ResourceLocation DryTexture5;
    private static final ResourceLocation DryTexture6;
    private static final ResourceLocation DryTexture7;
    private static final ResourceLocation DryTexture8;
    private static final ResourceLocation DryTexture9;
    private static final ResourceLocation DryTexture10;
    private static final ResourceLocation DryTexture11;
    private static final ResourceLocation DryTexture12;
    private static final ResourceLocation DryTexture13;
    private static final ResourceLocation DryTexture14;
    private static final ResourceLocation DryTexture15;
    private static final ResourceLocation DryTexture16;
    private static final ResourceLocation DryTexture17;
    private static final ResourceLocation DryTexture18;
    private static final ResourceLocation DryTexture19;
    private static final ResourceLocation DryTexture20;
    private static final ResourceLocation DryTexture21;
    private static final ResourceLocation DryTexture22;
    private static final ResourceLocation DryTexture23;
    private static final ResourceLocation DryTexture24;
    private static final ResourceLocation DryTexture25;
    private static final ResourceLocation DryTexture26;
    private static final ResourceLocation DryTexture27;
    private static final ResourceLocation WetTexture0;
    private static final ResourceLocation WetTexture1;
    private static final ResourceLocation WetTexture2;
    private static final ResourceLocation WetTexture3;
    private static final ResourceLocation WetTexture4;
    private static final ResourceLocation WetTexture5;
    private static final ResourceLocation WetTexture6;
    private static final ResourceLocation WetTexture7;
    private static final ResourceLocation WetTexture8;
    private static final ResourceLocation WetTexture9;
    private static final ResourceLocation WetTexture10;
    private static final ResourceLocation WetTexture11;
    private static final ResourceLocation WetTexture12;
    private static final ResourceLocation WetTexture13;
    private static final ResourceLocation WetTexture14;
    private static final ResourceLocation WetTexture15;
    private static final ResourceLocation WetTexture16;
    private static final ResourceLocation WetTexture17;
    private static final ResourceLocation PrinceTexture1;
    private static final ResourceLocation PrinceTexture2;
    
    public Boyfriend(final World par1World) {
        super(par1World);
        this.which_guy = 0;
        this.which_wet_guy = 0;
        this.wet_count = 0;
        this.auto_heal = 200;
        this.force_sync = 50;
        this.fight_sound_ticker = 0;
        this.taunt_sound_ticker = 0;
        this.had_target = 0;
        this.voice = 0;
        this.moveSpeed = 0.3f;
        this.voice_enable = 1;
        this.passenger = 0;
        this.is_prince = 0;
        this.which_guy = this.field_70146_Z.nextInt(28);
        this.voice = this.field_70146_Z.nextInt(10);
        this.which_wet_guy = this.field_70146_Z.nextInt(18);
        this.func_70105_a(0.5f, 1.6f);
        this.field_70178_ae = true;
        this.field_70174_ab = 100;
        this.func_70661_as().func_75491_a(false);
        this.func_70904_g(false);
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new MyEntityAIFollowOwner(this, 1.4f, 12.0f, 1.5f));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.25, Items.field_151083_be, false));
        this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAIArrowAttack((IRangedAttackMob)this, 1.25, 20, 10.0f));
        this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.5));
        this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 6.0f));
        this.field_70714_bg.func_75776_a(8, (EntityAIBase)new MyEntityAIWander((EntityCreature)this, 0.75f));
        this.field_70714_bg.func_75776_a(9, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.field_70714_bg.func_75776_a(10, (EntityAIBase)new EntityAIOpenDoor((EntityLiving)this, true));
        this.field_70714_bg.func_75776_a(11, (EntityAIBase)new EntityAIMoveIndoors((EntityCreature)this));
        if (OreSpawnMain.PlayNicely == 0) {
            this.field_70715_bh.func_75776_a(2, (EntityAIBase)new MyEntityAINearestAttackableTarget((EntityLiving)this, EntityCreeper.class, 20.0f, 0, true, true, IMob.field_82192_a));
        }
        if (OreSpawnMain.PlayNicely == 0) {
            this.field_70715_bh.func_75776_a(3, (EntityAIBase)new MyEntityAINearestAttackableTarget((EntityLiving)this, EntityLiving.class, 15.0f, 0, true, true, IMob.field_82192_a));
        }
        if (OreSpawnMain.PlayNicely == 0) {
            this.field_70715_bh.func_75776_a(4, (EntityAIBase)new MyEntityAIJealousy(this, Boyfriend.class, 6.0f, 5, true));
        }
        if (OreSpawnMain.PlayNicely == 0) {
            this.field_70715_bh.func_75776_a(5, (EntityAIBase)new MyEntityAIJealousy(this, Boyfriend.class, 3.0f, 15, true));
        }
        this.field_70728_aV = 0;
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.which_guy = this.field_70146_Z.nextInt(28);
        this.field_70180_af.func_75682_a(20, (Object)this.which_guy);
        this.wet_count = 0;
        this.which_wet_guy = this.field_70146_Z.nextInt(18);
        this.field_70180_af.func_75682_a(22, (Object)this.which_wet_guy);
        this.voice = this.field_70146_Z.nextInt(10);
        this.field_70180_af.func_75682_a(21, (Object)this.voice);
        this.field_70180_af.func_75682_a(23, (Object)this.voice_enable);
        this.field_70180_af.func_75682_a(24, (Object)this.is_prince);
        this.auto_heal = 200;
        this.force_sync = 50;
        this.fight_sound_ticker = 0;
        this.taunt_sound_ticker = 0;
        this.had_target = 0;
        this.func_70904_g(false);
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)this.mygetMaxHealth());
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)this.moveSpeed);
        this.func_110140_aT().func_111150_b(SharedMonsterAttributes.field_111264_e);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(8.0);
    }
    
    public int func_70658_aO() {
        int i = 0;
        for (final ItemStack itemstack : this.func_70035_c()) {
            if (itemstack != null && itemstack.func_77973_b() instanceof ItemArmor) {
                final int l = ((ItemArmor)itemstack.func_77973_b()).field_77879_b;
                i += l;
            }
        }
        if (i < 8) {
            i = 8;
        }
        if (i > 23) {
            i = 23;
        }
        return i;
    }
    
    public void func_70071_h_() {
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)this.moveSpeed);
        super.func_70071_h_();
        this.passenger = 0;
        if (this.func_70909_n() && !this.func_70906_o()) {
            final Entity e = (Entity)this.func_70902_q();
            if (e != null && e instanceof EntityPlayer) {
                final EntityPlayer p = (EntityPlayer)e;
                final Entity r = e.field_70154_o;
                if (r != null && r instanceof Elevator) {
                    final float f = -0.45f;
                    this.func_70107_b(r.field_70165_t - f * Math.sin(Math.toRadians(r.field_70177_z)), r.field_70163_u, r.field_70161_v + f * Math.cos(Math.toRadians(r.field_70177_z)));
                    this.field_70177_z = r.field_70177_z;
                    this.field_70125_A = r.field_70125_A;
                    final float n = 0.0f;
                    this.field_70721_aZ = n;
                    this.field_70754_ba = n;
                    this.field_70143_R = 0.0f;
                    this.passenger = 1;
                }
            }
        }
    }
    
    public void func_70014_b(final NBTTagCompound par1NBTTagCompound) {
        super.func_70014_b(par1NBTTagCompound);
        par1NBTTagCompound.func_74768_a("GirlType", this.getTameSkin());
        par1NBTTagCompound.func_74768_a("WetGirlType", this.getWetTameSkin());
        par1NBTTagCompound.func_74768_a("GirlVoice", this.field_70180_af.func_75679_c(21));
        par1NBTTagCompound.func_74768_a("GirlVoiceEnable", this.field_70180_af.func_75679_c(23));
        par1NBTTagCompound.func_74768_a("IsPrince", this.field_70180_af.func_75679_c(24));
    }
    
    public void func_70037_a(final NBTTagCompound par1NBTTagCompound) {
        super.func_70037_a(par1NBTTagCompound);
        this.setTameSkin(this.which_guy = par1NBTTagCompound.func_74762_e("GirlType"));
        this.setWetTameSkin(this.which_wet_guy = par1NBTTagCompound.func_74762_e("WetGirlType"));
        this.voice = par1NBTTagCompound.func_74762_e("GirlVoice");
        this.field_70180_af.func_75692_b(21, (Object)this.voice);
        this.voice_enable = par1NBTTagCompound.func_74762_e("GirlVoiceEnable");
        this.field_70180_af.func_75692_b(23, (Object)this.voice_enable);
        this.is_prince = par1NBTTagCompound.func_74762_e("IsPrince");
        this.field_70180_af.func_75692_b(24, (Object)this.is_prince);
    }
    
    protected void func_70629_bd() {
        super.func_70629_bd();
        final ItemStack stack = this.getCurrentEquippedItem();
        Entity victim = (Entity)this.func_70638_az();
        if (OreSpawnMain.PlayNicely != 0) {
            victim = null;
        }
        if (this.field_70170_p.field_73012_v.nextInt(100) == 1) {
            this.func_70604_c((EntityLivingBase)null);
        }
        if (stack != null && !this.func_70906_o()) {
            if (victim != null) {
                if (victim instanceof EntityLivingBase && this.func_70694_bm() != null) {
                    if (this.func_70032_d(victim) < 4.0f || (stack.func_77973_b() == OreSpawnMain.MyBertha && this.func_70032_d(victim) < 10.0f)) {
                        --this.field_70724_aR;
                        if (this.field_70724_aR <= 0) {
                            this.field_70724_aR = 25;
                            this.func_71038_i();
                            this.attackTargetEntityWithCurrentItem(victim);
                            --this.fight_sound_ticker;
                            if (this.fight_sound_ticker <= 0) {
                                if (!this.field_70170_p.field_72995_K && this.voice_enable != 0) {
                                    this.field_70170_p.func_72956_a((Entity)this, "orespawn:b_fight", 0.5f, this.func_70647_i());
                                }
                                this.fight_sound_ticker = 3;
                            }
                            this.had_target = 1;
                        }
                    }
                    else if (this.func_70032_d(victim) < 7.0f && stack.func_77973_b() != OreSpawnMain.MyUltimateBow) {
                        --this.taunt_sound_ticker;
                        if (this.taunt_sound_ticker <= 0) {
                            if (!this.field_70170_p.field_72995_K && this.voice_enable != 0) {
                                this.field_70170_p.func_72956_a((Entity)this, "orespawn:b_taunt", 0.5f, this.func_70647_i());
                            }
                            this.taunt_sound_ticker = 300;
                        }
                        this.func_70661_as().func_75497_a(victim, 1.25);
                    }
                }
            }
            else {
                this.fight_sound_ticker = 0;
                this.field_70724_aR = 0;
                if (this.had_target != 0) {
                    this.had_target = 0;
                    if (!this.field_70170_p.field_72995_K && this.voice_enable != 0) {
                        this.field_70170_p.func_72956_a((Entity)this, "orespawn:b_woohoo", 0.4f, this.func_70647_i());
                    }
                }
            }
        }
    }
    
    public void setPrince(final int par1) {
        this.is_prince = par1;
    }
    
    public ResourceLocation getTexture() {
        if (this.wet_count <= 0) {
            final int txture = this.getTameSkin();
            if (this.is_prince == 1) {
                return Boyfriend.PrinceTexture1;
            }
            if (this.is_prince == 2) {
                return Boyfriend.PrinceTexture2;
            }
            if (txture == 0) {
                return Boyfriend.DryTexture0;
            }
            if (txture == 1) {
                return Boyfriend.DryTexture1;
            }
            if (txture == 2) {
                return Boyfriend.DryTexture2;
            }
            if (txture == 3) {
                return Boyfriend.DryTexture3;
            }
            if (txture == 4) {
                return Boyfriend.DryTexture4;
            }
            if (txture == 5) {
                return Boyfriend.DryTexture5;
            }
            if (txture == 6) {
                return Boyfriend.DryTexture6;
            }
            if (txture == 7) {
                return Boyfriend.DryTexture7;
            }
            if (txture == 8) {
                return Boyfriend.DryTexture8;
            }
            if (txture == 9) {
                return Boyfriend.DryTexture9;
            }
            if (txture == 10) {
                return Boyfriend.DryTexture10;
            }
            if (txture == 11) {
                return Boyfriend.DryTexture11;
            }
            if (txture == 12) {
                return Boyfriend.DryTexture12;
            }
            if (txture == 13) {
                return Boyfriend.DryTexture13;
            }
            if (txture == 14) {
                return Boyfriend.DryTexture14;
            }
            if (txture == 15) {
                return Boyfriend.DryTexture15;
            }
            if (txture == 16) {
                return Boyfriend.DryTexture16;
            }
            if (txture == 17) {
                return Boyfriend.DryTexture17;
            }
            if (txture == 18) {
                return Boyfriend.DryTexture18;
            }
            if (txture == 19) {
                return Boyfriend.DryTexture19;
            }
            if (txture == 20) {
                return Boyfriend.DryTexture20;
            }
            if (txture == 21) {
                return Boyfriend.DryTexture21;
            }
            if (txture == 22) {
                return Boyfriend.DryTexture22;
            }
            if (txture == 23) {
                return Boyfriend.DryTexture23;
            }
            if (txture == 24) {
                return Boyfriend.DryTexture24;
            }
            if (txture == 25) {
                return Boyfriend.DryTexture25;
            }
            if (txture == 26) {
                return Boyfriend.DryTexture26;
            }
            if (txture == 27) {
                return Boyfriend.DryTexture27;
            }
        }
        else {
            final int temp = this.getWetTameSkin();
            if (temp == 0) {
                return Boyfriend.WetTexture0;
            }
            if (temp == 1) {
                return Boyfriend.WetTexture1;
            }
            if (temp == 2) {
                return Boyfriend.WetTexture2;
            }
            if (temp == 3) {
                return Boyfriend.WetTexture3;
            }
            if (temp == 4) {
                return Boyfriend.WetTexture4;
            }
            if (temp == 5) {
                return Boyfriend.WetTexture5;
            }
            if (temp == 6) {
                return Boyfriend.WetTexture6;
            }
            if (temp == 7) {
                return Boyfriend.WetTexture7;
            }
            if (temp == 8) {
                return Boyfriend.WetTexture8;
            }
            if (temp == 9) {
                return Boyfriend.WetTexture9;
            }
            if (temp == 10) {
                return Boyfriend.WetTexture10;
            }
            if (temp == 11) {
                return Boyfriend.WetTexture11;
            }
            if (temp == 12) {
                return Boyfriend.WetTexture12;
            }
            if (temp == 13) {
                return Boyfriend.WetTexture13;
            }
            if (temp == 14) {
                return Boyfriend.WetTexture14;
            }
            if (temp == 15) {
                return Boyfriend.WetTexture15;
            }
            if (temp == 16) {
                return Boyfriend.WetTexture16;
            }
            if (temp == 17) {
                return Boyfriend.WetTexture17;
            }
        }
        return null;
    }
    
    public int getTameSkin() {
        return this.field_70180_af.func_75679_c(20);
    }
    
    public int getVoice() {
        return this.field_70180_af.func_75679_c(21);
    }
    
    public void setTameSkin(final int par1) {
        this.field_70180_af.func_75692_b(20, (Object)par1);
        this.which_guy = par1;
    }
    
    public int getWetTameSkin() {
        return this.field_70180_af.func_75679_c(22);
    }
    
    public void setWetTameSkin(final int par1) {
        this.field_70180_af.func_75692_b(22, (Object)par1);
        this.which_wet_guy = par1;
    }
    
    public boolean func_70650_aV() {
        return true;
    }
    
    public boolean func_70648_aU() {
        return true;
    }
    
    protected void func_70069_a(final float par1) {
        float i = (float)MathHelper.func_76123_f(par1 - 3.0f);
        if (i > 0.0f) {
            if (i > 3.0f) {
                this.func_85030_a("damage.fallbig", 1.0f, 1.0f);
                i = 3.0f;
            }
            else {
                this.func_85030_a("damage.fallsmall", 1.0f, 1.0f);
            }
            this.func_70097_a(DamageSource.field_76379_h, i);
        }
    }
    
    public int mygetMaxHealth() {
        return 80;
    }
    
    public void func_70636_d() {
        this.func_82168_bl();
        super.func_70636_d();
        if (this.func_70090_H() || this.func_70058_J()) {
            this.wet_count = 500;
        }
        else if (this.wet_count > 0) {
            --this.wet_count;
        }
        --this.auto_heal;
        if (this.auto_heal <= 0) {
            if (this.mygetMaxHealth() > this.getBoyfriendHealth()) {
                this.func_70691_i(1.0f);
            }
            this.auto_heal = 150;
        }
        --this.force_sync;
        if (this.force_sync <= 0) {
            this.force_sync = 20;
            if (!this.field_70170_p.field_72995_K) {
                this.field_70180_af.func_75692_b(21, (Object)this.voice);
                this.field_70180_af.func_75692_b(23, (Object)this.voice_enable);
                this.field_70180_af.func_75692_b(24, (Object)this.is_prince);
                this.func_70904_g(this.func_70906_o());
            }
            else {
                this.voice = this.getVoice();
                this.voice_enable = this.field_70180_af.func_75679_c(23);
                this.is_prince = this.field_70180_af.func_75679_c(24);
            }
        }
    }
    
    public int getBoyfriendHealth() {
        return (int)this.func_110143_aJ();
    }
    
    public boolean func_70085_c(final EntityPlayer par1EntityPlayer) {
        ItemStack var2 = par1EntityPlayer.field_71071_by.func_70448_g();
        if (var2 != null && var2.field_77994_a <= 0) {
            par1EntityPlayer.field_71071_by.func_70299_a(par1EntityPlayer.field_71071_by.field_70461_c, (ItemStack)null);
            var2 = null;
        }
        if (var2 != null && (var2.func_77973_b() == Items.field_151083_be || var2.func_77973_b() == OreSpawnMain.MyPeacock) && par1EntityPlayer.func_70068_e((Entity)this) < 16.0) {
            if (!this.func_70909_n()) {
                if (!this.field_70170_p.field_72995_K) {
                    if (this.field_70170_p.field_73012_v.nextInt(3) == 0) {
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
        if (this.func_70909_n() && var2 != null && var2.func_77973_b() == OreSpawnMain.MyRuby && par1EntityPlayer.func_70068_e((Entity)this) < 16.0 && this.func_152114_e((EntityLivingBase)par1EntityPlayer)) {
            if (!this.field_70170_p.field_72995_K) {
                this.voice_enable = 0;
                this.field_70180_af.func_75692_b(23, (Object)this.voice_enable);
                this.func_70908_e(true);
                this.field_70170_p.func_72960_a((Entity)this, (byte)7);
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
        if (this.func_70909_n() && var2 != null && var2.func_77973_b() == OreSpawnMain.MyAmethyst && par1EntityPlayer.func_70068_e((Entity)this) < 16.0 && this.func_152114_e((EntityLivingBase)par1EntityPlayer)) {
            if (!this.field_70170_p.field_72995_K) {
                this.voice_enable = 1;
                this.field_70180_af.func_75692_b(23, (Object)this.voice_enable);
                this.func_70908_e(true);
                this.field_70170_p.func_72960_a((Entity)this, (byte)7);
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
        if (this.func_70909_n() && var2 != null && (var2.func_77973_b() == Items.field_151116_aA || var2.func_77973_b() == OreSpawnMain.MyPeacockFeather) && par1EntityPlayer.func_70068_e((Entity)this) < 16.0 && this.func_152114_e((EntityLivingBase)par1EntityPlayer)) {
            if (!this.field_70170_p.field_72995_K) {
                if (this.wet_count > 0 || this.func_70090_H() || this.func_70058_J()) {
                    ++this.which_wet_guy;
                    if (this.which_wet_guy > 17) {
                        this.which_wet_guy = 0;
                    }
                    this.setWetTameSkin(this.which_wet_guy);
                    this.field_70170_p.func_72960_a((Entity)this, (byte)7);
                    if (this.func_70090_H() || this.func_70058_J()) {
                        this.wet_count = 500;
                    }
                }
                else {
                    ++this.which_guy;
                    if (this.which_guy > 27) {
                        this.which_guy = 0;
                    }
                    this.setTameSkin(this.which_guy);
                    this.field_70170_p.func_72960_a((Entity)this, (byte)7);
                }
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
        if (this.func_70909_n() && var2 != null && this.func_152114_e((EntityLivingBase)par1EntityPlayer) && par1EntityPlayer.func_70068_e((Entity)this) < 16.0) {
            if (var2.func_77973_b() instanceof ItemFood) {
                if (!this.field_70170_p.field_72995_K) {
                    final ItemFood var3 = (ItemFood)var2.func_77973_b();
                    if (this.mygetMaxHealth() > this.func_110143_aJ()) {
                        this.func_70691_i((float)(var3.func_150905_g(var2) * 5));
                    }
                    this.func_70908_e(true);
                    this.field_70170_p.func_72960_a((Entity)this, (byte)7);
                }
                if (!par1EntityPlayer.field_71075_bZ.field_75098_d) {
                    final ItemStack itemStack6 = var2;
                    --itemStack6.field_77994_a;
                    if (var2.field_77994_a <= 0) {
                        par1EntityPlayer.field_71071_by.func_70299_a(par1EntityPlayer.field_71071_by.field_70461_c, (ItemStack)null);
                    }
                }
            }
            else {
                if (!this.field_70170_p.field_72995_K) {
                    this.func_70908_e(true);
                    this.field_70170_p.func_72960_a((Entity)this, (byte)7);
                }
                final ItemStack var4 = this.getCurrentEquippedItem();
                this.func_70062_b(0, var2);
                if (var2.func_77973_b() == Items.field_151045_i) {
                    this.func_70904_g(true);
                }
                else {
                    this.func_70904_g(false);
                }
                if (var4 != null) {
                    par1EntityPlayer.field_71071_by.func_70299_a(par1EntityPlayer.field_71071_by.field_70461_c, var4);
                }
                else {
                    par1EntityPlayer.field_71071_by.func_70299_a(par1EntityPlayer.field_71071_by.field_70461_c, (ItemStack)null);
                    final Item itm = var2.func_77973_b();
                    if (itm instanceof ItemOreSpawnArmor) {
                        if (itm == OreSpawnMain.EmeraldHelmet || itm == OreSpawnMain.AmethystHelmet || itm == OreSpawnMain.UltimateHelmet) {
                            final ItemStack v4 = this.func_71124_b(4);
                            this.func_70062_b(4, var2);
                            this.func_70062_b(0, v4);
                        }
                        if (itm == OreSpawnMain.EmeraldBody || itm == OreSpawnMain.AmethystBody || itm == OreSpawnMain.UltimateBody) {
                            final ItemStack v4 = this.func_71124_b(3);
                            this.func_70062_b(3, var2);
                            this.func_70062_b(0, v4);
                        }
                        if (itm == OreSpawnMain.EmeraldLegs || itm == OreSpawnMain.AmethystLegs || itm == OreSpawnMain.UltimateLegs) {
                            final ItemStack v4 = this.func_71124_b(2);
                            this.func_70062_b(2, var2);
                            this.func_70062_b(0, v4);
                        }
                        if (itm == OreSpawnMain.EmeraldBoots || itm == OreSpawnMain.AmethystBoots || itm == OreSpawnMain.UltimateBoots) {
                            final ItemStack v4 = this.func_71124_b(1);
                            this.func_70062_b(1, var2);
                            this.func_70062_b(0, v4);
                        }
                    }
                }
            }
            return true;
        }
        if (this.func_70909_n() && var2 != null && var2.func_77973_b() == Item.func_150898_a(Blocks.field_150484_ah) && par1EntityPlayer.func_70068_e((Entity)this) < 16.0) {
            this.func_70904_g(false);
            this.func_70903_f(true);
            this.func_152115_b(par1EntityPlayer.func_110124_au().toString());
            this.func_70908_e(true);
            this.field_70170_p.func_72960_a((Entity)this, (byte)7);
            if (!par1EntityPlayer.field_71075_bZ.field_75098_d) {
                final ItemStack itemStack7 = var2;
                --itemStack7.field_77994_a;
                if (var2.field_77994_a <= 0) {
                    par1EntityPlayer.field_71071_by.func_70299_a(par1EntityPlayer.field_71071_by.field_70461_c, (ItemStack)null);
                }
            }
            return true;
        }
        if (this.func_70909_n() && var2 != null && var2.func_77973_b() == Items.field_151057_cb && par1EntityPlayer.func_70068_e((Entity)this) < 16.0 && this.func_152114_e((EntityLivingBase)par1EntityPlayer)) {
            this.func_94058_c(var2.func_82833_r());
            if (!par1EntityPlayer.field_71075_bZ.field_75098_d) {
                final ItemStack itemStack8 = var2;
                --itemStack8.field_77994_a;
                if (var2.field_77994_a <= 0) {
                    par1EntityPlayer.field_71071_by.func_70299_a(par1EntityPlayer.field_71071_by.field_70461_c, (ItemStack)null);
                }
            }
            return true;
        }
        if (this.func_70909_n() && var2 == null && par1EntityPlayer.func_70068_e((Entity)this) < 16.0 && this.func_152114_e((EntityLivingBase)par1EntityPlayer)) {
            ItemStack var4 = this.func_71124_b(0);
            int it = 0;
            if (var4 == null) {
                ++it;
                var4 = this.func_71124_b(it);
            }
            if (var4 == null) {
                ++it;
                var4 = this.func_71124_b(it);
            }
            if (var4 == null) {
                ++it;
                var4 = this.func_71124_b(it);
            }
            if (var4 == null) {
                ++it;
                var4 = this.func_71124_b(it);
            }
            if (var4 != null) {
                par1EntityPlayer.field_71071_by.func_70299_a(par1EntityPlayer.field_71071_by.field_70461_c, var4);
                this.func_70062_b(it, (ItemStack)null);
                this.func_70904_g(false);
                if (!this.field_70170_p.field_72995_K) {
                    this.field_70170_p.func_72960_a((Entity)this, (byte)6);
                }
            }
            else if (!this.field_70170_p.field_72995_K) {
                this.func_70904_g(false);
                this.func_70908_e(true);
                this.field_70170_p.func_72960_a((Entity)this, (byte)7);
                String healthMessage = new String();
                healthMessage = String.format("I have %d health. Thanks for asking!", this.getBoyfriendHealth());
                par1EntityPlayer.func_146105_b((IChatComponent)new ChatComponentText(healthMessage));
            }
            return true;
        }
        return super.func_70085_c(par1EntityPlayer);
    }
    
    public boolean isWheat(final ItemStack par1ItemStack) {
        return par1ItemStack != null && (par1ItemStack.func_77973_b() == Items.field_151083_be || par1ItemStack.func_77973_b() == OreSpawnMain.MyPeacock);
    }
    
    protected boolean func_70692_ba() {
        return false;
    }
    
    protected String func_70639_aQ() {
        if (this.func_70906_o() || this.voice_enable == 0) {
            return null;
        }
        if (OreSpawnMain.bro_mode != 0 && this.field_70170_p.field_73012_v.nextInt(2) == 1) {
            return null;
        }
        if (this.field_70170_p.field_73012_v.nextInt(11) != 1) {
            return null;
        }
        final Entity victim = (Entity)this.func_70638_az();
        if (victim != null) {
            return null;
        }
        if (this.func_70090_H() || this.func_70058_J()) {
            return "orespawn:b_water";
        }
        if (this.field_70170_p.field_73012_v.nextInt(4) != 0) {
            if (this.field_70163_u < 60.0) {
                return null;
            }
            if (this.field_70170_p.func_72911_I()) {
                return "orespawn:b_thunder";
            }
            if (this.field_70170_p.func_72896_J()) {
                return "orespawn:b_rain";
            }
            if (!this.field_70170_p.func_72935_r() && this.field_70170_p.func_72937_j((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v)) {
                if (this.field_70170_p.field_73012_v.nextInt(3) == 0) {
                    return "orespawn:b_dark";
                }
                return null;
            }
        }
        if (!this.func_70909_n()) {
            return null;
        }
        if (this.mygetMaxHealth() > this.func_110143_aJ()) {
            return "orespawn:b_hurt";
        }
        if (OreSpawnMain.bro_mode != 0) {
            return "orespawn:bb_happy";
        }
        return "orespawn:b_happy";
    }
    
    protected String func_70621_aR() {
        if (this.voice_enable == 0) {
            return null;
        }
        if (OreSpawnMain.bro_mode != 0 && this.field_70170_p.field_73012_v.nextInt(2) == 1) {
            return null;
        }
        return "orespawn:b_ow";
    }
    
    protected String func_70673_aS() {
        if (OreSpawnMain.bro_mode != 0) {
            return null;
        }
        return this.func_70909_n() ? "orespawn:b_death_boyfriend" : "orespawn:b_death_single";
    }
    
    protected float func_70599_aP() {
        return 0.3f;
    }
    
    protected Item func_146068_u() {
        return Item.func_150898_a((Block)Blocks.field_150328_O);
    }
    
    protected void func_70628_a(final boolean par1, final int par2) {
        int var3 = 0;
        if (this.func_70909_n()) {
            var3 = this.field_70146_Z.nextInt(5);
            var3 += 2;
            for (int var4 = 0; var4 < var3; ++var4) {
                this.func_145779_a(Item.func_150898_a((Block)Blocks.field_150328_O), 1);
            }
        }
        final Item v6 = OreSpawnMain.MyItemGameController;
        var3 = this.field_70170_p.field_73012_v.nextInt(26);
        var3 += 10;
        for (int var5 = 0; var5 < var3; ++var5) {
            this.func_145779_a(v6, 1);
        }
        if (this.func_70909_n()) {
            ItemStack var6 = this.getCurrentEquippedItem();
            if (var6 != null && var6.field_77994_a > 0) {
                this.func_145779_a(var6.func_77973_b(), var6.field_77994_a);
            }
            var6 = this.func_71124_b(1);
            if (var6 != null && var6.field_77994_a > 0) {
                this.func_145779_a(var6.func_77973_b(), var6.field_77994_a);
            }
            var6 = this.func_71124_b(2);
            if (var6 != null && var6.field_77994_a > 0) {
                this.func_145779_a(var6.func_77973_b(), var6.field_77994_a);
            }
            var6 = this.func_71124_b(3);
            if (var6 != null && var6.field_77994_a > 0) {
                this.func_145779_a(var6.func_77973_b(), var6.field_77994_a);
            }
            var6 = this.func_71124_b(4);
            if (var6 != null && var6.field_77994_a > 0) {
                this.func_145779_a(var6.func_77973_b(), var6.field_77994_a);
            }
        }
    }
    
    public void attackEntityWithRangedAttack(final EntityLivingBase par1EntityLiving) {
        ItemStack it = null;
        if (this.field_82175_bq) {
            return;
        }
        it = this.getCurrentEquippedItem();
        if (it != null && it.func_77973_b() == OreSpawnMain.MyUltimateBow) {
            final EntityArrow var8 = new UltimateArrow(this.field_70170_p, (EntityLiving)this, par1EntityLiving, 2.0f, 10.0f);
            if (this.field_70170_p.field_73012_v.nextInt(4) == 1) {
                var8.func_70243_d(true);
            }
            final int var9 = EnchantmentHelper.func_77506_a(Enchantment.field_77344_u.field_77352_x, it);
            if (var9 > 0) {
                var8.func_70240_a(var9);
            }
            if (EnchantmentHelper.func_77506_a(Enchantment.field_77343_v.field_77352_x, it) > 0) {
                var8.func_70015_d(100);
            }
            it.func_77972_a(1, (EntityLivingBase)this);
            this.field_70170_p.func_72956_a((Entity)this, "random.bow", 1.0f, 1.0f / (this.field_70170_p.field_73012_v.nextFloat() * 0.4f + 1.2f) + 0.5f);
            var8.field_70251_a = 2;
            this.field_70170_p.func_72838_d((Entity)var8);
        }
        else {
            final Shoes var10 = new Shoes(this.field_70170_p, (EntityLivingBase)this, 6);
            final double var11 = par1EntityLiving.field_70165_t - this.field_70165_t;
            final double var12 = par1EntityLiving.field_70163_u + par1EntityLiving.func_70047_e() - 1.1 - var10.field_70163_u;
            final double var13 = par1EntityLiving.field_70161_v - this.field_70161_v;
            final float var14 = MathHelper.func_76133_a(var11 * var11 + var13 * var13) * 0.2f;
            var10.func_70186_c(var11, var12 + var14, var13, 1.8f, 4.0f);
            this.field_70170_p.func_72956_a((Entity)this, "random.bow", 0.75f, 1.0f / (this.func_70681_au().nextFloat() * 0.4f + 0.8f));
            this.field_70170_p.func_72838_d((Entity)var10);
        }
        this.func_71038_i();
    }
    
    public ItemStack getCurrentEquippedItem() {
        return this.func_71124_b(0);
    }
    
    public void attackTargetEntityWithCurrentItem(final Entity par1Entity) {
        final ItemStack stack = this.getCurrentEquippedItem();
        if (stack != null) {
            float var2 = 0.0f;
            if (this.func_70644_a(Potion.field_76420_g)) {
                var2 += 3 << this.func_70660_b(Potion.field_76420_g).func_76458_c();
            }
            if (this.func_70644_a(Potion.field_76437_t)) {
                var2 -= 2 << this.func_70660_b(Potion.field_76437_t).func_76458_c();
            }
            int var3 = 0;
            float var4 = (float)this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111126_e();
            if (par1Entity instanceof EntityLiving) {
                var4 += EnchantmentHelper.func_77512_a((EntityLivingBase)this, (EntityLivingBase)par1Entity);
                var3 += EnchantmentHelper.func_77507_b((EntityLivingBase)this, (EntityLivingBase)par1Entity);
            }
            if (this.func_70051_ag()) {
                ++var3;
            }
            if (var2 > 0.0f || var4 > 0.0f) {
                final boolean var5 = this.field_70143_R > 0.0f && !this.field_70122_E && !this.func_70617_f_() && !this.func_70090_H() && !this.func_70058_J() && !this.func_70644_a(Potion.field_76440_q) && this.field_70154_o == null && par1Entity instanceof EntityLiving;
                if (var5) {
                    var2 += this.field_70170_p.field_73012_v.nextInt((int)var2 / 2 + 2);
                }
                var2 += var4;
                final boolean var6 = par1Entity.func_70097_a(DamageSource.func_76358_a((EntityLivingBase)this), var2);
                if (var6 && var3 > 0) {
                    par1Entity.func_70024_g((double)(-MathHelper.func_76126_a(this.field_70177_z * 3.1415927f / 180.0f) * var3 * 0.5f), 0.1, (double)(MathHelper.func_76134_b(this.field_70177_z * 3.1415927f / 180.0f) * var3 * 0.5f));
                    this.field_70159_w *= 0.6;
                    this.field_70179_y *= 0.6;
                    this.func_70031_b(false);
                }
                final ItemStack var7 = this.getCurrentEquippedItem();
                if (par1Entity instanceof EntityLiving) {
                    final int var8 = EnchantmentHelper.func_77506_a(Enchantment.field_77334_n.field_77352_x, var7);
                    if (var8 > 0 && var6) {
                        par1Entity.func_70015_d(var8 * 4);
                    }
                }
            }
        }
    }
    
    protected float func_70647_i() {
        return (this.voice - 5) * 0.02f + 1.0f;
    }
    
    public EntityAgeable func_90011_a(final EntityAgeable var1) {
        return null;
    }
    
    public void func_82196_d(final EntityLivingBase entityliving, final float f) {
        this.attackEntityWithRangedAttack(entityliving);
    }
    
    public boolean func_70097_a(final DamageSource par1DamageSource, final float par2) {
        boolean ret = false;
        float p2 = par2;
        if (p2 > 10.0f) {
            p2 = 10.0f;
        }
        if (!par1DamageSource.func_76355_l().equals("cactus")) {
            ret = super.func_70097_a(par1DamageSource, p2);
        }
        return ret;
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
                        if (s != null && s.equals("Boyfriend")) {
                            return true;
                        }
                    }
                }
            }
        }
        return super.func_70601_bi();
    }
    
    static {
        DryTexture0 = new ResourceLocation("orespawn", "boyfriend0.png");
        DryTexture1 = new ResourceLocation("orespawn", "boyfriend1.png");
        DryTexture2 = new ResourceLocation("orespawn", "boyfriend2.png");
        DryTexture3 = new ResourceLocation("orespawn", "boyfriend3.png");
        DryTexture4 = new ResourceLocation("orespawn", "boyfriend4.png");
        DryTexture5 = new ResourceLocation("orespawn", "boyfriend5.png");
        DryTexture6 = new ResourceLocation("orespawn", "boyfriend6.png");
        DryTexture7 = new ResourceLocation("orespawn", "boyfriend7.png");
        DryTexture8 = new ResourceLocation("orespawn", "boyfriend8.png");
        DryTexture9 = new ResourceLocation("orespawn", "boyfriend9.png");
        DryTexture10 = new ResourceLocation("orespawn", "boyfriend10.png");
        DryTexture11 = new ResourceLocation("orespawn", "boyfriend11.png");
        DryTexture12 = new ResourceLocation("orespawn", "boyfriend12.png");
        DryTexture13 = new ResourceLocation("orespawn", "boyfriend13.png");
        DryTexture14 = new ResourceLocation("orespawn", "boyfriend14.png");
        DryTexture15 = new ResourceLocation("orespawn", "boyfriend15.png");
        DryTexture16 = new ResourceLocation("orespawn", "boyfriend16.png");
        DryTexture17 = new ResourceLocation("orespawn", "boyfriend17.png");
        DryTexture18 = new ResourceLocation("orespawn", "boyfriend18.png");
        DryTexture19 = new ResourceLocation("orespawn", "boyfriend19.png");
        DryTexture20 = new ResourceLocation("orespawn", "boyfriend20.png");
        DryTexture21 = new ResourceLocation("orespawn", "boyfriend21.png");
        DryTexture22 = new ResourceLocation("orespawn", "boyfriend22.png");
        DryTexture23 = new ResourceLocation("orespawn", "boyfriend23.png");
        DryTexture24 = new ResourceLocation("orespawn", "boyfriend24.png");
        DryTexture25 = new ResourceLocation("orespawn", "boyfriend25.png");
        DryTexture26 = new ResourceLocation("orespawn", "boyfriend26.png");
        DryTexture27 = new ResourceLocation("orespawn", "boyfriend27.png");
        WetTexture0 = new ResourceLocation("orespawn", "swimshorts0.png");
        WetTexture1 = new ResourceLocation("orespawn", "swimshorts1.png");
        WetTexture2 = new ResourceLocation("orespawn", "swimshorts2.png");
        WetTexture3 = new ResourceLocation("orespawn", "swimshorts3.png");
        WetTexture4 = new ResourceLocation("orespawn", "swimshorts4.png");
        WetTexture5 = new ResourceLocation("orespawn", "swimshorts5.png");
        WetTexture6 = new ResourceLocation("orespawn", "swimshorts6.png");
        WetTexture7 = new ResourceLocation("orespawn", "swimshorts7.png");
        WetTexture8 = new ResourceLocation("orespawn", "swimshorts8.png");
        WetTexture9 = new ResourceLocation("orespawn", "swimshorts9.png");
        WetTexture10 = new ResourceLocation("orespawn", "swimshorts10.png");
        WetTexture11 = new ResourceLocation("orespawn", "swimshorts11.png");
        WetTexture12 = new ResourceLocation("orespawn", "swimshorts12.png");
        WetTexture13 = new ResourceLocation("orespawn", "swimshorts13.png");
        WetTexture14 = new ResourceLocation("orespawn", "swimshorts14.png");
        WetTexture15 = new ResourceLocation("orespawn", "swimshorts15.png");
        WetTexture16 = new ResourceLocation("orespawn", "swimshorts16.png");
        WetTexture17 = new ResourceLocation("orespawn", "swimshorts17.png");
        PrinceTexture1 = new ResourceLocation("orespawn", "FrogPrince.png");
        PrinceTexture2 = new ResourceLocation("orespawn", "FrogPrince2.png");
    }
}

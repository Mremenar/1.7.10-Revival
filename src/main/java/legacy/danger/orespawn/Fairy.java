// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.block.Block;
import net.minecraft.util.MathHelper;
import net.minecraft.init.Blocks;
import net.minecraft.util.Vec3;
import java.util.Iterator;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.EntityLiving;
import net.minecraft.world.World;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.passive.EntityAmbientCreature;

public class Fairy extends EntityAmbientCreature
{
    private static final ResourceLocation texture0;
    private static final ResourceLocation texture1;
    private static final ResourceLocation texture2;
    private static final ResourceLocation texture3;
    private static final ResourceLocation texture4;
    private static final ResourceLocation texture5;
    private static final ResourceLocation texture6;
    private static final ResourceLocation texture7;
    private static final ResourceLocation texture8;
    int my_blink;
    int blinker;
    int myspace;
    public int fairy_type;
    private int force_sync;
    private ChunkCoordinates currentFlightTarget;
    private String myowner;
    private GenericTargetSorter TargetSorter;
    
    public Fairy(final World par1World) {
        super(par1World);
        this.my_blink = 0;
        this.blinker = 0;
        this.myspace = 0;
        this.fairy_type = 0;
        this.force_sync = 10;
        this.currentFlightTarget = null;
        this.myowner = null;
        this.TargetSorter = null;
        this.my_blink = 20 + this.field_70146_Z.nextInt(20);
        this.func_70105_a(0.4f, 0.8f);
        if (par1World != null) {
            this.fairy_type = par1World.field_73012_v.nextInt(9);
        }
        this.func_70661_as().func_75491_a(true);
        this.field_70155_l = 3.0;
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityLiving.class, 8.0f));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.TargetSorter = new GenericTargetSorter((Entity)this);
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)this.mygetMaxHealth());
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.10000000149011612);
        this.func_110140_aT().func_111150_b(SharedMonsterAttributes.field_111264_e);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(3.0);
    }
    
    public ResourceLocation getTexture(final Fairy a) {
        if (this.fairy_type == 8) {
            return Fairy.texture8;
        }
        if (this.fairy_type == 7) {
            return Fairy.texture7;
        }
        if (this.fairy_type == 6) {
            return Fairy.texture6;
        }
        if (this.fairy_type == 5) {
            return Fairy.texture5;
        }
        if (this.fairy_type == 4) {
            return Fairy.texture4;
        }
        if (this.fairy_type == 3) {
            return Fairy.texture3;
        }
        if (this.fairy_type == 2) {
            return Fairy.texture2;
        }
        if (this.fairy_type == 1) {
            return Fairy.texture1;
        }
        return Fairy.texture0;
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_75682_a(20, (Object)this.fairy_type);
    }
    
    public void setOwner(final EntityLivingBase e) {
        EntityPlayer p = null;
        if (e != null && e instanceof EntityPlayer) {
            p = (EntityPlayer)e;
            final String s = p.getDisplayName();
            if (s != null) {
                this.myowner = s;
            }
        }
    }
    
    public float getBlink() {
        if (this.blinker < this.my_blink / 2) {
            return 240.0f;
        }
        return 0.0f;
    }
    
    public boolean func_70652_k(final Entity par1Entity) {
        if (this.field_70170_p.field_73013_u == EnumDifficulty.PEACEFUL) {
            return false;
        }
        final boolean var4 = par1Entity.func_70097_a(DamageSource.func_76358_a((EntityLivingBase)this), 2.0f);
        return var4;
    }
    
    public int func_70658_aO() {
        return 4;
    }
    
    protected float func_70599_aP() {
        return 0.25f;
    }
    
    protected float func_70647_i() {
        return 1.7f;
    }
    
    protected String func_70639_aQ() {
        return null;
    }
    
    protected String func_70621_aR() {
        return "orespawn:rat_hit";
    }
    
    protected String func_70673_aS() {
        return "orespawn:big_splat";
    }
    
    public boolean func_70104_M() {
        return true;
    }
    
    protected void func_82167_n(final Entity par1Entity) {
    }
    
    protected void func_85033_bc() {
    }
    
    public int mygetMaxHealth() {
        return 40;
    }
    
    protected Item func_146068_u() {
        return Item.func_150898_a(OreSpawnMain.CrystalTorch);
    }
    
    protected boolean func_70650_aV() {
        return true;
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        this.field_70181_x *= 0.600000023841;
        ++this.blinker;
        if (this.blinker > this.my_blink) {
            this.blinker = 0;
        }
        --this.force_sync;
        if (this.force_sync < 0) {
            this.force_sync = 10;
            if (this.field_70170_p.field_72995_K) {
                this.fairy_type = this.field_70180_af.func_75679_c(20);
            }
            else {
                this.field_70180_af.func_75692_b(20, (Object)this.fairy_type);
            }
        }
        long t = this.field_70170_p.func_72820_D();
        t %= 24000L;
        if (t < 12000L) {
            return;
        }
        if (this.field_70170_p.field_72995_K && this.field_70170_p.field_73012_v.nextInt(5) == 0 && this.getBlink() > 1.0f) {
            this.field_70170_p.func_72869_a("fireworksSpark", this.field_70165_t, this.field_70163_u - 0.15000000596046448, this.field_70161_v, (double)((this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat()) / 8.0f), (double)(-this.field_70170_p.field_73012_v.nextFloat() / 8.0f), (double)((this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat()) / 8.0f));
        }
    }
    
    public void func_70014_b(final NBTTagCompound par1NBTTagCompound) {
        super.func_70014_b(par1NBTTagCompound);
        if (this.myowner == null) {
            this.myowner = "null";
        }
        par1NBTTagCompound.func_74778_a("MyOwner", this.myowner);
        par1NBTTagCompound.func_74768_a("FairyType", this.fairy_type);
    }
    
    public void func_70037_a(final NBTTagCompound par1NBTTagCompound) {
        super.func_70037_a(par1NBTTagCompound);
        this.myowner = par1NBTTagCompound.func_74779_i("MyOwner");
        if (this.myowner != null && this.myowner.equals("null")) {
            this.myowner = null;
        }
        this.fairy_type = par1NBTTagCompound.func_74762_e("fairyType");
    }
    
    private boolean isSuitableTarget(final EntityLivingBase par1EntityLiving, final boolean par2) {
        return this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL && par1EntityLiving != null && par1EntityLiving != this && par1EntityLiving.func_70089_S() && this.func_70635_at().func_75522_a((Entity)par1EntityLiving) && par1EntityLiving instanceof EntityMob;
    }
    
    private EntityLivingBase findSomethingToAttack() {
        if (OreSpawnMain.PlayNicely != 0) {
            return null;
        }
        final List var5 = this.field_70170_p.func_72872_a((Class)EntityLivingBase.class, this.field_70121_D.func_72314_b(8.0, 8.0, 8.0));
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
    
    public boolean canSeeTarget(final double pX, final double pY, final double pZ) {
        return this.field_70170_p.func_72901_a(Vec3.func_72443_a(this.field_70165_t, this.field_70163_u + 0.25, this.field_70161_v), Vec3.func_72443_a(pX, pY, pZ), false) == null;
    }
    
    protected void func_70619_bc() {
        int keep_trying = 25;
        if (this.field_70128_L) {
            return;
        }
        super.func_70619_bc();
        if (this.currentFlightTarget == null) {
            this.currentFlightTarget = new ChunkCoordinates((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v);
        }
        if (this.field_70170_p.field_73012_v.nextInt(200) == 0 || this.currentFlightTarget.func_71569_e((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v) < 2.5f) {
            for (Block bid = Blocks.field_150348_b; bid != Blocks.field_150350_a && keep_trying != 0; --keep_trying) {
                int zdir = this.field_70170_p.field_73012_v.nextInt(8);
                int xdir = this.field_70170_p.field_73012_v.nextInt(8);
                if (this.field_70170_p.field_73012_v.nextInt(2) == 0) {
                    zdir = -zdir;
                }
                if (this.field_70170_p.field_73012_v.nextInt(2) == 0) {
                    xdir = -xdir;
                }
                this.currentFlightTarget.func_71571_b((int)this.field_70165_t + xdir, (int)this.field_70163_u + this.field_70170_p.field_73012_v.nextInt(5) - 2, (int)this.field_70161_v + zdir);
                bid = this.field_70170_p.func_147439_a(this.currentFlightTarget.field_71574_a, this.currentFlightTarget.field_71572_b, this.currentFlightTarget.field_71573_c);
                if (bid == Blocks.field_150350_a && !this.canSeeTarget(this.currentFlightTarget.field_71574_a, this.currentFlightTarget.field_71572_b, this.currentFlightTarget.field_71573_c)) {
                    bid = Blocks.field_150348_b;
                }
            }
        }
        else if (this.field_70170_p.field_73012_v.nextInt(12) == 0 && this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL) {
            EntityLivingBase e = null;
            e = this.findSomethingToAttack();
            if (e != null) {
                this.currentFlightTarget.func_71571_b((int)e.field_70165_t, (int)(e.field_70163_u + 1.0), (int)e.field_70161_v);
                if (this.func_70068_e((Entity)e) < 6.0) {
                    this.func_70652_k((Entity)e);
                }
            }
        }
        else if (this.myowner != null) {
            final EntityPlayer p = this.field_70170_p.func_72924_a(this.myowner);
            if (p != null) {
                if (this.func_70068_e((Entity)p) > 64.0) {
                    this.currentFlightTarget.func_71571_b((int)p.field_70165_t + this.field_70170_p.field_73012_v.nextInt(3) - this.field_70170_p.field_73012_v.nextInt(3), (int)(p.field_70163_u + 1.0), (int)p.field_70161_v + this.field_70170_p.field_73012_v.nextInt(3) - this.field_70170_p.field_73012_v.nextInt(3));
                }
                if (this.func_70068_e((Entity)p) > 256.0) {
                    this.func_70107_b(p.field_70165_t + this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat(), p.field_70163_u, p.field_70161_v + this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat());
                }
            }
        }
        if (this.field_70170_p.field_73012_v.nextInt(250) == 1) {
            this.func_70691_i(1.0f);
        }
        final double var1 = this.currentFlightTarget.field_71574_a + 0.5 - this.field_70165_t;
        final double var2 = this.currentFlightTarget.field_71572_b + 0.1 - this.field_70163_u;
        final double var3 = this.currentFlightTarget.field_71573_c + 0.5 - this.field_70161_v;
        this.field_70159_w += (Math.signum(var1) * 0.2 - this.field_70159_w) * 0.1;
        this.field_70181_x += (Math.signum(var2) * 0.699999988079071 - this.field_70181_x) * 0.1;
        this.field_70179_y += (Math.signum(var3) * 0.2 - this.field_70179_y) * 0.1;
        final float var4 = (float)(Math.atan2(this.field_70179_y, this.field_70159_w) * 180.0 / 3.141592653589793) - 90.0f;
        final float var5 = MathHelper.func_76142_g(var4 - this.field_70177_z);
        this.field_70701_bs = 0.2f;
        this.field_70177_z += var5 / 4.0f;
    }
    
    protected boolean func_70041_e_() {
        return false;
    }
    
    protected void func_70069_a(final float par1) {
    }
    
    protected void func_70064_a(final double par1, final boolean par3) {
    }
    
    public boolean func_145773_az() {
        return true;
    }
    
    public boolean func_70601_bi() {
        int sc = 0;
        for (int k = -1; k <= 1; ++k) {
            for (int j = -1; j <= 1; ++j) {
                final Block bid = this.field_70170_p.func_147439_a((int)this.field_70165_t + j, (int)this.field_70163_u, (int)this.field_70161_v + k);
                if (bid == Blocks.field_150350_a) {
                    ++sc;
                }
            }
        }
        return sc >= 6 && this.field_70163_u >= 50.0;
    }
    
    public void initCreature() {
    }
    
    protected boolean func_70692_ba() {
        return !this.func_104002_bU() && this.myowner == null;
    }
    
    static {
        texture0 = new ResourceLocation("orespawn", "fairytexture.png");
        texture1 = new ResourceLocation("orespawn", "fairytexture2.png");
        texture2 = new ResourceLocation("orespawn", "fairytexture3.png");
        texture3 = new ResourceLocation("orespawn", "fairytexture4.png");
        texture4 = new ResourceLocation("orespawn", "fairytexture5.png");
        texture5 = new ResourceLocation("orespawn", "fairytexture6.png");
        texture6 = new ResourceLocation("orespawn", "fairytexture7.png");
        texture7 = new ResourceLocation("orespawn", "fairytexture8.png");
        texture8 = new ResourceLocation("orespawn", "fairytexture9.png");
    }
}

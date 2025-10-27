// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.block.Block;
import net.minecraft.util.MathHelper;
import net.minecraft.init.Blocks;
import net.minecraft.util.Vec3;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.entity.passive.EntityAnimal;

public class Cockateil extends EntityAnimal
{
    private ChunkCoordinates currentFlightTarget;
    public int birdtype;
    private boolean killedByPlayer;
    private static final ResourceLocation texture1;
    private static final ResourceLocation texture2;
    private static final ResourceLocation texture3;
    private static final ResourceLocation texture4;
    private static final ResourceLocation texture5;
    private static final ResourceLocation texture6;
    private int stuck_count;
    private int lastX;
    private int lastZ;
    private int flyup;
    
    public Cockateil(final World par1World) {
        super(par1World);
        this.currentFlightTarget = null;
        this.killedByPlayer = false;
        this.stuck_count = 0;
        this.lastX = 0;
        this.lastZ = 0;
        this.flyup = 0;
        this.func_70105_a(0.5f, 0.5f);
        this.func_70661_as().func_75491_a(true);
        this.field_70728_aV = 2;
        this.field_70178_ae = false;
        this.field_70174_ab = 2;
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)this.mygetMaxHealth());
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.33000001311302185);
        this.func_110140_aT().func_111150_b(SharedMonsterAttributes.field_111264_e);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
    }
    
    public ResourceLocation getTexture() {
        switch (this.birdtype = this.getBirdType()) {
            case 0: {
                return Cockateil.texture1;
            }
            case 1: {
                return Cockateil.texture2;
            }
            case 2: {
                return Cockateil.texture3;
            }
            case 3: {
                return Cockateil.texture4;
            }
            case 4: {
                return Cockateil.texture5;
            }
            case 5: {
                return Cockateil.texture6;
            }
            default: {
                return null;
            }
        }
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.birdtype = this.field_70146_Z.nextInt(6);
        this.field_70180_af.func_75682_a(22, (Object)this.birdtype);
    }
    
    protected boolean func_70692_ba() {
        return !this.func_104002_bU();
    }
    
    public int getBirdType() {
        return this.field_70180_af.func_75679_c(22);
    }
    
    public void setBirdType(final int par1) {
        this.field_70180_af.func_75692_b(22, (Object)par1);
    }
    
    protected float func_70599_aP() {
        return 0.55f;
    }
    
    protected float func_70647_i() {
        return 1.0f;
    }
    
    protected String func_70639_aQ() {
        if (this.field_70170_p.func_72935_r() && !this.field_70170_p.func_72896_J()) {
            return "orespawn:birds";
        }
        return null;
    }
    
    protected String func_70621_aR() {
        return "orespawn:duck_hurt";
    }
    
    protected String func_70673_aS() {
        return "orespawn:duck_hurt";
    }
    
    public boolean func_70104_M() {
        return true;
    }
    
    public int mygetMaxHealth() {
        return 2;
    }
    
    protected boolean func_70650_aV() {
        return true;
    }
    
    public boolean func_70097_a(final DamageSource par1DamageSource, final float par2) {
        final Entity e = par1DamageSource.func_76346_g();
        if (e != null && e instanceof EntityPlayer) {
            this.killedByPlayer = true;
        }
        return super.func_70097_a(par1DamageSource, par2);
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.currentFlightTarget == null) {
            this.currentFlightTarget = new ChunkCoordinates((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v);
        }
        else if (this.field_70163_u < this.currentFlightTarget.field_71572_b) {
            this.field_70181_x *= 0.7;
        }
        else {
            this.field_70181_x *= 0.5;
        }
    }
    
    public int getAttackStrength(final Entity par1Entity) {
        return 1;
    }
    
    public void setFlyUp() {
        this.flyup = 2;
    }
    
    protected void func_70069_a(final float par1) {
    }
    
    protected void func_70064_a(final double par1, final boolean par3) {
    }
    
    public boolean canSeeTarget(final double pX, final double pY, final double pZ) {
        return this.field_70170_p.func_72901_a(Vec3.func_72443_a(this.field_70165_t, this.field_70163_u + 0.75, this.field_70161_v), Vec3.func_72443_a(pX, pY, pZ), false) == null;
    }
    
    protected void func_70619_bc() {
        int xdir = 1;
        int zdir = 1;
        int keep_trying = 35;
        int stayup = 0;
        if (this.field_70128_L) {
            return;
        }
        super.func_70619_bc();
        if (this.field_70170_p.field_73011_w.field_76574_g == OreSpawnMain.DimensionID4) {
            stayup = 2;
        }
        if (this.lastX == (int)this.field_70165_t && this.lastZ == (int)this.field_70161_v) {
            ++this.stuck_count;
        }
        else {
            this.stuck_count = 0;
            this.lastX = (int)this.field_70165_t;
            this.lastZ = (int)this.field_70161_v;
        }
        if (this.currentFlightTarget == null) {
            this.currentFlightTarget = new ChunkCoordinates((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v);
        }
        if (this.stuck_count > 40 || this.field_70146_Z.nextInt(250) == 0 || this.currentFlightTarget.func_71569_e((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v) < 4.1f) {
            Block bid = Blocks.field_150348_b;
            this.stuck_count = 0;
            while (bid != Blocks.field_150350_a && keep_trying != 0) {
                zdir = this.field_70146_Z.nextInt(8) + 5 - this.flyup * 2;
                xdir = this.field_70146_Z.nextInt(8) + 5 - this.flyup * 2;
                if (this.field_70146_Z.nextInt(2) == 0) {
                    zdir = -zdir;
                }
                if (this.field_70146_Z.nextInt(2) == 0) {
                    xdir = -xdir;
                }
                this.currentFlightTarget.func_71571_b((int)this.field_70165_t + xdir, (int)this.field_70163_u + this.field_70146_Z.nextInt(9 + stayup) - 5 + this.flyup, (int)this.field_70161_v + zdir);
                bid = this.field_70170_p.func_147439_a(this.currentFlightTarget.field_71574_a, this.currentFlightTarget.field_71572_b, this.currentFlightTarget.field_71573_c);
                if (bid == Blocks.field_150350_a && !this.canSeeTarget(this.currentFlightTarget.field_71574_a, this.currentFlightTarget.field_71572_b, this.currentFlightTarget.field_71573_c)) {
                    bid = Blocks.field_150348_b;
                }
                --keep_trying;
            }
        }
        final double var1 = this.currentFlightTarget.field_71574_a + 0.3 - this.field_70165_t;
        final double var2 = this.currentFlightTarget.field_71572_b + 0.1 - this.field_70163_u;
        final double var3 = this.currentFlightTarget.field_71573_c + 0.3 - this.field_70161_v;
        this.field_70159_w += (Math.signum(var1) * 0.3 - this.field_70159_w) * 0.25;
        this.field_70181_x += (Math.signum(var2) * 0.699999 - this.field_70181_x) * 0.200000001;
        this.field_70179_y += (Math.signum(var3) * 0.3 - this.field_70179_y) * 0.25;
        final float var4 = (float)(Math.atan2(this.field_70179_y, this.field_70159_w) * 180.0 / 3.141592653589793) - 90.0f;
        final float var5 = MathHelper.func_76142_g(var4 - this.field_70177_z);
        this.field_70701_bs = 0.8f;
        this.field_70177_z += var5 / 3.0f;
    }
    
    protected boolean func_70041_e_() {
        return true;
    }
    
    public boolean func_145773_az() {
        return false;
    }
    
    public boolean func_70601_bi() {
        return this.field_70170_p.func_72935_r() && (this.field_70170_p.field_73011_w.field_76574_g == OreSpawnMain.DimensionID4 || this.field_70163_u >= 50.0);
    }
    
    protected Item func_146068_u() {
        this.birdtype = this.getBirdType();
        if (this.birdtype == 5 && this.killedByPlayer && this.field_70170_p.field_73012_v.nextInt(3) == 1) {
            return OreSpawnMain.MyRuby;
        }
        return Items.field_151008_G;
    }
    
    public void initCreature() {
    }
    
    public EntityAgeable func_90011_a(final EntityAgeable var1) {
        return null;
    }
    
    public void func_70014_b(final NBTTagCompound par1NBTTagCompound) {
        super.func_70014_b(par1NBTTagCompound);
        par1NBTTagCompound.func_74768_a("BirdType", this.getBirdType());
    }
    
    public void func_70037_a(final NBTTagCompound par1NBTTagCompound) {
        super.func_70037_a(par1NBTTagCompound);
        this.setBirdType(this.birdtype = par1NBTTagCompound.func_74762_e("BirdType"));
    }
    
    static {
        texture1 = new ResourceLocation("orespawn", "Bird1.png");
        texture2 = new ResourceLocation("orespawn", "Bird2.png");
        texture3 = new ResourceLocation("orespawn", "Bird3.png");
        texture4 = new ResourceLocation("orespawn", "Bird4.png");
        texture5 = new ResourceLocation("orespawn", "Bird5.png");
        texture6 = new ResourceLocation("orespawn", "Bird6.png");
    }
}

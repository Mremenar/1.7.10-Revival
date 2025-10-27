// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.block.Block;
import java.util.List;
import net.minecraft.init.Items;
import net.minecraft.util.MathHelper;
import net.minecraft.network.play.client.C0CPacketInput;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.init.Blocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.EntityLiving;

public class Elevator extends EntityLiving
{
    private int boatPosRotationIncrements;
    private double boatX;
    private double boatY;
    private double boatZ;
    private double boatYaw;
    private double boatPitch;
    private double velocityX;
    private double velocityY;
    private double velocityZ;
    private int damage_counter;
    private int exploding;
    private int color;
    private int playing;
    private static final ResourceLocation texture1;
    private static final ResourceLocation texture2;
    private static final ResourceLocation texture3;
    private static final ResourceLocation texture4;
    private static final ResourceLocation texture5;
    private static final ResourceLocation texture6;
    private static final ResourceLocation texture7;
    private static final ResourceLocation texture8;
    private static final ResourceLocation texture9;
    private static final ResourceLocation texture10;
    
    public Elevator(final World par1World) {
        super(par1World);
        this.damage_counter = 100;
        this.exploding = 0;
        this.color = 1;
        this.playing = 0;
        this.func_70105_a(1.25f, 1.0f);
        this.field_70153_n = null;
    }
    
    public Elevator(final World par1World, final double par2, final double par4, final double par6) {
        this(par1World);
        this.func_70107_b(par2, par4 + this.field_70129_M, par6);
        this.field_70159_w = 0.0;
        this.field_70181_x = 0.0;
        this.field_70179_y = 0.0;
        this.field_70169_q = par2;
        this.field_70167_r = par4;
        this.field_70166_s = par6;
    }
    
    public ResourceLocation getTexture() {
        switch (this.getColor()) {
            case 1: {
                return Elevator.texture1;
            }
            case 2: {
                return Elevator.texture2;
            }
            case 3: {
                return Elevator.texture3;
            }
            case 4: {
                return Elevator.texture4;
            }
            case 5: {
                return Elevator.texture5;
            }
            case 6: {
                return Elevator.texture6;
            }
            case 7: {
                return Elevator.texture7;
            }
            case 8: {
                return Elevator.texture8;
            }
            case 9: {
                return Elevator.texture9;
            }
            case 10: {
                return Elevator.texture10;
            }
            default: {
                return Elevator.texture1;
            }
        }
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(60.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(1.3300000429153442);
        this.func_110140_aT().func_111150_b(SharedMonsterAttributes.field_111264_e);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(0.0);
    }
    
    protected boolean func_70692_ba() {
        return false;
    }
    
    public boolean shouldRiderSit() {
        return false;
    }
    
    public int getTrackingRange() {
        return 128;
    }
    
    public int getUpdateFrequency() {
        return 10;
    }
    
    public boolean sendsVelocityUpdates() {
        return true;
    }
    
    protected void func_70069_a(final float par1) {
    }
    
    protected void func_70064_a(final double par1, final boolean par3) {
    }
    
    protected boolean func_70041_e_() {
        return false;
    }
    
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_75682_a(22, (Object)new Integer(0));
        this.field_70180_af.func_75682_a(23, (Object)new Integer(1));
        this.field_70180_af.func_75682_a(24, (Object)new Float(0.0f));
        this.field_70180_af.func_75682_a(20, (Object)new Integer(0));
        this.field_70180_af.func_75682_a(21, (Object)new Integer(0));
        this.func_110163_bv();
    }
    
    public boolean func_70104_M() {
        return true;
    }
    
    public double func_70042_X() {
        return 0.5;
    }
    
    public boolean func_70097_a(final DamageSource par1DamageSource, final float par2) {
        final boolean p = par1DamageSource.func_76346_g() instanceof EntityPlayer;
        if (this.field_70153_n != null && !p) {
            return false;
        }
        if (par1DamageSource.func_76355_l().equals("inWall")) {
            return false;
        }
        if (!this.field_70170_p.field_72995_K && !this.field_70128_L) {
            this.setForwardDirection(-this.getForwardDirection());
            this.setTimeSinceHit(10);
            this.setDamageTaken(this.getDamageTaken() + par2 * 10.0f);
            this.func_70018_K();
            final boolean flag = par1DamageSource.func_76346_g() instanceof EntityPlayer && ((EntityPlayer)par1DamageSource.func_76346_g()).field_71075_bZ.field_75098_d;
            if (flag || this.getDamageTaken() > 40.0f) {
                if (this.field_70153_n != null) {
                    this.field_70153_n.func_70078_a((Entity)this);
                }
                if (!flag) {
                    this.func_145779_a(OreSpawnMain.MyElevator, 1);
                }
                this.func_70106_y();
            }
            return true;
        }
        return true;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_70057_ab() {
        this.setForwardDirection(-this.getForwardDirection());
        this.setTimeSinceHit(10);
        this.setDamageTaken(this.getDamageTaken() * 11.0f);
    }
    
    public boolean func_70067_L() {
        return !this.field_70128_L;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_70056_a(final double par1, final double par3, final double par5, final float par7, final float par8, final int par9) {
        if (this.field_70153_n != null) {
            this.boatPosRotationIncrements = par9 + 8;
        }
        else {
            this.boatPosRotationIncrements = 6;
        }
        this.boatX = par1;
        this.boatY = par3;
        this.boatZ = par5;
        this.boatYaw = par7;
        this.boatPitch = par8;
        this.field_70159_w = this.velocityX;
        this.field_70181_x = this.velocityY;
        this.field_70179_y = this.velocityZ;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_70016_h(final double par1, final double par3, final double par5) {
        this.field_70159_w = par1;
        this.velocityX = par1;
        this.field_70181_x = par3;
        this.velocityY = par3;
        this.field_70179_y = par5;
        this.velocityZ = par5;
    }
    
    public void onLivingpdate() {
        if (this.field_70153_n == null) {
            super.func_70636_d();
        }
        this.func_70015_d(0);
    }
    
    public void func_70071_h_() {
        List list = null;
        final double velocity = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
        double d6 = this.field_70146_Z.nextFloat() * 2.0f - 1.0f;
        double d7 = (this.field_70146_Z.nextInt(2) * 2 - 1) * 0.7;
        double obstruction_factor = 0.0;
        double relative_g = 0.0;
        double max_speed = 0.85;
        double gh = 0.75;
        int dist = 2;
        if (this.field_70128_L) {
            return;
        }
        this.field_70160_al = true;
        if (this.getTimeSinceHit() > 0) {
            this.setTimeSinceHit(this.getTimeSinceHit() - 1);
        }
        if (this.getDamageTaken() > 0.0f) {
            this.setDamageTaken(this.getDamageTaken() - 1.0f);
        }
        this.field_70169_q = this.field_70165_t;
        this.field_70167_r = this.field_70163_u;
        this.field_70166_s = this.field_70161_v;
        if (velocity > 0.15 && this.field_70153_n != null) {
            final double d8 = Math.cos(Math.toRadians(this.field_70177_z + 270.0f));
            final double d9 = Math.sin(Math.toRadians(this.field_70177_z + 270.0f));
            Block bid = Blocks.field_150350_a;
            int i;
            for (i = 1; i < 10; ++i) {
                bid = this.field_70170_p.func_147439_a((int)this.field_70165_t, (int)this.field_70163_u - i, (int)this.field_70161_v);
                if (bid != Blocks.field_150350_a) {
                    break;
                }
            }
            for (int j = 0; j < 1.0 + velocity * 10.0; ++j) {
                d6 = this.field_70146_Z.nextFloat() * 2.0f - 1.0f;
                d7 = (this.field_70146_Z.nextInt(2) * 2 - 1) * 0.7;
                if (this.field_70146_Z.nextBoolean()) {
                    final double d10 = this.field_70165_t - d8 * d6 * 0.8 + d9 * d7;
                    final double d11 = this.field_70161_v - d9 * d6 * 0.8 - d8 * d7;
                    if (this.field_70146_Z.nextBoolean()) {
                        this.field_70170_p.func_72869_a("smoke", d10, this.field_70163_u - 0.25, d11, this.field_70159_w, this.field_70181_x, this.field_70179_y);
                    }
                    else {
                        this.field_70170_p.func_72869_a("reddust", d10, this.field_70163_u - 0.25, d11, this.field_70159_w, this.field_70181_x, this.field_70179_y);
                    }
                }
                else {
                    final double d10 = this.field_70165_t + d8 + d9 * d6 * 0.7;
                    final double d11 = this.field_70161_v + d9 - d8 * d6 * 0.7;
                    if (this.field_70146_Z.nextBoolean()) {
                        this.field_70170_p.func_72869_a("smoke", d10, this.field_70163_u - 0.225, d11, this.field_70159_w, this.field_70181_x, this.field_70179_y);
                    }
                    else {
                        this.field_70170_p.func_72869_a("reddust", d10, this.field_70163_u - 0.225, d11, this.field_70159_w, this.field_70181_x, this.field_70179_y);
                    }
                }
                if (bid == Blocks.field_150355_j || bid == Blocks.field_150358_i) {
                    for (int k = 0; k < 5; ++k) {
                        this.field_70170_p.func_72869_a("splash", this.field_70165_t + this.field_70146_Z.nextFloat(), this.field_70163_u - i + 1.25, this.field_70161_v + this.field_70146_Z.nextFloat(), this.field_70159_w / 2.0, this.field_70181_x + velocity, this.field_70179_y / 2.0);
                    }
                }
            }
        }
        if (this.playing > 0) {
            --this.playing;
        }
        if (this.field_70153_n != null && this.playing == 0 && this.field_70170_p.field_73012_v.nextInt(80) == 1) {
            this.field_70170_p.func_72956_a(this.field_70153_n, "orespawn:hover", 0.45f, 1.0f);
            this.playing = 55;
        }
        if (!this.field_70170_p.field_72995_K) {
            if (this.exploding > 0) {
                --this.exploding;
            }
            if (this.exploding == 0 && velocity > 0.65 && this.field_70170_p.field_73012_v.nextInt(20000) == 1) {
                this.exploding = 45;
                this.playing = 50;
            }
            this.setExploding(this.exploding);
        }
        else {
            this.exploding = this.getExploding();
        }
        if (this.getExploding() > 0 && this.field_70153_n != null) {
            if (this.field_70170_p.field_73012_v.nextInt(10) == 1) {
                this.field_70170_p.func_72956_a(this.field_70153_n, "random.explode", 0.55f, 0.75f + this.field_70170_p.field_73012_v.nextFloat());
            }
            for (int i = 0; i < 15; ++i) {
                this.field_70170_p.func_72869_a("explode", (double)(int)(this.field_70165_t + (this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat()) * 4.0f), (double)(int)(this.field_70163_u + (this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat()) * 4.0f), (double)(int)(this.field_70161_v + (this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat()) * 4.0f), this.field_70159_w, 0.0, this.field_70179_y);
                this.field_70170_p.func_72869_a("largeexplode", (double)(int)(this.field_70165_t + (this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat()) * 2.0f), (double)(int)(this.field_70163_u + (this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat()) * 2.0f), (double)(int)(this.field_70161_v + (this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat()) * 2.0f), this.field_70159_w, 0.0, this.field_70179_y);
                this.field_70170_p.func_72869_a("smoke", (double)(int)(this.field_70165_t + (this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat()) * 5.0f), (double)(int)(this.field_70163_u + (this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat()) * 5.0f), (double)(int)(this.field_70161_v + (this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat()) * 5.0f), this.field_70159_w, 0.0, this.field_70179_y);
                this.field_70170_p.func_72869_a("largesmoke", (double)(int)(this.field_70165_t + (this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat()) * 3.0f), (double)(int)(this.field_70163_u + (this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat()) * 3.0f), (double)(int)(this.field_70161_v + (this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat()) * 3.0f), this.field_70159_w, 0.0, this.field_70179_y);
            }
        }
        if (this.field_70170_p.field_72995_K) {
            if (this.field_70153_n == null) {
                final Block bid = this.field_70170_p.func_147439_a((int)this.field_70165_t, (int)((float)this.field_70163_u - (float)gh), (int)this.field_70161_v);
                if (bid != Blocks.field_150350_a) {
                    this.field_70181_x += 0.06;
                    this.field_70163_u += 0.07;
                    this.boatY += 0.07;
                }
                else {
                    this.field_70181_x -= 0.003;
                }
            }
            else if (this.field_70153_n instanceof EntityClientPlayerMP) {
                final EntityClientPlayerMP pp = (EntityClientPlayerMP)this.field_70153_n;
                pp.field_71174_a.func_147297_a((Packet)new C03PacketPlayer.C05PacketPlayerLook(pp.field_70177_z, pp.field_70125_A, pp.field_70122_E));
                pp.field_71174_a.func_147297_a((Packet)new C0CPacketInput(pp.field_70702_br, pp.field_70701_bs, pp.field_71158_b.field_78901_c, pp.field_71158_b.field_78899_d));
            }
            if (this.boatPosRotationIncrements > 0) {
                final double d8 = this.field_70165_t + (this.boatX - this.field_70165_t) / this.boatPosRotationIncrements;
                final double d9 = this.field_70163_u + (this.boatY - this.field_70163_u) / this.boatPosRotationIncrements;
                final double d12 = this.field_70161_v + (this.boatZ - this.field_70161_v) / this.boatPosRotationIncrements;
                this.func_70107_b(d8, d9, d12);
                this.field_70125_A += (float)((this.boatPitch - this.field_70125_A) / this.boatPosRotationIncrements);
                double d13 = MathHelper.func_76138_g(this.boatYaw - this.field_70177_z);
                if (this.field_70153_n != null) {
                    d13 = MathHelper.func_76138_g(this.field_70153_n.field_70177_z - (double)this.field_70177_z);
                }
                this.func_70101_b(this.field_70177_z += (float)(d13 / this.boatPosRotationIncrements), this.field_70125_A);
                --this.boatPosRotationIncrements;
            }
            else {
                final double d8 = this.field_70165_t + this.field_70159_w;
                final double d9 = this.field_70163_u + this.field_70181_x;
                final double d12 = this.field_70161_v + this.field_70179_y;
                this.func_70107_b(d8, d9, d12);
                this.field_70159_w *= 0.99;
                this.field_70181_x *= 0.95;
                this.field_70179_y *= 0.99;
            }
        }
        else {
            if (this.field_70153_n != null) {
                gh = 1.25;
            }
            Block bid = this.field_70170_p.func_147439_a((int)this.field_70165_t, (int)((float)this.field_70163_u - (float)gh), (int)this.field_70161_v);
            if (bid != Blocks.field_150350_a) {
                this.field_70181_x += 0.06;
                this.field_70163_u += 0.1;
                if (bid == Blocks.field_150329_H && this.field_70153_n != null && this.field_70170_p.field_73012_v.nextInt(200) == 1 && this.field_70170_p.func_82736_K().func_82766_b("mobGriefing")) {
                    this.field_70170_p.func_147449_b((int)this.field_70165_t, (int)(this.field_70163_u - gh), (int)this.field_70161_v, Blocks.field_150350_a);
                }
                if (bid == Blocks.field_150349_c && this.field_70153_n != null && this.field_70170_p.field_73012_v.nextInt(200) == 1 && this.field_70170_p.func_82736_K().func_82766_b("mobGriefing")) {
                    this.field_70170_p.func_147449_b((int)this.field_70165_t, (int)(this.field_70163_u - gh), (int)this.field_70161_v, Blocks.field_150346_d);
                }
            }
            else {
                this.field_70181_x -= 0.01;
            }
            if (this.field_70153_n != null) {
                final EntityPlayer pp2 = (EntityPlayer)this.field_70153_n;
                obstruction_factor = 0.0;
                dist = 3;
                dist += (int)(velocity * 8.0);
                for (int k = 1; k < dist; ++k) {
                    for (int i = 1; i < dist * 2; ++i) {
                        final double dx = i * Math.cos(Math.toRadians(this.field_70177_z + 90.0f));
                        final double dz = i * Math.sin(Math.toRadians(this.field_70177_z + 90.0f));
                        bid = this.field_70170_p.func_147439_a((int)(this.field_70165_t + dx), (int)this.field_70163_u - k, (int)(this.field_70161_v + dz));
                        if (bid != Blocks.field_150350_a) {
                            obstruction_factor += 0.05;
                        }
                    }
                }
                this.field_70181_x += obstruction_factor * 0.11;
                this.field_70163_u += obstruction_factor * 0.11;
                double d8;
                for (d8 = this.field_70153_n.field_70177_z, d8 %= 360.0; d8 < 0.0; d8 += 360.0) {}
                double d9;
                for (d9 = this.field_70177_z, d9 %= 360.0; d9 < 0.0; d9 += 360.0) {}
                for (relative_g = (d8 - d9) % 180.0; relative_g < 0.0; relative_g += 180.0) {}
                if (relative_g > 90.0) {
                    relative_g -= 180.0;
                }
                if (velocity > 0.01) {
                    d8 = 1.85 - velocity;
                    d8 = Math.abs(d8);
                    if (d8 < 0.01) {
                        d8 = 0.01;
                    }
                    if (d8 > 0.9) {
                        d8 = 0.9;
                    }
                    this.field_70177_z = this.field_70153_n.field_70177_z + (float)(relative_g * d8);
                }
                else {
                    this.field_70177_z = this.field_70153_n.field_70177_z;
                }
                relative_g = Math.abs(relative_g) * velocity;
                if (relative_g > 50.0) {
                    relative_g = 0.0;
                }
                this.field_70125_A = 10.0f * (float)velocity;
                this.func_70101_b(this.field_70177_z, this.field_70125_A);
                double newvelocity = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
                if (this.exploding != 0) {
                    newvelocity -= 0.05;
                    if (newvelocity < 0.0) {
                        newvelocity = 0.0;
                    }
                }
                final double rr = Math.atan2(this.field_70153_n.field_70179_y, this.field_70153_n.field_70159_w);
                final double rhm = Math.atan2(this.field_70179_y, this.field_70159_w);
                final double rhdir = Math.toRadians((this.field_70153_n.field_70177_z + 90.0f) % 360.0f);
                final double rt = 0.0;
                final double pi = 3.1415926545;
                double deltav = 0.0;
                final float im = pp2.field_70701_bs;
                if (OreSpawnMain.flyup_keystate != 0) {
                    ++max_speed;
                }
                double rdv = Math.abs(rhm - rhdir) % (pi * 2.0);
                if (rdv > pi) {
                    rdv -= pi * 2.0;
                }
                rdv = Math.abs(rdv);
                if (Math.abs(newvelocity) < 0.01) {
                    rdv = 0.0;
                }
                if (rdv > 1.5) {
                    newvelocity = -newvelocity;
                }
                if (Math.abs(im) > 0.001f) {
                    if (im > 0.0f) {
                        deltav = 0.025;
                        if (max_speed > 1.0) {
                            deltav += 0.15;
                        }
                    }
                    else {
                        max_speed = 0.35;
                        deltav = -0.02;
                    }
                    newvelocity += deltav;
                    if (newvelocity >= 0.0) {
                        if (newvelocity > max_speed) {
                            newvelocity = max_speed;
                        }
                        this.field_70159_w = Math.cos(Math.toRadians(this.field_70177_z + 90.0f)) * newvelocity;
                        this.field_70179_y = Math.sin(Math.toRadians(this.field_70177_z + 90.0f)) * newvelocity;
                    }
                    else {
                        if (newvelocity < -max_speed) {
                            newvelocity = -max_speed;
                        }
                        newvelocity = -newvelocity;
                        this.field_70159_w = Math.cos(Math.toRadians(this.field_70177_z + 270.0f)) * newvelocity;
                        this.field_70179_y = Math.sin(Math.toRadians(this.field_70177_z + 270.0f)) * newvelocity;
                    }
                }
                else if (newvelocity >= 0.0) {
                    this.field_70159_w = Math.cos(Math.toRadians(this.field_70177_z + 90.0f)) * newvelocity;
                    this.field_70179_y = Math.sin(Math.toRadians(this.field_70177_z + 90.0f)) * newvelocity;
                }
                else {
                    this.field_70159_w = Math.cos(Math.toRadians(this.field_70177_z + 270.0f)) * (newvelocity * -1.0);
                    this.field_70179_y = Math.sin(Math.toRadians(this.field_70177_z + 270.0f)) * (newvelocity * -1.0);
                }
            }
            else if (this.field_70153_n == null) {
                this.field_70159_w = 0.0;
                this.field_70179_y = 0.0;
            }
            this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
            if (this.field_70123_F && velocity > 0.75) {
                this.func_70106_y();
                for (int p = this.field_70170_p.field_73012_v.nextInt(10), k = 0; k < 6 + p; ++k) {
                    this.func_145779_a(Items.field_151055_y, 1);
                }
                for (int k = 0; k < 2; ++k) {
                    this.func_145779_a(Items.field_151045_i, 1);
                }
            }
            else {
                this.field_70159_w *= 0.98;
                this.field_70181_x *= 0.94;
                this.field_70179_y *= 0.98;
            }
            list = this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D.func_72314_b(0.25, 0.0, 0.25));
            if (list != null && !list.isEmpty()) {
                for (int l = 0; l < list.size(); ++l) {
                    final Entity entity = list.get(l);
                    if (entity != this.field_70153_n && entity.func_70104_M() && !(entity instanceof Girlfriend) && !(entity instanceof Boyfriend)) {
                        entity.func_70108_f((Entity)this);
                    }
                }
            }
            if (this.field_70153_n != null && this.field_70153_n.field_70128_L) {
                this.field_70153_n = null;
            }
        }
    }
    
    public void func_70043_V() {
        if (this.field_70153_n != null) {
            this.field_70153_n.func_70107_b(this.field_70165_t, this.field_70163_u + this.func_70042_X() + this.field_70153_n.func_70033_W(), this.field_70161_v);
        }
    }
    
    public void func_70014_b(final NBTTagCompound par1NBTTagCompound) {
        par1NBTTagCompound.func_74768_a("HoverColor", this.getColor());
    }
    
    public void func_70037_a(final NBTTagCompound par1NBTTagCompound) {
        this.color = par1NBTTagCompound.func_74762_e("HoverColor");
        if (this.color < 1) {
            this.color = 1;
        }
        if (this.color > 10) {
            this.color = 10;
        }
        this.setColor(this.color);
    }
    
    public float func_70053_R() {
        return 0.25f;
    }
    
    public boolean func_70085_c(final EntityPlayer par1EntityPlayer) {
        ItemStack var2 = par1EntityPlayer.field_71071_by.func_70448_g();
        if (var2 != null && var2.field_77994_a <= 0) {
            par1EntityPlayer.field_71071_by.func_70299_a(par1EntityPlayer.field_71071_by.field_70461_c, (ItemStack)null);
            var2 = null;
        }
        if (var2 != null && var2.func_77973_b() == OreSpawnMain.MyUltimateSword && par1EntityPlayer.func_70068_e((Entity)this) < 16.0) {
            if (!this.field_70170_p.field_72995_K) {
                ++this.color;
                if (this.color > 10) {
                    this.color = 1;
                }
                this.setColor(this.color);
            }
            return true;
        }
        if (this.field_70153_n != null && this.field_70153_n instanceof EntityPlayer && this.field_70153_n != par1EntityPlayer) {
            return true;
        }
        if (!this.field_70170_p.field_72995_K) {
            par1EntityPlayer.func_70078_a((Entity)this);
        }
        return true;
    }
    
    public void setDamageTaken(final float f) {
        this.field_70180_af.func_75692_b(24, (Object)f);
    }
    
    public float getDamageTaken() {
        return this.field_70180_af.func_111145_d(24);
    }
    
    public void setTimeSinceHit(final int par1) {
        this.field_70180_af.func_75692_b(22, (Object)par1);
    }
    
    public int getTimeSinceHit() {
        return this.field_70180_af.func_75679_c(22);
    }
    
    public void setForwardDirection(final int par1) {
        this.field_70180_af.func_75692_b(23, (Object)par1);
    }
    
    public int getForwardDirection() {
        return this.field_70180_af.func_75679_c(23);
    }
    
    public void setExploding(final int par1) {
        this.field_70180_af.func_75692_b(20, (Object)par1);
    }
    
    public int getExploding() {
        return this.field_70180_af.func_75679_c(20);
    }
    
    public void setColor(final int par1) {
        this.field_70180_af.func_75692_b(21, (Object)par1);
    }
    
    public int getColor() {
        return this.field_70180_af.func_75679_c(21);
    }
    
    static {
        texture1 = new ResourceLocation("orespawn", "Elevator1.png");
        texture2 = new ResourceLocation("orespawn", "Elevator2.png");
        texture3 = new ResourceLocation("orespawn", "Elevator3.png");
        texture4 = new ResourceLocation("orespawn", "Elevator4.png");
        texture5 = new ResourceLocation("orespawn", "Elevator5.png");
        texture6 = new ResourceLocation("orespawn", "Elevator6.png");
        texture7 = new ResourceLocation("orespawn", "Elevator7.png");
        texture8 = new ResourceLocation("orespawn", "Elevator8.png");
        texture9 = new ResourceLocation("orespawn", "Elevator9.png");
        texture10 = new ResourceLocation("orespawn", "Elevator10.png");
    }
}

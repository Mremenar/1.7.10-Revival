// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.item.Item;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.EntityCreature;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.entity.Entity;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.entity.passive.EntityAnimal;

public class Island extends EntityAnimal
{
    private float dir;
    private float speed;
    private int radius;
    private int depth;
    private int timer;
    private int just_spawned;
    private int ticker;
    private int once;
    private double myX;
    private double myY;
    private double myZ;
    private int dirchange;
    
    public Island(final World par1World) {
        super(par1World);
        this.dir = 0.0f;
        this.speed = 0.1f;
        this.radius = 5;
        this.depth = 3;
        this.timer = 73;
        this.just_spawned = 1;
        this.ticker = 0;
        this.once = 1;
        this.func_70105_a(0.5f, 0.5f);
        this.ticker = par1World.field_73012_v.nextInt(50);
        this.dirchange = this.field_70170_p.field_73012_v.nextInt(2500);
    }
    
    public void func_70071_h_() {
        super.func_70071_h_();
        final double field_70159_w = 0.0;
        this.field_70179_y = field_70159_w;
        this.field_70181_x = field_70159_w;
        this.field_70159_w = field_70159_w;
        if (this.field_70170_p.field_72995_K) {
            return;
        }
        if (this.once != 0) {
            this.myX = this.field_70165_t;
            this.myY = this.field_70163_u;
            this.myZ = this.field_70161_v;
            this.once = 0;
        }
        if (this.just_spawned != 0) {
            this.dir = this.field_70170_p.field_73012_v.nextFloat() * 3.1415927f;
            if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                this.dir *= -1.0f;
            }
            if (this.field_70170_p.field_73012_v.nextInt(40) != 1) {
                this.radius = 3 + this.field_70170_p.field_73012_v.nextInt(4);
                this.depth = 2 + this.field_70170_p.field_73012_v.nextInt(3);
                this.speed = this.field_70170_p.field_73012_v.nextFloat() / 50.0f * OreSpawnMain.IslandSpeedFactor;
            }
            else {
                this.radius = 6 + this.field_70170_p.field_73012_v.nextInt(5);
                this.depth = 3 + this.field_70170_p.field_73012_v.nextInt(4);
                this.speed = this.field_70170_p.field_73012_v.nextFloat() / 200.0f * OreSpawnMain.IslandSpeedFactor;
            }
            this.create_island();
            this.ticker = this.field_70170_p.field_73012_v.nextInt(50);
            this.dirchange = this.field_70170_p.field_73012_v.nextInt(10000);
        }
        ++this.ticker;
        if (this.ticker >= this.timer) {
            this.update_island();
            this.ticker = 0;
        }
        --this.dirchange;
        if (this.dirchange <= 0) {
            this.dirchange = this.field_70170_p.field_73012_v.nextInt(5000);
            this.dir = this.field_70170_p.field_73012_v.nextFloat() * 3.1415927f;
            if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                this.dir *= -1.0f;
            }
        }
        this.just_spawned = 0;
    }
    
    public void func_70636_d() {
        if (this.field_70170_p.field_72995_K) {
            super.func_70636_d();
        }
    }
    
    protected void func_70629_bd() {
    }
    
    protected void func_70619_bc() {
    }
    
    protected void func_70069_a(final float par1) {
    }
    
    protected boolean func_70692_ba() {
        return false;
    }
    
    public void func_70037_a(final NBTTagCompound par1NBTTagCompound) {
        super.func_70037_a(par1NBTTagCompound);
        this.just_spawned = par1NBTTagCompound.func_74762_e("JustSpawned");
        this.depth = par1NBTTagCompound.func_74762_e("Idepth");
        this.radius = par1NBTTagCompound.func_74762_e("Iradius");
        this.speed = par1NBTTagCompound.func_74760_g("Ispeed");
        this.dir = par1NBTTagCompound.func_74760_g("Idir");
    }
    
    public void func_70014_b(final NBTTagCompound par1NBTTagCompound) {
        super.func_70014_b(par1NBTTagCompound);
        par1NBTTagCompound.func_74768_a("JustSpawned", this.just_spawned);
        par1NBTTagCompound.func_74768_a("Idepth", this.depth);
        par1NBTTagCompound.func_74768_a("Iradius", this.radius);
        par1NBTTagCompound.func_74776_a("Ispeed", this.speed);
        par1NBTTagCompound.func_74776_a("Idir", this.dir);
    }
    
    public EntityAgeable func_90011_a(final EntityAgeable entityageable) {
        return null;
    }
    
    private void create_island() {
        final double deltadir = 0.10471975333333333;
        final double deltamag = 0.3499999940395355;
        int ixlast = 0;
        int izlast = 0;
        int xoff = 0;
        int zoff = 0;
        for (int i = 0; i < this.depth; ++i) {
            izlast = (ixlast = 0);
            for (double curdir = -3.1415926; curdir < 3.1415926; curdir += deltadir) {
                double tradius = this.radius;
                tradius /= i + 1;
                for (double h = 0.75; h < tradius; h += deltamag) {
                    final int ix = (int)(this.field_70165_t + Math.cos(curdir + this.dir) * h);
                    final int iz = (int)(this.field_70161_v + Math.sin(curdir + this.dir) * h);
                    if (ix != ixlast || iz != izlast) {
                        ixlast = ix;
                        izlast = iz;
                        if (i == 0) {
                            final Block bid;
                            if ((bid = this.field_70170_p.func_147439_a(ix, (int)this.field_70163_u - i + 1, iz)) == Blocks.field_150350_a) {
                                if (this.field_70170_p.field_73012_v.nextInt(5000) == 1) {
                                    this.field_70170_p.func_147449_b(ix, (int)this.field_70163_u - i + 1, iz, Blocks.field_150353_l);
                                }
                                else {
                                    this.FastSetBlock(ix, (int)this.field_70163_u - i + 1, iz, (Block)Blocks.field_150391_bh);
                                    if (this.field_70170_p.field_73012_v.nextInt(20) == 1 && this.field_70170_p.func_147439_a(ix, (int)this.field_70163_u - i + 2, iz) == Blocks.field_150350_a) {
                                        if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                                            this.field_70170_p.func_147449_b(ix, (int)this.field_70163_u - i + 2, iz, (Block)Blocks.field_150338_P);
                                        }
                                        else {
                                            this.field_70170_p.func_147449_b(ix, (int)this.field_70163_u - i + 2, iz, (Block)Blocks.field_150337_Q);
                                        }
                                    }
                                }
                            }
                            else if (bid == Blocks.field_150357_h) {
                                this.func_70106_y();
                                return;
                            }
                        }
                        else if (this.field_70170_p.field_73012_v.nextInt(10) == 1) {
                            this.FastSetBlock(ix, (int)this.field_70163_u - i + 1, iz, Blocks.field_150482_ag);
                        }
                        else {
                            this.FastSetBlock(ix, (int)this.field_70163_u - i + 1, iz, Blocks.field_150377_bs);
                        }
                    }
                }
            }
        }
        if (this.field_70165_t < 0.0) {
            xoff = -1;
        }
        if (this.field_70161_v < 0.0) {
            zoff = -1;
        }
        this.field_70170_p.func_147449_b((int)this.field_70165_t + xoff, (int)this.field_70163_u, (int)this.field_70161_v + zoff, Blocks.field_150350_a);
        this.FastSetBlock((int)this.field_70165_t + xoff, (int)this.field_70163_u, (int)this.field_70161_v + zoff, Blocks.field_150350_a);
    }
    
    private void update_island() {
        final double deltadir = 0.10471975333333333;
        final double deltamag = 0.3499999940395355;
        final double pi2 = 1.57079632675;
        int ixlast = 0;
        int izlast = 0;
        int xoff = 0;
        int zoff = 0;
        this.myX += this.speed * Math.cos(this.dir);
        this.myZ += this.speed * Math.sin(this.dir);
        final int mx = (int)this.myX;
        final int mz = (int)this.myZ;
        final int px = (int)this.field_70165_t;
        final int pz = (int)this.field_70161_v;
        if (mx != px || mz != pz) {
            for (int i = 0; i < this.depth; ++i) {
                izlast = (ixlast = 0);
                for (double curdir = -3.3; curdir < 3.3; curdir += deltadir / 2.0) {
                    double tradius;
                    double h;
                    for (tradius = this.radius, tradius /= i + 1, h = 0.75; h < tradius; h += deltamag) {}
                    h -= deltamag;
                    if (h < 0.75) {
                        h = 0.75;
                    }
                    while (h < tradius + deltamag) {
                        final int ix = (int)(this.field_70165_t + Math.cos(curdir + this.dir) * h);
                        final int iz = (int)(this.field_70161_v + Math.sin(curdir + this.dir) * h);
                        if (ix != ixlast || iz != izlast) {
                            ixlast = ix;
                            izlast = iz;
                            if (i == 0) {
                                final Block bid = this.field_70170_p.func_147439_a(ix, (int)this.field_70163_u + 1 + 1, iz);
                                if (bid == Blocks.field_150337_Q || bid == Blocks.field_150338_P) {
                                    this.FastSetBlock(ix, (int)this.field_70163_u + 1 + 1, iz, Blocks.field_150350_a);
                                }
                            }
                            this.FastSetBlock(ix, (int)this.field_70163_u - i + 1, iz, Blocks.field_150350_a);
                        }
                        h += deltamag / 2.0;
                    }
                }
            }
            if (this.field_70165_t < 0.0) {
                xoff = -1;
            }
            if (this.field_70161_v < 0.0) {
                zoff = -1;
            }
            this.field_70170_p.func_147449_b((int)this.field_70165_t + xoff, (int)this.field_70163_u, (int)this.field_70161_v + zoff, Blocks.field_150377_bs);
            this.field_70165_t = (int)this.myX;
            if (this.myX < 0.0) {
                this.field_70165_t -= 0.5;
            }
            else {
                this.field_70165_t += 0.5;
            }
            this.field_70161_v = (int)this.myZ;
            if (this.myZ < 0.0) {
                this.field_70161_v -= 0.5;
            }
            else {
                this.field_70161_v += 0.5;
            }
            for (int i = 0; i < this.depth; ++i) {
                izlast = (ixlast = 0);
                for (double curdir = -3.1415926; curdir < 3.1415926; curdir += deltadir) {
                    double tradius;
                    double h;
                    for (tradius = this.radius, tradius /= i + 1, h = 0.75; h < tradius; h += deltamag) {}
                    h -= deltamag * 3.0;
                    if (h < 0.75) {
                        h = 0.75;
                    }
                    while (h < tradius) {
                        final int ix = (int)(this.field_70165_t + Math.cos(curdir + this.dir) * h);
                        final int iz = (int)(this.field_70161_v + Math.sin(curdir + this.dir) * h);
                        if (ix != ixlast || iz != izlast) {
                            ixlast = ix;
                            izlast = iz;
                            if (i == 0) {
                                final Block bid;
                                if ((bid = this.field_70170_p.func_147439_a(ix, (int)this.field_70163_u - i + 1, iz)) == Blocks.field_150350_a) {
                                    if (this.field_70170_p.field_73012_v.nextInt(5000) == 1) {
                                        this.field_70170_p.func_147449_b(ix, (int)this.field_70163_u - i + 1, iz, Blocks.field_150353_l);
                                    }
                                    else {
                                        this.FastSetBlock(ix, (int)this.field_70163_u - i + 1, iz, (Block)Blocks.field_150391_bh);
                                        if (this.field_70170_p.field_73012_v.nextInt(20) == 1 && this.field_70170_p.func_147439_a(ix, (int)this.field_70163_u - i + 2, iz) == Blocks.field_150350_a) {
                                            if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                                                this.field_70170_p.func_147449_b(ix, (int)this.field_70163_u - i + 2, iz, (Block)Blocks.field_150338_P);
                                            }
                                            else {
                                                this.field_70170_p.func_147449_b(ix, (int)this.field_70163_u - i + 2, iz, (Block)Blocks.field_150337_Q);
                                            }
                                        }
                                    }
                                }
                                else if (bid == Blocks.field_150357_h) {
                                    this.func_70106_y();
                                    return;
                                }
                            }
                            else {
                                final Block bid = this.field_70170_p.func_147439_a(ix, (int)this.field_70163_u - i + 1, iz);
                                if (bid == Blocks.field_150348_b) {
                                    if (!this.field_70170_p.field_72995_K) {
                                        this.field_70170_p.func_72876_a((Entity)this, (double)ix, this.field_70163_u - i + 1.0, (double)iz, 5.0f, true);
                                    }
                                }
                                else if (this.field_70170_p.field_73012_v.nextInt(10) == 1) {
                                    this.FastSetBlock(ix, (int)this.field_70163_u - i + 1, iz, Blocks.field_150482_ag);
                                }
                                else {
                                    this.FastSetBlock(ix, (int)this.field_70163_u - i + 1, iz, Blocks.field_150377_bs);
                                }
                            }
                        }
                        h += deltamag;
                    }
                }
            }
            xoff = 0;
            if (this.field_70165_t < 0.0) {
                xoff = -1;
            }
            zoff = 0;
            if (this.field_70161_v < 0.0) {
                zoff = -1;
            }
            this.field_70170_p.func_147449_b((int)this.field_70165_t + xoff, (int)this.field_70163_u, (int)this.field_70161_v + zoff, Blocks.field_150350_a);
            this.FastSetBlock((int)this.field_70165_t + xoff, (int)this.field_70163_u, (int)this.field_70161_v + zoff, Blocks.field_150350_a);
        }
        if (this.field_70170_p.field_73012_v.nextInt(2 + 2000 / this.timer) == 1) {
            final AxisAlignedBB bb = AxisAlignedBB.func_72330_a(this.field_70165_t - 10.0, this.field_70163_u - 5.0, this.field_70161_v - 10.0, this.field_70165_t + 10.0, this.field_70163_u + 5.0, this.field_70161_v + 10.0);
            final List var5 = this.field_70170_p.func_72872_a((Class)Triffid.class, bb);
            final Iterator var6 = var5.iterator();
            if (!var6.hasNext()) {
                final EntityCreature newent = (EntityCreature)spawnCreature(this.field_70170_p, "Triffid", this.field_70165_t, this.field_70163_u + 2.01, this.field_70161_v);
            }
        }
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
    
    protected Item func_146068_u() {
        return Item.func_150898_a(OreSpawnMain.MyIslandBlock);
    }
    
    public void FastSetBlock(final int ix, final int iy, final int iz, final Block id) {
        OreSpawnMain.setBlockFast(this.field_70170_p, ix, iy, iz, id, 0, 3);
    }
}

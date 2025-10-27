// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.item.Item;
import net.minecraft.entity.Entity;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.entity.passive.EntityAnimal;

public class IslandToo extends EntityAnimal
{
    private int dir;
    private float speed;
    private int width;
    private int depth;
    private int length;
    private int timer;
    private int just_spawned;
    private int ticker;
    private int once;
    private double myX;
    private double myY;
    private double myZ;
    private int dirchange;
    private int blocktype;
    
    public IslandToo(final World par1World) {
        super(par1World);
        this.dir = 0;
        this.speed = 0.1f;
        this.width = 5;
        this.depth = 3;
        this.length = 10;
        this.timer = 42;
        this.just_spawned = 1;
        this.ticker = 0;
        this.once = 1;
        this.dirchange = 0;
        this.blocktype = 0;
        this.func_70105_a(0.5f, 0.5f);
        this.ticker = par1World.field_73012_v.nextInt(50);
        this.dirchange = this.field_70170_p.field_73012_v.nextInt(5000);
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
            this.dir = this.field_70170_p.field_73012_v.nextInt(4);
            if (this.field_70170_p.field_73012_v.nextInt(40) != 1) {
                this.width = 1 + this.field_70170_p.field_73012_v.nextInt(5 * OreSpawnMain.IslandSizeFactor);
                this.length = this.width;
                this.depth = 1 + this.field_70170_p.field_73012_v.nextInt(4);
                this.speed = this.field_70170_p.field_73012_v.nextFloat() / 40.0f * OreSpawnMain.IslandSpeedFactor;
                if (this.length * this.width * this.depth <= 64) {
                    this.speed *= 2.0f;
                }
                if (this.length * this.width * this.depth <= 32) {
                    this.speed *= 2.0f;
                }
            }
            else {
                this.width = 5 + this.field_70170_p.field_73012_v.nextInt(8 * OreSpawnMain.IslandSizeFactor);
                this.length = this.width;
                this.depth = 3 + this.field_70170_p.field_73012_v.nextInt(6);
                this.speed = this.field_70170_p.field_73012_v.nextFloat() / 150.0f * OreSpawnMain.IslandSpeedFactor;
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
            this.dir = this.field_70170_p.field_73012_v.nextInt(4);
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
        this.width = par1NBTTagCompound.func_74762_e("Iwidth");
        this.depth = par1NBTTagCompound.func_74762_e("Idepth");
        this.length = par1NBTTagCompound.func_74762_e("Ilength");
        this.speed = par1NBTTagCompound.func_74760_g("Ispeed");
        this.dir = par1NBTTagCompound.func_74762_e("Idir");
        this.blocktype = par1NBTTagCompound.func_74762_e("Iblocktype");
    }
    
    public void func_70014_b(final NBTTagCompound par1NBTTagCompound) {
        super.func_70014_b(par1NBTTagCompound);
        par1NBTTagCompound.func_74768_a("JustSpawned", this.just_spawned);
        par1NBTTagCompound.func_74768_a("Iwidth", this.width);
        par1NBTTagCompound.func_74768_a("Idepth", this.depth);
        par1NBTTagCompound.func_74768_a("Ilength", this.length);
        par1NBTTagCompound.func_74776_a("Ispeed", this.speed);
        par1NBTTagCompound.func_74768_a("Idir", this.dir);
        par1NBTTagCompound.func_74768_a("Iblocktype", this.blocktype);
    }
    
    public EntityAgeable func_90011_a(final EntityAgeable entityageable) {
        return null;
    }
    
    public boolean func_70097_a(final DamageSource par1DamageSource, final float par2) {
        final boolean ret = false;
        int xoff = 0;
        int zoff = 0;
        final int ix = (int)this.field_70165_t;
        final int iz = (int)this.field_70161_v;
        if (ix < 0) {
            xoff = 1;
            this.field_70165_t = ix;
            this.field_70165_t -= 0.5;
        }
        else {
            this.field_70165_t = ix;
            this.field_70165_t += 0.5;
        }
        if (iz < 0) {
            zoff = 1;
            this.field_70161_v = iz;
            this.field_70161_v -= 0.5;
        }
        else {
            this.field_70161_v = iz;
            this.field_70161_v += 0.5;
        }
        super.func_70097_a(par1DamageSource, par2);
        return ret;
    }
    
    private void create_island() {
        int xoff = 0;
        int zoff = 0;
        if (this.field_70165_t < 0.0) {
            xoff = 1;
        }
        if (this.field_70161_v < 0.0) {
            zoff = 1;
        }
        for (int k = 0; k <= this.depth; ++k) {
            int il = this.length / (this.depth - k + 1);
            if (il < 1) {
                il = 1;
            }
            for (int i = -il; i <= il; ++i) {
                for (int j = -il; j <= il; ++j) {
                    final int ix = (int)this.field_70165_t + j - xoff;
                    final int iz = (int)this.field_70161_v + i - zoff;
                    if (k == this.depth) {
                        final Block bid;
                        if ((bid = this.field_70170_p.func_147439_a(ix, (int)this.field_70163_u + k, iz)) == Blocks.field_150350_a) {
                            if (this.field_70170_p.field_73012_v.nextInt(5000) == 1) {
                                this.field_70170_p.func_147449_b(ix, (int)this.field_70163_u + k, iz, Blocks.field_150355_j);
                            }
                            else {
                                this.FastSetBlock(ix, (int)this.field_70163_u + k, iz, (Block)Blocks.field_150349_c);
                                if (this.field_70170_p.field_73012_v.nextInt(30) == 1) {
                                    if (this.field_70170_p.func_147439_a(ix, (int)this.field_70163_u + k + 1, iz) == Blocks.field_150350_a) {
                                        if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                                            this.field_70170_p.func_147449_b(ix, (int)this.field_70163_u + k + 1, iz, OreSpawnMain.MyFlowerPinkBlock);
                                        }
                                        else {
                                            this.field_70170_p.func_147449_b(ix, (int)this.field_70163_u + k + 1, iz, OreSpawnMain.MyFlowerBlueBlock);
                                        }
                                    }
                                }
                                else if (this.field_70170_p.field_73012_v.nextInt(100) == 1 && this.field_70170_p.func_147439_a(ix, (int)this.field_70163_u + k + 1, iz) == Blocks.field_150350_a) {
                                    OreSpawnMain.OreSpawnTrees.SmallTree(this.field_70170_p, ix, (int)this.field_70163_u + k + 1, iz);
                                }
                            }
                        }
                        else if (bid == Blocks.field_150357_h) {
                            this.func_70106_y();
                            return;
                        }
                    }
                    else {
                        this.mySetBlock(ix, (int)this.field_70163_u + k, iz);
                    }
                }
            }
        }
        this.field_70170_p.func_147449_b((int)this.field_70165_t - xoff, (int)this.field_70163_u, (int)this.field_70161_v - zoff, Blocks.field_150350_a);
    }
    
    private void mySetBlock(final int ix, final int iy, final int iz) {
        Block bid = Blocks.field_150348_b;
        if (this.blocktype == 0) {
            this.blocktype = 1 + this.field_70170_p.field_73012_v.nextInt(8);
        }
        if (this.blocktype == 1 && this.field_70170_p.field_73012_v.nextInt(5) == 1) {
            bid = Blocks.field_150365_q;
        }
        if (this.blocktype == 2 && this.field_70170_p.field_73012_v.nextInt(10) == 1) {
            bid = Blocks.field_150366_p;
        }
        if (this.blocktype == 3 && this.field_70170_p.field_73012_v.nextInt(20) == 1) {
            bid = Blocks.field_150412_bA;
        }
        if (this.blocktype == 4 && this.field_70170_p.field_73012_v.nextInt(30) == 1) {
            bid = OreSpawnMain.MyOreTitaniumBlock;
        }
        if (this.blocktype == 5 && this.field_70170_p.field_73012_v.nextInt(30) == 1) {
            bid = OreSpawnMain.MyOreUraniumBlock;
        }
        if (this.blocktype == 6 && this.field_70170_p.field_73012_v.nextInt(30) == 1) {
            bid = OreSpawnMain.MyOreRubyBlock;
        }
        if (this.blocktype == 7 && this.field_70170_p.field_73012_v.nextInt(30) == 1) {
            bid = OreSpawnMain.MyOreAmethystBlock;
        }
        if (this.blocktype == 8 && this.field_70170_p.field_73012_v.nextInt(20) == 1) {
            bid = Blocks.field_150352_o;
        }
        if (bid == Blocks.field_150348_b) {
            if (this.field_70170_p.field_73012_v.nextInt(3000) == 1) {
                bid = OreSpawnMain.MyEnderPearlBlock;
            }
            if (this.field_70170_p.field_73012_v.nextInt(3000) == 2) {
                bid = OreSpawnMain.MyEyeOfEnderBlock;
            }
            if (this.field_70170_p.field_73012_v.nextInt(3000) == 3) {
                bid = OreSpawnMain.MyBlockAmethystBlock;
            }
            if (this.field_70170_p.field_73012_v.nextInt(3000) == 4) {
                bid = OreSpawnMain.MyBlockRubyBlock;
            }
            if (this.field_70170_p.field_73012_v.nextInt(3000) == 5) {
                bid = OreSpawnMain.MyBlockUraniumBlock;
            }
            if (this.field_70170_p.field_73012_v.nextInt(3000) == 6) {
                bid = OreSpawnMain.MyBlockTitaniumBlock;
            }
            if (this.field_70170_p.field_73012_v.nextInt(3000) == 7) {
                bid = Blocks.field_150340_R;
            }
            if (this.field_70170_p.field_73012_v.nextInt(3000) == 8) {
                bid = Blocks.field_150484_ah;
            }
        }
        this.FastSetBlock(ix, iy, iz, bid);
    }
    
    private void update_island() {
        int xoff = 0;
        int zoff = 0;
        if (this.dir == 0) {
            this.myZ -= this.speed;
        }
        else if (this.dir == 1) {
            this.myZ += this.speed;
        }
        else if (this.dir == 2) {
            this.myX += this.speed;
        }
        else {
            this.myX -= this.speed;
        }
        int ke;
        int ks;
        int js;
        int je = js = (ks = (ke = 0));
        final int mx = (int)this.myX;
        final int mz = (int)this.myZ;
        final int px = (int)this.field_70165_t;
        final int pz = (int)this.field_70161_v;
        if (mx != px || mz != pz) {
            if (this.dir == 0) {
                js = 1;
                je = 1;
                ks = -1;
                ke = 1;
            }
            else if (this.dir == 1) {
                js = -1;
                je = -1;
                ks = -1;
                ke = 1;
            }
            else if (this.dir == 2) {
                js = -1;
                je = 1;
                ks = -1;
                ke = -1;
            }
            else {
                js = -1;
                je = 1;
                ks = 1;
                ke = 1;
            }
            if (this.field_70165_t < 0.0) {
                xoff = 1;
            }
            if (this.field_70161_v < 0.0) {
                zoff = 1;
            }
            for (int i = 0; i <= this.depth; ++i) {
                int il = this.length / (this.depth - i + 1);
                if (il < 1) {
                    il = 1;
                }
                for (int j = js * il; j <= je * il; ++j) {
                    for (int k = ks * il; k <= ke * il; ++k) {
                        final int ix = (int)this.field_70165_t + k - xoff;
                        final int iz = (int)this.field_70161_v + j - zoff;
                        if (i == this.depth) {
                            Block bid = this.field_70170_p.func_147439_a(ix, (int)this.field_70163_u + i + 1, iz);
                            if (bid == OreSpawnMain.MyFlowerPinkBlock || bid == OreSpawnMain.MyFlowerBlueBlock || bid == OreSpawnMain.MyFlowerBlackBlock || bid == OreSpawnMain.MyFlowerScaryBlock) {
                                this.FastSetBlock(ix, (int)this.field_70163_u + i + 1, iz, Blocks.field_150350_a);
                            }
                            if (bid == Blocks.field_150355_j || bid == Blocks.field_150358_i) {
                                this.field_70170_p.func_147449_b(ix, (int)this.field_70163_u + i, iz, Blocks.field_150350_a);
                            }
                            if (bid == OreSpawnMain.MySkyTreeLog) {
                                this.field_70170_p.func_147449_b(ix, (int)this.field_70163_u + i + 1, iz, Blocks.field_150350_a);
                                bid = this.field_70170_p.func_147439_a(ix, (int)this.field_70163_u + i + 2, iz);
                                if (bid == OreSpawnMain.MySkyTreeLog) {
                                    this.field_70170_p.func_147449_b(ix, (int)this.field_70163_u + i + 2, iz, Blocks.field_150350_a);
                                    bid = this.field_70170_p.func_147439_a(ix, (int)this.field_70163_u + i + 3, iz);
                                    if (bid == OreSpawnMain.MySkyTreeLog) {
                                        this.field_70170_p.func_147449_b(ix, (int)this.field_70163_u + i + 3, iz, Blocks.field_150350_a);
                                    }
                                }
                            }
                            bid = this.field_70170_p.func_147439_a(ix, (int)this.field_70163_u + i, iz);
                            if (bid == Blocks.field_150355_j || bid == Blocks.field_150358_i) {
                                this.field_70170_p.func_147449_b(ix, (int)this.field_70163_u + i, iz, Blocks.field_150350_a);
                            }
                        }
                        this.FastSetBlock(ix, (int)this.field_70163_u + i, iz, Blocks.field_150350_a);
                    }
                }
            }
            this.mySetBlock((int)this.field_70165_t - xoff, (int)this.field_70163_u, (int)this.field_70161_v - zoff);
            this.field_70165_t = mx;
            if (this.myX < 0.0) {
                this.field_70165_t -= 0.5;
            }
            else {
                this.field_70165_t += 0.5;
            }
            this.field_70161_v = mz;
            if (this.myZ < 0.0) {
                this.field_70161_v -= 0.5;
            }
            else {
                this.field_70161_v += 0.5;
            }
            if (this.dir == 0) {
                js = -1;
                je = -1;
                ks = -1;
                ke = 1;
            }
            else if (this.dir == 1) {
                js = 1;
                je = 1;
                ks = -1;
                ke = 1;
            }
            else if (this.dir == 2) {
                js = -1;
                je = 1;
                ks = 1;
                ke = 1;
            }
            else {
                js = -1;
                je = 1;
                ks = -1;
                ke = -1;
            }
            zoff = (xoff = 0);
            if (this.field_70165_t < 0.0) {
                xoff = 1;
            }
            if (this.field_70161_v < 0.0) {
                zoff = 1;
            }
            this.field_70170_p.func_147449_b((int)this.field_70165_t - xoff, (int)this.field_70163_u, (int)this.field_70161_v - zoff, Blocks.field_150350_a);
            for (int i = 0; i <= this.depth; ++i) {
                int il = this.length / (this.depth - i + 1);
                if (il < 1) {
                    il = 1;
                }
                for (int j = js * il; j <= je * il; ++j) {
                    for (int k = ks * il; k <= ke * il; ++k) {
                        final int ix = (int)this.field_70165_t + k - xoff;
                        final int iz = (int)this.field_70161_v + j - zoff;
                        if (i == this.depth) {
                            final Block bid;
                            if ((bid = this.field_70170_p.func_147439_a(ix, (int)this.field_70163_u + i, iz)) == Blocks.field_150350_a) {
                                if (this.field_70170_p.field_73012_v.nextInt(5000) == 1) {
                                    this.field_70170_p.func_147449_b(ix, (int)this.field_70163_u + i, iz, Blocks.field_150355_j);
                                }
                                else {
                                    this.FastSetBlock(ix, (int)this.field_70163_u + i, iz, (Block)Blocks.field_150349_c);
                                    if (this.field_70170_p.field_73012_v.nextInt(30) == 1) {
                                        if (this.field_70170_p.func_147439_a(ix, (int)this.field_70163_u + i + 1, iz) == Blocks.field_150350_a) {
                                            if (this.field_70170_p.field_73012_v.nextInt(2) == 1) {
                                                this.field_70170_p.func_147449_b(ix, (int)this.field_70163_u + i + 1, iz, OreSpawnMain.MyFlowerPinkBlock);
                                            }
                                            else {
                                                this.field_70170_p.func_147449_b(ix, (int)this.field_70163_u + i + 1, iz, OreSpawnMain.MyFlowerBlueBlock);
                                            }
                                        }
                                    }
                                    else if (this.field_70170_p.field_73012_v.nextInt(100) == 1 && this.field_70170_p.func_147439_a(ix, (int)this.field_70163_u + i + 1, iz) == Blocks.field_150350_a) {
                                        OreSpawnMain.OreSpawnTrees.SmallTree(this.field_70170_p, ix, (int)this.field_70163_u + i + 1, iz);
                                    }
                                }
                            }
                            else if (bid == Blocks.field_150357_h) {
                                this.func_70106_y();
                                return;
                            }
                        }
                        else {
                            final Block bid = this.field_70170_p.func_147439_a(ix, (int)this.field_70163_u + i, iz);
                            if (bid == Blocks.field_150377_bs) {
                                if (!this.field_70170_p.field_72995_K) {
                                    this.field_70170_p.func_72876_a((Entity)this, (double)ix, this.field_70163_u + i, (double)iz, 5.0f, true);
                                }
                            }
                            else {
                                this.mySetBlock(ix, (int)this.field_70163_u + i, iz);
                            }
                        }
                    }
                }
            }
            this.field_70170_p.func_147449_b((int)this.field_70165_t - xoff, (int)this.field_70163_u, (int)this.field_70161_v - zoff, Blocks.field_150350_a);
        }
    }
    
    protected Item func_146068_u() {
        return Item.func_150898_a(OreSpawnMain.MyIslandBlock);
    }
    
    public void FastSetBlock(final int ix, final int iy, final int iz, final Block id) {
        OreSpawnMain.setBlockFast(this.field_70170_p, ix, iy, iz, id, 0, 3);
    }
}

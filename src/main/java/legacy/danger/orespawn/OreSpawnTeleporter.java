// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.entity.EntityList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.init.Blocks;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.Teleporter;

public class OreSpawnTeleporter extends Teleporter
{
    private WorldServer world;
    private World oldWorld;
    private Random random;
    private int newdim;
    
    public OreSpawnTeleporter(final WorldServer par1WorldServer, final int dim, final World par2World) {
        super(par1WorldServer);
        this.world = par1WorldServer;
        this.oldWorld = par2World;
        this.random = new Random(par1WorldServer.func_72905_C());
        this.newdim = dim;
    }
    
    public void func_77185_a(final Entity par1Entity, final double par2, final double par4, final double par6, final float par8) {
        this.justPutMe(par1Entity);
    }
    
    public boolean func_77184_b(final Entity par1Entity, final double par2, final double par4, final double par6, final float par8) {
        this.justPutMe(par1Entity);
        return true;
    }
    
    public boolean func_85188_a(final Entity par1Entity) {
        return true;
    }
    
    private boolean isGroundBlock(final Block bid) {
        return bid != Blocks.field_150350_a && (bid == Blocks.field_150346_d || bid == Blocks.field_150349_c || bid == Blocks.field_150348_b || bid == Blocks.field_150377_bs || bid == Blocks.field_150424_aL || bid == Blocks.field_150347_e || bid == Blocks.field_150354_m || bid == Blocks.field_150322_A || bid == Blocks.field_150458_ak);
    }
    
    public boolean justPutMe(final Entity par1Entity) {
        int posX = (int)par1Entity.field_70165_t;
        int posZ = (int)par1Entity.field_70161_v;
        int posY = 120;
        int found = 0;
        int inarow = 0;
        int airfound = 0;
        for (int i = 0; i < 1000 && found == 0; ++i) {
            for (posY = 180; posY > 1; --posY) {
                Block bid = this.world.func_147439_a(posX, posY + 1, posZ);
                if (bid == Blocks.field_150350_a || bid == null) {
                    inarow = 0;
                    bid = this.world.func_147439_a(posX, posY, posZ);
                    if (bid == Blocks.field_150350_a || bid == null) {
                        airfound = 1;
                        bid = this.world.func_147439_a(posX, posY - 1, posZ);
                        if (bid != Blocks.field_150350_a && bid != null) {
                            if (this.world.func_147439_a(posX, posY - 1, posZ).func_149688_o().func_76220_a()) {
                                found = 1;
                                break;
                            }
                            if (bid == Blocks.field_150329_H && this.world.func_147439_a(posX, posY - 2, posZ).func_149688_o().func_76220_a()) {
                                found = 1;
                                --posY;
                                break;
                            }
                            break;
                        }
                    }
                }
                else {
                    if (this.isGroundBlock(bid)) {
                        ++inarow;
                    }
                    if (airfound != 0 && inarow >= 3) {
                        break;
                    }
                }
            }
            if (found == 0) {
                posX = (int)par1Entity.field_70165_t + this.world.field_73012_v.nextInt(3 + i / 5) - this.world.field_73012_v.nextInt(3 + i / 5);
                if (i > 100) {
                    posX = posX + OreSpawnMain.OreSpawnRand.nextInt(2 + i / 5) - OreSpawnMain.OreSpawnRand.nextInt(2 + i / 5);
                }
                if (i > 500) {
                    posX = posX + this.random.nextInt(2 + i / 5) - this.random.nextInt(2 + i / 5);
                }
                posZ = (int)par1Entity.field_70161_v + this.world.field_73012_v.nextInt(3 + i / 5) - this.world.field_73012_v.nextInt(3 + i / 5);
                if (i > 100) {
                    posZ = posZ + OreSpawnMain.OreSpawnRand.nextInt(2 + i / 5) - OreSpawnMain.OreSpawnRand.nextInt(2 + i / 5);
                }
                if (i > 500) {
                    posZ = posZ + this.random.nextInt(2 + i / 5) - this.random.nextInt(2 + i / 5);
                }
                airfound = 0;
                inarow = 0;
            }
        }
        if (found == 0) {
            posX = (int)par1Entity.field_70165_t;
            posZ = (int)par1Entity.field_70161_v;
            for (posY = 180; posY > 1; --posY) {
                if (Blocks.field_150350_a == this.world.func_147439_a(posX, posY + 1, posZ) && Blocks.field_150350_a == this.world.func_147439_a(posX, posY, posZ) && Blocks.field_150350_a != this.world.func_147439_a(posX, posY - 1, posZ)) {
                    break;
                }
            }
        }
        final double oldX = par1Entity.field_70165_t;
        final double oldY = par1Entity.field_70163_u;
        final double oldZ = par1Entity.field_70161_v;
        double newX = posX;
        double newZ = posZ;
        final double newY = posY;
        if (newX < 0.0) {
            newX -= 0.5;
        }
        else {
            newX += 0.5;
        }
        if (newZ < 0.0) {
            newZ -= 0.5;
        }
        else {
            newZ += 0.5;
        }
        par1Entity.func_70012_b(newX, newY, newZ, par1Entity.field_70177_z, 0.0f);
        final double field_70159_w = 0.0;
        par1Entity.field_70179_y = field_70159_w;
        par1Entity.field_70181_x = field_70159_w;
        par1Entity.field_70159_w = field_70159_w;
        final MinecraftServer minecraftserver = MinecraftServer.func_71276_C();
        final WorldServer worldserver = minecraftserver.func_71218_a(this.oldWorld.field_73011_w.field_76574_g);
        final WorldServer worldserver2 = minecraftserver.func_71218_a(this.newdim);
        if (par1Entity instanceof EntityPlayer) {
            final EntityPlayer ep = (EntityPlayer)par1Entity;
            final AxisAlignedBB bb = AxisAlignedBB.func_72330_a(oldX - 24.0, oldY - 12.0, oldZ - 24.0, oldX + 24.0, oldY + 12.0, oldZ + 24.0);
            final List var5 = this.oldWorld.func_72872_a((Class)EntityTameable.class, bb);
            for (final Entity var7 : var5) {
                final EntityTameable et = (EntityTameable)var7;
                if (!et.func_70906_o()) {
                    final String p1 = ep.func_110124_au().toString();
                    final String p2 = et.func_152113_b();
                    if ((p1 == null || p2 == null || !p1.equals(p2)) && !et.func_152114_e((EntityLivingBase)ep)) {
                        continue;
                    }
                    this.sendToThisDimension(var7, newX, newY, newZ, (int)ep.field_70177_z);
                }
            }
        }
        worldserver.func_82742_i();
        worldserver2.func_82742_i();
        return true;
    }
    
    public void sendToThisDimension(final Entity e, final double newX, final double newY, final double newZ, final int ro) {
        if (this.oldWorld.field_72995_K) {
            return;
        }
        e.field_70170_p.func_72900_e(e);
        e.field_70128_L = false;
        e.func_70012_b(newX, newY, newZ, (float)ro, 0.0f);
        final double field_70159_w = 0.0;
        e.field_70179_y = field_70159_w;
        e.field_70181_x = field_70159_w;
        e.field_70159_w = field_70159_w;
        e.func_70029_a((World)this.world);
        final Entity var6 = EntityList.func_75620_a(EntityList.func_75621_b(e), (World)this.world);
        if (var6 != null) {
            var6.func_82141_a(e, true);
            var6.func_70012_b(newX, newY, newZ, (float)ro, 0.0f);
            final Entity entity = var6;
            final Entity entity2 = var6;
            final Entity entity3 = var6;
            final double field_70159_w2 = 0.0;
            entity3.field_70179_y = field_70159_w2;
            entity2.field_70181_x = field_70159_w2;
            entity.field_70159_w = field_70159_w2;
            var6.func_70029_a((World)this.world);
            this.world.func_72838_d(var6);
        }
        e.field_70128_L = true;
    }
    
    public void func_85189_a(final long par1) {
    }
}

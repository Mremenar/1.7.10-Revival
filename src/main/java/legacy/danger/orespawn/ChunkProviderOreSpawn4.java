// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.world.ChunkPosition;
import net.minecraft.world.biome.BiomeGenBase;
import java.util.List;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.chunk.storage.ExtendedBlockStorage;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.init.Blocks;
import net.minecraft.block.Block;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

public class ChunkProviderOreSpawn4 implements IChunkProvider
{
    private World worldObj;
    private Random random;
    private final Block[] cachedBlockIDs;
    private final byte[] cachedBlockMetadata;
    
    public ChunkProviderOreSpawn4(final World par1World, final long par2, final boolean par4) {
        this.cachedBlockIDs = new Block[256];
        this.cachedBlockMetadata = new byte[256];
        this.worldObj = par1World;
        this.random = new Random(par2);
        for (int j = 0; j < 8; ++j) {
            if (j == 0) {
                this.cachedBlockIDs[j] = Blocks.field_150357_h;
            }
            else if (j == 7) {
                this.cachedBlockIDs[j] = (Block)Blocks.field_150349_c;
            }
            else {
                this.cachedBlockIDs[j] = Blocks.field_150346_d;
            }
        }
    }
    
    public Chunk func_73158_c(final int par1, final int par2) {
        return this.func_73154_d(par1, par2);
    }
    
    public Chunk func_73154_d(final int par1, final int par2) {
        final Chunk chunk = new Chunk(this.worldObj, par1, par2);
        for (int k = 0; k < this.cachedBlockIDs.length; ++k) {
            final Block block = this.cachedBlockIDs[k];
            if (block != null) {
                final int l = k >> 4;
                ExtendedBlockStorage extendedblockstorage = chunk.func_76587_i()[l];
                if (extendedblockstorage == null) {
                    extendedblockstorage = new ExtendedBlockStorage(k, !this.worldObj.field_73011_w.field_76576_e);
                    chunk.func_76587_i()[l] = extendedblockstorage;
                }
                for (int i1 = 0; i1 < 16; ++i1) {
                    for (int j1 = 0; j1 < 16; ++j1) {
                        extendedblockstorage.func_150818_a(i1, k & 0xF, j1, block);
                        extendedblockstorage.func_76654_b(i1, k & 0xF, j1, (int)this.cachedBlockMetadata[k]);
                    }
                }
            }
        }
        this.addScragglyTrees(this.worldObj, par1 * 16, par2 * 16, chunk);
        chunk.func_76603_b();
        return chunk;
    }
    
    public boolean func_73149_a(final int par1, final int par2) {
        return true;
    }
    
    public void func_73153_a(final IChunkProvider par1IChunkProvider, final int par2, final int par3) {
        final int k = par2 * 16;
        final int l = par3 * 16;
        this.random.setSeed(this.worldObj.func_72905_C());
        final long i1 = this.random.nextLong() / 2L * 2L + 1L;
        final long j1 = this.random.nextLong() / 2L * 2L + 1L;
        this.random.setSeed(par2 * i1 + par3 * j1 ^ this.worldObj.func_72905_C());
    }
    
    public boolean func_73151_a(final boolean par1, final IProgressUpdate par2IProgressUpdate) {
        return true;
    }
    
    public void func_104112_b() {
    }
    
    public boolean func_73156_b() {
        return false;
    }
    
    public boolean func_73157_c() {
        return true;
    }
    
    public String func_73148_d() {
        return "DangerDimension";
    }
    
    public List func_73155_a(final EnumCreatureType par1EnumCreatureType, final int par2, final int par3, final int par4) {
        final BiomeGenBase biomegenbase = this.worldObj.func_72807_a(par2, par4);
        return biomegenbase.func_76747_a(par1EnumCreatureType);
    }
    
    public ChunkPosition func_147416_a(final World p_147416_1_, final String p_147416_2_, final int p_147416_3_, final int p_147416_4_, final int p_147416_5_) {
        return null;
    }
    
    public int func_73152_e() {
        return 0;
    }
    
    public void func_82695_e(final int par1, final int par2) {
    }
    
    public void addScragglyTrees(final World world, final int chunkX, final int chunkZ, final Chunk chunk) {
        int howmany = 1 + this.random.nextInt(10);
        if (OreSpawnMain.LessLag == 1) {
            howmany /= 2;
        }
        if (OreSpawnMain.LessLag == 2) {
            howmany /= 4;
        }
        if (howmany == 0) {
            return;
        }
        for (int i = 0; i < howmany; ++i) {
            final int posX = 2 + chunkX + this.random.nextInt(12);
            final int posZ = 2 + chunkZ + this.random.nextInt(12);
            for (int posY = 20; posY > 2; --posY) {
                if (OreSpawnMain.getBlockIDInChunk(chunk, posX, posY - 1, posZ) == Blocks.field_150349_c) {
                    this.ScragglyTreeWithBranches(world, posX, posY, posZ, chunk);
                    break;
                }
            }
        }
    }
    
    public void makeScragglyBranch(final World world, int x, int y, int z, final int len, final int biasx, final int biasz, final Chunk chunk) {
        for (int k = 0; k < len; ++k) {
            int ix = this.random.nextInt(2) - this.random.nextInt(2) + biasx;
            int iz = this.random.nextInt(2) - this.random.nextInt(2) + biasz;
            if (ix > 1) {
                ix = 1;
            }
            if (ix < -1) {
                ix = -1;
            }
            if (iz > 1) {
                iz = 1;
            }
            if (iz < -1) {
                iz = -1;
            }
            final int iy = (this.random.nextInt(3) > 0) ? 1 : 0;
            x += ix;
            z += iz;
            y += iy;
            Block bid = OreSpawnMain.getBlockIDInChunk(chunk, x, y, z);
            if (bid != Blocks.field_150350_a && bid != Blocks.field_150364_r && bid != OreSpawnMain.MyAppleLeaves) {
                return;
            }
            OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, x, y, z, Blocks.field_150364_r, 0);
            for (int m = -1; m < 2; ++m) {
                for (int n = -1; n < 2; ++n) {
                    if (this.random.nextInt(2) == 1) {
                        bid = OreSpawnMain.getBlockIDInChunk(chunk, x + m, y, z + n);
                        if (bid == Blocks.field_150350_a) {
                            OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, x + m, y, z + n, OreSpawnMain.MyAppleLeaves, 0);
                        }
                    }
                }
            }
            if (this.random.nextInt(2) == 1) {
                bid = OreSpawnMain.getBlockIDInChunk(chunk, x, y + 1, z);
                if (bid == Blocks.field_150350_a) {
                    OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, x, y + 1, z, OreSpawnMain.MyAppleLeaves, 0);
                }
            }
        }
    }
    
    public void ScragglyTreeWithBranches(final World world, int x, int y, int z, final Chunk chunk) {
        final int i = 1 + this.random.nextInt(3);
        final int j = i + this.random.nextInt(12);
        for (int k = 0; k < i; ++k) {
            final Block bid = OreSpawnMain.getBlockIDInChunk(chunk, x, y + k, z);
            if (k >= 1 && bid != Blocks.field_150350_a && bid != Blocks.field_150364_r && bid != OreSpawnMain.MyAppleLeaves) {
                return;
            }
            OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, x, y + k, z, Blocks.field_150364_r, 0);
        }
        y += i - 1;
        for (int k = i; k < j; ++k) {
            final int ix = this.random.nextInt(2) - this.random.nextInt(2);
            final int iz = this.random.nextInt(2) - this.random.nextInt(2);
            final int iy = (this.random.nextInt(4) > 0) ? 1 : 0;
            x += ix;
            z += iz;
            y += iy;
            Block bid = OreSpawnMain.getBlockIDInChunk(chunk, x, y, z);
            if (bid != Blocks.field_150350_a && bid != Blocks.field_150364_r && bid != OreSpawnMain.MyAppleLeaves) {
                break;
            }
            OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, x, y, z, Blocks.field_150364_r, 0);
            if (this.random.nextInt(4) == 1) {
                this.makeScragglyBranch(world, x, y, z, this.random.nextInt(1 + j - k), this.random.nextInt(2) - this.random.nextInt(2), this.random.nextInt(2) - this.random.nextInt(2), chunk);
            }
            for (int m = -1; m < 2; ++m) {
                for (int n = -1; n < 2; ++n) {
                    if (this.random.nextInt(2) == 1) {
                        bid = OreSpawnMain.getBlockIDInChunk(chunk, x + m, y, z + n);
                        if (bid == Blocks.field_150350_a) {
                            OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, x + m, y, z + n, OreSpawnMain.MyAppleLeaves, 0);
                        }
                    }
                }
            }
            if (this.random.nextInt(2) == 1) {
                bid = OreSpawnMain.getBlockIDInChunk(chunk, x, y + 1, z);
                if (bid == Blocks.field_150350_a) {
                    OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, x, y + 1, z, OreSpawnMain.MyAppleLeaves, 0);
                }
            }
        }
    }
}

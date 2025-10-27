// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.storage.WorldInfo;
import net.minecraft.world.WorldServer;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.DimensionManager;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.WorldProvider;

public class WorldProviderOreSpawn2 extends WorldProvider
{
    public String func_80007_l() {
        return "Dimension-Extreme";
    }
    
    public boolean func_76567_e() {
        return true;
    }
    
    public void func_76572_b() {
        this.field_76578_c = (WorldChunkManager)new WorldChunkManagerHell(BiomeGenBase.field_76770_e, 0.01f);
        this.field_76578_c.func_76935_a(0, 0).func_76732_a(0.8f, 0.01f);
        this.field_76574_g = OreSpawnMain.DimensionID2;
    }
    
    public void setWorldTime(final long time) {
        final WorldServer ws = DimensionManager.getWorld(this.field_76574_g);
        if (ws != null) {
            final WorldInfo w = ws.func_72912_H();
            if (w != null) {
                if (time % 24000L > 12000L && ws.func_73056_e()) {
                    long i = time + 24000L;
                    i -= i % 24000L;
                    for (int j = 0; j < MinecraftServer.func_71276_C().field_71305_c.length; ++j) {
                        MinecraftServer.func_71276_C().field_71305_c[j].func_72877_b(i);
                    }
                }
                else {
                    super.setWorldTime(time);
                }
            }
            else {
                super.setWorldTime(time);
            }
        }
        else {
            super.setWorldTime(time);
        }
    }
    
    public IChunkProvider func_76555_c() {
        return (IChunkProvider)new ChunkProviderOreSpawn2(this.field_76579_a, this.field_76579_a.func_72905_C(), true);
    }
}

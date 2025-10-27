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
import net.minecraftforge.common.BiomeManager;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.WorldProvider;

public class WorldProviderOreSpawn3 extends WorldProvider
{
    private BiomeGenUtopianPlains MyPlains;
    
    public WorldProviderOreSpawn3() {
        this.MyPlains = (BiomeGenUtopianPlains)new BiomeGenUtopianPlains(OreSpawnMain.BiomeVillageID).func_76739_b(353825).func_76735_a("Villages").func_76732_a(0.7f, 0.5f);
    }
    
    public String func_80007_l() {
        return "Dimension-VillageMania";
    }
    
    public boolean func_76567_e() {
        return true;
    }
    
    public void func_76572_b() {
        this.MyPlains.setVillageCreatures();
        this.field_76578_c = (WorldChunkManager)new WorldChunkManagerHell((BiomeGenBase)this.MyPlains, 0.5f);
        this.field_76578_c.func_76935_a(0, 0).func_76732_a(0.7f, 0.5f);
        this.field_76574_g = OreSpawnMain.DimensionID3;
        BiomeManager.addVillageBiome((BiomeGenBase)this.MyPlains, true);
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
        return (IChunkProvider)new ChunkProviderOreSpawn3(this.field_76579_a, this.field_76579_a.func_72905_C(), true);
    }
}

// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import java.util.Random;
import net.minecraft.world.gen.structure.MapGenVillage;

public class MapGenMoreVillages extends MapGenVillage
{
    private int field_82665_g;
    private int field_82666_h;
    
    public MapGenMoreVillages() {
        this.field_82665_g = 9;
        this.field_82666_h = 7;
    }
    
    protected boolean func_75047_a(int par1, int par2) {
        final int var3 = par1;
        final int var4 = par2;
        if (par1 < 0) {
            par1 -= this.field_82665_g - 1;
        }
        if (par2 < 0) {
            par2 -= this.field_82665_g - 1;
        }
        int var5 = par1 / this.field_82665_g;
        int var6 = par2 / this.field_82665_g;
        final Random var7 = this.field_75039_c.func_72843_D(var5, var6, 10387312);
        var5 *= this.field_82665_g;
        var6 *= this.field_82665_g;
        var5 += var7.nextInt(this.field_82665_g - this.field_82666_h);
        var6 += var7.nextInt(this.field_82665_g - this.field_82666_h);
        if (var3 == var5 && var4 == var6) {
            final boolean var8 = this.field_75039_c.func_72959_q().func_76940_a(var3 * 16 + 8, var4 * 16 + 8, 0, MapGenMoreVillages.field_75055_e);
            return true;
        }
        return false;
    }
}

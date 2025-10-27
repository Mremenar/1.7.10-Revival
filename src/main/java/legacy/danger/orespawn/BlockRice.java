// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import java.util.Random;
import net.minecraft.util.IIcon;
import net.minecraft.block.BlockCrops;

public class BlockRice extends BlockCrops
{
    private IIcon[] iconArray;
    
    public BlockRice(final int par1) {
    }
    
    public IIcon func_149691_a(final int par1, int par2) {
        if (par2 < 7) {
            if (par2 >= 6) {
                par2 = 4;
            }
            return this.iconArray[par2 >> 1];
        }
        return this.iconArray[3];
    }
    
    public int func_149745_a(final Random par1Random) {
        return 2 + par1Random.nextInt(4);
    }
    
    protected Item func_149866_i() {
        return OreSpawnMain.MyRice;
    }
    
    protected Item func_149865_P() {
        return OreSpawnMain.MyRice;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149651_a(final IIconRegister par1IIconRegister) {
        this.iconArray = new IIcon[4];
        for (int i = 0; i < this.iconArray.length; ++i) {
            this.iconArray[i] = par1IIconRegister.func_94245_a("OreSpawn:rice_" + i);
        }
    }
}

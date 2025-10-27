// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;

public class RTPBlock extends Block
{
    public RTPBlock(final int i) {
        super(Material.field_151576_e);
        this.func_149647_a(CreativeTabs.field_78030_b);
    }
    
    public void func_149724_b(final World world, final int par2, final int par3, final int par4, final Entity par5Entity) {
        if (par5Entity instanceof EntityPlayer) {
            final EntityPlayer p = (EntityPlayer)par5Entity;
            EntityPlayerMP mp = null;
            if (par5Entity instanceof EntityPlayerMP) {
                mp = (EntityPlayerMP)par5Entity;
            }
            int x = par2;
            int y = par3;
            int z = par4;
            int found = 0;
            for (int tries = 0; tries < 1000 && found == 0; ++tries) {
                if (world.field_73012_v.nextInt(2) == 0) {
                    x = par2 + 16 + world.field_73012_v.nextInt(8) - world.field_73012_v.nextInt(8);
                }
                else {
                    x = par2 - 16 + world.field_73012_v.nextInt(8) - world.field_73012_v.nextInt(8);
                }
                if (world.field_73012_v.nextInt(2) == 0) {
                    z = par4 + 16 + world.field_73012_v.nextInt(8) - world.field_73012_v.nextInt(8);
                }
                else {
                    z = par4 - 16 + world.field_73012_v.nextInt(8) - world.field_73012_v.nextInt(8);
                }
                for (y = par3 - 4; y <= par3 + 4; ++y) {
                    if (world.func_147439_a(x, y - 1, z).func_149688_o().func_76220_a() && world.func_147439_a(x, y, z) == Blocks.field_150350_a && world.func_147439_a(x, y + 1, z) == Blocks.field_150350_a) {
                        found = 1;
                        break;
                    }
                }
            }
            if (found != 0) {
                if (mp != null) {
                    mp.field_71135_a.func_147364_a((double)(x + 0.5f), (double)(float)y, (double)(z + 0.5f), p.field_70177_z, 0.0f);
                }
                else {
                    p.func_70012_b((double)(x + 0.5f), (double)(float)y, (double)(z + 0.5f), p.field_70177_z, 0.0f);
                }
                for (int var3 = 0; var3 < 6; ++var3) {
                    world.func_72869_a("smoke", (double)(x + 0.5f), (double)(y + 2.25f), (double)(z + 0.5f), 0.0, 0.0, 0.0);
                    world.func_72869_a("explode", (double)(x + 0.5f), (double)(y + 2.25f), (double)(z + 0.5f), 0.0, 0.0, 0.0);
                    world.func_72869_a("reddust", (double)(x + 0.5f), (double)(y + 2.25f), (double)(z + 0.5f), 0.0, 0.0, 0.0);
                }
                p.field_70170_p.func_72956_a((Entity)p, "random.explode", 1.0f, 1.5f);
            }
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149651_a(final IIconRegister iconRegister) {
        this.field_149761_L = iconRegister.func_94245_a("OreSpawn:" + this.func_149739_a().substring(5));
    }
}

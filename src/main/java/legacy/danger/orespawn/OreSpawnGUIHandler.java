// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.network.IGuiHandler;

public class OreSpawnGUIHandler implements IGuiHandler
{
    public Object getServerGuiElement(final int ID, final EntityPlayer player, final World world, final int x, final int y, final int z) {
        final TileEntity tileEntity = world.func_147438_o(x, y, z);
        switch (ID) {
            case 0: {
                if (tileEntity instanceof TileEntityCrystalFurnace) {
                    return new ContainerCrystalFurnace(player.field_71071_by, (TileEntityCrystalFurnace)tileEntity);
                }
                break;
            }
            case 1: {
                return new ContainerCrystalWorkbench(player.field_71071_by, world, x, y, z);
            }
        }
        return null;
    }
    
    public Object getClientGuiElement(final int ID, final EntityPlayer player, final World world, final int x, final int y, final int z) {
        final TileEntity tileEntity = world.func_147438_o(x, y, z);
        switch (ID) {
            case 0: {
                if (tileEntity instanceof TileEntityCrystalFurnace) {
                    return new CrystalFurnaceGUI(player.field_71071_by, (TileEntityCrystalFurnace)tileEntity);
                }
                break;
            }
            case 1: {
                return new CrystalWorkbenchGUI(player.field_71071_by, world, x, y, z);
            }
        }
        return null;
    }
}

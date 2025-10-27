// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;

public class CommonProxyOreSpawn
{
    private SimpleNetworkWrapper network;
    
    public SimpleNetworkWrapper getNetwork() {
        return this.network;
    }
    
    public void registerRenderThings() {
    }
    
    public void registerSoundThings() {
    }
    
    public void registerKeyboardInput() {
    }
    
    public void registerNetworkStuff() {
        (this.network = NetworkRegistry.INSTANCE.newSimpleChannel("RiderControls")).registerMessage((Class)RiderControlMessageHandler.class, (Class)RiderControlMessage.class, 0, Side.SERVER);
    }
    
    public int setArmorPrefix(final String string) {
        return 0;
    }
}

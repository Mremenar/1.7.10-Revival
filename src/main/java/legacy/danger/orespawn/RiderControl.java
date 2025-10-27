// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;

public class RiderControl
{
    private final RiderControlMessage rcm;
    private final SimpleNetworkWrapper network;
    private int keystate;
    
    public RiderControl(final SimpleNetworkWrapper network) {
        this.rcm = new RiderControlMessage();
        this.keystate = 0;
        this.network = network;
    }
    
    @SubscribeEvent
    public void onTick(final TickEvent.ClientTickEvent evt) {
        int newkeystate = 0;
        final KeyHandler myKeyhandler = OreSpawnMain.MyKeyhandler;
        if (KeyHandler.KEY_FLY_UP.func_151470_d()) {
            newkeystate = 1;
        }
        if (this.keystate != newkeystate) {
            this.rcm.keystate = newkeystate;
            this.network.sendToServer((IMessage)this.rcm);
            this.keystate = newkeystate;
        }
    }
}

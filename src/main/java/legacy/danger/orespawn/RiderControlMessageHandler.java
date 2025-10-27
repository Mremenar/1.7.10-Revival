// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import org.apache.logging.log4j.LogManager;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import org.apache.logging.log4j.Logger;
import io.netty.channel.ChannelHandler;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;

@ChannelHandler.Sharable
public class RiderControlMessageHandler implements IMessageHandler<RiderControlMessage, IMessage>
{
    private static final Logger L;
    
    public IMessage onMessage(final RiderControlMessage message, final MessageContext ctx) {
        if (ctx.side == Side.CLIENT) {
            return null;
        }
        OreSpawnMain.flyup_keystate = message.keystate;
        return null;
    }
    
    static {
        L = LogManager.getLogger();
    }
}

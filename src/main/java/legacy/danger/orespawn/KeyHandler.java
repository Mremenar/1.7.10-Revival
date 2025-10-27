// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.Minecraft;

public class KeyHandler
{
    private final Minecraft mc;
    public static final String KEY_CATEGORY = "key.categories.orespawn";
    public static final KeyBinding KEY_FLY_UP;
    
    public KeyHandler() {
        this.mc = Minecraft.func_71410_x();
        ClientRegistry.registerKeyBinding(KeyHandler.KEY_FLY_UP);
    }
    
    @SubscribeEvent
    public void onKeyInput(final InputEvent.KeyInputEvent event) {
    }
    
    static {
        KEY_FLY_UP = new KeyBinding("OreSpawn UP/FAST", 56, "key.categories.orespawn");
    }
}

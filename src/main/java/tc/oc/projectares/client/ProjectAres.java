package tc.oc.projectares.client;

import net.minecraft.client.Minecraft;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.ModLoader;
import net.minecraft.src.NetClientHandler;
import net.minecraft.src.NetServerHandler;
import net.minecraft.src.mod_ProjectAres;

public final class ProjectAres {
    private static ProjectAres pa;

    public boolean onPA = false;
    public static final String serverDomain = "oc.tc";

    public static ProjectAres get() {
        return pa;
    }

    public ProjectAres() {
        pa = this;
        ModLoader.setInGUIHook(mod_ProjectAres.get(), true, false);
        ModLoader.setInGameHook(mod_ProjectAres.get(), true, false);
    }

    public void onCustomPacket(NetServerHandler serverHandler, String channel, int length, byte[] data) {}

    public void onTickInGUI(float tick, Minecraft mc, GuiScreen screen) {}

    public void onTickInGame(float tick, Minecraft mc) {}

    public void onConnect(NetClientHandler handler) {
        if (handler.getNetManager().getSocketAddress().toString().contains(serverDomain)) {
            onPA = true;
        }
    }

    public void onDisconnect(NetClientHandler handler) {
        if (onPA) onPA = false;
    }
}

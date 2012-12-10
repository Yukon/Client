package net.minecraft.src;

import net.minecraft.client.Minecraft;
import net.minecraft.src.*;

import tc.oc.projectares.client.ProjectAres;

public final class mod_ProjectAres extends BaseMod {
    private static ProjectAres pa;

    public static mod_ProjectAres get() {
        for(Object mod : ModLoader.getLoadedMods()) {
            if(mod instanceof mod_ProjectAres) {
                return (mod_ProjectAres) mod;
            }
        }
        return null;
    }

    @Override
    public void load() {
        this.pa = new ProjectAres();
    }

    @Override
    public void serverCustomPayload(NetServerHandler serverHandler, Packet250CustomPayload packet) {
        this.pa.onCustomPacket(serverHandler, packet.channel, packet.length, packet.data);
    }

    @Override
    public String getVersion() {
        return "0.1";
    }

    @Override
    public String getName() {
        return "Project Ares Client";
    }

    @Override
    public boolean onTickInGUI(float tick, Minecraft mc, GuiScreen screen) {
        this.pa.onTickInGUI(tick, mc, screen);
        return true;
     }

    @Override
    public boolean onTickInGame(float tick, Minecraft mc) {
        this.pa.onTickInGame(tick, mc);
        return true;
    }

    @Override
    public void clientConnect(NetClientHandler handler) {
        this.pa.onConnect(handler);
    }

    @Override
    public void clientDisconnect(NetClientHandler handler) {
        this.pa.onDisconnect(handler);
    }
}
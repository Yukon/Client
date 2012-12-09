package net.minecraft.src;

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

    public void load() {
        this.pa = new ProjectAres();
    }

    public void serverCustomPaylod(NetServerHandler serverHandler, Packet250CustomPayload packet) {
        this.pa.onCustomPacket(serverHandler, packet.channel, packet.length, packet.data);
    }

    public String getVersion() {
        return "0.1";
    }
}
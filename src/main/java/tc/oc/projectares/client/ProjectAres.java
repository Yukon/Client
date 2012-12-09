package tc.oc.projectares.client;

import net.minecraft.src.NetServerHandler;

public final class ProjectAres {
    private static ProjectAres pa;

    public static ProjectAres get() {
        return pa;
    }

    public ProjectAres() {
        pa = this;
    }

    public void onCustomPacket(NetServerHandler serverHandler, String channel, int length, byte[] data) {}
}

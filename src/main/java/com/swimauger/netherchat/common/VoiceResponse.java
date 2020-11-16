package com.swimauger.netherchat.common;

import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class VoiceResponse {
    public VoiceResponse() {

    }

    public static void encode(VoiceResponse msg, PacketBuffer packetBuffer) {

    }

    public static VoiceResponse decode(PacketBuffer packetBuffer) {
        return new VoiceResponse();
    }

    public static <MSG> void onMessage(MSG msg, Supplier<NetworkEvent.Context> contextSupplier) {

    }
}

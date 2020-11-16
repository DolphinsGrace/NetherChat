package com.swimauger.netherchat.common;

import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class VoiceRequest {
    public VoiceRequest() {

    }

    public static void encode(VoiceRequest voiceRequest, PacketBuffer packetBuffer) {
        
    }

    public static VoiceRequest decode(PacketBuffer packetBuffer) {
        return new VoiceRequest();
    }

    public static <MSG> void onMessage(MSG msg, Supplier<NetworkEvent.Context> contextSupplier) {

    }
}

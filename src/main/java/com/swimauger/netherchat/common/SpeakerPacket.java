package com.swimauger.netherchat.common;

import com.swimauger.netherchat.client.core.Speaker;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class SpeakerPacket {
    private byte[] audio;

    public SpeakerPacket(byte[] audio) {
        this.audio = audio;
    }

    public static void encode(SpeakerPacket response, PacketBuffer packet) {
        packet.writeByteArray(response.audio);
    }

    public static SpeakerPacket decode(PacketBuffer packet) {
        return new SpeakerPacket(packet.readByteArray());
    }

    public static void onMessage(SpeakerPacket response, Supplier<NetworkEvent.Context> context) {
        Speaker.playAudio(response.audio);
        context.get().setPacketHandled(true);
    }
}

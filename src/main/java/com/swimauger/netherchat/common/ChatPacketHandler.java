package com.swimauger.netherchat.common;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

import java.util.Optional;

public class ChatPacketHandler {
    public static final byte AUDIO_REQUEST_ID = 39;
    public static final byte AUDIO_RESPONSE_ID = 40;

    private static final String PROTOCOL_VERSION = "1";

    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
            new ResourceLocation("netherchat", "network"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals
    );

    public static void registerMessages() {
        INSTANCE.registerMessage(
                AUDIO_REQUEST_ID,
                MicrophonePacket.class,
                MicrophonePacket::encode,
                MicrophonePacket::decode,
                MicrophonePacket::onMessage,
                Optional.of(NetworkDirection.PLAY_TO_SERVER)
        );

        INSTANCE.registerMessage(
                AUDIO_RESPONSE_ID,
                SpeakerPacket.class,
                SpeakerPacket::encode,
                SpeakerPacket::decode,
                SpeakerPacket::onMessage,
                Optional.of(NetworkDirection.PLAY_TO_CLIENT)
        );
    }
}

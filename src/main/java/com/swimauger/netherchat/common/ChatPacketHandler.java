package com.swimauger.netherchat.common;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

import java.util.Optional;

public class ChatPacketHandler {
    public static final byte VOICE_REQUEST_ID = 39;
    public static final byte VOICE_RESPONSE_ID = 40;

    private static final String PROTOCOL_VERSION = "1";

    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
            new ResourceLocation("netherchat", "chat"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals
    );

    public static void registerMessages() {
        INSTANCE.registerMessage(
                VOICE_REQUEST_ID,
                VoiceRequest.class,
                VoiceRequest::encode,
                VoiceRequest::decode,
                VoiceRequest::onMessage,
                Optional.of(NetworkDirection.PLAY_TO_SERVER)
        );

        INSTANCE.registerMessage(
                VOICE_RESPONSE_ID,
                VoiceResponse.class,
                VoiceResponse::encode,
                VoiceResponse::decode,
                VoiceResponse::onMessage,
                Optional.of(NetworkDirection.PLAY_TO_SERVER)
        );
    }
}

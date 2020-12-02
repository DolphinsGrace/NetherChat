package com.swimauger.netherchat.common;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class MicrophonePacket {
    public byte[] audio;

    public MicrophonePacket(byte[] audio) {
        this.audio = audio;
    }

    public static void encode(MicrophonePacket packet, PacketBuffer buff) {
        buff.writeByteArray(packet.audio);
    }

    public static MicrophonePacket decode(PacketBuffer buff) {
        return new MicrophonePacket(buff.readByteArray());
    }

    public static void onMessage(MicrophonePacket packet, Supplier<NetworkEvent.Context> context) {
        int radius = 15;
        ServerPlayerEntity player = context.get().getSender();
        Vector3d pos = player.getPositionVec();
        player.getServerWorld()
            .getEntitiesWithinAABBExcludingEntity(player, new AxisAlignedBB(
                    pos.x - radius,
                    pos.y - radius,
                    pos.z - radius,
                    pos.x + radius,
                    pos.y + radius,
                    pos.z + radius
            ))
            .forEach(entity -> {
                if (entity instanceof ServerPlayerEntity) {
                    ServerPlayerEntity serverPlayer = (ServerPlayerEntity) entity;
                    ChatPacketHandler.INSTANCE.sendTo(new SpeakerPacket(packet.audio), serverPlayer.connection.netManager, NetworkDirection.PLAY_TO_CLIENT);
                }
            });
        context.get().setPacketHandled(true);
    }
}

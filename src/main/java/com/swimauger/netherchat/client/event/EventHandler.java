package com.swimauger.netherchat.client.event;

import com.swimauger.netherchat.client.text.VolumeLevel;
import com.swimauger.netherchat.client.text.VolumeTextComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class EventHandler {
    @SubscribeEvent
    public static void onPlayerJoinWorld(EntityJoinWorldEvent event) {
        Entity entity = event.getEntity();
        if (entity instanceof PlayerEntity) {
            entity.setCustomName(VolumeTextComponent.concat(entity.getName().getString(), VolumeLevel.MUTE));
        }
    }
}

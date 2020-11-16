package com.swimauger.netherchat;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("netherchat")
public class NetherChat
{
    public static final Logger LOGGER = LogManager.getLogger();

    public NetherChat() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onCommonSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::sendMessageToMods);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::recieveMessageFromMods);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onClientSetup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void onCommonSetup(final FMLCommonSetupEvent event) {
        // On server setup
    }

    private void onClientSetup(final FMLClientSetupEvent event) {
        // On client setup
    }

    private void sendMessageToMods(final InterModEnqueueEvent event) {
        // Send message to other mods
    }

    private void recieveMessageFromMods(final InterModProcessEvent event) {
        // Recieve message from other mods
    }
}

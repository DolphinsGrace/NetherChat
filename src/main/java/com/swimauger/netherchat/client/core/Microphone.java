package com.swimauger.netherchat.client.core;

import com.swimauger.netherchat.common.ChatPacketHandler;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;

public class Microphone {
    private static AudioFormat format = new AudioFormat(8000.0f, 16, 1, true, true);
    private static TargetDataLine line;
    private static boolean isOn = false;
    private static boolean isMute = false;

    public static void on() {
        new Thread(() -> {
            try {
                isOn = true;
                line = AudioSystem.getTargetDataLine(format);
                line.open(format);
                line.start();
                byte[] data = new byte[line.getBufferSize()];
                while (isOn) {
                    if (!isMute) {
                        line.read(data, 0, data.length);
                        ChatPacketHandler.INSTANCE.sendToServer(data);
                    }
                }
            } catch(LineUnavailableException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static void mute() {
        isMute = true;
    }

    public static void unmute() {
        isMute = false;
    }

    public static void off() {
        isOn = false;
        line.stop();
        line.close();
    }
}

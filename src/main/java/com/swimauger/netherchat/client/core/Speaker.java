package com.swimauger.netherchat.client.core;

import javax.sound.sampled.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Speaker {
    private static AudioFormat format = new AudioFormat(8000.0f, 16, 1, true, true);
    private static SourceDataLine line;

    public static void playAudio(byte[] audio) {
        new Thread(() -> {
            try {
                line = AudioSystem.getSourceDataLine(format);
                line.open(format);
                line.start();
                byte[] data = new byte[line.getBufferSize()];
                InputStream stream = new ByteArrayInputStream(audio);
                AudioInputStream audioStream = new AudioInputStream(stream, format, audio.length / format.getFrameSize());
                int count;
                while ((count = audioStream.read(data, 0, data.length)) != -1) {
                    if (count > 0) {
                        line.write(data, 0, count);
                    }
                }
                line.drain();
                line.close();
            } catch (LineUnavailableException | IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

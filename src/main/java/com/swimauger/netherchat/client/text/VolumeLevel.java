package com.swimauger.netherchat.client.text;

public enum VolumeLevel {
    MUTE("\u0004"),
    LOW("\u0003"),
    MEDIUM("\u0002"),
    HIGH("\u0001");

    public final String code;

    private VolumeLevel(String code) {
        this.code = code;
    }
}

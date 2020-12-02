package com.swimauger.netherchat.client.text;

public enum VolumeLevel {
    HIGH("\u0001"),
    MEDIUM("\u0002"),
    LOW("\u0003"),
    MUTE("\u0004");

    public final String code;

    private VolumeLevel(String code) {
        this.code = code;
    }
}

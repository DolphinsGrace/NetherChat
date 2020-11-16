package com.swimauger.netherchat.client.text;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.Style;

public class VolumeTextComponent extends StringTextComponent {
    public VolumeTextComponent(VolumeLevel level) {
        super(level.code);
    }

    @Override
    public Style getStyle() {
        return Style.field_240709_b_.func_240719_a_(new ResourceLocation("netherchat", "volume"));
    }

    public static ITextComponent concat(String text, VolumeLevel level) {
        return new StringTextComponent(text).func_230529_a_(new VolumeTextComponent(level));
    }

    public static ITextComponent concat(VolumeLevel level, String text) {
        return new StringTextComponent(text).func_230529_a_(new VolumeTextComponent(level));
    }
}

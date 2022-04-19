package com.ggxz.newarchitecture.components;

import androidx.annotation.Nullable;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;

import java.util.Date;

public class NativeListViewOnScrollEvent extends Event<NativeListViewOnScrollEvent> {
    public static final String EVENT_NAME = "scroll";
    private int offset_y = 0;

    public NativeListViewOnScrollEvent(int surfaceId, int viewTag, int offset_y) {
        super(surfaceId, viewTag);
        this.offset_y = offset_y;
    }

    @Override
    public String getEventName() {
        return EVENT_NAME;
    }

    @Override
    public short getCoalescingKey() {
        return 0;
    }

    @Nullable
    @Override
    protected WritableMap getEventData() {
        WritableMap map = Arguments.createMap();
        map.putInt("offset_y", offset_y);
        map.putDouble("timeStamp", new Date().getTime());
        return map;
    }
}

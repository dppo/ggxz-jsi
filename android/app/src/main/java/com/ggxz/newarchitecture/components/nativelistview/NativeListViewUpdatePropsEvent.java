package com.ggxz.newarchitecture.components.nativelistview;

import androidx.annotation.Nullable;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;

public class NativeListViewUpdatePropsEvent extends Event<NativeListViewUpdatePropsEvent> {
    public static final String EVENT_NAME = "native_list_update_props";
    private WritableMap mProps;

    public NativeListViewUpdatePropsEvent(int surfaceId, int viewTag, WritableMap props) {
        super(surfaceId, viewTag);
        mProps = props;
    }

    @Override
    public String getEventName() {
        return EVENT_NAME;
    }

    @Nullable
    @Override
    protected WritableMap getEventData() {
        return mProps;
    }
}

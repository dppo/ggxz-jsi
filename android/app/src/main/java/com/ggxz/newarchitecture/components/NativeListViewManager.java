package com.ggxz.newarchitecture.components;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.viewmanagers.NativeListViewManagerInterface;

import java.util.Map;

@ReactModule(name = NativeListViewManager.REACT_CLASS)
public class NativeListViewManager extends SimpleViewManager<NativeListView>
        implements NativeListViewManagerInterface<NativeListView> {
    public static final String REACT_CLASS = "NativeListView";

    public NativeListViewManager() {
    }

    @NonNull
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @NonNull
    @Override
    protected NativeListView createViewInstance(@NonNull ThemedReactContext reactContext) {
        return new NativeListView(reactContext);
    }

    @Nullable
    @Override
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.of(NativeListViewOnScrollEvent.EVENT_NAME, MapBuilder.of("registrationName", "onScroll"));
    }
}

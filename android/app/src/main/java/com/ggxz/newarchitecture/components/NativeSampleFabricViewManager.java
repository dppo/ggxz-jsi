package com.ggxz.newarchitecture.components;

import android.graphics.Color;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.NativeSampleFabricViewManagerDelegate;
import com.facebook.react.viewmanagers.NativeSampleFabricViewManagerInterface;

@ReactModule(name = NativeSampleFabricViewManager.REACT_CLASS)
public class NativeSampleFabricViewManager extends SimpleViewManager<NativeSampleFabricView>
        implements NativeSampleFabricViewManagerInterface<NativeSampleFabricView> {
    public static final String REACT_CLASS = "NativeSampleFabricView";

    private final ViewManagerDelegate<NativeSampleFabricView> mDelegate;

    public NativeSampleFabricViewManager() {
        mDelegate = new NativeSampleFabricViewManagerDelegate<>(this);
    }

    @Nullable
    @Override
    protected ViewManagerDelegate<NativeSampleFabricView> getDelegate() {
        return mDelegate;
    }

    @Override
    public void receiveCommand(@NonNull NativeSampleFabricView root, String commandId, @Nullable ReadableArray args) {
        mDelegate.receiveCommand(root, commandId, args);
    }

    @Override
    @ReactProp(name = "color")
    public void setColor(NativeSampleFabricView view, @Nullable String value) {
        view.setTextColor(Color.parseColor(value));
    }

    @Override
    @ReactProp(name = "step", defaultInt = 0)
    public void setStep(NativeSampleFabricView view, int value) {
        view.setText("Step: " + value);
    }

    @Override
    public void changeBackgroundColor(NativeSampleFabricView view, String color) {
        view.setBackgroundColor(Color.parseColor(color));
    }

    @NonNull
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @NonNull
    @Override
    protected NativeSampleFabricView createViewInstance(@NonNull ThemedReactContext reactContext) {
        return new NativeSampleFabricView(reactContext);
    }
}

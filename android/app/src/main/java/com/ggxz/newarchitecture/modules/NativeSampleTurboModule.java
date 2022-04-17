package com.ggxz.newarchitecture.modules;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.ReactApplicationContext;
import com.ggxz.codegen.NativeSampleTurboModuleSpec;

public class NativeSampleTurboModule extends NativeSampleTurboModuleSpec {
    public static final String NAME = "NativeSampleTurboModule";

    public NativeSampleTurboModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public double syncOne() {
        return 0;
    }

    @Override
    public void asyncOne() {

    }

    @NonNull
    @Override
    public String getName() {
        return NAME;
    }
}

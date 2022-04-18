package com.ggxz.newarchitecture.modules;

import android.app.Activity;
import android.content.Intent;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.ggxz.ConversionUtil;
import com.ggxz.MainActivity;
import com.ggxz.ProxyActivity;
import com.ggxz.codegen.NativeNavigationSpec;

public class NativeNavigation extends NativeNavigationSpec {
    public static final String NAME = "NativeNavigation";
    private final ReactApplicationContext reactContext;

    public NativeNavigation(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public void navigate(String moduleName, ReadableMap params) {
        Activity activity = this.reactContext.getCurrentActivity();
        if (activity != null) {
            Intent intent = new Intent(this.reactContext.getCurrentActivity(), ProxyActivity.class);
            intent.putExtra("moduleName", moduleName);
            intent.putExtra("params", ConversionUtil.toBundle(params));
            activity.startActivity(intent);
        }
    }

    @Override
    public void goBack() {
        Activity activity = this.reactContext.getCurrentActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @Override
    public void popToTop() {
        Activity activity = this.reactContext.getCurrentActivity();
        if (activity != null) {
            Intent intent = new Intent(activity, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            activity.startActivity(intent);
        }
    }

    @NonNull
    @Override
    public String getName() {
        return NAME;
    }
}

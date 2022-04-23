package com.ggxz.newarchitecture.components.nativelistview;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.facebook.react.ReactApplication;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.config.ReactFeatureFlags;
import com.ggxz.BuildConfig;

public class NativeListItem extends LinearLayout {
    private ReactRootView mReactRootView;
    private ReactInstanceManager mReactInstanceManager;
    private View emptyView;
    private final String cellModuleName;
    private boolean isRunning = false;

    public NativeListItem(Context context, String cellModuleName) {
        super(context);
        ReactFeatureFlags.enableEagerRootViewAttachment = true;

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        setLayoutParams(params);
        this.cellModuleName = cellModuleName;

        ReactApplication app = (ReactApplication) getContext().getApplicationContext();
        mReactInstanceManager = app.getReactNativeHost().getReactInstanceManager();

        mReactRootView = new ReactRootView(getContext());
//        mReactRootView.setIsFabric(BuildConfig.IS_NEW_ARCHITECTURE_ENABLED);

        emptyView = new View(getContext());
        emptyView.setBackgroundColor(Color.BLACK);
        emptyView.setMinimumWidth(200);
        emptyView.setMinimumHeight(200);

        LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mReactRootView.setLayoutParams(params);
        this.addView(mReactRootView, params2);

        this.addView(emptyView);
    }

    public void startReactApp(String item) {
        isRunning = true;
        Bundle bundle = new Bundle();
        bundle.putString("item", item);
        mReactRootView.startReactApplication(mReactInstanceManager, cellModuleName, bundle);
    }

    public void setAppProperties(String item) {
        Bundle bundle = new Bundle();
        bundle.putString("item", item);
        mReactRootView.setAppProperties(bundle);
    }

    public boolean isRunning() {
        return isRunning;
    }
}

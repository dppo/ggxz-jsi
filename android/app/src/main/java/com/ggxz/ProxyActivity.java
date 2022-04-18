package com.ggxz;

import android.os.Bundle;

import com.facebook.react.ReactActivity;
import com.facebook.react.ReactActivityDelegate;
import com.facebook.react.ReactRootView;

import javax.annotation.Nullable;

public class ProxyActivity extends ReactActivity {
    @Override
    protected ReactActivityDelegate createReactActivityDelegate() {
        return new ProxyActivityDelegate(this);
    }

    public static class ProxyActivityDelegate extends ReactActivityDelegate {
        ReactActivity mActivity;

        public ProxyActivityDelegate(ReactActivity activity) {
            super(activity, null);
            mActivity = activity;
        }

        @Override
        protected ReactRootView createRootView() {
            ReactRootView reactRootView = new ReactRootView(getContext());
            reactRootView.setIsFabric(BuildConfig.IS_NEW_ARCHITECTURE_ENABLED);
            return reactRootView;
        }

        @Nullable
        @Override
        protected Bundle getLaunchOptions() {
            return mActivity.getIntent().getBundleExtra("params");
        }

        @Override
        public String getMainComponentName() {
            return mActivity.getIntent().getStringExtra("moduleName");
        }
    }
}

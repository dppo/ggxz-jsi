package com.ggxz.newarchitecture.components;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.EventDispatcher;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class NativeListView extends RelativeLayout {

    public NativeListView(Context context) {
        super(context);
        this.initView();
    }

    public NativeListView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.initView();
    }

    public NativeListView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.initView();
    }

    private void handlerScroll(int i) {
        NativeListViewOnScrollEvent event = new NativeListViewOnScrollEvent(UIManagerHelper.getSurfaceId(getContext()), getId(), i);
        ReactContext reactContext = (ReactContext) getContext();
        EventDispatcher eventDispatcher =
                UIManagerHelper.getEventDispatcherForReactTag(reactContext, getId());
        assert eventDispatcher != null;
        eventDispatcher.dispatchEvent(event);
    }

    private void initView() {
        NestedScrollView nestedScrollView = new NestedScrollView(getContext());
        nestedScrollView.setBackgroundColor(Color.YELLOW);
        nestedScrollView.setOnScrollChangeListener(new OnScrollChangeListener() {
            @Override
            public void onScrollChange(View view, int i, int i1, int i2, int i3) {
                handlerScroll(i1);
            }
        });
        RelativeLayout.LayoutParams params =
                new RelativeLayout.LayoutParams(
                        LayoutParams.MATCH_PARENT,
                        LayoutParams.MATCH_PARENT);
        params.addRule(RelativeLayout.CENTER_HORIZONTAL);
        params.addRule(RelativeLayout.CENTER_VERTICAL);
        this.addView(nestedScrollView, params);


        RecyclerView recyclerView = new RecyclerView(getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
        nestedScrollView.addView(recyclerView, params);

        List data = new ArrayList();
        for (int i = 0; i < 500; i++) {
            data.add(String.valueOf(i));
        }
        NativeListViewAdapter adapter = new NativeListViewAdapter(data);
        recyclerView.setAdapter(adapter);
    }
}

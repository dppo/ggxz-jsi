package com.ggxz.newarchitecture.components.nativelistview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.EventDispatcher;

import java.util.ArrayList;
import java.util.List;

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
//        NestedScrollView nestedScrollView = new NestedScrollView(getContext());
//        nestedScrollView.setVerticalScrollBarEnabled(true);
//        nestedScrollView.setOverScrollMode(OVER_SCROLL_ALWAYS);
//        nestedScrollView.setOnScrollChangeListener(new OnScrollChangeListener() {
//            @Override
//            public void onScrollChange(View view, int i, int i1, int i2, int i3) {
//                handlerScroll(i1);
//            }
//        });
//        RelativeLayout.LayoutParams params =
//                new RelativeLayout.LayoutParams(
//                        LayoutParams.MATCH_PARENT,
//                        LayoutParams.MATCH_PARENT);
//        this.addView(nestedScrollView, params);

        RecyclerView recyclerView = new RecyclerView(getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(false);
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
        RelativeLayout.LayoutParams params2 =
                new RelativeLayout.LayoutParams(
                        LayoutParams.MATCH_PARENT,
                        LayoutParams.MATCH_PARENT);
        this.addView(recyclerView, params2);

        List data = new ArrayList();
        for (int i = 0; i < 200; i++) {
            data.add(String.valueOf(i));
        }
        NativeListViewAdapter adapter = new NativeListViewAdapter(data);
        recyclerView.setAdapter(adapter);
    }
}

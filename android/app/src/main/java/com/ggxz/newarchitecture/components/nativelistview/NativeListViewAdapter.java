package com.ggxz.newarchitecture.components.nativelistview;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NativeListViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<String> mData;
    private int count = 0;

    public NativeListViewAdapter(List<String> list) {
        mData = list;
    }

    public void setData(List<String> list) {
        mData = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        count++;
        Log.d("onCreateViewHolder", String.valueOf(count));
        return new MyViewHolder(new NativeListItem(parent.getContext(), "TestItem"));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyViewHolder mHolder = (MyViewHolder) holder;
        NativeListItem itemView = (NativeListItem) holder.itemView;
        if (!itemView.isRunning()) {
            itemView.startReactApp(mData.get(position));
        } else {
            itemView.setAppProperties(mData.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(@NonNull NativeListItem itemView) {
            super(itemView);
        }
    }
}

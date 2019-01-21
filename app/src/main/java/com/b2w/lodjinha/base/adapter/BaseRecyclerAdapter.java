package com.b2w.lodjinha.base.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;


import com.b2w.lodjinha.base.holder.ViewWrapper;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.List;

@EBean
public abstract class BaseRecyclerAdapter<T> extends RecyclerView.Adapter<ViewWrapper> {

    public interface OnItemClickListener<T> {
        void onItemClick(T item);
    }

    @RootContext
    protected Context mContext;

    protected List<T> items;

    protected OnItemClickListener<T> onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener<T> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setItemsLista(List<T> items) {
        this.items = items;
    }


    @Override
    public int getItemCount() {
        return items.size();
    }
}

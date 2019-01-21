package com.b2w.lodjinha.home.view.adapter.produto;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.b2w.lodjinha.base.adapter.BaseRecyclerAdapter;
import com.b2w.lodjinha.base.holder.ViewWrapper;
import com.b2w.lodjinha.home.view.adapter.categoria.CategoriaItem;
import com.b2w.lodjinha.home.view.adapter.categoria.CategoriaItem_;
import com.b2w.lodjinha.rest.model.Produto;

import org.androidannotations.annotations.EBean;

@EBean
public class ProdutoAdapter extends BaseRecyclerAdapter<Produto> {

    @Override
    public ViewWrapper onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewWrapper(ProdutoItem_.build(mContext));
    }

    @Override
    public void onBindViewHolder(ViewWrapper holder, int position) {
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        holder.getView().setLayoutParams(lp);

        ((ProdutoItem) holder.getView()).bind(items.get(position), onItemClickListener);
    }
}

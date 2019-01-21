package com.b2w.lodjinha.home.view.adapter.categoria;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.b2w.lodjinha.base.adapter.BaseRecyclerAdapter;
import com.b2w.lodjinha.base.holder.ViewWrapper;
import com.b2w.lodjinha.home.view.adapter.produto.ProdutoItem;
import com.b2w.lodjinha.rest.model.Categoria;

import org.androidannotations.annotations.EBean;

@EBean
public class CategoriaAdapter extends BaseRecyclerAdapter<Categoria> {

    @Override
    public ViewWrapper onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewWrapper(CategoriaItem_.build(mContext));
    }

    @Override
    public void onBindViewHolder(ViewWrapper holder, int position) {
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        holder.getView().setLayoutParams(lp);

        ((CategoriaItem) holder.getView()).bind(items.get(position), onItemClickListener);
    }
}

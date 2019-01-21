package com.b2w.lodjinha.home.view.adapter.produto;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.b2w.lodjinha.R;
import com.b2w.lodjinha.base.adapter.BaseRecyclerAdapter;
import com.b2w.lodjinha.rest.model.Categoria;
import com.b2w.lodjinha.rest.model.Produto;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

@EViewGroup(R.layout.categoriaitem_layout)
public class ProdutoItem extends LinearLayout {

    @ViewById(R.id.txtCategoria)
    protected TextView txtCategoria;


    public ProdutoItem(@NonNull Context context) {
        super(context);
    }

    public ProdutoItem(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ProdutoItem(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ProdutoItem(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void bind(Produto produto, BaseRecyclerAdapter.OnItemClickListener<Produto> onItemClickListener) {
        txtCategoria.setText(produto.getDescricao());
    }
}

package com.b2w.lodjinha.home.view.adapter.categoria;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.b2w.lodjinha.R;
import com.b2w.lodjinha.base.adapter.BaseRecyclerAdapter;
import com.b2w.lodjinha.rest.model.Banner;
import com.b2w.lodjinha.rest.model.Categoria;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

@EViewGroup(R.layout.categoriaitem_layout)
public class CategoriaItem extends LinearLayout {

    @ViewById(R.id.imgFotoCategoria)
    protected ImageView imgCategoria;

    @ViewById(R.id.txtCategoria)
    protected TextView txtCategoria;


    public CategoriaItem(@NonNull Context context) {
        super(context);
    }

    public CategoriaItem(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CategoriaItem(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CategoriaItem(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void bind(Categoria categoria, BaseRecyclerAdapter.OnItemClickListener<Categoria> onItemClickListener) {
        Picasso.get()
                .load(categoria.getUrlImagem())
                .into(imgCategoria);
        txtCategoria.setText(categoria.getDescricao());
    }
}

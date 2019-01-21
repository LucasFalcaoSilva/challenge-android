package com.b2w.lodjinha.home.view.adapter.produto;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.b2w.lodjinha.R;
import com.b2w.lodjinha.base.adapter.BaseRecyclerAdapter;
import com.b2w.lodjinha.rest.model.Produto;
import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

@EViewGroup(R.layout.produtoitem_layout)
public class ProdutoItem extends LinearLayout {

    @ViewById(R.id.txtNomeProduto)
    protected TextView txtDescricao;

    @ViewById(R.id.imgFotoProduto)
    protected ImageView imgFotoProduto;

    @ViewById(R.id.txtDe)
    protected TextView txtValorAntigo;

    @ViewById(R.id.txtPor)
    protected TextView txtValorNovo;

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
        txtDescricao.setText(produto.getNome());
        txtValorAntigo.setText("De: " + formatarValor(produto.getPrecoDe()));
        txtValorNovo.setText("Por: " + formatarValor(produto.getPrecoPor()));

        Picasso.get()
                .load(produto.getUrlImagem())
                .centerCrop().resize(100, 100)
                .placeholder(R.mipmap.ic_wait)
                .error(R.mipmap.ic_launcher)
                .into(imgFotoProduto);
    }

    public String formatarValor(Double valor) {
        BigDecimal valorFormat = new BigDecimal(valor);
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        return nf.format(valorFormat);
    }
}

package com.b2w.lodjinha.categoria.view;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.b2w.lodjinha.R;
import com.b2w.lodjinha.categoria.contract.CategoriaMVP;
import com.b2w.lodjinha.categoria.presenter.CategoriaPresenter;
import com.b2w.lodjinha.home.view.adapter.produto.ProdutoAdapter;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_categoria)
public class CategoriaActivity extends AppCompatActivity implements CategoriaMVP.CategoriaView {

    @Bean
    protected CategoriaPresenter mCategoriaPresenter;

    @ViewById(R.id.rvProdutos)
    protected RecyclerView rvProdutos;

    @ViewById(R.id.pg_produtos)
    protected ProgressBar pgProdutos;

    @Extra
    protected Long idCategoria;

    @Extra
    protected String nomeCategoria;

    @AfterInject
    protected void iniciarCategoria() {
        mCategoriaPresenter.setCategoriaView(this);
    }

    @AfterViews
    protected void carregarCategoria() {

        pgProdutos.setVisibility(View.VISIBLE);
        rvProdutos.setVisibility(View.GONE);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle(nomeCategoria);

        rvProdutos.setLayoutManager( new LinearLayoutManager(this));
        rvProdutos.setItemAnimator(new DefaultItemAnimator());
        rvProdutos.setHasFixedSize(true);

        mCategoriaPresenter.carregarProdutosCategoria(idCategoria);
    }

    @Override
    public void carregarProdutos(ProdutoAdapter produtoAdapter) {
        rvProdutos.setAdapter(produtoAdapter);
        produtoAdapter.notifyDataSetChanged();

        pgProdutos.setVisibility(View.GONE);
        rvProdutos.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
}

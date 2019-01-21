package com.b2w.lodjinha.categoria.presenter;

import com.b2w.lodjinha.base.service.CallBackGeneric;
import com.b2w.lodjinha.categoria.contract.CategoriaMVP;
import com.b2w.lodjinha.home.view.adapter.produto.ProdutoAdapter;
import com.b2w.lodjinha.repository.ProdutoRepository;
import com.b2w.lodjinha.rest.model.Produto;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.util.List;

@EBean
public class CategoriaPresenter implements CategoriaMVP.CategoriaPresenter {

    private CategoriaMVP.CategoriaView categoriaView;

    @Bean
    protected ProdutoRepository mProdutoRepository;

    @Bean
    protected ProdutoAdapter produtoAdapter;

    @Override
    public void setCategoriaView(CategoriaMVP.CategoriaView categoriaView) {
        this.categoriaView = categoriaView;
    }

    @Override
    public void carregarProdutosCategoria(Long idCategoria){
        mProdutoRepository.obterProdutoCategoria(new CallBackGeneric<List<Produto>>() {
            @Override
            public void callBackSuccess(List<Produto> response) {
                produtoAdapter.setItemsLista(response);
                categoriaView.carregarProdutos(produtoAdapter);
            }

            @Override
            public void callBackError(String response) {

            }
        },idCategoria);
    }
}

package com.b2w.lodjinha.categoria.contract;

import com.b2w.lodjinha.home.view.adapter.produto.ProdutoAdapter;

public interface CategoriaMVP {

    interface CategoriaView{

        void carregarProdutos(ProdutoAdapter produtoAdapter);
    }

    interface CategoriaPresenter{

        void setCategoriaView(CategoriaView categoriaView);

        void carregarProdutosCategoria(Long idCategoria);
    }
}

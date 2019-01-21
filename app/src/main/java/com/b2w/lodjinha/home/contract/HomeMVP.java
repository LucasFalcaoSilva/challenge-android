package com.b2w.lodjinha.home.contract;

import com.b2w.lodjinha.home.view.adapter.banner.SlidingImageAdapter;
import com.b2w.lodjinha.home.view.adapter.categoria.CategoriaAdapter;
import com.b2w.lodjinha.home.view.adapter.produto.ProdutoAdapter;

import org.androidannotations.annotations.UiThread;

public interface HomeMVP {
    interface HomeView{

        void carregarAdapter(SlidingImageAdapter slidingImageAdapter);

        void carregarCategoriaAdapter(CategoriaAdapter mCategoriaAdapter);

        void carregarProdutosAdapter(ProdutoAdapter mProdutoAdapter);
    }
    interface HomePresenter{

        void setView(HomeView view);

        void carregarBanners();

        void carregarCategorias();

        void carregarProdutosMaisVendidos();

        void carregarHome();
    }
}

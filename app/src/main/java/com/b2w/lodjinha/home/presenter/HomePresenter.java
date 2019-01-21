package com.b2w.lodjinha.home.presenter;

import android.content.Context;

import com.b2w.lodjinha.base.adapter.BaseRecyclerAdapter;
import com.b2w.lodjinha.base.service.CallBackGeneric;
import com.b2w.lodjinha.categoria.view.CategoriaActivity_;
import com.b2w.lodjinha.home.contract.HomeMVP;
import com.b2w.lodjinha.home.view.adapter.banner.SlidingImageAdapter;
import com.b2w.lodjinha.home.view.adapter.categoria.CategoriaAdapter;
import com.b2w.lodjinha.home.view.adapter.produto.ProdutoAdapter;
import com.b2w.lodjinha.repository.BannerRepository;
import com.b2w.lodjinha.repository.CategoriaRepository;
import com.b2w.lodjinha.repository.ProdutoRepository;
import com.b2w.lodjinha.rest.model.Banner;
import com.b2w.lodjinha.rest.model.Categoria;
import com.b2w.lodjinha.rest.model.Produto;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.List;

@EBean
public class HomePresenter implements HomeMVP.HomePresenter {

    private HomeMVP.HomeView view;

    @RootContext
    protected Context mContext;

    @Bean
    protected BannerRepository mBannerRepository;

    @Bean
    protected CategoriaRepository mCategoriaRepository;

    @Bean
    protected ProdutoRepository mProdutoRepository;

    @Bean
    protected SlidingImageAdapter mSlidingImageAdapter;

    @Bean
    protected CategoriaAdapter mCategoriaAdapter;

    @Bean
    protected ProdutoAdapter mProdutoAdapter;

    @Override
    public void setView(HomeMVP.HomeView view) {
        this.view = view;
    }

    @Override
    public void carregarHome() {
        carregarBanners();
        carregarCategorias();
        carregarProdutosMaisVendidos();
    }

    @Override
    public void carregarBanners() {
        mBannerRepository.obterBanner(new CallBackGeneric<List<Banner>>() {
            @Override
            public void callBackSuccess(List<Banner> response) {
                mSlidingImageAdapter.setItemsLista(response);
                view.carregarAdapter(mSlidingImageAdapter);
            }

            @Override
            public void callBackError(String response) {

            }
        });
    }

    @Override
    public void carregarCategorias() {
        mCategoriaRepository.obterCategoria(new CallBackGeneric<List<Categoria>>() {
            @Override
            public void callBackSuccess(List<Categoria> response) {
                mCategoriaAdapter.setItemsLista(response);
                mCategoriaAdapter.setOnItemClickListener(new BaseRecyclerAdapter.OnItemClickListener<Categoria>() {
                    @Override
                    public void onItemClick(Categoria item) {
                        CategoriaActivity_.intent(mContext)
                                .idCategoria(item.getId())
                                .nomeCategoria(item.getDescricao())
                                .start();
                    }
                });
                view.carregarCategoriaAdapter(mCategoriaAdapter);
            }

            @Override
            public void callBackError(String response) {

            }
        });
    }

    @Override
    public void carregarProdutosMaisVendidos() {
        mProdutoRepository.obterProdutosMaisVendidos(new CallBackGeneric<List<Produto>>() {
            @Override
            public void callBackSuccess(List<Produto> response) {
                mProdutoAdapter.setItemsLista(response);
                view.carregarProdutosAdapter(mProdutoAdapter);
            }

            @Override
            public void callBackError(String response) {

            }
        });
    }
}

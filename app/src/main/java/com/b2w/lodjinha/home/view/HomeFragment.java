package com.b2w.lodjinha.home.view;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.b2w.lodjinha.R;
import com.b2w.lodjinha.home.contract.HomeMVP;
import com.b2w.lodjinha.home.presenter.HomePresenter;
import com.b2w.lodjinha.home.view.adapter.banner.SlidingImageAdapter;
import com.b2w.lodjinha.home.view.adapter.categoria.CategoriaAdapter;
import com.b2w.lodjinha.home.view.adapter.produto.ProdutoAdapter;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_home)
public class HomeFragment extends Fragment implements HomeMVP.HomeView {

    @ViewById(R.id.pagerIamgens)
    protected ViewPager mImageViewPager;

    @ViewById(R.id.tabDots)
    protected TabLayout tabLayout;

    @ViewById(R.id.rvCategorias)
    protected RecyclerView rvCategorias;

    @ViewById(R.id.rvProdutos)
    protected RecyclerView rvProdutos;

    @Bean
    protected HomePresenter homePresenter;

    @AfterInject
    public void iniciarHome() {
        homePresenter.setView(this);
    }

    @AfterViews
    public void carregarBanner() {
        tabLayout.setupWithViewPager(mImageViewPager, true);
        homePresenter.carregarHome();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rvCategorias.setLayoutManager(layoutManager);
    }

    @Override
    @UiThread
    public void carregarAdapter(SlidingImageAdapter slidingImageAdapter) {
        mImageViewPager.setAdapter(slidingImageAdapter);
        slidingImageAdapter.notifyDataSetChanged();
    }

    @Override
    @UiThread
    public void carregarCategoriaAdapter(CategoriaAdapter mCategoriaAdapter) {
        rvCategorias.setAdapter(mCategoriaAdapter);
        mCategoriaAdapter.notifyDataSetChanged();
    }

    @Override
    @UiThread
    public void carregarProdutosAdapter(ProdutoAdapter mProdutoAdapter) {
        rvProdutos.setAdapter(mProdutoAdapter);
        mProdutoAdapter.notifyDataSetChanged();
    }
}

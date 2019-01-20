package com.b2w.lodjinha.home.presenter;

import android.content.Context;

import com.b2w.lodjinha.home.contract.HomeMVP;
import com.b2w.lodjinha.sobre.view.SobreFragment_;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

@EBean
public class HomePresenter implements HomeMVP.HomePresenter {

    private HomeMVP.HomeView homeView;


    @RootContext
    protected Context mContext;

    @Override
    public void seView(HomeMVP.HomeView homeView) {
        this.homeView = homeView;
    }

    @Override
    public void carregarFragmentHome() {
        homeView.trocarFragment(null);
    }

    @Override
    public void carregarFragmentSobre() {
        homeView.trocarFragment(SobreFragment_.builder().build());
    }
}

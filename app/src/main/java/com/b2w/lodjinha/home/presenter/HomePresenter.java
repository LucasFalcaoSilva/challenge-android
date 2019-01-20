package com.b2w.lodjinha.home.presenter;

import com.b2w.lodjinha.home.contract.HomeMVP;

import org.androidannotations.annotations.EBean;

@EBean
public class HomePresenter implements HomeMVP.HomePresenter {

    private HomeMVP.HomeView homeView;

    @Override
    public void seView(HomeMVP.HomeView homeView) {
        this.homeView = homeView;
    }

    @Override
    public void carregarFragmentHome() {

    }

    @Override
    public void carregarFragmentSobre() {

    }
}

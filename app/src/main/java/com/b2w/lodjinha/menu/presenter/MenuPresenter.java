package com.b2w.lodjinha.menu.presenter;

import android.content.Context;

import com.b2w.lodjinha.menu.contract.MenuMVP;
import com.b2w.lodjinha.sobre.view.SobreFragment_;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

@EBean
public class MenuPresenter implements MenuMVP.HomePresenter {

    private MenuMVP.HomeView menuView;


    @RootContext
    protected Context mContext;

    @Override
    public void seView(MenuMVP.HomeView homeView) {
        this.menuView = homeView;
    }

    @Override
    public void carregarFragmentHome() {
        menuView.trocarFragment(null);
    }

    @Override
    public void carregarFragmentSobre() {
        menuView.trocarFragment(SobreFragment_.builder().build());
    }
}

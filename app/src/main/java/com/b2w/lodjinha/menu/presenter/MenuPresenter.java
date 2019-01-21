package com.b2w.lodjinha.menu.presenter;

import android.content.Context;

import com.b2w.lodjinha.home.view.HomeFragment_;
import com.b2w.lodjinha.menu.contract.MenuMVP;
import com.b2w.lodjinha.sobre.view.SobreFragment_;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

@EBean
public class MenuPresenter implements MenuMVP.MenuPresenter {

    private MenuMVP.MenuView menuView;


    @RootContext
    protected Context mContext;

    @Override
    public void seView(MenuMVP.MenuView menuView) {
        this.menuView = menuView;
    }

    @Override
    public void carregarFragmentHome() {
        menuView.trocarFragment(HomeFragment_.builder().build());
    }

    @Override
    public void carregarFragmentSobre() {
        menuView.trocarFragment(SobreFragment_.builder().build());
    }
}

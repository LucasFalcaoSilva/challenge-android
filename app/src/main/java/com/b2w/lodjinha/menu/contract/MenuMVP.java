package com.b2w.lodjinha.menu.contract;

import android.support.v4.app.Fragment;

public interface MenuMVP {
    interface MenuPresenter {

        void seView(MenuView menuView);

        void carregarFragmentHome();

        void carregarFragmentSobre();
    }
    interface MenuView {

        void carregarMenuLateral();

        void trocarFragment(Fragment fragment);
    }
}

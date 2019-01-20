package com.b2w.lodjinha.home.contract;

import android.support.v4.app.Fragment;

public interface HomeMVP {
    interface HomePresenter{

        void seView(HomeView homeView);

        void carregarFragmentHome();

        void carregarFragmentSobre();
    }
    interface HomeView{

        void carregarMenuLateral();

        void trocarFragment(Fragment fragment);
    }
}

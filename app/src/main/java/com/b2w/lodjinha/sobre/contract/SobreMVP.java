package com.b2w.lodjinha.sobre.contract;

public interface SobreMVP {
    interface SobreView{

        void carregarData(String data);

        void carregarNome(String nomeDesenvolvedor);
    }
    interface SobrePresenter{

        void setView(SobreView view);

        void carregarInfoAPP();
    }
}

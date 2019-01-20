package com.b2w.lodjinha.sobre.presenter;

import com.b2w.lodjinha.sobre.contract.SobreMVP;

import org.androidannotations.annotations.EBean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@EBean
public class SobrePresenter implements SobreMVP.SobrePresenter {

    private SobreMVP.SobreView view;

    @Override
    public void setView(SobreMVP.SobreView view) {
        this.view = view;
    }

    @Override
    public void carregarInfoAPP() {
        view.carregarData(carregarDataDesenvolvimento());
        view.carregarNome("Lucas Miranda Silva");

    }

    private String carregarDataDesenvolvimento() {
        String datastr = "20/01/2019";

        Date data =  new Date(datastr);
        Locale local = new Locale("pt","BR");
        DateFormat formato = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy",local);

        return formato.format(data);
    }
}

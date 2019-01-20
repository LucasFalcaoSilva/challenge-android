package com.b2w.lodjinha.sobre.view;

import android.support.v4.app.Fragment;
import android.widget.TextView;

import com.b2w.lodjinha.R;
import com.b2w.lodjinha.sobre.contract.SobreMVP;
import com.b2w.lodjinha.sobre.presenter.SobrePresenter;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_sobre)
public class SobreFragment extends Fragment implements SobreMVP.SobreView {

    @Bean
    protected SobrePresenter sobrePresenter;

    @ViewById(R.id.txtData)
    protected TextView txtData;

    @ViewById(R.id.txtNome)
    protected TextView txtNome;

    public SobreFragment(){

    }

    @AfterInject
    public void iniciarSobre(){
        sobrePresenter.setView(this);
    }

    @AfterViews
    public void carregarSobre(){
        sobrePresenter.carregarInfoAPP();
    }

    @Override
    public void carregarData(String data){
        txtData.setText(data);
    }

    @Override
    public void carregarNome(String nomeDesenvolvedor){
        txtNome.setText(nomeDesenvolvedor);
    }

}

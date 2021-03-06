package com.b2w.lodjinha.repository;

import com.b2w.lodjinha.base.service.CallBackGeneric;
import com.b2w.lodjinha.rest.LodjinhaWService;
import com.b2w.lodjinha.rest.model.Banner;
import com.b2w.lodjinha.rest.model.Categoria;
import com.b2w.lodjinha.rest.model.DataBanner;
import com.b2w.lodjinha.rest.model.DataCategoria;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.util.List;

@EBean
public class CategoriaRepository {

    @Bean
    protected LodjinhaWService service;

    @Background
    public void obterCategoria(final CallBackGeneric<List<Categoria>> callBackGeneric) {
        service.obterCategoria(new CallBackGeneric<DataCategoria>() {
            @Override
            public void callBackSuccess(DataCategoria response) {
                callBackGeneric.callBackSuccess(response.getData());
            }

            @Override
            public void callBackError(String response) {
                callBackGeneric.callBackError(response);
            }
        });
    }
}

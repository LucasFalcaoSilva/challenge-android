package com.b2w.lodjinha.repository;

import com.b2w.lodjinha.base.service.CallBackGeneric;
import com.b2w.lodjinha.rest.LodjinhaWService;
import com.b2w.lodjinha.rest.model.DataProduto;
import com.b2w.lodjinha.rest.model.Produto;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.util.List;

@EBean
public class ProdutoRepository {

    @Bean
    protected LodjinhaWService service;

    @Background
    public void obterProdutosMaisVendidos(final CallBackGeneric<List<Produto>> callBackGeneric) {
        service.obterProdutosMaisVendidos(new CallBackGeneric<DataProduto>() {
            @Override
            public void callBackSuccess(DataProduto response) {
                callBackGeneric.callBackSuccess(response.getData());
            }

            @Override
            public void callBackError(String response) {
                callBackGeneric.callBackError(response);
            }
        });
    }

    @Background
    public void obterProdutoCategoria(final CallBackGeneric<List<Produto>> callBackGeneric, Long idCategoria) {
        service.obterProdutoCategoria(new CallBackGeneric<DataProduto>() {
            @Override
            public void callBackSuccess(DataProduto response) {
                callBackGeneric.callBackSuccess(response.getData());
            }

            @Override
            public void callBackError(String response) {
                callBackGeneric.callBackError(response);
            }
        }, idCategoria);
    }

    @Background
    public void obterProduto(final CallBackGeneric<List<Produto>> callBackGeneric, Long idProduto) {
        service.obterProduto(new CallBackGeneric<DataProduto>() {
            @Override
            public void callBackSuccess(DataProduto response) {
                callBackGeneric.callBackSuccess(response.getData());
            }

            @Override
            public void callBackError(String response) {
                callBackGeneric.callBackError(response);
            }
        }, idProduto);
    }
}

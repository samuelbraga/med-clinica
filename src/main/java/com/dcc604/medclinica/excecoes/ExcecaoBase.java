package com.dcc604.medclinica.excecoes;

public class ExcecaoBase extends RuntimeException {

    public ExcecaoBase(String mensagem) {
        super(mensagem);
    }
}

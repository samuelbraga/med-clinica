package com.dcc604.clinica.excecoes;

public class ExcecaoBase extends RuntimeException {

    public ExcecaoBase(String mensagem) {
        super(mensagem);
    }
}

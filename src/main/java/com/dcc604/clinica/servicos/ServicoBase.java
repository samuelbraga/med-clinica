package com.dcc604.clinica.servicos;

public interface ServicoBase<M, D> {
    M execute(D d);
}

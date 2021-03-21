package com.dcc604.medclinica.servicos;

public interface ServicoBase<M, D> {
    M execute(D d);
}

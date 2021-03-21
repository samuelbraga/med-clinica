package com.dcc604.medclinica;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constantes {
    public static final String ERRO_ATENDENTE_EXISTENTE = "Atendente já cadastrado";
    public static final String ERRO_MEDICO_EXISTENTE = "Medico já cadastrado";
    public static final String ERRO_AGENDA_EXISTENTE = "Agenda já cadastrada";
    public static final String ERRO_MEDICO_NAO_ENCONTRADO = "Medico não encontrado";
}

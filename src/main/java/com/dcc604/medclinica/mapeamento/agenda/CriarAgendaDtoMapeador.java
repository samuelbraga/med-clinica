package com.dcc604.medclinica.mapeamento.agenda;

import com.dcc604.medclinica.dtos.CriarAgendaDTO;
import io.swagger.model.CriarAgendaRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CriarAgendaDtoMapeador {
    CriarAgendaDTO fromCriarAgendaRequest(CriarAgendaRequest from);
}

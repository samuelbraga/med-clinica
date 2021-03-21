package com.dcc604.medclinica.mapeamento.agenda;

import com.dcc604.medclinica.modelos.Agenda;
import io.swagger.model.AgendaResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AgendaResponseMapeador {
    AgendaResponse fromAgenda(Agenda from);
}

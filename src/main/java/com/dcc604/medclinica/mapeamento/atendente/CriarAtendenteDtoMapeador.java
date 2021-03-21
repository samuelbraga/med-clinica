package com.dcc604.medclinica.mapeamento.atendente;

import com.dcc604.medclinica.dtos.CriarAtendenteDTO;
import io.swagger.model.CriarAtendenteRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CriarAtendenteDtoMapeador {
    CriarAtendenteDTO fromCriarAtendentesRequest(CriarAtendenteRequest from);
}

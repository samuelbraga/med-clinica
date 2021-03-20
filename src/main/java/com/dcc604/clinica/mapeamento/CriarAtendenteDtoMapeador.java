package com.dcc604.clinica.mapeamento;

import com.dcc604.clinica.dtos.CriarAtendenteDTO;
import io.swagger.model.CriarAtendenteRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CriarAtendenteDtoMapeador {
    CriarAtendenteDTO fromCriarAtendentesRequest(CriarAtendenteRequest from);
}

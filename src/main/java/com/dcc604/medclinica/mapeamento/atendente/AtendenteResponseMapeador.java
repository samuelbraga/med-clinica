package com.dcc604.medclinica.mapeamento.atendente;

import com.dcc604.medclinica.modelos.Atendente;
import io.swagger.model.AtendenteResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AtendenteResponseMapeador {
    AtendenteResponse fromAtendente(Atendente from);
}

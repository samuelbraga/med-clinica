package com.dcc604.medclinica.mapeamento.medico;

import com.dcc604.medclinica.dtos.CriarMedicoDTO;
import io.swagger.model.CriarMedicoRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CriarMedicoDtoMapeador {
    CriarMedicoDTO fromCriarMedicoRequest(CriarMedicoRequest from);
}

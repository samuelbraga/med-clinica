package com.dcc604.clinica.mapeamento.medico;

import com.dcc604.clinica.dtos.CriarMedicoDTO;
import io.swagger.model.CriarMedicoRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CriarMedicoDtoMapeador {
    CriarMedicoDTO fromCriarMedicoRequest(CriarMedicoRequest from);
}

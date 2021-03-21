package com.dcc604.medclinica.mapeamento.paciente;

import com.dcc604.medclinica.dtos.CriarPacienteDTO;
import io.swagger.model.CriarPacienteRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CriarPacienteDtoMapeador {
    CriarPacienteDTO fromCriarPacienteRequest(CriarPacienteRequest from);
}

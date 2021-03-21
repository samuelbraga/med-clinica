package com.dcc604.medclinica.mapeamento.paciente;

import com.dcc604.medclinica.modelos.Paciente;
import io.swagger.model.PacienteResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PacienteResponseMapeador {
    PacienteResponse fromPaciente(Paciente paciente);
}

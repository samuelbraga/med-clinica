package com.dcc604.clinica.mapeamento.medico;

import com.dcc604.clinica.modelos.Medico;
import io.swagger.model.MedicoResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MedicoResponseMapeador {
    MedicoResponse fromMedico(Medico from);
}

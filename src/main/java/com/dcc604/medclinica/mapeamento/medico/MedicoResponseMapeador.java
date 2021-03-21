package com.dcc604.medclinica.mapeamento.medico;

import com.dcc604.medclinica.modelos.Medico;
import io.swagger.model.MedicoResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MedicoResponseMapeador {
    MedicoResponse fromMedico(Medico from);
}

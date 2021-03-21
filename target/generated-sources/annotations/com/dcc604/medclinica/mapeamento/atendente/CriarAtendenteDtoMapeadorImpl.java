package com.dcc604.medclinica.mapeamento.atendente;

import com.dcc604.medclinica.dtos.CriarAtendenteDTO;
import io.swagger.model.CriarAtendenteRequest;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-20T20:06:07-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_282 (Private Build)"
)
@Component
public class CriarAtendenteDtoMapeadorImpl implements CriarAtendenteDtoMapeador {

    @Override
    public CriarAtendenteDTO fromCriarAtendentesRequest(CriarAtendenteRequest from) {
        if ( from == null ) {
            return null;
        }

        CriarAtendenteDTO criarAtendenteDTO = new CriarAtendenteDTO();

        criarAtendenteDTO.setCarteiraDeTrabalho( from.getCarteiraDeTrabalho() );
        criarAtendenteDTO.setDataContratacao( from.getDataContratacao() );
        criarAtendenteDTO.setNome( from.getNome() );
        criarAtendenteDTO.setCpf( from.getCpf() );
        criarAtendenteDTO.setSalario( from.getSalario() );
        criarAtendenteDTO.setFuncao( from.getFuncao() );
        criarAtendenteDTO.setTurno( from.getTurno() );

        return criarAtendenteDTO;
    }
}

package com.dcc604.medclinica.mapeamento.medico;

import com.dcc604.medclinica.dtos.CriarMedicoDTO;
import io.swagger.model.CriarMedicoRequest;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-20T20:06:08-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_282 (Private Build)"
)
@Component
public class CriarMedicoDtoMapeadorImpl implements CriarMedicoDtoMapeador {

    @Override
    public CriarMedicoDTO fromCriarMedicoRequest(CriarMedicoRequest from) {
        if ( from == null ) {
            return null;
        }

        CriarMedicoDTO criarMedicoDTO = new CriarMedicoDTO();

        criarMedicoDTO.setCarteiraDeTrabalho( from.getCarteiraDeTrabalho() );
        criarMedicoDTO.setDataContratacao( from.getDataContratacao() );
        criarMedicoDTO.setNome( from.getNome() );
        criarMedicoDTO.setCpf( from.getCpf() );
        criarMedicoDTO.setSalario( from.getSalario() );
        criarMedicoDTO.setFuncao( from.getFuncao() );
        criarMedicoDTO.setCrm( from.getCrm() );
        criarMedicoDTO.setEspecialidade( from.getEspecialidade() );

        return criarMedicoDTO;
    }
}

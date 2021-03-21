package com.dcc604.medclinica.mapeamento.medico;

import com.dcc604.medclinica.modelos.Medico;
import io.swagger.model.MedicoResponse;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-20T20:06:07-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_282 (Private Build)"
)
@Component
public class MedicoResponseMapeadorImpl implements MedicoResponseMapeador {

    @Override
    public MedicoResponse fromMedico(Medico from) {
        if ( from == null ) {
            return null;
        }

        MedicoResponse medicoResponse = new MedicoResponse();

        medicoResponse.setId( from.getId() );
        medicoResponse.setCarteiraDeTrabalho( from.getCarteiraDeTrabalho() );
        medicoResponse.setDataContratacao( from.getDataContratacao() );
        medicoResponse.setNome( from.getNome() );
        medicoResponse.setCpf( from.getCpf() );
        medicoResponse.setSalario( from.getSalario() );
        medicoResponse.setFuncao( from.getFuncao() );
        medicoResponse.setCrm( from.getCrm() );
        medicoResponse.setEspecialidade( from.getEspecialidade() );
        if ( from.getDataCriacao() != null ) {
            medicoResponse.setDataCriacao( LocalDateTime.ofInstant( from.getDataCriacao().toInstant(), ZoneOffset.UTC ).toLocalDate() );
        }
        if ( from.getDataAtualizacao() != null ) {
            medicoResponse.setDataAtualizacao( LocalDateTime.ofInstant( from.getDataAtualizacao().toInstant(), ZoneOffset.UTC ).toLocalDate() );
        }

        return medicoResponse;
    }
}

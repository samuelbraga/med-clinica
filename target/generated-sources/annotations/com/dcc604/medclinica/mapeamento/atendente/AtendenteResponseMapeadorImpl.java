package com.dcc604.medclinica.mapeamento.atendente;

import com.dcc604.medclinica.modelos.Atendente;
import io.swagger.model.AtendenteResponse;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-20T20:06:08-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_282 (Private Build)"
)
@Component
public class AtendenteResponseMapeadorImpl implements AtendenteResponseMapeador {

    @Override
    public AtendenteResponse fromAtendente(Atendente from) {
        if ( from == null ) {
            return null;
        }

        AtendenteResponse atendenteResponse = new AtendenteResponse();

        atendenteResponse.setId( from.getId() );
        atendenteResponse.setCarteiraDeTrabalho( from.getCarteiraDeTrabalho() );
        atendenteResponse.setDataContratacao( from.getDataContratacao() );
        atendenteResponse.setNome( from.getNome() );
        atendenteResponse.setCpf( from.getCpf() );
        atendenteResponse.setSalario( from.getSalario() );
        atendenteResponse.setFuncao( from.getFuncao() );
        atendenteResponse.setTurno( from.getTurno() );
        if ( from.getDataCriacao() != null ) {
            atendenteResponse.setDataCriacao( LocalDateTime.ofInstant( from.getDataCriacao().toInstant(), ZoneOffset.UTC ).toLocalDate() );
        }
        if ( from.getDataAtualizacao() != null ) {
            atendenteResponse.setDataAtualizacao( LocalDateTime.ofInstant( from.getDataAtualizacao().toInstant(), ZoneOffset.UTC ).toLocalDate() );
        }

        return atendenteResponse;
    }
}

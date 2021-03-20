package com.dcc604.clinica.controladores;

import com.dcc604.clinica.dtos.CriarAtendenteDTO;
import com.dcc604.clinica.mapeamento.AtendenteResponseMapeador;
import com.dcc604.clinica.mapeamento.CriarAtendenteDtoMapeador;
import com.dcc604.clinica.modelos.Atendente;
import com.dcc604.clinica.servicos.ServicoBase;
import io.swagger.api.AtendentesApi;
import io.swagger.model.AtendenteResponse;
import io.swagger.model.CriarAtendenteRequest;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ControladorAtendente implements AtendentesApi {
    @Qualifier("criarAtendenteService")
    private final ServicoBase<Atendente, CriarAtendenteDTO> criarAtendenteService;

    private final CriarAtendenteDtoMapeador requestMapeador;
    private final AtendenteResponseMapeador responseMapeador;

    @Override
    public ResponseEntity<AtendenteResponse> create(@Valid @RequestBody CriarAtendenteRequest body) {
        CriarAtendenteDTO atendenteDTO = requestMapeador.fromCriarAtendentesRequest(body);
        Atendente atendente = criarAtendenteService.execute(atendenteDTO);
        AtendenteResponse atendenteResponse = responseMapeador.fromAtendente(atendente);

        return new ResponseEntity<>(atendenteResponse, HttpStatus.CREATED);
    }
}

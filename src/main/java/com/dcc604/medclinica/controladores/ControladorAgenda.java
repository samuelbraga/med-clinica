package com.dcc604.medclinica.controladores;

import com.dcc604.medclinica.dtos.CriarAgendaDTO;
import com.dcc604.medclinica.mapeamento.agenda.AgendaResponseMapeador;
import com.dcc604.medclinica.mapeamento.agenda.CriarAgendaDtoMapeador;
import com.dcc604.medclinica.modelos.Agenda;
import com.dcc604.medclinica.servicos.ServicoBase;
import io.swagger.api.AgendaApi;
import io.swagger.model.AgendaResponse;
import io.swagger.model.CriarAgendaRequest;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ControladorAgenda implements AgendaApi {
    @Qualifier("criarAgendaService")
    private final ServicoBase<Agenda, CriarAgendaDTO> criarAgendaService;

    private final CriarAgendaDtoMapeador requestMapper;
    private final AgendaResponseMapeador responseMapeador;

    @Override
    public ResponseEntity<AgendaResponse> create(@Valid @RequestBody CriarAgendaRequest body) {
        CriarAgendaDTO criarAgendaDTO = requestMapper.fromCriarAgendaRequest(body);
        Agenda agenda = criarAgendaService.execute(criarAgendaDTO);
        AgendaResponse response = responseMapeador.fromAgenda(agenda);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}

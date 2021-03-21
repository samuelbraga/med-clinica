package com.dcc604.medclinica.controladores;

import com.dcc604.medclinica.dtos.CriarMedicoDTO;
import com.dcc604.medclinica.mapeamento.medico.CriarMedicoDtoMapeador;
import com.dcc604.medclinica.mapeamento.medico.MedicoResponseMapeador;
import com.dcc604.medclinica.modelos.Medico;
import com.dcc604.medclinica.servicos.ServicoBase;
import io.swagger.api.MedicoApi;
import io.swagger.model.CriarMedicoRequest;
import io.swagger.model.MedicoResponse;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ControladorMedico implements MedicoApi {
    @Qualifier("criarMedicoServico")
    private final ServicoBase<Medico, CriarMedicoDTO> criarMedicoService;

    private final CriarMedicoDtoMapeador requestMapper;
    private final MedicoResponseMapeador responseMapeador;

    @Override
    public ResponseEntity<MedicoResponse> create(@Valid @RequestBody CriarMedicoRequest body) {
        CriarMedicoDTO criarMedicoDTO = requestMapper.fromCriarMedicoRequest(body);
        Medico medico = criarMedicoService.execute(criarMedicoDTO);
        MedicoResponse medicoResponse = responseMapeador.fromMedico(medico);
        return new ResponseEntity<>(medicoResponse, HttpStatus.CREATED);
    }
}

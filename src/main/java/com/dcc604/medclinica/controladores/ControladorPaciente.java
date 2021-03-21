package com.dcc604.medclinica.controladores;

import static com.dcc604.medclinica.Constantes.HEADER_ATEMDETE_ID;

import com.dcc604.medclinica.dtos.CriarPacienteDTO;
import com.dcc604.medclinica.mapeamento.paciente.CriarPacienteDtoMapeador;
import com.dcc604.medclinica.mapeamento.paciente.PacienteResponseMapeador;
import com.dcc604.medclinica.modelos.Paciente;
import com.dcc604.medclinica.servicos.ServicoBase;
import io.swagger.api.PacienteApi;
import io.swagger.model.AtendenteResponse;
import io.swagger.model.CriarPacienteRequest;
import io.swagger.model.PacienteResponse;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ControladorPaciente implements PacienteApi {
    @Qualifier("criarPacienteServico")
    private final ServicoBase<Paciente, CriarPacienteDTO> criarPacienteServico;

    private final CriarPacienteDtoMapeador requestMapeador;
    private final PacienteResponseMapeador responseMapeador;

    @Override
    public ResponseEntity<PacienteResponse> criar(
        @RequestHeader(value = HEADER_ATEMDETE_ID) Integer xAtendenteId,
        @Valid @RequestBody CriarPacienteRequest body
    ) {
        CriarPacienteDTO criarPacienteDTO = requestMapeador.fromCriarPacienteRequest(body);
        criarPacienteDTO.setAtendenteId(xAtendenteId);
        Paciente paciente = criarPacienteServico.execute(criarPacienteDTO);
        PacienteResponse pacienteResponse = responseMapeador.fromPaciente(paciente);
        return new ResponseEntity<>(pacienteResponse, HttpStatus.CREATED);
    }
}

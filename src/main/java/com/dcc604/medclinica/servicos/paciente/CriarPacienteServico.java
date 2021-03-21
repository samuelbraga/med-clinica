package com.dcc604.medclinica.servicos.paciente;

import static com.dcc604.medclinica.Constantes.ERRO_ATENDENTE_NAO_ENCONTRADO;
import static com.dcc604.medclinica.Constantes.ERRO_PACIENTE_EXISTENTE;

import com.dcc604.medclinica.dtos.CriarPacienteDTO;
import com.dcc604.medclinica.excecoes.ExcecaoBase;
import com.dcc604.medclinica.modelos.Paciente;
import com.dcc604.medclinica.repositorios.AtendenteRepositorio;
import com.dcc604.medclinica.repositorios.PacienteRepositorio;
import com.dcc604.medclinica.servicos.ServicoBase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service("criarPacienteServico")
@RequiredArgsConstructor
public class CriarPacienteServico implements ServicoBase<Paciente, CriarPacienteDTO> {
    private final PacienteRepositorio repositorio;
    private final AtendenteRepositorio atendenteRepositorio;

    @Override
    public Paciente execute(CriarPacienteDTO criarPacienteDTO) {
        if (existePaciente(criarPacienteDTO.getCpf())) throw new ExcecaoBase(ERRO_PACIENTE_EXISTENTE);

        if (!existeAtendente(criarPacienteDTO.getAtendenteId())) throw new ExcecaoBase(ERRO_ATENDENTE_NAO_ENCONTRADO);

        Paciente paciente = new Paciente(criarPacienteDTO);
        repositorio.save(paciente);
        return paciente;
    }

    private boolean existePaciente(String cpf) {
        return repositorio.findByCpf(cpf).isPresent();
    }

    private boolean existeAtendente(Integer id) {
        return atendenteRepositorio.findById(id).isPresent();
    }
}

package com.dcc604.medclinica.servicos.agenda;

import static com.dcc604.medclinica.Constantes.ERRO_AGENDA_EXISTENTE;
import static com.dcc604.medclinica.Constantes.ERRO_MEDICO_NAO_ENCONTRADO;

import com.dcc604.medclinica.dtos.CriarAgendaDTO;
import com.dcc604.medclinica.excecoes.ExcecaoBase;
import com.dcc604.medclinica.modelos.Agenda;
import com.dcc604.medclinica.modelos.Medico;
import com.dcc604.medclinica.repositorios.AgendaRepositorio;
import com.dcc604.medclinica.repositorios.MedicoRepositorio;
import com.dcc604.medclinica.servicos.ServicoBase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service("criarAgendaService")
@RequiredArgsConstructor
public class CriarAgendaService implements ServicoBase<Agenda, CriarAgendaDTO> {
    private final AgendaRepositorio repositorio;
    private final MedicoRepositorio medicoRepositorio;

    @Override
    public Agenda execute(CriarAgendaDTO criarAgendaDTO) {
        if (existeAgenda(criarAgendaDTO.getMedicoId())) throw new ExcecaoBase(ERRO_AGENDA_EXISTENTE);

        Medico medico = buscarMedico(criarAgendaDTO.getMedicoId());
        Agenda agenda = new Agenda();
        agenda.setMedico(medico);
        repositorio.save(agenda);
        return agenda;
    }

    private boolean existeAgenda(Integer id) {
        return this.repositorio.findByMedicoId(id).isPresent();
    }

    private Medico buscarMedico(Integer id) {
        return medicoRepositorio.findById(id).orElseThrow(() -> new ExcecaoBase(ERRO_MEDICO_NAO_ENCONTRADO));
    }
}

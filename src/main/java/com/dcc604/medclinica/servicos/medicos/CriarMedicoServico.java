package com.dcc604.medclinica.servicos.medicos;

import static com.dcc604.medclinica.Constantes.ERRO_MEDICO_EXISTENTE;

import com.dcc604.medclinica.dtos.CriarMedicoDTO;
import com.dcc604.medclinica.excecoes.ExcecaoBase;
import com.dcc604.medclinica.modelos.Medico;
import com.dcc604.medclinica.repositorios.MedicoRepositorio;
import com.dcc604.medclinica.servicos.ServicoBase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service("criarMedicoServico")
public class CriarMedicoServico implements ServicoBase<Medico, CriarMedicoDTO> {
    private final MedicoRepositorio repositorio;

    @Override
    public Medico execute(CriarMedicoDTO medicoDTO) {
        if (existeMedico(medicoDTO.getCpf()) || existeMedico(medicoDTO.getCarteiraDeTrabalho())) throw new ExcecaoBase(
            ERRO_MEDICO_EXISTENTE
        );

        Medico medico = new Medico(medicoDTO);
        repositorio.save(medico);
        return medico;
    }

    private boolean existeMedico(String cpf) {
        return repositorio.findByCpf(cpf).isPresent();
    }

    private boolean existeMedico(Integer carteiraDeTrabalho) {
        return repositorio.findByCarteiraDeTrabalho(carteiraDeTrabalho).isPresent();
    }
}

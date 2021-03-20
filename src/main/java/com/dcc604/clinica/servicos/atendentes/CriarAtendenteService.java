package com.dcc604.clinica.servicos.atendentes;

import static com.dcc604.clinica.Constantes.ERRO_ATENDENTE_EXISTE;

import com.dcc604.clinica.dtos.CriarAtendenteDTO;
import com.dcc604.clinica.excecoes.ExcecaoBase;
import com.dcc604.clinica.modelos.Atendente;
import com.dcc604.clinica.repositorios.AtendenteRepositorio;
import com.dcc604.clinica.servicos.ServicoBase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service("criarAtendenteService")
@RequiredArgsConstructor
public class CriarAtendenteService implements ServicoBase<Atendente, CriarAtendenteDTO> {
    private final AtendenteRepositorio repositorio;

    public Atendente execute(CriarAtendenteDTO atendenteDTO) {
        if (existeAtendente(atendenteDTO.getCarteiraDeTrabalho())) {
            throw new ExcecaoBase(ERRO_ATENDENTE_EXISTE);
        }
        Atendente atendente = new Atendente(atendenteDTO);
        repositorio.save(atendente);
        return atendente;
    }

    private boolean existeAtendente(Integer carteiraDeTrabalho) {
        return repositorio.findByCarteiraDeTrabalho(carteiraDeTrabalho).isPresent();
    }
}

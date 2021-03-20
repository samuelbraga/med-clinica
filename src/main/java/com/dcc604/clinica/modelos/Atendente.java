package com.dcc604.clinica.modelos;

import com.dcc604.clinica.dtos.CriarAtendenteDTO;
import javax.persistence.Entity;
import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Atendente extends Funcionario {
    private Integer turno;

    public Atendente(CriarAtendenteDTO criarAtendenteDTO) {
        this.carteiraDeTrabalho = criarAtendenteDTO.getCarteiraDeTrabalho();
        this.dataContratacao = criarAtendenteDTO.getDataContratacao();
        this.nome = criarAtendenteDTO.getNome();
        this.cpf = criarAtendenteDTO.getNome();
        this.salario = criarAtendenteDTO.getSalario();
        this.fucao = criarAtendenteDTO.getFucao();
        this.turno = criarAtendenteDTO.getTurno();
    }
}

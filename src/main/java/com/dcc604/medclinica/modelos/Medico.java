package com.dcc604.medclinica.modelos;

import com.dcc604.medclinica.dtos.CriarMedicoDTO;
import io.swagger.model.Especialidade;
import javax.persistence.Entity;
import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Medico extends Funcionario {
    private Integer crm;
    private Especialidade especialidade;

    public Medico(CriarMedicoDTO criarMedicoDTO) {
        this.carteiraDeTrabalho = criarMedicoDTO.getCarteiraDeTrabalho();
        this.dataContratacao = criarMedicoDTO.getDataContratacao();
        this.nome = criarMedicoDTO.getNome();
        this.cpf = criarMedicoDTO.getCpf();
        this.salario = criarMedicoDTO.getSalario();
        this.funcao = criarMedicoDTO.getFuncao();
        this.crm = criarMedicoDTO.getCrm();
        this.especialidade = criarMedicoDTO.getEspecialidade();
    }
}

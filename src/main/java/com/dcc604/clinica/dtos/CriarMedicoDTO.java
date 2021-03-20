package com.dcc604.clinica.dtos;

import io.swagger.model.Especialidade;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CriarMedicoDTO {
    private Integer carteiraDeTrabalho;
    private LocalDate dataContratacao;
    private String nome;
    private String cpf;
    private BigDecimal salario;
    private String funcao;
    private Integer crm;
    private Especialidade especialidade;
}

package com.dcc604.medclinica.modelos;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.*;
import lombok.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class Funcionario extends EntidadeBase {
    @Column(unique = true)
    protected Integer carteiraDeTrabalho;

    protected String cpf;
    protected LocalDate dataContratacao;
    protected String nome;
    protected BigDecimal salario;
    protected String funcao;
}

package com.dcc604.clinica.modelos;

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

    protected LocalDate dataContratacao;
    protected String nome;
    protected String cpf;
    protected BigDecimal salario;
    protected String fucao;
}

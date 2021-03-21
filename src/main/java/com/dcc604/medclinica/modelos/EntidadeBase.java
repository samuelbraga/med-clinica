package com.dcc604.medclinica.modelos;

import java.util.Date;
import javax.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Data
public abstract class EntidadeBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    protected Date dataCriacao;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    protected Date dataAtualizacao;
}

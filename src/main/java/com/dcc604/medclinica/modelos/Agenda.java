package com.dcc604.medclinica.modelos;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Agenda extends EntidadeBase {
    @OneToOne
    private Medico medico;
}

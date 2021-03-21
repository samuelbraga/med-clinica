package com.dcc604.medclinica.modelos;

import com.dcc604.medclinica.dtos.CriarPacienteDTO;
import java.time.LocalDate;
import javax.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Paciente extends EntidadeBase {
    private String cpf;
    private String nome;
    private LocalDate dataNascimento;
    private String celular;
    private String email;

    public Paciente(CriarPacienteDTO criarPacienteDTO) {
        this.cpf = criarPacienteDTO.getCpf();
        this.nome = criarPacienteDTO.getNome();
        this.dataNascimento = criarPacienteDTO.getDataNascimento();
        this.celular = criarPacienteDTO.getCelular();
        this.email = criarPacienteDTO.getEmail();
    }
}

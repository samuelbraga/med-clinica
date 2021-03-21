package com.dcc604.medclinica.dtos;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CriarPacienteDTO {
    private String cpf;
    private String nome;
    private LocalDate dataNascimento;
    private String celular;
    private String email;
    private Integer atendenteId;
}

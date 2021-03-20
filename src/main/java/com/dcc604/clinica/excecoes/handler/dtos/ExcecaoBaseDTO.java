package com.dcc604.clinica.excecoes.handler.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExcecaoBaseDTO {
    private String mensagem;

    public ExcecaoBaseDTO(String mensagem, String split) {
        this.mensagem = mensagem.split(split)[0];
    }
}

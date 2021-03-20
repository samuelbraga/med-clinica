package com.dcc604.clinica.excecoes.handler.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorBodyValidationDTO {
    private String field;
    private String message;
}

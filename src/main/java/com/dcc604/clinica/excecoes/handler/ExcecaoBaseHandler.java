package com.dcc604.clinica.excecoes.handler;

import com.dcc604.clinica.excecoes.ExcecaoBase;
import com.dcc604.clinica.excecoes.handler.dtos.ExcecaoBaseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExcecaoBaseHandler {

    @ExceptionHandler(ExcecaoBase.class)
    public ResponseEntity<ExcecaoBaseDTO> handle(ExcecaoBase excecaoBase) {
        ExcecaoBaseDTO excecaoBaseDTO = new ExcecaoBaseDTO(excecaoBase.getMessage());
        return new ResponseEntity<>(excecaoBaseDTO, HttpStatus.BAD_REQUEST);
    }
}

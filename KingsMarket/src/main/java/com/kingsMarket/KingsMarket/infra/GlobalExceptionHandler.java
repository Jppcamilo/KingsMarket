package com.kingsMarket.KingsMarket.infra;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroDeValidacaoModel> handleValidationErrors(MethodArgumentNotValidException ex) {

        List<ErroDeValidacaoModel.CampoErro> errosDeCampo = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(erro -> new ErroDeValidacaoModel.CampoErro(erro.getField(), erro.getDefaultMessage()))
                .collect(Collectors.toList());

        ErroDeValidacaoModel respostaErro = new ErroDeValidacaoModel(
                HttpStatus.BAD_REQUEST.value(),
                "Erro de validação nos dados enviados.",
                errosDeCampo
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respostaErro);
    }
}
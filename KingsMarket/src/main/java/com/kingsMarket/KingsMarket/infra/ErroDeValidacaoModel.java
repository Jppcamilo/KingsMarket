package com.kingsMarket.KingsMarket.infra;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ErroDeValidacaoModel {
    private LocalDateTime timestamp;
    private Integer status;
    private String erro;
    private List<CampoErro> campos;

    public ErroDeValidacaoModel(Integer status, String erro, List<CampoErro> campos) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.erro = erro;
        this.campos = campos;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class CampoErro {
        private String campo;
        private String mensagem;
    }
}
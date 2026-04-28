package com.kingsMarket.KingsMarket.projections;

import org.springframework.beans.factory.annotation.Value;
import java.math.BigDecimal;

public interface JogoProjection {
    Long getId();
    String getTitulo();
    BigDecimal getPreco();

    @Value("#{target.desenvolvedora.nome}")
    String getDesenvolvedoraNome();

    @Value("#{target.categoria.nome}")
    String getCategoriaNome();
}
package com.kingsMarket.KingsMarket.repository;

import com.kingsMarket.KingsMarket.model.JogoModel;
import com.kingsMarket.KingsMarket.projections.JogoProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface JogoRepository extends JpaRepository<JogoModel, Long> {

    Page<JogoProjection> findByPrecoLessThanEqual(BigDecimal precoMaximo, Pageable pageable);

    @Query("SELECT j FROM JogoModel j WHERE LOWER(j.titulo) LIKE LOWER(CONCAT('%', :termo, '%'))")
    Page<JogoProjection> buscarPorTermo(@Param("termo") String termo, Pageable pageable);
}
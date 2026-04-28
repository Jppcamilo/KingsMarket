package com.kingsMarket.KingsMarket.repository;

import com.kingsMarket.KingsMarket.model.CategoriaModel;
import com.kingsMarket.KingsMarket.projections.CategoriaProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {

    Page<CategoriaProjection> findByNomeContainingIgnoreCase(String nome, Pageable pageable);
}
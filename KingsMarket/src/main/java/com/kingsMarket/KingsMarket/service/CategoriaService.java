package com.kingsMarket.KingsMarket.service;

import com.kingsMarket.KingsMarket.model.CategoriaModel;
import com.kingsMarket.KingsMarket.projections.CategoriaProjection;
import com.kingsMarket.KingsMarket.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public List<CategoriaModel> listarTodas() {
        return repository.findAll();
    }

    public Optional<CategoriaModel> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public CategoriaModel salvar(CategoriaModel categoria) {
        return repository.save(categoria);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public Page<CategoriaProjection> buscarPorNome(String nome, Pageable pageable) {
        return repository.findByNomeContainingIgnoreCase(nome, pageable);
    }
}
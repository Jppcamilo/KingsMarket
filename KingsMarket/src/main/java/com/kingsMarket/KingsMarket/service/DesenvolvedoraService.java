package com.kingsMarket.KingsMarket.service;

import com.kingsMarket.KingsMarket.model.DesenvolvedoraModel;
import com.kingsMarket.KingsMarket.projections.DesenvolvedoraProjection;
import com.kingsMarket.KingsMarket.repository.DesenvolvedoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DesenvolvedoraService {

    @Autowired
    private DesenvolvedoraRepository repository;

    public List<DesenvolvedoraModel> listarTodas() {
        return repository.findAll();
    }

    public Optional<DesenvolvedoraModel> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public DesenvolvedoraModel salvar(DesenvolvedoraModel desenvolvedora) {
        return repository.save(desenvolvedora);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public Page<DesenvolvedoraProjection> buscarPorNome(String nome, Pageable pageable) {
        return repository.findByNomeContainingIgnoreCase(nome, pageable);
    }
}
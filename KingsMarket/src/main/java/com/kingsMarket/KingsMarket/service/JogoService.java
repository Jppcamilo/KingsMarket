package com.kingsMarket.KingsMarket.service;

import com.kingsMarket.KingsMarket.model.CategoriaModel;
import com.kingsMarket.KingsMarket.model.DesenvolvedoraModel;
import com.kingsMarket.KingsMarket.model.JogoModel;
import com.kingsMarket.KingsMarket.projections.JogoProjection;
import com.kingsMarket.KingsMarket.repository.CategoriaRepository;
import com.kingsMarket.KingsMarket.repository.DesenvolvedoraRepository;
import com.kingsMarket.KingsMarket.repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class JogoService {

    @Autowired
    private JogoRepository repository;

    @Autowired
    private DesenvolvedoraRepository desenvolvedoraRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<JogoModel> listarTodos() {
        return repository.findAll();
    }

    public Optional<JogoModel> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public JogoModel salvar(JogoModel jogo) {

        if (jogo.getDesenvolvedora() != null && jogo.getDesenvolvedora().getId() != null) {
            DesenvolvedoraModel devCompleta = desenvolvedoraRepository.findById(jogo.getDesenvolvedora().getId())
                    .orElseThrow(() -> new RuntimeException("Desenvolvedora não encontrada com este ID."));
            jogo.setDesenvolvedora(devCompleta);
        }

        if (jogo.getCategoria() != null && jogo.getCategoria().getId() != null) {
            CategoriaModel catCompleta = categoriaRepository.findById(jogo.getCategoria().getId())
                    .orElseThrow(() -> new RuntimeException("Categoria não encontrada com este ID."));
            jogo.setCategoria(catCompleta);
        }

        return repository.save(jogo);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public Page<JogoProjection> buscarPorTermo(String termo, Pageable pageable) {
        return repository.buscarPorTermo(termo, pageable);
    }

    public Page<JogoProjection> buscarPorPrecoMaximo(BigDecimal precoMaximo, Pageable pageable) {
        return repository.findByPrecoLessThanEqual(precoMaximo, pageable);
    }
}
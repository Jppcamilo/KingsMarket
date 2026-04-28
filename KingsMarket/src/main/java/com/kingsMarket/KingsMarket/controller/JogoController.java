package com.kingsMarket.KingsMarket.controller;

import com.kingsMarket.KingsMarket.model.JogoModel;
import com.kingsMarket.KingsMarket.projections.JogoProjection;
import com.kingsMarket.KingsMarket.service.JogoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;

import java.util.List;

@RestController
@RequestMapping("/api/jogos")
public class JogoController {

    @Autowired
    private JogoService service;

    @GetMapping
    public List<JogoModel> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<JogoModel> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public JogoModel criar(@RequestBody @Valid JogoModel jogo) {
        return service.salvar(jogo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JogoModel> atualizar(@PathVariable Long id, @RequestBody @Valid JogoModel dadosAtualizados) {
        return service.buscarPorId(id).map(jogo -> {
            jogo.setTitulo(dadosAtualizados.getTitulo());
            jogo.setDescricao(dadosAtualizados.getDescricao());
            jogo.setPreco(dadosAtualizados.getPreco());
            jogo.setDesenvolvedora(dadosAtualizados.getDesenvolvedora());

            return ResponseEntity.ok(service.salvar(jogo));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (service.buscarPorId(id).isPresent()) {
            service.deletar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/buscar")
    public ResponseEntity<Page<JogoProjection>> buscarPorTermo(
            @RequestParam String termo,
            Pageable pageable) {
        return ResponseEntity.ok(service.buscarPorTermo(termo, pageable));
    }

    @GetMapping("/preco-maximo")
    public ResponseEntity<Page<JogoProjection>> buscarPorPrecoMaximo(
            @RequestParam BigDecimal precoMaximo,
            Pageable pageable) {
        return ResponseEntity.ok(service.buscarPorPrecoMaximo(precoMaximo, pageable));
    }
}
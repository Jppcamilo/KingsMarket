package com.kingsMarket.KingsMarket.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kingsMarket.KingsMarket.model.CategoriaModel;
import com.kingsMarket.KingsMarket.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.kingsMarket.KingsMarket.projections.CategoriaProjection;

import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @GetMapping
    public List<CategoriaModel> listar() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaModel> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public CategoriaModel criar(@RequestBody @Valid CategoriaModel categoria) {
        return service.salvar(categoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaModel> atualizar(@PathVariable Long id, @RequestBody @Valid CategoriaModel dadosAtualizados) {
        return service.buscarPorId(id).map(categoria -> {
            categoria.setNome(dadosAtualizados.getNome());
            categoria.setDescricao(dadosAtualizados.getDescricao());
            return ResponseEntity.ok(service.salvar(categoria));
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
    public ResponseEntity<Page<CategoriaProjection>> buscarPorNome(
            @RequestParam String nome,
            Pageable pageable) {
        return ResponseEntity.ok(service.buscarPorNome(nome, pageable));
    }
}
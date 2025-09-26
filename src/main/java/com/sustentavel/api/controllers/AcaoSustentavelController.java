package com.sustentavel.api.controllers;

import com.sustentavel.api.dtos.AcaoSustentavelRequest;
import com.sustentavel.api.dtos.AcaoSustentavelResponse;
import com.sustentavel.api.enums.CategoriaAcao;
import com.sustentavel.api.services.AcaoSustentavelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acoes")
public class AcaoSustentavelController {

    @Autowired
    private AcaoSustentavelService service;

    @GetMapping
    public ResponseEntity<List<AcaoSustentavelResponse>> listarTodas() {
        List<AcaoSustentavelResponse> acoes = service.listarTodas();
        return ResponseEntity.ok(acoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AcaoSustentavelResponse> buscarPorId(@PathVariable Long id) {
        AcaoSustentavelResponse acao = service.buscarPorId(id);
        return ResponseEntity.ok(acao);
    }

    @PostMapping
    public ResponseEntity<AcaoSustentavelResponse> criar(@Valid @RequestBody AcaoSustentavelRequest request) {
        AcaoSustentavelResponse acao = service.criar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(acao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AcaoSustentavelResponse> atualizar(@PathVariable Long id,
                                                            @Valid @RequestBody AcaoSustentavelRequest request) {
        AcaoSustentavelResponse acao = service.atualizar(id, request);
        return ResponseEntity.ok(acao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/categoria")
    public ResponseEntity<List<AcaoSustentavelResponse>> buscarPorCategoria(@RequestParam("tipo") CategoriaAcao categoria) {
        List<AcaoSustentavelResponse> acoes = service.buscarPorCategoria(categoria);
        return ResponseEntity.ok(acoes);
    }
}
package com.sustentavel.api.services;

import com.sustentavel.api.dtos.AcaoSustentavelRequest;
import com.sustentavel.api.dtos.AcaoSustentavelResponse;
import com.sustentavel.api.entities.AcaoSustentavel;
import com.sustentavel.api.enums.CategoriaAcao;
import com.sustentavel.api.exceptions.RecursoNaoEncontradoException;
import com.sustentavel.api.repositories.AcaoSustentavelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AcaoSustentavelService {

    @Autowired
    private AcaoSustentavelRepository repository;

    public List<AcaoSustentavelResponse> listarTodas() {
        return repository.findAll()
                .stream()
                .map(this::entityParaResponse)
                .collect(Collectors.toList());
    }

    public AcaoSustentavelResponse buscarPorId(Long id) {
        AcaoSustentavel acao = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Ação sustentável não encontrada com ID: " + id));
        return entityParaResponse(acao);
    }

    public AcaoSustentavelResponse criar(AcaoSustentavelRequest request) {
        AcaoSustentavel acao = requestParaEntity(request);
        AcaoSustentavel acaoSalva = repository.save(acao);
        return entityParaResponse(acaoSalva);
    }

    public AcaoSustentavelResponse atualizar(Long id, AcaoSustentavelRequest request) {
        AcaoSustentavel acao = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Ação sustentável não encontrada com ID: " + id));

        acao.setTitulo(request.getTitulo());
        acao.setDescricao(request.getDescricao());
        acao.setCategoria(request.getCategoria());
        acao.setDataRealizacao(request.getDataRealizacao());
        acao.setResponsavel(request.getResponsavel());

        AcaoSustentavel acaoAtualizada = repository.save(acao);
        return entityParaResponse(acaoAtualizada);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new RecursoNaoEncontradoException("Ação sustentável não encontrada com ID: " + id);
        }
        repository.deleteById(id);
    }

    public List<AcaoSustentavelResponse> buscarPorCategoria(CategoriaAcao categoria) {
        return repository.findByCategoria(categoria)
                .stream()
                .map(this::entityParaResponse)
                .collect(Collectors.toList());
    }

    private AcaoSustentavelResponse entityParaResponse(AcaoSustentavel acao) {
        return new AcaoSustentavelResponse(
                acao.getId(),
                acao.getTitulo(),
                acao.getDescricao(),
                acao.getCategoria(),
                acao.getDataRealizacao(),
                acao.getResponsavel()
        );
    }

    private AcaoSustentavel requestParaEntity(AcaoSustentavelRequest request) {
        return new AcaoSustentavel(
                request.getTitulo(),
                request.getDescricao(),
                request.getCategoria(),
                request.getDataRealizacao(),
                request.getResponsavel()
        );
    }
}
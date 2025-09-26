package com.sustentavel.api.dtos;

import com.sustentavel.api.enums.CategoriaAcao;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class AcaoSustentavelRequest {

    @NotBlank(message = "Título é obrigatório")
    @Size(min = 3, max = 100, message = "Título deve ter entre 3 e 100 caracteres")
    private String titulo;

    @NotBlank(message = "Descrição é obrigatória")
    @Size(min = 10, max = 1000, message = "Descrição deve ter entre 10 e 1000 caracteres")
    private String descricao;

    @NotNull(message = "Categoria é obrigatória")
    private CategoriaAcao categoria;

    @NotNull(message = "Data de realização é obrigatória")
    @PastOrPresent(message = "Data de realização deve ser anterior ou igual à data atual")
    private LocalDate dataRealizacao;

    @NotBlank(message = "Responsável é obrigatório")
    @Size(min = 2, max = 100, message = "Nome do responsável deve ter entre 2 e 100 caracteres")
    private String responsavel;

    public AcaoSustentavelRequest() {
    }

    public AcaoSustentavelRequest(String titulo, String descricao, CategoriaAcao categoria, LocalDate dataRealizacao, String responsavel) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.categoria = categoria;
        this.dataRealizacao = dataRealizacao;
        this.responsavel = responsavel;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public CategoriaAcao getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaAcao categoria) {
        this.categoria = categoria;
    }

    public LocalDate getDataRealizacao() {
        return dataRealizacao;
    }

    public void setDataRealizacao(LocalDate dataRealizacao) {
        this.dataRealizacao = dataRealizacao;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }
}
package com.sustentavel.api.entities;

import com.sustentavel.api.enums.CategoriaAcao;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "acoes_sustentaveis")
public class AcaoSustentavel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String titulo;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CategoriaAcao categoria;

    @Column(name = "data_realizacao", nullable = false)
    private LocalDate dataRealizacao;

    @Column(nullable = false, length = 100)
    private String responsavel;

    public AcaoSustentavel() {
    }

    public AcaoSustentavel(String titulo, String descricao, CategoriaAcao categoria, LocalDate dataRealizacao, String responsavel) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.categoria = categoria;
        this.dataRealizacao = dataRealizacao;
        this.responsavel = responsavel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AcaoSustentavel that = (AcaoSustentavel) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "AcaoSustentavel{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", categoria=" + categoria +
                ", dataRealizacao=" + dataRealizacao +
                ", responsavel='" + responsavel + '\'' +
                '}';
    }
}
package com.sustentavel.api.repositories;

import com.sustentavel.api.entities.AcaoSustentavel;
import com.sustentavel.api.enums.CategoriaAcao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcaoSustentavelRepository extends JpaRepository<AcaoSustentavel, Long> {

    List<AcaoSustentavel> findByCategoria(CategoriaAcao categoria);
}
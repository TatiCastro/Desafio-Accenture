package com.accenture.plataformaCursos.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.plataformaCursos.entity.Aluno;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    @Query("SELECT inscricao.aluno FROM Inscricao inscricao WHERE inscricao.curso.id = :cursoId")
    List<Aluno> findAlunosByCursoId(@Param("cursoId") Long cursoId);

}

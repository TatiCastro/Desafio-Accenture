package com.accenture.plataformaCursos.repository;

import com.accenture.plataformaCursos.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CursoRepository extends JpaRepository<Curso, Long> {

    @Query("SELECT inscricao.curso FROM Inscricao inscricao WHERE inscricao.aluno.id = :alunoId")
    List<Curso> findCursosByAlunoId(@Param("alunoId") Long alunoId);

}

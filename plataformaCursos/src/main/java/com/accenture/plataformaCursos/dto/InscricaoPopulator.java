package com.accenture.plataformaCursos.dto;

import com.accenture.plataformaCursos.entity.Aluno;
import com.accenture.plataformaCursos.entity.Curso;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class InscricaoPopulator {

    public AlunoDTO toAlunoDTO(Aluno aluno) {

        if (aluno == null) {
            return null;
        }

        return new AlunoDTO(aluno.getId(), aluno.getNome(), aluno.getEmail());
    }

    public CursoDTO toCursoDTO(Curso curso) {

        if (curso == null) {
            return null;
        }

        return new CursoDTO(curso.getId(), curso.getNome(), curso.getDescricao());
    }

    public Set<AlunoDTO> toAlunoDTOSet(List<Aluno> alunos) {

        if (alunos == null) {
            return null;
        } else if (alunos.isEmpty()) {
            return new HashSet<>();
        }

        return alunos.stream()
                .map(this::toAlunoDTO)
                .collect(Collectors.toSet());
    }

    public Set<CursoDTO> toCursoDTOSet(List<Curso> cursos) {

        if (cursos == null) {
            return null;
        } else if (cursos.isEmpty()) {
            return new HashSet<>();
        }

        return cursos.stream()
                .map(this::toCursoDTO)
                .collect(Collectors.toSet());
    }

}

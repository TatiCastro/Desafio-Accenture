package com.accenture.plataformaCursos.service;

import com.accenture.plataformaCursos.dto.AlunoDTO;
import com.accenture.plataformaCursos.dto.CursoDTO;
import com.accenture.plataformaCursos.dto.InscricaoPopulator;
import com.accenture.plataformaCursos.entity.Curso;
import com.accenture.plataformaCursos.repository.AlunoRepository;
import com.accenture.plataformaCursos.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private InscricaoPopulator inscricaoPopulator;

    public Set<AlunoDTO> encontrarAlunosDoCurso(Long cursoId) {
        return inscricaoPopulator.toAlunoDTOSet(alunoRepository.findAlunosByCursoId(cursoId));
    }

    public CursoDTO criarCurso(Curso curso) {
        curso.setDataCriacao();
        return inscricaoPopulator.toCursoDTO(cursoRepository.save(curso));
    }

    public Set<CursoDTO> listarTodos() {
        return inscricaoPopulator.toCursoDTOSet(cursoRepository.findAll());
    }
}

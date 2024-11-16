package com.accenture.plataformaCursos.service;

import com.accenture.plataformaCursos.dto.AlunoDTO;
import com.accenture.plataformaCursos.dto.CursoDTO;
import com.accenture.plataformaCursos.dto.InscricaoPopulator;
import com.accenture.plataformaCursos.entity.Aluno;
import com.accenture.plataformaCursos.repository.CursoRepository;
import com.accenture.plataformaCursos.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private InscricaoPopulator inscricaoPopulator;

    public Set<CursoDTO> encontrarCursosDoAluno(Long alunoId) {
        return inscricaoPopulator.toCursoDTOSet(cursoRepository.findCursosByAlunoId(alunoId));
    }

    public AlunoDTO salvarAluno(Aluno aluno) {
        aluno.setDataCadastro();
        return inscricaoPopulator.toAlunoDTO(alunoRepository.save(aluno));
    }

    public Set<AlunoDTO> listarTodos() {
        return inscricaoPopulator.toAlunoDTOSet(alunoRepository.findAll()) ;
    }
}

package com.accenture.plataformaCursos.service;


import com.accenture.plataformaCursos.entity.Aluno;
import com.accenture.plataformaCursos.entity.Curso;
import com.accenture.plataformaCursos.entity.Inscricao;
import com.accenture.plataformaCursos.repository.AlunoRepository;
import com.accenture.plataformaCursos.repository.CursoRepository;
import com.accenture.plataformaCursos.repository.InscricaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InscricaoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private InscricaoRepository inscricaoRepository;

    public String inscrever(Long cursoId, Long alunoId) {
        Optional<Aluno> alunoOpt = alunoRepository.findById(alunoId);
        Optional<Curso> cursoOpt = cursoRepository.findById(cursoId);

        if (alunoOpt.isPresent() && cursoOpt.isPresent()) {
            Aluno aluno = alunoOpt.get();
            Curso curso = cursoOpt.get();

            Inscricao inscricao = new Inscricao(curso, aluno);

            inscricaoRepository.save(inscricao);

            return "Aluno inscrito no curso!";
        }

        return "Aluno ou Curso não encontrado!";
    }
}

package com.accenture.plataformaCursos.controller;

import com.accenture.plataformaCursos.dto.AlunoDTO;
import com.accenture.plataformaCursos.dto.CursoDTO;
import com.accenture.plataformaCursos.entity.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.accenture.plataformaCursos.service.AlunoService;

import java.util.Set;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping("/{alunoId}/cursos")
    public Set<CursoDTO> encontrarCursosDoAluno(@PathVariable Long alunoId) {
        return alunoService.encontrarCursosDoAluno(alunoId);
    }

    @PostMapping
    public AlunoDTO salvarAluno(@RequestBody Aluno aluno) {
        return alunoService.salvarAluno(aluno);
    }

}



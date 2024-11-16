package com.accenture.plataformaCursos.controller;

import com.accenture.plataformaCursos.dto.AlunoDTO;
import com.accenture.plataformaCursos.dto.CursoDTO;
import com.accenture.plataformaCursos.entity.Curso;
import com.accenture.plataformaCursos.service.CursoService;
import com.accenture.plataformaCursos.service.InscricaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private InscricaoService inscricaoService;

    @Autowired
    private CursoService cursoService;

    @GetMapping("/{cursoId}/alunos")
    public Set<AlunoDTO> encontrarAlunosDoCurso(@PathVariable Long cursoId) {
        return cursoService.encontrarAlunosDoCurso(cursoId);
    }

    @PostMapping
    public CursoDTO criarCurso(@RequestBody Curso curso) {
        return cursoService.criarCurso(curso);
    }

    @PostMapping("/inscrever/{cursoId}/{alunoId}")
    public String inscrever(@PathVariable Long cursoId, @PathVariable Long alunoId) {
        return inscricaoService.inscrever(cursoId, alunoId);
    }
}


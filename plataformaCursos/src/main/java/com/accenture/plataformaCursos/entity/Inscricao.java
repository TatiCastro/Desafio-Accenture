package com.accenture.plataformaCursos.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Inscricao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @Temporal(TemporalType.DATE)
    private Date dataInscricao;

    public Inscricao() {
    }

    public Inscricao(Curso curso, Aluno aluno) {
        this.curso = curso;
        this.aluno = aluno;
        setDataInscricao();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Date getDataInscricao() {
        return dataInscricao;
    }

    public void setDataInscricao() {
        this.dataInscricao = new java.util.Date();
    }
}

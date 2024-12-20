package com.accenture.plataformaCursos.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;

    @Temporal(TemporalType.DATE)
    private Date dataCriacao;

    @OneToMany(mappedBy = "curso")
    private Set<Inscricao> inscricoes = new HashSet<>();

    public Curso() {
    }

    public Curso(String nome, String descricao, Set<Inscricao> inscricoes) {
        this.nome = nome;
        this.descricao = descricao;
        this.inscricoes = inscricoes;
        setDataCriacao();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao() {
        this.dataCriacao = new java.util.Date();
    }

    public Set<Inscricao> getAlunos() {
        return inscricoes;
    }

    public void setAlunos(Set<Inscricao> inscricoes) {
        this.inscricoes = inscricoes;
    }
}

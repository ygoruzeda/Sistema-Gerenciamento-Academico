package br.com.ygor.model;

import java.util.List;

public class Disciplina {
    private int id;
    private String nome;
    private List<Curso> cursos;

    public Disciplina(String nome, List<Curso> cursos){
        this.nome = nome;
        this.cursos = cursos;
    }
    
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }    
    
}

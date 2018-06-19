package br.com.ygor.model;

public class Curso {
    private int id;
    private String nome;
    private Escola escola;
    
    public Curso(String nome, Escola escola){
        this.nome = nome;
        this.escola = escola;
    }

    public Curso() {}
    
    public int getId() {
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Escola getEscola() {
        return escola;
    }

    public void setEscola(Escola escola) {
        this.escola = escola;
    }    
    
}

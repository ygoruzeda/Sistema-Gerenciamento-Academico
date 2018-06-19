package br.com.ygor.model;

public class Escola {
    private int id;
    private String nome;
    
    public Escola(String nome){
        this.nome = nome;
    }
    
    public Escola(){}
    
    public int getId(){
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
}

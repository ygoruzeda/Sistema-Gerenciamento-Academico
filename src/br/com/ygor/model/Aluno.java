package br.com.ygor.model;

public class Aluno extends Pessoa{
    private int id;
    private Curso curso;
        
    public Aluno(){}
    
    public Aluno(String nome, String endereco, String telefone, Curso curso){
      super.setNome(nome);
      super.setEndereco(endereco);
      super.setTelefone(telefone);
      this.curso = curso;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }    

}

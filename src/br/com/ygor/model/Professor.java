package br.com.ygor.model;

import java.util.Date;
import java.util.List;

public class Professor extends Funcionario {
    private int id;
    private List<Escola> escolas;
    
    public Professor(String nome, int matricula, String endereco, String telefone,
        Date dataAdm, float salario, List<Escola> escolas){
        super.setNome(nome);
        super.setMatricula(matricula);
        super.setEndereco(endereco);
        super.setTelefone(telefone);
        super.setDataAdm(dataAdm);
        super.setSalario(salario);
        this.escolas = escolas;
    }
}

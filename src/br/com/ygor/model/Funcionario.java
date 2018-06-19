package br.com.ygor.model;

import java.util.Date;

public class Funcionario extends Pessoa {
    private Date dataAdm;
    private float salario;

    public Date getDataAdm() {
        return dataAdm;
    }

    public void setDataAdm(Date dataAdm) {
        this.dataAdm = dataAdm;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }    
    
}

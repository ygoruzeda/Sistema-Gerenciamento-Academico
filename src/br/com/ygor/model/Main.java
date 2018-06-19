package br.com.ygor.model;

import br.com.ygor.dao.EscolaDao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    
    public static void main(String []args){
        /*Date data = new Date();
        List<Escola> escolas = new ArrayList<Escola>(); 
        Escola e = new Escola("T.I");
        escolas.add(e);
        Professor p = new Professor("Ygor", 123, "Teste", "(75)98103-6116", data, 2500, escolas);
        
        System.out.println(p.getNome());;*/
        
        EscolaDao dao = new EscolaDao();
        Escola escola = new Escola("T.I");
        
        dao.insert(escola);
        
        
    }

}

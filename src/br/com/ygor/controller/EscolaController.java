package br.com.ygor.controller;

import br.com.ygor.dao.EscolaDao;
import br.com.ygor.model.Escola;
import br.com.ygor.view.EscolaView;
import java.util.List;


public class EscolaController implements Controller{
    private EscolaView view;
    private EscolaDao dao;          
    
    @Override
    public void start() {
        view = new EscolaView(this);
        dao = new EscolaDao();
        view.openView();
    }

    @Override
    public void insert() {
        Escola escola = new Escola(view.getNome());
        dao.insert(escola);        
    }
    
    @Override
    public void update(){
        Escola escola = new Escola(view.getNome());
        escola.setId(view.getId());
        dao.update(escola);
    }
    
    @Override
    public void delete(){
        if (!dao.hasRelationshipWithAnotherTable(view.getId()))
           dao.delete(view.getId());
        else
            view.msgExclusionNotAllowed();
        
    }
    
    @Override
    public List<Escola> listAll(){
        return dao.listAll();
    }   
}

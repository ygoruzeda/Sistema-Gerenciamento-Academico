package br.com.ygor.controller;

import br.com.ygor.dao.CursoDao;
import br.com.ygor.dao.EscolaDao;
import br.com.ygor.model.Curso;
import br.com.ygor.model.Escola;
import br.com.ygor.view.CursoView;
import java.util.List;

public class CursoController implements Controller {
    private CursoView view;
    private CursoDao dao;      
    private EscolaDao escolaDao;
    
    @Override
    public void start() {
        view = new CursoView(this);
        dao = new CursoDao();
        escolaDao = new EscolaDao();
        view.openView();
    }

    @Override
    public void insert() {
        Curso curso = new Curso(view.getNome(), view.getEscola());
        dao.insert(curso);        
    }
    
    @Override
    public void update(){
        Curso curso = new Curso(view.getNome(), view.getEscola());
        curso.setId(view.getId());
        dao.update(curso);
    }
    
    @Override
    public void delete(){
        if (!dao.hasRelationshipWithAnotherTable(view.getId()))
            dao.delete(view.getId());
        else
            view.msgExclusionNotAllowed();
    }
    
    @Override
    public List<Curso> listAll(){
        return dao.listAll();
    }
    
    public Escola returnEscola(int id){
        return escolaDao.returnEscola(id);
    }
    
    public List<Escola> returnEscolas(){
        return escolaDao.listAll();
    }
       
}

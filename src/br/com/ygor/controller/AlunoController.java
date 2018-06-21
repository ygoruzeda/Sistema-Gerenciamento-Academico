package br.com.ygor.controller;

import br.com.ygor.dao.AlunoDao;
import br.com.ygor.dao.CursoDao;
import br.com.ygor.model.Aluno;
import br.com.ygor.model.Curso;
import br.com.ygor.view.AlunoView;
import java.util.List;

public class AlunoController implements Controller {
    private AlunoView view;
    private AlunoDao dao;
    private CursoDao cursoDao;
    
    @Override
    public void start() {
        view = new AlunoView(this);
        dao = new AlunoDao();
        cursoDao = new CursoDao();
        view.openView();
    }

    @Override
    public void insert() {
        Aluno aluno = new Aluno(view.getNome(), view.getEndereco(), view.getTelefone(), view.getCurso());
        dao.insert(aluno);        
    }
    
    @Override
    public void update(){
        Aluno aluno = new Aluno(view.getNome(), view.getEndereco(), view.getTelefone(), view.getCurso());
        aluno.setId(view.getId());
        dao.update(aluno);
    }
    
    @Override
    public void delete(){
        dao.delete(view.getId());
    }
    
    @Override
    public List<Aluno> listAll(){
        return dao.listAll();
    }
    
    public List<Curso> returnCursos(){
        return cursoDao.listAll();
    }
    
    public Curso returnCurso(int idCurso){
        return cursoDao.returnCurso(idCurso);
    }
           

}

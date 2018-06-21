package br.com.ygor.dao;

import java.util.ArrayList;
import java.util.List;

public class ProfessorDao extends DaoConnection implements Dao, HasMatricula{

    @Override
    public void insert(Object object) {
        
    }

    @Override
    public void update(Object object) {
        
    }

    @Override
    public void delete(int id) {
        
    }

    @Override
    public List listAll() {
        return new ArrayList<>();
    }

    @Override
    public int returnLastMatricula() {
        return 0;
    }

}

package br.com.ygor.dao;

import java.util.List;

public interface Dao {
    
    public void insert(Object object);
    
    public void update(Object object);
    
    public void delete(int id);
    
    public List listAll();
    
    public void listForId(int id);
}

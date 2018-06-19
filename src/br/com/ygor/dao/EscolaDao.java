package br.com.ygor.dao;

import br.com.ygor.model.Curso;
import br.com.ygor.model.Escola;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EscolaDao extends DaoConnection implements Dao {

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
    public void listForId(int id) {
  
    }
    
    public Escola returnEscola(int id){
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM escola WHERE id = ?");
            stmt.setString(1, String.valueOf(id));
            ResultSet rs = stmt.executeQuery();
            Escola escola = new Escola();            
            
            while (rs.next()){
                escola.setId(Integer.valueOf(rs.getString("id")));
                escola.setNome(rs.getString("nome"));
            }
            
            rs.close();
            stmt.close();
            
            return escola;
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
}

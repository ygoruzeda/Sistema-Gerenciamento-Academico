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
        Escola escola = (Escola) object;
        
        String sql = "INSERT INTO escola (nome) VALUES (?)";
        
        try {
            PreparedStatement stmt = getConnection().prepareStatement(sql);
                          
            stmt.setString(1, escola.getNome());
                                   
            stmt.execute();
            stmt.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }        
    }
    @Override
    public void update(Object object) {
        Escola escola = (Escola) object;
        
        String sql = "UPDATE escola set nome = ? WHERE id = ?";
        
        try {
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            
            stmt.setString(1, escola.getNome());            
            stmt.setString(2, String.valueOf(escola.getId()));            
                        
            stmt.execute();
            stmt.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM escola WHERE id = ?";
        
        try {
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            
            stmt.setString(1, String.valueOf(id));            
            
            stmt.execute();
            stmt.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Escola> listAll() {
       try {
            ArrayList<Escola> escolas = new ArrayList<Escola>();
            PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM escola");
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                Escola escola = new Escola();
                escola.setId(Integer.valueOf(rs.getString("id")));
                escola.setNome(rs.getString("nome"));
                
                escolas.add(escola);
            }
            rs.close();
            stmt.close();
            
            return escolas;
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
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
    
    public boolean hasRelationshipWithAnotherTable(int id){
        try{
            PreparedStatement stmt = getConnection().prepareStatement("SELECT e.id FROM escola as e "
                    + "INNER JOIN curso AS c ON e.id = c.id_escola "
                    + "WHERE e.id = ?");
            stmt.setString(1, String.valueOf(id));
            ResultSet rs = stmt.executeQuery();
                
            boolean retorno = false;
            if (rs.next()){
                retorno = rs.getString(1) == null ? false : true;                                                     
            } 
            
            rs.close();
            stmt.close();     
            
            return retorno;
        } catch (SQLException e){
            throw new RuntimeException(e);
        }       
    }
    
}

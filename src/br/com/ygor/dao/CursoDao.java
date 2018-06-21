package br.com.ygor.dao;

import br.com.ygor.model.Curso;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursoDao extends DaoConnection implements Dao {
    private EscolaDao escolaDao = new EscolaDao();
    
    @Override
    public void insert(Object object) {
        Curso curso = (Curso) object;
        
        String sql = "INSERT INTO curso (nome, id_escola) VALUES (?, ?)";
        
        try {
            PreparedStatement stmt = getConnection().prepareStatement(sql);
                          
            stmt.setString(1, curso.getNome());
            stmt.setString(2, String.valueOf(curso.getEscola().getId()));
                       
            stmt.execute();
            stmt.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }        
    }

    @Override
    public void update(Object object) {
        Curso curso = (Curso) object;
        
        String sql = "UPDATE curso set nome = ?, escola_id = ? WHERE id = ?";
        
        try {
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            
            stmt.setString(1, curso.getNome());            
            stmt.setString(2, String.valueOf(curso.getEscola().getId()));            
            stmt.setString(3, String.valueOf(curso.getId()));
            
            stmt.execute();
            stmt.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
          
        String sql = "DELETE FROM curso WHERE id = ?";
        
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
    public List<Curso> listAll() {
        try {
            ArrayList<Curso> cursos = new ArrayList<Curso>();
            PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM curso");
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                Curso curso = new Curso();
                curso.setId(Integer.valueOf(rs.getString("id")));
                curso.setNome(rs.getString("nome"));
                curso.setEscola(escolaDao.returnEscola(Integer.valueOf(rs.getString("id_escola"))));
                cursos.add(curso);
            }
            rs.close();
            stmt.close();
            
            return cursos;
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
  
    public Curso returnCurso(int id){
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM curso WHERE id = ?");
            stmt.setString(1, String.valueOf(id));
            ResultSet rs = stmt.executeQuery();
            Curso curso = new Curso();
                        
            while (rs.next()){
                curso.setId(Integer.valueOf(rs.getString("id")));
                curso.setNome(rs.getString("nome"));
                curso.setEscola(escolaDao.returnEscola(Integer.valueOf(rs.getString("id_escola"))));
            }
            rs.close();
            stmt.close();
            
            return curso;
        } catch(SQLException  e){
            throw new RuntimeException(e);
        }
    }
    
}

package br.com.ygor.dao;

import br.com.ygor.model.Aluno;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AlunoDao extends DaoConnection implements Dao, HasMatricula{
        
    @Override
    public void insert(Object object) {
        Aluno aluno = (Aluno) object;
        
        String sql = "INSERT INTO aluno " + 
                "(nome, matricula, endereco, telefone, id_curso) " +
                "VALUES (?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement stmt = getConnection().prepareStatement(sql);
                          
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, String.valueOf(returnLastMatricula()));
            stmt.setString(3, aluno.getEndereco());
            stmt.setString(4, aluno.getTelefone());
            stmt.setString(5, String.valueOf(aluno.getCurso().getId()));
                       
            stmt.execute();
            stmt.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }        
    }

    @Override
    public void update(Object object) {
        Aluno aluno = (Aluno) object;
        
        String sql = "UPDATE aluno set nome = ?, endereco = ?, telefone = ? WHERE id = ?";
        
        try {
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            
            stmt.setString(1, aluno.getNome());            
            stmt.setString(2, aluno.getEndereco());            
            stmt.setString(3, aluno.getTelefone());            
            stmt.setString(4, String.valueOf(aluno.getId()));
            
            stmt.execute();
            stmt.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
          
        String sql = "DELETE FROM aluno WHERE id = ?";
        
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
    public List<Aluno> listAll() {
        
        try {
            ArrayList<Aluno> alunos = new ArrayList<Aluno>();
            PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM aluno");
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                Aluno aluno = new Aluno();
                aluno.setId(Integer.valueOf(rs.getString("id")));
                aluno.setNome(rs.getString("nome"));
                
                alunos.add(aluno);
            }
            rs.close();
            stmt.close();
            
            return alunos;
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public void listForId(int id) {
        
    }
    
    @Override
    public int returnLastMatricula(){
                
        try{
            PreparedStatement stmt = getConnection().prepareStatement("SELECT max(matricula) as mat FROM aluno");
            ResultSet rs = stmt.executeQuery();
            Calendar calendar = Calendar.getInstance();
            
            int matricula = 0;
            if (rs.next()){
                matricula = rs.getString(1) == null ? (calendar.get(Calendar.YEAR) * 10) : 
                        (Integer.valueOf(rs.getString(1)) + 1);                                
            } 
            
            rs.close();
            stmt.close();     
            
            return matricula;
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

}

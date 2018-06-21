package br.com.ygor.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactoryTest {
    
    public static void main(String args[]) throws SQLException{
        Connection c = new ConnectionFactory().getConnection();
        System.out.println("Conexão aberta!");
        c.close();                
    }
    
}

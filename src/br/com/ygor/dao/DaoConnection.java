package br.com.ygor.dao;

import java.sql.Connection;

public class DaoConnection {
    private Connection connection = new ConnectionFactory().getConnection();

    public Connection getConnection() {
        return connection;
    }
   
}

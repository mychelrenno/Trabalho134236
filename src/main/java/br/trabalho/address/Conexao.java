package br.trabalho.address;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {

	private final String url = "jdbc:mysql://localhost/ecommercedb";
    private final String user = "root";
    private final String pass = "sucesso";
    private Connection connection;
    
    public Conexao(){
        
    }
    
    public Connection getConnection(){
        try {
            connection = DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }
}

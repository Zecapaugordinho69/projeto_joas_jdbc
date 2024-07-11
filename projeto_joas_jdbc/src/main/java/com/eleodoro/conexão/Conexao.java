package com.eleodoro.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private  String url = "jdbc:mysql://localhost:3306/caixa";
    private  String user = "root";
    private  String password = "escola";

    private Connection conn;

    public Connection getConexao() {


        try {
            if(conn == null) {
                conn = DriverManager.getConnection(url, user, password);
                System.out.println("Conectado com sucesso");
                return conn;
            } else {
                return conn;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro de conexao");
            return null;
        }
    }

    
}

package com.eleodoro.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.eleodoro.conexão.Conexao;
import com.eleodoro.modelo.Funcionario;

public class FuncionarioDao {
    

    private Funcionario funcionario;
    private final String SQLINCLUIR = "INSERT INTO FUNCIONARIO VALUES (?, ?, ?)";
    private final String SQLALTERAR = "UPDATE FUNCIONARIO SET LOGIN = ?, SENHA = ? WHERE NOME = ?";
    private final String SQLEXCLUIR = "DELETE FROM FUNCIONARIO WHERE NOME = ?";
    private final String SQLCONSULTAR = "SELECT * FROM FUNCIONARIO WHERE NOME = ?";

    public FuncionarioDao (Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public boolean incluir(){
         try {
            PreparedStatement ps = Conexao.getConexao () .PreparedStatement(SQLINCLUIR);
            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getLogin());
            ps.setString(3, funcionario.getSenha());
            ps.executeUpdate();
            return true;
         } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Não foi possivel incluir o funcionario");
            return false;
         }
    }

    public boolean alterar(){
        try {
           PreparedStatement ps = Conexao.getConexao () .PreparedStatement(SQLALTERAR);
           ps.setString(1, funcionario.getLogin());
           ps.setString(2, funcionario.getSenha());
           ps.setString(3, funcionario.getNome());
           ps.executeUpdate();
           return true;
        } catch (SQLException e) {
           e.printStackTrace();
           System.out.println("Não foi possivel alterar o funcionário");
           return false;
        }
   }

   public boolean excluir(){
    try {
       PreparedStatement ps = Conexao.getConexao () .PreparedStatement(SQLEXCLUIR);
       ps.setString(1, funcionario.getNome());
       ps.executeUpdate();
       return true;
    } catch (SQLException e) {
       e.printStackTrace();
       System.out.println("Não foi possivel excluir o funcionário");
       return false;
    }
}

public boolean consultar(){
    try {
       PreparedStatement ps = Conexao.getConexao () .PreparedStatement(SQLCONSULTAR);
       ps.setString(1, funcionario.getNome());
       ResultSet rs = ps.executeQuery();
       if (rs.next()) {
        funcionario.setLogin(rs.getString(2));
        funcionario.setSenha(rs.getString(3));
       }
       ps.executeUpdate();
       return true;
    } catch (SQLException e) {
       e.printStackTrace();
       System.out.println("Não foi possivel consultar o funcionario");
       return false;
    }
}
}

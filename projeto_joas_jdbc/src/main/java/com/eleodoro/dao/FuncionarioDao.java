package com.eleodoro.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.eleodoro.conexao.Conexao;

public class FuncionarioDao {

    /**
     * @param FuncionarioPojo
     */
    public void cadastrarFuncionario(FuncionarioPojo funcionarioPojo) {

        Conexao conexao = new Conexao();

        String sql = "insert into funcionario (nome, login, senha) values (?, ?, ?)";

        PreparedStatement ps = null;


        try {
            ps = conexao.getConexao().prepareStatement(sql);

            ps.setString(1, funcionarioPojo.getNome());
            ps.setString(2, funcionarioPojo.getLogin());
            ps.setString(3, funcionarioPojo.getSenha());

            ps.execute();
            ps.close();

            System.out.println("Dados gravados com sucesso");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Problema no método cadastrar funcionario no FuncionarioDao");
        }
    }

    public void consultarFuncionario(FuncionarioPojo funcionarioPojo) {

        Conexao conexao = new Conexao();

        String sql = "select * from funcionario where Id = ?";

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conexao.getConexao().prepareStatement(sql);

            ps = setInt(1, funcionarioPojo.getId());


            rs = ps.executeQuery();

            while (rs.next()) {

                funcionarioPojo.setId(rs.getInt(1));
                funcionarioPojo.setNome(rs.getString(2));
                funcionarioPojo.setLogin(rs.getString(3));
                funcionarioPojo.setSenha(rs.getString(4));
            }

            rs.close();
            ps.close();

            System.out.println("Consulta com sucesso");
        
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Problema no metodo consultar");
        }
    }

    private PreparedStatement setInt(int i, Object id) {
        //Auto-generated 
        throw new UnsupportedOperationException("Unimplemented method 'setInt'");
    }

    public void incluirFuncionario(FuncionarioPojo funcionarioPojo) {
        Conexao conexao = new Conexao();

        String sql = "update funcionario set nome = ?, login = ?, senha = ? where id = ?";

        PreparedStatement ps = null;

        try {
            ps = conexao.getConexao().prepareStatement(sql);

            ps.setString(1, funcionarioPojo.getNome());
            ps.setString(2, funcionarioPojo.getLogin());
            ps.setString(3, funcionarioPojo.getSenha());
            ps.setInt(4, (int) funcionarioPojo.getId());

            ps.execute();
            ps.close();

            System.out.println("Inclusão com sucesso");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Problema no metodo ao atualizar");
        }

    }


    public void excluirFuncionario(FuncionarioPojo funcionarioPojo) {
        Conexao conexao = new Conexao();

        String sql = "delete from funcionario where id = ?";

        PreparedStatement ps = null;

  
        try {
            ps = conexao.getConexao().prepareStatement(sql);

            ps.setInt(1, (int) funcionarioPojo.getId());

            ps.execute();
            ps.close();

            System.out.println("Exclusão com sucesso");
        
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Problema no método de exclusão");
        }
    }

    public void atualizarFuncionario(FuncionarioPojo funcionarioPojo) {
        // Auto-generated
        throw new UnsupportedOperationException("Unimplemented method 'atualizarFuncionario'");
    }
    
}

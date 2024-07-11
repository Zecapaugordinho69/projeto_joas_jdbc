package com.eleodoro;

import com.eleodoro.conexao.Conexao;
import com.eleodoro.dao.FuncionarioDao;
import com.eleodoro.dao.FuncionarioPojo;
import com.eleodoro.modelo.Funcionario;

public class FuncionarioApplication {

	public static void main(String[] args) {
		Conexao conexao  = new Conexao();
		conexao.getConexao();

		//inserção

		Funcionario funcionarioInserir = new Funcionario();
		funcionarioInserir.setNome("Joás");
		funcionarioInserir.setLogin("Joaixx");
		funcionarioInserir.setSenha("abc123");

		FuncionarioPojo funcionarioPojoInserir = new FuncionarioPojo();
		funcionarioPojoInserir.setNome(funcionarioInserir.getNome());
		funcionarioPojoInserir.setLogin(funcionarioInserir.getLogin());
		funcionarioPojoInserir.setSenha(funcionarioInserir.getSenha());

		FuncionarioDao funcionarioDaoInserir = new FuncionarioDao();
		funcionarioDaoInserir.cadastrarFuncionario(funcionarioPojoInserir);

		//consulta

		Funcionario funcionarioConsultar = new Funcionario();
		funcionarioConsultar.setId(1);

		FuncionarioPojo funcionarioPojoConsultar = new FuncionarioPojo();
		funcionarioPojoConsultar.setId(funcionarioConsultar.getId());

		FuncionarioDao funcionarioDaoConsultar = new FuncionarioDao();
		funcionarioDaoConsultar.consultarFuncionario(funcionarioPojoConsultar);

		System.out.println(funcionarioPojoConsultar.toString());

		//atualização 
		
		Funcionario funcionarioAtualizar = new Funcionario();
		funcionarioAtualizar.setId(1);
		funcionarioAtualizar.setNome("Joás Costa");
		funcionarioAtualizar.setLogin("Jowass");
		funcionarioAtualizar.setSenha("def456");

		FuncionarioPojo funcionarioPojoAtualizar = new FuncionarioPojo();
		funcionarioPojoAtualizar.setId(1);
		funcionarioPojoAtualizar.setNome(funcionarioAtualizar.getNome());
		funcionarioPojoAtualizar.setLogin(funcionarioAtualizar.getLogin());
		funcionarioPojoAtualizar.setSenha(funcionarioAtualizar.getSenha());

		FuncionarioDao funcionarioDaoAtualizar = new FuncionarioDao();
		funcionarioDaoAtualizar.atualizarFuncionario(funcionarioPojoAtualizar);

		//exclusão

		Funcionario funcionarioExcluir = new Funcionario();
		funcionarioExcluir.setId(1);

		FuncionarioPojo funcionarioPojoExcluir = new FuncionarioPojo();
		funcionarioPojoExcluir.setId(1);

		FuncionarioDao funcionarioDaoExcluir = new FuncionarioDao();
		funcionarioDaoExcluir.excluirFuncionario(funcionarioPojoExcluir);
	}

}

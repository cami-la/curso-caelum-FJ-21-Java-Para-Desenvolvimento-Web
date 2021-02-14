package br.com.caelum.jbdc.teste;

import java.sql.SQLException;

import br.com.caelum.jbdc.dao.ContatoDao;
import br.com.caelum.jbdc.modelo.Contato;

public class TesteAltera {

	public static void main(String[] args) throws SQLException {
		ContatoDao dao = new ContatoDao();
		Contato alterarContato = dao.pesquisar(1);
		alterarContato.setNome("Alura");
		alterarContato.setEmail("contato@alura.com.br");
		alterarContato.setEndereco("Rua alura, 115, fj21");
		
		dao.altera(alterarContato);
		
		System.out.println("Contato Alterado!");
		
	}

}

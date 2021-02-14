package br.com.caelum.jbdc.teste;

import java.sql.SQLException;

import br.com.caelum.jbdc.dao.ContatoDao;
import br.com.caelum.jbdc.modelo.Contato;

public class TestePesquisa {

	public static void main(String[] args) throws SQLException {
		ContatoDao dao = new ContatoDao();
		Contato pesquisaContato = dao.pesquisar(1);
		
		System.out.println(pesquisaContato);
	}

}

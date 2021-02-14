package br.com.caelum.jbdc.teste;

import java.sql.SQLException;

import br.com.caelum.jbdc.dao.ContatoDao;
import br.com.caelum.jbdc.modelo.Contato;

public class TesteRemove {

	public static void main(String[] args) throws SQLException {
		ContatoDao dao = new ContatoDao();
		Contato contatoARemover = dao.pesquisar(1);
		dao.remove(contatoARemover);
		
		System.out.println("Contato removido com sucesso!");
	}

}

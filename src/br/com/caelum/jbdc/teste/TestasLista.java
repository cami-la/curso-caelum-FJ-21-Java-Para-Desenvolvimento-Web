package br.com.caelum.jbdc.teste;

import java.sql.SQLException;
import java.util.List;

import br.com.caelum.jbdc.dao.ContatoDao;
import br.com.caelum.jbdc.modelo.Contato;

public class TestasLista {
	public static void main(String[] args) throws SQLException {
		ContatoDao dao = new ContatoDao();
		List<Contato> contatos = dao.getLista();
		
		contatos.stream().forEach(ct -> {
			System.out.println(ct.getNome());
			System.out.println(ct.getEmail());
			System.out.println(ct.getEndereco());			
			System.out.println(ct.getDataNascimentoFormatada());
		});
	}
}

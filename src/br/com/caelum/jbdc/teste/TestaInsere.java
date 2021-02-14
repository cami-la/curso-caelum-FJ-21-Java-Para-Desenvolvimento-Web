package br.com.caelum.jbdc.teste;

import java.sql.SQLException;
import java.util.Calendar;

import br.com.caelum.jbdc.dao.ContatoDao;
import br.com.caelum.jbdc.modelo.Contato;

public class TestaInsere {

	public static void main(String[] args) throws SQLException {
		//pronto para gravar
		Contato contato = new Contato();
		contato.setNome("Caelum");
		contato.setEmail("contato@caelum.com.br");
		contato.setEndereco("R. Vergueiro 3185 cj57");
		contato.setDataNascimento(Calendar.getInstance());
		
		//gravando nessa conexão
		ContatoDao dao = new ContatoDao();
		
		//adicionando o novo contato na conexão
		dao.adiciona(contato);
		System.out.println("Gravado!");
	}

}

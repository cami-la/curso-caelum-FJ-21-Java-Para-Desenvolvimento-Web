package br.com.caelum.jbdc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.jbdc.factory.ConnectionFactory;
import br.com.caelum.jbdc.modelo.Contato;

public class ContatoDao {
	
	private Connection connection;

	public ContatoDao() throws SQLException {
		Connection connection = new ConnectionFactory().getConnection();
		this.connection = connection;
	}
	
	public void adiciona(Contato contato) throws SQLException {
		String sql = "INSERT INTO contatos (nome, endereco, email, dataNascimento) VALUES (?, ?, ?, ?)";
		
		try(PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setString(1, contato.getNome());
			pstm.setString(2, contato.getEndereco());
			pstm.setString(3, contato.getEmail());
			pstm.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));

			pstm.execute();
		}
	}
	
	public List<Contato> getLista() throws SQLException {
		List<Contato> contatos = new ArrayList<Contato>();
		
		String sql = "SELECT id, nome, email, endereco, dataNascimento FROM contatos";
		
		try(PreparedStatement pstm = this.connection.prepareStatement(sql)) {
			pstm.execute();
			
			try(ResultSet rst = pstm.getResultSet()) {
				while(rst.next()) {
					//Criando o objeto Contato
					Contato contato = new Contato();
					contato.setId(rst.getLong(1));
					contato.setNome(rst.getString(2));
					contato.setEmail(rst.getString(3));
					contato.setEndereco(rst.getString(4));
					//montando a data através do Calendar
					Calendar data = Calendar.getInstance();
					data.setTime(rst.getDate("dataNascimento"));
					contato.setDataNascimento(data);
					
					contatos.add(contato);					
				}
			}
		}
		
		return contatos;
	}

	public Contato pesquisar(int id) throws SQLException {
		Contato contato = new Contato();
		
		String sql = "SELECT * FROM contatos WHERE id = ?";
		
		try(PreparedStatement pstm = this.connection.prepareStatement(sql)) {
			pstm.setLong(1, id);
			pstm.execute();
			
			try(ResultSet rst = pstm.getResultSet()) {
				while(rst.next()) {
					if (rst.getLong(1) == id) {
						contato.setId(rst.getLong(1));
						contato.setNome(rst.getString(2));
						contato.setEmail(rst.getString(3));
						contato.setEndereco(rst.getString(4));
						
						//montando a data através do Calendar
						Calendar data = Calendar.getInstance();
						data.setTime(rst.getDate("dataNascimento"));
						contato.setDataNascimento(data);
					}
				}
			}
		}
		return contato;
	}
}

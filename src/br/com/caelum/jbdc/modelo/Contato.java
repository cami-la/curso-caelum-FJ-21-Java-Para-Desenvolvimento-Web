package br.com.caelum.jbdc.modelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Contato {
	private Long id;
	private String nome;
	private String endereco;
	private String email;
	private Calendar dataNascimento;
	
	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNome() {
		return this.nome;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public String getEmail() {
		return this.email;
	}

	public Calendar getDataNascimento() {
		return this.dataNascimento;
	}
	
	public String getDataNascimentoFormatada() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String date = sdf.format(new Date());
		
		return date;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	@Override
	public String toString() {
		return String.format("%d - %s - %s - %s - %s", this.id, this.nome, this.email, this.endereco, this.getDataNascimentoFormatada());
	}

}

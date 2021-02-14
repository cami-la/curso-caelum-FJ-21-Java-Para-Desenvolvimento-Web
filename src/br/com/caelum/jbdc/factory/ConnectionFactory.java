package br.com.caelum.jbdc.factory;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	
	private ComboPooledDataSource dataSource;

	public ConnectionFactory() {
		ComboPooledDataSource comboPooledDatasource = new ComboPooledDataSource();
		comboPooledDatasource.setJdbcUrl("jdbc:mysql://localhost/fj21?useTimezone=true&serverTimezone=UTC");
		comboPooledDatasource.setUser("root");
		comboPooledDatasource.setPassword("260514");
		
		comboPooledDatasource.setMaxPoolSize(15);
		
		this.dataSource = comboPooledDatasource;
	}
	
	public Connection getConnection() throws SQLException {
		return this.dataSource.getConnection();
	}
}

package br.com.alura.library.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	public Connection getConnection() {

		try {
			String url = "jdbc:postgresql://localhost:5432/library";
			String user = "postgres";
			String password = "admin";
			
			//This line is necessary so that Tomcat manages to access the DB driver.
			Class.forName("org.postgresql.Driver");
			
			Connection connection = DriverManager.getConnection(url, user, password);
			return connection;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}

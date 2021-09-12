package br.com.alura.library.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.library.model.Author;

public class AuthorDao {

	private Connection connection;
	private String sql;
	
	public AuthorDao(Connection connection) {
		
		this.connection = connection;
	}
	
	public List<Author> getAuthors(){
		
		List<Author> authors = new ArrayList<>();
		
		sql = "SELECT * FROM authors;";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Author author = new Author();
				
				author.setName(rs.getString("name"));
				author.setBirthday(rs.getDate("birthday").toLocalDate());
				author.setEmail(rs.getString("email"));
				author.setResume(rs.getString("resume"));
				
				authors.add(author);
			}
			return authors; 
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new RuntimeException();
		}		
	}

	public void registerAuthor(Author author) {

		sql = "INSERT INTO authors (name, birthday, email, resume) values (?, ?, ?, ?);";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setString(1, author.getName());
			ps.setDate(2, Date.valueOf(author.getBirthday()));
			ps.setString(3, author.getEmail());
			ps.setString(4, author.getResume());
			
			ps.execute();
			
		} catch (SQLException e) {

			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
}
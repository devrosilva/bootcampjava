
package br.com.alura.library.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.library.dao.AuthorDao;
import br.com.alura.library.factory.ConnectionFactory;
import br.com.alura.library.model.Author;

@WebServlet("/")
public class AuthorServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private AuthorDao dao;
	
	public AuthorServlet() {
		
		this.dao = new AuthorDao(new ConnectionFactory().getConnection()); 
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("authors", dao.getAuthors());
		
		req.getRequestDispatcher("/WEB-INF/jsp/library.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			Author author = new Author();
			
			author.setName(req.getParameter("name"));
			author.setEmail(req.getParameter("email"));
			author.setBirthday(LocalDate.parse(req.getParameter("birthday")));
			author.setResume(req.getParameter("resume"));
			
			if( (author.getName().trim().length() > 0) && (author.getEmail().trim().length() > 0) && (author.getBirthday().toString().trim().length() > 0) ) {
				dao.registerAuthor(author);
			}
			resp.sendRedirect("library");
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			
			resp.sendRedirect("library");
		}

	}
}
package br.edu.utfpr;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(
		urlPatterns = { "/login" }, 
		initParams = { 
				@WebInitParam(name = "user", value = "root"), 
				@WebInitParam(name = "pwd", value = "qwerty")
		})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String userDefault = null; 
	private String pwdDefault = null;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		userDefault = config.getInitParameter("user");
	    pwdDefault = config.getInitParameter("pwd");
	}    
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String pwd = request.getParameter("password");
		
		if(user.equals(userDefault) && pwd.equals(pwdDefault)){
			request.getRequestDispatcher("/WEB-INF/imc.html")
			.forward(request, response);
		}
		else{
			response.sendRedirect("http://goo.gl/obybO7");
		}
	}

}

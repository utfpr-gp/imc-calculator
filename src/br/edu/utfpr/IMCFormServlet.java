package br.edu.utfpr;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/imc-form")
public class IMCFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Boolean isLoggedIn = (Boolean)request.getSession().getAttribute("isLoggedIn");
		if(isLoggedIn){
			String address = "/WEB-INF/view/imc.jsp";
			request.getRequestDispatcher(address)
			.forward(request, response);
		}
		else{
			response.sendRedirect("index.jsp"); 
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

package br.edu.utfpr;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.utfpr.model.IMCBean;


@WebServlet({ "/imc-calculator", "/calculadora-imc" })
public class IMCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {				
		processing(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		processing(request, response);		 
	}
	
	private void processing(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String weight = request.getParameter("weight");
		String height = request.getParameter("height");
		
		weight = weight.replaceAll(",", ".");
		height = height.replaceAll(",", ".");
				
		double weightDouble;
		double heightDouble;
		try{
			weightDouble = Double.parseDouble(weight);
			heightDouble = Double.parseDouble(height);
			
			IMCBean imcBean = new IMCBean(weightDouble, heightDouble);
			
			request.setAttribute("bean", imcBean);			
			
			request.getRequestDispatcher("/WEB-INF/view/result.jsp")
			.forward(request, response);			
		}
		catch (Exception e) {			
			throw new NumberFormatException("Problema de conversão numérica");
		}		
	}

}

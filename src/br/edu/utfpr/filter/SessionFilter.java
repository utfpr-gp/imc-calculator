package br.edu.utfpr.filter;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 
 * Filtro para redirecionar o usuário para o formulário de IMC caso ele já esteja logado.
 * Isso acontece quando ele tenta acessar o formulário de login.
 * 
 * @author Roni
 *
 */
@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD
		}
					, urlPatterns = {"/index.html" })
public class SessionFilter implements Filter {


	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Filtro");
		if(((HttpServletRequest)request).getSession(false) == null){
			System.out.println("sem sessão");
			chain.doFilter(request, response);
		}	
		else{
			System.out.println("com sessão");
			((HttpServletResponse)response).sendRedirect("imc-form");			
		}		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

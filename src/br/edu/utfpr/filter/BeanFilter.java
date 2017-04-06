package br.edu.utfpr.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.edu.utfpr.model.IMCBean;

/**
 * 
 * Cria a sessão, se inexistente. Adiciona o resultado de IMC corrente na lista
 * guardada na sessão no momento do retorno da resposta ao cliente.
 * 
 * Com isso, a lista de resultados enviada a página de resultados não contém o
 * resultado corrente.
 * 
 * @author Roni
 *
 */
@WebFilter(dispatcherTypes = { DispatcherType.REQUEST, DispatcherType.FORWARD }, urlPatterns = { "/imc-calculator" })
public class BeanFilter implements Filter {

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpSession session = ((HttpServletRequest)request).getSession();
		Boolean isLoggedIn = (Boolean)session.getAttribute("isLoggedIn");

		if (isLoggedIn == null) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {			
			List<IMCBean> beans = (List<IMCBean>) session.getAttribute("beans");

			if (beans == null) {
				beans = new ArrayList<>();
				session.setAttribute("beans", beans);
			}

			// pass the request along the filter chain
			chain.doFilter(request, response);

			IMCBean imcBean = (IMCBean) request.getAttribute("bean");
			beans.add(imcBean);
			session.setAttribute("beans", beans);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

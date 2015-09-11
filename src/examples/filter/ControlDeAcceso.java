package examples.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ControlDeAcceso implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		
		
		HttpSession httpsession = null;
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		
		
		if (null == (httpsession = request.getSession(false))){

			if(request.getRequestURI().equals("/WebHibernate/AutenticationServlet")){
				arg2.doFilter(arg0, arg1);
			}
			else {
				if(request.getRequestURI().equals("/WebHibernate/index.html")){
					arg2.doFilter(arg0, arg1);
				}
				else {
					response.sendRedirect("/WebHibernate/index.html");
				}
				
			}
			//if(request.getRequestURI().equals("/WebHibernate/ContenidoEstatico/*")){
				
			//}
		}
		
		else {
			arg2.doFilter(arg0, arg1);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}

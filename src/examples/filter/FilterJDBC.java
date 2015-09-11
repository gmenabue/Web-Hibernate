package examples.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FilterJDBC implements Filter {

	private final Logger log = LogManager.getRootLogger();
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		
		//Creo un objeto de ServletContext para obtener el ServletContext
		ServletContext servletContext = arg0.getServletContext();
		
		//Creo un objeto Long para guardar el tiempo inicial
		long tiempo1 = System.currentTimeMillis();
		
		//Con el objeto ServletRequest ejecuto el .doFilter
		//para decirle que pase el request al servlet
		arg2.doFilter(arg0, arg1);
		
		//Creo un objeto Long para guardar el tiempo de salida
		long tiempo2 = System.currentTimeMillis();
		
		//Creo un objeto Long para sacar una media de cuanto dura el Servlet
		long tiempoTotal = tiempo2 - tiempo1;
		
		log.info("El tiempo que tarda el servlet JDBC " + tiempoTotal + "ms");
		System.out.println("El tiempo que tarda el servlet JDBC " + tiempoTotal + "ms");
		
		//Declaro un Interger para guardar el valor que reciba del atributo servletContext.getAttribute("Contador")
		Integer contador =  (Integer) servletContext.getAttribute("Contador");
		
		//cuento
		contador++;
		
		//Hago setAttribute("Contador", contador) para guardar el valor
		//de este contador en el Context.
		servletContext.setAttribute("Contador", contador);
		log.info(contador + " usuarios han pasado por aquí");
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}

package hibernate.examples.listeners;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;

import org.apache.catalina.SessionEvent;
import org.hibernate.SessionFactory;

import com.sun.javafx.collections.MappingChange.Map;

import sessionManager.SessionManager;

public class HibernateContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		//System.out.println("Ha Pasado Por ContextListener Destroyed");
		
		ServletContext servletContext = arg0.getServletContext();
		SessionFactory sessionFactory = (SessionFactory) servletContext.getAttribute("SessionFactory");
		
		if(sessionFactory != null){
			
			sessionFactory.close();
			//System.out.println("Hemos cerrado el factory");
		}
		
		else {
			//System.out.println("Error al cerrar el factory");
		}
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		//System.out.println("Ha Pasado Por ContextListeners Initialized");
		Integer contador = 0;
		ServletContext servletContext = arg0.getServletContext();
		
		HashMap<String, HttpSession> registroSesiones = new HashMap<>();
		
		SessionFactory sessionFactory = SessionManager.getSessionFactory();
		
		servletContext.setAttribute("SessionFactory", sessionFactory);
		servletContext.setAttribute("Contador", contador);
		servletContext.setAttribute("RegistroSesiones", registroSesiones);
		
	}

}

package hibernate.examples.listeners;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HibernateSessionListener implements HttpSessionListener {
	private final Logger log = LogManager.getRootLogger();

	
	
	
	
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
	
	log.info("ID Session: " + arg0.getSession().getId());	
	log.info("Session Created");
	
	ServletContext servletContext = arg0.getSession().getServletContext();
	HttpSession session = arg0.getSession();
	
	HashMap<String, HttpSession> registroSesiones = (HashMap<String, HttpSession>) servletContext.getAttribute("RegistroSesiones");
	registroSesiones.put(session.getId(), session);
	
	session.setAttribute("RegistroSesiones", registroSesiones);
	
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		ServletContext servletContext = arg0.getSession().getServletContext();
		HttpSession session = arg0.getSession();
		
		HashMap<String, HttpSession> registroSesiones = (HashMap<String, HttpSession>) servletContext.getAttribute("RegistroSesiones");
		registroSesiones.remove(session.getId(), session);
		session.setAttribute("RegistroSesiones", registroSesiones);
		log.info("Session Destroyed");
		
	}

}

package sesiones.activas.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class sesionesActivasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final Logger log = LogManager.getRootLogger();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sesionesActivasServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie cookie = getCookie(request, "LlamadasAlServlet");
		Integer contador = 0;
		String valorCookie = cookie.getValue();
		Integer intValor = new Integer(valorCookie);
		
		
		
		if (intValor < 3) {
			contador++;
			valorCookie = contador.toString();
			cookie.setValue(valorCookie);
			response.addCookie(cookie);
		}
		else {
			response.sendRedirect("/WebHibernate/errorcookie.html");
		}
		
		
		
		
		
//******************************************************************************//
		Date fecha = new Date();
		ServletContext servletContext = request.getServletContext();
		@SuppressWarnings("unchecked")
		HashMap<String, HttpSession> registroSesiones = (HashMap<String, HttpSession>) servletContext.getAttribute("RegistroSesiones");
		
		response.setContentType("text/html");
		//Cojo el fichero que tiene preparado  por getWriter
		//para escribir nuestra respuesta
		PrintWriter out = response.getWriter();
		
		HttpSession httpSession = null;
		Iterator<HttpSession> it = registroSesiones.values().iterator();
		while(it.hasNext()){
			httpSession = (HttpSession) it.next();
			log.info("Las Sesiones Activas Son: " + httpSession.getId() + "   " + "Nombre: " + httpSession.getAttribute("nombre"));
			out.println("<br>Las Sesiones Activas Son: " + httpSession.getId()+ "   " + "<br>Nombre: " + httpSession.getAttribute("nombre")+"</br>"+ fecha + "</br>");
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * Método para comprobar si la petición trae una cookie
	 * Si no la trae, le doy una
	 * Si la trae se la regreso
	 * @param request
	 * @param nombreCookie
	 * @return Cookie
	 */
	private Cookie getCookie (HttpServletRequest request, String nombreCookie){
		Cookie cookie = null;
		Cookie cookieAux;
		int i = 0;
		boolean encontrado = false;
		
		Cookie[] arrayCookies = request.getCookies(); //LA RECUPERO
	
		
			if(null == arrayCookies){//Si no hay Cookies(El Array está vacío)
				log.info("Creo una nueva Cookie");
					cookie = new Cookie(nombreCookie, "1");
					cookie.setMaxAge(60);
			}
			else{//Si hay Cookies
			while ((i < arrayCookies.length) && (!encontrado))
			{
				cookieAux = arrayCookies[i];
				
					if(arrayCookies[i].getName().equals(nombreCookie))
					{
						
						log.info("Nombre de Cookie " + cookieAux.getName());	
						encontrado = true;
						cookie = cookieAux;
					}	
					else {
						i = i + 1;	
					}	
				}
			if (!encontrado){//Si no he encontrado la cookie
				log.info("Creo una nueva Cookie");
				cookie = new Cookie(nombreCookie, "1");
				cookie.setMaxAge(60);
			}
		}
			
			
				
		return cookie;
		
	}
}

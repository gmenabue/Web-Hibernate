package servlet.liga.espanola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class LigaEspanolaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final Logger log = LogManager.getRootLogger();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LigaEspanolaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

		
	
	//**************************************************************************//
		
		
		String contenidoPagina = getContenidoHTML();
		
	//**************************************************************************//
		
		
	    int contador = 0;
		int longuitud = contenidoPagina.length();
		int posicion_actual = 0;
		int empieza, acaba = 0;
		String equipo = "";
		String INICIO_EQUIPO = "\"equipo\">";
		String FIN_EQUIPO = "<";
		
		
		response.setContentType("text/html");
		//Cojo el fichero que tiene preparado  por getWriter
		//para escribir nuestra respuesta
		PrintWriter out = response.getWriter();
		
		while (posicion_actual < longuitud)
		{
			empieza = contenidoPagina.indexOf(INICIO_EQUIPO, posicion_actual);
			if (empieza != -1)
			{
				contador++;
				acaba = contenidoPagina.indexOf(FIN_EQUIPO, empieza+4);
				equipo = contenidoPagina.substring(empieza+9, acaba);
				posicion_actual = acaba;
				out.println(contador + "- " + equipo + "</br>");
				//log.info(contador + "- " + equipo);
				
			}
			else {
					posicion_actual = longuitud;
				 }
			
		}
			log.info("Han llamado al servlet");

	}
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	

	private String getContenidoHTML() throws IOException {
		
		String pagina = "http://www.marca.com/futbol/primera/clasificacion.html";
		URL urlResultados = new URL(pagina);
		URLConnection resultadosConnection = urlResultados.openConnection();
	    resultadosConnection.connect();
	    //Creamos el objeto con el que vamos a leer
	    BufferedReader br = new BufferedReader(new InputStreamReader(resultadosConnection.getInputStream()));
	    String inputLine;
	    String contenido = "";
	    while ((inputLine = br.readLine()) != null) {
	        contenido += inputLine + "\n";
	    }
	    br.close();
	    //System.out.println(contenido.toString());
	    return contenido;
	    
	}
	
	
}

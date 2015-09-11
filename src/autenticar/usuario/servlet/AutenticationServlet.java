package autenticar.usuario.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javafx.scene.control.Alert;
import jdbc.clase.DTO.UsuarioDTO;


public class AutenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession httpsession = null;
       
	private final Logger log = LogManager.getRootLogger();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutenticationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Me declaro una variable para almacenar el valor recibido
		//en HttpServletRequest
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");
		
		ServletContext servletContext = request.getServletContext();
		
		//Me declaro un Statement
		Statement stmt = null;
		//Me declaro un ResulSet para ejecutar la Query
		ResultSet rset = null;
		//Me declaro un empleado para almacenar el 
		UsuarioDTO usuario1 = null;
		//Me creo un objeto pool y llamo a get instance para recibir
		//el objeto ya que pool ultiliza sin
		Pool pool = Pool.getInstance();
		//Me creo un Objeto de Connection y hago getConnection
		Connection connection = pool.getConnection();
		
		response.setContentType("text/html");
		//Cojo el fichero que tiene preparado  por getWriter
		//para escribir nuestra respuesta
		PrintWriter out = response.getWriter();
	
		try {
			//Creo un Statement
			stmt = connection.createStatement();
			//Ejecuto la Query
			rset = stmt.executeQuery("select * from USERS WHERE NAME = '" + nombre + "' and PASSWORD = '" + password +"'");
			
			
			//Recorro el ResultSet
			if (rset.next())
			{
				//Compongo el objeto 
				usuario1 = componerObjeto(rset);
				System.out.println(usuario1.getUSER_NAME());
				System.out.println(nombre);
				System.out.println(usuario1.getUSER_PASS());
				System.out.println(password);
		
				if(null != usuario1){
						//if(usuario1.getUSER_PASS().equals(password)){
							out.println("Inicio De Sesión Correcto<br>" + "<br> Se Ha logueado correctamente");
							System.out.println("Se ha logueado");
							log.info("Usuario Se Ha Logueado Con Exito");
							//response.sendRedirect("indexlogueado.html");
							
							//Despues de loguear correctamente le damos una session
							//al usuario que se ha logueado
							if(null == (httpsession = request.getSession(false))){
								
								httpsession = request.getSession();
								//log.info("Crear Nueva Session");
							}
							else {
								
								log.info("La Session Ya Existe");
							}

							httpsession.setAttribute("nombre", nombre);
							//log.info(httpsession.getAttribute("nombre"));
							request.getRequestDispatcher("/indexlogueado.html").forward(request, response);
						//}
					}
			}
			else {
			
					out.println("Usuario o Contraseña Incorrecto<br>" + "<br> No se ha logueado");
					System.out.println("No se ha logueado");
					log.info("Usuario o Contraseña Incorrectos");
					//response.sendRedirect("indexnologueado.html");
					request.getRequestDispatcher("/indexnologueado.html").forward(request, response);
			}
		}
		
		catch (SQLException e) {
			log.error("Error en AutenticationServlet");
			e.printStackTrace();
		} 
		finally{
			Pool.liberarRecursos(connection, stmt, rset);
		}
		//response.sendRedirect("indexlogueado.html");
		//request.getRequestDispatcher("/sesionesActivasServlet").include(request, response);
		


}

	private static UsuarioDTO componerObjeto(ResultSet rset) throws SQLException {

		UsuarioDTO usuario = null;


	
		String USER_NAME = rset.getString(1);
		String USER_PASS = rset.getString(2);
	
	
	
		usuario = new UsuarioDTO(USER_NAME, USER_PASS);
	
		return usuario;
	}
	

}

package recuperar.departamentos.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.clase.DTO.DepartamentoDTO;
import jdbc.clase.DTO.UsuarioDTO;
import jdbc.servlet.Pool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class recuperarDepartamentosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final Logger log = LogManager.getRootLogger();
    DepartamentoDTO departamento;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public recuperarDepartamentosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		
				
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
					
					rset = stmt.executeQuery("select * from DEPARTMENTS");    
					
					out.print("<form action=\"RecuperarEmpleadosServlet\" method=\"get\">");
					out.println("<select name=\"lista_dep\">");
					//Recorro el ResultSet
					while (rset.next())
					{
						departamento = componerObjeto(rset);
						//System.out.println(departamento.getDEPARTMENT_NAME());
						out.print("<option value =\"" + departamento.getDEPARTMENT_ID() + "\">" + departamento.getDEPARTMENT_NAME() +"</option>");
										
					}
					out.print("</select>");
					out.print("<input type=\"submit\" value=\"Buscar Empleados\"/>" + 
							"</form>");
				}
				
				catch (SQLException e) {
					log.error("Error en AutenticationServlet");
					e.printStackTrace();
				} 
				finally{
					Pool.liberarRecursos(connection, stmt, rset);
				}
				
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	private static DepartamentoDTO componerObjeto(ResultSet rset) throws SQLException {

		DepartamentoDTO departamento = null;


	
		int DEPARTMENT_ID = rset.getInt(1);
		String DEPARTMENT_NAME = rset.getString(2);
	
	
	
		departamento = new DepartamentoDTO(DEPARTMENT_NAME, DEPARTMENT_ID);
		
		return departamento;
	}
}

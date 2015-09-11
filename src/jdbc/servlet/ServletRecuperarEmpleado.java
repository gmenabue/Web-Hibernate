package jdbc.servlet;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jdbc.clase.DTO.EmployeeDTO;


public class ServletRecuperarEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private final Logger log = LogManager.getRootLogger();
   
    public ServletRecuperarEmpleado() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Me declaro una variable para almacenar el valor recibido
		//en HttpServletRequest
		String id = request.getParameter("id");
		//Me declaro un Statement
		Statement stmt = null;
		//Me declaro un ResulSet para ejecutar la Query
		ResultSet rset = null;
		//Me declaro un empleado para almacenar el 
		EmployeeDTO empleado1 = new EmployeeDTO();
		//Me creo un objeto pool y llamo a get instance para recibir
		//el objeto ya que pool ultiliza sin
		Pool pool = Pool.getInstance();
		//Me creo un Objeto de Connection y hago getConnection
		Connection connection = pool.getConnection();
		
	
		try {
			//Creo un Statement
			stmt = connection.createStatement();
			//Me creo un preparedStatement para darle valor a la ?
			PreparedStatement pstmt = connection.prepareStatement("select * from employees WHERE EMPLOYEE_ID = ?");     
			//Le doy el valor a la 1ª ?
			pstmt.setString(1, id);
			//Ejecuto la Query
			rset = pstmt.executeQuery();
			
			
			//Recorro el ResultSet
			while (rset.next())
			{
				//Compongo el objeto 
				empleado1 = componerObjeto(rset);
			

			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally{
			Pool.liberarRecursos(connection, stmt, rset);
		}
		
		
		
		response.setContentType("text/html");
		//Cojo el fichero que tiene preparado  por getWriter
		//para escribir nuestra respuesta
		PrintWriter out = response.getWriter();
		
		
		out.println("El empleado " + id + " es:<br> " + "Nombre: " + empleado1.getFIRST_NAME() + "</br> " + "Apellido: " + empleado1.getLAST_NAME());
		System.out.println("Usado ServletRecuperarEmpleado");
		System.out.println("El empleado " + id + " es: " + empleado1.getFIRST_NAME() + " " + empleado1.getLAST_NAME());
		log.info("El empleado consultado con la ID: " + id + " es: " + empleado1.getFIRST_NAME() + " " + empleado1.getLAST_NAME());
		System.out.println("Ha llamado a Get");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

private static EmployeeDTO componerObjeto(ResultSet rset) throws SQLException {
		
		EmployeeDTO empleado = null;
		
		
	    	int EMPLOYEE_ID = rset.getInt(1);
	    	String FIRST_NAME = rset.getString(2);
	    	String LAST_NAME = rset.getString(3);
	    	String EMAIL = rset.getString(4);
	    	String PHONE_NUMBER = rset.getString(5);
	    	String HIRE_DATE = rset.getString(6);
	    	String JOB_ID = rset.getString(7);
	    	int SALARY = rset.getInt(8);
	    	int COMISSION_PCT = rset.getInt(9);
	    	int MANAGER_ID = rset.getInt(10);
	    	int DEPARTMENT_ID = rset.getInt(11);
	    	
	    	empleado = new EmployeeDTO(EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, HIRE_DATE, JOB_ID, SALARY, COMISSION_PCT, MANAGER_ID, DEPARTMENT_ID);
	    	
	    	
		 return empleado;
	}
}

package recuperar.empleados.servlet;

import hibernate.clase.DAO.DepartmentsDAO;
import hibernate.clase.DTO.Departments;
import hibernate.clase.DTO.Employees;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Transaction;

import sessionManager.SessionManager;

public class RecuperarEmpleadosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final Logger log = LogManager.getRootLogger();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecuperarEmpleadosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				String id = request.getParameter("lista_dep");
				Integer new_id = new Integer(id);
		
				//Me declaro una lista de departamentos para guardar los departamentos recuperados
				List<Departments> lista = new ArrayList<Departments>();
				//Me declaro un set de empleados para guardar la lista de empleados
				Set<Employees> lista_emp = new HashSet<Employees>();
				//Objeto de DepartmentsDAO
				DepartmentsDAO ddao = new DepartmentsDAO();
				//Obtengo la Session y la seteo en la clase SuperDAO
				ddao.setSession(SessionManager.obtenerSesionNueva());
				//Inicio la transacción
				Transaction transaction = ddao.getSession().beginTransaction();
				//Con el tipo mime identifico la información que viaja en el cuerpo del mensaje
				response.setContentType("text/html");
				//Cojo el fichero que tiene preparado  por getWriter
				//para escribir nuestra respuesta
				PrintWriter out = response.getWriter();
				List<Employees> empleados_lista = new ArrayList<>();
				
				
				try 
		    	{
					//Leo todos los departamentos y los guardo en la lista de departamentos
		    		lista = ddao.read_all2(new_id);
		    		Iterator<Departments> it = lista.iterator();
		    		Departments dep = new Departments();
		    		
		    		//Recorro la lista
		    		while (it.hasNext())
		    		{
		    			dep = it.next();
		    			
		    			System.out.println('\n' + dep.getDepartmentName());
		    			
		    			//Leo los empleados de cada departamento y los meto en 
		    			//una lista de empleados.
		    			lista_emp = dep.getEmployeeses();
		    			
		    			Employees emp = new Employees();
		        		
		    			//Recorro la lista de empleados
		        		Iterator<Employees> ite = lista_emp.iterator();
		        				
		        				while (ite.hasNext()){
		        					
		        					emp = ite.next();
		        					//System.out.println(emp.getFirstName() + " " + emp.getLastName());
		        					out.println(emp.getFirstName() + " " + emp.getLastName() + "<br>");
		        					empleados_lista.add(emp);
		        				}
		    			
		    		}
		    		//Si el proceso ha ido bien, hago Commit.
		    		transaction.commit();
		    		}
		    	catch (Exception e)
		    	{
		    		//Si el proceso no ha ido bien, capturo la exepción, envío el error
		    		// a un log y hago rollback de la transación.
		    		log.error("Error en el método Recuperar Empleados Por Departamentos");
		    		e.printStackTrace();
		    		transaction.rollback();//si algo ha ido mal, deshago la transacción
		    	}
		    	finally 
		    	{
		    		//Cierro la sesión
		    		SessionManager.cerrar_session(ddao.getSession());
		    		//SessionManager.cerrar_session_factory();
		    	}
				request.setAttribute("listaempleados", empleados_lista);
				request.getRequestDispatcher("/empleados.jsp").forward(request, response);
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

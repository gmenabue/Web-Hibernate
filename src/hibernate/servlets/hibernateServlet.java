package hibernate.servlets;

import hibernate.clase.DAO.EmployeesHibernateDAO;
import hibernate.clase.DTO.Employees;
import interfaces.Recuperable;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import services.Empleado_service;


public class hibernateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final Logger log = LogManager.getRootLogger();
	Empleado_service es = new Empleado_service();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public hibernateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String id = request.getParameter("id");
		int id_emp = new Integer(id);
		
		/*
		ServletContext servletContext = request.getServletContext();
		
		SessionFactory sessionFactory = (SessionFactory) servletContext.getAttribute("SessionFactory");
		
		Session session = sessionFactory.openSession(); 
		
		session.close();
		*/
		
		Recuperable empleadoHibernate_DAO  = new EmployeesHibernateDAO();
		es.setEmpleadoDAO(empleadoHibernate_DAO);
		Employees empleado3DTO = new Employees();
		
		try {
			empleado3DTO = (Employees) es.leer_empleado(id_emp);
			log.info("Se ha leido el empleado");
		} 
		catch (Exception e) {
			//log.info("Error al obtener empleado de la base de datos");
			// TODO: handle exception
		}
		
		//Con el tipo mime identifico la información que viaja en el cuerpo del mensaje
		response.setContentType("text/html");
		//Cojo el fichero que tiene preparado  por getWriter
		//para escribir nuestra respuesta
		PrintWriter out = response.getWriter();
		
		//Esto para usarlo con el JSP buscarempleado
		request.setAttribute("empleado", empleado3DTO);
		request.getRequestDispatcher("/buscarempleadoregreso.jsp").forward(request, response);
		
		
		out.println("<font size=4> El empleado con el ID: " + empleado3DTO.getEmployeeId() + " es:<br> " 
		+ "<br>Nombre Empleado: " + empleado3DTO.getFirstName() 
		+ "<br> Apellido Empleado: " +empleado3DTO.getLastName() + "<br> Salario Empleado: " 
		+ empleado3DTO.getSalary()+" $");
		System.out.println("Usado Servlet hibernateServlet");
		System.out.println("Ha llamado a Get");
		log.info("El empleado consultado con la ID: " + id + " es: " + empleado3DTO.getFirstName() + " " + empleado3DTO.getLastName());
		log.info("Se ha completado el proceso con exito!");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

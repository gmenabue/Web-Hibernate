package incrementar.salario.servlet;


import hibernate.clase.DTO.Employees;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.OperacionesService;


public class IncrementarSalarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IncrementarSalarioServlet() {
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
		
		ServletConfig servletConfig = getServletConfig();
		
		String inc = servletConfig.getInitParameter("IncrementoSalario");
		BigDecimal incremento = new BigDecimal(inc);
		
		
		OperacionesService op = new OperacionesService();
		
		@SuppressWarnings("unused")
		List<Employees> lista_empleados = new ArrayList<Employees>();
		lista_empleados = op.incremento_salario(incremento);
		
		
		//Con el tipo mime identifico la información que viaja en el cuerpo del mensaje
		response.setContentType("text/html");
		//Cojo el fichero que tiene preparado  por getWriter
		//para escribir nuestra respuesta
		PrintWriter out = response.getWriter();
		
		out.println("Salario Aumentado Correctamente!!");
		System.out.println("Salaraio incrementado");
		
		

		
		
		// TODO Auto-generated method stub
	}

}

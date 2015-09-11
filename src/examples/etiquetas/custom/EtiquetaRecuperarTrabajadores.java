package examples.etiquetas.custom;

import hibernate.clase.DTO.Employees;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import services.OperacionesService;

public class EtiquetaRecuperarTrabajadores extends SimpleTagSupport {
	
	private int id;
	private final Logger log = LogManager.getRootLogger();

	/* (non-Javadoc)
	 * @see javax.servlet.jsp.tagext.SimpleTagSupport#doTag()
	 */
	@Override
	public void doTag() throws JspException, IOException {
		
		
		OperacionesService op = new OperacionesService();
		Set<Employees> lista_empleados = op.recuperar_empleados_departamentos_id(id);
		JspWriter out = getJspContext().getOut();
		
		//Employees emp;
		/*//Para recorrer la lista con un iterartor
		Iterator<Employees> it = lista_empleados.iterator();
		
		while (it.hasNext())
		{
			emp = it.next();
			out.println("<br>"+emp.getFirstName() + "  " + emp.getLastName() + "<br>");
		}
		*/
		
		//Para recorrer la lista con un For Each
		for( Employees emp  : lista_empleados){
			
			out.println("<br>"+emp.getFirstName() + "  " + emp.getLastName() + "<br>");
			
		}
		super.doTag();
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	
}

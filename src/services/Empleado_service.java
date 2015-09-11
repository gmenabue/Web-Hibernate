/**
 * 
 */
package services;


import hibernate.clase.DAO.EmployeesHibernateDAO;
import interfaces.Recuperable;



/**
 * @author Giordano Menabue
 *
 */
public class Empleado_service {
	Recuperable empleadoDAO = null;
	
	

	/**
	 * Constructor de la clase Empleado Service.
	 */
	public Empleado_service(){
		empleadoDAO = new EmployeesHibernateDAO();
		
	}

	/**
	 * @param empleadoDAO the empleadoDAO to set
	 */
	public void setEmpleadoDAO(Recuperable empleadoDAO) {
		this.empleadoDAO = empleadoDAO;
	}
	
	public Object leer_empleado (int id){
		Object empleado;
		empleado = this.empleadoDAO.read(id);
		return empleado;
	}
	
}

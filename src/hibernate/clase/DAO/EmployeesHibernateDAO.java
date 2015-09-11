/**
 * 
 */
package hibernate.clase.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import sessionManager.SessionManager;
import hibernate.clase.DTO.Employees;
import interfaces.Recuperable;

/**
 * @author alumno
 *
 */
public class EmployeesHibernateDAO extends SuperDAO implements Recuperable {

	
	
	@Override
	public Object read(Object id) {
		Employees empleadoDTO = new Employees();
		
		//Cargo la configuraci�n: MAPPING entre Tablas y Objetos as� como La descripci�n de la base de de datos
    	//Dicho de otra forma: cargamos en memoria en la clase Configuration el hibernate.cfg.xml
    	Configuration configuration = new Configuration().configure();
    	//Preparo a un objeto, que ser� el encargado de generarme el estado de comunicaci�n con la base de datos
    	//StandardServiceRegistryBuilder se preconfigura el entorno a emplear
    	StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
    	
    	//Ahora s�, obtengo el objeto SessionFactory, a partir de la anterior clase /servicio
    	//que ya es la clase que encapsula al Pool y dem�s recursos f�sicos
    	SessionFactory miSessionFactory = configuration.buildSessionFactory(builder.build());
    	
    	//Ahora ya con sesion, obtengo y manejo conexiones que me va dando SessionFactory
    	Session session = miSessionFactory.openSession();
    	
    	
    	Transaction transaction = null;
    	//Y procedo a guardarlo --> INICIO DE LA TRANSACCION
    	
    	
    	
    	
    	try 
    	{
    		
    		transaction = session.beginTransaction();
			
    		empleadoDTO = (Employees) session.createSQLQuery("select * from employees WHERE EMPLOYEE_ID = " + id).addEntity(Employees.class).uniqueResult();
    		System.out.println( empleadoDTO.getFirstName()+" "+ empleadoDTO.getLastName());
    		System.out.println("----------------------------------------------------------------------------");
    		System.out.println("----------------------------------------------------------------------------");
    		
    			
    	
    	
    		//transaction.commit();//si todo ha ido bien, persisto los cambio, los hago de verdad, no en la copia de la BD
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    		transaction.rollback();//si algo ha ido mal, deshago la transacci�n
    		
    	}
    	finally 
    	{
    		//Cierro la sesi�n
    		SessionManager.cerrar_session(session);
    		//SessionManager.cerrar_session_factory();
    	}
		
		
		return empleadoDTO ;
	}

	
	public List<Employees> read_all() {
		@SuppressWarnings("unchecked")
		List<Employees> list = getSession().createSQLQuery("select * from employees").addEntity(Employees.class).list();
		return list;
		
	}
}

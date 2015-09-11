/**
 * 
 */
package interfaces;

import java.util.List;


/**
 * @author Giordano Menabue
 *
 */
public interface InterfaceDAO <Generico>{

	/**
	 * * M�todo para crear contenido en la base de datos 
	 * @param g objeto que recibe el m�todo
	 * @return boolean
	 */
	public boolean create(Generico g);
	
	/**
	 * M�todo para leer de la base de datos
	 * @param id parametro que recibe el m�todo 
	 * @return un objeto del tipo que querramos leer
	 */
	public Generico read (Object id);
	
	
	public Generico update (Generico g);
	
	
	public boolean delete (Object id);
	
	
	public List<Generico> read_all ();
}

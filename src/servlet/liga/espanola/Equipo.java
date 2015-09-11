package servlet.liga.espanola;

public class Equipo {
	
	private int posici�n;
	private String nombre;
	private int pj;
	private int pg;
	private int pp;
	
	/**
	 * Constructor de la clase Equipos
	 * @param posici�n
	 * @param nombre
	 * @param pj
	 * @param pg
	 * @param pp
	 */
	public Equipo(int posici�n, String nombre, int pj, int pg, int pp) {
		super();
		this.posici�n = posici�n;
		this.nombre = nombre;
		this.pj = pj;
		this.pg = pg;
		this.pp = pp;
	}
	
	/**
	 * Constructor vacio de la clase Equipo
	 */
	public Equipo(){
		//constructor vacio
	}

	/**
	 * @return the posici�n
	 */
	public int getPosici�n() {
		return posici�n;
	}

	/**
	 * @param posici�n the posici�n to set
	 */
	public void setPosici�n(int posici�n) {
		this.posici�n = posici�n;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the pj
	 */
	public int getPj() {
		return pj;
	}

	/**
	 * @param pj the pj to set
	 */
	public void setPj(int pj) {
		this.pj = pj;
	}

	/**
	 * @return the pg
	 */
	public int getPg() {
		return pg;
	}

	/**
	 * @param pg the pg to set
	 */
	public void setPg(int pg) {
		this.pg = pg;
	}

	/**
	 * @return the pp
	 */
	public int getPp() {
		return pp;
	}

	/**
	 * @param pp the pp to set
	 */
	public void setPp(int pp) {
		this.pp = pp;
	}
	
	
	
}

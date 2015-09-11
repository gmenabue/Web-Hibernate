package servlet.liga.espanola;

public class Equipo {
	
	private int posición;
	private String nombre;
	private int pj;
	private int pg;
	private int pp;
	
	/**
	 * Constructor de la clase Equipos
	 * @param posición
	 * @param nombre
	 * @param pj
	 * @param pg
	 * @param pp
	 */
	public Equipo(int posición, String nombre, int pj, int pg, int pp) {
		super();
		this.posición = posición;
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
	 * @return the posición
	 */
	public int getPosición() {
		return posición;
	}

	/**
	 * @param posición the posición to set
	 */
	public void setPosición(int posición) {
		this.posición = posición;
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

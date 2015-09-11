package jdbc.clase.DTO;

public class UsuarioDTO {
	String USER_NAME;
	String USER_PASS;
	public UsuarioDTO(String uSER_NAME, String uSER_PASS) {
		super();
		USER_NAME = uSER_NAME;
		USER_PASS = uSER_PASS;
	}
	/**
	 * @return the uSER_NAME
	 */
	public String getUSER_NAME() {
		return USER_NAME;
	}
	/**
	 * @param uSER_NAME the uSER_NAME to set
	 */
	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}
	/**
	 * @return the uSER_PASS
	 */
	public String getUSER_PASS() {
		return USER_PASS;
	}
	/**
	 * @param uSER_PASS the uSER_PASS to set
	 */
	public void setUSER_PASS(String uSER_PASS) {
		USER_PASS = uSER_PASS;
	}
	
	
}

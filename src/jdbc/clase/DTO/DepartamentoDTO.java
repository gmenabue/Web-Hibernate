package jdbc.clase.DTO;

public class DepartamentoDTO {

	String DEPARTMENT_NAME;
	int DEPARTMENT_ID;
	public DepartamentoDTO(String dEPARTMENT_NAME, int dEPARTMENT_ID) {
		super();
		DEPARTMENT_NAME = dEPARTMENT_NAME;
		DEPARTMENT_ID = dEPARTMENT_ID;
	}
	/**
	 * @return the dEPARTMENT_NAME
	 */
	public String getDEPARTMENT_NAME() {
		return DEPARTMENT_NAME;
	}
	/**
	 * @param dEPARTMENT_NAME the dEPARTMENT_NAME to set
	 */
	public void setDEPARTMENT_NAME(String dEPARTMENT_NAME) {
		DEPARTMENT_NAME = dEPARTMENT_NAME;
	}
	/**
	 * @return the dEPARTMENT_ID
	 */
	public int getDEPARTMENT_ID() {
		return DEPARTMENT_ID;
	}
	/**
	 * @param dEPARTMENT_ID the dEPARTMENT_ID to set
	 */
	public void setDEPARTMENT_ID(int dEPARTMENT_ID) {
		DEPARTMENT_ID = dEPARTMENT_ID;
	}
	
	
}

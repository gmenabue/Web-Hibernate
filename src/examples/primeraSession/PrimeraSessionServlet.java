package examples.primeraSession;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class PrimeraSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	HttpSession httpsession = null;
	private final Logger log = LogManager.getRootLogger();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrimeraSessionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if(null == (httpsession = request.getSession(false))){
			
			httpsession = request.getSession();
			log.info("Crear Nueva Session");
		}
		else {
			
			log.info("La Session Ya Existe");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

package examples.uploadfiles;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UploadFileExample extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Logger log = LogManager.getRootLogger();
	
	private String extraerRuta (String contentheader)
	{
		String ruta = null;

		ruta = contentheader.substring(contentheader.indexOf("filename=")+10, contentheader.length()-1);
		
		log.trace("Ruta obtenida =" + ruta);
		return ruta;
	}
	
	
	private String extraerExtension (String contentheader)
	{
		String extension = null;

		extension = contentheader.substring(contentheader.indexOf("filename=")+16, contentheader.length()-1);
		
		log.trace("Extension =" + extension);
		return extension;
	}
	
	private String obtenerCabecera(HttpServletRequest request, String nombre_parte) throws IllegalStateException, IOException, ServletException{
		String cabecera = null;
	    Collection<String> headers = null;
	    Iterator<String> it = null;
	    
	    	headers = request.getPart(nombre_parte).getHeaders("content-disposition");
	    	it= headers.iterator();
	    	if (it.hasNext())
	    	{
	    		cabecera = it.next();
	    	}
	    
	    return cabecera;
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		String cabecera = obtenerCabecera(request, "fResumen");
		String nombre_fichero_origen = extraerRuta (cabecera);
		String nombre_extension = extraerExtension(cabecera);
		
		String nombre_fichero_destino = getServletConfig().getInitParameter("RUTA_SUBIDA_FICHEROS")+"\\"+nombre_fichero_origen;
		ServletOutputStream out = null;
		
			log.trace("Entro en doPost " + getClass().getName());
			
			switch (nombre_extension) {
			case "jpg": resp.setContentType("image/jpeg");
				
				break;
			case "pdf": resp.setContentType("application/pdf");
				
				break;
			case "html": resp.setContentType("text/html");
			
			break;
			case "mp3": resp.setContentType("audio/x-mpeg-3");
			
			break;
			case "jpeg": resp.setContentType("image/jpeg");
			
			break;

			default:
				break;
			}
			
			out = resp.getOutputStream();
			try (InputStream f_entrada = request.getPart("fResumen").getInputStream(); FileOutputStream f_salida = new FileOutputStream(nombre_fichero_destino);) 
				{
				
					byte array_intermedio[] = new byte[1024];
					int bytes_leidos = 0;
			        while ((bytes_leidos = f_entrada.read(array_intermedio)) != -1) 
			        {
			        	out.write(array_intermedio, 0, bytes_leidos);
			        	f_salida.write(array_intermedio, 0, bytes_leidos);
			        	
			        }
			        out.flush();
			    
			    } catch (Exception e) 
				{
			    	e.printStackTrace();
			    	log.error(e.toString());
			    }
			
		
	}

}

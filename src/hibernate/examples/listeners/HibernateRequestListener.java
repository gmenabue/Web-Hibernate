package hibernate.examples.listeners;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class HibernateRequestListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		//System.out.println("Ha Pasado Por RequestListener Destroyed");
		
	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		//System.out.println("Ha Pasado Por RequestListener Initialized");
		
	}

}

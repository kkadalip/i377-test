package test;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 
1. Tekitage servlet, mis loeb konkreetse kasutaja "reloadide" arvu
   Salvestage sessiooni Integer tyypi muutuja
   Suurendage seda igas doGet v2ljakutses
   Trykkige muutuja v22rtus v2ljundisse
 */
public class praks1yl1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer count = (Integer) request.getSession().getAttribute("count");
		if (count == null){
			count = 0;
		}
		count++;
		
		request.getSession().setAttribute("count", count);
		
		response.getWriter().println("Count: "+count);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}

package muu;

import java.io.IOException;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex4
 */
public class Ex4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// alt shift M, setListData
		setListData(request);
		request.getRequestDispatcher("ex4.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ka postis tuleb suunata jsp peale
		setListData(request);
		request.getSession().setAttribute("listName", request.getAttribute("request"));
		response.sendRedirect("Ex4"); // post suunab geti peale ringi
		//request.getRequestDispatcher("ex4.jsp").forward(request, response);
	}
	
	private void setListData(HttpServletRequest request) {
		LinkedHashMap<String, String> oddMap = new LinkedHashMap<String, String>();
		oddMap.put("1", "üks");
		oddMap.put("2", "kolm");
		oddMap.put("3", "viis");
		oddMap.put("4", "seitse");

		LinkedHashMap<String, String> evenMap = new LinkedHashMap<String, String>();
		evenMap.put("1", "kaks");
		evenMap.put("2", "neli");
		evenMap.put("3", "kuus");
		evenMap.put("4", "kaheksa");

		//pageContext.setAttribute("odd", oddMap);
		//pageContext.setAttribute("even", evenMap);
		
		request.setAttribute("odd", oddMap);
		request.setAttribute("even", evenMap);
	}

}

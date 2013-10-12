package osa3;

import java.io.IOException;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Osa3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// alt shift M, setListData
		setListData(request);
		request.getRequestDispatcher("exKarl.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ka postis tuleb suunata jsp peale
		setListData(request);
		request.getSession().setAttribute("listName", request.getAttribute("request"));
		response.sendRedirect("ExKarl"); // post suunab geti peale ringi
		//request.getRequestDispatcher("exKarl.jsp").forward(request, response);
		
		//Karl karl = new Karl();
	}
	
	private void setListData(HttpServletRequest request) {
		LinkedHashMap<String, String> defaultValuesMap = new LinkedHashMap<String, String>();
		defaultValuesMap.put("CEO", "1");
		defaultValuesMap.put("Administration", "1-1");
		defaultValuesMap.put("Legal", "1-1-1");
		defaultValuesMap.put("Archives", "1-1-2");
		defaultValuesMap.put("Production", "1-2");
		defaultValuesMap.put("Sales", "2");
		//pageContext.setAttribute("defaultValues", defaultValuesMap);
		request.setAttribute("defaultValues", defaultValuesMap);
	}
}

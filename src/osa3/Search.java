package osa3;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Unit;

public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		searchUnits(request); // alt shift M, saab mõnusalt eraldi meetodisse lükata
		request.getRequestDispatcher("osa3menu.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		searchUnits(request);
		response.sendRedirect("Osa3"); // Search // post suunab geti peale ringi, mis omakorda suunab jsp peale
	}
	
	private void searchUnits(HttpServletRequest request){
		String paramText = "searchString"; //do
		HttpSession session = request.getSession();
		String param = request.getParameter(paramText);
		String sessionParam = (String)session.getAttribute(paramText);
		if(param != null){
			request.getSession().setAttribute(paramText, param);
			sessionParam = param;
		}
		
		List<Unit> foundUnits = new ArrayList<Unit>();
		
		dao.UnitDao uDao = new dao.UnitDao();
		try {
			foundUnits = uDao.searchUnitsByName(sessionParam);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("foundUnits", foundUnits);
		System.out.println("searchiga leitud unitid on " + foundUnits.toString());
	}

}

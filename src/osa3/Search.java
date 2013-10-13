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

import model.Unit;

public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		searchUnits(request); // alt shift M, saab mõnusalt eraldi meetodisse lükata
		request.getRequestDispatcher("osa3.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		searchUnits(request);
		//request.getSession().setParameter("listName", request.getAttribute("request"));
		//request.getSession().setAttribute("listName", request.getParameter("request"));
		response.sendRedirect("Search"); // post suunab geti peale ringi, mis omakorda suunab jsp peale
	}
	
	private void searchUnits(HttpServletRequest request){
		List<Unit> units = new ArrayList<Unit>();
		
		dao.UnitDao uDao = new dao.UnitDao();
		try {
			units = uDao.findUnit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		LinkedHashMap<String, String> searchMap = new LinkedHashMap<String, String>();
		for(Iterator<Unit> i = units.iterator(); i.hasNext(); ) {
			Unit item = i.next();
			searchMap.put(item.getName(), item.getCode());
		}
		request.setAttribute("search", searchMap);
		
		System.out.println("searchmap on " + unitMap.toString());
	}

}

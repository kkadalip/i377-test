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

import dao.UnitDao;
import model.Unit;

public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doStuff(request); // alt shift M, saab mõnusalt eraldi meetodisse lükata
		request.getRequestDispatcher("WEB-INF/osa3search.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.sendRedirect("Search");
	}

	private void doStuff(HttpServletRequest request){
		String behaviour = request.getParameter("do");
		String searchString = request.getParameter("searchString");
		List<Unit> displayedUnits = new ArrayList<Unit>();

		if("delete".equals(behaviour)){
			UnitDao uDao = new UnitDao();
			try {
				//System.out.println("Deleting item that has id " + request.getParameter("id"));
				uDao.deleteByID(Integer.parseInt(request.getParameter("id")));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(searchString == null){
			displayedUnits = getAllUnits(request);
		}else{
			displayedUnits = searchUnits(request);
		}		
		request.setAttribute("displayedUnits", displayedUnits);
	}

	private List<Unit> searchUnits(HttpServletRequest request){
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
		return foundUnits;
	}

	private List<Unit> getAllUnits(HttpServletRequest request){
		List<Unit> allUnits = new ArrayList<Unit>();
		dao.UnitDao uDao = new dao.UnitDao();
		try {
			allUnits = uDao.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allUnits;
	}

}

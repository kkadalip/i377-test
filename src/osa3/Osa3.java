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

public class Osa3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getUnits(request); // alt shift M, saab mõnusalt eraldi meetodisse lükata
		request.getRequestDispatcher("osa3.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getUnits(request);
		//request.getSession().setParameter("listName", request.getAttribute("request"));
		//request.getSession().setAttribute("listName", request.getParameter("request"));
		response.sendRedirect("Osa3"); // post suunab geti peale ringi, mis omakorda suunab jsp peale
	}

	private void getUnits(HttpServletRequest request){
		List<Unit> unitsList = new ArrayList<Unit>();
		
		dao.UnitDao uDao = new dao.UnitDao();
		try {
			unitsList = uDao.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("unitsList", unitsList);
		System.out.println("unitsList on " + unitsList.toString()); // TEST
	}
}

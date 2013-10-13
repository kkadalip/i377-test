package osa3;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Unit;

public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/osa3add.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		addUnit(request);
		getUnits(request); // alt shift M, saab mõnusalt eraldi meetodisse lükata
		response.sendRedirect("Search"); // post suunab geti peale ringi, mis omakorda suunab jsp peale
	}

	private void addUnit(HttpServletRequest request){
		String name = request.getParameter("name");
		String code = request.getParameter("code");
		dao.UnitDao uDao = new dao.UnitDao();
		Unit unit = new Unit();
		//unit.setId(5);
		unit.setName(name);
		unit.setCode(code);
		try {
			uDao.addUnit(unit);
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
		//System.out.println("unitsList on " + unitsList.toString()); // TEST
	}

}

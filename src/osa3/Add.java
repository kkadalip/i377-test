package osa3;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Unit;

public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("osa3add.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		addUnit(request);
		response.sendRedirect("Osa3"); // post suunab geti peale ringi, mis omakorda suunab jsp peale
	}

	private void addUnit(HttpServletRequest request){
		dao.UnitDao uDao = new dao.UnitDao();
		Unit unit = new Unit();
		//unit.setId(5);
		unit.setName("swagger");
		unit.setCode("1-1-1-1");
		try {
			uDao.addUnit(unit);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

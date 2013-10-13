package osa3;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SetupDao;
import dao.UnitDao;

public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String behaviour = request.getParameter("do");
			// Tühjenda
			if(behaviour == "clear_data"){
				clear();
			// Sisesta näidisandmed	
			}else if(behaviour == "insert_data"){
				insertDefaultValues();
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("Search");
	}

	private void clear(){
		UnitDao uDao = new UnitDao();
		try {
			uDao.deleteAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// kui parameeter on menu_InsertData, siis
	private void insertDefaultValues(){
		System.out.println("Adding default values once more");
		dao.SetupDao setup = new dao.SetupDao();
		setup.createDefaultValues();
	}
}

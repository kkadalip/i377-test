package osa3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("Osa3");
	}

	// kui parameeter on menu_InsertData, siis
	private void insertDefaultValues(){
		System.out.println("Adding default values once more");
		dao.SetupDao setup = new dao.SetupDao();
		setup.createDefaultValues();
	}
}

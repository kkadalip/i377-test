package test;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
2. Tekitage Servlet, mis kysib kasutajalt tema nime ja tervitab teda vastu
doGet-is trykkida vorm, mis kasutab POST meetodit
doPost-is v6tta vormi andmetest ( request.getParameter(...) ) nimi ja trykkida see v2ljundisse
*/
public class praks1yl2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String form = "<form method='POST'>"
				+"<input type=text name='nimi'>"
				+"<input type=submit value='Saada'>"
				+"</form>";
		response.getWriter().println(form);
	}
// doPo ctrl space aitab eclipse!!!!!
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ctrl 1 aitab eclipse!!!!
		String a = request.getParameter("nimi");
		response.getWriter().println("Tere "+a);
	}
}

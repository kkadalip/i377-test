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
		getUnits(request);
		//getUnits2();

		// alt shift M, setListData
		//setListData(request);
		request.getRequestDispatcher("osa3.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//getUnits(request);

		// ka postis tuleb suunata jsp peale
		//setListData(request);
		request.getSession().setAttribute("listName", request.getAttribute("request"));
		response.sendRedirect("Osa3"); // post suunab geti peale ringi
		//request.getRequestDispatcher("exKarl.jsp").forward(request, response);

		//Karl karl = new Karl();
	}

	//	private void setListData(HttpServletRequest request) {
	//		LinkedHashMap<String, String> defaultValuesMap = new LinkedHashMap<String, String>();
	//		defaultValuesMap.put("CEO", "1");
	//		defaultValuesMap.put("Administration", "1-1");
	//		defaultValuesMap.put("Legal", "1-1-1");
	//		defaultValuesMap.put("Archives", "1-1-2");
	//		defaultValuesMap.put("Production", "1-2");
	//		defaultValuesMap.put("Sales", "2");
	//		//pageContext.setAttribute("defaultValues", defaultValuesMap);
	//		request.setAttribute("defaultValues", defaultValuesMap);
	//	}

	private void getUnits(HttpServletRequest request){
		List<Unit> units = new ArrayList<Unit>();
		dao.UnitDao uDao = new dao.UnitDao();
		try {
			units = uDao.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		LinkedHashMap<String, String> unitMap = new LinkedHashMap<String, String>();
		for(Iterator<Unit> i = units.iterator(); i.hasNext(); ) {
			Unit item = i.next();
			unitMap.put(item.getName(), item.getCode());
		}
		request.setAttribute("unitMap", unitMap);
	}

	private void getUnits2(){
		dao.UnitDao uDao = new dao.UnitDao();
		try {
			uDao.findAll2();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

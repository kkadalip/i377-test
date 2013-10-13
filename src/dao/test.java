package dao;

import java.sql.SQLException;
import java.util.List;

import model.Unit;

public class test {

	public static void main(String[] args) {
		UnitDao uDao = new UnitDao();

		System.out.println("FindAll");
		List<Unit> un2;
		try {
			un2 = new UnitDao().findAll();
			System.out.println(un2);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.apache.commons.dbutils.DbUtils;
import org.hibernate.service.config.spi.ConfigurationService.Converter;

import model.Unit;

public class UnitDao extends AbstractDao {


	//	private void update() throws SQLException { // siia parameetrid, mille järgi updateda?... eh teistele ka siis?
	//		Connection conn = DriverManager.getConnection(DB_URL);
	//
	//		PreparedStatement ps = null;
	//		Statement stmt = null;
	//		try {
	//			ps = conn.prepareStatement(
	//					"UPDATE unit SET name = ? WHERE id = ?");
	//			//ps.setString(unit.getId(), unit.getName());
	//			ps.setString(1, "Mary"); // MUUDA
	//			ps.setInt(2, 3L); // MUUDA
	//
	//			int rowCount = ps.executeUpdate();
	//			System.out.println(rowCount + " rows updated!");
	//
	//		} finally {
	//			DbUtils.closeQuietly(stmt);
	//			DbUtils.closeQuietly(conn);
	//		}
	//	}
	//
	//	private void printCertain() throws SQLException {
	//		Connection conn = DriverManager.getConnection(DB_URL);
	//
	//		PreparedStatement ps = null;
	//		Statement stmt = null;
	//		ResultSet rset = null;
	//		try {
	//			ps = conn.prepareStatement("SELECT id, name FROM unit "
	//					+ "WHERE id = ?");
	//			ps.setInt(1, 3L);
	//			rset = ps.executeQuery();
	//			while (rset.next()) {
	//				System.out.println(rset.getInt(1) + ", " + rset.getString(2));
	//			}
	//		} finally {
	//			DbUtils.closeQuietly(rset);
	//			DbUtils.closeQuietly(stmt);
	//			DbUtils.closeQuietly(conn);
	//		}
	//	}
	//

	public List<Unit> findAll() throws SQLException{
		List<Unit> units = new ArrayList<Unit>();
		try {
			st = getConnection().createStatement();
			rs = st.executeQuery("SELECT * FROM unit");
			while(rs.next()){
				Unit unit = new Unit();
				unit.setId(rs.getInt(1)); // id
				unit.setName(rs.getString(2)); // name
				unit.setCode(rs.getString(3)); // code
				units.add(unit);
			}
		} finally {
			closeResources();
		}
		return units;
	}
	
	public void addUnit(Unit unit) throws SQLException{
			int unitId = unit.getId();
			String unitName = unit.getName();
			String unitCode = unit.getCode();
			String query = "INSERT INTO unit (id, name, code) VALUES ("+unitId+", '"+unitName+"', '"+unitCode+"');";
			System.out.println(query);
		try {
			st = getConnection().createStatement();
			rs = st.executeQuery(query);
		} finally {
			closeResources();
		}
	}	

	public List<Unit> searchUnits(String name) throws SQLException{
		List<Unit> units = new ArrayList<Unit>();
		try {
			pst = getConnection().prepareStatement("SELECT * FROM unit WHERE UPPER(name) LIKE ?");
			pst.setString(1, "%" + name.toUpperCase() + "%");
			rs = pst.executeQuery();
			while(rs.next()){
				Unit unit = new Unit();
				unit.setId(rs.getInt(1));
				unit.setName(rs.getString(2));
				unit.setCode(rs.getString(3));
				units.add(unit);
			}
		} finally {
			closeResources();
		}
		return units;
	}
	
	public List<Unit> deleteUnitById(int id) throws SQLException{
		return null;
	}
}

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
		//int unitId = unit.getId();
		String unitName = unit.getName();
		String unitCode = unit.getCode();
		String query = "INSERT INTO unit VALUES(NEXT VALUE FOR seq1,'"+unitName+"','"+unitCode+"');";
		try {
			st = getConnection().createStatement();
			rs = st.executeQuery(query);
		} finally {
			closeResources();
		}
	}

	public List<Unit> searchUnitsByName(String searchName) throws SQLException{
		List<Unit> units = new ArrayList<Unit>();
		try {
			pst = getConnection().prepareStatement("SELECT * FROM unit WHERE LOWER(name) LIKE ?");
			pst.setString(1, "%" + searchName.toLowerCase() + "%");
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

	public void deleteAll() throws SQLException{
		try {
			st = getConnection().createStatement();
			rs = st.executeQuery("TRUNCATE TABLE unit;");
		} finally {
			closeResources();
		}
	}

	public void deleteByID(int id) throws SQLException{
		try {
			pst = getConnection().prepareStatement("DELETE FROM unit WHERE id = ?;");
			pst.setInt(1, id);
			pst.execute();
		} finally {
			closeResources();
		}
	}

}

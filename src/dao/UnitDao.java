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

	//	EntityManagerFactory emf = Persistence.createEntityManagerFactory(
	//			"my-hsql-unit");
	//	EntityManager em = emf.createEntityManager();
	//
	//	public void save(Unit unit) {
	//		em.getTransaction().begin();
	//
	//		if (unit.getId() == null) {
	//			em.persist(unit);
	//		} else {
	//			em.merge(unit);
	//		}
	//
	//		em.getTransaction().commit();
	//	}

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
	//			ps.setLong(2, 3L); // MUUDA
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
	//			ps.setLong(1, 3L);
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
	public void findAll2() throws SQLException {
		Connection conn = DriverManager.getConnection(DB_URL);
		Statement stmt = null;
		ResultSet rset = null;
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery("SELECT id, name, code FROM UNIT"); // ERROR
			while (rset.next()) {
				long id = rset.getLong("id");
				String name = rset.getString("name");
				String code = rset.getString("code");
				System.out.println("id " + id + " name " + name + " code " + code);
				//System.out.println(rset.getLong(1)); //  + ", " + rset.getString(2) + ", " + rset.getString(3)
			}
//			rset = stmt.executeQuery("SELECT * FROM UNIT"); // ERROR
//			System.out.println(rset.toString());
		} finally {
			closeResources();
		}
	}
	
	public List<Unit> findAll () throws SQLException{
		List<Unit> units = new ArrayList<Unit>();
		try {
			st=getConnection().createStatement();
			while(rs.next()){
				Unit unit = new Unit();
				unit.setName(rs.getString(1));
				units.add(unit); 
			}
		} finally {
			closeResources();
		}
		return units;
	}

}

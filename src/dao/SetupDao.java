package dao;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbutils.DbUtils;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.SQLExec;

public class SetupDao extends AbstractDao {

    public void createSchema() {
        executeSqlFromFile(getClassPathFile("schema.sql"));
    }
    
    public void createDefaultValues() {
    	executeSqlFromFile(getClassPathFile("testData.sql"));
    }
    
    public void destroy() {
    	executeQuery("DROP SCHEMA PUBLIC CASCADE;");
    }
    
    private String getClassPathFile(String fileName) {
        return getClass().getClassLoader().getResource(fileName).getFile();
    }

    private void executeSqlFromFile(String sqlFilePath) {

        Project project = new Project();
        project.init();

        SQLExec e = new SQLExec();
        e.setProject(project);
        e.setTaskType("sql");
        e.setTaskName("sql");
        e.setSrc(new File(sqlFilePath));
        e.setDriver("org.hsqldb.jdbcDriver");
        e.setUserid("sa");
        e.setPassword("");
        e.setUrl(DB_URL);
        e.execute();
    }
    
    private void updateUnit() throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL);

        PreparedStatement ps = null;
        Statement stmt = null;
        try {
            ps = conn.prepareStatement(
                    "UPDATE unit SET name = ? WHERE id = ?");
            ps.setString(1, "Mary"); // MUUDA
            ps.setLong(2, 3L); // MUUDA

            int rowCount = ps.executeUpdate();
            System.out.println(rowCount + " rows updated!");

        } finally {
            DbUtils.closeQuietly(stmt);
            DbUtils.closeQuietly(conn);
        }
    }

    private void printCertainUnit() throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL);

        PreparedStatement ps = null;
        Statement stmt = null;
        ResultSet rset = null;
        try {
            ps = conn.prepareStatement("SELECT id, name FROM unit "
                    + "WHERE id = ?");
            ps.setLong(1, 3L);
            rset = ps.executeQuery();
            while (rset.next()) {
                System.out.println(rset.getInt(1) + ", " + rset.getString(2));
            }
        } finally {
            DbUtils.closeQuietly(rset);
            DbUtils.closeQuietly(stmt);
            DbUtils.closeQuietly(conn);
        }
    }

    private void printUnits() throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL);

        Statement stmt = null;
        ResultSet rset = null;
        try {
            stmt = conn.createStatement();
            rset = stmt.executeQuery("SELECT id, name FROM unit");
            while (rset.next()) {
                System.out.println(rset.getLong(1) + ", " + rset.getString(2));
            }
        } finally {
            DbUtils.closeQuietly(rset);
            DbUtils.closeQuietly(stmt);
            DbUtils.closeQuietly(conn);
        }
    }

    private void createTable() throws SQLException {

        Connection conn = DriverManager.getConnection(DB_URL);
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(
                    "CREATE TABLE unit (id INT, name VARCHAR(100))"); // MUUDA
        } finally {
            DbUtils.closeQuietly(stmt);
            DbUtils.closeQuietly(conn);
        }
    }    
    
}

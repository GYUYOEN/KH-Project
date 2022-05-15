package conn.db;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;


public class DBConn {
	private final static String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	private final static String BASE_URL = "jdbc:oracle:thin:@";
	
	private String url_address;
	private Connection conn;
	private Statement stat;

	public DBConn(String domain, String port, String serviceName, String username, String password) throws Exception {
		url_address = String.format("%s:%s/%s", domain, port, serviceName);
		this.initConnect(username, password);
	}
	
	public DBConn(String tnsAlias, String walletPath, String username, String password) throws Exception {
		url_address = String.format("%s?TNS_ADMIN=%s", tnsAlias, walletPath);
		this.initConnect(username, password);
	}
	
	private void initConnect(String username, String password) throws Exception {
		Class.forName(DRIVER_NAME);

		conn = DriverManager.getConnection(BASE_URL + url_address, username, password);
		
		conn.setAutoCommit(false);
		
		stat = conn.createStatement();
	}
	
	public ResultSet sendSelectQuery(String sql) throws Exception {
		ResultSet rs = this.stat.executeQuery(sql);
		return rs;
	}
	
	public int sendUpdateQuery(String sql) throws Exception {
		int rs = this.stat.executeUpdate(sql);
		return rs;
	}
	
	public int sendInsertQuery(String sql) throws Exception {
		int rs = this.stat.executeUpdate(sql);
		return rs;
	}
	
	public int sendDeleteQuery(String sql) throws Exception {
		int rs = this.stat.executeUpdate(sql);
		return rs;
	}
	
	public void commit() throws Exception {
		this.conn.commit();
	}
	
	public void rollback() throws Exception {
		this.conn.rollback();
	}
	
	public void close() throws Exception {
		this.stat.close();
		this.conn.close();
	}

}
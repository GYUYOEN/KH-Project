package pocketmon.dao;

import java.sql.ResultSet;

import conn.db.DBConn;
import pocketmon.vo.PocketmonVO;

public class PocketmonDAO {
	private DBConn db;
	
	public PocketmonDAO() {
		try {
			db = new DBConn("localhost", "1521", "XEPDB1", "semi", "semi");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean register(PocketmonVO data) {
		String query = String.format(
					  "INSERT INTO pocketmon_book VALUES('%s', '%s', %d)"
					 , data.getPocketmonInitName()
					 , data.getPocketmonName()
					 , data.getPocketmonLevel());
		int rs ;
		try {
			rs = db.sendInsertQuery(query);
			if(rs == 1) {
				db.commit();
				return true;
			}
			db.rollback();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean update(PocketmonVO data) {
		String query = String.format(
				"UPDATE pocketmon_book SET pocketmon_name = '%s' WHERE pocketmon_initname = '%s'" 
						, data.getPocketmonName()
						, data.getPocketmonInitName());
		int rs ;
		try {
			rs = db.sendInsertQuery(query);
			if(rs == 1) {
				db.commit();
				return true;
			}
			db.rollback();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean update2(PocketmonVO data) {
		String query = String.format(
				"UPDATE pocketmon_book SET pocketmon_level = %d WHERE pocketmon_initname = '%s'" 
						, data.getPocketmonLevel()
						, data.getPocketmonInitName());
		int rs ;
		try {
			rs = db.sendInsertQuery(query);
			if(rs == 1) {
				db.commit();
				return true;
			}
			db.rollback();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean remove(PocketmonVO data) {
		String query = String.format("DELETE FROM pocketmon_book WHERE pocketmon_name = '" + data.getPocketmonName() + "'");
		try {	
			int rs = db.sendDeleteQuery(query);
			if(rs == 1) {
				db.commit();
				return true;
			}
			db.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public PocketmonVO get(String pocketmon) {
		String query = String.format("SELECT * FROM pocketmon_book WHERE pocketmon_initname = '%s'", pocketmon);
		try {
			ResultSet rs = db.sendSelectQuery(query);
			if(rs.next()) {
				PocketmonVO data = new PocketmonVO();
				data.setPocketmonName(rs.getString("pocketmon_initname"));
				data.setPocketmonName(rs.getString("pocketmon_name"));
				data.setPocketmonLevel(rs.getInt("pocketmon_level"));
				return data;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}

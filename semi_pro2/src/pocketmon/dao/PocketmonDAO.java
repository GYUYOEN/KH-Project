package pocketmon.dao;

import conn.db.DBConn;
import pocketmon.vo.PocketmonVO;

public class PocketmonDAO {
	private DBConn db;
	
	public PocketmonDAO() {
		try {
			db = new DBConn("localhost", "1521", "XEPDB1", "semi2", "semi2");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean register(PocketmonVO data) {
		String query = String.format(
					  "INSERT INTO pocketmon_book VALUES('%s', %d)"
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
				"UPDATE pocketmon_book SET pocketmon_level = '%s' WHERE pocketmon_name = '%s'" 
						, data.getPocketmonLevel()
						, data.getPocketmonName());
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
		String query = "DELETE FROM pocketmon_book WHERE pocketmon_name = '" + data.getPocketmonName() + "'";
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
	
}

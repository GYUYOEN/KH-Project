package pocketmon.dao;

import java.sql.ResultSet;

import conn.db.DBConn;
import join.vo.JoinVO;
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
	
	public boolean registerBook(PocketmonVO data) {
		String query = String.format(
					  "INSERT INTO pocketmon_book VALUES('%s', '%s', %d)"
					 , data.getPocketmonInitName()
					 , data.getPocketmonNowName()
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
	
	public boolean registerODoctor(PocketmonVO data) {
		String query = String.format(
					  "INSERT INTO pocketmon_odoctor_home VALUES('%s', '%s', %d)"
					 , data.getPocketmonInitName()
					 , data.getPocketmonNowName()
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
	
	public boolean updateName(PocketmonVO data) {
		String query = String.format(
				"UPDATE pocketmon_book SET pocketmon_nowname = '%s' WHERE pocketmon_initname = '%s'" 
						, data.getPocketmonNowName()
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
	
	public boolean updateLevel(PocketmonVO data) {
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

	public boolean removeBook(PocketmonVO data) {
		String query = String.format("DELETE FROM pocketmon_book WHERE pocketmon_nowname = '" + data.getPocketmonNowName() + "'");
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
	
	public boolean removeODoctor(PocketmonVO data) {
		String query = String.format("DELETE FROM pocketmon_odoctor_home WHERE pocketmon_nowname = '" + data.getPocketmonNowName() + "'");
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
	
	public PocketmonVO getODoctor(String pocketmon) {
		String query = String.format("SELECT * FROM pocketmon_odoctor_home WHERE pocketmon_nowname = '%s'", pocketmon);
		try {
			ResultSet rs = db.sendSelectQuery(query);
			while(rs.next()) {
				PocketmonVO data = new PocketmonVO();
				data.setPocketmonInitName(rs.getString("pocketmon_initname"));
				data.setPocketmonNowName(rs.getString("pocketmon_nowname"));
				data.setPocketmonLevel(rs.getInt("pocketmon_level"));
				return data;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public PocketmonVO getBook(String pocketmon) {
		String query = String.format("SELECT * FROM pocketmon_book WHERE pocketmon_nowname = '%s'", pocketmon);
		try {
			ResultSet rs = db.sendSelectQuery(query);
			if(rs.next()) {
				PocketmonVO data = new PocketmonVO();
				data.setPocketmonInitName(rs.getString("pocketmon_initname"));
				data.setPocketmonNowName(rs.getString("pocketmon_nowname"));
				data.setPocketmonLevel(rs.getInt("pocketmon_level"));
				return data;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public JoinVO getJoin(String userid) {
		String query = String.format("SELECT * FROM members_manager WHERE USERID = '%s'", userid);
		try {
			ResultSet rs = db.sendSelectQuery(query);
			if(rs.next()) {
				JoinVO data = new JoinVO();
				data.setUserid(rs.getString("userid"));
				data.setUserpw(rs.getString("userpw"));
				data.setNickname(rs.getString("nickname"));
				data.setCreateDate(rs.getDate("createdate"));
				return data;
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean registerJoin(JoinVO data) {
		String query = String.format(
				"INSERT INTO members_manager VALUES('%s', '%s', '%s', SYSDATE)"
			   , data.getUserid()
			   , data.getUserpw()
			   , data.getNickname()
			   , data.getCreateDate());
		int rs;
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

	
}

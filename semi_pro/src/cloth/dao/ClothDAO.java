package cloth.dao;

import java.io.File;

import com.join.vo.JoinVo;

import cloth.vo.ClothVO;
import conn.db.DBConn;

public class ClothDAO {
	private DBConn db;
	
	public ClothDAO() {
		try {
			db = new DBConn(new File(System.getProperty("user.home") + "/oracle_db.conf"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean register(ClothVO data) {
		String query = "INSERT INTO ";
		int rs = db.sendInsertQuery();
		if(rs == 1) {
			db.commit();
			return true;
		}
		return false;
	}
}

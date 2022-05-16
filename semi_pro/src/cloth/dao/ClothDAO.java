package cloth.dao;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import cloth.vo.ClothVO;

import cloth.vo.ClothVO;

import cloth.vo.ClothVO;

import cloth.vo.ClothVO;
import conn.db.DBConn;

public class ClothDAO {
	private DBConn db;
	
	public ClothDAO() {
		try {
			db = new DBConn("localhost", "1521", "XEPDB1", "semi2", "semi2");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean register(ClothVO data) {
		String query = String.format("INSERT INTO spring_top_clothes VALUES('%s', %d)"
					  , data.getPocketmonName()
					  , data.getPrice()
					  , data.getKind()
					  , data.getAppearance()
					  , data.getColor());
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean update(ClothVO data) {
		try {
			String query = "UPDATE spring_top_clothes"
					+ "        SET PRICE = '" + data.getPrice() + "'"
					+ "          , KIND = '" + data.getKind() + "'"
					+ "          , APPEARANCE = '" + data.getAppearance() + "'"
					+ "          , COLOR = " + data.getColor()
					+ "      WHERE BRAND = '" + data.getBrand() + "'";
			int rs = db.sendUpdateQuery(query);
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
	
	public boolean remove(ClothVO data) {
		String query = "DELETE FROM spring_top_clothes WHERE BRAND = '" + data.getBrand() + "'";
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
	
	public ClothVO get(String brand) {
		String query = String.format("SELECT * FROM spring_top_clothes WHERE BRAND = '%s'", brand);
		try {
			ResultSet rs = db.sendSelectQuery(query);
			if(rs.next()) {
				ClothVO data = new ClothVO();
				data.setBrand(rs.getString("brand"));
				data.setPrice(rs.getInt("price"));
				data.setKind(rs.getString("kind"));
				data.setAppearance(rs.getString("appearance"));
				data.setColor(rs.getString("color"));
				return data;
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

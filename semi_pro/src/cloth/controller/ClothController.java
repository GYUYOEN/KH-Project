package cloth.controller;

import cloth.vo.ClothVO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cloth.vo.ClothVO;

import cloth.dao.ClothDAO;
import cloth.vo.ClothVO;

public class ClothController {
	private ClothDAO dao = new ClothDAO();
	
	public boolean cloth(ClothVO data) {
		ClothVO info = dao.get(data.getBrand());
		
		if(info != null) {
			return false;
		}
		
		boolean result = dao.register(data);
		return result;
	}
	
	public boolean update(ClothVO data) {
		return dao.update(data);
	}
	
	public boolean remove(ClothVO data) {
		return dao.remove(data);
	}
	
	
}

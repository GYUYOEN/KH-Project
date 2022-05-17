package pocketmon.controller;

import pocketmon.dao.PocketmonDAO;
import pocketmon.vo.PocketmonVO;

public class PocketmonController {
	private PocketmonDAO dao = new PocketmonDAO();
	
	public boolean registerBook(PocketmonVO data) {
		
		PocketmonVO pocketmon = dao.getBook(data.getPocketmonInitName());
		
		if(pocketmon != null) {
			return false;
		}
		
		boolean result = dao.registerBook(data);
		return result;
	}
	
	public boolean registerODoctor(PocketmonVO data) {
		
		PocketmonVO pocketmon = dao.getODoctor(data.getPocketmonInitName());
		
		if(pocketmon != null) {
			return false;
		}
		
		
		boolean result = dao.registerODoctor(data);
		return result;
	}
	
	public boolean updateName(PocketmonVO data) {
		return dao.updateName(data);
	}
	
	public boolean updateLevel(PocketmonVO data) {
		return dao.updateLevel(data);
	}

	public boolean removeBook(PocketmonVO data) {
		return dao.removeBook(data);
	}
	
	public boolean removeODoctor(PocketmonVO data) {
		return dao.removeODoctor(data);
	}
}

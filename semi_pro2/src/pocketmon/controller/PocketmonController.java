package pocketmon.controller;

import pocketmon.dao.PocketmonDAO;
import pocketmon.vo.PocketmonVO;

public class PocketmonController {
	private PocketmonDAO dao = new PocketmonDAO();
	
	public boolean pocketmon(PocketmonVO data) {
		
		PocketmonVO pocketmon = dao.get(data.getPocketmonInitName());
		
		if(pocketmon != null) {
			return false;
		}
		
		boolean result = dao.register(data);
		return result;
	}
	
	public boolean update(PocketmonVO data) {
		return dao.update(data);
	}
	
	public boolean update2(PocketmonVO data) {
		return dao.update2(data);
	}

	public boolean remove(PocketmonVO data) {
		return dao.remove(data);
	}
}

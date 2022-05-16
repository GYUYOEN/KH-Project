package pocketmon.controller;

import pocketmon.dao.PocketmonDAO;
import poketmon.vo.PocketmonVO;

public class PocketmonController {
	private PocketmonDAO dao = new PocketmonDAO();
	
	public boolean pocketmon(PocketmonVO data) {
		
		String info = data.getPocketmonName();
		if(info == null) {
			return false;
		}
		
		boolean result = dao.register(data);
		return result;
	}
	
	public boolean update(PocketmonVO data) {
		return dao.update(data);
	}

	public boolean remove(PocketmonVO data) {
		return dao.remove(data);
	}
}

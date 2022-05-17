package exam;

import java.util.Scanner;

import javax.xml.crypto.Data;

import pocketmon.controller.PocketmonController;
import pocketmon.dao.PocketmonDAO;
import pocketmon.vo.PocketmonVO;

public class Test {
	private static PocketmonDAO dao = new PocketmonDAO();
	private static Scanner sc = new Scanner(System.in);
	private static PocketmonController pc = new PocketmonController();
	
	public static void main(String args[]) {
		PocketmonVO data = new PocketmonVO();
		System.out.println("오박사에게 가져올 포켓몬 이름을 작성하세요.");
		String input = sc.nextLine();
		data = dao.getODoctor(input);
		
		boolean check1 = pc.registerBook(data);
	}
}

package pocketmon.view;

import java.util.Random;
import java.util.Scanner;

import pocketmon.controller.PocketmonController;
import pocketmon.dao.PocketmonDAO;
import pocketmon.vo.PocketmonVO;

public class PocketmonView {
	 
	 private Scanner sc = new Scanner(System.in);
	 private Random rand = new Random();
	 private PocketmonController pc = new PocketmonController();
	 private PocketmonDAO dao = new PocketmonDAO();
	 private int pocketmonLevel = 1;
	 
	 public void show() throws Exception {
		 System.out.println("1. 포켓몬 잡기");
		 System.out.println("2. 포켓몬 진화");
		 System.out.println("3. 포켓몬 오박사한테 보내기");
		 System.out.print(">>> ");
		 
		 String input = sc.nextLine();
		 
		 switch(input) {
		 	case "1" :
		 		this.pocketmonCatch();
		 		break;
		 	case "2" :
		 		this.pocketmonUpgrade();
		 		break;
		 	case "3" :
		 		this.pocketmonDelete();
		 		break;
		 	default :
		 		System.out.println("잘못입력");
		 }
	 }
	 
	 private void pocketmonCatch() throws Exception {
		 PocketmonVO data = new PocketmonVO();
		 String[] pocketmons = {"피카츄", "파이리", "꼬부기"};
		 int catchCount = 3;
		 String pocketmon = "";
		
		 while(true) {
			 boolean[] result = {true, false};
			 pocketmon = pocketmons[rand.nextInt(3)];
		
			 System.out.println("포켓몬 잡는중...");
			 Thread.sleep(2000);
			
			 if(result[rand.nextInt(2)]) {	
				 System.out.println(pocketmon + "를 잡았습니다!!");
				 System.out.print("잡은 포켓몬 : ");
				 System.out.println(pocketmon);
				 data.setPocketmonInitName(pocketmon);
				 data.setPocketmonName(pocketmon);
				 data.setPocketmonLevel(pocketmonLevel);
				 break;
			 } else  {
				 System.out.println("놓쳤습니다ㅠㅠ 다시잡아보세요!");
				 catchCount--;
				
				 if(catchCount == 0) {
					 System.out.println("포켓몬 잡는데 실패하였습니다ㅠㅠ");
					 break;
				}
			}
		}
		
		boolean check = pc.pocketmon(data);
		
		if(check) {
			System.out.println("포켓몬이 도감에 등록되었습니다.");
		} else {
			System.out.println("중복되는 포켓몬이 있어 도감에 등록되지 않았습니다.");
		}
	}
	
	private void pocketmonUpgrade() {
		PocketmonVO data = new PocketmonVO();
		System.out.println("1. 진화구슬 수확");
		System.out.println("2. 결투");
		System.out.print(">>> ");
		String input = sc.nextLine();
		
		switch(input) {
			case "1":
				boolean[] result1 = {true, false};
				if(result1[rand.nextInt(2)]) {
					System.out.println("진화구슬을 획득하였습니다. 진화하시겠습니까?");
					System.out.println("1. YES ");
					System.out.println("2. NO ");
					System.out.print(">>> ");
				} else {
					System.out.println("진화구슬을 획득하지 못하였습니다.");
				}
				
				input = sc.nextLine();
				
				switch(input) {
					case "1":
						System.out.println("진화시킬 포켓몬을 선택하세요.");
						input = sc.nextLine();
						data.setPocketmonInitName(input);
						if(input.equals("피카츄")) {
							data.setPocketmonName("라이츄");
						} else if(input.equals("꼬부기")) {
							data.setPocketmonName("어니부기");
						} else if(input.equals("파이리")) {
							data.setPocketmonName("리자드");
						}
						break;
					case "2":
						break;
				}
				break;
			case "2":
				System.out.println("결투에 보낼 포켓몬을 선택하세요.");
				input = sc.nextLine();
				boolean[] result2 = {true, false};
				if(result2[rand.nextInt(2)]) {
					System.out.println("결투에서 이겼습니다!");
					System.out.println(data.getPocketmonName());
					int res = data.getPocketmonLevel() + 1;
					data.setPocketmonLevel(res);
					if(pocketmonLevel == 10) {
						if(input.equals("피카츄")) {
							data.setPocketmonName("라이츄");
						} else if(input.equals("꼬부기")) {
							data.setPocketmonName("어니부기");
						} else if(input.equals("파이리")) {
							data.setPocketmonName("리자드");
						}
					}
				} else {
					System.out.println("결투에서 졌습니다ㅠㅠ");
					pocketmonLevel--;
				}
				break;
		}
		
		boolean check = pc.update(data);
		if(check) {
			System.out.println("진화하였습니다.");
		} else {
			System.out.println("진화하지 못하였습니다.");
		}
	}
	private void pocketmonDelete() {
		PocketmonVO data = new PocketmonVO();
		System.out.println("오박사에게 보낼 포켓몬 이름을 작성하세요.");
		String input = sc.nextLine();
		data.setPocketmonName(input);
		
		boolean check = pc.remove(data);
		
		if(check) {
			System.out.println("오박사한테 보냈습니다.");
			return;
		} else {
			System.out.println("오박사한테 보내지 못했습니다.");
		}
		
	}

}

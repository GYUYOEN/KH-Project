package pocketmon.view;

import java.util.Random;
import java.util.Scanner;

import pocketmon.controller.PocketmonController;
import pocketmon.dao.PocketmonDAO;
import pocketmon.initname.PocketmonInitName;
import pocketmon.vo.PocketmonVO;

public class PocketmonView {
	 
	 private Scanner sc = new Scanner(System.in);
	 private Random rand = new Random();
	 private PocketmonController pc = new PocketmonController();
	 private PocketmonDAO dao = new PocketmonDAO();
	 private int pocketmonInitLevel = 1;
	 
	 public void show() throws Exception {
		 while(true) {
			 System.out.println("1. 포켓몬 잡기");
			 System.out.println("2. 포켓몬 진화 구슬 수확하기");
			 System.out.println("3. 결투 신청하기");
			 System.out.println("4. 포켓몬 오박사한테 보내기");
			 System.out.println("5. 오박사한테 포켓몬 받기");
			 System.out.print(">>> ");
		 
			 String input = sc.nextLine();
		 
			 switch(input) {
		 		case "1" :
		 			this.pocketmonCatch();
		 			break;
		 		case "2" :
		 			this.pocketmonDirectUpgrade();
		 			break;
		 		case "3" :
		 			this.pocketmonFightUpdrade();
		 			break;
		 		case "4" :
		 			this.pocketmonSend();
		 			break;
		 		case "5" :
		 			this.pocketmonTake();
		 			break;
		 		default :
		 			System.out.println("잘못입력");
			 }
		 }
	 }

	private void pocketmonCatch() throws Exception {
		 PocketmonVO data = new PocketmonVO();
		 String[] pocketmons = {"피카츄", "파이리", "꼬부기", "이상해씨", "고라파덕", 
				 			"피죤", "푸린", "야도란", "식스테일", "모다피"};
		 int catchCount = 3;
		 String pocketmon = "";

			 boolean[] result = {true, false};
			 pocketmon = pocketmons[rand.nextInt(10)];
			 System.out.println(pocketmon + " 이/가 나타났습니다!!");
			 System.out.println("잡으시겠습니까?");
			 System.out.println("1. YES ");
			 System.out.println("2. NO ");
			 System.out.print(">>> ");
			 String input = sc.nextLine();
			 
			 switch(input) {
			 	case "1":
			 		while(true) {
			 		System.out.println("포켓몬 잡는중...");
			 		Thread.sleep(2000);
			 		
			 		if(result[rand.nextInt(2)]) {	
			 			System.out.println(pocketmon + " 를 잡았습니다!!");
			 			data.setPocketmonInitName(pocketmon);
			 			data.setPocketmonNowName(pocketmon);
			 			data.setPocketmonLevel(pocketmonInitLevel);
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
			 	case "2":
			 		break;
			 	default :
			 		System.out.println("잘못입력");
			 }
			 
			 boolean check = pc.registerBook(data);
			 
			 if(check) {
				 System.out.println("포켓몬이 도감에 등록되었습니다.");
			 } else {
				 System.out.println("중복되는 포켓몬이 있어 도감에 등록되지 않았습니다.");
			 }
	}
	
	private void pocketmonDirectUpgrade() throws Exception {
		PocketmonVO data = new PocketmonVO();
		
		System.out.println("구슬 수확하는 중...");
		Thread.sleep(2000);
		
		boolean[] result1 = {true, false};
		if(result1[rand.nextInt(2)]) {
			System.out.println("진화구슬을 획득하였습니다. 진화하시겠습니까?");
			System.out.println("1. YES ");
			System.out.println("2. NO ");
			System.out.print(">>> ");
			String input = sc.nextLine();
		
			switch(input) {
				case "1":
					System.out.println("진화시킬 포켓몬을 선택하세요.");
					input = sc.nextLine();
					data = dao.getBook(input);
					if(input.equals("피카츄")) {
						data.setPocketmonNowName("라이츄");
					} else if(input.equals("꼬부기")) {
						data.setPocketmonNowName("어니부기");
					} else if(input.equals("파이리")) {
						data.setPocketmonNowName("리자드");
					} else if(input.equals("이상해씨")) {
						data.setPocketmonNowName("이상해풀");
					} else if(input.equals("푸린")) {
						data.setPocketmonNowName("푸크린");
					} else if(input.equals("식스테일")) {
						data.setPocketmonNowName("나인테일");
					} else if(input.equals("피죤")) {
						data.setPocketmonNowName("피죤투");
					} else if(input.equals("모다피")) {
						data.setPocketmonNowName("우츠동");
					} else if(input.equals("야돈")) {
						data.setPocketmonNowName("야도란");
					} else if(input.equals("고라파덕")) {
						data.setPocketmonNowName("골덕");
					} 
					
					System.out.println("진화에 성공했습니다!");
					boolean check = pc.updateName(data);
				break;
			case "2":
				break;
			default :
				System.out.println("잘못입력");
			}
		} else {
			System.out.println("진화구슬을 획득하지 못하였습니다.");
		}
	}


	private void pocketmonFightUpdrade() throws Exception {
		PocketmonVO data = new PocketmonVO();
		System.out.println("결투에 보낼 포켓몬을 선택하세요.");
		String input = sc.nextLine();
		
		System.out.println("결투진행 중...");
		Thread.sleep(3000);
		
		boolean[] result2 = {true, false};
		
		if(result2[rand.nextInt(2)]) {
			System.out.println("결투에서 이겼습니다!");
			data = dao.getBook(input);
			data.setPocketmonLevel(data.getPocketmonLevel()+1);
			if(data.getPocketmonLevel() == 5) {
				if(input.equals("피카츄")) {
					data.setPocketmonNowName("라이츄");
				} else if(input.equals("꼬부기")) {
					data.setPocketmonNowName("어니부기");
				} else if(input.equals("파이리")) {
					data.setPocketmonNowName("리자드");
				}
				data.setPocketmonLevel(pocketmonInitLevel);
			} 
		} else {
			System.out.println("결투에서 졌습니다ㅠㅠ");
			data = dao.getBook(input);
			data.setPocketmonLevel(data.getPocketmonLevel()-1);
			if(data.getPocketmonLevel() == 0) {
				data.setPocketmonLevel(pocketmonInitLevel);
			}
		}
		
		boolean check1 = pc.updateLevel(data);
		boolean check2 = pc.updateName(data);
	}
	
	private void pocketmonSend() {
		PocketmonVO data = new PocketmonVO();
		System.out.println("오박사에게 보낼 포켓몬 이름을 작성하세요.");
		String input = sc.nextLine();
		data = dao.getBook(input);
		
		boolean check1= pc.registerODoctor(data);
		boolean check2 = pc.removeBook(data);
	}
	
	private void pocketmonTake() {
		PocketmonVO data = new PocketmonVO();
		System.out.println("오박사에게 가져올 포켓몬 이름을 작성하세요.");
		String input = sc.nextLine();
		data = dao.getODoctor(input);
		
		boolean check1 = pc.registerBook(data);
		boolean check2 = pc.removeODoctor(data);
		
	}

}

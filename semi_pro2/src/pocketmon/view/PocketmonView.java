package pocketmon.view;

import java.util.Random;
import java.util.Scanner;

import pocketmon.controller.PocketmonController;
import pocketmon.vo.PocketmonVO;

public class PocketmonView {
	 
	 private Scanner sc = new Scanner(System.in);
	 private Random rand = new Random();
	 private PocketmonController pc = new PocketmonController();
	 private int pocketmonLevel = 1;
	 private int fightStack = 1;
	 
	 public void show() {
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
	private void pocketmonCatch() {
		PocketmonVO data = new PocketmonVO();
		String[] pocketmons = {"피카츄", "파이리", "꼬부기"};
		int catchCount = 3;
		String pocketmon = "";
		
		while(true) {
			boolean[] result = {true, false};
			pocketmon = pocketmons[rand.nextInt(3)];
		
			if(result[rand.nextInt(2)]) {
				System.out.println(pocketmon + "를 잡았습니다!!");
				System.out.print("잡은 포켓몬 : ");
				System.out.println(pocketmon);
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
			System.out.println("포켓몬이 도감에 등록되지 않았습니다.");
		}
	}
	
	private void pocketmonUpgrade() {
		PocketmonVO data = new PocketmonVO();
		System.out.println("1. 진화구슬 획득");
		System.out.println("2. 결투");
		System.out.print(">>> ");
		String input = sc.nextLine();
		
		switch(input) {
			case "1":
				System.out.println("진화구슬을 획득하였습니다. 진화하시겠습니까?");
				System.out.println("1. YES ");
				System.out.println("2. NO ");
				
				input = sc.nextLine();
				
				switch(input) {
					case "1":
						System.out.println("진화시킬 포켓몬을 선택하세요.");
						input = sc.nextLine();
						data.setPocketmonName(input);
						data.setPocketmonLevel(pocketmonLevel++);
						
						break;
					case "2":
						break;
				}
				break;
			case "2":
				boolean[] result = {true, false};
				if(result[rand.nextInt(2)]) {
					System.out.println("결투에서 이겼습니다!");
					fightStack++;
					if(fightStack == 10) {
						data.setPocketmonLevel(pocketmonLevel++);
					}
				} else {
					fightStack--;
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
		if(pc.remove(data)) {
			System.out.println("탈퇴 처리가 완료 되었습니다.");
			return;
		} else {
			System.out.println("탈퇴 처리를 수행할 수 없습니다.");
		}
		
	}

}

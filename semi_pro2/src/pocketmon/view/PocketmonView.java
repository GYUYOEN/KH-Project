package pocketmon.view;

import java.util.Random;
import java.util.Scanner;

import join.vo.JoinVO;
import pocketmon.controller.PocketmonController;
import pocketmon.dao.PocketmonDAO;
import pocketmon.vo.PocketmonVO;

public class PocketmonView {
	 
	 private Scanner sc = new Scanner(System.in);
	 private Random rand = new Random();
	 private PocketmonController pc = new PocketmonController();
	 private PocketmonDAO dao = new PocketmonDAO();
	 private int pocketmonInitLevel = 1;
	 
	 public void show() throws Exception {
		 while(true) {
			 System.out.println("<<< 포켓몬 게임 로그인 화면 >>>");
			 System.out.println("1. 회원가입");
			 System.out.println("2. 로그인");
			 System.out.println("3. 프로그램 종료");
			 System.out.print(">>> ");
			 
			 String input = sc.nextLine();
			 
			 switch(input) {
			 	case "1" :
			 		this.joinMenu(); break;
			 	case "2" :
			 		this.loginMenu(); break;
			 	case "3" :
			 		System.exit(0);
			 	default :
			 		System.out.println("잘못입력");
			 }
		 }
	 }
	 
	private void joinMenu() {
		JoinVO data = new JoinVO();
		
		System.out.print("아이디 : ");
		data.setUserid(sc.nextLine());
		System.out.print("비밀번호 : ");
		data.setUserpw(sc.nextLine());
		System.out.print("닉네임 : ");
		data.setNickname(sc.nextLine());
		
		boolean result = pc.join(data);
		
		if(result) {
			System.out.println("회원가입을 축하합니다.");
		} else {
			System.out.println("회원가입을 할 수 없습니다.(중복된 아이디가 있습니다.)");
		}
	}

	private void loginMenu() throws Exception {
		System.out.print("아이디 : ");
		String userid = sc.nextLine();
		System.out.print("패스워드 : ");
		String userpw = sc.nextLine();
		
		JoinVO account = pc.login(userid, userpw);
		
		if(account != null) {
			System.out.printf("%s 님이 로그인을 하였습니다.\n", account.getNickname());
			this.pocketmonGame();
		} else {
			System.out.println("로그인에 실패히였습니다.");
			this.show();
		}		
	}

 public void pocketmonGame() throws Exception {
		 while(true) {
			 System.out.println("<<< 포켓몬 게임 시작 >>>");
			 System.out.println("1. 포켓몬 잡기");
			 System.out.println("2. 포켓몬 진화 구슬 수확하기");
			 System.out.println("3. 결투 신청하기");
			 System.out.println("4. 포켓몬 오박사한테 보내기");
			 System.out.println("5. 오박사한테 포켓몬 받기");
			 System.out.println("6. 게임종료(로그아웃)");
			 System.out.print(">>> ");
		 
			 String input = sc.nextLine();
		 
			 switch(input) {
		 		case "1" :
		 			this.pocketmonCatch(); break;
		 		case "2" :
		 			this.pocketmonDirectUpgrade(); break;
		 		case "3" :
		 			this.pocketmonFightUpdrade(); break;
		 		case "4" :
		 			this.pocketmonSend(); break;
		 		case "5" :
		 			this.pocketmonTake(); break;
		 		case "6" :
		 			this.show(); break;
		 		default :
		 			System.out.println("잘못입력");
			 }
		 }
	 }

	private void pocketmonCatch() throws Exception {
		PocketmonVO data = new PocketmonVO();
		String[] pocketmons = {"피카츄", "파이리", "꼬부기", "이상해씨", "고라파덕", 
				 			"구구", "푸린", "야도란", "식스테일", "모다피", "삐삐",
				 			"주벳", "디그다", "쏘드라", "치코리타", "깜지곰"};
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
			 
		boolean res = true;
		while(res) {
			switch(input) {
			 	case "1":
			 		System.out.println("포켓몬 잡는중...");
			 		Thread.sleep(2000);
			 		
			 		if(result[rand.nextInt(2)]) {	
			 			System.out.println(pocketmon + " 를 잡았습니다!!");
			 			data.setPocketmonInitName(pocketmon);
			 			data.setPocketmonNowName(pocketmon);
			 			data.setPocketmonLevel(pocketmonInitLevel);
			 			res = false;
			 			break;
			 		} else  {
			 			catchCount--;
			 			if(catchCount == 0) {
			 				System.out.println("포켓몬 잡는데 실패하였습니다ㅠㅠ");
			 				this.pocketmonGame();
			 				break;
			 			}
			 			
			 			System.out.println("놓쳤습니다ㅠㅠ 다시잡아보시겠습니까?");
			 			System.out.println("1. YES");
			 			System.out.println("2. NO");
			 			System.out.print(">>> ");
			 			input = sc.nextLine();
			 			break;
			 		}
			 	case "2":
			 		this.pocketmonGame();
			 		break;
			 	default :
			 		System.out.println("잘못입력");
			 }
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
					} else if(input.equals("어니부기")) {
						data.setPocketmonNowName("거북왕");
					} else if(input.equals("파이리")) {
						data.setPocketmonNowName("리자드");
					} else if(input.equals("리자드")) {
						data.setPocketmonNowName("리자몽");
					} else if(input.equals("이상해씨")) {
						data.setPocketmonNowName("이상해풀");
					} else if(input.equals("이상해풀")) {
						data.setPocketmonNowName("이상해꽃");
					}else if(input.equals("푸린")) {
						data.setPocketmonNowName("푸크린");
					} else if(input.equals("식스테일")) {
						data.setPocketmonNowName("나인테일");
					} else if(input.equals("구구")) {
						data.setPocketmonNowName("피죤");
					} else if(input.equals("피죤")) {
						data.setPocketmonNowName("피죤투");
					} else if(input.equals("모다피")) {
						data.setPocketmonNowName("우츠동");
					} else if(input.equals("우츠동")) {
						data.setPocketmonNowName("우츠보트");
					}  else if(input.equals("야돈")) {
						data.setPocketmonNowName("야도란");
					} else if(input.equals("고라파덕")) {
						data.setPocketmonNowName("골덕");
					} else if(input.equals("삐삐")) {
						data.setPocketmonNowName("픽시");
					} else if(input.equals("주벳")) {
						data.setPocketmonNowName("골벳");
					} else if(input.equals("디그다")) {
						data.setPocketmonNowName("닥트리오");
					} else if(input.equals("쏘드라")) {
						data.setPocketmonNowName("시드라");
					} else if(input.equals("치코리타")) {
						data.setPocketmonNowName("베이리프");
					} else if(input.equals("베이리프")) {
						data.setPocketmonNowName("메가니움");
					} else if(input.equals("깜지곰")) {
						data.setPocketmonNowName("링곰");
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
		data = dao.getBook(input);
		
		if(data.getPocketmonLevel() == 0) {
			System.out.println("포켓몬 상테가 좋지 않아 결투에 참여할 수없습니다.");
			System.out.println("병원에 보내 치료를 받으시겠습니다?");
			System.out.println("1. YES");
			System.out.println("2. NO");
			System.out.print(">>> ");
			input = sc.nextLine();
			
			switch(input) {
				case "1":
					System.out.println("포켓몬 치료중...");
					Thread.sleep(3000);
				
					data.setPocketmonLevel(pocketmonInitLevel);
					System.out.println("치료가 완료되었습니다!");
					break;
				case "2":
					break;
				default :
					System.out.println("잘못입력");
			}	
		} else {
			System.out.println("결투진행 중...");
			Thread.sleep(3000);
			
			boolean[] result2 = {true, false};
		
			if(result2[rand.nextInt(2)]) {
				System.out.println("결투에서 이겼습니다!");
				data.setPocketmonLevel(data.getPocketmonLevel()+1);
			
				if(data.getPocketmonLevel() == 3) {
				
					if(input.equals("피카츄")) {
						data.setPocketmonNowName("라이츄");
					} else if(input.equals("꼬부기")) {
						data.setPocketmonNowName("어니부기");
					} else if(input.equals("어니부기")) {
						data.setPocketmonNowName("거북왕");
					} else if(input.equals("파이리")) {
						data.setPocketmonNowName("리자드");
					} else if(input.equals("리자드")) {
						data.setPocketmonNowName("리자몽");
					} else if(input.equals("이상해씨")) {
						data.setPocketmonNowName("이상해풀");
					} else if(input.equals("이상해풀")) {
						data.setPocketmonNowName("이상해꽃");
					}else if(input.equals("푸린")) {
						data.setPocketmonNowName("푸크린");
					} else if(input.equals("식스테일")) {
						data.setPocketmonNowName("나인테일");
					} else if(input.equals("구구")) {
						data.setPocketmonNowName("피죤");
					} else if(input.equals("피죤")) {
						data.setPocketmonNowName("피죤투");
					} else if(input.equals("모다피")) {
						data.setPocketmonNowName("우츠동");
					} else if(input.equals("우츠동")) {
						data.setPocketmonNowName("우츠보트");
					}  else if(input.equals("야돈")) {
						data.setPocketmonNowName("야도란");
					} else if(input.equals("고라파덕")) {
						data.setPocketmonNowName("골덕");
					} else if(input.equals("삐삐")) {
						data.setPocketmonNowName("픽시");
					} else if(input.equals("주벳")) {
						data.setPocketmonNowName("골벳");
					} else if(input.equals("디그다")) {
						data.setPocketmonNowName("닥트리오");
					} else if(input.equals("쏘드라")) {
						data.setPocketmonNowName("시드라");
					} else if(input.equals("치코리타")) {
						data.setPocketmonNowName("베이리프");
					} else if(input.equals("베이리프")) {
						data.setPocketmonNowName("메가니움");
					} else if(input.equals("깜지곰")) {
						data.setPocketmonNowName("링곰");
					}
					
					data.setPocketmonLevel(pocketmonInitLevel);
				} 
			} else {
				System.out.println("결투에서 졌습니다ㅠㅠ");
				data = dao.getBook(input);
				data.setPocketmonLevel(data.getPocketmonLevel()-1);
				
				if(data.getPocketmonLevel() == 0) {
					System.out.println("포켓몬이 많이 다쳐 더이상 결투에 보낼 수 없습니다.");
					System.out.println("병원에 보내겠습니까?");
					System.out.println("1. YES");
					System.out.println("2. NO");
					System.out.print(">>> ");
					input = sc.nextLine();
				
					switch(input) {
						case "1":
							System.out.println("포켓몬 치료중...");
							Thread.sleep(3000);
						
							data.setPocketmonLevel(pocketmonInitLevel);
							System.out.println("치료가 완료되었습니다!");
							break;
						case "2":
							break;
						default :
							System.out.println("잘못입력");
					}
				}
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
		
		System.out.println("오박사에게 포켓몬을 보냈습니다.");
	}
	
	private void pocketmonTake() {
		PocketmonVO data = new PocketmonVO();
		System.out.println("오박사에게 가져올 포켓몬 이름을 작성하세요.");
		String input = sc.nextLine();
		data = dao.getODoctor(input);
		
		boolean check1 = pc.registerBook(data);
		boolean check2 = pc.removeODoctor(data);
		
		System.out.println("오박사에게 포켓몬을 받았습니다.");
	}

}

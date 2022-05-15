package cloth.view;

import java.util.Scanner;
import cloth.menu.ClothMenu;

public class ClothView {
	private Scanner sc = new Scanner(System.in);
	private ClothMenu cm = new ClothMenu();
	
	public void show() {
		while(true) {
			System.out.print(cm.getMain());
			System.out.print(">>> ");
			String input = sc.nextLine();
			
//			if(input.equals(1)) {
//				input = "spring";	
//			} else if(input.equals(2)) {
//				input = "summer";
//			} else if(input.equals(3)) {
//				input = "fall";
//			} else if(input.equals(4)) {
//				input = "winter";
//			}
//			
			switch(input) {
				case "1" :
					this.springMain(); break;
				case "2" :
					this.summerMain(); break;
				case "3" :
					this.fallMain(); break;
				case "4" :
					this.winterMain(); break;
				default :
					System.out.println("잘못작성하였습니다. 다시 입력하세요.");
			}
		}
	}
	
	public void springMain() {
		System.out.print(cm.springClothMain());	
		System.out.print(">>> ");
		String input = sc.nextLine();
		
		switch(input) {
			case "1" :
			case "2" :
				System.out.println(cm.springClothModify()); break;
			default :
				System.out.println("잘못작성하였습니다. 다시 입력하세요.");
		}
	}
	
	public void summerMain() {
		System.out.print(cm.summerClothMain());	
		System.out.print(">>> ");
		String input = sc.nextLine();
		
		switch(input) {
			case "1" :
			case "2" :
				System.out.println(cm.summerClothModify()); break;
			default :
				System.out.println("잘못작성하였습니다. 다시 입력하세요.");
		}
	}
	
	public void fallMain() {
		System.out.print(cm.fallClothMain());
		System.out.print(">>> ");
		String input = sc.nextLine();
		
		switch(input) {
			case "1" :
			case "2" :
				System.out.println(cm.fallClothModify()); break;
			default :
				System.out.println("잘못작성하였습니다. 다시 입력하세요.");
		}
	}
	
	public void winterMain() {
		System.out.print(cm.winterClothMain());	
		System.out.print(">>> ");
		String input = sc.nextLine();
		
		switch(input) {
			case "1" :
			case "2" :
				System.out.println(cm.winterClothModify()); break;
			default :
				System.out.println("잘못작성하였습니다. 다시 입력하세요.");
		}
	}
}

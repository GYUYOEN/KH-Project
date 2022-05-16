package cloth.view;

import java.util.Scanner;

import cloth.controller.ClothController;
import cloth.menu.ClothMenu;
import cloth.vo.ClothVO;

public class ClothView {
	private Scanner sc = new Scanner(System.in);
	private ClothMenu cm = new ClothMenu();
	private ClothController cc = new ClothController();
	
	public void show() {
		while(true) {
			System.out.print(cm.getMain());
			System.out.print(">>> ");
			String input = sc.nextLine();
					
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
		System.out.print(cm.clothMain());	
		System.out.print(">>> ");
		String input = sc.nextLine();
		
		switch(input) {
			case "1" :
				this.springRandom(); break;
			case "2" :
				this.springModify(); break;
			default :
				System.out.println("잘못작성하였습니다. 다시 입력하세요.");
		}
	}
	
	public void springRandom() {}
	
	public void springModify() {
		System.out.println(cm.clothModify());
		System.out.print(">>> ");
		String input = sc.nextLine();
		
		switch(input) {
			case "1" :
				this.insert(); break;
			case "2" :
				this.update(); break;
			case "3" :
				this.delete(); break;
			default :
				System.out.println("잘못작성하였습니다. 다시 입력하세요.");
		}
	}

	public void summerMain() {
		System.out.print(cm.clothMain());	
		System.out.print(">>> ");
		String input = sc.nextLine();
		
		switch(input) {
			case "1" :
				this.summerRandom(); break;
			case "2" :
				this.summerModify(); break;
			default :
				System.out.println("잘못작성하였습니다. 다시 입력하세요.");
		}
	}
	
	public void summerRandom() {}
	
	public void summerModify() {
		System.out.println(cm.clothModify());
		System.out.print(">>> ");
		String input = sc.nextLine();
		
		switch(input) {
		case "1" :
			this.insert(); break;
		case "2" :
			this.update(); break;
		case "3" :
			this.delete(); break;
		default :
			System.out.println("잘못작성하였습니다. 다시 입력하세요.");
		}
		
		ClothVO data = new ClothVO();
		
		boolean result = cc.cloth(data);
		
		if(result) {
			System.out.println("옷이 등록되었습니다.");
		} else {
			System.out.println("옷을 등록하지 못하였습니다.");
		}
	}

	public void fallMain() {
		System.out.print(cm.clothMain());
		System.out.print(">>> ");
		String input = sc.nextLine();
		
		switch(input) {
			case "1" :
				this.fallRandom();
			case "2" :
				this.fallModify(); break;
			default :
				System.out.println("잘못작성하였습니다. 다시 입력하세요.");
		}
	}
	
	public void fallRandom() {}
	
	public void fallModify() {
		System.out.println(cm.clothModify());
		System.out.print(">>> ");
		String input = sc.nextLine();
		
		switch(input) {
		case "1" :
			this.insert(); break;
		case "2" :
			this.update(); break;
		case "3" :
			this.delete(); break;
		default :
			System.out.println("잘못작성하였습니다. 다시 입력하세요.");
		}
		
		ClothVO data = new ClothVO();
		
		boolean result = cc.cloth(data);
		
		if(result) {
			System.out.println("옷이 등록되었습니다.");
		} else {
			System.out.println("옷을 등록하지 못하였습니다.");
		}
	}

	public void winterMain() {
		System.out.print(cm.clothMain());	
		System.out.print(">>> ");
		String input = sc.nextLine();
		
		switch(input) {
			case "1" :
				this.winterRandom(); break;
			case "2" :
				this.winterModify(); break;
			default :
				System.out.println("잘못작성하였습니다. 다시 입력하세요.");
		}
	}
	
	public void winterRandom() {}
	
	public void winterModify() {
		System.out.println(cm.clothModify());
		System.out.print(">>> ");
		String input = sc.nextLine();
		
		switch(input) {
		case "1" :
			this.insert(); break;
		case "2" :
			this.update(); break;
		case "3" :
			this.delete(); break;
		default :
			System.out.println("잘못작성하였습니다. 다시 입력하세요.");
		}
		
		ClothVO data = new ClothVO();
		
		boolean result = cc.cloth(data);
		
		if(result) {
			System.out.println("옷이 등록되었습니다.");
		} else {
			System.out.println("옷을 등록하지 못하였습니다.");
		}
	}
	
	private void insert() {
		System.out.println(cm.clothSplit());
		System.out.print(">>> ");
		String input = sc.nextLine();
		
		switch(input) {
			case "1" :
				this.clothTop(); break;
			case "2" :
				this.clothBottom(); break;
			default :
				System.out.println("잘못입력");
		}
	}
	
	private void update(ClothVO info) {
		String input = "";
		
		System.out.println("변경할 가격 : ");
		input = sc.nextLine();
		input = input.isEmpty() ? Integer.toString(info.getPrice()) : input;
		info.setPrice(input);
		
		System.out.println("변경할 종류 : ");
		input = sc.nextLine();
		input = input.isEmpty() ? info.getKind() : input;
		info.setKind(input);
		System.out.println("변경할 외형 : ");
		input = sc.nextLine();
		input = input.isEmpty() ? info.getAppearance() : input;
		info.setAppearance(input);
		
		System.out.println("변경할 색깔 : ");
		input = sc.nextLine();
		input = input.isEmpty() ? info.getColor() : input;
		info.setColor(input);
		
		boolean result = cc.update(info);
		
		if(result) {
			System.out.println("수정완료");
		} else {
			System.out.println("수정실패");
		}
	}

	private void delete() {
		String input = "";
		System.out.println("삭제할 브랜드 : ");
		input = sc.nextLine();
		
	}
	
	private void clothTop() {
		
		ClothVO data = new ClothVO();
		System.out.print("브랜드 : ");
		data.setBrand(sc.nextLine());
		System.out.print(" 가격 : ");
		data.setPrice(sc.nextLine());
		System.out.print(" 종류 : ");
		data.setKind(sc.nextLine());
		System.out.print(" 외형 : ");
		data.setAppearance(sc.nextLine());
		System.out.print(" 색깔 : ");
		data.setColor(sc.nextLine());
		
		boolean result = cc.cloth(data);
		
		if(result) {
			System.out.println("옷이 등록되었습니다.");
		} else {
			System.out.println("옷을 등록하지 못하였습니다.");
		}
		
	}
	
	private void clothBottom() {
		
		ClothVO data = new ClothVO();
		System.out.println("브랜드 : ");
		data.setBrand(sc.nextLine());
		System.out.println(" 가격 : ");
		data.setPrice(sc.nextLine());
		System.out.println(" 종류 : ");
		data.setKind(sc.nextLine());
		System.out.println(" 외형 : ");
		data.setAppearance(sc.nextLine());
		System.out.println(" 색깔 : ");
		data.setColor(sc.nextLine());
		
		boolean result = cc.cloth(data);
		
		if(result) {
			System.out.println("옷이 등록되었습니다.");
		} else {
			System.out.println("옷을 등록하지 못하였습니다.");
		}
		
	}
}

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
				this.springRandom(); break;
			case "2" :
				this.springModify(); break;
			default :
				System.out.println("잘못작성하였습니다. 다시 입력하세요.");
		}
	}
	
	public void springRandom() {}
	
	public void springModify() {
		System.out.println(cm.springClothModify());
		System.out.print(">>> ");
		String input = sc.nextLine();
		
		switch(input) {
			case "1" :
				this.springInsert(); break;
			case "2" :
				this.springUpdate(); break;
			case "3" :
				this.springDelete(); break;
			default :
				System.out.println("잘못작성하였습니다. 다시 입력하세요.");
		}
	}

	private void springInsert() {
		System.out.println(cm.springClothSplit());
		System.out.print(">>> ");
		String input = sc.nextLine();
		
		switch(input) {
			case "1" :
				this.springClothTop(); break;
			case "2" :
				this.springClothBottom(); break;
			default :
				System.out.println("잘못입력");
		}
	}
	
	private void springClothTop() {
		
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
	
	private void springClothBottom() {
		
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
	
	private void springUpdate() {
		// TODO Auto-generated method stub
		
	}
	
	private void springDelete() {
		// TODO Auto-generated method stub
		
	}

	public void summerMain() {
		System.out.print(cm.summerClothMain());	
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
		System.out.println(cm.summerClothModify());
		System.out.print(">>> ");
		String input = sc.nextLine();
		
		switch(input) {
		case "1" :
			this.summerInsert(); break;
		case "2" :
			this.summerUpdate(); break;
		case "3" :
			this.summerDelete(); break;
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
	
	private void summerInsert() {
		System.out.println(cm.summerClothSplit());
		System.out.print(">>> ");
		String input = sc.nextLine();
		
		switch(input) {
			case "1" :
				this.summerClothTop(); break;
			case "2" :
				this.summerClothBottom(); break;
			default :
				System.out.println("잘못입력");
		}
		
	}
	
	private void summerClothTop() {
		
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
	
	private void summerClothBottom() {
		
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

	private void summerUpdate() {
		// TODO Auto-generated method stub
		
	}

	private void summerDelete() {
		// TODO Auto-generated method stub
		
	}

	public void fallMain() {
		System.out.print(cm.fallClothMain());
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
		System.out.println(cm.fallClothModify());
		System.out.print(">>> ");
		String input = sc.nextLine();
		
		switch(input) {
		case "1" :
			this.fallInsert(); break;
		case "2" :
			this.fallUpdate(); break;
		case "3" :
			this.fallDelete(); break;
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
	
	private void fallInsert() {
		System.out.println(cm.fallClothSplit());
		System.out.print(">>> ");
		String input = sc.nextLine();
		
		switch(input) {
			case "1" :
				this.fallClothTop(); break;
			case "2" :
				this.fallClothBottom(); break;
			default :
				System.out.println("잘못입력");
		}
		
	}
	
	private void fallClothTop() {
		
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
	
	private void fallClothBottom() {
		
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

	private void fallUpdate() {
		// TODO Auto-generated method stub
		
	}

	private void fallDelete() {
		// TODO Auto-generated method stub
		
	}

	public void winterMain() {
		System.out.print(cm.winterClothMain());	
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
		System.out.println(cm.winterClothModify());
		System.out.print(">>> ");
		String input = sc.nextLine();
		
		switch(input) {
		case "1" :
			this.winterInsert(); break;
		case "2" :
			this.winterUpdate(); break;
		case "3" :
			this.winterDelete(); break;
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

	private void winterInsert() {
		System.out.println(cm.winterClothSplit());
		System.out.print(">>> ");
		String input = sc.nextLine();
		
		switch(input) {
			case "1" :
				this.winterClothTop(); break;
			case "2" :
				this.winterClothBottom(); break;
			default :
				System.out.println("잘못입력");
		}
	}
	
	private void winterClothTop() {
		
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
	
	private void winterClothBottom() {
		
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

	private void winterUpdate() {
		// TODO Auto-generated method stub
		
	}

	private void winterDelete() {
		// TODO Auto-generated method stub
		
	}
}

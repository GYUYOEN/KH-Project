package cloth.menu;

public class ClothMenu {
	public String getMain() {
		String s = "";
		s += "<<< 계절을 선택해주세요. >>>\n";
		s += "┌───────────────────┐\n";
		s += "│	1. 봄			  │\n";
		s += "│	2. 여름			  │\n";
		s += "│	3. 가을			  │\n";
		s += "│	4. 겨울			  │\n";
		s += "└───────────────────┘\n";
		
		return s;
	}
	
	public String clothMain() {
		String s = "";
		s += "┌───────────────────┐\n";
		s += "│	1. 랜덤 초이스 	  │\n";
		s += "│	2. 옷 정보 수정	  │\n";
		s += "└───────────────────┘\n";
		
		return s;
	}

	public String clothModify() {
		String s = "";
		s += "<<< 옷 정보 수정 메뉴화면 입니다. >>>\n";
		s += "┌───────────────────┐\n";
		s += "│	1. 옷 추가		  │\n";
		s += "│	2. 옷 수정		  │\n";
		s += "│	2. 옷 삭제		  │\n";
		s += "└───────────────────┘\n";
		
		return s;
	}
	
	public String clothSplit() {
		String s = "";
		s += "┌───────────────────┐\n";
		s += "│	1. 상의			  │\n";
		s += "│	2. 하의			  │\n";
		s += "└───────────────────┘\n";
		
		return s;
	}
	
}
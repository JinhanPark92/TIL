package App;

import java.util.Scanner;

public class Myapp {

	public static void main(String[] args) {
		boolean flag = true;
		while(flag) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("원하는 메뉴 변호를 입력하세요.");
		System.out.println("1.입 력");
		System.out.println("2.수 정");
		System.out.println("3.삭 제");
		System.out.println("4.검 색");
		System.out.println("5.목록보기");
		System.out.println("6.종 료");
		
		int input;

		input = scanner.nextInt();
		scanner.nextLine();
		if(input == 1) {
			
		}
		else if(input ==2) {
			
		}
		else if(input ==3) {
			
		}
		else if(input ==4) {
	
		}
		else if(input ==5) {
	
		}
		else if(input ==6) {
			System.out.println("정말 종료하시겠습니까?(yes)");
			String input6 = null;
			String yes = new String("yes");
			input6 = scanner.next();
			if(input6.equals(yes)) {
				System.out.println("종료됩니다.");				
				flag = !flag;
			}
		}
		else {
			System.out.println("다시 입력해 주세요.");
		}
		scanner.close();
		scanner = null; // 자원 초기화
			
	}
		return;
}
}

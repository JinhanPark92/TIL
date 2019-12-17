package App;

import java.util.Scanner;

public class Myappbyteacher {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String cmd = null; ////""해도됨
		while(true) {
		System.out.println("원하는 메뉴 변호를 입력하세요. ex)1");
		System.out.println("1.입 력");
		System.out.println("2.수 정");
		System.out.println("3.삭 제");
		System.out.println("4.검 색");
		System.out.println("5.목록보기");
		System.out.println("9.종 료");
		
		cmd = scanner.nextLine().trim();///trim() 공백제거
		//int num = scanner.nextLineInt();///int로 할 경우 엔터 반드시 필요
		
		//System.out.println(cmd+" 입력");
		switch(cmd) {
			case "1":
				System.out.println("입력 작업 수행");
				break;
			case "2":
				System.out.println("수정 작업 수행");
				break;
			case "3":
				System.out.println("삭제 작업 수행");
				break;
			case "4":
				System.out.println("검색 작업 수행");
				break;
			case "5":
				System.out.println("목록보기 작업 수행");
				break;
			case "9":
				System.out.println("종료합니다.");
				System.out.println("종료를 원하시면 q를 입력하세요.");
				if(scanner.nextLine().equalsIgnoreCase("q")) {
					System.out.println("종료 합니다.");
					scanner.close();
					scanner = null; // 자원 초기화
					return;
				}
				else {
					break;
				}
  			default:
				System.out.println("다시 입력하세요.");
		}
		
		
	}

}
}

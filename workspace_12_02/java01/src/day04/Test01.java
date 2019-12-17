package day04;
import java.io.FileInputStream;
import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) throws Exception {    
		System.out.println("APP 시작 ------");
		String name = null;
		int kor, eng, math;
		Scanner scanner = new Scanner(new FileInputStream("C:\\lib\\score.txt"),"UTF-8");
		
		System.out.println("이름 국어 영어 수학 점수를 입력하세요.");
		System.out.println("ex)홍길동 90 90 90");
		name = scanner.next(); //// 공백 무시하고 받음
		kor = scanner.nextInt();
		eng = scanner.nextInt();
		math = scanner.nextInt();
		scanner.nextLine(); //////한줄 단위로 입력을 받음 ///버퍼의 개행문자 제거 역할
		
		double sum = kor+eng+math;
		double avg = sum/3;
		
		System.out.printf("이름=%s %n", name);
		System.out.printf("국어 영어 수학 ", kor, eng, math);
		System.out.printf("평균=%.2f", avg);
		//학점 처리 A B C D F
		char grade;
		
		switch((int)avg/10) { /////switch는 더블 타입 수행 불가능 --->정수화 처리
			case 10:
			case 9:
				grade = 'A';
				break;
			case 8:
				grade = 'B';
				break;
			case 7:
				grade = 'C';
				break;
			case 6:
				grade = 'D';
				break;
			default:
				grade = 'F';
				break;
		}
		
		System.out.printf(" grade = %c 학점 %n", grade);
	
		if(scanner != null) scanner.close();
		scanner = null;
		
		switch(grade) {
		case 'A':
		case 'B':
			System.out.println("우수한 학생입니다.");
			break;
		case 'C':
		case 'D':
			System.out.println("수고하셨습니다.");
			break;
		case 'F':
			System.out.println("재수강입니다.");
			break;/////switch 구문 나가기
		}
		
		return; ///종료 호출이 시작된 곳(method가 시작한 곳)으로 돌아감///
		////요기서 method는 public static void main(String[] args)임
	}

}

//		if(avg >= 90) {
//			grade = 'A';
//			
//		}
//		else if(avg>=80) {
//			grade = 'B';
//		}
//		else if(avg>=70) {
//			grade ='C';
//		}
//		else if(avg>=60) {
//			grade = 'D';
//		}
//		else {
//			grade = 'F';
//		}
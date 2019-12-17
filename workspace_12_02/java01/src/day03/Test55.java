package day03;
import java.io.FileInputStream;
import java.util.Scanner;

public class Test55 {

	public static void main(String[] args) throws Exception {    
		System.out.println("APP 시작 ------");
		String name = null;
		int kor, eng, math;
		Scanner scanner = new Scanner(new FileInputStream("C:\\lib\\score.txt"));
		
		System.out.println("이름 국어 영어 수학 점수를 입력하세요.");
		System.out.println("ex)홍길동 90 90 90");
		name = scanner.next();
		kor = scanner.nextInt();
		eng = scanner.nextInt();
		math = scanner.nextInt();
		scanner.nextLine();
		
		double sum = kor+eng+math;
		double avg = sum/3;
		
		System.out.printf("이름=%s %n", name);
		System.out.printf("국어 영어 수학 ", kor, eng, math);
		System.out.printf("평균=%.2f", avg);
		//학점 처리 A B C D F
		char grade = 'F';
		if(avg >= 90) {
			grade = 'A';
			
		}
		else if(avg>=80) {
			grade = 'B';
		}
		else if(avg>=70) {
			grade ='C';
		}
		else if(avg>=60) {
			grade = 'D';
		}
		else {
			grade = 'F';
		}
		System.out.printf("   grade = %c 학점 %n", grade);
		scanner.close();
		scanner = null;
		return;

	}

}

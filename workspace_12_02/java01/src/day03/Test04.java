package day03;

import java.util.Scanner;

public class Test04 {

	public static void main(String[] args) {    ///void---> 어떠한 값도 가지지 않고 바로 return으로 돌아간다
		Scanner scanner = new Scanner(System.in);

		System.out.println("APP 시작 ------");
		String name = null;
		int kor, eng, math;

		System.out.println("성적처리를 종료하려면 q를 입력하세요.");
		String msg = scanner.nextLine();
		if(msg.equals("q") || msg.equals("Q") || msg.equals("Quit") || msg.equals("quit") || msg.equals("QUIT")) {
//		if(msg.toLowwercase().equals("quit")) {
			if(scanner!=null) {
				scanner.close();
				scanner =null;
			}
			System.out.println("APP 종료합니다.....");
			return;
		}
		
		System.out.println("이름 국어 영어 수학 점수를 입력하세요.");
		System.out.println("ex)90 90 90");
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


		if(avg>=80) {
			System.out.println(" ---> 합격입니다.");
		}
		else {
			System.out.println(" ---> 불합격입니다.");
		}
		//if(avg<80){System.out.println(" ---> 불합격입니다.");}
		
		
		scanner.close();
		scanner = null;
		return;

	}

}

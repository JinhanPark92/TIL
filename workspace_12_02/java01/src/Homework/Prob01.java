package Homework;

public class Prob01 {

	public static void main(String[] args) {
			/*
			 아래는 변수 num의 값에따라  양수 음수  0을 출력하는  코드이다.
			삼항 연산자를 이용해서 에 알맞은 코드를 완성하세요. 
			힌트:   삼항 연산자를 두번 이용   
			*/
			int num = -90;
			String result = num > 0 ? "양수" : num == 0 ? "0" : "음수";
			System.out.println(num +" : "+result);


			/*
		        다음은 대문자를 소문자로 변경하는 코드입니다.
		        변수 ch에 저장된 문자가 대문자 인 경우에만 
			소문자로 변경하는 코드를 완성 합니다.
		  	*/
			char ch = 'B';
			char lowerCase = (ch>='A'&&ch<='Z') ? (char)(ch+32):ch; // 조건문 ? 결과 ;
			System.out.print("ch:"+ch); // char 형태의 데이터끼리 +는 string 형태로 만들기
			System.out.println(" to lowerCase :"+lowerCase); // +는 성능저하의 주 원인

			}
		}          
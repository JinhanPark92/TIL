package day02;

public class Test01 {
	// 클래스의 구성요소
	// data(변수) + 기능(함수 = method)
	
	public static void main(String[] args) {
		// data(변수) , 지역변수 , 초기화 해야 사용 가능
		
		//기본형
		int i = 900;
		long i2 = 999999999999999999l;
		
		double f = 99.9;
		
		char c = 'A';
		//자동 형변환 프로모션
		int c2 = c; //char=>int
		
		char c3 = 97;
		//char c4 = c3>>>>>>자동 형변환 프로모션 불가(데이터범위가 줄어들어 손실 우려)
		char c4 = (char)c3;//char(c3)
		
		System.out.println(c2);
		System.out.println(c4);
		System.out.println(c4);
		System.out.println("=============");
		System.out.printf("1/2 = %d %n", 1/2);
		System.out.printf("1/2. = %.2f %n", 1/2.);
		System.out.println("=============");
		
			
		
		
		
		boolean b =true;
		
		System.out.printf("%d %f %c %b %n",i,f,c,b);
		System.out.printf("%s %s %s %s %n",i,f,c,b);
		System.out.printf("i=%d f=%.2f c=%c b=%b %n",i,f,c,b);
		
		
////		//참조형
////		String name = "홍길동";
////		System.out.println(name);
	}
//
}

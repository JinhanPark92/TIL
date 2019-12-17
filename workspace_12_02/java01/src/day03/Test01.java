package day03;

public class Test01 {

	public static void main(String[] args) {
		// ==와 equals() method의 고분 사용
		// 기본값의 값을 비교시 ==
		// 객체를 비교시 equal()
		
		int i = 90, j = 90, k = 99;
		System.out.printf("%b %b %b %n",i==j, i==k, i!=k);
		
		System.out.println("==========================================");
		
		String s1 = new String("java"); //string class는 메모리에 저장된 값은 불변
		String s2 = new String("java");
		System.out.printf("s1=%s , s2=%s %n", s1,s2);
		System.out.printf("s1==s2 %b %n", s1==s2);
		System.out.printf("s1.equal(s2) %b %n", s1.equals(s2));
		
		System.out.println("==========================================");

		String s3 = "java"; // 자료가 저장되는 메모리 구역이 new string이랑 다름
		String s4 = "java"; // 이미 s3에서 java 저장 , s3와 s4 주소 공유
		System.out.printf("s3=%s , s4=%s %n", s3,s4);
		System.out.printf("s3==s4 %b %n", s3==s4);
		System.out.printf("s3.equal(s4) %b %n", s3.equals(s4));

		System.out.println("==========================================");

		System.out.printf("s1=%s , s4=%s %n", s1,s4);
		System.out.printf("s1==s4 %b %n", s1==s4);
		System.out.printf("s1.equal(s4) %b %n", s1.equals(s4));
	}

}

package day02;

public class Test05 {

	public static void main(String[] args) {
		byte num = 127;
		num = (byte)(num+1);
		System.out.println(num);
		
		char c = 'a';
		System.out.printf("숫자냐? %b %n", Character.isDigit(c));
		
		System.out.println("abc"+"def");// 성능저하의 원인!!! 이렇게 하지맛!!!!
		System.out.println(1+1+1);
		System.out.println(1+1+"1");
		System.out.println("1"+1+1);
		
		String r1 = "100"+1; // 1001
		int r2 = Integer.parseInt("100")+1; // 101
		
		System.out.printf("r1=%s, r2=%d %n",r1,r2);
		
		double r3 = Double.parseDouble("100.5")+1;
		System.out.println(r3);
		
		int r4 = (int)(Double.parseDouble("100.5")+1);
		System.out.println(r4);
		
		System.out.println(Math.PI);
	}

}

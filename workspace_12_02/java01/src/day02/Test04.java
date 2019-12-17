package day02;

public class Test04 {

	public static void main(String[] args) {
		int num = 100;
		num = num + 20;
		int i = 99, j = 77;
		System.out.printf("(i=%d,j=%d) %n",i,j);
		
		// i,j 스와핑
		
		System.out.printf("(i=%d,j=%d) %n",j,i);
		
		System.out.println("====================");
		char c1 = 'B', c2 = 'W';
		System.out.printf("(c1=%c, c2=%c) %n", c1,c2);
		char tempc = c1;
		c1 = c2;
		c2 = tempc;
		System.out.printf("(c1=%c, c2=%c) %n", c1,c2);
		System.out.println("====================");
		String s1 = "hello", s2 = "java";
		System.out.printf("(s1=%s, s2=%s) %n", s1,s2);
		String temps = s1;
		s1=s2;
		s2 = temps;
		System.out.printf("(s1=%s, s2=%s) %n", s1,s2);
		System.out.println("====================");
		String s11 = "hello", s22 = "java";
		System.out.printf("(s1=%s, s2=%s) %n", s11,s22);
		System.out.printf("(s1=%s, s2=%s) %n", s22,s11);
		
		
		
	}

}

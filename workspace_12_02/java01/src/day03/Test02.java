package day03;

public class Test02 {

	public static void main(String[] args) {
		System.out.println(1<<0); //1
		System.out.println(1<<1); //왼쪽으로 1비트 옮겨가 --> 10 -->2
		System.out.println(1<<2); //100 -->4
		System.out.println(1<<3); //1000 -->8
		
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
		
		System.out.println(1>4 & 4<0);
		System.out.println(1&4);
		System.out.println(1|4);
		
		
	}

}

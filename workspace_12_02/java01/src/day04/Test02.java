package day04;

public class Test02 {

	public static void main(String[] args) {
		for(int i=0; i<3; i++) {
			for(int j=0;j<5;j++) {
				System.out.printf("i=%d, j=%d ",i,j);
			}
			System.out.println("");/////줄 바꿈 역할(ln이 줄바꿈역할)

		}
		System.out.println("====================================");
		
		int i=0;
		do {
			System.out.println("--------------");
			i++;			
		}while(i<10);
		
		boolean flag = true;
		while(flag) {
			System.out.println("~~~~~~~~~");
			int num = (int)(Math.random()*10);
			System.out.println(num);
			if(num % 3 == 0) flag =!flag; //////%연산자는 나머지
		}
		
		
		
	}

}
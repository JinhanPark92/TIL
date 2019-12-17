package day04;

public class Test04 {
	public static void main(String[] args) {
		int[] eng;         //배열 선언
		eng = new int[5];  //배열 생성
		
		eng[0] = 99;
		eng[1] = 88;
		eng[2] =100;
		eng[3] = 81;
		eng[4] = 67;
		
		double sum = 0;
		double avg = 0.0;
		for(int i=0;i<eng.length;i++) {
			System.out.print(eng[i]+" ");
			sum += eng[i];
		}
		System.out.println();
		avg = sum / eng.length;
		
		System.out.printf("합계 = %d %n",(int)sum);
		System.out.printf("평균 = %.2f %n",avg);

		String[] names = new String[5];
		names[0] = "홍길동";
		names[1] = "";
		names[2] = "박길동";
		names[3] = "고길동";
		names[4] = "최길동";

		for(int i=0;i<names.length;i++) {
		 	if(names[i] != null && names[i].length()>0) {
			    System.out.print(names[i].charAt(0)+"** ,");
			    System.out.print(eng[i]);
			    System.out.println();
/*1. print

print의 경우는 라인변경(줄바꿈)이 되지 않고 출력된다.

ex) System.out.print("num은" + num + "이다.");

​

2. println

println의 경우는 라인변경(줄바꿈)이 되어 출력된다.

ex) System.out.println("num은" + num + "이다.");

​

3. printf

printf의 경우 C언어의 문법을 따른다.

ex) System.out.printf("num은 %d이다. \n", num);

printf에서 줄바꿈을 하고자 할 때 \n을 해도 되고 %n을 해도 된다.

​

※ 그렇다면 C언어에서 쓰는 printf를 왜 자바에서 사용할까?

주로 문자 출력 시 왼쪽 정렬, 오른쪽 정렬을 해서 출력하고자 할 때 사용한다.*/





		 	}
		}
		
	}
}






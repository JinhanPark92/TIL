package day05;

public class Calc {
    //메소드 오버로딩 
	public static int add(int a,int b){
		return a+b;
	}
	public static int add(int ... a){/////다변 처리 가능 내부적으로 배열 처리 가변인자는 맨 뒤에만 올수 있다!!!!!!
		int sum = 0;
		for(int i = 0; i<a.length;i++) {
			sum += a[i];
		}
		return sum;
	}
	public static double add(double a,double b){
		return a+b;
	}
}

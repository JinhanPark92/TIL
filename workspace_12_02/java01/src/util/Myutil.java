package util;

public class Myutil {
	
	public static int[] sort(int[] a) {
		int[] num = a.clone();
		
		for(int i=0 ; i<num.length-1;i++) {
			int min = i;
			for(int j= i+1;j<num.length ;j++) {
				if(num[min] > num[j]) {
					min = j;
				}
			}
			if(i != min) {  //num[i]   num[min]
				Myutil.swap(num,i,min);
			 	}
			}
		return num;
		
	}
	public static void swap(int[] num, int i, int min) {
		int temp = num[i];
		num[i] = num[min];
		num[min] = temp;

	}
	//두개의 점수를 입력받아 큰값을 리턴해주는 max함수
	public static int max(int a, int b) {
		return a>=b ? a:b;
	}

}

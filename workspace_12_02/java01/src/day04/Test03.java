package day04;

public class Test03 {

	public static void main(String[] args) {
	 A :	for(int i=1; i<10; i++) {
			for(int j=2;j<10;j++) {
				if(j==5) break A;///////////////////A라는 루프를 끝냄
//				if(j==5) break;
				int x = i*j;
				System.out.printf("%d*%d=%2d| ", j,i,x);
			}
			System.out.println();
		}
	}
}
/*		System.out.println("==========================================================================");
		
		int i = 1;
		while(i<10) {
			int j = 2;
			while(j<10) {
				System.out.printf("%d*%d=%2d| ", j,i,i*j);
				j++;
				//////if(j==5) break;//////break는 자신이 포함된 루프를 닫는 역할
				//////if(j==5) continue;////////////////5만 제외---->continue는 본인이 포함된 루프 건너 뛰는 역할
				
			}
			System.out.println();
		i++;
		}
	}
}
*/
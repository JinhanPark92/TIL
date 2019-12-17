package Homework;

public class Prob04 {

	public static void main(String args[]) {
		
		System.out.println( Prob04.leftPad("SDS", 6, '#') );
		System.out.println( Prob04.leftPad("SDS", 5, '$') ); 
		System.out.println( Prob04.leftPad("SDS", 2, '&') ); 
	}
// Teacher's version
	
	public static String leftPad(String str, int size, char padChar) {
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i<size-str.length();i++) {
				sb.append(padChar);
			}
			sb.append(str);
			
			return sb.toString();
		}
}

//		/*  여기에 프로그램을 완성하십시오. */
//		
//		if(str.length()>=size)
//			return str;
//		else{
//			StringBuilder st = new StringBuilder();
//			int i = size - str.length();
//			while(i!=0) {
//				st.append(padChar);
//				i--;
//			}
//			return st.append(str).toString();
//		}
//		
//		
//	}
//}

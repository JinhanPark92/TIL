package day07;

public class Test01 {
	public static void main(String[] arg) {
		Dog d = new Dog();
		d.print();
		
		//main에서는 this super 키워드 사용할 수 없다.
		System.out.println(d.kind);
		System.out.println(d.getSuperKind());
	}
	
}

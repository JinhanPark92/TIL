package day09;

public class Test02 {

	public static void main(String[] args) {
		A a = new A("고길동");
		a.print();
		A.B b1 = a.new B();//b1에서 쓰이는 네임은 a에 있다
		b1.print();
		
		A.B b = new A().new B();//b에서 쓰이는 네임은 뉴 에이에 있다.
		//뉴 에이의 네임은 초기값 홍길동을 가짐
		b.print();
	}

}
class A{
	String name = "홍길동";

	public A() {	}

	public A(String name) {
		this.name = name;
	}
	void print() {
		System.out.println(name.charAt(0)+"**");
	}
	
	class B{
		void print() {
			System.out.println(name);
		}
	}
}

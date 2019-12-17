package day07;

public class Animal {
	protected String kind = "강아지 종류";
	public Animal() {
	}
	public Animal(String kind) {
		super();
		this.kind = kind;
	}
	public void breath() {
		System.out.println("페로 숨을 쉽니다......");
	}
}

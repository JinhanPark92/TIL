package day08;

public abstract class Animal {   ////abstract는 아직 미완성 클래스이니 메모리에 넣지 마!!!라고 하는거
	protected String kind = "강아지 종류";
	public Animal() {}
	public Animal(String kind) {
		super();
		this.kind = kind;
	}
	public abstract void breath();////abstract --> 미완성 코드임을 밝히는 것
}

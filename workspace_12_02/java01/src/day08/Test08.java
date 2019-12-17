package day08;
public class Test08 {
	public static void main(String[] args) {
	  Drawable[] s = {new Circle(), new Rectangle()};
	  for(Drawable data : s) {
		  data.draw();
		  ((Moveable)data).move();
	  }
	  System.out.println("=============================");
	  
	  T[] t = {new Circle(), new Rectangle()};
	  for(T data : t) {////향상된 for 구문//data는 여기서 새로 선언됨 배열
		  data.draw();
		  data.move();
	  }
	}
}
interface Drawable{
	void draw();
}
interface Moveable{
	void move();
}
interface T extends Drawable, Moveable{}

class Circle implements T{
	String name = "Circle";
	@Override
	public void move() {
		System.out.println(name+"    이동");
	}
	@Override
	public void draw() {
		System.out.println(name+"    그리기");	
	}
}
class Rectangle implements T{
	String name = "Rectangle";
	@Override
	public void move() {
		System.out.println(name+"    이동");
	}
	@Override
	public void draw() {
		System.out.println(name+"    그리기");
	}
}
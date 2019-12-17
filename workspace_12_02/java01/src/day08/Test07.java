package day08;

public class Test07 {

	public static void main(String[] args) {
		Circle_a a = new Circle_a();
		System.out.println(a.cArea(5));
		a.print();
		a.color="~~~~~~~~~~~~";
		System.out.println(a.color);
		
		Circle_i i = new Circle_i();
		System.out.println(i.cArea(5));
		System.out.println(i.color);
	}

}
class Circle_a extends Shape_a{
	
	@Override
	public double cArea(double r) {
		return Math.PI*r*r;
	}
}

abstract class Shape_a{
	String color;
	public abstract double cArea(double r);
	public void print() {
		
	}
}
interface Shape_i{
	final static String color = "red";
	double cArea(double r);
	
}

class Circle_i implements Shape_i{
	@Override
	public double cArea(double r) {
		return Math.PI*r*r;
	}
}
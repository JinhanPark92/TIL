package day07;

public class Test02 {

	public static void main(String[] args) {
		
		Object a = new Animal();//a라는 변수에 주소 입력
		((Animal)a).breath();
		
		Animal a2 = new Animal();//a라는 변수에 주소 입력
		a2.breath();
		
		Object obj = a2;
		Animal temp = (Animal)obj;
		temp.breath();
		
		Dog d = new Dog();
		System.out.println(d.kind);
		Object obj2 = d;
		Animal a3 = (Animal)obj2;
		Dog d3 = (Dog)obj2;
		System.out.println(a3.kind);
		System.out.println(d3.kind);
		
		System.out.println("====================================================");
		
		String msg = "hello java";
		
		Object obj7 = msg;
		if(obj7 instanceof Dog)
		System.out.println(((Dog)obj7).kind);
		
		if(obj7 instanceof Animal)
		System.out.println(((Animal)obj7).kind);
		
		if(obj7 instanceof String)
		System.out.println(((String)obj7).toUpperCase());
		
	}

}

package day08;

public class Test04 {
	public static void main(String[] arg) {
		String msg1 = "hello";//String은 클래스
		String msg2 = "hello";
		System.out.println(msg1+" "+msg2);
		System.out.println(msg1.equals(msg2));
		
		Person p1 = new Person("홍길동", 22);//Person은 밑에 class로 선언함
		Person p2 = new Person("홍길동", 22);
		System.out.println(p1+" "+p2);
		System.out.println(p1.equals(p2));
		
		System.out.println("====================================");

		System.out.println(msg1);//String 클래스에서 toString() 메서드가 추가되어 있으므로 자동적으로 수행함.
		System.out.println(msg2);//String 클래스에서 toString() 메서드가 추가되어 있으므로 자동적으로 수행함.
		
		System.out.println(p1);
		System.out.println(p2.toString());
		System.out.println("====================================");
		
		Object obj = p1; //////모든 객체는 object 타입임 따라서 오브젝트는 모든 데이터를 담을 수 있어
		System.out.println(obj);
		System.out.println(((Person)obj).name);//object는 최상위 객체 따라서 다운캐스팅
		
		Object obj1 = msg1; //////모든 객체는 object 타입임 따라서 오브젝트는 모든 데이터를 담을 수 있어///object는 최상위 객체
		System.out.println(obj1);
		System.out.println(((String)obj1).toUpperCase());//object는 최상위 객체
		
		
	}
}

class Person{
	String name;
	int age;
	public Person() {/////생성자
		super();
	}
	public Person(String name, int age) {///생성자
		this.name = name;
		this.age = age;
	}
	// Person class에서 toString 메서드 기능 추가(String클래스에서 toString 메서드가 자동적으로 추가 되어 있음)
	@Override
	public String toString() {
	/* In general, the toString method returns a string that"textually represents" this object. 
	 * The result should be a concise but informative representation that is easy for a person to read.
	 * It is recommended that all subclasses override this method. 
	 * The toString method for class Object returns 
	 * a string consisting of the name of the class of which the object is an instance,
	 * the at-sign character `@', and the unsigned hexadecimal representation of the hash code of the object. 
	 * In other words, this method returns a string equal to the value of: 

 		getClass().getName() + '@' + Integer.toHexString(hashCode())
 
		Overrides: toString() in Object
		Returns:a string representation of the object.*/
		
		return "Person["+name+" : "+age+"]";
	}
	@Override//부코클래스의 메소드를 자식클래스에서 재정의하는 것.
	public boolean equals(Object obj) {//부모 표현법은 그대로 가져온다!!(object는 최상위 클래스)
		boolean f = false;
//instanceof : 참조번수가 참조하는 인스턴스의 타압을 검사할 때 쓰이는 연산자. if(참조변수 instanceof 객체타입)
//instanceof 연산자를 활용하여 타입을 확인하는 이유는 다형성으로 인해 여러 타입이 전달될 수 있으므로 각각의 인스턴스 타입에 따라 서로 다른 작업을 하기 위해서이다.
		if(obj instanceof Person) {//Object클래스를 기본으로 상속받는다.
			Person p = (Person)obj;
			if (name.equals(p.name)&&age == p.age) {
				f = true;
			}
		}
		return f;
	}
}
//모든 객체는 object를 상속받는다.





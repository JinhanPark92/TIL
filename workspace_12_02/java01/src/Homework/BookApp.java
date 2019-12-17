package Homework;
/*1. 책(Book) 객체 여러 개를 저장할 수 있는 책 목록(booklist)이라는 배열을 멤버변수로 가져야 한다. 
2. 책 목록(booklist)이라는 배열 변수를 초기화하는 생성자 메서드를 작성해야 한다. 
4. Book 객체를 booklist에 등록하는 addBook(Book book) 메서드를 작성하세요
5. 책 목록을 화면에 출력하는 printBookList() 메서드가 있어야 한다. 
6. 모든 책 가격의 합을 출력하는 printTotalPrice() 메서드가 있어야 한다.*/
public class BookApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookMgr b1 = new BookMgr();////BookMgr() ---> 생성자 이름!!!!
		
		b1.addBook(new Book("Java Program", 26400));
		b1.addBook(new Book("JSP Program", 26400));
		b1.addBook(new Book("SQL Fundamentals", 26400));
		b1.addBook(new Book("JDBC Program", 26400));
		b1.addBook(new Book("EJB Program", 26400));
		
		System.out.println("=== 책 목록 ===");
		b1.printBookList();
		System.out.println();
		
		System.out.println("=== 책 가격의 총합 ===");
		b1.printTotalPrice();
	}

}


//package Day06;
//
//public class BookApp {
//
//	public static void main (String[] args) {
//		BookMgr b1 = new BookMgr();
//		
//		b1.addBook(new Book("Java Program", 26400));
//		b1.addBook(new Book("JSP Program", 26400));
//		b1.addBook(new Book("SQL Fundamentals", 26400));
//		b1.addBook(new Book("JDBC Program", 26400));
//		b1.addBook(new Book("EJB Program", 26400));
//		
//		System.out.println("=== 책 목록 ===");
//		b1.printBookList();
//		System.out.println();
//		
//		System.out.println("=== 책 가격의 총합 ===");
//		b1.printTotalPrice();
//	}
//
//}
package Homework;
/*1. 책(Book) 객체 여러 개를 저장할 수 있는 책 목록(booklist)이라는 배열을 멤버변수로 가져야 한다. 
2. 책 목록(booklist)이라는 배열 변수를 초기화하는 생성자 메서드를 작성해야 한다. 
4. Book 객체를 booklist에 등록하는 addBook(Book book) 메서드를 작성하세요
5. 책 목록을 화면에 출력하는 printBookList() 메서드가 있어야 한다. 
6. 모든 책 가격의 합을 출력하는 printTotalPrice() 메서드가 있어야 한다.*/

public class BookMgr {
	Book[] booklist;
	static int index;
	static int size = 10;
	
	public BookMgr() {
		index = 0;
		booklist = new Book[size];
	}
	public void addBook(Book book) {
		booklist[index++] = book;
	}
	public void printBookList() {
		for(int i = 0; i < index; i++) {
			System.out.println(booklist[i].getTitle());
		}
	}
	public void printTotalPrice() {
		int sum = 0;
		for(int i = 0; i < index; i++) {
			sum += booklist[i].getPrice();
		}
		System.out.printf("전체 책 가격의 합 : %d", sum);
	}
}

//package Day06;
//import Day06.Book;
//
//public class BookMgr {
//	Book[] booklist;
//	static int index;
//	static int size = 10;
//	public BookMgr() {
//		index =0;
//		booklist = new Book[size];
//	}
//	
//	
//	public void addBook(Book book) {
//		booklist[index++] = book;		
//	}
//	
//	public void printBookList() {
//		System.out.println(" 책 목록 ");
//		for(int i=0;i<index;i++) {
//			System.out.println(booklist[i].getTitle());
//		}
//		
//	}
//	void printTotalPrice() {
//		int sum = 0;
//		for(int i = 0; i < index; i++) {
//			sum += booklist[i].getPrice();
//		}
//		System.out.printf("전체 책 가격의 합 : %d", sum);
//		
//	}
//	
//	
//	
//	
//}
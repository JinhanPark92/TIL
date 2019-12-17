package Homework;

public class Book {
	private String title;
	private int price;
	
	public Book() {
		this("",0);
	}
	public Book(String title, int price) {
		setTitle(title);    
		setPrice(price);
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}


//package Day06;
//
//public class Book {
//	private String title;
//	private int price;
//	
//	public Book(String title, int price) {
//		this.title = title;
//		this.price = price;
//	}
//	public Book(String title) {
//		this.title = title;
//	}
//	public Book(int price) {
//		this.price = price;
//	}
//	
//	public void setTitle(String input) {
//		this.title = input;
//		return;
//	}
//	
//	public String getTitle() {
//		return title;
//	}
//	
//	public void setPrice(int price) {
//		if(price < 0) return;
//		this.price = price;
//	}
//	public int getPrice() {
//		return price;
//	}
//	
//
//
//}
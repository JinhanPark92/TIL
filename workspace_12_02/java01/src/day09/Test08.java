package day09;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Homework.Book;
public class Test08 {

	public static void main(String[] args) {
		System.out.println("-------------- START ---------------");
		Scanner scanner = null;
		
		try {
			scanner = new Scanner(new File("bookdata.txt"));
			while(scanner.hasNextLine()) {
				String [] data = scanner.nextLine().split(" ");
				Book book = new Book(data[0], Integer.parseInt(data[1]));
				System.out.println(book);
			}
		} catch (FileNotFoundException e) {
			System.out.println("bookdata.txt 파일 확인 해 주세요");
			//e.printStackTrace();
		}finally {
			if(scanner != null)	scanner.close();
		}
		
		System.out.println("----------------END-----------------");

	}

}

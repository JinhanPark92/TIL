package day09;

import javax.swing.JOptionPane;

public class Test04 {

	public static void main(String[] args) {
		Controller cmd = null;
		//cmd.exec();
		//Controller delete = new DeleteController();
//람다 표현식		
		Controller insert = ()-> System.out.println("insert 수행");
		
		Controller update = ()-> System.out.println("update 수행");

		Controller delete = ()-> System.out.println("delete 수행");
		
String msg = JOptionPane.showInputDialog("명령을 입력하세요. 1.delete 2.insert 3.update");
		
		switch (msg) {
			case "1":
			case "delete" :
				cmd = delete;
			break;
			
			case "2":
			case "insert":
				cmd = insert;
			break;
			
			case "3":
			case "update" :
				cmd = update;
			break;

			default:
			System.out.println("명령 선택을 다시하세요.");
				//cmd = new ListCommand();
				break;
		}
	       if(cmd != null) cmd.exec();

	}

}

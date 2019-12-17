package day06;
public class AccountTest2 {

	public static void main(String[] args) {
		Account a1 = new Account("2019-12-09-001", "홍길동", 10);
//		a1.setNumber("2019-12-09-001");
//		a1.setName("홍길동");
//		a1.setMoney(10);
		a1.print();
		
		Account a2 = new Account("2019-12-09-008", "김길동", 7600);
//		a2.setNumber("2019-12-09-008");
//		a2.setName("김길동");
//		a2.setMoney(7600);
		a2.print();
		
		Account a3 = new Account();
		a3.print();
		
		//a1.input(a2.output(2000));
//		Account.transfer(a2, a1, 2000);
//		
//		a1.print();
//		a2.print();
	}

}

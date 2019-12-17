package day06;

public class Account {
	private String name; 
	private String number;
	private int money;
	
	public Account() {
		this("","",0);////코드 중복 처리 기법
//		setNumber("");
//		setName("");
//		setMoney(0);
//		System.out.println("Account() 기본생성자 수행");
	}
	public Account(String number,String name, int money) {
		setNumber(number);    
		setName(name);
		setMoney(money);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	/*****
	 * 
	 * @param money 입금금액
	 */
	public void input(int money) {
		this.money += money;
		return;
	}
	/**
	 * ㄴ
	 * @param money 출금금액
	 * @return 출금액
	 */
	public int output(int money) {
		if(this.money >= money) {
			this.money -= money;
			return money;
		}else {
			return 0;
		}
	}	
	/**
	 * 계좌 정보 출력
	 */
	public void print(){
		System.out.printf("[%s(%s) 잔고:%7d원]%n" ,number, name, money );
		return;
	}
	public static void transfer(Account from, Account to, int money) {
		System.out.println("계자이체");
		System.out.println(from.number+" -->"+to.number);
		
		to.input(from.output(money));
		
	}
}


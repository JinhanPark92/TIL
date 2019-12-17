package day09;

public class Test09 {

	public static void main(String[] args) {
		Account account = new Account("홍길동", "001", 1000);
		try {
			account.output(7000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}

class MoneyException extends Exception{
	MoneyException() {
		super("계좌잔고 예외 발생");
	}
	MoneyException(String msg){
		super(msg);
	}
}

class Account{
	String name;
	String number;
	int money;
	
	public Account() {
		super();
	}
	public Account(String name, String number, int money) {
		super();
		this.name = name;
		this.number = number;
		this.money = money;
	}
	public void input(int money) {
		this.money += money;
		
	}
	public void output(int money) throws Exception {
		if(this.money < money) throw new Exception("잔고부족");
		this.money -= money;
	}
	
	
	
	@Override
	public String toString() {
		return "Account [name=" + name + ", number=" + number + ", money=" + money + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (money != other.money)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}
	
	
}
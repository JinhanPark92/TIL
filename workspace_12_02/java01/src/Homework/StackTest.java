package Homework;

public class StackTest {

	public static void main(String[] args) {
		MyStack stack = new MyStack(10);
		if(stack.isEmpty()){
			System.out.println("스택이 비어있습니다.");
		}
		for (int i = 1; i <= 10; i++) {
			stack.push(i);
		}
		if(stack.isFull()){
			System.out.println("스택이 가득 찼습니다.");
		}
		System.out.println("최상위 숫자 : " + stack.top());
		System.out.println("최상위에서 꺼낸 숫자 : " + stack.pop());
		System.out.println("최상위에서 꺼낸 숫자 : " + stack.pop());
		System.out.println("");
		System.out.println("== 스택 리스트 ==");
		for (int i = 1; i <= 10; i++) {
			int num = stack.pop();
			if(num != -1)
				System.out.println(num);
		}
	}
}

class MyStack{
	int i=0;
	int[] stack;
	public MyStack() {
		this.stack = new int[10];
	}
	public MyStack(int l) {
		if(l<0) 
			this.stack = new int[10];
		else 
			this.stack = new int[l];
	}
	public void push(int s) {
			stack[i] = s;
			i++;
		}
	public boolean isEmpty() {
		if(i==0) return true;
		else return false;
	}
	public boolean isFull() {
			if(i==this.stack.length) 
			return true;
			else return false;				
		}
	public int top() {
		if(i!=0) return stack[i-1];
		else return -1;
		}
	public int pop() {
		if(i!=0) {
		i--;
		return stack[i];
		}
		else return -1;
	}
}

	
	
	




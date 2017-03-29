package com.hackerrank.linear;

public class QueueFromStack<T> {
	private Stack<T> stack1 = new Stack<>();
	private Stack<T> stack2 = new Stack<>();
	public void add(T item){
		stack1.push(item);
	}
	public T remove(){
		if(stack1.isEmpty() && stack2.isEmpty())
			return null;
		if(stack2.isEmpty()){
			while(!stack1.isEmpty()){
				stack2.push(stack1.pop());
			}
		}
		return stack2.pop();
	}
	public static void main(String[] args) {
		QueueFromStack<Object> queueFromStack = new QueueFromStack<>();
		queueFromStack.add(1);
		queueFromStack.add(2);
		System.err.println(queueFromStack.remove());
		queueFromStack.add(3);
		queueFromStack.add(4);
		System.err.println(queueFromStack.remove());
		System.err.println(queueFromStack.remove());
		System.err.println(queueFromStack.remove());
	}
}

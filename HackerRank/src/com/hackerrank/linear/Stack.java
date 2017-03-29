package com.hackerrank.linear;

import java.util.ArrayList;
import java.util.List;

public class Stack<T> {
	
	private List<T> arr = new ArrayList<>();
	
	public Stack() {
	}
	public boolean isEmpty(){
		return size() == 0;
	}
	public int size(){
		return arr.size();
	}
	public void push(T item){
		arr.add(item);
	}
	public T pop(){
		return arr.remove(arr.size()-1);
	}
	public T peek(){
		return arr.get(arr.size()-1);
	}
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		System.err.println(stack.pop());
		System.err.println(stack.pop());
		System.err.println(stack.size());
	}
}

package com.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StacksWithMaxSize {
	
	private int maxSize = 10;
	List<Stack<Integer>> stacks= new ArrayList<>();
	
	public StacksWithMaxSize(int maxsize) {
		maxSize = maxsize;
		stacks.add(new Stack<>());
	}
	
	public void push(int value){
		Stack<Integer> stack = stacks.get(stacks.size()-1);
		if(stack.size() >= maxSize) {
			Stack<Integer> inner = new Stack<>();
			inner.push(value);
			stacks.add(inner);
		} else
			stack.push(value);
	}
	
	public int pop(){
		Stack<Integer> stack = stacks.get(stacks.size()-1);
		int result = stack.pop();
		if(stack.isEmpty())
			stacks.remove(stacks.size()-1);
		return result;
	}
	public static void main(String[] args) {
		StacksWithMaxSize maxSize2 = new StacksWithMaxSize(2);
		maxSize2.push(1);
		maxSize2.push(2);
		maxSize2.push(3);
		maxSize2.push(4);
		System.err.println(maxSize2.stacks.size());
		System.err.println(maxSize2.pop());
		System.err.println(maxSize2.pop());
		System.err.println(maxSize2.stacks.size());
	}
}

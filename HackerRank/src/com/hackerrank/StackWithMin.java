package com.hackerrank;

import java.util.Stack;

public class StackWithMin<T> {
	private Stack<Node> stack = new Stack<>();
	
	public void push( int value){
		Node node = new Node();
		node.data = value;
		node.min = Math.min(value,min());
		stack.push(node);
	}
	public int min() {
		if(!stack.isEmpty()){
			return stack.peek().min;
		}
		return Integer.MAX_VALUE;
	}
	public static void main(String[] args) {
		StackWithMin<Double> stackWithMin = new StackWithMin<>();
		stackWithMin.push(10000);
		System.err.println(stackWithMin.min());
		stackWithMin.push(1);
		stackWithMin.push(10);
		stackWithMin.push(100);
		System.err.println(stackWithMin.min());
	}
	class Node{
		int min;
		int data;
	}
}

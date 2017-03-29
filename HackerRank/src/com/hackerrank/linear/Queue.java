package com.hackerrank.linear;

import java.util.ArrayList;
import java.util.List;

public class Queue<T> {
	private List<T> arr =new ArrayList<>();
	public boolean isEmpty(){
		return size()==0;
	}
	public int size() {
		return arr.size();
	}
	public void enqueue(T item){
		arr.add(0, item);
	}
	public T dequeue(){
		return arr.remove(size()-1);
	}
	public static void main(String[] args) {
		Queue<Object> queue = new Queue<>();
		queue.enqueue(1);
		queue.enqueue(2);
		System.err.println(queue.size());
		System.err.println(queue.dequeue());
		System.err.println(queue.size());
	}
}

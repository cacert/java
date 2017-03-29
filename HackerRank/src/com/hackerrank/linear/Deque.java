package com.hackerrank.linear;

import java.util.ArrayList;
import java.util.List;

public class Deque <T> {
	private List<T> arr = new ArrayList<>();
	public void addFirst(T item){
		arr.add(0, item);
	}
	public void addLast(T item){
		arr.add(item);
	}
	public T removeLast(){
		return arr.remove(size());
	}
	public T removeFirst(){
		return arr.remove(0);
	}
	public int size() {
		return arr.size();
	}
	public boolean isEmpty(){
		return size() == 0;
	}
}

package com.hackerrank;

import java.util.Arrays;

public class MyVector <E>{
	
	private static int arr[];
	private int index ;
	private Object[] typearr;
	
	public MyVector(int initSize) {
		arr = new int[initSize];
		typearr = new Object[initSize];
		index =0;
	}
	public int getSize(){
		return index;
	}
	public boolean isEmpty(){
		return index == 0 ;
	}
	
	public static void main(String[] args) {
		MyVector myVector = new MyVector(10);
		System.err.println(myVector.isEmpty());
		System.err.println(myVector.getSize());
		myVector.add(1);
		myVector.add(2);
		myVector.add(3);
		myVector.add(4);
//		myVector.add(4,11);
//		myVector.add(1,2);
		
		myVector.addRecursive(4,11);
		myVector.addRecursive(1,2);
		System.err.println(myVector.isEmpty());
		System.err.println(myVector.getSize());
		System.err.println(myVector.get(2));
		System.err.println(Arrays.toString(arr));
	}
	private void add(int ix, int value) {
		ensureCapacity(index + 1);
		for(int i = index; i >= ix;i--){
			arr[i+1]=arr[i];
		}
		arr[ix]=value;
		index++;
	}
	
	private void addRecursive(int ix, int value) {
		if(ix < 0 || ix > index +1)
			return ;
		ensureCapacity(index + 1);
		addRecursive(ix+1, arr[ix]);
		//yana tasi
		arr[ix] = value;
		//gelen degeri set et
	}
	
	private int get(int i) {
		if(i < index)
			return arr[i];
		else 
			throw new  ArrayIndexOutOfBoundsException("vector lenght is " + index);
	}
	private void add(int i) {
		ensureCapacity(index+1);
		arr[index++]= i;
	}
	private void ensureCapacity(int i) {
		if(i<arr.length)
			return;
		int newsize = arr.length*2;
		int[] newArr = new int[newsize];
		System.arraycopy(arr, 0, newArr, 0, arr.length);
		arr = newArr;
	}
}

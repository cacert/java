package com.hackerrank;

public class Myheap {
	int[]arr = new int[10];
	int size = 0;
	
	public int getLeftChildIndex(int index){
		return (2*index)+1;
	}
	public int getRightChildIndex(int index){
		return (2*index)+2;
	}
	
	public int getParentIndex(int index){
		return (index-1)/2;
	}
	public void insert(int i){
		size++;
		arr[size-1]=i;
		siftUp();
	}
	private void siftUp() {
		if(size<2)
			return;
		int data = arr[size-1];
		int index = size -1;
		while(data< arr[getParentIndex(index)]){
			int temp = arr[index];
			arr[index]=arr[getParentIndex(index)];
			arr[getParentIndex(index)]=temp;
			index = getParentIndex(index);
		}
	}
	public static void main(String[] args) {
		new Myheap().test();
	}
	private void test() {
		insert(2);
		insert(5);
		insert(1);
		insert(1);
	}
}

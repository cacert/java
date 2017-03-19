package com.hackerrank;

/**
 * @author kasimsert
 *
 *Q1:Describe how you could use a single array to implement three stacks
 */
public class QueueTest {
	public static void main(String[] args) {
		new QueueTest().Q1(10);
	}

	private void Q1(int stacksize){
		MyStack myStack = new MyStack(stacksize);
		myStack.push(1, 1);
		myStack.push(1, 2);
		System.err.println(myStack.size(0));
		System.err.println(myStack.size(1));
		System.err.println(myStack.pop(1));
		System.err.println(myStack.pop(1));
	}
	
	private class MyStack{
		private int stacksize ;
		private int [] arr  ;
		private int [] order = {0,0,0};
		public MyStack(int size) {
			this.stacksize = size;
			arr = new int[stacksize*3];
		}
		public void push(int stacknum, int data){
			arr[stacknum*stacksize + order[stacknum]++] =data; 
		}
		public int  pop(int stacknum){
			if(order[stacknum] > 0)
				return arr[stacknum*stacksize + --order[stacknum]] ; 
			return 0;
		}
		public int  size(int stacknum){
			return order[stacknum] ; 
		}
	}
}

package com.hackerrank.linear;

public class QueueWithTwoStacks {
	
	private Stack<Integer> stack1  = new Stack<>();
	private Stack<Integer> stack2  = new Stack<>();
	
	public void enqueu(int i){
		stack1.push(i);
	}
	public int dequeue () throws QueueEmptyException{
		if(size()==0)
			throw new QueueEmptyException("queuee is empty");
		
		if(stack2.size()>0)
			return stack2.pop();
		
		while(stack1.size()>0)
			stack2.push(stack1.pop());
		
		return stack2.pop();
	}
	public int size(){
		return stack1.size()+stack2.size();
	}
	public static void main(String[] args) throws Exception{
		QueueWithTwoStacks queue = new QueueWithTwoStacks();
		queue.enqueu(1);
		queue.enqueu(2);
		queue.enqueu(3);
		System.err.println(queue.dequeue());
		System.err.println(queue.dequeue());
		System.err.println(queue.dequeue());
		System.err.println(queue.dequeue());
	}
	class QueueEmptyException extends Exception{
		public QueueEmptyException(String message) {
			super(message);
		}
	}
}

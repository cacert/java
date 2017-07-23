package com.kasim;

public class DoubleLinkedList {

	class Node {
		int data;
		Node  next;
		Node prev;
		public Node(int data ) {
			this.data = data;
		}
	}
	public void test() {
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		
		one.next = two;
		two.prev = one;
		
		two.next = three;
		three.prev = two;
		Node head = one;
		Node tail = three;
		
		Node current = head;
		
		while(current != null) {
			System.err.println(current.data);
			current =current.next;
		}
		current = tail;
		while(current != null) {
			System.err.println(current.data);
			current =current.prev;
		}
		
	}
	public static void main(String[] args) {
		new DoubleLinkedList().test();
	}
}

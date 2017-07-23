package com.kasim;

public class SingleLinkedList {
	class Node {
		int data ;
		Node next;
		public Node(int data ) {
			this.data = data;
		}
	}
	
	public boolean hasCycle(Node head) {
		
		return false;
	}
	
	public Node reverse(Node head) {
		
		if(head == null)
			return null;
		
		Node current = head;
		Node nextNode = current ;
		Node prev = null;
		
		while(current !=null) {
			nextNode =current.next;
			current.next = prev;
			prev = current;
			current = nextNode;
		}
		return prev ;
	}
	public void test () {
		Node two = new Node(2);
		Node one = new Node(1);
		Node three = new Node(3);
		
		one.next = two;
		two.next = three;
		Node head = one;
		Node current = head;
		while(current != null) {
			System.err.println(current.data);
			current = current.next;
		}
		
		current = reverse(head);
		while(current != null) {
			System.err.println(current.data);
			current = current.next;
		}
		
	}
	public static void main(String[] args) {
		new SingleLinkedList().test();
	}

}

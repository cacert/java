package com.hackerrank;

import java.util.HashSet;

import com.hackerrank.linear.Stack;

/**
 * @author kasimsert
 *
 *Q : Write code to remove duplicates from an unsorted linked list
 *Q : Implement an algorithm to  find the nth to last element of a singly linked list
 *Q : You have two numbers represented by a linked list, where each node contains a single 
 *    digit The digits are stored in reverse order, such that the 1’s digit is at the 
 *    head of the list 
 *    Write a function that adds the two numbers and returns the sum as a linked list
 */
public class LinkedListsTest {
	public static void main(String[] args) {
		LinkedListsTest listsTest = new LinkedListsTest();
		LinkedListNode a = listsTest.new LinkedListNode();
		a.data = "a";
		LinkedListNode b = listsTest.new LinkedListNode();
		b.data = "b";
		LinkedListNode c = listsTest.new LinkedListNode();
		c.data = "c";
		LinkedListNode d = listsTest.new LinkedListNode();
		d.data = "d";
		
		a.next = b;
		b.next = c;
		c.next= d;
		//d.next = a;
		//System.err.println(listsTest.checkIfCycyleExists(a));
		//listsTest.reverseUsingStack(a);
		listsTest.reverseInplace(a);
	}
	
	private LinkedListNode addLists(LinkedListNode n1, LinkedListNode n2,int carry){
		if(n2 == null || n1 == null){
			if(n2 != null){
				n2.data = String.valueOf(Integer.parseInt(n2.data) + carry);
				return n2;
			}
			if(n1 != null){
				n1.data = String.valueOf(Integer.parseInt(n1.data) + carry);
				return n1;
			}
		}
		int data1 = Integer.parseInt(n1.data);
		int data2 = Integer.parseInt(n2.data);
		int carryBit = (data1 + data2) > 10  ? 1 :0;
		LinkedListNode result = new LinkedListNode();
		result.data = String.valueOf((data1 + data2)%10) ;
		result.next = addLists(n1.next, n2.next, carryBit);
		return result;
	}
	private void removeDuplicates(LinkedListNode node){
		if(node == null || node.next == null)
			return ;
		HashSet<String> set = new HashSet<>();
		while(node.next != null){
			if(set.contains(node.next.data)){
				node.next = node.next.next;
			}
			set.add(node.next.data);
		}
	}
	
	private void removeDuplicatesNoBuffer(LinkedListNode head){
		if(head == null || head.next == null)
			return ;
		LinkedListNode current = head.next;
		LinkedListNode runner = head;
		LinkedListNode previous = head;
		while(current != null){
			runner = head;
			while(runner != current){
				if(runner.data.equals(current.data)){
					previous.next = current.next;
					current = current.next;
					break;
				}
				runner = runner.next;
			}
			if(runner == current){
				previous = current;
				current = current.next;
			}
		}
		
	}
	
	private LinkedListNode returnNthelement(LinkedListNode head, int n){
		
		if(head == null || head.next == null)
			return null;
		LinkedListNode p1 = head;
		LinkedListNode p2 = head;
		for(int i = 0 ; i < n ; i++){
			if(p2 == null) return null;
			p2=p2.next;
		} 
		//now p2 -p1 = n
		while(p2 != null){
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2;
		
	}
	class LinkedListNode{
		LinkedListNode next ;
		String data;
	}
	
	private boolean checkIfCycyleExists(LinkedListNode head){
		if(head == null)
			return false;
		LinkedListNode runner1 = head;
		LinkedListNode runner2 = head;
		while(runner1 != null && runner1.next != null){
			runner1= runner1.next.next;
			runner2 = runner2.next;
			if(runner1==runner2)
				return true;
		}
		return false;
	}
	private void reverseInplace(LinkedListNode head){
		if(head == null)
			return;
		LinkedListNode prev =null ; 
		LinkedListNode current = head;
		LinkedListNode next = null ;
		while (current != null){
			next = current.next;
			current.next = prev;
			
			prev = current;
			current = next ;
		}
		LinkedListNode runner = prev;
		while(runner != null){
			System.err.println(runner.data);
			runner = runner.next;
		}
	}
	private void reverseUsingStack(LinkedListNode head){
		if(head == null)
			return;
		//print first
		LinkedListNode runner = head;
		while(runner != null){
			System.err.println(runner.data);
			runner = runner.next;
		}
		
		Stack<LinkedListNode> stack = new Stack<>();
		runner = head;
		while(runner != null){
			stack.push(runner);
			runner  = runner.next;
		}
		runner  = stack.pop();
		head = runner;
		while(!stack.isEmpty()){
			runner.next=stack.pop();
			runner = runner.next;
		}
		runner.next = null;
		
		//print last
		runner = head;
		while(runner != null){
			System.err.println(runner.data);
			runner = runner.next;
		}
	}
}

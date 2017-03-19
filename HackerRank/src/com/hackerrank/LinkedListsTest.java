package com.hackerrank;

import java.util.HashSet;

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
		new LinkedListsTest();
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
	private class LinkedListNode{
		LinkedListNode next ;
		String data;
	}
}

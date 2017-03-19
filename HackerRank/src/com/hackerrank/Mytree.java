package com.hackerrank;

public class Mytree {

	public static void main(String[] args) {
		new Mytree().testtree();;
	}
	public void testtree(){
		Node node = new Node(5);
		node.insert(3);
		node.insert(7);
		node.insert(10);
		System.err.println(node.contains(10));
	}
	
	class Node{
		Node left, right;
		int value;
		public Node(int value) {
			this.value=value;
		}
		public void insert(int value){
			if(this.value > value){
				if(left == null)
					left= new Node(value);
				else
					left.insert(value);
			}
			else {
				if(right==null)
					right = new Node(value);
				else
					right.insert(value);
			}
		}
		public boolean contains(int value){
			if(this.value == value)
				return true;
			else if(right != null && this.value<value)
				return right.contains(value);
			else if(left != null)
				return left.contains(value);
			else return false;
		}
	}
	
}

package com.hackerrank;

public class BalancedTree {
	public static void main(String[] args) {
		BalancedTree balancedTree = new BalancedTree();
		Node n = new Node();
		n.data=1;
		Node left1 = new Node();
		Node right1 = new Node();
		Node left2 = new Node();
		Node right2 = new Node();
		Node left3 = new Node();
		n.left=left1;
		//n.right=right1;
		left1.left=left2;
		left1.right=right2;
		System.err.println(balancedTree.isBalanced(n));
		
	}
	private int maxDepth(Node n, int depth){
		if(n == null){
			return depth--;
		}
		depth++;
		return Math.max(maxDepth(n.right, depth),maxDepth(n.left, depth));
	}
	
	private int minDepth(Node n, int depth){
		if(n == null){
			return depth--;
		}
		depth++;
		return Math.min(minDepth(n.right, depth),minDepth(n.left, depth));
	}
	
	public boolean isBalanced(Node n){
		return (maxDepth(n, 0)-minDepth(n, 0))<=1;
	}
	
}
class Node{
	int data;
	Node right;
	Node left;
	public Node() {
	}
}

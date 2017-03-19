package com.hackerrank;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeSet;

public class TreeExamples {

	TNode root;
	
	public void insert(int value ){
		if(root== null) {
			TNode node = new TNode();
			node.data =value;
			root = node;
		}
		else
			insertNode(root, value);
	}

	private void insertNode(TNode root,int value) {
		if(root.data>value){
			if(root.left != null){
				insertNode(root.left, value);
			}
			else{
				TNode node = new TNode();
				node.data = value;
				root.left=node;
			}
		}
		else if(root.data<=value){
			if(root.right != null){
				insertNode(root.right, value);
			}
			else{
				TNode node = new TNode();
				node.data = value;
				root.right=node;
			}
		}
	}
	public static void main(String[] args) {
		new TreeExamples().test();
	}

	private void test() {
		insert(6);
		insert(2);
		insert(3);
		insert(1);
		insert(4);
		insert(11);
		insert(12);
		System.err.println("INORDER");
		traversalInOrder(root);
		System.err.println("POST");
		traversalPostOrder(root);
		System.err.println("PRE");
		traversalPreOrder(root);
		
		System.err.println("Size ::"+sizeBT(root));
		
		System.err.println("Hight ::"+heightBT(root));
		
		levelOrderTraversal(root);
		System.err.println(isBinarySearchTree(root, 0, Integer.MAX_VALUE));
		
		TreeExamples examples = new TreeExamples();
		examples.root = new TNode();
		examples.root.data=3;
		examples.root.left = new TNode();
		examples.root.left.data=1;
		examples.root.right=new TNode();
		examples.root.right.data=4;
		System.err.println(isBinarySearchTree(examples.root, 0, Integer.MAX_VALUE));
		
		System.err.println("Hight Stack ::"+heightWithStack(root));
		
		leftViewOfBT(root,0);
		System.err.println(isSubTree(root, examples.root));
		System.err.println("lca2 ::"+lca2(root, root.left.data, root.right.right.data).data);
		System.err.println(digit_sum(123));
		System.err.println(digit_sum(00123000000));
		System.err.println(deletion_distance("at","cat"));
		
		compareExample();
	}

	private void traversalInOrder(TNode node) {
		if(node!= null){
			traversalInOrder(node.left);
			System.err.println(node.data);
			traversalInOrder(node.right);
		}	
	}
	
	private boolean isBinarySearchTree(TNode root, int lower, int upper){
		if(root == null)
			return true;
		
		if(root.data<upper && root.data >= lower){
			return isBinarySearchTree(root.left, lower, root.data) && isBinarySearchTree(root.right, root.data, upper);
		}
		return false;
	}
	
	private void traversalWithStack(TNode root) {

	}
	
	private void findSumInPath(){
		
	}
	
	private void levelOrderTraversal(TNode root){
		if(root == null)
			return;
		Queue<TNode> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()){
			int level = q.size();
			while(level>0){
				TNode current = q.remove();
				System.err.print(current.data + " ");
				if(current.left != null)
					q.add(current.left);
				if(current.right!= null)
					q.add(current.right);
				level--;
			}
			System.err.println();
		}
	}
	
	private void traversalPostOrder(TNode node) {
		if(node!= null){
			traversalPostOrder(node.left);
			traversalPostOrder(node.right);
			System.err.println(node.data);
		}	
	}
	private void traversalPreOrder(TNode node) {
		if(node!= null){
			System.err.println(node.data);
			traversalPreOrder(node.left);
			traversalPreOrder(node.right);
		}	
	}
	private int sizeBT(TNode root){
		if(root == null)
			return 0;
		int left=sizeBT(root.left);
		int right=sizeBT(root.right);
		return left+right+1;
	}
	private int heightBT(TNode root){
		if(root==null)
			return 0;
		int left=heightBT(root.left);
		int right=heightBT(root.right);
		return Math.max(left, right)+1;
	}
	private int heightWithStack(TNode root){
		if(root == null){
			return 0;
		}
		Stack<TNode> stack = new Stack<>();
		stack.push(root);
		int height=0;
		while(!stack.isEmpty()){
			int level = stack.size();
			while(level > 0){
				TNode pop = stack.pop();
				if(pop.left != null)
					stack.push(pop.left);
				if(pop.right != null)
					stack.push(pop.right);
				level--;
			}
			height++;
		}
		return height;
	}
	private TNode lca(TNode root, TNode left, TNode right){
		if(root == null)
			return null;
		if(root == left || right == root)
			return root;
		TNode fromLeft = lca(root.left,left, right);
		TNode fromRight= lca(root.right,left,right);
		if(fromLeft != null && fromRight != null)
			return root;
		return fromLeft != null ? fromLeft : fromRight;
	}
	
	private TNode lca2(TNode root, int p, int q){
		if (root.data > Math.max(p, q)) {
            return lca2(root.left, p, q);
        } else if (root.data < Math.min(p, q)) {
            return lca2(root.right, p, q);
        } else {
            return root;
        }
	}
	
	class CompObject {
		String name;
		Integer salary;
		public CompObject(String name, Integer salary) {
			this.name=name;
			this.salary=salary;
		}
	}
	
	class CompObjectComparator implements Comparator<CompObject>{

		//1 ile 2. yi compare eder, ascending sort eder.	
		//Yani descending sort icin normalde dondugun degerin tersini donmek lazim.o2 compare o1 yani
		@Override
		public int compare(CompObject o1, CompObject o2) {
			if(o1.name.equals(o2.name))
				return o1.salary>o2.salary ? -1:1;
			return o1.name.compareTo(o2.name);
		}

		
	}
	
	private void compareExample(){
		Collection<CompObject> c =  new TreeSet<>(new CompObjectComparator());
		c.add(new CompObject("kasim",100));
		c.add(new CompObject("kasim", 1001));
		
		for(CompObject comp :c){
			System.err.println("name ::" + comp.name);
			System.err.println("Salary :: " + comp.salary);
		}
	}
	
    public static int deletion_distance(String str1, String str2) {
        char[] ss1 = str1.toCharArray();
        char[] ss2 = str2.toCharArray();
        Arrays.sort(ss1);
        Arrays.sort(ss2);
        int minl=Math.min(ss1.length,ss2.length);
        int i = 0;
        int count = 0;
        while(i<minl){
            if(ss1[i]!=ss2[i])
                count ++;
            i++;
        }
        
        count += Math.max(ss1.length,ss2.length)-minl;
        return count;
    }
    //comparator
	  public static int digit_sum(long number) {
	      long remainder=0;
	      number = Math.abs(number);
	      int total = 0;
	      while(true){
	    	  remainder = number %10;
	    	  total+=remainder;
	    	  number /=10;
	    	  if(remainder == number)
	    		  break;
	      }
	      return total;
	  }
	
	private void leftViewOfBT(TNode root,int level){
		System.err.println("left view of BT");
		Queue<TNode> q=new LinkedList<>();
		TNode current = root;
		q.add(current);
		while(!q.isEmpty()){
			TNode node = q.peek();
			int size = q.size();
			System.err.println(node.data);
			while(size>0){
				node = q.remove(); 
				if(node.left!=null)
					q.add(node.left);
				if(node.right != null)
					q.add(node.right);
				size --;
			}
		}
	}
	
	private boolean isIdentical(TNode root, TNode subroot){
		if(root == null && subroot == null){
			return true;
		}
		if(root == null || subroot==null){
			return false;
		}
		return (root.data == subroot.data) && isIdentical(root.left, subroot.left) && isIdentical(root.right, subroot.right);
	}
	private boolean isSubTree(TNode root, TNode subroot){
		if(subroot == null){
			return true;
		}
		if(root == null)
			return false;
		if(root.data == subroot.data)
			return isIdentical(root, subroot);
		return isSubTree(root.left, subroot) || isSubTree(root.right, subroot);
	}
}
class TNode{
	TNode left;
	TNode right;
	int data ;
}

class Deneme {
	static MyNode Insert(MyNode root, int value) {
		if (root == null) {
			MyNode node = new MyNode();
			node.data = value;
			return node;
		} else
			return insertNode(root, value);
	}

	static MyNode insertNode(MyNode root, int value) {
		if (root.data > value) {
			if (root.left != null)
				return insertNode(root.left, value);
			else {
				MyNode node = new MyNode();
				node.data = value;
				root.left = node;
				return node;
			}
		} else {
			if (root.right != null)
				return insertNode(root.right, value);
			else {
				MyNode node = new MyNode();
				node.data = value;
				root.right = node;
				return node;
			}
		}
	}
	static class MyNode{
		int data;
		MyNode right;
		MyNode left;
	}
	public static void main(String[] args) {
		Deneme deneme = new Deneme();
		MyNode root = deneme.Insert(null, 3);
		deneme.Insert(root, 1);
		deneme.Insert(root, 5);
		deneme.Insert(root, 2);
		deneme.Insert(root, 4);
	}
}



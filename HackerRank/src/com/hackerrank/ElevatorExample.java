package com.hackerrank;

import java.util.Arrays;

public class ElevatorExample {
	public static void main(String[] args) {
		new ElevatorExample().test();
	}

	private void test() {
		System.err.println(trapped2(new int[] { 0,1,0,2,1,0,1,3,2,1,2,1 }));
	}

	public int trap(int[] A) {
		if (A.length == 0)
			return 0;
		int[] maxLeft = new int[A.length];
		int[] maxRight = new int[A.length];
		int max = A[0];
		for (int i = 1; i < A.length; i++) {
			maxLeft[i] = max;
			if (A[i] > max)
				max = A[i];
		}
		max = A[A.length - 1];
		for (int i = A.length - 2; i >= 0; i--) {
			maxRight[i] = max;
			if (A[i] > max)
				max = A[i];
		}
		int ret = 0;
		for (int i = 1; i < A.length - 1; i++) {
			int trap = Math.min(maxLeft[i], maxRight[i]) - A[i];
			if (trap > 0)
				ret += trap;
		}
		return ret;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private int trapped2(int[] arr ){
		
		int[] maxleft= new int[arr.length];
		int[] maxright = new int[arr.length];
		int max=arr[0];
		for(int i=0 ; i< arr.length ; i++){
			maxleft[i]=max;
			if(arr[i]>max)
				max = arr[i];
		}
		max =arr[arr.length-1];
		for(int i=arr.length-1 ; i>=0 ; i--){
			maxright[i]=max;
			if(arr[i]>max)
				max = arr[i];
		}
		
		System.err.println(Arrays.toString(maxleft));
		System.err.println(Arrays.toString(maxright));
		int sum = 0;
		for(int i = 0 ; i<arr.length;i++){
			int value = Math.min(maxleft[i], maxright[i])-arr[i];
			if(value>0)
				sum+= value;
		}
		return sum;
		
	}
}

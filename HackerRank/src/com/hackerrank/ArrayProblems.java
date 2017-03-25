package com.hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayProblems {


	/**
	 * finds and returns how many two numbers sum up to input number
	 * @param arr
	 * @param num
	 * @return
	 */
	private int pairSum(int arr[] , int num) {
		if (arr.length==0)
			return 0;
		Map<Integer,Integer> complement = new HashMap<>();
		int count = 0;
		for(int i : arr){
			if(complement.containsKey(num-i)){
				complement.merge(num-i, -1, Integer::sum);
				count++;
			}
			else
				complement.merge(i, 1, Integer::sum);
		}
		return count;
	}
	
	/**
	 * find and return missing element in arr2
	 * @param arr1
	 * @param arr2
	 * @return
	 */
	private int findMissingElement(int[] arr1, int[] arr2){
		
		Map<Integer, Integer> counts = new HashMap<>();
		for(int i : arr1){
			counts.merge(i, 1, Integer::sum);
		}
		for(int i : arr2){
			counts.merge(i, -1, Integer::sum);
		}
		for(int i : counts.keySet()){
			if(counts.get(i)!=0)
				return i;
		}
		return -1;
	}
	
	private void computeSum(int[] arr){
		int sum= 0;
		for(int i = 0; i< arr.length; i ++){
			sum+= arr[i];
		}
		System.err.println("sum is "+sum);
	}
	
	public static void main(String[] args) {
		System.err.println(new ArrayProblems().findMissingElement(new int[]{1,2,3,4}, new int[]{1,2,4} ));
	}

	private void test() {
		computeSum(new int[]{1,2,3});
		findMinIndex(new int[]{11,55,22,5,4,777,1});
		findMinIndexReverse(new int[]{11,55,22,5,4,777,1});
		System.err.println(fiboBad(8));
		int arr [] = fiboGood(8);
		System.err.println(arr[0]+arr[1]);
		System.err.println(binarySearchRecursive(new int[]{1,10,12},11));
		System.err.println(binarySearchIterative(new int[]{1,2},2));
		System.err.println(Arrays.toString(reverseArr(new int [] {1,2})));
		System.err.println(findBeforeMinAfterMax(new int []{1,6,3,7,18,10,10,10}));
		MySingleton.INSTANCE.doSomething();
	}
	private int  findMinIndex(int[] arr ){
		int minIndex = 0;
		for(int i = 1;i< arr.length;i++){
			if(arr[minIndex]>arr[i]){
				minIndex = i;
			}
		}
		System.err.println("minindex is = " + minIndex);
		return minIndex;
	}
	private int findMinIndexReverse(int[] arr ){
		int minIndex = 0;
		
		for(int i = arr.length-1 ; i>=0 ; i--){
			if(arr[i]< arr[minIndex])
				minIndex = i;
		}
		System.err.println("minindexreverse is = " + minIndex);
		return minIndex;
	}
	private int fiboBad(int num){
		if(num<2)
			return num;
		else
		return fiboBad(num-1)+fiboBad(num-2);
	}
	private int[] fiboGood(int num){
		if(num<2)
			return new int[]{0,num};
		else{
			int result[] = fiboGood(num-1);
			return new int[] {result[1],result[0]+result[1]};
		}
	}
	
	private boolean binarySearchRecursive(int [] arr, int value){
		return findRecursive(arr,0,arr.length-1,value);
	}
	private boolean findRecursive(int[] arr, int start, int end, int value) {
		if(start>end) return false;
		int mid = (start + end)/2 ;
		if(arr[mid] == value)
			return true;
		else if(arr[mid]>value){
			return findRecursive(arr, start, mid-1, value);
		}
		else 
			return findRecursive(arr, mid+1, end, value);
	}

	private boolean binarySearchIterative(int [] arr, int value){
		int start = 0;
		int end = arr.length-1;
		 while (start<=end){
			 int mid = (start + end)/2;
			 if(arr[mid] == value)
				 return true;
			 else if(arr[mid]> value){
				 end = mid -1;
			 }
			 else
				 start = mid +1 ;
		 }
		return false;
	}
	private int[] reverseArr(int [] arr ){
		int start = 0;
		int end = arr.length-1;
		while(start < end){
			int temp = arr[start];
			arr [start] = arr[end];
			arr[end]= temp;
			start ++;
			end --;
		}
		return arr;
	}
	private int findBeforeMinAfterMax(int []arr){
		if(arr.length==0)
			return -1;
		if(arr.length<3)
			return arr[0];
		
		int tempMax=arr[0];

		int arrmin[] = new int [arr.length];
		int arrmax[] = new int [arr.length];
		
		for(int i = 0; i<arr.length;i++){
			if(tempMax<arr[i]){
				tempMax=arr[i];
			}
			arrmax[i] = tempMax;
		}
		int tempMin=arr[arr.length-1];
		for(int i = arr.length-1;i>=0;i--){
			if(tempMin>arr[i])
				tempMin=arr[i];
			arrmin[i]=tempMin;
		}
		for(int i =1;i<arr.length;i++){
			if(arrmin[i]==arrmax[i])
				return i;
		}
		return -1;
	}
	
	enum MySingleton{
		INSTANCE;
		public void doSomething(){
			System.err.println("singleton deneme");
		}
	}

}

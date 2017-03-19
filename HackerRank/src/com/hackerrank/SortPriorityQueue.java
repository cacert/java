package com.hackerrank;

import java.util.PriorityQueue;
import java.util.TreeMap;

public class SortPriorityQueue {
	public static void main(String[] args) {
		//new SortPriorityQueue().sortPQ(new int[]{1, 5,3,2,7},new int[]{11,2,4,6});
		new SortPriorityQueue().sortTM(new int[]{1, 5,3,2,7},new int[]{11,2,4,6});
		System.err.println(new SortPriorityQueue().findSubString("k asim1","k "));
	}
	private void sortPQ(int[] arr1, int[] arr2){
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i =0; i<arr1.length;i++){
			pq.add(arr1[i]);
		}
		for(int i =0; i<arr2.length;i++){
			pq.add(arr2[i]);
		}
		for(Integer i :pq){
			System.err.print(" " + i);
		}
		System.err.println();
		while(!pq.isEmpty()){
			System.err.print(" " + pq.remove());
		}
		
	}
	private void sortTM(int[] arr1, int[] arr2){
		TreeMap<Integer,Integer> pq = new TreeMap<>();
		for(int i =0; i<arr1.length;i++){
			pq.put(arr1[i],arr1[i]);
		}
		for(int i =0; i<arr2.length;i++){
			pq.put(arr2[i],arr2[i]);
		}
		for(Integer i :pq.keySet()){
			System.err.print(" " + i);
		}
		System.err.println();
//		while(!pq.isEmpty()){
//			System.err.print(" " + pq.remove());
//		}
		
	}
	public boolean findSubString(String st1, String st2){
		if(st1 == null)
			return false;
		if(st2 == null)
			return true;
		int lenSt1 = st1.length();
		int lenSt2 = st2.length();
		if(lenSt2>lenSt1)
			return false;
		boolean match = false ;
		int j = 0;
		for(int i = 0;i<lenSt1;i++){
			for (j = 0 ; j< lenSt2 && i+j<lenSt1;j++){
				if(st1.charAt(i+j)!=st2.charAt(j)){
					break;
				}
			}
			if(j == lenSt2)
				match = true;
		}
		return match;
	}
}

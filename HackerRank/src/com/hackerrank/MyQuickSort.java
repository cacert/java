package com.hackerrank;

public class MyQuickSort {
	public static void main(String[] args) {
		int[] arr = new int[]{1, 5, 2,17,4,9,2,30,11};
		new MyQuickSort().quicksort(arr,0,arr.length-1);
		for(int i : arr)
			System.err.print(i);
		
		System.err.println();
		arr = new int[]{2,5,3,1,4};
		new Rewrite().quicksort(arr, 0, arr.length-1);
		
		for(int i : arr)
			System.err.print(i);
	}
	public int partition(int [] arr, int begin, int end){
		int pivot = arr[(begin+end)/2];
		int i = begin;
		int j = end;
		while(i<=j){
			while(arr[i]<pivot)
				i++;
			while(arr[j]>pivot)
				j--;
			if(i<=j){
				swap(arr,i,j);
				i++;
				j--;
			}
		}
		return i;
	}
	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	private void quicksort(int [] arr, int begin, int end){
		int index = partition(arr, begin, end);
		if(begin < index-1)
			quicksort(arr, begin, index-1);
		if(index < end)
			quicksort(arr, index, end);
	}
}

class Rewrite{
	public void quicksort(int []arr, int begin, int end){
		if(begin >= end )
			return;
		//find pivot
		int pivot = arr[(begin+end)/2];
		//find elements which should be swapped
		int i = begin;
		int j =  end;
		while(i<=j){
			while(arr[i]< pivot){
				i++;
			}
			while(arr[j]>pivot){
				j--;
			}
			//make swap 
			if(i<=j){
				int temp = arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
				i++;
				j--;
			}
		}
		quicksort(arr, begin, i-1);
		quicksort(arr, i, end);
	}
	
}

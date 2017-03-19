package com.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArraysvsCollections {
	private void asList(){
		int[] arr = {1,2,3,4};
		System.err.println(Arrays.asList(arr));
	}
	public static void main(String[] args) {
		new ArraysvsCollections().test();
	}

	private void shuffle(Integer arr[]){
		Collections.shuffle(Arrays.asList(arr));
		System.err.println();
	}
	private void test(){
		Integer[] arr = new Integer[]{1,4,2,5,6,3};
		shuffle(arr);
		System.err.println(Arrays.toString(arr));
	}
}

package com.codewars;

public class FindMissingElement {
	public int solution(int[] A) {
		if (A.length == 0)
			return 1;
		long sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum = sum + A[i];
		}
		long normalSum = 0;
		for (int i = 0; i < A.length; i++) {
			normalSum = normalSum + i+1;
		}
		int diff = (int) (sum - normalSum);
		int last = A[A.length - 1];
		return last - diff;
	}
	private int solution2(int [] A) {
		int sum = 0;
		int i = 0 ;
		for(i = 0 ; i< A.length ; i++) {
			sum = sum ^ (A[i]^(i+1));
		}
		return sum^(i+1);
	}
	public static void main(String[] args) {
		FindMissingElement element = new FindMissingElement();
		int [] arr = new int[] {1,3};
		System.err.println(element.solution(arr));
		System.err.println(element.solution2(arr));
	}
}

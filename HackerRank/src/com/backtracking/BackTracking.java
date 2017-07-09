package com.backtracking;

public class BackTracking {
	public static void main(String[] args) {
		System.err.println(new BackTracking().splitOdd10(new int[]{1,2,3,4,10}));
	}

	private boolean splitOdd10(int[] nums) {
		int start = 0;
		int sum10 = 0;
		int sumOdd = 0;
		return group(start, sum10, sumOdd, nums);
	}

	private boolean group(int start, int sum10, int sumOdd, int[] nums) {
		if (start >= nums.length) {
			return sum10 % 10 == 0 && sumOdd % 2 != 0;
		}
		return group(start + 1, sum10 + nums[start], sumOdd, nums)
				|| group(start + 1, sum10, sumOdd + nums[start], nums);
	}

}

/**
pageIndex = 10
itemsperpage = 2
itemcount = 5 
 * 
 * */

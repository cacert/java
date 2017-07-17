package com.codewars;

public class SumOfDivided {
	public static String sumOfDivided(int[] l) {
		int max = Math.abs(l[0]);
		for (int i = 1; i < l.length; i++) {
			if (max < Math.abs(l[i])) {
				max = Math.abs(l[i]);
			}
		}
		String result = findPrime(l, max);
		return result;
	}

	private static String findPrime(int[] l, int min) {
		String result = "";
		for (int i = 2; i <= min; i++) {
			if (checkIfPrime(i)) {
				int sum = 0;
				int count = 0;
				for (int j = 0; j < l.length; j++) {
					if (Math.abs(l[j]) % i == 0) {
						sum = sum + l[j];
						count = count + 1;
					}
				}
				if (count > 0) {
					result = result + "(" + i + " " + sum + ")";
				}
			}
		}
		return result;
	}

	private static boolean checkIfPrime(int num) {
		for (int i = 2; i < num; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		int[] lst = new int[] {59,59, 79,79, 107};
		System.err.println(SumOfDivided.sumOfDivided(lst));
	}
}

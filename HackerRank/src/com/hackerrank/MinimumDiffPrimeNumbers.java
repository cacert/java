package com.hackerrank;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * You are given an array of integers. Find the minimum difference between two
 * prime numbers(Positive or negative) in the array when present with minimum
 * time complexity and provide the test data to test the this code.
 */
public class MinimumDiffPrimeNumbers {

	public static void main(String[] args) {
		int[] numbers = { 101, -113, 1, 45, 78, -2, -3, 7 };
		System.out.println(new MinimumDiffPrimeNumbers().findPrimes(numbers));

	}

	private int findPrimes(int[] numbers) {

		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();

		for (int i = 0; i < numbers.length; i++) {
			if (isPrime(numbers[i]))
				map.put(numbers[i], numbers[i]);
		}

		return map.firstKey().intValue() - map.lastKey().intValue();
	}

	private boolean isPrime(int n) {

		if (n < 0)
			n = 0 - n; // just convert n to positive for simplicity
		for (int i = 2; i < n / 2; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}

class BitDeneme {
	private void test2(){
		System.err.println(1^5);
	}

	private void test() throws IOException {
		byte[] bitfield = new byte[0xFFFFFFF / 8];
		Scanner in = new Scanner(new FileReader("aa.txt"));
		while (in.hasNextInt()) {
			int n = in.nextInt ();
			bitfield [n / 8] |= 1 << (n % 8);
		}
		for (int i = 0; i < bitfield.length; i++) {
			for (int j = 0; j < 8; j++) {
			}
		}
		in.close();
	}
	public static void main(String[] args) {
		new BitDeneme().test2();
	}

}

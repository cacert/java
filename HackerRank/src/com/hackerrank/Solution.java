package com.hackerrank;

public class Solution {

	public static void main(String[] args) {
		removeDuplicate();
	}

	private static void removeDuplicate() {
		char[] str = new char[] { 'a', 'a', 'a', 'b', 'd' };
		
		if (str == null)
			return;
		int len = str.length;
		if (len < 2)
			return;
		int tail = 1;
		for (int i = 1; i < len; ++i) {
			int j;
			for (j = 0; j < tail; ++j) {
				if (str[i] == str[j])
					break;
			}
			if (j == tail) {
				str[tail] = str[i];
				++tail;
			}
		}
		str[tail] = 0;
		System.err.println(str);
	}
}

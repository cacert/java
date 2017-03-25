package com.hackerrank;

import java.util.HashMap;
import java.util.Map;

public class AnagramSolutions {
	/**
	 * 	remove white space both
	 *	lower both
	 *  increase each letter count in map
	 *	decrease each letter count in map
	 * 	check if all of them is 0
	 * @param s1
	 * @param s2
	 * @return
	 */
	private boolean anagram(String s1, String s2) {
		if(s1== null || s2==null )
			return false;
		
		s1 = s1.replaceAll(" ", "").toLowerCase();
		s2 = s2.replace(" ", "").toLowerCase();
		
		Map<Character, Integer> counter = new HashMap<>();
		for (char c :s1.toCharArray()){
			counter.merge(c, 1, Integer::sum);
		}
		
		for (char c :s1.toCharArray()){
			counter.merge(c, -1, Integer::sum);
		}
		
		for(int i : counter.values()){
			if(i != 0)
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		System.err.println(new AnagramSolutions().anagram("ahmet", "tehma"));
	}
}

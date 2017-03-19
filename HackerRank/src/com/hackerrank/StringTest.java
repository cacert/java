package com.hackerrank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class StringTest {
	public boolean hasAllUniqueChars(String input){
		boolean[] chars = new boolean[256];
		int i =0;
		while(i< input.length()){
			if(chars[input.charAt(i)])
				return false;
			chars[input.charAt(i)]=true;
			i++;
		}
		return true;
	}
	
	private String reverseInPlace(String input){
		if(input == null || input.length() < 2)
			return input;
		int len = input.length()-1;
		char[] chars = input.toCharArray();
		char temp;
		for(int i = 0; i<len-i;i++){
			temp = chars[i];
			chars[i]=chars[len-i];
			chars[len-i]=temp;
		}
		return new String(chars);
	}
	public static void main(String[] args) {
		System.err.println(new StringTest().hasAllUniqueChars("abcd"));
		System.err.println(new StringTest().reverseInPlace(""));
		System.err.println(new StringTest().reverseInPlace(null));
		System.err.println(new StringTest().reverseInPlace("aaaaabndddjwekdwldwlk"));
		
		System.err.println(new StringTest().removeDuplicateAgain(null));
		System.err.println(new StringTest().removeDuplicateAgain("aaaaabndddjwekdwldwlk"));
		
		System.err.println(new StringTest().removeDuplicateWithHashset(null));
		System.err.println(new StringTest().removeDuplicateWithHashset("aaaaabndddjwekdwldwlk"));
		new StringTest().sortReverse(new String[]{"kasim","merv","eren"});
	}
	
	private String removeDuplicate(String input){
		if(input == null || input.length()<2)
			return input;
		int tail = 1;
		char[] chars = input.toCharArray();
		for(int i = 1;i< input.length() ; i++){
			int j;
			for (j = 0 ; j< tail ; j++){
				if(chars[i]==chars[j])
					break;
			}
			if(tail == j){
				chars[tail] = chars[i];
				tail ++;
			}
		}chars[tail]=0;
		return new String(chars);
	}
	private String removeDuplicateAgain(String input){
		if(input == null || input.length()<2)
			return input;
		int cursor =1;
		char[] chars = input.toCharArray();
		for (int i = 1; i<input.length(); ++i ){
			int j;
			for(j = 0;j<cursor;j++){
				if(chars[i]== chars[j])
					break;
			}
			if(j == cursor){
				chars[cursor++]=chars[i];
			}
		}
		chars[cursor]=0;
		return new String(chars);
	}
	
	private String removeDuplicateWithHashset(String input){
		if(input == null || input.length()<2)
			return input;
		Set<String> chars = new LinkedHashSet<>();
		for (int i = 0; i < input.length(); i++) {
			chars.add(String.valueOf(input.charAt(i)));
		}
		StringBuffer buffer = new StringBuffer();
		for(String s : chars){
			buffer.append(s);
		}
		return buffer.toString();
	}
	private void sortReverse(String []arr){
		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr, new MyComparator());
		System.out.println(Arrays.toString(arr));
		System.out.println();
	}
	private static class MyComparator implements Comparator<String>{

		@Override
		public int compare(String o1, String o2) {
			if(o1 == null || o2 == null){
				return 0;
			}
			if(o1.length()==o2.length())
				return o1.compareTo(o2);
			return o1.length()-o2.length();
		}
		
	}
}

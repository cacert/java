package com.hackerrank.linear;

import java.util.HashSet;
import java.util.Set;

public class BalancedParanthesisCheck {
	private Stack<Character> stack;
	private static Set<Character> openings = new HashSet<>();
	private static Set<String> matches = new HashSet<>();
	static{
		openings.add('{');
		openings.add('[');
		openings.add('(');
		matches.add("{}");
		matches.add("()");
		matches.add("[]");
	}
	
	private boolean isBalanced(String input){
		if(input == null)
			return true;
		stack = new Stack<>();
		for(int i = 0 ; i< input.length() ; i++){
			if(openings.contains(input.charAt(i))){
				stack.push(input.charAt(i));
			}
			else {
				if(stack.size()==0)
					return false;
				char index = input.charAt(i);
				char pop = stack.pop();
				//if((index== '}' && pop != '{') || (index== ']' && pop != '[') || (index== ')' && pop != '('))
				String pair= String.valueOf(pop)+String.valueOf(index);
				if(!matches.contains(pair))	
					return false;
			}
		}
		return stack.isEmpty();
	} 
	public static void main(String[] args) {
		BalancedParanthesisCheck bpc = new BalancedParanthesisCheck();
		System.err.println(bpc.isBalanced(""));
		System.err.println(bpc.isBalanced("{{{{}}}"));
		System.err.println(bpc.isBalanced("{([])}"));
		System.err.println(bpc.isBalanced("{[]}[]("));
	}
}

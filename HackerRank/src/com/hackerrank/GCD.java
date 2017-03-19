package com.hackerrank;

public class GCD {
	public int GCD(int num1, int num2){
		//gcd(a,b)=gcd(b,a mod b),
		//gcd(a,0)=a
		if(num1 == 0 )
			return num2;
		if(num2 == 0 )
			return num1;
		
		return GCD(num2,num1%num2);
	}
	public static void main(String[] args) {
		System.err.println(new GCD().GCD(100, 30));
	}
}

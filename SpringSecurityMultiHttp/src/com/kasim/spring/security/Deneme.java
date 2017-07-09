package com.kasim.spring.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Deneme {
	public static void main(String[] args) {
		System.err.println(Deneme.countPairs(new int[]{1, 2, 3,4,5,6},2));
	}
	
    static int numOfPlaylist(int N, int K, int L) {
    //N!/(N-K-1)! * (N-K)^ (L - K -1)
        long sum = 1;
        for(int i = N ; i>=(N-K) ; i--){
            sum = sum * i;
        }    
         for(int i = 0 ; i<(L-K-1) ; i++){
            sum = sum * (N-K);
        } 
        return (int)sum%1_000_000_007;
    }
    
    static int countPairs(int[] numbers, int k) {
        Arrays.sort(numbers);
        int count = 0;
        List<Integer[]> list =  new ArrayList<>();
        for(int i = 0 ; i< numbers.length ; i++){
            for(int j = i ; j< numbers.length ; j++){
                if(numbers[j] - numbers[i] == k && notExists(list,new Integer[]{numbers[i],numbers[j]}))
                    list.add(new Integer[]{numbers[i],numbers[j]});
            }
        }

        for(int i = 0 ; i< list.size() ; i++){
        	Integer[] current = list.get(i);
            for(int j = i+1 ; j< list.size() ; j++){
            	Integer[] temp = list.get(j);
                if((current[0] != temp[0] && current[1] != temp[1]) || (current[0] != temp[1] && current[1] != temp[0])){
                	count++;
                	continue;
                }
            }
        }
        
        return list.size() ;
    }

	private static boolean notExists(List<Integer[]> list, Integer[] temp) {
        for(int i = 0 ; i< list.size() ; i++){
        	Integer[] current = list.get(i);
            if((current[0] == temp[0] && current[1] == temp[1])){
            	return false;
            }
        }
		return true;
	}

}

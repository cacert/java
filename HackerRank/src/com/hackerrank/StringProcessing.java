package com.hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StringProcessing {
	
    public static int numberNeeded(String first, String second) {
        char[] firstarr = first.toCharArray();
        char[] secondarr = second.toCharArray();
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        
        for(int i = 0 ; i< firstarr.length ; i++){
            map1.putIfAbsent(firstarr[i], 0);
        	map1.put(firstarr[i],map1.get(firstarr[i])+1);
        }
        for(int j = 0 ; j< secondarr.length ; j++){
        	if(map1.containsKey(secondarr[j])){
        		map1.put(secondarr[j],map1.get(secondarr[j])-1);
        		if(map1.get(secondarr[j]) == 0)
        			map1.remove(secondarr[j]);
        		continue;
        	}
        	else{
	        	map2.putIfAbsent(secondarr[j], 0);
	        	map2.put(secondarr[j],map2.get(secondarr[j])+1);
        	}
        }
        int count = 0;
        for(Integer i : map1.values()){
        	count += i.intValue();
        }
        for(Integer i : map2.values()){
        	count += i.intValue();
        }
        return count;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        String magazine[] = new String[m];
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            magazine[magazine_i] = in.next();
        }
        String ransom[] = new String[n];
        for(int ransom_i=0; ransom_i < n; ransom_i++){
            ransom[ransom_i] = in.next();
        }
    }
    static void ransom(String[] magazine, String []ransom){
        
       Map<String, Integer> map = new HashMap<>();
       for(String str: ransom ){
           map.putIfAbsent(str,0);
           map.put(str,map.get(str)+1);
       }
       for(String str: magazine){
           if(map.containsKey(str)){
               map.put(str, map.get(str)-1);
               if(map.get(str) == 0){
                   map.remove(str);
               }
           }
       } 
       if(map.size() == 0)
           System.out.println("Yes");
       else
           System.out.println("No");
    }

}

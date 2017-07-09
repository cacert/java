package arrays;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Codility {
	public int solution(int[] A) {
		// sum to current
		// calculate remaining
		// check if they are equals
		if (A.length == 0)
			return 0;
		long sum = 0;
		for (int i = 0; i < A.length; i++) {
			if (i < A.length - 1 && remainingSum(A, i + 1) == sum) {
				return i;
			}
			sum += A[i];
		}
		return -1;
	}

	public long remainingSum(int[] arr, int index) {
		long sum = 0;
		for (int i = index; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}

	public static void main(String[] args) {
		System.err.println(new Codility().solution(new int[] { 2, 147, 483, 647, 1, 2, 147, 483, 647 }));
		System.err.println(new Codility().makeReadable(0));
		System.err.println(new Codility().order("4of Fo1r pe6ople g3ood th5e the2"));
		System.err.println(gap(328));
		System.err.println(findOdd(new int [] {2,3,2,1,1,4,4,7,7}));
		System.err.println(TripleDouble(451999277L, 41177722899L));
	}
	//photo.jpg, Warsaw, 2013-09-05 14:08:15
	

	private static String getExtension(String photo) {
		String string = photo.split(",")[0];
		
		int indexOf = string.indexOf(".");
		return string.substring(indexOf+1 );
	}

	private static String getNumber(int i, List<String> cities) {
		String result = ""+i;
		String.valueOf(cities.size()).length();
		for(int j = 1 ; j<String.valueOf(cities.size()).length(); j ++ ){
			result= "0" + result;
		}
		return result;
	}

	private static void sortByDatetime(Map<String, List<String>> cities) {
		// TODO Auto-generated method stub
		for(String city : cities.keySet() ){
			cities.put(city,sorted(cities.get(city)));
		}
	}

	
	
	private static List<String> sorted(List<String> list) {
		TreeMap<String, String> tree = new TreeMap<>();
		for(String line : list){
			tree.put(line.split(",")[2], line);
		}
		return (List<String>) tree.values();
	}

	private static String findCity(String line) {
		return line.split(",")[1];
	}

	public static int findOdd(int [] arr ){
		int num = 0;
		for(int i = 0 ; i< arr.length ; i++){
			num^=arr[i];
		}
		System.err.println(num);
		return num;
	}
	public static int TripleDouble(long num1,long num2 ){
		//TripleDouble(451999277L, 41177722899L);	
		List<Long> list = findTripples(num1);
		return findDoubles(list,num2);
	}

	private static int findDoubles(List<Long> in, long num2) {
		Map<Long, Long> map = new HashMap<>();
		List <Long> list = new ArrayList<>();
		while(num2>9){
			long remainder = num2%10;
			num2/=num2;
			if(map.containsKey(remainder)){
				map.put(remainder,	map.get(remainder) +1 );
				if(map.get(remainder) == 2)
					list.add(remainder);
			}
			else
				map.put(remainder, 1L);
		}
		for(Long i : in){
			if(list.contains(i)){
				return 1;
			}
		}
		return 0;
	}

	private static List<Long> findTripples(long num1) {
		Map<Long, Long> map = new HashMap<>();
		List <Long> list = new ArrayList<>();
		while(num1>9){
			long remainder = num1%10;
			num1/=num1;
			if(map.containsKey(remainder)){
				map.put(remainder,	map.get(remainder) +1 );
				if(map.get(remainder) == 3)
					list.add(remainder);
			}
			else
				map.put(remainder, 1L);
		}
		return list;
	}

	public static String makeReadable(int seconds) {
		int hour = 0;
		int minute = 0;
		int second = 0;

		minute = seconds / 60;
		second = seconds % 60;
		hour = minute / 60;
		minute = minute % 60;
		String min = minute < 10 ? "0" + minute : String.valueOf(minute);
		String sec = second < 10 ? "0" + second : String.valueOf(second);
		return hour + ":" + min + ":" + sec;
	}

	public static String order(String str) {
		if (str == null || str.length() == 0)
			return str;
		String[] words = str.split(" ");
		Map<Integer, String> map = new HashMap<>(words.length);
		int[] order = new int[words.length];
		for (int i = 0; i < order.length; i++) {
			for (int j = 0; j < words[i].length(); j++) {
				char c = words[i].charAt(j);
				if (Character.isDigit(c)) {
					order[i] = Integer.parseInt(String.valueOf(c));
					map.put(order[i], words[i]);
				}
			}
		}
		Arrays.sort(order);
		String result = "";
		for (int i = 0; i < order.length; i++) {
			if (!result.equals(""))
				result = result + " ";
			result = result + map.get(order[i]);
		}
		return result;
	}

	public static int gap(int N) {
		int i = N;
		String result = "";
		while(i>=2){
			result = i%2 + result;
			i = i/2;
			if(i<2)
				result = i%2 + result;
		}
		System.err.println(result);
		return calculateGap(result);
	}

	public static int  calculateGap(String result ){
		int distance = 0;
		int maxDistance = 0;
		for(int i = 0 ; i< result.length(); i++){
			distance = 0;
			if(result.charAt(i)=='1'){
				while(i < result.length()-1 && result.charAt(i+1) == '0'){
					i++;
					distance++;
				}
				if(i < result.length()-1 && result.charAt(i+1) == '1' && distance > maxDistance )
					maxDistance = distance;
			
			}
		} 
		return maxDistance;
	}
	public static boolean isPrime(long start) {
		long num = start;
		for (long i = 2; i < num; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

}

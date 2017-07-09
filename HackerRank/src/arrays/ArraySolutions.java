package arrays;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ArraySolutions {
	public static void main(String[] args) {
		int[] arr = new int[]{1,2,3};
		//System.out.println("arr1"+Arrays.toString(arr));
		int[] arr2 = arr;
		//System.out.println("arr2"+Arrays.toString(arr2));
		arr[2]= 2;
		//System.out.println("arr2"+Arrays.toString(arr2));
		//System.out.println("arr1"+Arrays.toString(arr));
		 printMinMax(new int[]{256741038,623958417,467905213,714532089,938071625});
		
		
	}
	private boolean findAnagramUsingHashTables(String s1, String s2){
		return false;
	}
	
    public static void printMinMax(int [] arr){
    	
        Arrays.sort(arr);
        long sum = 0;
        BigInteger bg = new BigInteger("0");
        
        System.out.print(bg.add(new BigInteger(String.valueOf(arr[0])))
        .add(new BigInteger(String.valueOf(arr[1])))
        .add(new BigInteger(String.valueOf(arr[2])))
        .add(new BigInteger(String.valueOf(arr[3]))));
        bg = new BigInteger("0");
        System.out.print(" "+      bg.add(new BigInteger(String.valueOf(arr[1])))
        .add(new BigInteger(String.valueOf(arr[2])))
        .add(new BigInteger(String.valueOf(arr[3])))
        .add(new BigInteger(String.valueOf(arr[4]))));

    }

}


class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1== null)
            return l2;
        if(l2 == null)
            return l1;
        return addRecursive(null,l1,l2,0);
    }
    private  ListNode addRecursive(ListNode current, ListNode l1, ListNode l2,int remainder){
        if(l1 == null && l2 == null && remainder == 0)
            return null ;
        
        int val1 = 0;
        int val2 = 0;
        
        if(l1!= null)
            val1 = l1.val;
        if(l2!= null)
            val2 = l2.val;
        
        int sum = val1+val2+remainder;
        int a  = sum %10;
        int b = 0;
        if(sum>9)
            b=sum/10 ;
        ListNode n = new ListNode(a);
        ListNode nextl1 = (l1 == null ? null : l1.next);
        ListNode nextl2 = (l2 == null ? null : l2.next);

        n.next = addRecursive(n, nextl1,nextl2,b);
        return n;
    }
    
    public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		
		ListNode ret = new Solution().addTwoNumbers(l1, l2);
		System.err.println(ret);
	}
}

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) 
     { val = x; 
     }
}


class Solution2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.nextLine();
		while (n > 0) {
			String str = scanner.nextLine();
			evaluate(str);
			n--;
		}
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
	}

	private static void evaluate(String str) {
		int length = str.length();
		boolean funny = true;
		if (length < 2) {
			System.out.println("Not Funny");
			return;
		}
		for (int i = 0; i < (length / 2); i++) {
			if (Math.abs(str.charAt(i) - str.charAt(i + 1)) == Math
					.abs(str.charAt(length - i - 1) - str.charAt(length - i - 2)))
				continue;
			else
				funny = false;
		}
		if (funny)
			System.out.println("Funny");
		else
			System.out.println("Not Funny");
	}

	
}

class FindMissingElement{
	
	private  void findMissingElement(int[] full, int[] minus){
		if(full.length-minus.length>1)
			return ;
		Map<Integer,Integer> map = new HashMap<>();
		for (int i=0;i<minus.length;i++){
			if(map.containsKey(minus[i])){
				map.put(minus[i], map.get(minus[i])+1);
			}
			else
				map.put(minus[i], 1);
		}
		for(int i= 0;i<full.length;i++){
			int current = full[i];
			if(map.containsKey(current)&& map.get(current)>0)
				map.put(current, map.get(current)-1);
			else {
				System.out.println(current);
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		FindMissingElement findMissingElement = new FindMissingElement();
//		findMissingElement.findMissingElement(new int[]{1,2,3,4},new int[]{1,7,3});
//		findMissingElement.longestSum(new int[]{1,2,-1,3,4,10,10,-10,-1});
		System.err.println(Arrays.toString(findMissingElement.fix34(new int[]{3, 1, 1, 3, 4, 4})));
	}
	
	private void longestSum(int[] arr){
		
		if(arr.length==0)
			return;
		
		int current_sum = arr[0];
		int max_sum = arr[0];
		
		for(int i =1;i<arr.length;i++){
			
		}
	}
	
	
	public int[] fix34(int[] nums) {
		if (nums.length == 0)
			return new int[0];
		int[] arr = new int[nums.length];
		int[] fours = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			if(fours[i] != 4)
				arr[i] = nums[i];
			if (nums[i] == 3) {
				swapNextFour(i + 1, nums, arr, fours);
				i++;
			}
		}
		return arr;
	}

	public void swapNextFour(int index, int[] nums, int[] arr, int[] fours) {
		for (int i = 0; i < arr.length; i++) {
			if (nums[i] == 4 && fours[i] != 4) {
				fours[i] = 4;
				if(arr[index]!=0)
					arr[i] = arr[index];
				else 
					arr[i] = nums[index];
				arr[index] = 4;
				break;
			}
		}
	}
}
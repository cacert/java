package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CodingBat {
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

	private void swapNextFour(int index, int[] nums, int[] arr, int[] fours) {
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
	
	public int maxMirror(int[] nums) {
		  //find contigues
		  //find contigues max
		  //find reverse
		  if(nums.length < 3)
		    return nums.length;
		  List<Integer> cont = findContigues(nums);
		  for(int i = cont.size()-1; i>=0 ; i--){
		    int max = cont.get(i);
		    if(findReverse(nums,max,cont.size()))
		      return cont.size();
		  }
		  return 1;
		}
		public List<Integer> findContigues(int[] nums){
		  List<Integer>  list = new ArrayList<>();
		  int maxlen= 0;
		  for(int i = 0 ; i< nums.length ; i++){
		    List<Integer> temp = findOne(i, nums);
		    if(maxlen < temp.size()){
		      list = temp;
		      maxlen = temp.size();
		    }
		  }
		  return list;
		}

		public List<Integer> findOne(int index,int[] nums){
		  List<Integer> list = new ArrayList<>();
		  int i = index;
		  list.add(nums[i]);
		  while(i<nums.length -1){
		    if((nums[i+1] - nums[i]) != 1)
		      break;
		    list.add(nums[++i]);
		  }
		  return list;
		}

		public boolean findReverse(int[]nums, int max, int size){
		  for(int i = 0 ; i<nums.length;i++){
		    if(nums[i] == max){
		      int j = 1;
		      while(i<nums.length-1 && nums[i]-nums[i+1]==1){
		        i++;
		        j++;
		        if(j==size)
		          return true;
		      }
		    }
		  }
		  return false;
		}
	
	public static void main(String[] args) {
		System.err.println(Arrays.toString(new CodingBat().fix34(new int[]{3, 1, 1, 3, 4, 4})));
		System.err.println(new CodingBat().maxMirror(new int[]{1, 2, 3, 2, 1}));
	}
}

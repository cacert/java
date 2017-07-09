package arrays;

import java.util.*;

public class Deneme {
	public static void main(String[] args) {
		System.err.println(Deneme.listSquared(1, 250));
		System.err.println( Deneme.sumConsecutives(Arrays.asList(1, 1, 2, 3, 4,4)));
	}

	public static String listSquared(long m, long n) {
		// findDivisors
		// find squared divisors sum
		// sqrroot
		List<String> result = new ArrayList<>();
		for (long i = m; i <= n; i++) {
			List<Long> list = findDivisors(i);
			if (list.isEmpty())
				continue;
			long sum = findSquaredSum(list);
			long num = (long) Math.sqrt(sum);
			if (sum == num * num)
				result.add("[" + i + ", " + sum + "]");
		}
		return result.toString();
	}

	public static List<Long> findDivisors(long i) {
		List<Long> list = new ArrayList<>();
		for (long l = 1; l <= i; l++) {
			if (i % l == 0) {
				list.add(l);
			}
		}
		return list;
	}

	public static long findSquaredSum(List<Long> list) {
		long sum = 0;
		for (Long l : list) {
			sum += l * l;
		}
		return sum;
	}

	public static List<Integer> sumConsecutives(List<Integer> s) {
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < s.size(); i++) {
			int current = s.get(i);
			int sum = current;
			while (i + 1 < s.size() && s.get(i + 1) == current) {
				sum += s.get(i + 1);
				i++;
			}
			result.add(sum);
		}
		return result;
	}
	
	public boolean groupSum(int start, int[] nums, int target) {
		  if(target == 0)
		    return true;
		  if(start>=nums.length)
		    return  false;
		  if(groupSum(start+1 ,nums,target-nums[start]))
		    return true;
		  if(groupSum(start+1 ,nums,target))
		    return true;
		  return false;
		}
}
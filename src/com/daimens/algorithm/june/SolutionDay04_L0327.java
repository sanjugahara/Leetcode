package com.daimens.algorithm.june;

public class SolutionDay04_L0327 {
	
	// O(n^2)
	public int countRangeSum(int[] nums, int lower, int upper) {
		if (nums.length == 0) return 0;
		
		long[] sum = new long[nums.length];
		sum[0] = nums[0];
		for (int i = 1; i < nums.length; i++){
			sum[i] = sum[i-1] + nums[i];
		}
		
		int cnt = 0;
		for (int i = 0; i < nums.length; i++){
			for (int j = i; j < nums.length; j++){
				long s = sum[j] - sum[i] + nums[i];
				if (s >= lower && s <= upper) cnt ++;
			}
		}
		
		return cnt;
    }
	
	

}

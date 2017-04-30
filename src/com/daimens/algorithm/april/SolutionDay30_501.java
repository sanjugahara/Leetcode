package com.daimens.algorithm.april;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author DemonSong
 *
 */
public class SolutionDay30_501 {

	public int subarraySum(int[] nums, int k) {

		if (nums.length == 0)
			return 0;

		int n = nums.length;
		int[] sums = new int[n + 1];

		sums[0] = 0;
		sums[1] = nums[0];

		for (int i = 2; i < sums.length; i++) {
			sums[i] += sums[i - 1] + nums[i - 1];
		}
		
		int count = 0;
		for (int i = 0; i < sums.length; i++) {
			
			int target = sums[i] + k;
			for (int j = i + 1; j < sums.length;j++){
				if (target == sums[j]){
					count ++;
				}
			}
		}

		return count;
	}

	public static void main(String[] args) {
		SolutionDay30_501 day = new SolutionDay30_501();

		int[] nums = { 1, 1, 1, 1 };
		day.subarraySum(nums, 2);
	}

}

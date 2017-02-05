package com.daimens.algorithm.february;

/**
 * 
 * @author Demon Song
 * 494.Target Sum
 * You are given a list of non-negative integers, a1,a2,...,an,and a target,S.Now you have 2 symbols + and -. 
 * For each integer,you should choose one from + and - as its new symbol.
 * Find out how many ways to assign symbols to make sum of integers equal to target S.
 * Example 1:
 * Input:nums is [1,1,1,1,1],S is 3.
 * Output: 5
 * Explanation:
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * There are 5 ways to assign symbols to make the sum of nums be target 3.
 * 
 * Note:
 * 1. The length of the given array is positive and will not exceed 20.
 * 2. The sum of elements in the given array will not exceed 1000.
 * 3. Your output answer is guaranteed to be fitted in a 32-bit integer.
 * 
 *
 */
public class SolutionDay05_494 {
	//值得讲解的一道dp题
	public int findTargetSumWays(int[] nums, int S) {
		int sum = 0;
		for (int i : nums) {
			sum += i;
		}
		if (S > sum || S < -sum) {
			return 0;
		}
		int[] dp = new int[2 * sum + 1];
		dp[0 + sum] = 1;
		for (int i = 0; i < nums.length; i++) {
			int[] next = new int[2 * sum + 1];
			for (int k = 0; k < 2 * sum + 1; k++) {
				if (dp[k] != 0) {//从后往前求！！！求得是sum
					next[k + nums[i]] += dp[k];
					next[k - nums[i]] += dp[k];
				}
			}
			dp = next;
		}
		return dp[sum + S];
	}
}

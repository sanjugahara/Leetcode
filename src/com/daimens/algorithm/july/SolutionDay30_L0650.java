package com.daimens.algorithm.july;

import java.util.Arrays;

public class SolutionDay30_L0650 {
	
	final int INF = 1 << 29;
	public int minSteps(int n) {
		int[] dp = new int[n + 16];
		Arrays.fill(dp, INF);
		dp[1] = 0;
		for (int i = 1; i < n; ++i){
			for (int j = 2 * i; j <= n; j += i){
				dp[j] = Math.min(dp[j], dp[i] + j / i);
			}
		}
		return dp[n];
	}
	
	public static void main(String[] args) {
		SolutionDay30_L0650 day = new SolutionDay30_L0650();
		System.out.println(day.minSteps(6));
	}

}

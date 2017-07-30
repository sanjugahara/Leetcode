package com.daimens.algorithm.july;

import java.util.Arrays;

public class SolutionDay30_L0501 {
	
	final int INF = 1 << 29;
	public int minSteps(int n) {
		int[] dp = new int[n + 16];
		Arrays.fill(dp, INF);
		dp[1] = 0;
		dp[2] = 2;
		if (n == 2) return dp[2];
		for (int i = 3; i <= n; ++i) dp[i] = i;
		for (int i = 1; i <= n; ++i){
			for (int j = 1; j <= n; ++j){
				for (int k = 1; k <= n; ++k){
					if (k + j < n && dp[k + j] > dp[k] + 1){
						dp[k + j] = dp[k] + 1;
					}
				}

				
				if (2 * j < n && dp[2 * j] > dp[j] + 2){
					dp[2 * j] = dp[j] + 2;
				}
			}
		}
		return dp[n];
	}
	
	
	public static void main(String[] args) {
		SolutionDay30_L0501 day = new SolutionDay30_L0501();
		System.out.println(day.minSteps(6));
	}

}

package com.daimens.algorithm.july;

import java.util.Arrays;

public class SolutionDay23_L0501 {
	
	class Pair{
		int x;
		int y;
		public Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public int findLongestChain(int[][] pairs) {
		int n = pairs.length;
		Pair[] ps = new Pair[n];
		for (int i = 0; i < n; ++i){
			ps[i] = new Pair(pairs[i][0], pairs[i][1]);
		}
		Arrays.sort(ps, (a, b) -> (a.x != b.x ? a.x - b.x : a.y - b.y));
		int[] dp = new int[n + 16];
		dp[1] = 1;
		for (int i = 1; i < n; ++i){
			for (int j = 0; j < i; ++j){
				if (ps[i].x > ps[j].y){
					dp[i + 1] = Math.max(dp[i + 1], dp[j + 1] + 1);
				}
				else{
					dp[i + 1] = Math.max(dp[i + 1], dp[j + 1]);
				}
			}
		}
		return dp[n];
    }
	
	
	public static void main(String[] args) {
		SolutionDay23_L0501 day = new SolutionDay23_L0501();
//		int[][] pairs = {{-6,9},{1,6},{8,10},{-1,4},{-6,-2},{-9,8},{-5,3},{0,3}};
		int[][] pairs = {{1,2},{2,3},{3,4}};
		System.out.println(day.findLongestChain(pairs));
	}
}

package com.daimens.algorithm.may;

import java.util.LinkedList;
import java.util.Queue;

public class SolutionDay07_503 {
	
	public int findPaths(int m, int n, int N, int i, int j) {
		
		int MOD = 1000000000 + 7;
        
		int[][] dp = new int[m][n];
		//boolean[][] hh = new boolean[m][n];
		dp[i][j] = 1;
		//hh[i][j] = true;
		int[][] directions= {{-1,0},{0,-1},{0,1},{1,0}};
		
		int[] now = {i,j,0};
		Queue<int[]> queue = new LinkedList<>();
		queue.add(now);
		
		int ans = 0;
		
		while (!queue.isEmpty()){
			int[] tmp = queue.poll();
			if (tmp[2] == N) break;
			for (int l = 0; l < 4; l++){
				int cur_i = tmp[0] + directions[l][0];
				int cur_j = tmp[1] + directions[l][1];
				if (cur_i == -1 || cur_i == m || cur_j == -1 || cur_j == n) {
					if (cur_i == -1) ans += dp[0][cur_j] % MOD;
					if (cur_i == m) ans += dp[m-1][cur_j]% MOD;
					if (cur_j == -1) ans += dp[cur_i][0]% MOD;
					if (cur_j == n) ans += dp[cur_i][n-1]% MOD;
					continue;
				}
				//if (hh[cur_i][cur_j]) continue;
				dp[cur_i][cur_j] = (cur_i == 0 ? 0 : dp[cur_i-1][cur_j]) + (cur_i == m-1 ? 0 : dp[cur_i+1][cur_j]) + (cur_j == n-1 ? 0 : dp[cur_i][cur_j+1]) + (cur_j == 0 ? 0 : dp[cur_i][cur_j-1]);
				//hh[cur_i][cur_j] = true;
				queue.add(new int[]{cur_i,cur_j,tmp[2]+1});
			}
		}
		
//		int ans = 0;
//		
//		for (int k = 1; k <= n; k++){
//			ans += dp[0][k] % MOD;
//			ans += dp[m+1][k] % MOD;
//		}
//		
//		for (int k = 1; k <= m; k++){
//			ans += dp[k][0] % MOD;
//			ans += dp[k][n] % MOD;
//		}
		
		return ans;
    }
	
	public static void main(String[] args) {
		SolutionDay07_503 day = new SolutionDay07_503();
		//day.findPaths(2, 2, 2, 0, 0);
		day.findPaths(1, 3, 3, 0, 0);
	}

}

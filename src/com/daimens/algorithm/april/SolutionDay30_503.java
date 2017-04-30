package com.daimens.algorithm.april;

public class SolutionDay30_503 {
	
	public int maxVacationDays(int[][] flights, int[][] days) {
		
		int n = days.length;
		int m = days[0].length;
		
		int[][] dp = new int[n+1][m+1];
		dp[1][1] = days[0][0]; 
		
		for (int i = 1; i < m; i++){
			dp[1][i+1] = dp[1][i] + days[0][i];
		}
		
		for (int j = 1; j < n;j++){
			if (flights[0][j] == 1){
				dp[j+1][1] = days[j][0];
			}
		}
		
		for (int i = 1; i < m; i++){
			for (int j = 0; j <  n; j++){
				for (int k = 0; k < n; k++){
					if (flights[k][j] == 1){
						dp[j+1][i+1] = Math.max(dp[j+1][i+1], dp[k+1][i] + (dp[k+1][i] == 0 ? 0 : days[j][i]));
					}else{
						dp[j+1][i+1] = Math.max(dp[j+1][i+1], dp[j+1][i] + (dp[j+1][i] == 0 ? 0 : days[j][i]));
					}
				}
			}
		}
		
		int max = 0;
		for (int i = 0; i < n+1; i++){
			max =Math.max(dp[i][m], max);
		}
		
        return max;
    }
	
	public static void main(String[] args) {
		SolutionDay30_503 day = new SolutionDay30_503();
//		int[][] flights = {{0,1,1},{1,0,1},{1,1,0}};
//		int[][] days = {{1,3,1},{6,0,3},{3,3,3}};
		
//		int[][] flights = {{0,0,0},{0,0,0},{0,0,0}};
//		int[][] days = {{1,1,1},{7,7,7},{7,7,7}};
		
//		int[][] flights = {{0,1,1},{1,0,1},{1,1,0}};
//		int[][] days = {{7,0,0},{0,7,0},{0,0,7}};
		
		int[][] flights = {{0,0,0},{0,0,1},{1,0,0}};
		int[][] days = {{0,1,0},{0,1,0},{1,0,0}};
		day.maxVacationDays(flights, days);
	}

}

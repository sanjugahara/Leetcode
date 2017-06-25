package com.daimens.algorithm.june;

public class SolutionDay25_L0502 {
	
	static int MOD = 1000000000 + 7;
//	public int kInversePairs(int n, int k) {
//		if (k == 0) return 1;
//		int res = 1;
//		for (int i = 1; i <= k && n >= 0; ++i, n -= 2){
//			res = (res * CN2(n,MOD)) % MOD;
//		}
//		return res;
//    }
//	
//	public int CN2(int n, int mod){
//		return (n % mod) * ((n - 1) % mod) / 2;
//	}
	
	public int kInversePairs(int n, int k) {
		if (k == 0) return 1;
		int[][] dp = new int[1000 + 16][1000 + 16];
		dp[2][0] = 1;
		dp[2][1] = 1;
		for (int i = 3; i <= n; ++i){
			for (int j = 1; j <= k; ++j){
				dp[n][k] = (dp[n-1][k-1] + dp[n-1][k]) % MOD;
			}
		}
		return dp[n][k];
	}
	
	public static void main(String[] args) {
		SolutionDay25_L0502 day = new SolutionDay25_L0502();
		System.out.println(day.kInversePairs(3, 1));
	}

}

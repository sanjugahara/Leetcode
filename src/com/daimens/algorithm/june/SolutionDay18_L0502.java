package com.daimens.algorithm.june;

import java.util.Arrays;

public class SolutionDay18_L0502 {
	
	public int smallestFactorization(int a) {
		if (a < 9) return a;
		String ans = "";
		while (a > 9){
			int i = 9;
			for (; i >= 1; --i){
				if (a % i == 0){
					ans += i;
					break;
				}
			}
			if (i == 1){ 
				return 0;
			}
			a = a / i;
		}
		ans += a;
		char[] array = ans.toCharArray();
		Arrays.sort(array);
		String small = new String(array);
		try {
			int num = Integer.parseInt(small);
			return num;
		} catch (NumberFormatException e) {
			return 0;
		}
    }
	
//	private String smallestFactorization(int a, int x){
//		if (a < 9) return "" + a;
//		String ans = "";
//		int i = 9;
//		for (; i >= 1; --i){
//			if (a % i == 0){ 
//				ans = "" + i + smallestFactorization(a / i,0);
//				break;
//			}
//		}
//		if (i == 1) return "0";
//		return ans;
//	}
	
	public static void main(String[] args) {
		SolutionDay18_L0502 day = new SolutionDay18_L0502();
		System.out.println(day.smallestFactorization(48));
	}
}

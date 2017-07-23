package com.daimens.algorithm.july;

public class SolutionDay23_L0502 {
	
	
	public int countSubstrings(String s) {
		char[] cs = s.toCharArray();
		int n = s.length();
		int start = 0;
		int cnt = 0;
		while (start < n){
			for (int i = start; i < n; ++i){
				if (isPalidrome(cs, start, i)){
					cnt++;
				}
//				else{
//					break;
//				}
			}
			start++;
		}
        return cnt;
    }
	
	public boolean isPalidrome(char[] cs, int i, int j){
		while (i < j){
			if (cs[i] != cs[j]) return false;
			i++;
			j--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		SolutionDay23_L0502 day = new SolutionDay23_L0502();
		System.out.println(day.countSubstrings("abc"));
		System.out.println(day.isPalidrome("aa".toCharArray(),0, 1));
	}

}

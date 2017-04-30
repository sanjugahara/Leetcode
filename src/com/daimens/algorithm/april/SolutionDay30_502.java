package com.daimens.algorithm.april;

public class SolutionDay30_502 {
	
	public boolean checkInclusion(String s1, String s2) {
		
		int[] map1 = new int[26];
		
		for (int i = 0; i < s1.length(); i++){
			map1[s1.charAt(i)-'a']++;
		}
		
		int len = s1.length();
		
		
		
		for (int i = 0; i + len -1 < s2.length(); i++) {
			String tmp = s2.substring(i, i+len);
			int[] map2 = new int[26];
			for (int j = 0; j < tmp.length();j++){
				map2[tmp.charAt(j)-'a']++;
			}
			
			if (isArraySame(map1, map2)) return true;
		}			
		
		return false;
    }
	
	private boolean isArraySame(int[] map1, int[] map2){
		for (int i = 0; i < map1.length; i++){
			if (map1[i] != map2[i]) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		SolutionDay30_502 day = new SolutionDay30_502();
		System.out.println(day.checkInclusion("ab", "eidboaoo"));
	}

}

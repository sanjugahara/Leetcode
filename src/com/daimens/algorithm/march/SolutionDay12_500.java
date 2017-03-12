package com.daimens.algorithm.march;

public class SolutionDay12_500 {
	
	public String reverseStr(String s, int k) {
		
		int len = s.length();
		
		if(len == 0) return "";
		
		StringBuilder sb;
		if(len <= k){
			sb = new StringBuilder(s);
			return sb.reverse().toString();
		}
		
		sb = new StringBuilder();
		
		int index = 0;
		while (index < len){
			// 逆序
			StringBuilder tmp = new StringBuilder();
			for (int i = index; i < k + index && i < len; i++){
				tmp.append(s.charAt(i));
			}
			
			index += k;
			sb.append(tmp.reverse().toString());
			
			//正序
			for (int i = index; i < k + index && i < len; i++){
				sb.append(s.charAt(i));
			}
			index += k;
		}
		
		return sb.toString();
	}
	
	
	public static void main(String[] args) {
		SolutionDay12_500 day = new SolutionDay12_500();
		
		String  string = "abcdefg";
		day.reverseStr(string, 2);
	}

}

package com.daimens.algorithm.march;

/**
 * 
 * @author DemonSong
 * 541.Reverse String II
 * Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from
 * the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k
 * but greater than or equal to k characters, then reverse the first k characters and left the other as original.
 * Example:
 * Input : s = "abcdefg",k =2
 * Output : "bacdfeg"
 * 
 * Restrictions:
 * 1. The string consists of lower English letters only.
 * 2. Length of the given string and k will in the range [1,10000]
 *
 */
public class SolutionDay12_500 {
	
//	public String reverseStr(String s, int k) {
//		
//		int len = s.length();
//		
//		if(len == 0) return "";
//		
//		StringBuilder sb;
//		if(len <= k){
//			sb = new StringBuilder(s);
//			return sb.reverse().toString();
//		}
//		
//		sb = new StringBuilder();
//		
//		int index = 0;
//		while (index < len){
//			// 逆序
//			StringBuilder tmp = new StringBuilder();
//			for (int i = index; i < k + index && i < len; i++){
//				tmp.append(s.charAt(i));
//			}
//			
//			index += k;
//			sb.append(tmp.reverse().toString());
//			
//			//正序
//			for (int i = index; i < k + index && i < len; i++){
//				sb.append(s.charAt(i));
//			}
//			index += k;
//		}
//		
//		return sb.toString();
//	}
	
//	public String reverseStr(String s, int k) {
//		
//		int len = s.length();
//		
//		if(len == 0) return "";
//		
//		StringBuilder sb = new StringBuilder();
//		
//		int index = 0;
//		while (index < len){
//			// 逆序
//			StringBuilder tmp = new StringBuilder();
//			for (int i = index; i < k + index && i < len; i++){
//				tmp.append(s.charAt(i));
//			}
//			
//			index += k;
//			sb.append(tmp.reverse().toString());
//			
//			//正序
//			for (int i = index; i < k + index && i < len; i++){
//				sb.append(s.charAt(i));
//			}
//			index += k;
//		}
//		
//		return sb.toString();
//	}
	
	//使用substring 用时 10ms
	public String reverseStr(String s, int k) {
		int len = s.length();
		if(len == 0) return "";
		
		StringBuilder sb = new StringBuilder();
		
		int index = 0;
		
		while(index < len){
			
			int last = index + k  < s.length() ? index+k : s.length();
			sb.append(new StringBuilder(s.substring(index, last)).reverse().toString());
			
			index = last;
			last = index + k < s.length() ? index + k : s.length();
			sb.append(s.substring(index,last));
			
			index = last;
		}
		
		return sb.toString();
	}
	
	
	public static void main(String[] args) {
		SolutionDay12_500 day = new SolutionDay12_500();
		
		String  string = "abcdefg";
		System.out.println(string.substring(1, 1+2));
		
		day.reverseStr(string, 2);
	}

}

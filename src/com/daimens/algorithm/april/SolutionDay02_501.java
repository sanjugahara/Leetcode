package com.daimens.algorithm.april;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class SolutionDay02_501 {
	
//	public int findLUSlength(String[] strs) {
//		
//		if(strs.length == 0) return -1;
//		
//		int[] len = new int[strs.length];
//		
//		for (int i = 0; i < strs.length; i++){
//			len[i] = strs[i].length();
//		}
//		
//		int maxLen = Integer.MIN_VALUE;
//		for (int i = 0; i < strs.length; i++){
//			if (len[i] < maxLen){
//				maxLen = len[i];
//			}
//		}
//		
//		String cmpStr = "";
//		int k = 0;
//		for (; k < strs.length; k++){
//			if (len[k] == maxLen){
//				cmpStr = strs[k];
//				break;
//			}
//		}
//		
//		for (int i = 0; i < strs.length; i++){
//			
//			if (i == k || strs[i].length() != maxLen) continue;
//			
//			if (cmpStr.equals(strs[i]))
//				return -1;
//		}
//		
//		return maxLen;
//    }
	
	
//	public int findLUSlength(String[] strs) {
//		if (strs.length == 0) return -1;
//		
//		Arrays.sort(strs,new Comparator<String>() {
//			@Override
//			public int compare(String o1, String o2) {
//				return o2.length() - o1.length();
//			}
//		});
//		
//		
//		if (strs[0].length() > strs[1].length()){
//			return strs[0].length();
//		}
//		
//		//all guys are the same length
//		if(strs[0].length() == strs[strs.length-1].length()){
//			
//			Set<String> hh = new HashSet<>();
//			for (int i = 0; i < strs.length; i++){
//				hh.add(strs[i]);
//			}
//			
//			if (hh.size() == strs.length)
//				return strs[0].length();
//			else
//				return -1;
//		}
//		
//		
//		int max = strs[0].length();
//		for (int i = 1; i < strs.length; i++){
//			
//			if(!isSubSequnce(strs[i-1], strs[i])){
//				int tmp = max;
//				max = Math.max(strs[i-1].length(), strs[i].length());
//				if(max == tmp)
//					max = strs[i].length();
//				return max;
//			}
//			max = strs[i].length();
//		}
//		
//		return -1;
//		
//	}
	
	public int findLUSlength(String[] strs) {
		
		if(strs.length == 0) return -1;
		
		
		Arrays.sort(strs,new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});
		
		int max = -1;
		
		for (int i = 0; i < strs.length; i++){
			
			boolean isLong = true;
			
			for (int j = 0; j < strs.length; j++){
				if (i == j || strs[j].length() < strs[i].length()) continue;
				
				if (isSubSequnce(strs[j], strs[i])) {
					isLong = false;
					break;
				}
			}
				
			if(isLong){
				max = Math.max(max, strs[i].length());
			}
		}
		
		return max;
	}
	
	//这个也是需要重写的！！！
	private boolean isSubSequnce(String seq, String subSeq){ //没有先后顺序
		
		if (seq.length() < subSeq.length()) {
			String tmp = seq;
			seq = subSeq;
			subSeq = tmp;
		}
		
		if (seq.length() == subSeq.length() && seq.equals(subSeq)) return true;
		
		int index_seq = 0;
		int index_sub = 0;
		while (index_seq < seq.length()){
			
			if (seq.charAt(index_seq) == subSeq.charAt(index_sub)){
				index_sub ++;
			}
			index_seq ++;
			
			if(index_sub == subSeq.length())
				return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		SolutionDay02_501 day = new SolutionDay02_501();
		
		String[] strs = {"aaa","aaa","aa"};
		System.out.println(day.isSubSequnce("aa","aaa"));
		System.out.println(3 % 3);
		day.findLUSlength(strs);
	}

}

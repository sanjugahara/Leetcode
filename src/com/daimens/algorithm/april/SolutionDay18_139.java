package com.daimens.algorithm.april;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author DemonSong 
 * 139.Word Break 
 * 		   Given a non-empty string s and a dictionary
 *         wordDict containing a list of non-empty words, determine if s can be
 *         segmented into a space-separated sequence of one or more dictionary
 *         words. You may assume the dictionary does not contain duplicate
 *         words.
 * 
 *         For example, given s = "leetcode", dict = ["leet", "code"].
 * 
 *         Return true because "leetcode" can be segmented as "leet code".
 *
 */
public class SolutionDay18_139 {
	
//	public boolean wordBreak(String s, List<String> wordDict) {
//		
//		boolean canBreak = false;
//	
//		String splitWords = "";
//		for (String split : wordDict){
//			String[] hh = s.split(split);
//			if (hh.length != 1){
//				canBreak = true;
//				splitWords = split;
//				break;
//			}
//		}
//		
//		if(!canBreak) return false;
//		
//		String[] arrays = s.split(splitWords);
//		wordDict.remove(splitWords);
//		
//		boolean tmp = true;
//		for (String ss : arrays){
//			if (ss.length() == 0) continue;
//			
//			tmp = tmp && wordBreak(ss, wordDict);
//		}
//		
//		return tmp;
//    }
	
	
	//循环遍历一次s就够了，必然能够用wordDict表示任何s
	public boolean wordBreak(String s, List<String> wordDict) {
		boolean[] f = new boolean[s.length()+1];
		
		f[0] = true;
		
		for (int i = 1; i <= s.length(); i++){
			for (int j = 0; j < i; j++){
				System.out.println("进入if之前：" +s.substring(j,i));
				if(f[j] && wordDict.contains(s.substring(j, i))){
					System.out.println("进入if之后：" +s.substring(j,i));
					f[i] = true;
					break;
				}
			}
		}
		
		return f[s.length()];
	}
	
	public static void main(String[] args) {
		SolutionDay18_139 day = new SolutionDay18_139();
		
//		String abc = "leetcode";
//		String[] hh = abc.split("leetcode");
		
		List<String> wordDict = new ArrayList<>();
		wordDict.add("leet");
		wordDict.add("code");
		
		String s = "leetcode";
		day.wordBreak(s, wordDict);
		
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				System.out.println(s.substring(j, i));
			}
		}
		
		

		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j <= s.length(); j++) {
				System.out.println(s.substring(i, j));
			}
		}
	}
}

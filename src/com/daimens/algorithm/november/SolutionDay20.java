package com.daimens.algorithm.november;

/**
 * 
 * @author Demon song
 * 242. Valid Anagram
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 *
 */
public class SolutionDay20 {
	
	public boolean isAnagram(String s, String t) {
		//ÿ����ĸ������һ���ַ����ж����ֹ�
		int[] charbucket = new int[26];
		for (char tempS : s.toCharArray()){
			charbucket[tempS-'a']++;
		}
		
		//Ͱʽ�ṹΪmap�ṹ
		for (char tempT : t.toCharArray()){
			charbucket[tempT-'a']--;
		}
		
		for (int i =0; i<26;i++){
			if (charbucket[i] !=0){
				return false;
			}
		}
		return true;   
    }
}

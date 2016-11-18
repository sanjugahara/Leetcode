package com.daimens.algorithm.november;

/**
 * 
 * @author demon
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * Examples:
 * s = "leetcode"
 * return 0.
 * s = "loveleetcode",
 * return 2.
 *
 */
public class SolutionDay18 {
	
	public int firstUniqChar(String s) {
		int[] characterMap = new int[26];
		char[] characters = s.toCharArray();
		//�������������map������
		for (char temp : characters){
			characterMap[temp-'a'] +=1;
		}
		//find the first characterMap Ϊ1�����
		for (int i =0; i<s.length();i++){
			if (characterMap[s.charAt(i)-'a'] ==1){
				return i;
			}
		}
		return -1;
    }
}

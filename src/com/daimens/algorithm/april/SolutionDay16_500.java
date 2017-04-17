package com.daimens.algorithm.april;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author DemonSong 
 * 551. Student Attendance Record I 
 * 
 *         https://leetcode.com/contest/leetcode-weekly-contest-28/problems/student-attendance-record-i/
 *         
 * 		   You are given a string
 *         representing an attendance record for a student. The record only
 *         contains the following three characters:
 * 
 *         'A' : Absent. 'L' : Late. 'P' : Present. A student could be rewarded
 *         if his attendance record doesn't contain more than one 'A' (absent)
 *         or more than two continuous 'L' (late).
 * 
 *         You need to return whether the student could be rewarded according to
 *         his attendance record.
 * 
 *         Example 1: Input: "PPALLP" Output: True Example 2: Input: "PPALLL"
 *         Output: False
 *
 */
public class SolutionDay16_500 {

//	public boolean checkRecord(String s) {
//
//		if (s.length() == 0)
//			return false;
//
//		Map<Character, Integer> map = new HashMap<>();
//
//		for (int i = 0; i < s.length(); i++) {
//			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
//		}
//
//		int count1 = map.get('A') == null ? 0 : map.get('A');
//
//		if (count1 > 1) {
//			return false;
//		}
//
//		int count2 = 1;
//		int max = 0;
//		for (int i = 1; i < s.length(); i++) {
//
//			if (s.charAt(i) == s.charAt(i - 1) && s.charAt(i - 1) == 'L') {
//				count2++;
//			} else {
//				max = Math.max(max, count2);
//				count2 = 1;
//			}
//		}
//
//		max = Math.max(max, count2);
//
//		if (max > 2) {
//			return false;
//		}
//		return true;
//	}
	
	public boolean checkRecord(String s){
		int[] map = new int[26];
		for (int i = 0; i < s.length(); i++){
			map[s.charAt(i)-'A']++;
		}
		
		if (map['A'-'A'] > 1) return false;
		
		int countL = 1;
		for (int i = 1; i < s.length(); i++){
			if (s.charAt(i-1) == 'L' && s.charAt(i) == s.charAt(i-1)){
				countL ++;
			}else{
				if (countL > 2) return false;
				countL = 1;
			}
		}
		
		if (countL > 2) return false;
		
		return true;
	}
	
	

	public static void main(String[] args) {
		SolutionDay16_500 day = new SolutionDay16_500();
		day.checkRecord("PPALLL");
	}

}

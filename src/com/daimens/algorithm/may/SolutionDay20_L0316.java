package com.daimens.algorithm.may;

/**
 * 
 * @author DemonSong
 * 
 *         316.Remove Duplicate Letters
 * 
 *         Given a string which contains only lowercase letters, remove
 *         duplicate letters so that every letter appear once and only once. You
 *         must make sure your result is the smallest in lexicographical order
 *         among all possible results.
 * 
 *         Example: Given "bcabc" Return "abc"
 * 
 *         Given "cbacdcbc" Return "acdb"
 *
 */
public class SolutionDay20_L0316 {
	
//	public String removeDuplicateLetters(String s) {
//        char[] c = s.toCharArray();
//        int[] map = new int[26];
//        for (int i = 0; i < c.length; i++){
//        	map[c[i]-'a']++;
//        }
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < map.length; i++){
//        	if (map[i] >= 1){
//        		char cc = (char) (i + 'a');
//        		sb.append(new String(new char[]{cc}));
//        	}
//        }
//        return sb.toString();
//    }
	
//	public String removeDuplicateLetters(String s) {
//		char[] c = s.toCharArray();
//		int[]  map = new int[26];
//		for (int i = 0; i < c.length; i++){
//			map[c[i]-'a']++;
//		}
//		
//		for (int i = 0; i < c.length; i++){
//			if(map[c[i]-'a'] >= 2){
//				map[c[i]-'a']--;
//				c[i] = '#';
//			}
//		}
//		
//		StringBuilder sb = new StringBuilder();
//		for (int i = 0; i < c.length; i++){
//			if (c[i] != '#'){
//				sb.append(new String(new char[]{c[i]}));
//			}
//		}
//		return sb.toString();
//	}
	
	public String removeDuplicateLetters(String s) {
		char[] c = s.toCharArray();
		int[]  map = new int[26];
		for (int i = 0; i < c.length; i++){
			map[c[i]-'a']++;
		}
		
		int lf = 0, rt = s.length()-1;
		while (lf < rt){
			while (lf < rt && ! (map[c[lf]-'a'] >= 2)) lf ++;
			while (lf < rt && ! (map[c[rt]-'a'] >= 2)) rt --;
			
			if (lf >= rt) break;
			
			if (c[lf] <= c[rt]){
				map[c[lf]-'a']--;
				c[lf] = '#';
				lf++;
			}else{
				map[c[rt]-'a']--;
				c[rt] = '#';
				rt--;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < c.length; i++){
			if (c[i] != '#'){
				sb.append(new String(new char[]{c[i]}));
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		SolutionDay20_L0316 day = new SolutionDay20_L0316();
		day.removeDuplicateLetters("bcabc");
	}
}

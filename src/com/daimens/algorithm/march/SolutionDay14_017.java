package com.daimens.algorithm.march;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * @author DemonSong
 * 17.Letter Combinations of a Phone Number
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * 
 * Input: Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * Note:
 * Although the above answer is in lexicographical order,your answer could be in any order you want.
 * 
 *
 */
public class SolutionDay14_017 {
	
	public List<String> letterCombinations(String digits) {
		
		if(digits.length() == 0) return new ArrayList<>();
		
		String[][] map ={{"a","b","c"},
							 {"d","e","f"},
							 {"g","h","i"},
							 {"j","k","l"},
							 {"m","n","o"},
							 {"p","q","r","s"},
							 {"t","u","v"},
							 {"w","x","y","z"}};
		
		List<String> res = new ArrayList<>();
		
		int len = digits.length();
		int index = 0;
		Queue<String> queue = new LinkedList<>();
		
		int digit = (int)(digits.charAt(index) - '0');
		for (String c : map[digit-2]){
			queue.add(c);
		}
		
		if(len == 1) {
			while(!queue.isEmpty()){
				res.add(queue.poll());
			}
		}
		
		index++;
		
		Queue<String> queue2 = new LinkedList<>();
		
		while(index < len){
			while(!queue.isEmpty()){
				String c = queue.poll();
				digit = (int)(digits.charAt(index) - '0');
				for (String cc : map[digit-2]){
					String tmp = c +cc;
					queue2.add(tmp);
				}
			}
			index ++;
			
			if(index == len){
				while(!queue2.isEmpty()){
					res.add(queue2.poll());
				}
			}else{
				queue = queue2;
			}
		}
		
		return res;
    }
	
	public static void main(String[] args) {
		SolutionDay14_017 day = new SolutionDay14_017();
		day.letterCombinations("22");
		
	}

}

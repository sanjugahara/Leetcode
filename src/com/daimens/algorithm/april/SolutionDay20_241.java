package com.daimens.algorithm.april;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author DemonSong 
 * 
 * 241.Different Ways to Add Parentheses
 * 
 *         Given a string of numbers and operators, return all possible results
 *         from computing all the different possible ways to group numbers and
 *         operators. The valid operators are +, - and *.
 * 
 * 
 *         Example 1 Input: "2-1-1".
 * 
 *         ((2-1)-1) = 0 (2-(1-1)) = 2 Output: [0, 2]
 * 
 * 
 *         Example 2 Input: "2*3-4*5"
 * 
 *         (2*(3-(4*5))) = -34 ((2*3)-(4*5)) = -14 ((2*(3-4))*5) = -10
 *         (2*((3-4)*5)) = -10 (((2*3)-4)*5) = 10 Output: [-34, -14, -10, -10,
 *         10]
 *
 */
public class SolutionDay20_241 {
	public List<Integer> diffWaysToCompute(String input) {
		
		List<Integer> ans = new ArrayList<>();
		for (int i = 0; i < input.length(); i++){
			if ((input.charAt(i) == '+') || (input.charAt(i) == '-') || (input.charAt(i) == '*')){
				String part1 = input.substring(0, i);
				String part2 = input.substring(i+1,input.length());
				
				List<Integer> left = diffWaysToCompute(part1);
				List<Integer> right = diffWaysToCompute(part2);
				
				for(int a : left){
					for(int b : right){
						int c = 0;
                        switch (input.charAt(i)) {
                            case '+': c = a+b;
                                break;
                            case '-': c = a-b;
                                break;
                            case '*': c = a*b;
                                break;
                        }
                        ans.add(c);
					}
				}
			}
		}
		
		if (ans.size() == 0) {
            ans.add(Integer.valueOf(input));
        }
		return ans;
    }
}

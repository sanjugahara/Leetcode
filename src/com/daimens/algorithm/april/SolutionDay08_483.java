package com.daimens.algorithm.april;

import java.util.Arrays;

/**
 * 
 * @author DemonSong
 * 483.Smallest Good Base
 * For an integer n. we call k>= 2 a good base of n, if all digits of n base k are 1.
 * Now given a string representing n, you should return the smallest good base of n in string format.
 * Example 1:
 * Input:"13"
 * Output: "3"
 * Explanation: 13 base 3 is 111.
 * 
 * Example 2:
 * Input:"4681"
 * Output:"8"
 * Explanation: 4681 base 8 in 11111.
 * 
 * Example 3:
 * Input: "1000000000000000000"
 * Output: "999999999999999999"
 * Explanation: 1000000000000000000 base 999999999999999999 is 11.
 * 
 * Note:
 * 1. The range of n is [3,10^18]
 * 2. The string representing n is always valid and will not have leading zeros.
 *
 */
public class SolutionDay08_483 {
	public String smallestGoodBase(String n) {
		
		for (int j = 3; j <= Integer.parseInt(n);j++){
			if (Integer.toString(Integer.parseInt(n), j).matches("1+")){
				return Integer.toString(j);
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
			System.out.println(Integer.toString(767, 766));
	}
}

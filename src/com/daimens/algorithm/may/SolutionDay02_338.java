package com.daimens.algorithm.may;

/**
 * 
 * @author DemonSong
 * 
 *         338. Counting Bits
 * 
 *         Given a non negative integer number num. For every numbers i in the
 *         range 0 ≤ i ≤ num calculate the number of 1's in their binary
 *         representation and return them as an array.
 * 
 *         Example: For num = 5 you should return [0,1,1,2,1,2].
 * 
 *         Follow up:
 * 
 *         It is very easy to come up with a solution with run time
 *         O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly
 *         in a single pass? Space complexity should be O(n). Can you do it like
 *         a boss? Do it without using any builtin function like
 *         __builtin_popcount in c++ or in any other language.
 *
 */
public class SolutionDay02_338 {
	public int[] countBits(int num) {
        int[] dp = new int[num+1];
        dp[0] = 0;
        
        int pow = 1;
        for (int i = 1,t = 0; i <= num; i++,t++){
        	if (i == pow){
        		pow *= 2;
        		t = 0;
        	}
        	dp[i] = 1 + dp[t];
        }
        
        return dp;
    }
	
	public static void main(String[] args) {
		SolutionDay02_338 day = new SolutionDay02_338();
		day.countBits(5);
	}
}

package com.daimens.algorithm.february;

import java.util.Random;

/**
 * 
 * @author Demon Song
 * 384.Shuffle an Array
 * Shuffle a set of numbers without duplicates.
 * Example:
 * init an a array with set 1,2,and 3.
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 * Shuffle the array[1,2,3] and return its result.Any permutation of [1,2,3] must equally likely
 * to be returned.
 * solution.shuffle();
 * Reset the array back to its original configuration [1,2,3]
 * solution.reset();
 * Returns the random shuffling of array [1,2,3]
 * solution.shuffle();
 *
 *
 */
public class SolutionDay04_384 {
	
	private int[] nums;
	private Random random;
	
	public SolutionDay04_384(int[] nums) {
        this.nums = nums;
        random = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
    	if(nums == null) return null;
    	int[] a = nums.clone();
    	for(int j = 1; j < a.length; j++){
    		int i = random.nextInt(j + 1);
    		swap(a, i, j);
    	}
        return a;
    }
    
    private void swap(int[] a,int i, int j){
    	int t = a[i];
    	a[i] = a[j];
    	a[j] = t;
    }
    
    public static void main(String[] args) {
    	int[] nums = new int[20];
    	SolutionDay04_384 day04_384 = new SolutionDay04_384(nums);
    	day04_384.shuffle();
	}
    
}


   


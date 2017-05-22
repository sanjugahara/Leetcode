package com.daimens.algorithm.may;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.sun.scenario.effect.LinearConvolveCoreEffect;

/**
 * 
 * @author DemonSong
 * 
 *         315.Count of Smaller Numbers After self
 * 
 *         You are given an integer array nums and you have to return a new
 *         counts array. The counts array has the property where counts[i] is
 *         the number of smaller elements to the right of nums[i].
 * 
 *         Example:
 * 
 *         Given nums = [5, 2, 6, 1]
 * 
 *         To the right of 5 there are 2 smaller elements (2 and 1). To the
 *         right of 2 there is only 1 smaller element (1). To the right of 6
 *         there is 1 smaller element (1). To the right of 1 there is 0 smaller
 *         element. Return the array [2, 1, 1, 0].
 *
 */
public class SolutionDay22_L0315 {
	
	// TLE
//	public List<Integer> countSmaller(int[] nums) {
//		List<Integer> count = new ArrayList<>();
//		for (int i = 0; i < nums.length; i++){
//			int cnt = 0;
//			for (int j = i + 1; j < nums.length; j++){
//				if (nums[j] < nums[i]) cnt ++;
//			}
//			count.add(cnt);
//		}
//		return count;
//    }
	
	
	private class BinaryTree{
		int val;
		int index;
		int layer;
		
		BinaryTree left;
		BinaryTree right;
		
		public BinaryTree(int val, int index) {
			this.val = val;
			this.index = index;
		}
		
		@Override
		public String toString() {
			return "["+val+","+index+"]";
		}
	}
	
	private BinaryTree insert(BinaryTree root, int val, int index, int layer){
		if (root == null) {
			root = new BinaryTree(val, index);
			root.layer = layer;
		}
		else if (root.val > val){
			root.left = insert(root.left, val, index, layer + 1);
		}
		else{
			root.right = insert(root.right, val, index,layer);
		}
		return root;
	}
	
	public List<Integer> countSmaller(int[] nums) {
		int len = nums.length;
		Integer[] ans = new Integer[len];
		List<Integer> sorted = new ArrayList<>();
		for (int i = len - 1; i >= 0; i--){
			int index = findIndex(sorted, nums[i]);
			index = index == -1 ? 0 : index;
			ans[i] = index;
			sorted.add(index,nums[i]);
		}
		return Arrays.asList(ans);
	}
	
	private int findIndex(List<Integer> sorted, int target){
		if (sorted.size() == 0) return 0;
		int lf = 0, rt = sorted.size()-1;
		while (lf < rt){
			int mid = lf + (rt + 1 - lf) / 2;
			if (sorted.get(mid) >= target){
				rt = mid - 1;
			}else{
				lf = mid;
			}
		}
		if (sorted.get(lf) < target) return lf+1;
		return -1;
	}
	
	
	public static void main(String[] args) {
		SolutionDay22_L0315 day = new SolutionDay22_L0315();
		int[] nums = {5,2,6,1};
		day.countSmaller(nums);
	}
	
}

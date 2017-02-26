package com.daimens.algorithm.february;

import java.util.HashMap;
import java.util.Map;

public class SolutionDay26_501 {
	//传统解法
//	public boolean checkSubarraySum(int[] nums, int k) {
//		if(nums.length < 2) return false;
//		
//		if (k == 0) {
//			for (int i = nums.length-1; i >= 0; i--) {
//				int sum = 0;
//				for (int j = 0; j <= i; j++){
//					sum += nums[j];
//				}
//				if (sum == 0){
//					return true;
//				}
//			}
//			return false;
//		}
//		
//		for (int i = nums.length-1; i >= 0; i--) {
//			int sum = 0;
//			for (int j = 0; j <= i; j++){
//				sum += nums[j];
//			}
//			if(sum % k == 0){
//				return true;
//			}
//		}
//		return false;
//    }
	
//	public boolean checkSubarraySum(int[] nums, int k) {
//		return helper(new ArrayList<>(), 0, nums, k) ;
//	}
//	
//	private boolean helper(List<Integer> ans, int start,int[] nums,int k){
//		boolean res = false;
//		if(ans.size() <= nums.length && !ans.isEmpty()){
//			int sum = 0;
//			for (int tmp : ans){
//				sum += tmp;
//			}
//			
//			if(k == 0 && sum == 0){
//				return true;
//			}
//			if(k != 0 && sum % k == 0){
//				return true;
//			}
//		}
//		for (int i = start; i < nums.length; i++) {
//			ans.add(nums[start]);
//			helper(ans, ++start, nums,k);
//			ans.remove(ans.size() - 1);
//		}
//		
//		return res;
//	}
	
	//smart solution
	public boolean checkSubarraySum(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>() {
			{
				put(0, -1); //初始化操作
			}
		};;
		
		int runningSum = 0;
		for (int i = 0; i < nums.length; i++) {
			runningSum += nums[i];
			
			if (k != 0)
				runningSum %= k;
			
			Integer prev = map.get(runningSum);
			if (prev != null) {
				if (i - prev > 1)
					return true;
			} else {
				map.put(runningSum, i);
			}
		}
		
		return false;
	}
	
	//iterator solution
	
	
	public static void main(String[] args) {
		SolutionDay26_501 day = new SolutionDay26_501();
		int[] nums ={23,2,4,6,7};
		System.out.println(day.checkSubarraySum(nums, 6));
	}
}

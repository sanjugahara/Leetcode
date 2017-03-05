package com.daimens.algorithm.march;

import java.util.HashMap;
import java.util.Map;

public class SolutionDay05_500 {
	
//	public int findPairs(int[] nums, int k) {
//		//k == 0是特殊情况
//		if (k == 0){
//			int sum = 0;
//			HashMap<Integer, Integer> map = new HashMap<>();
//			for (int i = 0; i < nums.length;i++){
//				//没有元素
//				if(map.get(nums[i]) ==null ){
//					map.put(nums[i], 1);
//				}
//				else{
//					int count = map.get(nums[i]);
//					map.put(nums[i], ++count);
//				}
//				
//			}
//			
//			for (int num : map.keySet()){
//				if(map.get(num) > 0){
//					sum ++;
//				}
//			}
//			return sum;
//		}
//		else{
//			Set<Integer> set = new HashSet<>();
//			for (int i = 0; i < nums.length;i++){
//				set.add(nums[i]);
//			}
//			
//			
//			int sum = 0;
//			int tmp[] = new int[set.size()];
//			
//			
//			int i = 0;
//			for (int outer : set){
//				tmp[i++] = outer;
//			}
//			
//			for (int j = 0; j < tmp.length;j++){
//				for (int x = j ; x < tmp.length; x++){
//					if(Math.abs(tmp[x]-tmp[j]) == k)
//						sum++;
//				}
//			}
//			
//			return sum;
//		}
//    }
	
	public int findPairs(int[] nums, int k) {
		if(k < 0) return 0; // border
		Map<Integer,Integer> map = new HashMap<>();
		int count = 0, n = nums.length;
		//双指针遍历
		for (int i = 0, j = 0; j < 2 * n; j++, i = j % n) { //为什么要扫描两遍
			
			if(!map.containsKey(nums[i])) map.put(nums[i], i);
			Integer upper = map.get(nums[i] + k);
			
			
			if(upper != null && upper != -1 && upper != i){ //upper != i 针对的是k=0 的情况吧?
				count++;
				map.put(nums[i] + k, -1);
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		SolutionDay05_500 day = new SolutionDay05_500();
	}

}

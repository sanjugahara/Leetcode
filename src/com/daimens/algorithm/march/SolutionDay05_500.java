package com.daimens.algorithm.march;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SolutionDay05_500 {
	
	public int findPairs(int[] nums, int k) {
		//k == 0是特殊情况
		if (k == 0){
			int sum = 0;
			HashMap<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < nums.length;i++){
				if(map.get(nums[i]) ==null ){
					map.put(nums[i], 1);
				}
				else{
					int count = map.get(nums[i]);
					map.put(nums[i], ++count);
				}
				
			}
			
			for (int num : map.keySet()){
				if(map.get(num) > 0){
					sum ++;
				}
			}
			return sum;
		}
		else{
			Set<Integer> set = new HashSet<>();
			for (int i = 0; i < nums.length;i++){
				set.add(nums[i]);
			}
			
			
			int sum = 0;
			int tmp[] = new int[set.size()];
			
			
			int i = 0;
			for (int outer : set){
				tmp[i++] = outer;
			}
			
			for (int j = 0; j < tmp.length;j++){
				for (int x = j ; x < tmp.length; x++){
					if(Math.abs(tmp[x]-tmp[j]) == k)
						sum++;
				}
			}
			
			return sum;
		}
    }
	
	public static void main(String[] args) {
		SolutionDay05_500 day = new SolutionDay05_500();
		
	}

}

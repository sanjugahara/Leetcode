package com.daimens.algorithm.march;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionDay26_503 {
	
	
	
	public int removeBoxes(int[] boxes) {
		
		if(boxes.length == 0) return 0;
		
		List<Integer> ans = new ArrayList<>();
		for (int num : boxes){
			ans.add(num);
		}
		
		find(ans);
		
        return maxSum;
    }
	
	int maxSum = 0;
	private void find(List<Integer> arrays){
		if(arrays.size() == 0) return;
		
		Map<Integer,Integer> map = new HashMap<>();
		
		for (int i = 0; i < arrays.size(); i++) {
			map.put(arrays.get(i), map.getOrDefault(arrays.get(i), 0)+1);
		}
		
		int max = Integer.MIN_VALUE;
		for(int count : map.values()){
			if(count > max){
				max = count;
			}
		}
		
		maxSum += max * max;
		
		List<Integer> values = new ArrayList<>();
		
		for(int key : map.keySet()){
			if(map.get(key) == max){
				values.add(key);
			}
		}
		
		
		
		
		for(int i = 0 ; i < values.size(); i++){
			
			int sum = maxSum;
			
			int value = values.get(i);
			
			int index = 0;
			while(index < arrays.size()){
				List<Integer> ans = new ArrayList<>();
				//head
				while(index < arrays.size() && arrays.get(index) == value) index++;
				
				while(index < arrays.size() && arrays.get(index) != value){
					ans.add(arrays.get(index));
					index ++;
				}
				
				find(ans);
				
				//tail
				while(index < arrays.size() && arrays.get(index) == value){
					index++;
				}
			}
			
			maxSum = Math.max(maxSum, sum);
		}
	}
	
	public static void main(String[] args) {
		SolutionDay26_503 day = new SolutionDay26_503();
		
		int[] boexes = {1, 3, 2, 2, 2, 3, 4, 3, 1};
		day.removeBoxes(boexes);
	}

}

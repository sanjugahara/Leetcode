package com.daimens.algorithm.august;

public class SolutionDay13_L0502 {
	
	public boolean isPossible(int[] nums) {
		
        int[] map = new int[10000 + 16];
        for (int i = 0; i < nums.length; ++i){
        	map[nums[i]] ++;
        }
        int len = nums.length;
        int n = nums.length;
        while (len != 0){
        	int max = -1;
        	int id = -1;
        	for (int i = 0; i < map.length; ++i){
        		if (map[i] > max){
        			max = map[i];
        			id = i;
        		}
        	}
        	//if (id + 1 >= n || id + 2 >= n) return false;
        	
        	if (map[id + 1] != 0 || map[id + 2] != 0) return false;
        	else{
                int mm = Math.max(map[id + 1], map[id + 2]);
        		map[id] -= mm;
        		map[id + 1] -= mm;
        		map[id + 2] -= mm;
        		int j = 0;
        		int cnt = 3;
        		while (id + j < n){
        			map[id + j] -= Math.min(mm, map[id + j]);
        			cnt ++;
        		}
        		len -= cnt;
        	}
        }
        return true;
    }
	
	public static void main(String[] args) {
		SolutionDay13_L0502 day = new SolutionDay13_L0502();
		int[] nums = {1,2,3,3,4,5};
		System.out.println(day.isPossible(nums));
	}

}

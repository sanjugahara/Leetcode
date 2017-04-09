package com.daimens.algorithm.april;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sun.glass.ui.Size;

public class SolutionDay09_501 {
	
//	public int leastBricks(List<List<Integer>> wall) {
//		if (wall.size() == 0) return 0;
//		
//		if (wall.get(0).size() == 0) return 0;
//		
//		Set<Integer> set = new HashSet<>();
//		
//		int row = wall.size();
//		
//		int sum = 0;
//		for (int j = 0; j < wall.get(0).size(); j++){
//			sum += wall.get(0).get(j);
//		}
//		
//		Map<Integer,List<Integer>> map = new HashMap<>();
//		for (int i = 0; i < row; i++){
//			int tmpSum = 0;
//			List<Integer> list = new ArrayList<>();
//			for (int j =0; j < wall.get(i).size(); j++){
//				tmpSum += wall.get(i).get(j);
//				list.add(tmpSum);
//				if(tmpSum == sum) continue;
//				set.add(tmpSum);
//			}
//			map.put(i, list);
//		}
//		
//		int min = row;
//		for (int num : set){
//			int count = 0;
//			for (int i =0; i< row; i++){
//				List<Integer> list = map.get(i);
//				
//				int lf = 0, rt = list.size()-1;
//				while (lf < rt){
//					int mid = lf + (rt -lf) / 2;
//					if (list.get(mid) < num){
//						lf = mid + 1;
//					}else{
//						rt = mid;
//					}
//				}
//				if (list.get(rt) != num){
//					count++;
//				}
//			}
//			
//			min = Math.min(min, count);
//		}
//		
//        return min;
//    }
	
	public int leastBricks(List<List<Integer>> wall) {
		if (wall.size() == 0) return 0;
		if (wall.get(0).size() == 0) return 0;
		
		Map<Integer,Integer> map = new HashMap<>();
		
		for (int i =0; i < wall.size(); i++){
			int sum = 0;
			for (int j = 0; j < wall.get(i).size()-1;j++){
				sum += wall.get(i).get(j);
				map.put(sum,map.getOrDefault(sum, 0)+1);
			}
		}
		
		int min = wall.size();
		for (int count : map.values()){
			min = Math.min(min, wall.size()-count);
		}
		
		return min;
	}
	
	public static void main(String[] args) {
		SolutionDay09_501 day = new SolutionDay09_501();
		List<List<Integer>> walls = new ArrayList<>();
		walls.add(new ArrayList<>());
		walls.add(new ArrayList<>());
		walls.add(new ArrayList<>());
		walls.add(new ArrayList<>());
		walls.add(new ArrayList<>());
		walls.add(new ArrayList<>());
		
		walls.get(0).add(1);
		walls.get(0).add(2);
		walls.get(0).add(2);
		walls.get(0).add(1);
		
		walls.get(1).add(3);
		walls.get(1).add(1);
		walls.get(1).add(2);
		
		walls.get(2).add(1);
		walls.get(2).add(3);
		walls.get(2).add(2);
	
		walls.get(3).add(2);
		walls.get(3).add(4);
	
		walls.get(4).add(3);
		walls.get(4).add(1);
		walls.get(4).add(2);
	
		walls.get(5).add(1);
		walls.get(5).add(3);
		walls.get(5).add(1);
		walls.get(5).add(1);
		
		day.leastBricks(walls);
	
	
	}

}

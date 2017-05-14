package com.daimens.algorithm.may;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class SolutionDay14_L0501 {
	
//	public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
//		List<Integer> ans = new ArrayList<>();
//		ans.add(kill);
//		boolean[] visited = new boolean[ppid.size()];
//		List<Integer> index = find(ppid,kill,visited);
//		Queue<List<Integer>> queue = new LinkedList<>();
//		if (!index.isEmpty()) queue.offer(index);
//		while (!queue.isEmpty()){
//			List<Integer> tmp = queue.poll();
//			for (int i = 0; i < tmp.size(); i++){
//				int target = pid.get(tmp.get(i));
//				ans.add(target);
//				List<Integer> array = find(ppid, target,visited);
//				if (!array.isEmpty()) queue.offer(array);
//			}
//		}
//		return ans;
//    }
//	
//	
//	private List<Integer> find(List<Integer> ppid, int kill,boolean[] visited){
//		List<Integer> ans = new ArrayList<>();
//		for (int i = 0; i < ppid.size(); i++){
//			if (visited[i]) continue;
//			if (ppid.get(i) == kill){
//				visited[i] = true;
//				ans.add(i);
//			}
//		}
//		return ans;
//	}
	
	public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
		Map<Integer,List<Integer>> map = new HashMap<>();
		for (int i = 0; i < ppid.size(); i++){
			map.computeIfAbsent(ppid.get(i), k -> new ArrayList<Integer>()).add(pid.get(i));
		}
		List<Integer> ans = new ArrayList<>();
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(kill);
		while (!queue.isEmpty()){
			int target = queue.poll();
			ans.add(target);
			if (map.containsKey(target)){
				List<Integer> tmp = map.get(target);
				for (int num : tmp){
					queue.offer(num);
				}
			}
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		SolutionDay14_L0501 day = new SolutionDay14_L0501();
		int[] nums = {1,2,3};
		int[] nums2 = {0,1,1};
		List<Integer> pid = new ArrayList<>();
		for (int n : nums){
			pid.add(n);
		}
		List<Integer> ppid = new ArrayList<>();
		for (int n : nums2){
			ppid.add(n);
		}
		day.killProcess(pid, ppid, 1);
	}

}

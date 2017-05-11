package com.daimens.algorithm.may;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author DemonSong
 * 
 *         207.Course Schedule
 * 
 *         There are a total of n courses you have to take, labeled from 0 to n
 *         - 1.
 * 
 *         Some courses may have prerequisites, for example to take course 0 you
 *         have to first take course 1, which is expressed as a pair: [0,1]
 * 
 *         Given the total number of courses and a list of prerequisite pairs,
 *         is it possible for you to finish all courses?
 * 
 *         For example:
 * 
 *         2, [[1,0]] There are a total of 2 courses to take. To take course 1
 *         you should have finished course 0. So it is possible.
 * 
 *         2, [[1,0],[0,1]] There are a total of 2 courses to take. To take
 *         course 1 you should have finished course 0, and to take course 0 you
 *         should also have finished course 1. So it is impossible.
 * 
 *         Note: The input prerequisites is a graph represented by a list of
 *         edges, not adjacency matrices. Read more about how a graph is
 *         represented. You may assume that there are no duplicate edges in the
 *         input prerequisites. click to show more hints.
 * 
 *         Hints: This problem is equivalent to finding if a cycle exists in a
 *         directed graph. If a cycle exists, no topological ordering exists and
 *         therefore it will be impossible to take all courses. Topological Sort
 *         via DFS - A great video tutorial (21 minutes) on Coursera explaining
 *         the basic concepts of Topological Sort. Topological sort could also
 *         be done via BFS.
 *
 */
public class SolutionDay11_L0207 {
	
//	public boolean canFinish(int numCourses, int[][] prerequisites) {
//		Map<Integer, List<Integer>> map = new HashMap<>();
//		for (int[] pre : prerequisites){
//			map.computeIfAbsent(pre[0], k -> new ArrayList<Integer>()).add(pre[1]);
//		}
//		boolean hasCycle = false;
//		for (int i = 0; i < prerequisites.length; i++){
//			hasCycle = hasCycle || dfs(prerequisites[i][0], new ArrayList<>(), map);
//		}
//        return !hasCycle;
//    }
//	
//	private boolean dfs(int curr, List<Integer> ans, Map<Integer, List<Integer>> map){
//		if (map.containsKey(curr)){
//			List<Integer> tmp = map.get(curr);
//			boolean hasCycle = false;
//			for (int course : tmp){
//				if (hasCycle(ans, course)) return true;
//				ans.add(course);
//				hasCycle = hasCycle || dfs(course, ans, map);
//				ans.remove(ans.size()-1);
//			}
//			return hasCycle;
//		}
//		else{
//			return false;
//		}
//	}
//	
//	private boolean hasCycle(List<Integer> ans, int add){
//		return ans.contains(add);
//	}
	
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		List<Integer> graph[] = new ArrayList[numCourses];
		for (int i = 0; i < numCourses; i++){
			graph[i] = new ArrayList<>();
		}
		boolean[] visited = new boolean[numCourses];
		for (int[] pre : prerequisites){
			graph[pre[0]].add(pre[1]);
		}
		
		for (int i = 0; i < numCourses; i++){
			if (dfs(graph, visited, i)){
				return false;
			}
		}
		return true;
	}
	
	private boolean dfs(List<Integer> graph[], boolean[] visited,int start){
		if (visited[start]) return true;
		visited[start] = true;
		for (int i = 0; i < graph[start].size(); i++){
			if(dfs(graph, visited, graph[start].get(i))){
				return true;
			}
		}
		//这句话是关键
		visited[start] = false;
		return false;
	}
	
	public static void main(String[] args) {
		SolutionDay11_L0207 day = new SolutionDay11_L0207();
		int[][] num = {{0,1},{1,0}};
		day.canFinish(2, num);
	}

}

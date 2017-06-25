package com.daimens.algorithm.june;

public class SolutionDay25_L0501 {
	
	public int scheduleCourse(int[][] courses) {
		int n = courses.length;
		int max = 0;
		for (int i = 0; i < n; ++i){
			max = Math.max(dfs(courses,i,0,new boolean[n]),max);
		}
		return max;
	}
	
	public int dfs(int[][] courses, int pos, int start, boolean[] visited){
		int now = courses[pos][0] + start;
		if (now <= courses[pos][1]){
			visited[pos] = true;
			int max = 1;
			for (int i = 0; i < courses.length; ++i){
				if (!visited[i]) max = Math.max(dfs(courses, i, now, visited)+1, max);
			}
			return max;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		SolutionDay25_L0501 day = new SolutionDay25_L0501();
		int[][] courses ={{1,2},{2,3}};
		System.out.println(day.scheduleCourse(courses));
	}
}

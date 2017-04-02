package com.daimens.algorithm.april;

import java.util.LinkedList;
import java.util.Queue;


public class SolutionDay02_502 {
	
//	public int findCircleNum(int[][] M) {
//		
//		if (M.length == 0) return 0;
//		
//		
//		int[][] friends = new int[M.length][M.length];
//		for (int i = 0; i < friends.length; i++){
//			friends[i][i] = i+1;
//		}
//		
//		for (int i = 0; i < M.length; i++){
//			for (int j = i; j < M.length; j++){
//				if(M[i][j] == 1){
//					if(i == 0)
//						friends[i][j] = i+1;
//					if (i != 0){
//						
//						int friendOfK = i+1;
//						for (int k = i-1; k >= 0; k--){
//							if(M[i-1][i] == 1){
//								friendOfK = friends[i-1][i];
//								break;
//							}
//						}
//						friends[i][j] = friendOfK;
//					}
//				}
//			}
//		}
//		
//		if(M[M.length-1][0] == 1){  //最后一个人和第一个人的关系
//			friends[0][M.length-1] = friends[M.length-1][M.length-1];
//		}
//		
//		
//		int max = M.length;
//		
//		Set<Integer> sets = new HashSet<>();
//		for (int i = 0; i < friends.length; i++){
//			for (int j = i + 1; j < friends.length; j++){
//				sets.add(friends[i][j]);
//			}
//		}
//		
//		
//        return sets.size() - 1;
//    }
	
//	public int findCircleNum(int[][] M) {
//		if (M.length == 0) return 0;
//		
//		int len = M.length;
//		int[][] friends = new int[len][len];
//		
//		for (int i = 0; i < len; i++){
//			friends[i][i] = i + 1;
//		}
//		
//		for (int i = 0; i < len; i++){
//			for (int j = i; j < len ; j++){
//				
//				if(i == 0){
//					if(M[i][j] == 1){
//						friends[i][j] = 1;
//						friends[j][i] = 1;
//					}
//				}
//				else{
//					int friendsOfK = i + 1;
//					for (int k = 0; k < i; k++){
//						if(friends[i][k] != 0){
//							friendsOfK = friends[i][k];
//						}
//					}
//					
//					if(M[i][j] == 1){
//						friends[i][j] = friendsOfK;
//						friends[j][i] = friendsOfK;
//					}
//				}
//			}
//		}
//		
//		Set<Integer> set = new HashSet<>();
//		for (int i = 0; i < len;i ++){
//			for (int j = 0; j < len; j++){
//				set.add(friends[i][j]);
//			}
//		}
//		
//		if (M[M.length-1][0] == 1){
//			return set.size()-2 < 0 ? 1 : set.size()-2;
//		}
//		
//		return set.size()-1 < 0 ? 1:set.size()-1;
//		
//	}
	
	public int findCircleNum(int[][] M) {
		
		if (M.length == 0) return 0;
		
		int len = M.length;
		
		int count = 0;
		for (int i = 0; i < len; i++) {
			if(M[i][i] != 0){
				count ++;
				bfs(M,i);
			}
		}
		
		return count;
	}
	
	private void bfs(int[][] M,int row){
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(row);
		
		while (!queue.isEmpty()){
			int h = queue.poll();
			for (int col = 0; col < M.length; col ++){
				if(M[h][col] != 0){
					queue.offer(col);
					M[h][col] = 0;
				}
			}
		}
		
	}
	
	
	
	public static void main(String[] args) {
		SolutionDay02_502 day = new SolutionDay02_502();
		int[][] M = {{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
		
		day.findCircleNum(M);
	}

}

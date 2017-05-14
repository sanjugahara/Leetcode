package com.daimens.algorithm.may;

import java.util.Comparator;
import java.util.PriorityQueue;

import javafx.scene.control.Cell;

/**
 * 
 * @author DemonSong
 * 
 *         407.Trapping Rain Water II
 * 
 *         Given an m x n matrix of positive integers representing the height of
 *         each unit cell in a 2D elevation map, compute the volume of water it
 *         is able to trap after raining.
 * 
 *         Note: Both m and n are less than 110. The height of each unit cell is
 *         greater than 0 and is less than 20,000.
 * 
 *         Example:
 * 
 *         Given the following 3x6 height map: [ [1,4,3,1,3,2], [3,2,1,3,2,4],
 *         [2,3,3,2,3,1] ]
 * 
 *         Return 4.
 * 
 *         The above image represents the elevation map
 *         [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]] before the rain.
 * 
 * 
 *         After the rain, water are trapped between the blocks. The total
 *         volume of water trapped is 4.
 *
 */
public class SolutionDay13_L0407 {

	public int trapRainWater(int[][] heightMap) {
		int row = heightMap.length;
		if (row <= 2) return 0;
		int col = heightMap[0].length;
		if (col <= 2) return 0;
		
		int[][] dir = {{-1,0},{1,0},{0,-1}};
		
		int area = 0;
		for (int i = 1; i < row - 1; i++) {
			int minHeight = heightMap[i][0];
			for (int j = 1; j < col -1; j ++){
			}
		}
		return area;
	}
	
	public static void main(String[] args) {
		SolutionDay13_L0407 day = new SolutionDay13_L0407();
		int[][] heightMap = {{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}};
		day.trapRainWater(heightMap);
	}
}

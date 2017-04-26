package com.daimens.algorithm.april;

import java.util.Stack;

/**
 * 
 * @author DemonSong
 * 
 *         84.Largest Rectangle in Histogram
 * 
 *         Given n non-negative integers representing the histogram's bar height
 *         where the width of each bar is 1, find the area of largest rectangle
 *         in the histogram.
 * 
 * 
 *         Above is a histogram where width of each bar is 1, given height =
 *         [2,1,5,6,2,3].
 * 
 * 
 *         The largest rectangle is shown in the shaded area, which has area =
 *         10 unit.
 * 
 *         For example, Given heights = [2,1,5,6,2,3], return 10.
 *
 */
public class SolutionDay26_084 {

	public int largestRectangleArea(int[] heights) {
		
		Stack<Integer> stack = new Stack<>();
		
		int max = 0;
		for (int i = 0; i <= heights.length; i++){
			int curr = (i == heights.length) ? 0: heights[i];
			int count = 0;
			while(!stack.isEmpty() && heights[stack.peek()] > curr){
				int pos = stack.pop();
				max = Math.max(max, heights[pos] * (i - pos));
				heights[pos] = curr;
				count++;
			}
			i -= count;
			stack.push(i);
		}
		
        return max; 
    }

//	public int largestRectangleArea(int[] height) {
//        int len = height.length;
//        Stack<Integer> s = new Stack<Integer>();
//        int maxArea = 0;
//        for(int i = 0; i <= len; i++){
//            int h = (i == len ? 0 : height[i]);
//            if(s.isEmpty() || h >= height[s.peek()]){
//                s.push(i);
//            }else{
//                int tp = s.pop();
//                maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
//                i--;
//            }
//        }
//        return maxArea;
//    }
	
	public static void main(String[] args) {
		SolutionDay26_084 day = new SolutionDay26_084();
		int[] heights = {2,1,5,6,2,3};
		day.largestRectangleArea(heights);
	}
}

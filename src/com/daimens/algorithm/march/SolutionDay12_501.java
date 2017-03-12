package com.daimens.algorithm.march;

import java.util.Arrays;
import java.util.List;

public class SolutionDay12_501 {

	public int findMinDifference(List<String> timePoints) {
		
		int[] times = new int[timePoints.size()];
		int index = 0;
		
		for (String num : timePoints){
			String[] time = num.split(":");
			int minutes = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
			times[index++] = minutes;
		}
		
		Arrays.sort(times);
		
		int min = Integer.MAX_VALUE;
		
		for (int i = 1; i < times.length; i++){
			if(times[i] - times[i-1] < min){
				min = times[i] - times[i-1];
			}
		}
		
		//最后一个数
		
		if ((times[0] + 24 * 60 )- times[times.length -1] < min){
			min = (times[0] + 24 * 60 )- times[times.length -1];
		}
		
		return min;
	}
	
	public static void main(String[] args) {
		SolutionDay12_501 day = new SolutionDay12_501();
	}
}

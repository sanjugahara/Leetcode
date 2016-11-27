package com.daimens.algorithm.november;

import java.util.HashMap;

/**
 * 
 * @author Demon Song
 * 447. Number of Boomerangs
 * Given n points in the plane that are all pairwise distinct,
 * a "boommerange" is a tuple of points (i,j,k)such that the 
 * distance between i and j equals the distance between i and k
 * (the order of the tuple matters)
 * Find the number of boomeranges. You may assume that n will be
 * at most 500 and coordinates of points are all in range [-10000,10000]
 * Example:
 * Input:
 * [[0,0],[1,0],[2,0]]
 * Output:
 * 2
 * Explanation:
 * The two boomerange are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
 *
 */
public class SolutionDay26 {
	//����������⣬��Ѱһ���㵽�����ľ��룬���Ҽ�¼����
	public int numberOfBoomerangs(int[][] points) {
		int sum = 0;
		//����ѭ�� 1. ��һ�������ѭ�� 2. ���㶥�������ѭ�� - ����ѭ���м��� tuple ����
		for (int i = 0 ; i < points.length; i++){ //points�ĸ���
			//�Ծ���Ϊkey����ͬ����Ĵ���Ϊvalue������HashMap
			HashMap<Integer, Integer> distanceCountMap = new HashMap<Integer,Integer>();
			for (int j = 0; j < points.length; j++){
				//���������ľ���
				int distance = pointsDistance(points[i][0], points[i][1], points[j][0], points[j][1]);
				//map �в����ڶ�Ӧ��distance
				if (!distanceCountMap.containsKey(distance)){
					distanceCountMap.put(distance, 1);
				}else{ //map �д��ڶ�Ӧ��key
					int value = distanceCountMap.get(distance);
					distanceCountMap.put(distance, ++value);
				}
			}
			//ѭ������
			for (Integer value : distanceCountMap.values()){
				sum += value * (value-1);
			}
		}
        return sum;
    }
	
	public int pointsDistance(int xPt1,int yPt1, int xPt2,int yPt2){
		int x = xPt1-xPt2;
		int y = yPt1-yPt2;
		return x*x + y*y;
	}
	
	public static void main(String[] args) {
		int[][] points = {{1,0},{0,0},{2,0}};
		SolutionDay26 day26 = new SolutionDay26();
		System.out.println(day26.numberOfBoomerangs(points));
	}
}

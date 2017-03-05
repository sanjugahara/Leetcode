package com.daimens.algorithm.march;

public class SolutionDay05_502 {
	
	public int findBlackPixel(char[][] picture, int N) {
		int sum = 0;
		
		//先col
		for (int col = 0; col< picture[0].length;col++){
			//统计每一行，如果有多个元素 就删除了
			int[] count = new int[26];
			
			for (int row = 0; row < picture.length;row++){
				count[picture[row][col]-'A']++;
			}
			
			if(count['B'-'A'] == N){ 
				sum += N;
			}
		}
		
		for (int row = 0; row< picture.length;row++){ //列
			//统计每一行，如果有多个元素 就删除了
			int[] count = new int[26];
			
			for (int col = 0; col < picture[row].length;col++){//行
				count[picture[row][col]-'A']++;
			}
			
			//无关紧要的情况
			if(count['B'-'A'] > N){ 
				sum -= 1;
			}
		}
		
        return sum < 0 ? 0 : sum;
    }
	
	public static void main(String[] args) {
		SolutionDay05_502 day = new SolutionDay05_502();
		
	}
}

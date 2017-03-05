package com.daimens.algorithm.march;

public class SolutionDay05_502 {
	
	public int findBlackPixel(char[][] picture, int N) {
		int sum = 0;
		
		//先col
		boolean[] fitCol = new boolean[picture[0].length];
		for (int col = 0; col< picture[0].length;col++){
			//统计每一行，如果有多个元素 就删除了
			int[] count = new int[26];
			
			for (int row = 0; row < picture.length;row++){
				count[picture[row][col]-'A']++;
			}
			
			if(count['B'-'A'] == N){
				fitCol[col] = true;
				sum += N;
			}else{
				fitCol[col] = false;
			}
		}
		
		for (int row = 0; row< picture.length;row++){ //列
			//统计每一行，如果有多个元素 就删除了
			int[] count = new int[26];
			int[] add = new int[26];
			
			for (int col = 0; col < picture[row].length;col++){//行
				count[picture[row][col]-'A']++;
				if(!fitCol[col]){
					add[picture[row][col]-'A']++;
				}
			}
			
			//无关紧要的情况
			if(count['B'-'A'] != N){ 
				sum -= count['B'-'A'];
				sum += add['B'-'A'];
			}
		}
		
        return sum < 0 ? 0 : sum;
    }
	
	public static void main(String[] args) {
		SolutionDay05_502 day = new SolutionDay05_502();
		
	}
}

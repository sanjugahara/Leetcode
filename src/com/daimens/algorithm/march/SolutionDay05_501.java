package com.daimens.algorithm.march;

public class SolutionDay05_501 {
	
public int findLonelyPixel(char[][] picture) {
		
		int sum = 0;
		
		
		
		for (int i = 0; i< picture.length;i++){
			//统计每一行，如果有多个元素 就删除了
			int[] count = new int[26];
			
			for (int j = 0; j < picture[i].length;j++){
				count[picture[i][j]-'A']++;
			}
			
			if(count['B'-'A'] == 1){ 
				sum++;
			}
		}
		
		for (int i = 0; i< picture[0].length;i++){ //列
			//统计每一行，如果有多个元素 就删除了
			int[] count = new int[26];
			
			for (int j = 0; j < picture.length;j++){//行
				count[picture[j][i]-'A']++;
			}
			
			if(count['B'-'A'] > 1){ 
				sum -= count['B'-'A'];
			}
		}
		
        return sum < 0 ? 0 : sum;
    }
	
	public static void main(String[] args) {
		SolutionDay05_501 day = new SolutionDay05_501();
		
	}

}

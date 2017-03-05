package com.daimens.algorithm.march;

public class SolutionDay05_501 {
	
	public int findLonelyPixel(char[][] picture) {

		int sum = 0;
		for (int row = 0; row < picture.length; row++) {
			int[] count = new int[26];
			for (int col = 0; col < picture[row].length; col++) {
				count[picture[row][col] - 'A']++;
			}
			if (count['B' - 'A'] == 1) {
				sum++;
			}
		}

		for (int col = 0; col< picture[0].length; col++) {
			int[] count = new int[26];
			for (int row = 0; row < picture.length; row++) {
				count[picture[row][col] - 'A']++;
			}
			if (count['B' - 'A'] > 1) {
				sum -= count['B' - 'A'];
			}
		}

		return sum < 0 ? 0 : sum;
	}
	
	public static void main(String[] args) {
		SolutionDay05_501 day = new SolutionDay05_501();
		
	}

}

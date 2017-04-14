package com.daimens.algorithm.utils;

import java.util.Random;

/**
 * 
 * @author Demon Song
 *
 */
public abstract class RandomUtil {

	public static int[] randomSet(int min, int max, int n) {
		if (n > (max - min + 1) || max < min) {
			return null;
		}
		int[] result = new int[n];
		int count = 0;
		while (count < n) {
			int num = (int) (Math.random() * (max - min) + min);
			boolean flag = true;
			for (int j = 0; j < n; j++) {
				if (num == result[j]) {
					flag = false;
					break;
				}
			}
			if (flag) {
				result[count] = num;
				count++;
			}
		}
		return result;
	}
	
	public static Long[] randomLongArray(int length, int size){
		Long[] random = new Long[size];
		Random rand = new Random();
		for (int i = 0; i < size; i++){
			random[i] = (long) rand.nextInt((int)Math.pow(10, 9));
		}
		return random;
	}
}

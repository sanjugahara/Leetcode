package com.daimens.algorithm.november;

import java.util.HashMap;

/**
 * 
 * @author Demon Song
 * 217. Contains Duplicate
 * Given an array of integers, find if the array contains any duplicates. 
 * Your function should return true if any value appears at least twice in the array, 
 * and it should return false if every element is distinct.
 *
 */
public class SolutionDay23 {
	public boolean containsDuplicate(int[] nums){
		//����hashMapͳ�Ƹ���,һ����������2����ֱ�ӷ���
		HashMap<Integer, Integer> numsMap = new HashMap<Integer,Integer>();
		for (int i = 0 ; i < nums.length; i++){
			//�������һ����Ԫ��
			if(!numsMap.containsKey(nums[i])){
				int value =0;
				numsMap.put(nums[i], ++value);
			}
			else{ //������һ��Ԫ��
				return true;
			}
		}
		return false;
	}
}

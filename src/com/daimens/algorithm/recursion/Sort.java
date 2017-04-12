package com.daimens.algorithm.recursion;

import com.daimens.algorithm.utils.LoadData;

public class Sort {

	
	//尾递归
	public static void selectionSort(String[] elements){
		selectionSort(elements,0);
	}
	

	private static void selectionSort(String[] elements,int start){
		if (start <= elements.length-1){
			String tmp = elements[start];
			int index = -1;
			for (int i = start + 1; i < elements.length; i++){
				if (elements[i].compareTo(tmp) < 0){
					tmp = elements[i];
					index = i;
				}
			}
			if (index != -1){
				swap(elements, start, index);
			}
			selectionSort(elements, start + 1);
		}
	}
	
	private static void swap(String[] ele, int i, int j){
		String tmp = ele[i];
		ele[i] = ele[j];
		ele[j] = tmp;
	}
	
	public static boolean isSorted(String[] elements){
		
		for (int i = 1; i < elements.length; i++){
			if (elements[i].compareTo(elements[i-1]) < 0){
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		String[] arrays = LoadData.loadStringArray();
		System.out.println(isSorted(arrays));
		selectionSort(arrays);
		System.out.println(isSorted(arrays));
	}
		
}

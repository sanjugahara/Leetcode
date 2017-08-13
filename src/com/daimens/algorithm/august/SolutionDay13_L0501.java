package com.daimens.algorithm.august;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class SolutionDay13_L0501 {
	
	class Pair implements Comparable<Pair>{
		int id;
		int min;
		public Pair(int id, int min){
			this.id = id;
			this.min = min;
		}
		@Override
		public int compareTo(Pair that) {
			return this.min == that.min ? this.id - that.id : this.min - that.min;
		}
	}
	
	public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        Integer[] aux = arr.toArray(new Integer[0]);
        int index = binarySearch(aux, x);
        List<Integer> ans = new ArrayList<>();
        if (arr.size() == 0) return ans;
        Queue<Pair> queue = new PriorityQueue<>();
        queue.offer(new Pair(index, Math.abs(aux[index] - x)));
        for (int i = 1; i < k; ++i){
        	if (i + index < aux.length) queue.offer(new Pair(i + index, Math.abs(aux[index + i] - x)));
        	if (index - i >= 0) queue.offer(new Pair(index - i, Math.abs(aux[index - i] - x)));
        }
        for (int i = 0; i < k; ++i){
        	ans.add(aux[queue.poll().id]);
        }
        Collections.sort(ans);
        return ans;
//        if (aux[index] == x){ //find
//        	ans.add(x);
//        	Queue<Integer> queue = new PriorityQueue<>();
//            for (int i = 0; i < k - 1; ++i){
//            	if (index + i + 1 < aux.length){
//            		queue.offer(aux[index + i + 1]);
//            	}
//            }
//            
//            for (int i = 0; i < k - 1; ++i){
//            	if (index - i - 1>= 0) queue.offer(aux[index - i - 1]);
//            }
//            
//            for (int i = 0; i < k; ++i){
//            	ans.add(queue.poll());
//            }
//        	return ans;
//        }
//        else{ // not find
//        	int ll = x - aux[index];
//        	int rr = aux[index + 1] - x;
//        	int lf = -1;
//        	int rt = -1;
//        	if (ll < rr){
//        		ans.add(aux[index]);
//        		lf = index;
//        		rt = index;
//        	}
//        	else{
//        		ans.add(aux[index + 1]);
//        		lf = index + 1;
//        		rt = index + 1;
//        	}
//        	
//        	k = k - 1;
//        	lf --;
//        	rt ++;
//        	while (k --> 0){
//        		
//        	}
//        }
    }
	
	public int binarySearch(Integer[] arra, int x){
		int lf = 0, rt = arra.length - 1;
		while (lf < rt){
			int mid = lf + (rt - lf + 1) / 2;
			if (arra[mid] > x) rt = mid - 1;
			else lf = mid;
		}
		if (arra[lf] <= x) return lf;
		return 0;
	}
	
	public int binarySearch(int[] arra, int x){
		int lf = 0, rt = arra.length - 1;
		while (lf < rt){
			int mid = lf + (rt - lf + 1) / 2;
			if (arra[mid] > x) rt = mid - 1;
			else lf = mid;
		}
		if (arra[lf] <= x) return lf;
		return 0;
	}
	
	public static void main(String[] args) {
		SolutionDay13_L0501 day = new SolutionDay13_L0501();
		int[] arra = {0,0,1,2,3,3,4,7,7,8};
		System.out.println(day.binarySearch(arra, 5));
	}
}

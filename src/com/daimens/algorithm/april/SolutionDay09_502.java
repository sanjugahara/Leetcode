package com.daimens.algorithm.april;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SolutionDay09_502 {
	
//	public int nextGreaterElement(int n) {
//		
//		String ss = Integer.toString(n);
//		
//		PriorityQueue<Integer> queue = new PriorityQueue<>();
//		for (int i = 0; i < ss.length(); i++){
//			queue.add(ss.charAt(i)-'0');
//		}
//		
//		StringBuilder res = new StringBuilder();
//		for (int i = 0; i < ss.length(); i++){
//			res.append(queue.poll());
//		}
//		
//		
//		try {
//			int max = Integer.parseInt(res.reverse().toString());
//			
//			if (max == n){
//				return -1;
//			}
//			
//			// 置换最后两个元素
//			String ans = "";
//			String tmp = res.reverse().toString();
//			for (int i = 0; i < tmp.length() - 2; i++){
//				ans += tmp.charAt(i)-'0';
//			}
//			
//			ans += tmp.charAt(tmp.length()-1);
//			ans += tmp.charAt(tmp.length()-2);
//			
//			return Integer.parseInt(ans);
//		} catch (NumberFormatException e) {
//			return -1;
//		}
//    }
	
//	public int nextGreaterElement(int n) {
//		String num = Integer.toString(n);
//		
//		//如果是递减 那么return-1
//		
//		//else 从尾部开始搜索，符合递增的不去管他，遇到第一个递减的，对其交换元素
//		
//		int lf = -1;
//		int rt = -1;
//		for (int i = num.length() - 1; i >= 1; i--) {
//			int a1 = num.charAt(i)-'0';
//			int a2 = num.charAt(i-1)-'0';
//			
//			if (a2 < a1){
//				lf = i;
//				rt = i-1;
//				break;
//			}
//		}
//		
//		if (lf == -1 && rt == -1) return -1;
//		
//		try {
//			String ans = num.substring(0, rt) + num.substring(lf,lf+1) + num.substring(rt,rt+1) + num.substring(lf+1,num.length());
//			return Integer.parseInt(ans);
//		} catch (NumberFormatException e) {
//			return -1;
//		}
//	}
	
	public int nextGreaterElement(int n) {
		String num = Integer.toString(n);

		// 找到第一个递减的元素
		int index = -1;

		for (int i = num.length() - 1; i >= 1; i--) {
			if (num.charAt(i - 1) < num.charAt(i)) {
				index = i - 1; // 要置换的下标
				break;
			}

		}

		if (index == -1)
			return -1;

		int changeEle = num.charAt(index) - '0';

		int min = Integer.MAX_VALUE;
		int index2 = -1;
		for (int i = num.length() - 1; i >= index; i--) {
			if (num.charAt(i) - '0' > num.charAt(index) - '0') {
				min = Math.min(num.charAt(i) - '0', min);
				if (num.charAt(i) - '0' == min) {
					index2 = i;
				}
			}
		}

		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int i = index + 1; i < num.length(); i++) {
			// change
			if (index2 == i) {
				queue.add(changeEle);
			}
			else
				queue.add(num.charAt(i) - '0');
		}

		String ans = "";

		ans += num.substring(0, index);
		ans += min;

		while (!queue.isEmpty()) {
			ans += queue.poll();
		}

		try {
			return Integer.parseInt(ans);
		} catch (NumberFormatException e) {

			return -1;
		}
	}
	
	
	
	private boolean valid(int a1, int a2){
		String s1 = Integer.toString(a1);
		String s2 = Integer.toString(a2);
		
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		
		Arrays.sort(c1);
		Arrays.sort(c2);
		
		for (int i =0; i < c1.length; i++){
			if(c1[i] != c2[i])
				return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		SolutionDay09_502 day = new SolutionDay09_502();
		
		int n = 561296;
		day.nextGreaterElement(12443322);
	}

}

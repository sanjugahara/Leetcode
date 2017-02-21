package com.daimens.algorithm.february;

/**
 * 
 * @author Demon Song
 * 309.Best Time to Buy and Sell Stock with Cooldown
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like(ie,buy one and sell one
 * share of the stock multiple times) with the following restrictions:
 * You may not engage in multiple transactions at the same time(ie,you must sell the stock before you buy again).
 * After you sell your stock,you cannot buy stock on next day.(ie,cooldown 1 day)
 * Example :
 * prices = [1,2,3,0,2]
 * maxProfit = 3
 * transactions = [buy, cell, cooldown, buy, sell]
 *
 */
public class SolutionDay21_309 {
	
//	public int maxProfit(int[] prices) {
//		int maxProfit = 0;
//		
//		int fir = 0; //从0开始的下标，直接到数组的长度，但fir累加需放最后
//		int end = 0;
//		int len = prices.length;
//		
//		while (fir != len - 1 && prices[fir] > prices[fir + 1]) {
//			fir++; // 寻找开局最低点
//			end++;
//		}
//		
//		if(fir == len-1){
//			return maxProfit;
//		}
//		
//		while (fir < len){
//			while (end != len - 1 && prices[end] < prices[end + 1]) {
//				end++;
//			}
//			maxProfit += prices[end]-prices[fir];
//			fir = end + 2;
//		}
//        return maxProfit;
//    }
	
	public int maxProfit(int[] prices) {
		int sell = 0,prev_sell = 0,buy = Integer.MIN_VALUE,prev_buy;
		for (int price : prices){
			prev_buy = buy;
			buy = Math.max(prev_sell- price, prev_buy);
			prev_sell = sell;
	        sell = Math.max(prev_buy + price, prev_sell);
		}
		return sell;
	}
	
	public static void main(String[] args) {
		SolutionDay21_309 day = new SolutionDay21_309();
		int[] prices = {1,2,3,0,2}; 
		day.maxProfit(prices);
	}

}

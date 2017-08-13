package com.daimens.algorithm.august;

public class SolutionDay13_L0503 {
	
	public int newInteger(int n) {
		return Integer.parseInt(Integer.toString(n, 9));
    }
	
	public static void main(String[] args) {
		SolutionDay13_L0503 day = new SolutionDay13_L0503();
		System.out.println(day.newInteger(9));
	}

}

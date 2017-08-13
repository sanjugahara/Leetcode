package com.daimens.algorithm.august;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SolutionDay12_B1000 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int t = 0; t < T; ++t){
			int P = in.nextInt();
			System.out.println(ss(P - 1));
		}
		in.close();
	}
	
	public static int ss(int x){
		Set<Integer> set = new HashSet<Integer>();
		set.add(1);
		set.add(x);
		for (int i = 2; i <= x / i; ++i){
			if (x % i == 0){
				set.add(i);
				set.add(x / i);
			}
		}
		return set.size();
	}
	
}



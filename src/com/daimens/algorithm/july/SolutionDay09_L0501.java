package com.daimens.algorithm.july;

public class SolutionDay09_L0501 {

	public String solveEquation(String equation) {
		String[] values = equation.split("=");
		values[0] = (values[0].charAt(0) != '-' ? "+" : "") + values[0];
		values[1] = (values[1].charAt(0) != '-' ? "+" : "") + values[1];
		values[0] = values[0].replace("+", " +").replace("-", " -");
		values[1] = values[1].replace("+", " +").replace("-", " -");

		long sumX = 0;
		long sum = 0;
		String[] nums = values[0].split("\\ ");
		for (int i = 0; i < nums.length; ++i) {
			String num = nums[i];
			if (num.isEmpty())
				continue;
			if (num.contains("x")) {
				int flag = num.substring(0, 1).equals("+") ? 1 : -1;
				sumX += (flag * Integer.parseInt(
						(num.substring(1, num.length() - 1)).isEmpty() ? "1" : (num.substring(1, num.length() - 1))));
			} else {
				int flag = num.substring(0, 1).equals("+") ? 1 : -1;
				sum += (flag * Integer.parseInt(num.substring(1, num.length())));
			}
		}

		nums = values[1].split("\\ ");
		for (int i = 0; i < nums.length; ++i) {
			String num = nums[i];
			if (num.isEmpty())
				continue;
			if (num.contains("x")) {
				int flag = num.substring(0, 1).equals("+") ? -1 : 1;
				sumX += (flag * Integer.parseInt(
						(num.substring(1, num.length() - 1)).isEmpty() ? "1" : (num.substring(1, num.length() - 1))));
			} else {
				int flag = num.substring(0, 1).equals("+") ? -1 : 1;
				sum += (flag * Integer.parseInt(num.substring(1, num.length())));
			}
		}

		if (sumX == 0 && sum == 0)
			return "Infinite solutions";
		if (sumX == 0 && sum != 0)
			return "No solution";
		return "x=" + (sum / (-sumX));
	}

	public static void main(String[] args) {
		SolutionDay09_L0501 day = new SolutionDay09_L0501();
		System.out.println(day.solveEquation("-x=-1"));
	}

}

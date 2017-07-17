package com.daimens.algorithm.july;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class SolutionDay09_L0502 {
	// n -> n - 1
	// 状态较少
	public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
		Map<String, Integer> mem = new HashMap<>();
		mem.put(listToStr(needs), 0);

		Queue<List<Integer>> queue = new LinkedList<>();
		queue.offer(needs);
		while (!queue.isEmpty()) {
			List<Integer> aux = queue.poll();
			for (List<Integer> spec : special) {
				boolean isValid = true;
				for (int i = 0; i < aux.size(); ++i) {
					if (spec.get(i) > aux.get(i))
						isValid = false;
				}
				if (isValid) {
					List<Integer> remain = new ArrayList<>();
					for (int i = 0; i < aux.size(); ++i) {
						remain.add(aux.get(i) - spec.get(i));
					}
					mem.put(listToStr(remain), Math.min(mem.get(listToStr(aux)) + spec.get(spec.size() - 1),
							mem.containsKey(listToStr(remain)) ? mem.get(listToStr(remain)) : 1 << 30));
					queue.offer(remain);
				}
			}
		}

		int minValue = 1 << 30;
		for (String key : mem.keySet()) {
			int[] remain = strToList(key);
			int sum = mem.get(key);
			for (int i = 0; i < remain.length; ++i) {
				sum += (remain[i] * price.get(i));
			}
			minValue = Math.min(minValue, sum);
		}
		return minValue;
	}

	private String listToStr(List<Integer> needs) {
		StringBuilder sb = new StringBuilder();
		for (Integer need : needs) {
			sb.append(need + "+");
		}
		return sb.toString().substring(0, sb.length() - 1);
	}

	private int[] strToList(String str) {
		String[] nums = str.split("\\+");
		int[] needs = new int[nums.length];
		for (int i = 0; i < nums.length; ++i) {
			needs[i] = Integer.parseInt(nums[i]);
		}
		return needs;
	}

	public static void main(String[] args) {
		SolutionDay09_L0502 day = new SolutionDay09_L0502();

	}

}

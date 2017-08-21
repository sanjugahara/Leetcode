package com.daimens.algorithm.august;

import java.util.HashSet;
import java.util.Set;

public class SolutionDay21_L0663 {
	
	public boolean checkEqualTree(TreeNode root) {
		if (root.left == null && root.right == null) return false;
		list = new HashSet<>();
        int sum = find(root);
		if (sum % 2 != 0) return false;
		int key = sum / 2;
		return list.contains(key);
	}
	
	Set<Integer> list;
	public int find(TreeNode root){
		if (root == null) return 0;
		int left = find(root.left);
		int right = find(root.right);
		list.add(left + right + root.val);
		return left + right + root.val;
	}
	
	public static void main(String[] args) {
		SolutionDay21_L0663 day = new SolutionDay21_L0663();
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(10);
		root.right = new TreeNode(10);
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(3);
		System.out.println(day.checkEqualTree(root));
	}

}

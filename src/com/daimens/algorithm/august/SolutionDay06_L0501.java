package com.daimens.algorithm.august;

public class SolutionDay06_L0501 {
	
	public TreeNode constructMaximumBinaryTree(int[] nums) {
		TreeNode root = null;
		if (nums.length == 0) return root;
		root = build(root, nums, 0, nums.length - 1);
		return root;
	}
	
		public TreeNode build(TreeNode root, int[] nums, int i, int j){
			if (i == j) return new TreeNode(nums[i]);
			if (i > j) return null;
			int index = findMax(nums, i, j);
			root = new TreeNode(nums[index]);
			if (index - 1 >= 0)
				root.left = build(root, nums, i, index - 1);
			if (index + 1 <= nums.length - 1)
				root.right = build(root, nums, index + 1, j);
			return root;
		}
	
	
	public int findMax(int[] nums, int i, int j){
		int max = nums[i];
		int id = i;
		for (int index = i; index <= j; ++index){
			if (max < nums[index]){
				max = nums[index];
				id = index;
			}
		}
		return id;
	}
	
	public static void main(String[] args) {
		SolutionDay06_L0501 day = new SolutionDay06_L0501();
		int[] nums = {3,2,1,6,0,5};
		day.constructMaximumBinaryTree(nums);
	}
}

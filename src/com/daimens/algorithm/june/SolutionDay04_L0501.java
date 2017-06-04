package com.daimens.algorithm.june;

public class SolutionDay04_L0501 {

	public String tree2str(TreeNode t) {
		return dfs(t);
	}
	
	private String dfs(TreeNode t){
		if (t == null) return "";
		String ans = t.val+"";
		if (t.left != null){
			ans += "(" + dfs(t.left) + ")";
		}
		
		if (t.left == null && t.right != null){
			ans += "()";
		}
		
		if (t.right != null){
			ans += "(" + dfs(t.right) + ")";
		}
		else{
			ans += "()";
		}
		return ans;
	}

	public static void main(String[] args) {
		SolutionDay04_L0501 day = new SolutionDay04_L0501();
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
package com.daimens.algorithm.june;

public class SolutionDay18_L0501 {
	
	public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1){
        	TreeNode r = new TreeNode(v);
        	r.left = root;
        	return r;
        }
        dfs(root,v,d,1);
        return root;
    }
	
	private void dfs(TreeNode root, int v, int d, int layer) {
		if (root == null)
			return;
		
		if (layer == d - 1){
			TreeNode left = root.left;
			TreeNode right = root.right;
			root.left = new TreeNode(v);
			root.right = new TreeNode(v);
			root.left.left = left;
			root.right.right = right;
		}
		dfs(root.left, v, d, layer + 1);
		dfs(root.right, v, d, layer + 1);
	}
	
	public static void main(String[] args) {
		SolutionDay18_L0501 day = new SolutionDay18_L0501();
	}

}

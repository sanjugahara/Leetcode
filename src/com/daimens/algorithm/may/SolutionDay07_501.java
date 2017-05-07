package com.daimens.algorithm.may;

import java.util.ArrayList;
import java.util.List;

public class SolutionDay07_501 {
	
	public boolean isSubtree(TreeNode s, TreeNode t) {
		if (s == null && t == null) return true;
		
		if (s == null) return false;
		
		if (s.val != t.val){
			
		}
		
		List<TreeNode> t1 = new ArrayList<>();
		List<TreeNode> t2 = new ArrayList<>();
		
		dfs(t, t1);
		inorder(t, t2);
		
		List<TreeNode> s1 = new ArrayList<>();
		List<TreeNode> s2 = new ArrayList<>();
		
		dfs(s, s1);
		inorder(s, s2);
		
		if (t1.size() == s1.size()){
			for (int i = 0; i < t1.size(); i++){
				if (t1.get(i).val != s1.get(i).val) return false;
			}
			
			for (int i = 0; i < t1.size(); i++){
				if (t2.get(i).val != s2.get(i).val) return false;
			}
			
			return true;
		}
		
		return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
	
	private void dfs(TreeNode root, List<TreeNode> list){
		if (root == null) return;
		list.add(root);
		dfs(root.left, list);
		dfs(root.right, list);
	}
	
	private void inorder(TreeNode root, List<TreeNode> list){
		if (root == null) return;
		dfs(root.left, list);
		list.add(root);
		dfs(root.right, list);
	}
	
	
	public static void main(String[] args) {
		SolutionDay07_501 day = new SolutionDay07_501();
		TreeNode s = new TreeNode(3);
		s.left = new TreeNode(4);
		s.right = new TreeNode(5);
		
		s.left.left = new TreeNode(1);
		s.left.right = new TreeNode(2);
		
		TreeNode t = new TreeNode(4);
		t.left = new TreeNode(1);
		t.right = new TreeNode(2);
		
		day.isSubtree(s, t);
		
	}

}

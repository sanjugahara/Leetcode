package com.daimens.algorithm.march;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class SolutionDay26_502 {
	
	public List<Integer> boundaryOfBinaryTree(TreeNode root) {
		if(root == null) return new ArrayList<>();
		
		
		LinkedList<Integer> left = new LinkedList<>();
		left.add(root.val);
		
		if(root.left != null){
			leftDfs(root.left, left);
			left.remove(left.size()-1);
		}
		
		//leaf node
		leaveDfs(root,left);
		//left.remove(left.size()-1);
		
		LinkedList<Integer> right = new LinkedList<>();
		rightDfs(root.right, right);
		
		for(int i =1; i < right.size();i++){
			left.add(right.get(i));
		}
		
        return left;
    }
	
	private void leftDfs(TreeNode root,LinkedList<Integer> left){
		Stack<TreeNode> stack = new Stack<>();
		TreeNode curr = root;
		
		while(!stack.isEmpty() || curr != null){
			
			if(curr != null){
				stack.push(curr);
				left.add(curr.val);
				curr = curr.left;
			}else{
				TreeNode node = stack.pop();
				curr = node.right;
				if(curr == null){
					break;
				}
			}
		}
		
	}
	
	private void leaveDfs(TreeNode root,LinkedList<Integer> leaves){
		if(root == null) return;
		
		if(root.left == null && root.right == null){
			leaves.add(root.val);
		}
		leaveDfs(root.left,leaves);
		leaveDfs(root.right, leaves);
	}
	
	private void rightDfs(TreeNode root,LinkedList<Integer> right){
		
		Stack<TreeNode> stack = new Stack<>();
		TreeNode curr = root;
		
		while(!stack.isEmpty() || curr != null){
			
			if(curr != null){
				stack.push(curr);
				right.addFirst(curr.val);
				curr = curr.right;
			}else{
				TreeNode node = stack.pop();
				curr = node.left;
				if(curr == null){
					break;
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		SolutionDay26_502 day = new SolutionDay26_502();
		
		TreeNode root = new TreeNode(1);
		
		day.boundaryOfBinaryTree(root);
	}

}

package com.daimens.algorithm.march;

/**
 * 
 * @author DemonSong
 * 116.Populating Next Right Pointers in Each Node
 * Given a binary tree
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
 * Note:
 * 1. You may only use constant extra space.
 * 2. You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 * For example,
 * Given the following perfect binary tree,
 *        1
 *       /  \
 *      2    3
 *     / \  / \
 *    4  5  6  7   
 *
 * After calling your function, the tree should look like:
 *         1 -> NULL
 *       /  \
 *      2 -> 3 -> NULL
 *     / \  / \
 *    4->5->6->7 -> NULL
 *
 */
public class SolutionDay01_116 {
//	public void connect(TreeLinkNode root) {
//        if(root == null) return;
//        
//        if(root.left !=null){
//        	root.left.next = root.right;
//        	if(root.next != null){
//        		root.right.next = root.next.left;
//        	}
//        }
//        connect(root.left);
//        connect(root.right);
//    }
	
	public void connect(TreeLinkNode root){
		TreeLinkNode level_start = root;
		while (level_start != null){ //这个循环条件
			TreeLinkNode cur = level_start;
			while (cur != null){
				if(cur.left != null) cur.left.next = cur.right;
				if(cur.right!= null && cur.next !=null) cur.right.next = cur.next.left;
				cur = cur.next;
			}
			level_start = level_start.left;
		}
	}
}

class TreeLinkNode {
   int val;
   TreeLinkNode left, right, next;
   TreeLinkNode(int x) { val = x; }
}
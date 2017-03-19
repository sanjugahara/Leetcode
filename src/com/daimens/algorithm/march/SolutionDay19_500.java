package com.daimens.algorithm.march;

/**
 * 
 * @author DemonSong
 * 543.Diameter of Bianry Tree
 * Given a binary tree,you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of
 * the longest path between ant two nodes in a tree. This path may or may not pass through the root.
 * 
 * Example:
 * Given a binary tree
 *          1
 *         / \
 *        2   3
 *       / \     
 *      4   5  
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3]
 * Note:
 * The length of path between two nodes is represented by the number of edges between them.
 */
public class SolutionDay19_500 {

//	public int diameterOfBinaryTree(TreeNode root) {
//		
//		if(root == null) return 0;
//		
//		
//		
//		return maxTreeDeep(root, 0);
//    }
//	
//	
//	private int maxTreeDeep(TreeNode root,int deep){
//		
//		if(root == null) return 0;
//		
//		if(root.left != null && root.left.left == null && root.left.right== null){
//			return deep+1;
//		}
//		
//		else{
//			
//		}
//		
//		
//		if(root.right != null && root.right.left == null && root.right.right == null){
//			return deep+1;
//		}
//		
//		return Math.max(maxTreeDeep(root.left,++deep), maxTreeDeep(root.right,++deep));
//		
//		
//	}
	
	public int diameterOfBinaryTree(TreeNode root) {
		
		if(root == null) return 0;
		
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		
		return Math.max(Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)), 2 + left + right);
    }
	
	private int maxDepth(TreeNode root){
		
		if(root == null) return 0;
		
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		
		return left > right ? 1+left : 1+right;
	}
	
	public static void main(String[] args) {
		SolutionDay19_500 day = new SolutionDay19_500();
	}
}

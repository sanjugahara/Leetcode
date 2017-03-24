package com.daimens.algorithm.march;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author DemonSong
 * 513.Find Bottom Left Tree Value
 * Given a binary tree,find the leftmost value in the last row of the tree.
 * 
 * Example 1:
 * Input:
 *
 *    2
 *   / \
 *  1   3
 * 
 * Output:
 * 1
 * 
 * Example 2:
 * Input:
 * 
 *       1
 *      / \
 *     2   3
 *    /   / \
 *   4   5   6
 *      /
 *     7
 *
 * Output:
 * 7
 * 
 * Note: You may assume the tree (i.e, the given root node) is not NULL
 * 
 *
 */
public class SolutionDay24_513 {
	public int findBottomLeftValue(TreeNode root) {
		
		List<Integer> ans = new ArrayList<>();
		dfs(root, 0, ans);
        return ans.get(ans.size()-1);
    }
	
	
	private void dfs(TreeNode root, int layer, List<Integer> lists){
		
		if(root == null) return;
		
		if(layer == lists.size()){
			lists.add(root.val);
		}
		
		dfs(root.left, layer+1, lists);	
		dfs(root.right, layer+1, lists);
		
	}
}

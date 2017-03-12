package com.daimens.algorithm.march;

public class SolutionDay12_502 {

	
	public TreeNode str2tree(String s) {
		if(s.length() == 0) return null;

		StringBuilder leftStr = new StringBuilder();
		StringBuilder rightStr = new StringBuilder();
		StringBuilder value = new StringBuilder();
		
		for (int i = 0; i < s.length(); i++){
			
			if(s.charAt(i)== '('){
				break;
			}
			value.append(s.charAt(i));
		}
		
		int rootValue = Integer.parseInt(value.toString());
		TreeNode root = new TreeNode(rootValue);

		//解析 left
		
		int f = 0,l = 0;
		int isLeft = 0;
		for (int i = 0; i < s.length(); i++){
			if(s.charAt(i) == '('){
				if(isLeft == 0)
					f = i;
				isLeft ++;
			}
			
			if(s.charAt(i) == ')'){
				isLeft --;
				if(isLeft == 0)
					l = i;
				
			}
		}
		
		for (int i = f+1; i < l; i++){
			rightStr.append(s.charAt(i));
		}
		
		String tmp = s.substring(0, f);
		f = 0;
		l = 0;
		isLeft = 0;
		for (int i = 0; i < tmp.length(); i++){
			if(tmp.charAt(i) == '('){
				if(isLeft == 0)
					f = i;
				isLeft ++;
			}
			
			if(tmp.charAt(i) == ')'){
				isLeft --;
				if(isLeft == 0)
					l = i;
				
			}
		}
		
		for (int i = f+1; i < l; i++){
			leftStr.append(s.charAt(i));
		}
		
		if(leftStr.toString().length() == 0){
			leftStr = rightStr;
			rightStr = null;
		}
		
		if(leftStr.length() == 0){
			leftStr = null;
		}
		
		if(leftStr == null && rightStr == null) return root;
		
		//有了 treenode  leftStr 和RightStr
		if(leftStr != null){
			root.left = str2tree(leftStr.toString());
		}
		
		if(rightStr != null){
			root.right = str2tree(rightStr.toString());
		}
		
		return root;
    }
	
	
	
	public static void main(String[] args) {
		SolutionDay12_502 day = new SolutionDay12_502();
		String s = "4(2(3)(1))";
		day.str2tree(s);
	}
}

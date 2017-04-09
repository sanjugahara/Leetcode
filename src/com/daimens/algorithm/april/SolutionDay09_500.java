package com.daimens.algorithm.april;

public class SolutionDay09_500 {
	
	public String reverseWords(String s) {
	
		if (s.length() == 0) return s;
		
		String[] words = s.split(" ");
		
		StringBuilder ans = new StringBuilder();
		for (int i = 0; i < words.length; i++){
			StringBuilder tmp = new StringBuilder(words[i]);
			ans.append(tmp.reverse().toString()+" ");
		}
		
        return ans.toString().substring(0,ans.toString().length()-1);
    }
	
	public static void main(String[] args) {
		SolutionDay09_500 day = new SolutionDay09_500();
	}

}

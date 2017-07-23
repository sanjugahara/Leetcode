package com.daimens.algorithm.july;

import java.util.ArrayList;
import java.util.List;

public class SolutionDay23_L0503 {
	
	class TrieNode{
		TrieNode[] children = new TrieNode[32];
		String str;
		int times;
	}
	
	public TrieNode add(TrieNode root, String str, int times){
		char[] cs = str.toCharArray();
		if (root == null) root = new TrieNode();
		TrieNode cur = root;
		for (char c : cs){
			int pos = 0;
			if (c == ' ') pos = 27;
			else pos = c - 'a';
			if (cur.children[pos] == null) cur.children[pos] = new TrieNode();
			cur = cur.children[pos];
		}
		if (cur.str != null) cur.times += times;
		else cur.times = times;
		cur.str = str;
		return root;
	}
	
	public List<String> search(TrieNode root, String prefix){
		List<String> ans = new ArrayList<>();
		if (root == null) return ans;
		TrieNode cur = root;
		for (char c : prefix.toCharArray()){
			int pos = 0;
			if (c == ' ') pos = 27;
			else pos = c - 'a';
			if (cur.children[pos] == null){
				break;
			}
			if (cur.children[pos] != null){
				cur = cur.children[pos];
				if (cur.str != null) ans.add(cur.str);
			}
		}
		return ans;
	}
	
	TrieNode root;
	public String replaceWords(List<String> dict, String sentence) {
		root = new TrieNode();
		for (String word : dict){
			root = add(root, word, 0);
		}
		String[] replace = sentence.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < replace.length; ++i){
			List<String> lists = search(root, replace[i]);
			if (lists.isEmpty()){
				sb.append(replace[i] + " ");
			}
			else{
				int minLen = 1 << 30;
				String ans = "";
				for (String c : lists){
					if (c.length() < minLen){
						ans = c;
						minLen = c.length();
					}
				}
				sb.append(ans + " ");
			}
		}
		
        return sb.toString().substring(0, sb.length() - 1);
    }
	
	public static void main(String[] args) {
		SolutionDay23_L0503 day = new SolutionDay23_L0503();
	}
}

package com.daimens.algorithm.february;

import java.util.ArrayList;
import java.util.List;

public class SolutionDay26_502 {
	public String findLongestWord(String s, List<String> d) {
		String res = "";
		
		for (String tmp : d){
			int pos = 0;
			for (int i = 0; i < tmp.length();i++){
				while(pos < s.length()-1 && tmp.charAt(i) != s.charAt(pos)){
					pos ++;
				}
			}
			
			if(pos < s.length() - 1 || (pos == s.length()-1 && tmp.charAt(tmp.length()-1) == s.charAt(pos))){
				if(res.length() > tmp.length()){
					res = tmp;
					pos = 0;
				}
				
				if(res.length() == tmp.length()){
					int res_len = res.length();
					int tmp_len = tmp.length();
					
					int res_bigger = 0;
					int tmp_bigger = 0;
					
					for (int i = 0; i < res_len; i++){
						res_bigger += res.charAt(i) * Math.pow(10, res_len-i);
						tmp_bigger += tmp.charAt(i) * Math.pow(10, tmp_len-i);
					}
					
					if(tmp_bigger <= res_bigger){
						res = tmp;
						pos = 0;
					}
				}
			}
		}
		
        return res;
    }
	
	public static void main(String[] args) {
		SolutionDay26_502 day = new SolutionDay26_502();
		String s = "aewfafwafjlwajflwajflwafj";
		List<String> d = new ArrayList<>();
		String tmp = "apple";
		d.add(tmp);
		tmp = "ewaf";
		d.add(tmp);
		System.out.println(day.findLongestWord(s, d));
	}
}

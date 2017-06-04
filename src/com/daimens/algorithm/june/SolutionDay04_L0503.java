package com.daimens.algorithm.june;

import java.util.ArrayList;
import java.util.List;

public class SolutionDay04_L0503 {
	
	public boolean isValid(String code) {
		if (code.length() == 0) return false;
		char[] cs = code.toCharArray();
		if (cs[0] != '<') return false;
		
		String beginTag = parseBeginTag(code);
		String endTag = parseEndTag(code);
		
		if (!isTagValid(beginTag, endTag)) return false;
		
		//检测内容
		int i = beginTag.length() + 2, j = code.length() - 1 - endTag.length() - 2;
		String checkCode = code.substring(i, j+1);
		
		//检测cddata
		String pp = parseCDDATA(checkCode);
		
		//find 所有Tag
		List<String> tags = new ArrayList<>();
		char[] checks = checkCode.toCharArray();
		
		StringBuilder sb = new StringBuilder();
		for (int k = 0; k < checks.length; k++){
			if (checks[k] == '<'){
				sb = new StringBuilder();
			}else if (checks[k] != '>'){
				sb.append(checks[k]);
			}
			else if (checks[k] == '>'){
				tags.add(sb.toString());
			}
		}
		
		if (tags.size() % 2 != 0) return false;
		
		int lf = 0, rt = tags.size()-1;
		while (lf <= rt){
			if (!isTagValid(tags.get(lf), tags.get(rt))) return false;
			lf ++;
			rt --;
		}
		
		return true;
    }
	
	private String parseCDDATA(String code){
		String start = "<![CDATA[";
		String end = "]]>";
		
		int i = code.indexOf(start);
		int j = code.indexOf(end);
		
		if (i == -1 || j == -1) return code;
		
		
		
		return "";
	}
	
	
	private String parseBeginTag(String code){
		int i = 0;
		while (i < code.length() && code.charAt(i) != '>') i++;
		if (i == code.length()) return "";
		return code.substring(1, i);
	}
	
	private String parseEndTag(String code){
		int j = code.length()-1;
		while (j >= 0 && code.charAt(j) != '<') j--;
		if (j == -1) return "";
		return code.substring(j+1,code.length()-1);
	}
	
	private boolean isTagValid(String beginTag,String endTag){
		if (beginTag.isEmpty() || endTag.isEmpty()) return false;
		
		for (int i = 0; i < beginTag.length(); i++){
			if (Character.isLowerCase(beginTag.charAt(i))) return false;
		}
		
		char[] ends = endTag.toCharArray();
		char[] begins = beginTag.toCharArray();
		if (ends[0] != '/' && beginTag.length() != endTag.length()-1) return false;
		
		for (int i = 1; i < endTag.length(); i++){
			if (Character.isLowerCase(ends[i]) && ends[i] != begins[i]) return false;
		}
		return true;
	}
	

	public static void main(String[] args) {
		SolutionDay04_L0503 day = new SolutionDay04_L0503();
		String code = "<DIV>This is the first line <![CDATA[<div>]]></DIV>";
		day.isValid(code);
	}
}

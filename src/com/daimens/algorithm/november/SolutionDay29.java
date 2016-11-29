package com.daimens.algorithm.november;

/**
 * 
 * @author Demon Song
 * 459. Repeated SubString Pattern
 * Given a non-empty string check if it can be constructed 
 * by taking a substring of it and appending multiple copies 
 * of the substring together. 
 * You may assume the given string consists of lowercase 
 * English letters only and its length will not exceed 10000.
 * Example:
 * Input: "abab"
 * Output: True
 * Explanation: It's the substring "ab" twice.
 * Example 2:
 * Input: "aba"
 * Output: False
 * Example 3:
 * Input: "abcabcabcabc"
 * Output: True
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 *
 */
public class SolutionDay29 {
	public boolean repeatedSubstringPattern(String str){
		//���� ��һ���͵ڶ�����������Ѱ �������Ժ���Ӵ�  �� ֱ�ӵڶ����͵�����
		
		//subString of it and appending multiple copies of the substring together
		//so "ababc" is false
		//������hashMap��¼�� ����Ҫ
		
		//������ ������� ��֮�Ƚ�
		if (str == null || str.length() ==0) return false;
		
		for (int j = 1; j < str.length()/2+1; j++){
			String subStr = str.substring(0, j);
			if(str.length() % j ==0){ //�ܹ������� �ǻ�����ϣ����
				StringBuilder sb = new StringBuilder();
				for (int i = 0 ; i < str.length() /j; i++){
					sb.append(subStr);
				}
				if(sb.toString().equals(str)){
					return true;
				}
			}
//			for (int i = j; i < str.length()-j; i +=(j+1) ){
//				String tmp = str.substring(i,i+j);
//				if(!tmp.equals(subStr)){
//					break; //���Ȳ���˵��false
//				}
//			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		SolutionDay29 day29 = new SolutionDay29();
		day29.repeatedSubstringPattern("abab");
	}

}

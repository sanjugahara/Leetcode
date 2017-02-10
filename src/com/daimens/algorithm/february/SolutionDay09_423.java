package com.daimens.algorithm.february;

/**
 * 
 * @author Demon Song
 * 423.Reconstruct Original Digits from English
 * Given a non-empty string containing an out-of-order English representation of digits 0-9,
 * output the digits in ascending order.
 * Note:
 * 1. Input contains only lowercase English letters.
 * 2. Input is guaranteed to be valid and can be transformed to its original digits.That means
 * invalid inputs such as "abc" or "zerone" are not permitted.
 * 3. Input length is less than 50,000
 * 
 * Example 1:
 * Input: "owoztneoer"
 * Output: "012"
 * Example 2:
 * Input: "fviefuro"
 * Output: "45"
 *
 */
public class SolutionDay09_423 {
	
	public String originalDigits(String s){
		//找0元素,统计每个字符出现的频次么？貌似可以的
		int[] bucket = new int[26];
		for (char temp : s.toCharArray()){
			bucket[temp-'a']++;
		}
		
		int[] digits = new int[10];
		
		//定义查找顺序 0 6 8 7 5 9 4 3 2 1
		char[] series = {'z','x','g','s','v','i','u','r','w','e'};
		String[] keys = {"zero","six","eight","seven","five","nine","four","three","two","one"};
		int[] nums = {0,6,8,7,5,9,4,3,2,1};
		
		for (int i = 0; i < digits.length; i++){
			char selectId = series[i];
			if(bucket[selectId - 'a'] != 0){
				int frequency = bucket[selectId - 'a'];
				for (char tmp : keys[i].toCharArray()){
					bucket[tmp - 'a'] -= frequency;
				}
				digits[nums[i]] += frequency;
			}
		}
		
//		//0 - zero
//		if(bucket['z'-'a'] != 0){
//			int frequency = bucket['z'-'a'];
//			bucket['z'-'a'] -= frequency;
//			bucket['e'-'a'] -= frequency;
//			bucket['r'-'a'] -= frequency;
//			bucket['o'-'a'] -= frequency;
//			digits[0] += frequency;
//		}
//		//6 - six
//		if(bucket['x'-'a'] != 0){
//			int frequency = bucket['x'-'a'];
//			bucket['s'-'a'] -= frequency;
//			bucket['i'-'a'] -= frequency;
//			bucket['x'-'a'] -= frequency;
//			digits[6] += frequency;
//		}
//		//8 - eight
//		if(bucket['g'-'a'] != 0){
//			int frequency = bucket['g'-'a'];//跟顺序有关
//			bucket['e'-'a'] -= frequency;
//			bucket['i'-'a'] -= frequency;
//			bucket['g'-'a'] -= frequency;
//			bucket['h'-'a'] -= frequency;
//			bucket['t'-'a'] -= frequency;
//			digits[8] += frequency;
//		}
//		//7 - seven
//		if(bucket['s'-'a'] != 0){
//			int frequency = bucket['s'-'a'];//跟顺序有关
//			bucket['s'-'a'] -= frequency;
//			bucket['e'-'a'] -= frequency;
//			bucket['v'-'a'] -= frequency;
//			bucket['e'-'a'] -= frequency;
//			bucket['n'-'a'] -= frequency;
//			digits[7] += frequency;
//		}		
//		//5 - seven
//		if(bucket['v'-'a'] != 0){
//			int frequency = bucket['v'-'a'];//跟顺序有关
//			bucket['f'-'a'] -= frequency;
//			bucket['i'-'a'] -= frequency;
//			bucket['v'-'a'] -= frequency;
//			bucket['e'-'a'] -= frequency;
//			digits[5] += frequency;
//		}	
//		//9 - nine
//		if(bucket['i'-'a'] != 0){
//			int frequency = bucket['i'-'a'];//跟顺序有关
//			bucket['n'-'a'] -= frequency;
//			bucket['i'-'a'] -= frequency;
//			bucket['n'-'a'] -= frequency;
//			bucket['e'-'a'] -= frequency;
//			digits[9] += frequency;
//		}
//		//4 - four
//		if(bucket['u'-'a'] != 0){
//			int frequency = bucket['u'-'a'];//跟顺序有关
//			bucket['f'-'a'] -= frequency;
//			bucket['o'-'a'] -= frequency;
//			bucket['u'-'a'] -= frequency;
//			bucket['r'-'a'] -= frequency;
//			digits[4] += frequency;
//		}
//		//3 - three
//		if(bucket['r'-'a'] != 0){
//			int frequency = bucket['r'-'a'];//跟顺序有关
//			bucket['t'-'a'] -= frequency;
//			bucket['h'-'a'] -= frequency;
//			bucket['r'-'a'] -= frequency;
//			bucket['e'-'a'] -= frequency;
//			bucket['e'-'a'] -= frequency;
//			digits[3] += frequency;
//		}
//		//2 - two
//		if(bucket['w'-'a'] != 0){
//			int frequency = bucket['w'-'a'];//跟顺序有关
//			bucket['t'-'a'] -= frequency;
//			bucket['w'-'a'] -= frequency;
//			bucket['o'-'a'] -= frequency;
//			digits[2] += frequency;
//		}		
//		//1 - one
//		if(bucket['e'-'a'] != 0){
//			int frequency = bucket['e'-'a'];//跟顺序有关
//			bucket['o'-'a'] -= frequency;
//			bucket['n'-'a'] -= frequency;
//			bucket['e'-'a'] -= frequency;
//			digits[1] += frequency;
//		}
		
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < digits.length; i++){
			int frequency = digits[i];
			for (int j = 0; j < frequency; j ++){
				res.append(i);
			}
		}
		return res.toString();
	}
	
}

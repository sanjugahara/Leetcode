package com.daimens.algorithm.may;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author DemonSong
 * 
 *         126.Word Ladder II
 * 
 *         Given two words (beginWord and endWord), and a dictionary's word
 *         list, find all shortest transformation sequence(s) from beginWord to
 *         endWord, such that:
 * 
 *         Only one letter can be changed at a time Each transformed word must
 *         exist in the word list. Note that beginWord is not a transformed
 *         word. For example,
 * 
 *         Given: beginWord = "hit" endWord = "cog" wordList =
 *         ["hot","dot","dog","lot","log","cog"] Return [
 *         ["hit","hot","dot","dog","cog"], ["hit","hot","lot","log","cog"] ]
 *         Note: Return an empty list if there is no such transformation
 *         sequence. All words have the same length. All words contain only
 *         lowercase alphabetic characters. You may assume no duplicates in the
 *         word list. You may assume beginWord and endWord are non-empty and are
 *         not the same. UPDATE (2017/1/20): The wordList parameter had been
 *         changed to a list of strings (instead of a set of strings). Please
 *         reload the code definition to get the latest changes.
 *
 */
public class SolutionDay16_L0126 {
	
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		Map<String, List<String>> map = new HashMap<>();
		
		map.put(beginWord, new ArrayList<>());
		for (String word : wordList){
			map.put(word, new ArrayList<>());
		}
		for (String key : map.keySet()){
			List<String> container = map.get(key);
			for (String word : wordList){
				if (oneDiff(key, word)){
					container.add(word);
				}
			}
			map.put(key, container);
		}
		Set<String> visited = new HashSet<>();
		List<List<String>> ans = helper(map, beginWord, endWord,visited);
		return ans;
    }
	
	private List<List<String>> helper(Map<String, List<String>> map,String beginWord, String endWord, Set<String> visited){
		List<List<String>> ans = new ArrayList<>();
		if (!map.containsKey(endWord) || visited.contains(beginWord)) return null;
		visited.add(beginWord);
		for (String find : map.get(beginWord)){
			if (find.equals(endWord)){
				List<String> container = new ArrayList<>();
				container.add(beginWord);
				container.add(find);
				ans.add(container);
				visited.remove(beginWord);
				return ans;
			}
		}
		
		Map<Integer, List<List<List<String>>>> memory = new HashMap<>();
		int min = Integer.MAX_VALUE;
		for (String find : map.get(beginWord)){
			List<List<String>> tmp = helper(map, find, endWord,visited);
			if (tmp == null) continue;
			min = Math.min(min, tmp.get(0).size());
			if (memory.containsKey(tmp.get(0).size())){
				List<List<List<String>>> container = memory.get(tmp.get(0).size());
				container.add(tmp);
				memory.put(tmp.get(0).size(), container);
			}else{
				List<List<List<String>>> container = new ArrayList<>();
				container.add(tmp);
				memory.put(tmp.get(0).size(), container);
			}
		}
		
		if (min == Integer.MIN_VALUE) return ans;
		
		for (List<List<String>> tmp : memory.get(min)){
			for (int i = 0; i < tmp.size(); i++){
				List<String> container = new ArrayList<>();
				container.add(beginWord);
				container.addAll(tmp.get(i));
				ans.add(container);
			}
		}
		visited.remove(beginWord);
		return ans;
	}
	
	
	private boolean oneDiff(String a, String b){
		if (a.equals(b)) return false;
		char[] aa = a.toCharArray();
		char[] bb = b.toCharArray();
		
		int oneDiff = 0;
		for (int i = 0; i < aa.length; i++){
			if (aa[i] != bb[i]){
				oneDiff ++;
				if (oneDiff >= 2) return false;
			}
		}
		return true;
	}
	
//	public List<List<String>> findLadders(String start, String end, List<String> dict) {
//	    // hash set for both ends
//	    Set<String> set1 = new HashSet<String>();
//	    Set<String> set2 = new HashSet<String>();
//	    
//	    // initial words in both ends
//	    set1.add(start);
//	    set2.add(end);
//	    
//	    // we use a map to help construct the final result
//	    Map<String, List<String>> map = new HashMap<String, List<String>>();
//	    
//	    // build the map
//	    helper(dict, set1, set2, map, false);
//	    
//	    List<List<String>> res = new ArrayList<List<String>>();
//	    List<String> sol = new ArrayList<String>(Arrays.asList(start));
//	    
//	    // recursively build the final result
//	    generateList(start, end, map, sol, res);
//	    
//	    return res;
//	  }
//	  
//	  boolean helper(List<String> dict, Set<String> set1, Set<String> set2, Map<String, List<String>> map, boolean flip) {
//	    if (set1.isEmpty()) {
//	      return false;
//	    }
//	    
//	    if (set1.size() > set2.size()) {
//	      return helper(dict, set2, set1, map, !flip);
//	    }
//	    
//	    // remove words on current both ends from the dict
//	    dict.removeAll(set1);
//	    dict.removeAll(set2);
//	    
//	    // as we only need the shortest paths
//	    // we use a boolean value help early termination
//	    boolean done = false;
//	    
//	    // set for the next level
//	    Set<String> set = new HashSet<String>();
//	    
//	    // for each string in end 1
//	    for (String str : set1) {
//	      for (int i = 0; i < str.length(); i++) {
//	        char[] chars = str.toCharArray();
//	        
//	        // change one character for every position
//	        for (char ch = 'a'; ch <= 'z'; ch++) {
//	          chars[i] = ch;
//	          
//	          String word = new String(chars);
//	          
//	          // make sure we construct the tree in the correct direction
//	          String key = flip ? word : str;
//	          String val = flip ? str : word;
//	              
//	          List<String> list = map.containsKey(key) ? map.get(key) : new ArrayList<String>();
//	              
//	          if (set2.contains(word)) {
//	            done = true;
//	            
//	            list.add(val);
//	            map.put(key, list);
//	          } 
//	          
//	          if (!done && dict.contains(word)) {
//	            set.add(word);
//	            
//	            list.add(val);
//	            map.put(key, list);
//	          }
//	        }
//	      }
//	    }
//	    
//	    // early terminate if done is true
//	    return done || helper(dict, set2, set, map, !flip);
//	  }
//	  
//	  void generateList(String start, String end, Map<String, List<String>> map, List<String> sol, List<List<String>> res) {
//	    if (start.equals(end)) {
//	      res.add(new ArrayList<String>(sol));
//	      return;
//	    }
//	    
//	    // need this check in case the diff between start and end happens to be one
//	    // e.g "a", "c", {"a", "b", "c"}
//	    if (!map.containsKey(start)) {
//	      return;
//	    }
//	    
//	    for (String word : map.get(start)) {
//	      sol.add(word);
//	      generateList(word, end, map, sol, res);
//	      sol.remove(sol.size() - 1);
//	    }
//	  }
	
	public static void main(String[] args) {
		SolutionDay16_L0126 day = new SolutionDay16_L0126();
		String beginWord = "hit";
		String endWord = "cog";
		String[] words = {"hot","dot","dog","lot","log","cog"};
		List<String> wordList = Arrays.asList(words);
		day.findLadders(beginWord, endWord, wordList);
		//System.out.println(day.oneDiff("aaa", "aaa"));
		
		List<List<String>> ans = new ArrayList<>();
		System.out.println(ans.isEmpty());
	}
}

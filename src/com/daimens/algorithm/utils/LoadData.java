package com.daimens.algorithm.utils;

import java.util.ArrayList;
import java.util.List;

public abstract class LoadData {
	
	
	
	public static String[] loadStringArray(){
		List<String> res = new ArrayList<>();
        try {
            In in = new In("./data/1000words.txt");
            while (!in.isEmpty()) {
                String s = in.readLine();
                res.add(s);
            }
        }
        catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        
        return res.toArray(new String[0]);
	}
	
	public static void main(String[] args) {
		String[] ans = loadStringArray();
	}
}

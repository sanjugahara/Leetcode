package com.daimens.algorithm.march;

import java.awt.image.RescaleOp;

public class SolutionDay26_501 {
	
	public String complexNumberMultiply(String a, String b) {
		
		int a1 = 0;
		int a2 = 0;
		
		StringBuilder a1Builder = new StringBuilder();
		StringBuilder a2Builder = new StringBuilder();
		for(int i = 0; i < a.length(); i++){
			if(a.charAt(i) != '+')
				a1Builder.append(a.charAt(i));
			if(a.charAt(i) == '+'){
				a2Builder.append(a.substring(i+1,a.length()-1));
				break;
			}
		}
		
		a1 = Integer.parseInt(a1Builder.toString());
		a2 = Integer.parseInt(a2Builder.toString());
		
		
		int b1 = 0;
		int b2 = 0;
		
		StringBuilder b1Builder = new StringBuilder();
		StringBuilder b2Builder = new StringBuilder();
		for(int i = 0; i < b.length(); i++){
			if(b.charAt(i) != '+')
				b1Builder.append(b.charAt(i));
			
			if(b.charAt(i) == '+'){
				b2Builder.append(b.substring(i+1,b.length()-1));
				break;
			}
		}
		
		b1 = Integer.parseInt(b1Builder.toString());
		b2 = Integer.parseInt(b2Builder.toString());
		
		StringBuilder res = new StringBuilder();
		
		int c1 = a1*b1 - a2*b2;
		int c2 = a1 * b2 + a2 * b1;
		
		res.append(String.valueOf(c1));
		res.append("+");
		res.append(String.valueOf(c2));
		res.append("i");
		
        return res.toString();
    }
	
	public static void main(String[] args) {
		SolutionDay26_501 day = new SolutionDay26_501();
		
		String a = "1+1i";
		String b = "1+1i";
		
		day.complexNumberMultiply(a, b);
		
	}

}

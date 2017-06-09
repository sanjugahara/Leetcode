package com.daimens.algorithm.june;

/**
 * 
 * @author DemonSong
 * 
 *         65. Valid Number
 * 
 *         Validate if a given string is numeric.
 * 
 *         Some examples: "0" => true " 0.1 " => true "abc" => false "1 a" =>
 *         false "2e10" => true Note: It is intended for the problem statement
 *         to be ambiguous. You should gather all requirements up front before
 *         implementing one.
 *
 */
public class SolutionDay09_L0065 {
	
	public boolean isNumber(String s) {
		if (s.isEmpty()) return false;
		int n = s.length();
		char[] c = s.toCharArray();
		
		boolean isValid = true;
		
		int i = 0;

		while (i < n && c[i] == ' ') i++;
		if (i == n || !(c[i] == '+' || c[i] == '-' || c[i] == '.' || Character.isDigit(c[i]))) return false;
		
		//'+' or '-'
		if (c[i] == '+' || c[i] == '-'){
			i++;
		}
		
		if (c[i] == '.'){
			i++;

			if (i < n && c[i] == 'e') return false;
            
            if (i < n && Character.isDigit(c[i])){
                while (i < n && Character.isDigit(c[i])) i++;

			    if (i < n && c[i] == 'e'){
        			i++;
                    while (i < n && c[i] == ' ') i++;
                    if (i == n || ! (Character.isDigit(c[i]) || c[i] == '+' || c[i] == '-')) return false;
                    
                    if (i < n && (c[i] == '+' || c[i] == '-')) i++;
                    if (i == n) return false;
                    
                    while (i < n && Character.isDigit(c[i])) i++;
        			while (i < n && c[i] == ' ') i++;
        			if (i == n) return true;
        		    return false;
		        }
		        
		        while (i < n && c[i] == ' ') i++;
			    if (i == n) return true;
            }
            return false;
		}
		
		if (i == n || !Character.isDigit(c[i])) return false;
		
		long num = 0;
		while (i < n && Character.isDigit(c[i])){
			num = 10 * num + c[i++] - '0';
		}
		
		while (i < n && c[i] == ' ') i++;
		if (i == n) return isValid;
		
		
		if (!(c[i] == '.' || c[i] == 'e')) return false;
		
		if (!Character.isDigit(c[i-1]) && c[i] == '.') return false;
		if (!Character.isDigit(c[i-1]) && c[i] == 'e') return false;
		
		if (c[i] == '.'){
			i++;

			if (i < n && c[i] == 'e'){
        			i++;
                    while (i < n && c[i] == ' ') i++;
                    if (i == n || ! (Character.isDigit(c[i]) || c[i] == '+' || c[i] == '-')) return false;
                    
                    if (i < n && (c[i] == '+' || c[i] == '-')) i++;
                    if (i == n) return false;
                    
                    while (i < n && Character.isDigit(c[i])) i++;
        			while (i < n && c[i] == ' ') i++;
        			if (i == n) return true;
        		    return false;
		    }	
            
            if (i < n && Character.isDigit(c[i])){
                while (i < n && Character.isDigit(c[i])) i++;

			    if (i < n && c[i] == 'e'){
        			i++;
                    while (i < n && c[i] == ' ') i++;
                    if (i == n || ! (Character.isDigit(c[i]) || c[i] == '+' || c[i] == '-')) return false;
                    
                    if (i < n && (c[i] == '+' || c[i] == '-')) i++;
                    if (i == n) return false;
                    
                    while (i < n && Character.isDigit(c[i])) i++;
        			while (i < n && c[i] == ' ') i++;
        			if (i == n) return true;
        		    return false;
		        }
		        
		        while (i < n && c[i] == ' ') i++;
			    if (i == n) return true;
			    return false;
            }
            
    		while (i < n && c[i] == ' ') i++;
			if (i == n) return true;
            return false;			
		}
		
		if (i < n && c[i] == 'e'){
			i++;
            while (i < n && c[i] == ' ') i++;
            if (i == n || ! (Character.isDigit(c[i]) || c[i] == '+' || c[i] == '-')) return false;
            
            if (i < n && (c[i] == '+' || c[i] == '-')) i++;
            if (i == n) return false;
            
            while (i < n && Character.isDigit(c[i])) i++;
			while (i < n && c[i] == ' ') i++;
			if (i == n) return true;
		    return false;
		}
		
		return isValid;
    }
}

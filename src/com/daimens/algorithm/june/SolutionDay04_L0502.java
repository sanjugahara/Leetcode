package com.daimens.algorithm.june;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionDay04_L0502 {
	
	class File{
		String fileName;
		String content;
		File(){
			
		}
	}
	
	public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < paths.length; i++){
        	String[] tmp = paths[i].split(" ");
        	String root = tmp[0];
        	for (int j = 1; j < tmp.length; j++){
        		File file = parseFile(tmp[j]);
            	map.computeIfAbsent(file.content, a -> new ArrayList<>()).add(root + "/" + file.fileName);
        	}
        }
        
        List<List<String>> ans = new ArrayList<>();
        for (List<String> value : map.values()){
        	if (value.size() > 1) ans.add(value);
        }
        
        return ans;
    }
	
	
	private File parseFile(String path){
		File file = new File();
		int index = -1;
		for (int i = 0; i < path.length(); i++){
			if (path.charAt(i) == '('){
				index = i;
				break;
			}
		}
		file.fileName = path.substring(0, index);
		file.content = path.substring(index + 1, path.length() - 1);
		return file;
	}
	
	
	public static void main(String[] args) {
		SolutionDay04_L0502 day = new SolutionDay04_L0502();
		String[] paths = {"root/a 1.txt(abcd) 2.txt(efsfgh)","root/c 3.txt(abdfcd)","root/c/d 4.txt(efggdfh)"};
		day.findDuplicate(paths);
	}

}

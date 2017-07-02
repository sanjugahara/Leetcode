package com.daimens.algorithm.july;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LogSystem {
	
	class Log{
		String year;
		String month;
		String day;
		String hour;
		String minute;
		String second;
		int id;
	}
	
	List<Log> logs;
	public LogSystem() {
		logs = new ArrayList<>();
    }
    
    public void put(int id, String timestamp) {
        Log log = new Log();
        log.id = id;
        String[] times = timestamp.split(":");
        log.year = times[0];
        log.month = times[0] + times[1];
        log.day = times[0] + times[1] + times[2];
        log.hour = times[0] + times[1] + times[2] + times[3];
        log.minute = times[0] + times[1] + times[2] + times[3] + times[4];
        log.second = times[0] + times[1] + times[2] + times[3] + times[4] + times[5];
        logs.add(log);
    }
    
    public List<Integer> retrieve(String s, String e, String gra) {
        String[] ss = s.split(":");
        String[] es = e.split(":");
        StringBuilder stcmp = new StringBuilder();
        StringBuilder etcmp = new StringBuilder();
        List<Integer> ans = new ArrayList<>();
        if (gra.equals("Year")){
        	stcmp.append(ss[0]);
        	etcmp.append(es[0]);
        	Collections.sort(logs, new Comparator<Log>(){
				@Override
				public int compare(Log o1, Log o2) {
					return o1.year.compareTo(o2.year);
				}
        	});
        	
        	for (int i = 0; i < logs.size(); ++i){
        		if (logs.get(i).year.compareTo(stcmp.toString()) >= 0 && logs.get(i).year.compareTo(etcmp.toString()) <= 0){
        			ans.add(logs.get(i).id);
        		}
        	}
        }
        if (gra.equals("Month")){
        	stcmp.append(ss[0] + ss[1]);
        	etcmp.append(es[0] + es[1]);
        	Collections.sort(logs, new Comparator<Log>(){
				@Override
				public int compare(Log o1, Log o2) {
					return o1.month.compareTo(o2.month);
				}
        	});
        	
        	for (int i = 0; i < logs.size(); ++i){
        		if (logs.get(i).month.compareTo(stcmp.toString()) >= 0 && logs.get(i).month.compareTo(etcmp.toString()) <= 0){
        			ans.add(logs.get(i).id);
        		}
        	}
        }
        if (gra.equals("Day")){
        	stcmp.append(ss[0] + ss[1] + ss[2]);
        	etcmp.append(es[0] + es[1] + es[2]);
        	Collections.sort(logs, new Comparator<Log>(){
				@Override
				public int compare(Log o1, Log o2) {
					return o1.day.compareTo(o2.day);
				}
        	});
        	
        	for (int i = 0; i < logs.size(); ++i){
        		if (logs.get(i).day.compareTo(stcmp.toString()) >= 0 && logs.get(i).day.compareTo(etcmp.toString()) <= 0){
        			ans.add(logs.get(i).id);
        		}
        	}
        }
        if (gra.equals("Hour")){
        	stcmp.append(ss[0] + ss[1] + ss[2] + ss[3]);
        	etcmp.append(es[0] + es[1] + es[2] + es[3]);
        	Collections.sort(logs, new Comparator<Log>(){
				@Override
				public int compare(Log o1, Log o2) {
					return o1.hour.compareTo(o2.hour);
				}
        	});
        	
        	for (int i = 0; i < logs.size(); ++i){
        		if (logs.get(i).hour.compareTo(stcmp.toString()) >= 0 && logs.get(i).hour.compareTo(etcmp.toString()) <= 0){
        			ans.add(logs.get(i).id);
        		}
        	}
        }
        if (gra.equals("Minute")){
        	stcmp.append(ss[0] + ss[1] + ss[2] + ss[3] + ss[4]);
        	etcmp.append(es[0] + es[1] + es[2] + es[3] + es[4]);
        	Collections.sort(logs, new Comparator<Log>(){
				@Override
				public int compare(Log o1, Log o2) {
					return o1.minute.compareTo(o2.minute);
				}
        	});
        	
        	for (int i = 0; i < logs.size(); ++i){
        		if (logs.get(i).minute.compareTo(stcmp.toString()) >= 0 && logs.get(i).minute.compareTo(etcmp.toString()) <= 0){
        			ans.add(logs.get(i).id);
        		}
        	}
        }
        if (gra.equals("Second")){
        	stcmp.append(ss[0] + ss[1] + ss[2] + ss[3] + ss[4] + ss[5]);
        	etcmp.append(es[0] + es[1] + es[2] + es[3] + es[4] + es[5]);
        	Collections.sort(logs, new Comparator<Log>(){
				@Override
				public int compare(Log o1, Log o2) {
					return o1.second.compareTo(o2.second);
				}
        	});
        	
        	for (int i = 0; i < logs.size(); ++i){
        		if (logs.get(i).second.compareTo(stcmp.toString()) >= 0 && logs.get(i).second.compareTo(etcmp.toString()) <= 0){
        			ans.add(logs.get(i).id);
        		}
        	}
        }
    	return ans;
    }
	
	
	public static void main(String[] args) {
		LogSystem day = new LogSystem();
	}
}

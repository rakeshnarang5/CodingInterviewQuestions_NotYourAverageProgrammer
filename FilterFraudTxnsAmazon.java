package com.airtelbank.upiswitch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class LogEntry implements Comparable<LogEntry>{
    private int count;
    private String id;
    public LogEntry(int count, String id){
        this.count=count;
        this.id=id;
    }
   @Override public int compareTo(LogEntry o){
       return Integer.compare(this.count, o.count);
   }
}

public class tets {
	
	 public static List<String> processLogs(List<String> logs, int threshold) {
	        Map<String, Integer> userTransactionCountMap = new HashMap<>();
	        for(String txn : logs){
	            String[] str = txn.split(" ");
	            if(userTransactionCountMap.containsKey(str[0])){
	                int count = userTransactionCountMap.get(str[0]);
	                count++;
	                userTransactionCountMap.put(str[0],count);
	            }else{
	                userTransactionCountMap.put(str[0],1);
	            }
	        }
	        Map<String,LogEntry> logEntryMap = new TreeMap<>();
	        for(String key : userTransactionCountMap.keySet()){
	            if(userTransactionCountMap.get(key) >= threshold){
	                logEntryMap.put(key, new LogEntry(userTransactionCountMap.get(key), key));
	            }
	        }
	        List<String> result = new ArrayList<>();
	        logEntryMap.forEach( (k,v)->{
	        	result.add(k);
	        });
	        return result;
	    }

}

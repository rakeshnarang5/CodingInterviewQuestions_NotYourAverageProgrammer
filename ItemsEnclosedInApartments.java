package com.airtelbank.upiswitch;

import java.util.ArrayList;
import java.util.List;

public class test2 {

	public static void main(String[] args) {
		List<Integer> startIndices = new ArrayList<Integer>();
		startIndices.add(1);
//		startIndices.add(1);
//		startIndices.add(1);
//		startIndices.add(1);
		List<Integer> endIndices = new ArrayList<Integer>();
		endIndices.add(3);
//		endIndices.add(5);
//		endIndices.add(6);
//		endIndices.add(7);
		System.out.println(numberOfItems("*|*|", startIndices,endIndices));
	}

	public static List<Integer> numberOfItems(String s, List<Integer> startIndices, List<Integer> endIndices) {
		List<Integer> result = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		for(Integer num : startIndices) {
			if(num < min) {
				min=num;
			}
		}
		int max = Integer.MIN_VALUE;
		for(Integer num : endIndices) {
			if(num > max) {
				max=num;
			}
		}
		int[] itemsArray = new int[(max-min) + 1];
		int[] tempItemsArray = new int[(max-min) + 1];
		int processedTillIdx = 0;
		for (int i = 0; i < startIndices.size(); i++) {
			int startIdx = startIndices.get(i)-1;
			int items = itemsArray[startIdx];
			int tempItems = tempItemsArray[startIdx];
			if(processedTillIdx > 0) {
				startIdx=processedTillIdx+1;
				 items = itemsArray[processedTillIdx];
				 tempItems = tempItemsArray[processedTillIdx]; 
			}
			int endIdx = endIndices.get(i)-1;
			boolean firstPipeEncountered = false;
			if(items>0) {
				firstPipeEncountered=true;
			}
			for (int j = startIdx; j <= endIdx; j++) {
				if (firstPipeEncountered) {
					if (s.charAt(j) == '*') {
						tempItems++;
					}else if(s.charAt(j)=='|') {
						items+=tempItems;
						tempItems=0;
					}
				} else {
					if (s.charAt(j) == '|')
						firstPipeEncountered = true;
				}
				itemsArray[j]=items;
				tempItemsArray[j]=tempItems;
			}
			processedTillIdx=endIdx;
			result.add(items);
		}
		return result;
	}

}

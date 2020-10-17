package main;

import java.util.ArrayList;
import java.util.List;

public class TrappingRainWaterAmazon {

	public static void main(String[] args) {
		System.out.println("TC1: 0,5,0 ||  : " + (trap(new int[] {0,5,0}) == 0));
		
		System.out.println("TC1: 0,1,0,1 ||  : " + (trap(new int[] {0,1,0,1}) == 1));
		
		System.out.println("TC1: 0,5,0,3,0,5 ||  : " + (trap(new int[] {0,5,0,3,0,5}) == 12));
	
		System.out.println("TC1: 0,5,0,2 ||  : " + (trap(new int[] {0,5,0,2}) == 2));
		
		System.out.println("TC1: 0,5,0,2,0,3 ||  : " + (trap(new int[] {0,5,0,2,0,3}) == 7));
		
		System.out.println("TC1: 0,5,0,2,0,3,0,2 ||  : " + (trap(new int[] {0,5,0,2,0,3,0,2}) == 9));
		
		System.out.println("TC1: 0,5,0,2,0,3,0,2,0,1 ||  : " + (trap(new int[] {0,5,0,2,0,3,0,2,0,1}) == 10));

	}

	public static int trap(int[] height) {
		if(height.length == 0)
			return 0;
		int actualWaterStored = 0;
		int maxHeightEncountered = 0;
		int potentialWaterStored = 0;
		int lastMaxHeightIdx = 0;
		for(int i = 0 ; i < height.length ; i++) {
			int currentHeight = height[i];
			if(maxHeightEncountered == 0) {
				if(currentHeight > 0) {
					maxHeightEncountered = currentHeight;
					lastMaxHeightIdx=i;
				}
			}else {
				if(currentHeight >= maxHeightEncountered) {
					actualWaterStored += potentialWaterStored;
					potentialWaterStored=0;
					maxHeightEncountered=currentHeight;
					lastMaxHeightIdx=i;
				}else {
					potentialWaterStored += (maxHeightEncountered-currentHeight);
				}
			}
		}
		if(lastMaxHeightIdx != height.length-1) {
			int zerosEncountered = 0;
			potentialWaterStored=0;
			int localMaxima = 0;
			int localMaximaIdx = 0;
			List<Integer> list = new ArrayList<>();
			for(int i = lastMaxHeightIdx+1; i < height.length ; i++) {
				int currentHeight = height[i];
				if(currentHeight==0) {
					zerosEncountered++;
				}else if(list.isEmpty()) {
					potentialWaterStored+= (zerosEncountered*currentHeight);
					localMaxima=currentHeight;
					localMaximaIdx = i;
					list.add(currentHeight);
				}else if(currentHeight >= localMaxima) {
					potentialWaterStored=0;
					potentialWaterStored+= (zerosEncountered*currentHeight);
					localMaxima=currentHeight;
					localMaximaIdx = i;
					for(int j = list.size()-1; j>=0;j--) {
						potentialWaterStored += (currentHeight-list.get(j));
					}
				}else {
					for(int j = i-1 ; j >= localMaximaIdx+1 ; j--) {
						potentialWaterStored+= (currentHeight - height[j]);
					}
				}
			}
			actualWaterStored+=potentialWaterStored;
		}
		return actualWaterStored;
	}

}

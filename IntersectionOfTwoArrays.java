package com.airtelbank.upiswitch.kafka.configs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
	public int[] intersect(int[] nums1, int[] nums2) {
		/*
		 * if any of the input arrays are empty then there can't be an intersection
		 * therefore we return an empty array
		 */
		if (nums1.length == 0 || nums2.length == 0) {
			return new int[0];
		}
		/*
		 * we will use two maps to reduce time complexity num1Map will have frequency
		 * map of nums1 array
		 */
		Map<Integer, Integer> num1Map = new HashMap<>();
		// num2Map will have frequency map of nums2 array
		Map<Integer, Integer> num2Map = new HashMap<>();
		// fill frequences for nums1
		// O(n)
		fillMapWithFrequencies(nums1, num1Map);
		// fill frequences for nums2
		// O(m)
		fillMapWithFrequencies(nums2, num2Map);
		/*
		 * we use a list to store intersection array because we don't know how many
		 * elements would intersect thus we need a dynamic array
		 */
		List<Integer> intersection = new ArrayList<>();
		/*
		 * we will iterate over the map whose size is lesser so to reduce the number of
		 * lookups if nums1 is smaller, we will hit the if block else nums2 is smaller
		 * and we will hit the else block
		 */
		if (nums1.length <= nums2.length) {
			fillIntersectionIteratingOverMap(num1Map, num2Map, intersection);
		} else {
			fillIntersectionIteratingOverMap(num2Map, num1Map, intersection);
		}
		// declare a result array of size list
		int[] result = new int[intersection.size()];
		// fill it with elements of list
		for (int i = 0; i < intersection.size(); i++) {
			result[i] = intersection.get(i);
		}
		// return result
		return result;
	}

	/*
	 * this method finds intersection and fills intersection list time complexity of
	 * this operation is O(n) or O(m) depending on which of m or n is smaller if n
	 * is smaller -> O(n) if m is smaller -> O(m)
	 */
	private void fillIntersectionIteratingOverMap(Map<Integer, Integer> itrMap, Map<Integer, Integer> lookupMap,
			List<Integer> intersection) {
		/*
		 * itrMap -> map on which we will iterate lookupMap -> the larger map which we
		 * will use for lookup
		 */
		// we iterate over keys of itrMap
		for (Integer key : itrMap.keySet()) {
			// if lookup map contains that key, we have hit case
			if (lookupMap.containsKey(key)) {
				// we get count of key in itrMap
				int n1 = itrMap.get(key);
				// we get count of key in lookupMap
				int n2 = lookupMap.get(key);
				// we will fill intersection list with min(n1,n2) times key
				/*
				 * e.g. let's say key is 5 in itrMap -> count is 2 in lookupMap -> count is 5
				 * then intersection will have 5, 2 times list.add(5) list.add(5) we add two
				 * times
				 */
				if (n1 >= n2) {
					for (int i = 0; i < n2; i++) {
						intersection.add(key);
					}
				} else {
					for (int i = 0; i < n1; i++) {
						intersection.add(key);
					}
				}
			}
		}
	}

	// time complexity is O(n)
	private void fillMapWithFrequencies(int[] nums, Map<Integer, Integer> map) {
		for (Integer num : nums) {
			/*
			 * if map already has a number, we increment it's ocurrence count
			 */
			if (map.containsKey(num)) {
				int val = map.get(num);
				val++;
				map.put(num, val);
			} else {
				/*
				 * if not already present, we add that number to map and initialize count by 1
				 */
				map.put(num, 1);
			}
		}
	}
}

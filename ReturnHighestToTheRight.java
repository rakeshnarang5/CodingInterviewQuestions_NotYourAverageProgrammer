package main;

public class ReturnHighestToTheRight {

	/*
	 * arr = [1,5,7,6,10,12,9,8,4]
	 * 
	 * return first greater number to the right of the element in the array if, no
	 * such number exists, then return -1
	 * 
	 * output = [5,7,10,10,12,-1,-1,-1,-1]
	 * 
	 * worst case complexity test
	 * 
	 * arr = [99,98,97,96......100]
	 * 
	 * currVal <- 99 currRetVal <- 100
	 * 
	 * 
	 * 
	 * O(n^2)
	 * 
	 */

	public static void main(String[] args) {
		// take input of size
		int size = 100000000;
		// define array
		int[] input = new int[size];
		// define maxNum
		int maxNum = size;
		// set values in the array
		for (int i = 0; i < size; i++) {
			input[i] = maxNum;
			maxNum--;
		}
		// set last value of arr to integer.max_value
		input[size - 1] = Integer.MAX_VALUE;
		// algorithm 1
		// O(n^2)
//		long startTime = System.currentTimeMillis();
//		int[] output = find(input);
//		long endTime = System.currentTimeMillis();
//		System.out.println("algo1 took: "+(endTime-startTime)/1000 + "seconds");
		// algorithm 2
		// worst case O(n)
		long startTime2 = System.currentTimeMillis();
		int[] output2 = find2(input);
		long endTime2 = System.currentTimeMillis();
		System.out.println("algo2 took: " + (endTime2 - startTime2) / 1000 + "seconds");

		System.out.println("rakesh");
	}

	private static int[] find2(int[] input) {
		// define output array
		int[] output = new int[input.length];
		// current val
		int currVal = 0;
		// value returned for the current value returned
		int currValRetVal = 0;
		// loop over the items
		for (int i = 0; i < input.length; i++) {
			// if element that is greater than currVal
			if (input[i] > currVal) {
				// run second loop
				for (int j = i + 1; j < input.length; j++) {
					if (input[j] > input[i]) {
						output[i] = input[j];
						// set element for which loop was run
						currVal = input[i];
						// value that was found to be greater for that element
						currValRetVal = input[j];
						break;
					}
				}
			} else {
				output[i] = currValRetVal;
			}
		}
		setZeroToMinusOne(output);
		return output;
	}

	// O(n^2) + O(n)
	private static int[] find(int[] input) {
		// O(n^2)
		int[] output = new int[input.length];
		for (int i = 0; i < input.length; i++) {
			for (int j = i + 1; j < input.length; j++) {
				if (input[j] > input[i]) {
					output[i] = input[j];
					break;
				}
			}
		}
		// O(n)
		setZeroToMinusOne(output);
		return output;
	}

	private static void setZeroToMinusOne(int[] output) {
		for (int i = 0; i < output.length; i++) {
			if (output[i] == 0)
				output[i] = -1;
		}
	}

}

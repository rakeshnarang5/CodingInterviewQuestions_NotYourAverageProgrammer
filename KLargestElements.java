package codingninjas;

import main.CodingUtils;

import java.util.PriorityQueue;

public class KLargestElements {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 2, 4, 511, 0, 323};
        int[] result = Klargest(arr, 2, arr.length);
        CodingUtils.printArray(result);
    }

    /*
    1. use heap data structure
    2. add all elements in array to heap
    3. remove n-k elements from heap
    4. return the remaining elements as result
     */
    public static int[] Klargest(int[] a, int k, int n) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i : a) {
            priorityQueue.add(i);
        }
        int[] result = new int[k];
        for (int i = 0; i < n - k; i++) {
            priorityQueue.remove();
        }
        int i = 0;
        while (!priorityQueue.isEmpty()) {
            result[i] = priorityQueue.remove();
            i++;
        }
        return result;
    }
}

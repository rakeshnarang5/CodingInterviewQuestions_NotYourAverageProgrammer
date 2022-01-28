package codingninjas;

import main.CodingUtils;

import java.util.PriorityQueue;

public class KLargestElements {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 2, 4, 511, 0, 323};
        int[] result = Klargest(arr, 2, arr.length);
        CodingUtils.printArray(result);
    }

    public static int[] Klargest(int[] a, int k, int n) {
        // Write your code here
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

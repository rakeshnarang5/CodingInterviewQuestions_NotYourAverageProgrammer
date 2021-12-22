public class Solution 
{
    public static void sort012(int[] arr)
    {
        //Write your code here
        int low = 0;
        int high = arr.length -1;
        int mid = 0;
        while(mid <= high){
            switch (arr[mid]) {
                case 0: 
                	swap(arr, low, mid);
                	low++;
                	mid++;
                	break;
                case 1:
                	mid++;
                	break;
                case 2:
                	swap(arr, mid, high);
                	high--;
                	break;
                default:
                	break;
            }
        }
    }
    
    public static void swap(int[] arr, int firstIdx, int secondIdx){
        int temp = arr[firstIdx];
        arr[firstIdx] = arr[secondIdx];
        arr[secondIdx] = temp;
    }
}

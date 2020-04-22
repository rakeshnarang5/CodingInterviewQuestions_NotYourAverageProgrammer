import java.util.*;

public class Main {
 public static void main(String[] args) {
  int[] arr = new int[] {
   1,
   2,
   3,
   -5,
   6,
   6,
   -6,
   8,
   8
  };
  int[] result = findSubArrayWithZeroSum(arr);
  if (null != result) {
   for (int i = 0; i < result.length; i++) {
    System.out.print(result[i] + " ");
   }
  }
 }

 public static int[] findSubArrayWithZeroSum(int[] arr) {
  Map < Integer, Integer > referenceMap = new HashMap < > ();
  int sum = 0;
  for (int i = 0; i < arr.length; i++) {
   sum += arr[i];
   if (referenceMap.containsKey(sum)) {
    int refIdx = referenceMap.get(sum);
    int[] result = new int[i - refIdx];
    for (int j = 0; j < result.length; j++) {
     result[j] = arr[++refIdx];
    }
    return result;
   } else {
    referenceMap.put(sum, i);
   }

  }
  return null;
 }
}

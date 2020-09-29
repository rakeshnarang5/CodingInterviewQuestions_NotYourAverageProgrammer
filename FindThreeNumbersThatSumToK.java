public static boolean find3NumbersThatSumToK (int[] A, int arr_size, int sum){
  for(int i = 0 ; i < arr_size-2 ; i++){
    Set<Integer> set = new HashSet<>();
    int curr_sum = sum - A[i];
    for(int j = i+1 ; j < arr_size ; j++){
      if(set.contains(curr_sum - A[j])) {
         System.out.printf("Triplet is %d, %d, %d", A[i], A[j], curr_sum - A[j]);
      }
      set.add(A[j]);
    }
  }
}

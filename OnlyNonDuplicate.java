// time complexity -> O(n)
// space complexity -> O(n) in the worst case
class Solution {
 public int singleNumber(int[] nums) {
  // we use a set to store value we've seen
  Set < Integer > set = new HashSet < > ();
  // traverse array once
  for (int i = 0; i < nums.length; i++) {
   // if we have already seen the number
   // remove from set
   if (set.contains(nums[i])) {
    set.remove(nums[i]);
   } else {
    // else add number to set
    set.add(nums[i]);
   }
  }
  // at the end, only that number will be in set
  // which occurs only once
  // and that's your answer
  if (set.size() >= 1) {
   for (Integer i: set) {
    return i;
   }
  }
  // in all other cases, return -1
  return -1;
 }
}

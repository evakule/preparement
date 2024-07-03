package org.leetcode.medium;


import java.util.HashMap;
import java.util.stream.Collectors;

//https://leetcode.com/problems/longest-consecutive-sequence/
public class LongestConsecutiveSequence128 {
  public static void main(String[] args) {
    LongestConsecutiveSequence128 l = new LongestConsecutiveSequence128();
    System.out.println(l.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    System.out.println(l.longestConsecutive(new int[]{9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6}));
    System.out.println(l.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    System.out.println(l.longestConsecutive(new int[]{9, 1, -3, 2, 4, 8, 3, -1, 6, -2, -4, 7})); //Out 8 // Expected 4
    System.out.println(l.longestConsecutive(new int[]{-7, -1, 3, -9, -4, 7, -3, 2, 4, 9, 4, -9, 8, -7, 5, -1, -7})); //Out 5 // Expected 4
  }

  // My solution
//  public int longestConsecutive(int[] nums) {
//    PriorityQueue<Integer> pq = getPqWithoutDuplicates(nums);
//    Integer last = pq.poll();
//
//    if (last == null) return 0;
//
//    int result = 1;
//    int biggest = result;
//
//    while (!pq.isEmpty()) {
//      Integer current = pq.poll();
//      if (current - last != 1) {
//        result = Math.max(biggest, result);
//        biggest = 0;
//      }
//      biggest++;
//      last = current;
//    }
//
//    return Math.max(biggest, result);
//  }

//  private PriorityQueue<Integer> getPqWithoutDuplicates(int[] nums) {
//    PriorityQueue<Integer> pq = new PriorityQueue<>();
//    Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
//    Arrays.stream(nums).sequential().forEach(set::add);
//    pq.addAll(set);
//    return pq;
//  }

  //Not my solution
  public int longestConsecutive(int[] nums) {
    HashMap<Integer, Boolean> map = new HashMap<>();

    for (int num : nums) {
      map.put(num, true);
    }
    int max = 0;
    for (int k : map.keySet()) {
      if (map.containsKey(k - 1)) {
        map.put(k, false);
      } else {
        int l = 1;
        while (map.containsKey(k + l) == true) {
          l++;
        }
        max = Math.max(max, l);
      }
    }
    return max;

  }

}

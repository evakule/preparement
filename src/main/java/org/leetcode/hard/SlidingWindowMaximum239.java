package org.leetcode.hard;

import java.util.*;

public class SlidingWindowMaximum239 {
  public static void main(String[] args) {
    SlidingWindowMaximum239 s = new SlidingWindowMaximum239();
//    System.out.println(Arrays.toString(s.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    System.out.println(Arrays.toString(s.maxSlidingWindow(new int[]{1, 2, 3, 4, 5, 6, 7}, 3)));

  }

  //not my solution
  public int[] maxSlidingWindow(int[] nums, int k) {
    if (nums.length == 1) return new int[]{nums[0]};

    List<Integer> result = new ArrayList<>();
    Deque<Integer> deque = new ArrayDeque<>(); // Deque to store indices

    // Add elements of the first window
    for (int i = 0; i < k; i++) {
      while (!deque.isEmpty() && nums[i] >= nums[deque.peekFirst()]) {
        deque.pollLast();
      }
      deque.offerLast(i);
    }
    result.add(nums[deque.peekFirst()]);

    // Slide the window and calculate maximums
    for (int i = k; i < nums.length; i++) {
      // Remove elements outside the current window
      while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
        deque.pollFirst();
      }
      // Remove elements smaller than the current element from the deque
      while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
        deque.pollLast();
      }
      deque.offerLast(i);
      result.add(nums[deque.peekFirst()]);
    }

    return result.stream().mapToInt(Integer::intValue).toArray();
  }
}

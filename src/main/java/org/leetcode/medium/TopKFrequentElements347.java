package org.leetcode.medium;

import java.util.*;

public class TopKFrequentElements347 {
  public static void main(String[] args) {
    int k = 2;
    int[] array = new int[]{1, 1, 1, 2, 2, 3};
    System.out.println(Arrays.toString(new TopKFrequentElements347().topKFrequent(array, k)));
  }

  public int[] topKFrequent(int[] array, int k) {
    int[] result = new int[k];
    Map<Integer, Integer> map = new HashMap<>();
    PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

    for (int j : array) {
      map.put(j, map.getOrDefault(j, 0) + 1);
    }

    pq.addAll(map.entrySet());

    for (int i = k - 1; i >= 0; i--) {
      result[i] = Objects.requireNonNull(pq.poll()).getKey();
    }

    return result;
  }
}

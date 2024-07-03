package org.leetcode.medium;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import java.util.Stack;

public class DailyTemperatures739 {
  public static void main(String[] args) {
    DailyTemperatures739 d = new DailyTemperatures739();
    System.out.println(Arrays.toString(d.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    System.out.println();
    Arrays.stream(d.dailyTemperatures(new int[]{30, 40, 50, 60})).boxed().forEach(System.out::print);
    System.out.println();
    Arrays.stream(d.dailyTemperatures(new int[]{30, 60, 90})).boxed().forEach(System.out::print);
    System.out.println();
    Arrays.stream(d.dailyTemperatures(new int[]{89, 62, 70, 58, 47, 47, 46, 76, 100, 70})).boxed().forEach(System.out::print);

  }

  public int[] dailyTemperatures(int[] temperatures) {
    if (temperatures.length < 2) return new int[]{0};
    int[] result = new int[temperatures.length];
    Stack<Map.Entry<Integer, Integer>> stack = new Stack<>();

    for (int i = temperatures.length - 1; i >= 0; i--) {
      Map.Entry<Integer, Integer> entry = new AbstractMap.SimpleEntry<>(i, temperatures[i]);
      if (stack.isEmpty()) {
        stack.push(entry);
      } else {
        while (!stack.isEmpty() && entry.getValue() >= stack.peek().getValue()) {
          stack.pop();
        }
        if (!stack.isEmpty()) {
          result[i] = stack.peek().getKey() - entry.getKey();
        }
        stack.push(entry);
      }


    }

    return result;
  }
}

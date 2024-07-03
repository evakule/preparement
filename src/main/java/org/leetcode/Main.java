package org.leetcode;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    IntStream.range(1, 100).filter(x -> x % 3 == 0 || x % 5 == 0).forEach(System.out::println);
  }
}
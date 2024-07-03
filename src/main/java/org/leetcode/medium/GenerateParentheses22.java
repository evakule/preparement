package org.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateParentheses22 {

  public static void main(String[] args) {
    GenerateParentheses22 g = new GenerateParentheses22();
    List<String> list = g.generateParenthesis(2);
    System.out.println(Arrays.toString(list.toArray()));

  }
  public List<String> generateParenthesis(int n) {
    ArrayList<String> list = new ArrayList<>();
    backtrack("", n, list, 0, 0);
    return list;
  }


    private void backtrack(String outputString, int max, List<String> list, int close, int open) {
    if (outputString.length() == max * 2) {
      list.add(outputString);
    }
    if (close < open ) backtrack(outputString + ")", max, list, close + 1, open);
    if (open < max) backtrack(outputString + "(", max, list, close, open + 1);
  }
}

package org.leetcode.easy;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ValidParentheses20 {
  public static void main(String[] args) {
    ValidParentheses20 v = new ValidParentheses20();
//    System.out.println(v.isValid("()"));
//    System.out.println(v.isValid("()[]{}"));
//    System.out.println(v.isValid("(("));
    System.out.println(v.isValid("){"));
  }

  public boolean isValid(String s) {
    if (s.length() == 1) return false;
    Stack<Character> stack = new Stack<>();
    char[] array = s.toCharArray();
    for (char c : array) {
      if (c == '(')
        stack.push(')');
      else if (c == '{')
        stack.push('}');
      else if (c == '[')
        stack.push(']');
      else if (stack.isEmpty() || stack.pop() != c) //
        return false;
    }
    return stack.isEmpty();

  }
}

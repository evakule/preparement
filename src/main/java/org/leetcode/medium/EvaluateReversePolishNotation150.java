package org.leetcode.medium;

import java.util.Stack;

public class EvaluateReversePolishNotation150 {
  public static void main(String[] args) {
    EvaluateReversePolishNotation150 e = new EvaluateReversePolishNotation150();
    String[] data = new String[]{"2", "1", "+", "3", "*"};
    String[] data1 = new String[]{"4", "13", "5", "/", "+"};
    String[] data2 = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
    System.out.println(e.evalRPN(data2));

  }

  public int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<>();
    for (String token : tokens) {
      if (token.equals("+") && !stack.isEmpty()) {
        stack.push(stack.pop() + stack.pop());
      } else if (token.equals("-") && !stack.isEmpty()) {
        int first = stack.pop();
        int second = stack.pop();
        int result = second - first;
        stack.push(result);
      } else if (token.equals("*") && !stack.isEmpty()) {
        stack.push(stack.pop() * stack.pop());
      } else if (token.equals("/") && !stack.isEmpty()) {
        int first = stack.pop();
        int second = stack.pop();
        int result = second / first;
        stack.push(result);
      } else {
        stack.push(Integer.valueOf(token));
      }
    }
    return stack.pop();
  }
}

package org.leetcode.medium;

import java.util.Stack;

public class DecodeString394 {
  public static void main(String[] args) {
    DecodeString394 d = new DecodeString394();
    String s = d.decodeString("3[a2[c]]");
    System.out.println(s);
  }


  //Not mine
  public String decodeString(String s) {
    Stack<Integer> multiply = new Stack<>();
    Stack<String> strings = new Stack<>();
    String baseString = "";
    int index = 0;

    while (index < s.length()) {
      if (Character.isDigit(s.charAt(index))) {
        int count = 0;
        while (Character.isDigit(s.charAt(index))) {
          count = 10 * count + (s.charAt(index) - '0');
          index += 1;
        }
        multiply.push(count);
      } else if (s.charAt(index) == '[') {
        strings.push(baseString);
        baseString = "";
        index += 1;
      } else if (s.charAt(index) == ']') {
        StringBuilder sb = new StringBuilder(strings.pop());
        int times = multiply.pop();
        for (int i = 0; i < times; i++) {
          sb.append(baseString);
        }
        baseString = sb.toString();
        index += 1;
      } else {
        baseString = baseString + s.charAt(index);
        index += 1;
      }
    }
    return baseString;
  }
}

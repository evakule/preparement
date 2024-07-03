package org.leetcode.medium;

public class ReverseInteger7 {
  public static void main(String[] args) {
    ReverseInteger7 r = new ReverseInteger7();
    System.out.println(r.reverse(-1312355));
    System.out.println(r.reverse(123));
  }

  public int reverse(int x) {
    char[] chars = Integer.toString(x).toCharArray();
    StringBuilder sb = new StringBuilder();

    for (int i = chars.length - 1; i >= 0; i--) {
      if (chars[i] != '-') {
        sb.append(chars[i]);
      }
    }
    int result = 0;
    try {
      result = Integer.parseInt(sb.toString());
      return chars[0] == '-' ? result * -1 : result;
    } catch (NumberFormatException e) {
      return result;
    }
  }
}

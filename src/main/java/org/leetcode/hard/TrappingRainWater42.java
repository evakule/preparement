package org.leetcode.hard;


import java.util.Arrays;
import java.util.stream.IntStream;

//https://leetcode.com/problems/trapping-rain-water/
public class TrappingRainWater42 {
  public static void main(String[] args) {
    TrappingRainWater42 t = new TrappingRainWater42();
    System.out.println(t.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    System.out.println(t.trap(new int[]{4, 2, 0, 3, 2, 5}));

  }

  //my solution
  public int trap(int[] height) {
    int[] maxLeft = defineLeftMaxValues(height);
    int[] maxRight = defineRightMaxValues(height);
    return IntStream
        .range(0, height.length)
        .map(i -> Math.max(0, Math.min(maxLeft[i], maxRight[i]) - height[i]))
        .sum();
  }

  private int[] defineLeftMaxValues(int[] height) {
    if (height.length < 1) return new int[0];
    int max = 0;
    int[] result = new int[height.length];

    for (int i = 0; i < height.length; i++) {
      result[i] = max;
      if (height[i] > max) {
        max = height[i];
      }
    }
    result[height.length - 1] = max;
    return result;
  }

  private int[] defineRightMaxValues(int[] height) {
    if (height.length < 1) return new int[0];
    int max = 0;
    int[] result = new int[height.length];

    for (int i = height.length - 1; i > 0; i--) {
      result[i] = max;
      if (height[i] > max) {
        max = height[i];
      }
    }
    result[0] = max;
    return result;
  }

  //not my solution
//  public int trap(int[] height) {
//    int l = 0;
//    int r = height.length - 1;
//    int maxL = Integer.MIN_VALUE;
//    int maxR = Integer.MIN_VALUE;
//    var res = 0;
//    while(l < r){
//      maxL = Math.max(maxL,height[l]);
//      maxR = Math.max(maxR,height[r]);
//      if(maxL > maxR){
//        res += maxR - height[r--];
//      } else {
//        res += maxL - height[l++];
//      }
//    }
//    return res;
//  }


}

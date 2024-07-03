package org.leetcode.easy;

public class BestTimeToBuyAndSellStock121 {
  public static void main(String[] args) {
    BestTimeToBuyAndSellStock121 b = new BestTimeToBuyAndSellStock121();
    int[] array = new int[]{7, 1, 5, 3, 6, 4};
    System.out.println(b.maxProfit(array));


  }

  public int maxProfit(int[] prices) {
    int maxProfit = 0;
    int left = 0;
    int right = 1;

    while (right < prices.length) {
      if (prices[left] < prices[right]) {
        maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
      } else {
        left = right;
      }
      right++;
    }

    return maxProfit;
  }

  //brute force solution
//  public int maxProfit(int[] prices) {
//    int maxProfit = 0;
//    for (int i = 0; i < prices.length; i++) {
//      for (int j = i + 1; j < prices.length; j++) {
//        if (prices[i] < prices[j]) {
//          maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
//        }
//      }
//    }
//    return maxProfit;
//  }
}

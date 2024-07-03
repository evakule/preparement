package org.leetcode.medium;

class MinStack {

  private int[] stack;
  private int currentIndex = -1;
  private int min;


  public MinStack() {
    stack = new int[32];

  }

  public void push(int val) {
    if (currentIndex == stack.length - 10) {
      int[] newStack = new int[stack.length * 2];
      System.arraycopy(this.stack, 0, newStack, 0, this.stack.length);
      this.stack = newStack;
    }
    currentIndex++;
    stack[currentIndex] = val;
    min = Math.min(val, min);
  }

  public void pop() {
    stack[currentIndex] = 0;
    currentIndex--;

  }

  public int top() {
    return this.stack[currentIndex];
  }

  public int getMin() {
    return this.min;
  }
}

class Runner {
  public static void main(String[] args) {
    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    int min = minStack.getMin(); // return -3
    minStack.pop();
    int top = minStack.top();    // return 0
    int newMin = minStack.getMin(); // return -2
  }
}


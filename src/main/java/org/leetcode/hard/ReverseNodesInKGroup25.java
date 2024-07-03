package org.leetcode.hard;

import java.util.*;

public class ReverseNodesInKGroup25 {
  public static void main(String[] args) {
    ListNode l1 = new ListNode(1);
    ListNode l2 = new ListNode(2);
    ListNode l3 = new ListNode(3);
    ListNode l4 = new ListNode(4);
    ListNode l5 = new ListNode(5);
    l1.next = l2;
    l2.next = l3;
    l3.next = l4;
    l4.next = l5;
    ReverseNodesInKGroup25 r = new ReverseNodesInKGroup25();
    r.reverseKGroup(l1, 2);
  }


  //My solution
  public ListNode reverseKGroup(ListNode head, int k) {
    int counter = k;

    Deque<ListNode> deque = new ArrayDeque<>();
    List<Deque<ListNode>> list = new ArrayList<>();

    for (ListNode current = head; current != null; current = current.next) {
      deque.add(current);
      counter--;
      if (counter == 0) {
        list.add(deque);
        deque = new LinkedList<>();
        counter = k;
      }
    }

    if (!deque.isEmpty()) list.add(deque);

    ListNode result = new ListNode(0);
    ListNode current = result;

    for (Deque<ListNode> d : list) {
      int dequeSize = d.size();
      while (!d.isEmpty()) {
        current.next = (dequeSize == k) ? d.pollLast() : d.pollFirst();
        current = current.next;
        current.next = null;
      }
    }
    return result.next;
  }
}

package org.leetcode.easy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeTwoSortedLists21 {
  public static void main(String[] args) {
    MergeTwoSortedLists21 m = new MergeTwoSortedLists21();

    ListNode l1 = new ListNode(1);
    ListNode l2 = new ListNode(1);
    ListNode l3 = new ListNode(2);
    ListNode l4 = new ListNode(3);
    ListNode l5 = new ListNode(4);
    ListNode l6 = new ListNode(4);

    l1.next = l3;
    l3.next = l5;

    l2.next = l4;
    l4.next = l6;

    ListNode res = m.mergeTwoLists(l1, l2);

    while (res != null) {
      System.out.println(res.val);
      res = res.next;
    }

  }

  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {


    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a));

    while (list1 != null) {
      pq.add(list1.val);
      list1 = list1.next;

    }

    while (list2 != null) {
      pq.add(list2.val);
      list2 = list2.next;
    }

    ListNode head = new ListNode();
    ListNode curr = head;


    while (!pq.isEmpty()) {
      ListNode next = new ListNode(pq.poll());
      curr.next = next;
      curr = next;

      if (pq.isEmpty()) {
        return head.next;
      }

    }
    return new ListNode().next;
  }


}
